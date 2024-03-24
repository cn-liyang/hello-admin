package com.liyang.helloadmin.framework.security.util;

import com.liyang.helloadmin.framework.security.service.model.UserDetailsImpl;
import com.liyang.helloadmin.project.system.entity.UserEntity;
import com.liyang.helloadmin.project.system.entity.UserInfoEntity;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author cn-liyang
 */
public final class UserDetailsUtil {

    public static UserDetailsImpl getUserDetails() {
        return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static String getUsername() {
        return getUserDetails().getUsername();
    }

    public static UserEntity getUserEntity() {
        return getUserDetails().userEntity();
    }

    public static UserInfoEntity getUserInfoEntity() {
        return getUserEntity().getUserInfoEntity();
    }
}
