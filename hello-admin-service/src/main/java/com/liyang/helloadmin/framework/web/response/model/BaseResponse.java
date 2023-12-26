package com.liyang.helloadmin.framework.web.response.model;

import lombok.Data;

/**
 * @author cn-liyang
 */
@Data
public class BaseResponse<T> {

    private final String code;
    private final String message;
    private final T data;
    private final Long timestamp = System.currentTimeMillis();
}
