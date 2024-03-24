package com.liyang.helloadmin.project.entry.controller.model;

import com.liyang.helloadmin.project.entry.constant.LoginRegexps;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author cn-liyang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class LoginRequest extends LoginCode {

    @NotBlank(message = "请输入帐号")
    @Pattern(regexp = LoginRegexps.USERNAME_PATTERN, message = LoginRegexps.USERNAME_MESSAGE)
    private String username;

    @NotBlank(message = "请输入密码")
    @Pattern(regexp = LoginRegexps.PASSWORD_PATTERN, message = LoginRegexps.PASSWORD_MESSAGE)
    private String password;
}
