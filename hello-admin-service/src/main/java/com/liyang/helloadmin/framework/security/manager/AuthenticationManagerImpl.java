package com.liyang.helloadmin.framework.security.manager;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
@AllArgsConstructor
public class AuthenticationManagerImpl implements AuthenticationManager {

    private final AuthenticationConfiguration authenticationConfiguration;

    @Override
    @SneakyThrows
    public Authentication authenticate(Authentication authentication) {
        return authenticationConfiguration.getAuthenticationManager().authenticate(authentication);
    }
}
