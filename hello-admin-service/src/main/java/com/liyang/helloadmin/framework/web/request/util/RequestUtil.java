package com.liyang.helloadmin.framework.web.request.util;

import com.liyang.helloadmin.application.constant.Chars;
import com.liyang.helloadmin.framework.security.exception.JwtBearerBadException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.util.StringUtils;

/**
 * @author cn-liyang
 */
public final class RequestUtil {

    public static String getAuthorizationJwt(HttpServletRequest request) {
        val authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (
            !StringUtils.hasText(authorization) ||
            !authorization.startsWith(OAuth2AccessToken.TokenType.BEARER.getValue())
        ) {
            throw new JwtBearerBadException();
        }
        return authorization.replaceFirst(OAuth2AccessToken.TokenType.BEARER.getValue() + Chars.SPACE, "");
    }
}
