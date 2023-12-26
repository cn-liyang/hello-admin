package com.liyang.helloadmin.framework.security.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public final class PasswordUtil {

    private static PasswordEncoder passwordEncoder;
    private static String adminDecodedPassword;
    private static String guestDecodedPassword;

    private PasswordUtil(
        PasswordEncoder passwordEncoder,
        @Value("${password.admin:Admin123}") String adminDecodedPassword,
        @Value("${password.guest:Guest123}") String guestDecodedPassword
    ) {
        PasswordUtil.passwordEncoder = passwordEncoder;
        PasswordUtil.adminDecodedPassword = adminDecodedPassword;
        PasswordUtil.guestDecodedPassword = guestDecodedPassword;
    }

    public static String encode(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    public static Boolean verify(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    public static String getAdminEncodedPassword() {
        return encode(adminDecodedPassword);
    }

    public static String getGuestEncodedPassword() {
        return encode(guestDecodedPassword);
    }
}
