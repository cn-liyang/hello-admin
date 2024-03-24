package com.liyang.helloadmin.framework.cache.configuration;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cn-liyang
 */
@Configuration
@EnableCaching
public class CaffeineConfiguration {

    public static final String CAFFEINE_CACHE_1M = "CAFFEINE_CACHE_1M";
    public static final String CAFFEINE_CACHE_1H = "CAFFEINE_CACHE_1H";

    @Bean
    public CacheManagerCustomizer<CaffeineCacheManager> caffeineCacheManagerCustomizer() {
        return cacheManager -> cacheManager.setAllowNullValues(false);
    }

    @Bean(CAFFEINE_CACHE_1M)
    public Cache<String, Object> caffeineCache1m() {
        return Caffeine
            .newBuilder()
            .initialCapacity(100)
            .maximumSize(1000)
            .expireAfterAccess(1, TimeUnit.MINUTES)
            .recordStats()
            .build();
    }

    @Bean(CAFFEINE_CACHE_1H)
    public Cache<String, Object> caffeineCache1h() {
        return Caffeine
            .newBuilder()
            .initialCapacity(100)
            .maximumSize(1000)
            .expireAfterAccess(1, TimeUnit.HOURS)
            .recordStats()
            .build();
    }
}
