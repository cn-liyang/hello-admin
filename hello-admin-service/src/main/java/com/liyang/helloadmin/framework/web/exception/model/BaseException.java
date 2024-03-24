package com.liyang.helloadmin.framework.web.exception.model;

import lombok.Getter;

/**
 * @author cn-liyang
 */
@Getter
public class BaseException extends RuntimeException {

    private final String code;
    private final String message;
    private final Throwable cause;

    public BaseException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
        this.cause = null;
    }

    public BaseException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
        this.cause = cause;
    }
}
