package com.liyang.helloadmin.framework.orm.constant;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mybatisflex.core.constant.SqlConsts;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cn-liyang
 */
@AllArgsConstructor
@Getter
public enum QueryOperator {
    GT(SqlConsts.GT),
    GE(SqlConsts.GE),
    LT(SqlConsts.LT),
    LE(SqlConsts.LE),
    LIKE(SqlConsts.LIKE),
    NOT_LIKE(SqlConsts.NOT_LIKE),
    EQUALS(SqlConsts.EQUALS),
    NOT_EQUALS(SqlConsts.NOT_EQUALS),
    IS_NULL(SqlConsts.IS_NULL),
    IS_NOT_NULL(SqlConsts.IS_NOT_NULL),
    IN(SqlConsts.IN),
    NOT_IN(SqlConsts.NOT_IN),
    BETWEEN(SqlConsts.BETWEEN),
    NOT_BETWEEN(SqlConsts.NOT_BETWEEN);

    @JsonValue
    private final String value;
}
