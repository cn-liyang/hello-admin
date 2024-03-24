package com.liyang.helloadmin.project.system.controller.model;

import com.liyang.helloadmin.framework.orm.entity.BaseEntity;
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
public class RoleNotUser extends BaseEntity {

    private String username;
}
