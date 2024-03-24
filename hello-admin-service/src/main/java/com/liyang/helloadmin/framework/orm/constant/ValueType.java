package com.liyang.helloadmin.framework.orm.constant;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mybatisflex.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cn-liyang
 */
@AllArgsConstructor
@Getter
public enum ValueType {
    NUMB(0, "数字"),
    TEXT(1, "文本"),
    BOOL(2, "布尔"),
    TIME(3, "时间");

    @EnumValue
    @JsonValue
    private final Integer value;

    private final String label;
}
