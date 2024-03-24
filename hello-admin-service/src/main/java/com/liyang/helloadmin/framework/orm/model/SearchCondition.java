package com.liyang.helloadmin.framework.orm.model;

import com.liyang.helloadmin.framework.orm.constant.QueryOperator;
import com.liyang.helloadmin.framework.orm.constant.ValueType;
import lombok.Data;

/**
 * @author cn-liyang
 */
@Data
public class SearchCondition {

  private String field;
  private String value;
  private ValueType valueType;
  private QueryOperator operator;
}
