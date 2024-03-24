package com.liyang.helloadmin.project.system.constant;

import com.liyang.helloadmin.application.constant.Chars;

/**
 * @author cn-liyang
 */
public interface SystemPaths {
    String PREV = "/system";
    String USERS = PREV + Chars.SLASH + SystemDomains.USER + Chars.LOWERCASE_S;
    String ROLES = PREV + Chars.SLASH + SystemDomains.ROLE + Chars.LOWERCASE_S;
    String PERMS = PREV + Chars.SLASH + SystemDomains.PERM + Chars.LOWERCASE_S;
    String USER_INFOS = PREV + Chars.SLASH + SystemDomains.USER_INFO + Chars.LOWERCASE_S;
    String USER_OTM_ROLES = PREV + Chars.SLASH + SystemDomains.USER_OTM_ROLE + Chars.LOWERCASE_S; // extend
    String USER_NOT_ROLES = PREV + Chars.SLASH + SystemDomains.USER_NOT_ROLE + Chars.LOWERCASE_S; // extend
    String ROLE_OTM_USERS = PREV + Chars.SLASH + SystemDomains.ROLE_OTM_USER + Chars.LOWERCASE_S; // extend
    String ROLE_NOT_USERS = PREV + Chars.SLASH + SystemDomains.ROLE_NOT_USER + Chars.LOWERCASE_S; // extend
    String ROLE_OTM_PERMS = PREV + Chars.SLASH + SystemDomains.ROLE_OTM_PERM + Chars.LOWERCASE_S; // extend
}
