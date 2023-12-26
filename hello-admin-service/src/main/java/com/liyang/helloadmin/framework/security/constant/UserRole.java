package com.liyang.helloadmin.framework.security.constant;

/**
 * @author cn-liyang
 */
public enum UserRole {
    ADMIN,
    GUEST;

    public static Boolean isAdmin(String username) {
        return ADMIN.name().equalsIgnoreCase(username);
    }

    public static Boolean isGuest(String username) {
        return GUEST.name().equalsIgnoreCase(username);
    }
}
