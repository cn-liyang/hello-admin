package com.liyang.helloadmin.project.login.controller;

import com.liyang.helloadmin.framework.security.constant.SecurityPaths;
import com.liyang.helloadmin.framework.web.controller.BaseController;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cn-liyang
 */
@RestController
@Validated
@AllArgsConstructor
public class CaptchaController extends BaseController {

    @GetMapping(SecurityPaths.CAPTCHA)
    public Object getCaptcha() {
        // TODO
        return ok(null);
    }
}
