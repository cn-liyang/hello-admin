package com.liyang.helloadmin.project.system.util;

import com.liyang.helloadmin.project.system.entity.PermEntity;
import com.liyang.helloadmin.project.system.entity.table.PermEntityTableDef;
import com.liyang.helloadmin.project.system.service.PermService;
import com.mybatisflex.core.query.QueryWrapper;
import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;
import lombok.val;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @author cn-liyang
 */
@Component
public final class PermEntityUtil {

    private static PermService permService;

    private PermEntityUtil(PermService permService) {
        PermEntityUtil.permService = permService;
    }

    public static Optional<PermEntity> getOptionalEntityWithRelations(Serializable id) {
        // TODO RelationManager.setMaxDepth(3);
        val entity = permService.getMapper().selectOneWithRelationsById(id);
        return Optional.ofNullable(entity);
    }

    public static Optional<List<PermEntity>> getOptionalEntitiesByParentId(Serializable parentId) {
        val queryWrapper = QueryWrapper
            .create()
            .where(PermEntityTableDef.PERM_ENTITY.PARENT_ID.eq(parentId))
            .orderBy(PermEntityTableDef.PERM_ENTITY.SORT_BY, true);
        val entities = permService.list(queryWrapper);
        if (CollectionUtils.isEmpty(entities)) {
            return Optional.empty();
        }
        return Optional.of(entities);
    }

    public static Optional<List<PermEntity>> getOptionalEntitiesWithRelationsByParentId(Serializable parentId) {
        // TODO RelationManager.setMaxDepth(3);
        val queryWrapper = QueryWrapper
            .create()
            .where(PermEntityTableDef.PERM_ENTITY.PARENT_ID.eq(parentId))
            .orderBy(PermEntityTableDef.PERM_ENTITY.SORT_BY, true);
        val entities = permService.getMapper().selectListWithRelationsByQuery(queryWrapper);
        if (CollectionUtils.isEmpty(entities)) {
            return Optional.empty();
        }
        return Optional.of(entities);
    }

    public static List<PermEntity> recurGetPermTreesFromLeafEntities(List<PermEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }
        val parentEntities = entities
            .stream()
            .map(PermEntity::getParentId)
            .distinct()
            .map(PermEntityUtil::getOptionalEntityWithRelations)
            .filter(Optional::isPresent)
            .map(Optional::get)
            .peek(i ->
                i.setChildren(
                    entities
                        .stream()
                        .filter(j -> Objects.equals(i.getId(), j.getParentId()))
                        .sorted(Comparator.comparing(PermEntity::getSortBy))
                        .collect(Collectors.toList())
                )
            )
            .toList();
        val rootEntities = new ArrayList<PermEntity>();
        val nestEntities = new ArrayList<PermEntity>();
        parentEntities.forEach(i -> {
            if (Objects.equals(i.getParentId(), 0L)) {
                rootEntities.add(i);
            } else {
                nestEntities.add(i);
            }
        });
        val lastEntities = recurGetPermTreesFromLeafEntities(nestEntities);
        rootEntities.addAll(lastEntities);
        return rootEntities;
    }

    public static List<PermEntity> recurGetPermTreesFromRootEntities(List<PermEntity> entities, Serializable parentId) {
        if (CollectionUtils.isEmpty(entities) || Objects.isNull(parentId)) {
            return Collections.emptyList();
        }
        val childEntities = new ArrayList<PermEntity>();
        val otherEntities = new ArrayList<PermEntity>();
        entities.forEach(i -> {
            if (Objects.equals(i.getParentId(), parentId)) {
                childEntities.add(i);
            } else {
                otherEntities.add(i);
            }
        });
        childEntities
            .stream()
            .sorted(Comparator.comparing(PermEntity::getSortBy))
            .forEach(i -> i.setChildren(recurGetPermTreesFromRootEntities(otherEntities, i.getId())));
        return childEntities;
    }

    public static Optional<List<Long>> recurGetOptionalIds(List<PermEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Optional.empty();
        }
        return Optional.of(
            entities
                .stream()
                .map(i -> {
                    val ids = new ArrayList<Long>();
                    ids.add(i.getId());
                    recurGetOptionalIds(i.getChildren()).ifPresent(ids::addAll);
                    return ids;
                })
                .flatMap(Collection::stream)
                .collect(Collectors.toList())
        );
    }

    public static Optional<List<Long>> getOptionalTreeIds(PermEntity entity) {
        if (Objects.isNull(entity)) {
            return Optional.empty();
        }
        val ids = new ArrayList<Long>();
        ids.add(entity.getId());
        recurGetOptionalIds(entity.getChildren()).ifPresent(ids::addAll);
        return Optional.of(ids);
    }

    public static Optional<List<Long>> getOptionalTreeIds(Serializable id) {
        if (Objects.isNull(id)) {
            return Optional.empty();
        }
        val optionalEntity = PermEntityUtil.getOptionalEntityWithRelations(id);
        if (optionalEntity.isEmpty()) {
            return Optional.empty();
        }
        val entity = optionalEntity.get();
        return PermEntityUtil.getOptionalTreeIds(entity);
    }
}
