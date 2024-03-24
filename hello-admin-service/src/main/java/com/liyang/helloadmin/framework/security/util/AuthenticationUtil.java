package com.liyang.helloadmin.framework.security.util;

import com.liyang.helloadmin.framework.security.exception.JwtBadException;
import com.liyang.helloadmin.framework.security.exception.UserDetailsExpiredException;
import com.liyang.helloadmin.framework.security.service.model.UserDetailsImpl;
import com.liyang.helloadmin.framework.token.util.JwtMacUtil;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jwt.proc.BadJWTException;
import java.text.ParseException;
import java.util.Objects;
import lombok.val;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public final class AuthenticationUtil {

    private static AuthenticationManager authenticationManager;

    private AuthenticationUtil(AuthenticationManager authenticationManager) {
        AuthenticationUtil.authenticationManager = authenticationManager;
    }

    public static void authenticate(String username, String password) {
        val authI = new UsernamePasswordAuthenticationToken(username, password);
        val authO = authenticationManager.authenticate(authI);
        SecurityContextHolder.getContext().setAuthentication(authO);
        val userDetails = (UserDetailsImpl) authO.getPrincipal();
        UserDetailsCacheUtil.put(username, userDetails);
    }

    public static void authenticate(String jwt) {
        var username = "";
        try {
            username = JwtMacUtil.getVerifiedUsername(jwt);
        } catch (ParseException | BadJWTException | JOSEException e) {
            throw new JwtBadException(e);
        }
        val userDetails = UserDetailsCacheUtil.get(username);
        if (Objects.isNull(userDetails)) {
            throw new UserDetailsExpiredException();
        }
        val authorities = userDetails.getAuthorities();
        val authO = UsernamePasswordAuthenticationToken.authenticated(userDetails, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authO);
        UserDetailsCacheUtil.put(username, userDetails);
    }
}
