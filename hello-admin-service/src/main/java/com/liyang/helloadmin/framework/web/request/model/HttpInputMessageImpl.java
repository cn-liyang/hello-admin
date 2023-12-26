package com.liyang.helloadmin.framework.web.request.model;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.lang.NonNull;

/**
 * @author cn-liyang
 */
public record HttpInputMessageImpl(ByteArrayInputStream body, HttpHeaders headers) implements HttpInputMessage {
    @Override
    @NonNull
    public InputStream getBody() {
        return body;
    }

    @Override
    @NonNull
    public HttpHeaders getHeaders() {
        return headers;
    }
}
