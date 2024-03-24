package com.liyang.helloadmin.project.entry.exception;

import com.liyang.helloadmin.application.constant.Chars;
import com.liyang.helloadmin.framework.web.exception.ExceptionCode;
import com.liyang.helloadmin.framework.web.exception.ExceptionFormats;
import com.liyang.helloadmin.framework.web.exception.model.ClientErrorBadRequestException;
import com.liyang.helloadmin.project.entry.constant.LoginCodes;

/**
 * @author cn-liyang
 */
public class CaptchaBadException extends ClientErrorBadRequestException {

    private static final String CODE = ExceptionCode.ALERT + Chars.CARET + LoginCodes.CAPTCHA;
    private static final String MESSAGE = String.format(ExceptionFormats.SOME_BAD, LoginCodes.CAPTCHA);

    public CaptchaBadException() {
        super(CODE, MESSAGE, null);
    }
}
