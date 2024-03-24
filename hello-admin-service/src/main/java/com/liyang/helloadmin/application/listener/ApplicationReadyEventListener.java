package com.liyang.helloadmin.application.listener;

import com.liyang.helloadmin.application.util.TomcatUtil;
import com.liyang.helloadmin.framework.security.constant.SecurityPaths;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
@Slf4j
public class ApplicationReadyEventListener implements ApplicationListener<ApplicationReadyEvent> {

    @SneakyThrows
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        var contextUrl = "";
        val context = event.getApplicationContext();
        if (context instanceof AnnotationConfigServletWebServerApplicationContext webServerContext) {
            val servletContext = webServerContext.getServletContext();
            assert servletContext != null;
            val contextPath = servletContext.getContextPath();
            val webServer = webServerContext.getWebServer();
            contextUrl = TomcatUtil.getHostPortUrl(webServer) + contextPath;
        }
        log.info(contextUrl + SecurityPaths.H2_CONSOLE);
    }
}
