package com.liyang.helloadmin.application.util.aware;

import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public final class EnvironmentUtil implements EnvironmentAware {

    private static Environment environment;

    @Override
    public void setEnvironment(@NonNull Environment environment) {
        EnvironmentUtil.environment = environment;
    }
}
