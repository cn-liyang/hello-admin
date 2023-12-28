package com.liyang.helloadmin.project.login.caching;

import com.liyang.helloadmin.framework.cache.configuration.CaffeineConfiguration;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
@CacheConfig(cacheNames = CaffeineConfiguration.CAFFEINE_CACHE_1M)
public class CaptchaCaching {

    @SuppressWarnings("UnusedReturnValue")
    @CachePut(key = "#key")
    public String cachePut(String key, String value) {
        return value;
    }

    @CacheEvict(key = "#key")
    public void cacheEvict(String key) {}

    @Cacheable(key = "#key", unless = "#result == null")
    public String cacheable(String key) {
        return null;
    }
}
