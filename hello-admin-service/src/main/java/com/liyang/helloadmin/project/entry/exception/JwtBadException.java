package com.liyang.helloadmin.project.entry.exception;

import com.liyang.helloadmin.application.constant.Chars;
import com.liyang.helloadmin.framework.web.exception.ExceptionCode;
import com.liyang.helloadmin.framework.web.exception.ExceptionFormats;
import com.liyang.helloadmin.framework.web.exception.model.ServerErrorInternalException;
import org.springframework.security.config.Elements;

/**
 * @author cn-liyang
 * 请求基本异常
 */
public class JwtBadException extends ServerErrorInternalException {

    private static final String CODE = ExceptionCode.ERROR + Chars.CARET + Elements.JWT;
    private static final String MESSAGE = String.format(ExceptionFormats.SOME_BAD, Elements.JWT);

    public JwtBadException(Throwable cause) {
        super(CODE, MESSAGE, cause);
    }
}
