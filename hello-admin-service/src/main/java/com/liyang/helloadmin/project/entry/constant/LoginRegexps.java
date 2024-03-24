package com.liyang.helloadmin.project.entry.constant;

/**
 * @author cn-liyang
 */
public interface LoginRegexps {
    String USERNAME_PATTERN = "^[A-Za-z]\\w{4,19}$";
    String USERNAME_MESSAGE = "字母（大小写）、数字、下划线，要求字母（大小写）开头，长度 5-20 位";
    String PASSWORD_PATTERN = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)\\w{8,20}$";
    String PASSWORD_MESSAGE = "字母（大小写）、数字、下划线，要求每种字符至少有一个，长度 8-20 位";
}
