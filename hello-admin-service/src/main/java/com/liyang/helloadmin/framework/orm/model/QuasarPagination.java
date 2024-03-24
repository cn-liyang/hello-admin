package com.liyang.helloadmin.framework.orm.model;

import lombok.Data;

/**
 * @author cn-liyang
 */
@Data
public class QuasarPagination {

  private Long page;
  private Long rowsPerPage;
  private Long rowsNumber;
  private String sortBy;
  private Boolean descending;
}
