package com.liyang.helloadmin.framework.security.handler;

import com.liyang.helloadmin.application.constant.Chars;
import com.liyang.helloadmin.framework.security.constant.SecurityCodes;
import com.liyang.helloadmin.framework.web.exception.ExceptionCode;
import com.liyang.helloadmin.framework.web.exception.ExceptionFormats;
import com.liyang.helloadmin.framework.web.exception.model.ClientErrorForbiddenException;
import com.liyang.helloadmin.framework.web.response.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    private static final String CODE =
        ExceptionCode.ERROR + Chars.CARET + SecurityCodes.AUTHENTICATION + Chars.CARET + SecurityCodes.ENTRY_POINT;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) {
        SecurityContextHolder.clearContext();
        val status = HttpStatus.FORBIDDEN.value();
        val message = String.format(ExceptionFormats.FORBIDDEN_DETAILS, exception.getMessage());
        val exception1 = new ClientErrorForbiddenException(CODE, message, exception);
        ResponseUtil.out(response, status, exception1);
    }
}
