package com.liyang.helloadmin.framework.crypto.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cn-liyang
 */
@AllArgsConstructor
@Getter
public enum KeySize {
    _256(256),
    _512(512),
    _1024(1024),
    _2048(2048);

    private final Integer value;
}
