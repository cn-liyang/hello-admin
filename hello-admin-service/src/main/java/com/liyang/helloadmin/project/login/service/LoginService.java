package com.liyang.helloadmin.project.login.service;

import com.liyang.helloadmin.framework.security.util.AuthenticationUtil;
import com.liyang.helloadmin.framework.token.util.JwtMacUtil;
import com.liyang.helloadmin.framework.web.response.util.ResponseUtil;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

/**
 * @author cn-liyang
 */
@Service
public class LoginService {

    public HttpHeaders getLoginHeaders(String username, String password) {
        AuthenticationUtil.authenticate(username, password);
        val jwt = JwtMacUtil.createJwt(username);
        return ResponseUtil.getAuthorizationHeaders(jwt);
    }
}
