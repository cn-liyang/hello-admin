package com.liyang.helloadmin.framework.web.exception.model;

/**
 * @author cn-liyang
 */
public class ClientErrorUnauthorizedException extends BaseException {

    public ClientErrorUnauthorizedException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
