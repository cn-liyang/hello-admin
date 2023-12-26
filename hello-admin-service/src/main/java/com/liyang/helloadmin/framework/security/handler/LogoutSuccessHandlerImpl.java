package com.liyang.helloadmin.framework.security.handler;

import com.liyang.helloadmin.framework.security.caching.UserDetailsCaching;
import com.liyang.helloadmin.framework.token.util.JwtMacUtil;
import com.liyang.helloadmin.framework.web.request.util.RequestUtil;
import com.liyang.helloadmin.framework.web.response.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
@AllArgsConstructor
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    private final UserDetailsCaching userDetailsCaching;

    @Override
    @SneakyThrows
    public void onLogoutSuccess(
        HttpServletRequest request,
        HttpServletResponse response,
        Authentication authentication
    ) {
        val token = RequestUtil.getAuthorizationToken(request);
        val username = JwtMacUtil.getVerifiedUsername(token);
        userDetailsCaching.cacheEvict(username);
        ResponseUtil.outOk(response);
    }
}
