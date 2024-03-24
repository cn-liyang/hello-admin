package com.liyang.helloadmin.framework.crypto.constant;

import com.nimbusds.jose.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cn-liyang
 */
@AllArgsConstructor
@Getter
public enum BlockSize {
    _512(Pair.of(53, 64)),
    _1024(Pair.of(117, 128)),
    _2048(Pair.of(245, 256));

    private final Pair<Integer, Integer> value;
}
