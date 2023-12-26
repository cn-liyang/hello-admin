package com.liyang.helloadmin.framework.token.exception;

import com.liyang.helloadmin.framework.web.exception.ExceptionCode;
import com.liyang.helloadmin.framework.web.exception.model.ClientErrorBadRequestException;

/**
 * @author cn-liyang
 */
public class TokenJwtBadException extends ClientErrorBadRequestException {

    private static final String CODE = ExceptionCode.ERROR + ":TOKEN:JWT";
    private static final String MESSAGE = "Your JWT is bad! details: %s";

    public TokenJwtBadException(String msg, Throwable cause) {
        super(CODE, String.format(MESSAGE, msg), cause);
    }
}
