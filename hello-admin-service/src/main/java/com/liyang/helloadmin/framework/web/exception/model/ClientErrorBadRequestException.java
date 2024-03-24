package com.liyang.helloadmin.framework.web.exception.model;

/**
 * @author cn-liyang
 */
public class ClientErrorBadRequestException extends BaseException {

    public ClientErrorBadRequestException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
