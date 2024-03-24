package com.liyang.helloadmin.framework.json.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public final class JsonUtil {

    private static ObjectMapper objectMapper;

    private JsonUtil(ObjectMapper objectMapper) {
        JsonUtil.objectMapper = objectMapper;
    }

    @SneakyThrows
    public static String writeValueAsString(Object value) {
        return objectMapper.writeValueAsString(value);
    }

    @SneakyThrows
    public static <T> T readValue(String content, Class<T> valueType) {
        return objectMapper.readValue(content, valueType);
    }

    @SneakyThrows
    public static <T> T readValue(String content, TypeReference<T> valueTypeRef) {
        return objectMapper.readValue(content, valueTypeRef);
    }
}
