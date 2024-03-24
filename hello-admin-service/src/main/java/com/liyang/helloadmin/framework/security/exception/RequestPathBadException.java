package com.liyang.helloadmin.framework.security.exception;

import com.liyang.helloadmin.framework.security.constant.SecurityCodes;
import com.liyang.helloadmin.framework.web.exception.ExceptionFormats;
import org.springframework.security.core.AuthenticationException;

/**
 * @author cn-liyang
 * 请求基本异常
 */
public class RequestPathBadException extends AuthenticationException {

    public RequestPathBadException() {
        super(String.format(ExceptionFormats.SOME_BAD, SecurityCodes.REQUEST_PATH));
    }
}
