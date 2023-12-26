package com.liyang.helloadmin.project.login.controller;

import com.liyang.helloadmin.framework.security.constant.SecurityPaths;
import com.liyang.helloadmin.framework.web.controller.BaseController;
import java.util.Map;
import lombok.AllArgsConstructor;
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

    @PostMapping(SecurityPaths.LOGIN)
    public Object login(@RequestBody Map<String, Object> request) {
        // TODO
        return ok(request);
    }
}
