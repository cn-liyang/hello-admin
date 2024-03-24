package com.liyang.helloadmin.project.entry.util;

import com.liyang.helloadmin.application.util.IdUtil;
import com.liyang.helloadmin.project.entry.exception.CaptchaBadException;
import com.liyang.helloadmin.project.entry.exception.CaptchaExpiredException;
import com.nimbusds.jose.util.Pair;
import com.wf.captcha.SpecCaptcha;
import java.io.Serializable;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author cn-liyang
 */
@Component
public final class CaptchaUtil {

    private static Boolean caseIgnored;

    private CaptchaUtil(@Value("${captcha.case-ignored:true}") Boolean caseIgnored) {
        CaptchaUtil.caseIgnored = caseIgnored;
    }

    public static Pair<String, String> genCaptchaPair() {
        val captcha = new SpecCaptcha(130, 48);
        val id = IdUtil.uuid();
        val code = captcha.text();
        CaptchaCacheUtil.put(id, code);
        val dataUrl = captcha.toBase64();
        return Pair.of(id, dataUrl);
    }

    public static void verify(Serializable key, String code) {
        val cachedCode = CaptchaCacheUtil.get(key);
        if (!StringUtils.hasText(cachedCode)) {
            throw new CaptchaExpiredException();
        }
        if (!(caseIgnored ? cachedCode.equalsIgnoreCase(code) : cachedCode.equals(code))) {
            CaptchaCacheUtil.remove(key);
            throw new CaptchaBadException();
        }
    }
}
