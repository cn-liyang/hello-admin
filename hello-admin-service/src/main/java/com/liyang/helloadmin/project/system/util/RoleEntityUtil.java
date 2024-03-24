package com.liyang.helloadmin.project.system.util;

import com.liyang.helloadmin.project.system.service.RoleService;
import org.springframework.stereotype.Component;

/**
 * @author cn-liyang
 */
@Component
public final class RoleEntityUtil {

    private static RoleService roleService;

    private RoleEntityUtil(RoleService roleService) {
        RoleEntityUtil.roleService = roleService;
    }
}
