package com.liyang.helloadmin.project.system.controller.model;

import com.liyang.helloadmin.framework.orm.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author cn-liyang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class UserNotRole extends BaseEntity {

    private String name;
    private String label;
}
