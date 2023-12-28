package com.liyang.helloadmin.project.login.service;

import com.liyang.helloadmin.framework.security.util.AuthenticationUtil;
import com.liyang.helloadmin.framework.token.util.JwtMacUtil;
import com.liyang.helloadmin.framework.web.response.util.ResponseUtil;
import com.liyang.helloadmin.project.login.controller.model.LoginResponse;
import com.liyang.helloadmin.project.login.controller.model.UserInfo;
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

    public LoginResponse getLoginBody() {
        val userDetails = AuthenticationUtil.getUserDetails();
        val userEntity = userDetails.userEntity();
        val userInfoEntity = userEntity.getUserInfoEntity();
        val userId = userInfoEntity.getUserId();
        val nickname = userInfoEntity.getNickname();
        val avatar = userInfoEntity.getAvatar();
        val userInfo = new UserInfo(userId, nickname, avatar);
        return new LoginResponse(userInfo);
    }
}
