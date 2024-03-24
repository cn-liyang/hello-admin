package com.liyang.helloadmin.project.system.controller;

import com.liyang.helloadmin.framework.web.controller.table.WriteReadController;
import com.liyang.helloadmin.project.system.constant.SystemPaths;
import com.liyang.helloadmin.project.system.entity.RoleEntity;
import com.liyang.helloadmin.project.system.entity.table.RoleEntityTableDef;
import com.liyang.helloadmin.project.system.service.RoleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cn-liyang
 */
@RestController
@RequestMapping(SystemPaths.ROLES)
@Validated
public class RoleController extends WriteReadController<RoleEntity> {

    public RoleController(RoleService service) {
        super(service, RoleEntityTableDef.ROLE_ENTITY.DEFAULT_COLUMNS);
    }
}
