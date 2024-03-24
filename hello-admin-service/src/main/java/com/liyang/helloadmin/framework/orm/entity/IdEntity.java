package com.liyang.helloadmin.framework.orm.entity;

import com.mybatisflex.annotation.Id;
import com.mybatisflex.annotation.KeyType;
import lombok.Data;
import lombok.experimental.FieldNameConstants;

/**
 * @author cn-liyang
 */
@Data
@FieldNameConstants
public class IdEntity {

  @Id(keyType = KeyType.Auto)
  private Long id;
}
