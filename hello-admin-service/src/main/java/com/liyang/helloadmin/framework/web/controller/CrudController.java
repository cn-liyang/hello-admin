package com.liyang.helloadmin.framework.web.controller;

import com.liyang.helloadmin.framework.web.response.model.SuccessfulResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @author cn-liyang
 */
public class CrudController extends BaseController {

    protected Object created(Object data) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessfulResponse(data));
    }

    protected Object created(HttpHeaders headers, Object data) {
        return ResponseEntity.status(HttpStatus.CREATED).headers(headers).body(new SuccessfulResponse(data));
    }

    protected Object noContent(Object data) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new SuccessfulResponse(data));
    }

    protected Object noContent(HttpHeaders headers, Object data) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).headers(headers).body(new SuccessfulResponse(data));
    }

    protected Object resetContent(Object data) {
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).body(new SuccessfulResponse(data));
    }

    protected Object resetContent(HttpHeaders headers, Object data) {
        return ResponseEntity.status(HttpStatus.RESET_CONTENT).headers(headers).body(new SuccessfulResponse(data));
    }
}
