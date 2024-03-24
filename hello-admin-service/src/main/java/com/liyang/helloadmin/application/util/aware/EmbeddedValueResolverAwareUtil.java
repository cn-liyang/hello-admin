package com.liyang.helloadmin.application.util.aware;

import org.springframework.context.EmbeddedValueResolverAware;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * @author cn-liyang
 */
@Component
public final class EmbeddedValueResolverAwareUtil implements EmbeddedValueResolverAware {

    private static StringValueResolver resolver;

    @Override
    public void setEmbeddedValueResolver(@NonNull StringValueResolver resolver) {
        EmbeddedValueResolverAwareUtil.resolver = resolver;
    }
}
