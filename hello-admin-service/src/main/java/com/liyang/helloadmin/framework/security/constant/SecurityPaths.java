package com.liyang.helloadmin.framework.security.constant;

import com.liyang.helloadmin.framework.web.constant.PathPatterns;

/**
 * @author cn-liyang
 */
public interface SecurityPaths {
    String H2_CONSOLE = "/h2-console";
    String H2_CONSOLE_SUBS = H2_CONSOLE + PathPatterns.SUBS;
    String CAPTCHA = "/captcha";
    String LOGIN = "/login";
    String ERROR = "/error";
    String[] WHITELIST = { H2_CONSOLE_SUBS, CAPTCHA, LOGIN, ERROR };
}
