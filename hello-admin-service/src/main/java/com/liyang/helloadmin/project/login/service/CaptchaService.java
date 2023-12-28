package com.liyang.helloadmin.project.login.service;

import com.liyang.helloadmin.project.login.controller.model.CaptchaResponse;
import com.liyang.helloadmin.project.login.util.CaptchaUtil;
import lombok.val;
import org.springframework.stereotype.Service;

/**
 * @author cn-liyang
 */
@Service
public class CaptchaService {

    public CaptchaResponse getCaptchaBody() {
        val captchaPair = CaptchaUtil.genCaptchaPair();
        val id = captchaPair.getLeft();
        val dataUrl = captchaPair.getRight();
        return new CaptchaResponse(id, dataUrl);
    }
}
