package com.liyang.helloadmin.project.login.util;

import com.liyang.helloadmin.application.util.IdUtil;
import com.liyang.helloadmin.project.login.caching.CaptchaCaching;
import com.liyang.helloadmin.project.login.exception.CaptchaBadException;
import com.liyang.helloadmin.project.login.exception.CaptchaExpiredException;
import com.nimbusds.jose.util.Pair;
import com.wf.captcha.SpecCaptcha;
import lombok.val;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @author cn-liyang
 */
@Component
public final class CaptchaUtil {

    private static CaptchaCaching captchaCaching;
    private static Boolean caseIgnored;

    private CaptchaUtil(CaptchaCaching captchaCaching, @Value("${captcha.case-ignored:true}") Boolean caseIgnored) {
        CaptchaUtil.captchaCaching = captchaCaching;
        CaptchaUtil.caseIgnored = caseIgnored;
    }

    public static Pair<String, String> genCaptchaPair() {
        val captcha = new SpecCaptcha(130, 48);
        val id = IdUtil.uuid();
        val code = captcha.text();
        captchaCaching.cachePut(id, code);
        val dataUrl = captcha.toBase64();
        return Pair.of(id, dataUrl);
    }

    public static void verify(String key, String code) {
        val cachedCode = captchaCaching.cacheable(key);
        if (!StringUtils.hasText(cachedCode)) {
            throw new CaptchaExpiredException();
        }
        if (!(caseIgnored ? cachedCode.equalsIgnoreCase(code) : cachedCode.equals(code))) {
            captchaCaching.cacheEvict(key);
            throw new CaptchaBadException();
        }
    }
}
