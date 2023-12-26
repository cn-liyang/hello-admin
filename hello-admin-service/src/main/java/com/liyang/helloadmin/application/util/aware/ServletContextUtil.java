package com.liyang.helloadmin.application.util.aware;

import jakarta.servlet.ServletContext;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

/**
 * @author cn-liyang
 */
@Component
public final class ServletContextUtil implements ServletContextAware {

    private static ServletContext servletContext;

    @Override
    public void setServletContext(@NonNull ServletContext servletContext) {
        ServletContextUtil.servletContext = servletContext;
    }
}
