package com.liyang.helloadmin.framework.token.exception;

import com.liyang.helloadmin.framework.web.exception.ExceptionCode;
import com.liyang.helloadmin.framework.web.exception.model.ClientErrorBadRequestException;

/**
 * @author cn-liyang
 * 请求基本异常
 */
public class TokenBearerBadException extends ClientErrorBadRequestException {

    private static final String CODE = ExceptionCode.ERROR + ":TOKEN:BEARER";
    private static final String MESSAGE = "Your BEARER is bad!";

    public TokenBearerBadException() {
        super(CODE, MESSAGE, null);
    }
}
