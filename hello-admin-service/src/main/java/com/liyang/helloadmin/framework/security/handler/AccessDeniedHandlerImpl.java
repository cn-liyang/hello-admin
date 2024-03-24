package com.liyang.helloadmin.framework.security.handler;

import com.liyang.helloadmin.application.constant.Chars;
import com.liyang.helloadmin.framework.security.constant.SecurityCodes;
import com.liyang.helloadmin.framework.web.exception.ExceptionCode;
import com.liyang.helloadmin.framework.web.exception.ExceptionFormats;
import com.liyang.helloadmin.framework.web.exception.model.ClientErrorUnauthorizedException;
import com.liyang.helloadmin.framework.web.response.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.Elements;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    private static final String CODE =
        ExceptionCode.ALERT + Chars.CARET + SecurityCodes.AUTHORIZATION + Chars.CARET + Elements.ACCESS_DENIED_HANDLER;

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception) {
        val status = HttpStatus.UNAUTHORIZED.value();
        val message = String.format(ExceptionFormats.UNAUTHORIZED_DETAILS, exception.getMessage());
        val exception1 = new ClientErrorUnauthorizedException(CODE, message, exception);
        ResponseUtil.out(response, status, exception1);
    }
}
