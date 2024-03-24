package com.liyang.helloadmin.project.system.controller.model;

import com.liyang.helloadmin.project.system.entity.UserMtmRoleEntity;
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
public class RoleOtmUser extends UserMtmRoleEntity {

    private String username;
}
