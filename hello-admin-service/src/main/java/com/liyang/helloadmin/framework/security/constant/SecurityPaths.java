package com.liyang.helloadmin.framework.security.constant;

import com.liyang.helloadmin.framework.web.constant.PathPatterns;

/**
 * @author cn-liyang
 */
public interface SecurityPaths {
    String H2_CONSOLE = "/h2-console";
    String CAPTCHA = "/captcha";
    String LOGIN = "/login";
    String[] WHITELIST = { H2_CONSOLE + PathPatterns.SUBS, CAPTCHA, LOGIN };
}
