package com.liyang.helloadmin.application.constant;

/**
 * @author cn-liyang
 */
public interface Https {
    String PROTOCOL_HTTP = "http";
    String PROTOCOL_HTTPS = "https";
    String PREFIX_HTTP = PROTOCOL_HTTP + Chars.COLON + Chars.SLASH + Chars.SLASH;
    String PREFIX_HTTPS = PROTOCOL_HTTPS + Chars.COLON + Chars.SLASH + Chars.SLASH;
}
