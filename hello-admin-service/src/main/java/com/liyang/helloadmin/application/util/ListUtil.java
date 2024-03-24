package com.liyang.helloadmin.application.util;

import com.mybatisflex.core.util.StringUtil;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author cn-liyang
 */
public final class ListUtil {

    public static List<String> toList(String[] stringArray) {
        return Arrays
            .stream(stringArray)
            .map(StringUtil::trimOrNull)
            .filter(StringUtil::isNotBlank)
            .distinct()
            .collect(Collectors.toList());
    }
}
