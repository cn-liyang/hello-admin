package com.liyang.helloadmin.framework.web.exception.model;

/**
 * @author cn-liyang
 */
public class ClientErrorForbiddenException extends BaseException {

    public ClientErrorForbiddenException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
