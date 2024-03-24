package com.liyang.helloadmin.framework.orm.util;

import com.liyang.helloadmin.framework.orm.constant.ColumnChars;
import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.util.StringUtil;
import java.util.Objects;
import lombok.val;
import org.springframework.util.StringUtils;

/**
 * @author cn-liyang
 */
public final class QueryColumnUtil {

  public static String getCamelName(String name) {
    if (!StringUtils.hasText(name)) {
      return "";
    }
    val lowerCaseName = name.toLowerCase();
    val snakeCaseName = lowerCaseName.startsWith(ColumnChars.IS_)
      ? lowerCaseName.substring(ColumnChars.IS_.length())
      : lowerCaseName;
    return StringUtil.underlineToCamel(snakeCaseName);
  }

  public static String getCamelName(QueryColumn queryColumn) {
    if (Objects.isNull(queryColumn)) {
      return "";
    }
    return getCamelName(queryColumn.getName());
  }

  public static Boolean equals(QueryColumn queryColumn, String field) {
    if (Objects.isNull(queryColumn) || StringUtil.isBlank(field)) {
      return false;
    }
    return getCamelName(queryColumn).equals(field);
  }
}
