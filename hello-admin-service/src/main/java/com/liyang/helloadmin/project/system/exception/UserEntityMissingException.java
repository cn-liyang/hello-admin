package com.liyang.helloadmin.project.system.exception;

import com.liyang.helloadmin.application.constant.Chars;
import com.liyang.helloadmin.framework.web.exception.ExceptionCode;
import com.liyang.helloadmin.framework.web.exception.ExceptionFormats;
import com.liyang.helloadmin.framework.web.exception.model.ServerErrorInternalException;
import com.liyang.helloadmin.project.system.constant.SystemCodes;
import com.liyang.helloadmin.project.system.constant.SystemDomains;

/**
 * @author cn-liyang
 */
public class UserEntityMissingException extends ServerErrorInternalException {

    private static final String CODE = ExceptionCode.ERROR + Chars.CARET + SystemDomains.USER;
    private static final String MESSAGE = String.format(ExceptionFormats.SOME_MISSING, SystemCodes.USER_ENTITY);

    public UserEntityMissingException() {
        super(CODE, MESSAGE, null);
    }
}
