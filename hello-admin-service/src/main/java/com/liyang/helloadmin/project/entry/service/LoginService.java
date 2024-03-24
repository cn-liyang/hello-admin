package com.liyang.helloadmin.project.entry.service;

import com.liyang.helloadmin.framework.token.util.JwtMacUtil;
import com.liyang.helloadmin.framework.web.response.util.ResponseUtil;
import com.liyang.helloadmin.project.entry.exception.JwtBadException;
import com.liyang.helloadmin.project.system.context.UserEntityContext;
import com.nimbusds.jose.JOSEException;
import java.text.ParseException;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;

/**
 * @author cn-liyang
 */
@Service
public class LoginService {

    public HttpHeaders getLoginHeaders() {
        val userEntity = UserEntityContext.getUserEntity();
        val username = userEntity.getUsername();
        val roleNames = userEntity.getRoleNames();
        var jwt = "";
        try {
            jwt = JwtMacUtil.createJwt(username, roleNames);
        } catch (ParseException | JOSEException e) {
            throw new JwtBadException(e);
        }
        return ResponseUtil.getHttpHeaderAuthorization(jwt);
    }
}
