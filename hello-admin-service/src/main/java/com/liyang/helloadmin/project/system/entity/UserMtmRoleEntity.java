package com.liyang.helloadmin.project.system.entity;

import com.liyang.helloadmin.framework.orm.entity.BaseEntity;
import com.liyang.helloadmin.project.system.constant.SystemTables;
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
@Table(SystemTables.USER_MTM_ROLE)
public class UserMtmRoleEntity extends BaseEntity {

    private Long userId;
    private Long roleId;
}
