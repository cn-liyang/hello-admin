package com.liyang.helloadmin.project.entry.controller;

import com.liyang.helloadmin.framework.web.controller.BaseController;
import com.liyang.helloadmin.framework.web.encryption.annotation.AesEncryption;
import com.liyang.helloadmin.framework.web.encryption.annotation.RsaEncryption;
import com.liyang.helloadmin.project.entry.constant.MainPaths;
import com.liyang.helloadmin.project.entry.service.MainService;
import lombok.AllArgsConstructor;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cn-liyang
 */
@RestController
@AllArgsConstructor
public class MainController extends BaseController {

    private final MainService service;

    @GetMapping(MainPaths.AES_PAIR)
    @RsaEncryption
    public Object getAesPair() {
        val body = service.getAesPairBody();
        return ok(body);
    }

    @GetMapping(MainPaths.USER_INFO)
    @AesEncryption
    public Object getUserInfo() {
        val body = service.getUserInfoBody();
        return ok(body);
    }
}
