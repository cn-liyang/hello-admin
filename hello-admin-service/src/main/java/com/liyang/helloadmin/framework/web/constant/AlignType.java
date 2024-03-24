package com.liyang.helloadmin.framework.web.constant;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mybatisflex.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cn-liyang
 */
@AllArgsConstructor
@Getter
public enum AlignType {
    LEFT(0, "靠左"),
    CENTER(1, "居中"),
    RIGHT(2, "靠右");

    @EnumValue
    @JsonValue
    private final Integer value;

    private final String label;
}
