package com.liyang.helloadmin.framework.security.util;

import com.liyang.helloadmin.application.constant.Chars;
import com.liyang.helloadmin.application.util.IdUtil;
import com.liyang.helloadmin.framework.cache.service.Cache1HService;
import com.liyang.helloadmin.framework.security.constant.SecurityCodes;
import com.liyang.helloadmin.framework.security.service.model.UserDetailsImpl;
import java.io.Serializable;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public final class UserDetailsCacheUtil {

    private static final String PREFIX = SecurityCodes.USER_DETAILS + Chars.COLON + IdUtil.driftId() + Chars.COLON;
    private static Cache1HService cache1HService;

    private UserDetailsCacheUtil(Cache1HService cache1HService) {
        UserDetailsCacheUtil.cache1HService = cache1HService;
    }

    public static void put(Serializable key, UserDetailsImpl object) {
        cache1HService.cachePut(PREFIX + key, object);
    }

    public static void remove(Serializable key) {
        cache1HService.cacheEvict(PREFIX + key);
    }

    public static UserDetailsImpl get(Serializable key) {
        return (UserDetailsImpl) cache1HService.cacheable(PREFIX + key);
    }
}
