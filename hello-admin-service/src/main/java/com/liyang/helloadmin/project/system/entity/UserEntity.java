package com.liyang.helloadmin.project.system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.liyang.helloadmin.framework.orm.entity.BaseEntity;
import com.liyang.helloadmin.framework.orm.entity.IdEntity;
import com.liyang.helloadmin.project.system.constant.SystemTables;
import com.mybatisflex.annotation.Column;
import com.mybatisflex.annotation.RelationOneToOne;
import com.mybatisflex.annotation.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.FieldNameConstants;

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

    @JsonIgnore
    private String password;

    @Column("is_locked")
    private Boolean locked;

    @Column("is_expired")
    private Boolean expired;

    @Column("is_enabled")
    private Boolean enabled;

    @RelationOneToOne(selfField = IdEntity.Fields.id, targetField = UserInfoEntity.Fields.userId)
    private UserInfoEntity userInfoEntity;
}
