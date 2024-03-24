package com.liyang.helloadmin.application.util.aware;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public final class ResourceLoaderAwareUtil implements ResourceLoaderAware {

    private static ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(@NonNull ResourceLoader resourceLoader) {
        ResourceLoaderAwareUtil.resourceLoader = resourceLoader;
    }
}
