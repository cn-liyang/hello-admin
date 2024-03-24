package com.liyang.helloadmin.application.util;

import com.liyang.helloadmin.application.constant.Chars;
import com.liyang.helloadmin.application.constant.Https;
import lombok.val;
import org.springframework.boot.web.embedded.tomcat.TomcatWebServer;
import org.springframework.boot.web.server.WebServer;

/**
 * @author cn-liyang
 */
public final class TomcatUtil {

    public static String getHostPortUrl(WebServer webServer) {
        if (webServer instanceof TomcatWebServer tomcatWebServer) {
            val tomcat = tomcatWebServer.getTomcat();
            val host = tomcat.getHost();
            val hostName = host.getName();
            val port = tomcatWebServer.getPort();
            return Https.PREFIX_HTTP + hostName + Chars.COLON + port;
        }
        return "";
    }
}
