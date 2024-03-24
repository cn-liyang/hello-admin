package com.liyang.helloadmin.project.entry.util;

import com.liyang.helloadmin.project.entry.controller.model.MenuTree;
import com.liyang.helloadmin.project.system.entity.PermEntity;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.val;
import org.springframework.util.CollectionUtils;

/**
 * @author cn-liyang
 */
public final class MenuTreeUtil {

    public static MenuTree reduceEntity(PermEntity entity, List<MenuTree> children) {
        if (Objects.isNull(entity)) {
            return null;
        }
        val permType = entity.getPermType();
        val permSign = entity.getPermSign();
        val name = entity.getName();
        val icon = entity.getIcon();
        val label = entity.getLabel();
        val caption = entity.getCaption();
        return new MenuTree(permType, permSign, name, icon, label, caption, children);
    }

    public static List<MenuTree> recurReduceEntities(List<PermEntity> entities) {
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }
        return entities
            .stream()
            .map(i -> Optional.ofNullable(reduceEntity(i, recurReduceEntities(i.getChildren()))))
            .filter(Optional::isPresent)
            .map(Optional::get)
            .collect(Collectors.toList());
    }
}
