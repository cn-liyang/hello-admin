package com.liyang.helloadmin.framework.security.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public final class PasswordUtil {

    private static PasswordEncoder passwordEncoder;

    private PasswordUtil(PasswordEncoder passwordEncoder) {
        PasswordUtil.passwordEncoder = passwordEncoder;
    }

    public static String encode(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public static Boolean verify(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
