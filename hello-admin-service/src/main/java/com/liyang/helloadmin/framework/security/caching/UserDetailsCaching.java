package com.liyang.helloadmin.framework.security.caching;

import com.liyang.helloadmin.framework.cache.configuration.CaffeineConfiguration;
import com.liyang.helloadmin.framework.security.service.model.UserDetailsImpl;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
@CacheConfig(cacheNames = CaffeineConfiguration.CAFFEINE_CACHE_1H)
public class UserDetailsCaching {

    @SuppressWarnings("UnusedReturnValue")
    @CachePut(key = "#userDetails.username")
    public UserDetailsImpl cachePut(UserDetailsImpl userDetails) {
        return userDetails;
    }

    @CacheEvict(key = "#key")
    public void cacheEvict(String key) {}

    @Cacheable(key = "#key", unless = "#result == null")
    public UserDetailsImpl cacheable(String key) {
        return null;
    }
}
