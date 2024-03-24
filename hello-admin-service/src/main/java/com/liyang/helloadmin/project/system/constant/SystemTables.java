package com.liyang.helloadmin.project.system.constant;

/**
 * @author cn-liyang
 */
public interface SystemTables {
    String PREV = "sys_";
    String USER = PREV + SystemDomains.USER;
    String USER_INFO = PREV + SystemDomains.USER_INFO;
    String USER_MTM_ROLE = PREV + SystemDomains.USER_MTM_ROLE;
    String ROLE = PREV + SystemDomains.ROLE;
    String ROLE_MTM_PERM = PREV + SystemDomains.ROLE_MTM_PERM;
    String PERM = PREV + SystemDomains.PERM;
}
