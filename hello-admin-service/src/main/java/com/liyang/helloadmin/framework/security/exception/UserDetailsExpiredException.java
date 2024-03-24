package com.liyang.helloadmin.framework.security.exception;

import com.liyang.helloadmin.framework.security.constant.SecurityCodes;
import com.liyang.helloadmin.framework.web.exception.ExceptionFormats;
import org.springframework.security.core.AuthenticationException;

/**
 * @author cn-liyang
 */
public class UserDetailsExpiredException extends AuthenticationException {

    public UserDetailsExpiredException() {
        super(String.format(ExceptionFormats.SOME_EXPIRED, SecurityCodes.USER_DETAILS));
    }
}
