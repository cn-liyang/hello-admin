package com.liyang.helloadmin.application.util;

import com.liyang.helloadmin.application.constant.Times;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.val;
import org.springframework.util.StringUtils;

/**
 * @author cn-liyang
 */
public final class TimeUtil {

    public static LocalDate parseLocalDate(String text) {
        return LocalDate.parse(text, Times.LOCAL_DATE_FORMATTER);
    }

    public static LocalDateTime parseLocalDateTime(String text) {
        return LocalDateTime.parse(text, Times.LOCAL_DATE_TIME_FORMATTER);
    }

    public static Object parseTimeObject(String text) {
        if (StringUtils.hasText(text)) {
            val textLength = text.length();
            if (textLength == Times.LOCAL_DATE_PATTERN.length()) {
                return parseLocalDate(text);
            }
            if (textLength == Times.LOCAL_DATE_TIME_PATTERN.length()) {
                return parseLocalDateTime(text);
            }
        }
        return text;
    }
}
