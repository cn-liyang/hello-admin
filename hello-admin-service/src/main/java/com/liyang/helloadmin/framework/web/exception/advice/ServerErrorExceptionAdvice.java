package com.liyang.helloadmin.framework.web.exception.advice;

import com.liyang.helloadmin.framework.web.exception.model.ServerErrorInternalException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author cn-liyang
 */
@RestControllerAdvice
@Slf4j
public class ServerErrorExceptionAdvice {

    @ExceptionHandler(ServerErrorInternalException.class)
    public ResponseEntity<ServerErrorInternalException> handleException400(
        ServerErrorInternalException e,
        HttpServletRequest request
    ) {
        val uri = request.getRequestURI();
        val className = e.getClass().getSimpleName();
        log.warn("URI '{}' occur in {}: {}", uri, className, e.getMessage());
        return ResponseEntity.badRequest().body(e);
    }
}
