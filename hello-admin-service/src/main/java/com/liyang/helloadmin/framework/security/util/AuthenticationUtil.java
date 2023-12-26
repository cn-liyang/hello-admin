package com.liyang.helloadmin.framework.security.util;

import com.liyang.helloadmin.framework.security.caching.UserDetailsCaching;
import com.liyang.helloadmin.framework.security.exception.UserDetailsExpiredException;
import com.liyang.helloadmin.framework.security.service.model.UserDetailsImpl;
import com.liyang.helloadmin.framework.token.util.JwtMacUtil;
import java.util.Objects;
import lombok.val;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public final class AuthenticationUtil {

    private static AuthenticationManager authenticationManager;
    private static UserDetailsCaching userDetailsCaching;

    private AuthenticationUtil(AuthenticationManager authenticationManager, UserDetailsCaching userDetailsCaching) {
        AuthenticationUtil.authenticationManager = authenticationManager;
        AuthenticationUtil.userDetailsCaching = userDetailsCaching;
    }

    public static void authenticate(String username, String password) {
        val authI = new UsernamePasswordAuthenticationToken(username, password);
        val authO = authenticationManager.authenticate(authI);
        SecurityContextHolder.getContext().setAuthentication(authO);
        val userDetails = getUserDetails(authO);
        userDetailsCaching.cachePut(userDetails);
    }

    public static void authenticate(String jwt) {
        val username = JwtMacUtil.getVerifiedUsername(jwt);
        val userDetails = userDetailsCaching.cacheable(username);
        if (Objects.isNull(userDetails)) {
            throw new UserDetailsExpiredException();
        }
        val authorities = userDetails.getAuthorities();
        val authO = UsernamePasswordAuthenticationToken.authenticated(userDetails, null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authO);
        userDetailsCaching.cachePut(userDetails);
    }

    public static UserDetailsImpl getUserDetails() {
        return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static UserDetailsImpl getUserDetails(Authentication authentication) {
        if (Objects.isNull(authentication)) {
            return null;
        }
        return (UserDetailsImpl) authentication.getPrincipal();
    }
}
