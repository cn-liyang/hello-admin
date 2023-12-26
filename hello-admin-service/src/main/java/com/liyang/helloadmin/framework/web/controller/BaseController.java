package com.liyang.helloadmin.framework.web.controller;

import com.liyang.helloadmin.framework.web.response.model.SuccessfulResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

/**
 * @author cn-liyang
 */
public class BaseController {

    protected Object ok() {
        return ResponseEntity.ok(new SuccessfulResponse());
    }

    protected Object ok(Object data) {
        return ResponseEntity.ok(new SuccessfulResponse(data));
    }

    protected Object ok(HttpHeaders headers) {
        return ResponseEntity.ok().headers(headers).body(new SuccessfulResponse());
    }

    protected Object ok(HttpHeaders headers, Object data) {
        return ResponseEntity.ok().headers(headers).body(new SuccessfulResponse(data));
    }
}
