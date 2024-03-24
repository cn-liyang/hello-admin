package com.liyang.helloadmin.framework.security.util;

import com.liyang.helloadmin.application.constant.Chars;
import com.liyang.helloadmin.framework.security.exception.RequestMethodBadException;
import com.liyang.helloadmin.framework.security.exception.RequestPathBadException;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Objects;
import lombok.val;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.util.StringUtils;

/**
 * @author cn-liyang
 */
public final class AuthorizationUtil {

    public static String getAuthority(String method, String path) {
        if (!StringUtils.hasText(method)) {
            throw new RequestMethodBadException();
        }
        if (!StringUtils.hasText(path)) {
            throw new RequestPathBadException();
        }
        return method.toLowerCase() + Chars.POUND + path;
    }

    public static Boolean authorize(HttpServletRequest request) {
        val requestMethod = request.getMethod();
        val requestPath = request.getServletPath();
        val userDetails = UserDetailsUtil.getUserDetails();
        if (userDetails.isAdmin()) {
            return true;
        }
        if (userDetails.isGuest()) {
            return HttpMethod.GET.matches(requestMethod) || HttpMethod.POST.matches(requestMethod);
        }
        return AuthorityUtils
            .authorityListToSet(userDetails.getAuthorities())
            .stream()
            .anyMatch(i -> Objects.equals(i, getAuthority(requestMethod, requestPath)));
    }
}
