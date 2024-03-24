package com.liyang.helloadmin.project.system.util;

import com.liyang.helloadmin.framework.security.constant.SecurityRole;
import com.liyang.helloadmin.framework.security.util.UserDetailsUtil;
import com.liyang.helloadmin.project.system.constant.PermType;
import com.liyang.helloadmin.project.system.entity.PermEntity;
import com.liyang.helloadmin.project.system.entity.UserEntity;
import com.liyang.helloadmin.project.system.entity.table.UserEntityTableDef;
import com.liyang.helloadmin.project.system.service.UserService;
import com.mybatisflex.core.query.QueryCondition;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.val;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

/**
 * @author cn-liyang
 */
@Component
public final class UserEntityUtil {

    private static UserService userService;

    private UserEntityUtil(UserService userService) {
        UserEntityUtil.userService = userService;
    }

    public static Optional<UserEntity> getOptionalEntityWithRelations() {
        val username = UserDetailsUtil.getUsername();
        return getOptionalEntityWithRelations(username);
    }

    public static Optional<UserEntity> getOptionalEntityWithRelations(String username) {
        // TODO RelationManager.setMaxDepth(3);
        val condition = QueryCondition.createEmpty().and(UserEntityTableDef.USER_ENTITY.USERNAME.eq(username));
        val entity = userService.getMapper().selectOneWithRelationsByCondition(condition);
        return Optional.ofNullable(entity);
    }

    public static List<PermEntity> getPermTrees() {
        val userEntity = UserDetailsUtil.getUserEntity();
        if (Objects.isNull(userEntity)) {
            return Collections.emptyList();
        }
        if (userEntity.isAdmin() || userEntity.isGuest()) {
            val optionalEntities = PermEntityUtil.getOptionalEntitiesWithRelationsByParentId(0L);
            return optionalEntities.orElse(Collections.emptyList());
        } else {
            val entities = userEntity.getPermEntities();
            if (CollectionUtils.isEmpty(entities)) {
                return Collections.emptyList();
            }
            return PermEntityUtil.recurGetPermTreesFromLeafEntities(entities);
        }
    }

    public static List<? extends GrantedAuthority> getAuthorities(UserEntity entity) {
        if (Objects.isNull(entity)) {
            return AuthorityUtils.NO_AUTHORITIES;
        }
        if (entity.isAdmin() || entity.isGuest()) {
            val role = entity.isAdmin() ? SecurityRole.ADMIN.name() : SecurityRole.GUEST.name();
            return AuthorityUtils.createAuthorityList(role);
        } else {
            val entities = entity.getPermEntities();
            if (CollectionUtils.isEmpty(entities)) {
                return AuthorityUtils.NO_AUTHORITIES;
            }
            val authoritySet = entities
                .stream()
                .filter(i -> Objects.equals(i.getPermType(), PermType.RAPI))
                .map(PermEntity::getPermSign)
                .collect(Collectors.toSet());
            return AuthorityUtils.createAuthorityList(authoritySet);
        }
    }
}
