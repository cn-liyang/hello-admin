package com.liyang.helloadmin.application.constant;

import java.time.format.DateTimeFormatter;

/**
 * @author cn-liyang
 */
public interface Times {
    String LOCAL_DATE_PATTERN = "yyyy-MM-dd";
    String LOCAL_DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    DateTimeFormatter LOCAL_DATE_FORMATTER = DateTimeFormatter.ofPattern(LOCAL_DATE_PATTERN);
    DateTimeFormatter LOCAL_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(LOCAL_DATE_TIME_PATTERN);
}
