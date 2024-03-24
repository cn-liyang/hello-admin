package com.liyang.helloadmin.framework.cache.service;

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
public class Cache1MService {

    @SuppressWarnings("UnusedReturnValue")
    @CachePut(key = "#key")
    public Object cachePut(String key, Object object) {
        return object;
    }

    @CacheEvict(key = "#key")
    public void cacheEvict(String key) {}

    @Cacheable(key = "#key", unless = "#result == null")
    public Object cacheable(String key) {
        return null;
    }
}
