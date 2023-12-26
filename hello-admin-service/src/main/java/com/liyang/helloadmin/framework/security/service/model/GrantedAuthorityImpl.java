package com.liyang.helloadmin.framework.security.service.model;

import com.liyang.helloadmin.application.constant.OneChars;
import org.springframework.security.core.GrantedAuthority;

/**
 * @author cn-liyang
 */
public record GrantedAuthorityImpl(String restMethod, String restPath) implements GrantedAuthority {
    @Override
    public String getAuthority() {
        return restMethod + OneChars.POUND + restPath;
    }
}
