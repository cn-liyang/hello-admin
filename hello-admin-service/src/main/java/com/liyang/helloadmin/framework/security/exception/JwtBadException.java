package com.liyang.helloadmin.framework.security.exception;

import com.liyang.helloadmin.framework.web.exception.ExceptionFormats;
import org.springframework.security.config.Elements;
import org.springframework.security.core.AuthenticationException;

/**
 * @author cn-liyang
 * 请求基本异常
 */
public class JwtBadException extends AuthenticationException {

    public JwtBadException(Throwable cause) {
        super(String.format(ExceptionFormats.SOME_BAD, Elements.JWT), cause);
    }
}
