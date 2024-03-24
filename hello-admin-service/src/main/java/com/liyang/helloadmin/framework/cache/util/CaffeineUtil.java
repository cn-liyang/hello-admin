package com.liyang.helloadmin.framework.cache.util;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.stats.CacheStats;
import com.liyang.helloadmin.application.util.aware.ApplicationContextAwareUtil;
import lombok.val;

/**
 * @author cn-liyang
 */
public final class CaffeineUtil {

    public static CacheStats getCacheStats(String cacheName) {
        val cache = ApplicationContextAwareUtil.getBean(cacheName, Cache.class);
        return cache.stats();
    }
}
