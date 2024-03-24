package com.liyang.helloadmin.project.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.liyang.helloadmin.application.constant.Chars;
import com.liyang.helloadmin.framework.orm.entity.BaseEntity;
import com.liyang.helloadmin.framework.orm.entity.IdEntity;
import com.liyang.helloadmin.framework.security.constant.SecurityRole;
import com.liyang.helloadmin.project.system.constant.SystemDomains;
import com.liyang.helloadmin.project.system.constant.SystemTables;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.RelationManyToMany;
import com.mybatisflex.annotation.RelationOneToOne;
import com.mybatisflex.annotation.Table;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;
import org.springframework.util.CollectionUtils;

/**
 * @author cn-liyang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@FieldNameConstants
@Table(SystemTables.USER)
public class UserEntity extends BaseEntity {

    private String username;

    private String password;

    @Column("is_expired_account")
    private Boolean expiredAccount;

    @Column("is_expired_password")
    private Boolean expiredPassword;

    @Column("is_locked")
    private Boolean locked;

    @Column("is_enabled")
    private Boolean enabled;

    @JsonIgnore
    @RelationOneToOne(selfField = IdEntity.Fields.id, targetField = UserInfoEntity.Fields.userId)
    private UserInfoEntity userInfoEntity;

    @JsonIgnore
    @RelationManyToMany(
        joinTable = SystemTables.USER_MTM_ROLE,
        joinSelfColumn = SystemDomains.USER + Chars.UNDERSCORE + IdEntity.Fields.id,
        joinTargetColumn = SystemDomains.ROLE + Chars.UNDERSCORE + IdEntity.Fields.id
    )
    private List<RoleEntity> roleEntities;

    @JsonIgnore
    public List<PermEntity> getPermEntities() {
        if (CollectionUtils.isEmpty(roleEntities)) {
            return Collections.emptyList();
        }
        return roleEntities
            .stream()
            .map(RoleEntity::getPermEntities)
            .flatMap(Collection::stream)
            .distinct()
            .collect(Collectors.toList());
    }

    @JsonIgnore
    public List<String> getRoleNames() {
        if (CollectionUtils.isEmpty(roleEntities)) {
            return Collections.emptyList();
        }
        return roleEntities.stream().map(RoleEntity::getName).distinct().collect(Collectors.toList());
    }

    @JsonIgnore
    public Boolean isAdmin() {
        return getRoleNames().stream().anyMatch(SecurityRole::isAdmin);
    }

    @JsonIgnore
    public Boolean isGuest() {
        return getRoleNames().stream().allMatch(SecurityRole::isGuest);
    }
}
