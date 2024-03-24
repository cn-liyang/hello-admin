package com.liyang.helloadmin.framework.security.constant;

/**
 * @author cn-liyang
 */
public enum SecurityRole {
    ADMIN,
    GUEST;

    public static Boolean isAdmin(String name) {
        return ADMIN.name().equalsIgnoreCase(name);
    }

    public static Boolean isGuest(String name) {
        return GUEST.name().equalsIgnoreCase(name);
    }
}
