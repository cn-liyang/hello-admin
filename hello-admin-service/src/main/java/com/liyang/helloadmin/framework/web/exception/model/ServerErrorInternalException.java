package com.liyang.helloadmin.framework.web.exception.model;

/**
 * @author cn-liyang
 */
public class ServerErrorInternalException extends BaseException {

    public ServerErrorInternalException(String code, String message) {
        super(code, message);
    }

    public ServerErrorInternalException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
