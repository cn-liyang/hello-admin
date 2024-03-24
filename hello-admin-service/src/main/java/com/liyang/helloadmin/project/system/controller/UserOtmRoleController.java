package com.liyang.helloadmin.project.system.controller;

import com.liyang.helloadmin.framework.web.controller.table.WriteController;
import com.liyang.helloadmin.framework.web.request.model.page.PageRequest;
import com.liyang.helloadmin.project.system.constant.SystemPaths;
import com.liyang.helloadmin.project.system.controller.model.UserOtmRole;
import com.liyang.helloadmin.project.system.entity.UserMtmRoleEntity;
import com.liyang.helloadmin.project.system.service.UserMtmRoleService;
import com.liyang.helloadmin.project.system.util.UserOtmRoleUtil;
import lombok.val;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cn-liyang
 */
@RestController
@RequestMapping(SystemPaths.USER_OTM_ROLES)
@Validated
public class UserOtmRoleController extends WriteController<UserMtmRoleEntity> {

    public UserOtmRoleController(UserMtmRoleService service) {
        super(service);
    }

    @PostMapping
    public Object search(@RequestBody PageRequest pageRequest) {
        val page = pageRequest.<UserOtmRole>getPage();
        val id = pageRequest.getId();
        val queryWrapper = UserOtmRoleUtil.getQueryWrapper(id);
        val queryColumns = UserOtmRoleUtil.getQueryColumns();
        pageRequest.andQueryWrapperWithOrderBy(queryWrapper, queryColumns);
        val body = this.getService().pageAs(page, queryWrapper, UserOtmRole.class);
        return ok(body);
    }
}
