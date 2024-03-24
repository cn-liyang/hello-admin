package com.liyang.helloadmin.application.util.aware;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public final class ApplicationEventPublisherAwareUtil implements ApplicationEventPublisherAware {

    private static ApplicationEventPublisher applicationEventPublisher;

    @Override
    public void setApplicationEventPublisher(@NonNull ApplicationEventPublisher applicationEventPublisher) {
        ApplicationEventPublisherAwareUtil.applicationEventPublisher = applicationEventPublisher;
    }
}
