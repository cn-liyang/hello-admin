package com.liyang.helloadmin.framework.web.exception;

/**
 * @author cn-liyang
 */
public interface ExceptionFormats {
    String SOME_BAD = "The %s is bad!";
    String SOME_EXPIRED = "The %s is expired!";
    String SOME_MISSING = "The %s is missing!";
    String UNAUTHORIZED_DETAILS = "Your request is unauthorized! details: %s";
    String FORBIDDEN_DETAILS = "Your request is forbidden! details: %s";
}
