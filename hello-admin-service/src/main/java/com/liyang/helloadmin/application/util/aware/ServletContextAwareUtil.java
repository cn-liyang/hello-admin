package com.liyang.helloadmin.application.util.aware;

import jakarta.servlet.ServletContext;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

/**
 * @author cn-liyang
 */
@Component
public final class ServletContextAwareUtil implements ServletContextAware {

    private static ServletContext servletContext;

    public static String getContextPath() {
        return servletContext.getContextPath();
    }

    @Override
    public void setServletContext(@NonNull ServletContext servletContext) {
        ServletContextAwareUtil.servletContext = servletContext;
    }
}
