package com.liyang.helloadmin.project.entry.controller;

import com.liyang.helloadmin.framework.security.constant.SecurityPaths;
import com.liyang.helloadmin.framework.security.constant.SecurityUsers;
import com.liyang.helloadmin.framework.security.util.AuthenticationUtil;
import com.liyang.helloadmin.framework.web.controller.BaseController;
import com.liyang.helloadmin.project.entry.controller.model.LoginRequest;
import com.liyang.helloadmin.project.entry.service.LoginService;
import com.liyang.helloadmin.project.entry.util.CaptchaUtil;
import com.liyang.helloadmin.project.system.context.UserEntityContext;
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
        val username = request.getUsername();
        val password = request.getPassword();
        if (!SecurityUsers.ADMIN.equals(username)) {
            val code = request.getCode();
            val id = request.getId();
            CaptchaUtil.verify(id, code);
        }
        try (val ignored = new UserEntityContext()) {
            AuthenticationUtil.authenticate(username, password);
            val headers = service.getLoginHeaders();
            return ok(headers);
        }
    }
}
