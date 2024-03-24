package com.liyang.helloadmin.framework.orm.entity;

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
public class OptionEntity extends BaseEntity {

  private String name;
  private String icon;
  private String label;
  private String caption;
}
