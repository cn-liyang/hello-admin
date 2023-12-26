package com.liyang.helloadmin.application.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

/**
 * @author cn-liyang
 */
public final class JsonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @SneakyThrows
    public static String writeValueAsString(Object value) {
        return OBJECT_MAPPER.writeValueAsString(value);
    }

    @SneakyThrows
    public static <T> T readValue(String content, Class<T> valueType) {
        return OBJECT_MAPPER.readValue(content, valueType);
    }

    @SneakyThrows
    public static <T> T readValue(String content, TypeReference<T> valueTypeRef) {
        return OBJECT_MAPPER.readValue(content, valueTypeRef);
    }
}
