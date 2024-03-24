package com.liyang.helloadmin.project.system.controller;

import com.liyang.helloadmin.framework.web.controller.table.WriteReadController;
import com.liyang.helloadmin.project.system.constant.SystemPaths;
import com.liyang.helloadmin.project.system.entity.UserEntity;
import com.liyang.helloadmin.project.system.entity.table.UserEntityTableDef;
import com.liyang.helloadmin.project.system.service.UserService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cn-liyang
 */
@RestController
@RequestMapping(SystemPaths.USERS)
@Validated
public class UserController extends WriteReadController<UserEntity> {

    public UserController(UserService service) {
        super(service, UserEntityTableDef.USER_ENTITY.DEFAULT_COLUMNS);
    }
}
