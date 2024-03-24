package com.liyang.helloadmin.framework.orm.util;

import com.mybatisflex.core.paginate.Page;
import java.util.List;
import lombok.val;

/**
 * @author cn-liyang
 */
public final class PageUtil {

  public static <S, T> Page<T> reducePage(Page<S> source, List<T> targetRecords) {
    val pageNumber = source.getPageNumber();
    val pageSize = source.getPageSize();
    val totalRow = source.getTotalRow();
    return (new Page<>(targetRecords, pageNumber, pageSize, totalRow));
  }
}
