package com.liyang.helloadmin.project.entry.util;

import com.liyang.helloadmin.application.constant.Chars;
import com.liyang.helloadmin.application.util.IdUtil;
import com.liyang.helloadmin.framework.cache.service.Cache1MService;
import com.liyang.helloadmin.project.entry.constant.LoginCodes;
import java.io.Serializable;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public class CaptchaCacheUtil {

    private static final String PREFIX = LoginCodes.CAPTCHA + Chars.COLON + IdUtil.driftId() + Chars.COLON;
    private static Cache1MService cache1MService;

    private CaptchaCacheUtil(Cache1MService cache1MService) {
        CaptchaCacheUtil.cache1MService = cache1MService;
    }

    public static void put(Serializable key, String value) {
        cache1MService.cachePut(PREFIX + key, value);
    }

    public static void remove(Serializable key) {
        cache1MService.cacheEvict(PREFIX + key);
    }

    public static String get(Serializable key) {
        return (String) cache1MService.cacheable(PREFIX + key);
    }
}
