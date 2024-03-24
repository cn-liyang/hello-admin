package com.liyang.helloadmin.framework.web.response.util;

import com.liyang.helloadmin.application.constant.Chars;
import com.liyang.helloadmin.framework.json.util.JsonUtil;
import com.liyang.helloadmin.framework.web.response.model.SuccessfulResponse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import lombok.val;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.core.OAuth2AccessToken;

/**
 * @author cn-liyang
 */
public final class ResponseUtil {

    @SneakyThrows
    public static <T> void out(HttpServletResponse response, Integer status, T object) {
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(status);
        response.getWriter().print(JsonUtil.writeValueAsString(object));
    }

    public static void outOk(HttpServletResponse response) {
        out(response, HttpStatus.OK.value(), new SuccessfulResponse());
    }

    public static HttpHeaders getHttpHeaderAuthorization(String jwt) {
        val httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.AUTHORIZATION, OAuth2AccessToken.TokenType.BEARER.getValue() + Chars.SPACE + jwt);
        return httpHeaders;
    }
}
