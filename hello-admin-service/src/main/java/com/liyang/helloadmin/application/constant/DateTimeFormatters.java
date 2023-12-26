package com.liyang.helloadmin.application.constant;

import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

/**
 * @author cn-liyang
 */
public interface DateTimeFormatters {
    DateTimeFormatter LOCAL_DATE_TIME = new DateTimeFormatterBuilder()
        .parseCaseInsensitive()
        .append(DateTimeFormatter.ISO_LOCAL_DATE)
        .appendLiteral(OneChars.SPACE)
        .append(DateTimeFormatter.ISO_LOCAL_TIME)
        .toFormatter();
}
