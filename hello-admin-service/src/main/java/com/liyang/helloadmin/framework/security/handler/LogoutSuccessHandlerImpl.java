package com.liyang.helloadmin.framework.security.handler;

import com.liyang.helloadmin.framework.security.util.UserDetailsCacheUtil;
import com.liyang.helloadmin.framework.token.util.JwtMacUtil;
import com.liyang.helloadmin.framework.web.request.util.RequestUtil;
import com.liyang.helloadmin.framework.web.response.util.ResponseUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public class LogoutSuccessHandlerImpl implements LogoutSuccessHandler {

    @Override
    @SneakyThrows
    public void onLogoutSuccess(
        HttpServletRequest request,
        HttpServletResponse response,
        Authentication authentication
    ) {
        val jwt = RequestUtil.getAuthorizationJwt(request);
        val username = JwtMacUtil.getVerifiedUsername(jwt);
        UserDetailsCacheUtil.remove(username);
        ResponseUtil.outOk(response);
    }
}
