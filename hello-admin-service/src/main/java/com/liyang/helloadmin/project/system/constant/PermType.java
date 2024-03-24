package com.liyang.helloadmin.project.system.constant;

import com.fasterxml.jackson.annotation.JsonValue;
import com.mybatisflex.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cn-liyang
 */
@AllArgsConstructor
@Getter
public enum PermType {
    CATA(0, "目录"),
    VIEW(1, "视图"),
    RAPI(2, "接口");

    @EnumValue
    @JsonValue
    private final Integer value;

    private final String label;
}
