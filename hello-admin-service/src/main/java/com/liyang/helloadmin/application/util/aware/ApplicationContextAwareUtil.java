package com.liyang.helloadmin.application.util.aware;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public final class ApplicationContextAwareUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static String[] getActiveProfiles() {
        return applicationContext.getEnvironment().getActiveProfiles();
    }

    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    public static <T> T getBean(String name, Class<T> requiredType) {
        return applicationContext.getBean(name, requiredType);
    }

    @Override
    public void setApplicationContext(@NonNull ApplicationContext applicationContext) {
        ApplicationContextAwareUtil.applicationContext = applicationContext;
    }
}
