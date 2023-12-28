package com.liyang.helloadmin.project.system.constant;

import com.liyang.helloadmin.application.constant.OneChars;

/**
 * @author cn-liyang
 */
public interface SystemPaths {
    String SYSTEM = "/system";
    String USERS = SYSTEM + OneChars.SLASH + SystemDomains.USER + OneChars.LOWERCASE_S;
    String USER_INFOS = SYSTEM + OneChars.SLASH + SystemDomains.USER_INFO + OneChars.LOWERCASE_S;
}
