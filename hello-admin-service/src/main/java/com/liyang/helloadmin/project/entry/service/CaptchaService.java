package com.liyang.helloadmin.project.entry.service;

import com.liyang.helloadmin.project.entry.controller.model.CaptchaResponse;
import com.liyang.helloadmin.project.entry.util.CaptchaUtil;
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
