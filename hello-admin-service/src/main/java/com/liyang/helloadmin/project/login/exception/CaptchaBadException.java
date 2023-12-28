package com.liyang.helloadmin.project.login.exception;

import com.liyang.helloadmin.framework.web.exception.ExceptionCode;
import com.liyang.helloadmin.framework.web.exception.model.ClientErrorBadRequestException;

/**
 * @author cn-liyang
 */
public class CaptchaBadException extends ClientErrorBadRequestException {

    private static final String CODE = ExceptionCode.ALERT + ":CAPTCHA";
    private static final String MESSAGE = "Your captcha is bad!";

    public CaptchaBadException() {
        super(CODE, MESSAGE, null);
    }
}
