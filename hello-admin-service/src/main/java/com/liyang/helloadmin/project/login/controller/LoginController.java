package com.liyang.helloadmin.project.login.controller;

import com.liyang.helloadmin.framework.security.constant.SecurityPaths;
import com.liyang.helloadmin.framework.web.controller.BaseController;
import com.liyang.helloadmin.project.login.controller.model.LoginRequest;
import com.liyang.helloadmin.project.login.service.LoginService;
import com.liyang.helloadmin.project.login.util.CaptchaUtil;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cn-liyang
 */
@RestController
@Validated
@AllArgsConstructor
public class LoginController extends BaseController {

    private final LoginService service;

    @PostMapping(SecurityPaths.LOGIN)
    public Object login(@RequestBody LoginRequest request) {
        val code = request.getCode();
        val id = request.getId();
        CaptchaUtil.verify(id, code);
        val username = request.getUsername();
        val password = request.getPassword();
        val headers = service.getLoginHeaders(username, password);
        // TODO
        return ok(headers);
    }
}
