package com.liyang.helloadmin.framework.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author cn-liyang
 */
public class UserDetailsExpiredException extends AuthenticationException {

    public UserDetailsExpiredException() {
        super("The user-details is expired!");
    }
}
