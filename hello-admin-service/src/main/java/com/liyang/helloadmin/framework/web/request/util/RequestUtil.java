package com.liyang.helloadmin.framework.web.request.util;

import com.liyang.helloadmin.application.constant.OneChars;
import com.liyang.helloadmin.framework.security.service.model.GrantedAuthorityImpl;
import com.liyang.helloadmin.framework.token.exception.TokenBearerBadException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.util.StringUtils;

/**
 * @author cn-liyang
 */
public final class RequestUtil {

    public static String getAuthorizationToken(HttpServletRequest request) {
        val authorization = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (
            StringUtils.hasText(authorization) &&
            authorization.startsWith(OAuth2AccessToken.TokenType.BEARER.getValue())
        ) {
            return authorization.replaceFirst(OAuth2AccessToken.TokenType.BEARER.getValue() + OneChars.SPACE, "");
        } else {
            throw new TokenBearerBadException();
        }
    }

    public static GrantedAuthorityImpl getGrantedAuthority(HttpServletRequest request) {
        return new GrantedAuthorityImpl(request.getMethod(), request.getServletPath());
    }
}
