package com.liyang.helloadmin.project.system.controller;

import com.liyang.helloadmin.framework.web.controller.table.WriteController;
import com.liyang.helloadmin.framework.web.request.model.page.PageRequest;
import com.liyang.helloadmin.project.system.constant.SystemPaths;
import com.liyang.helloadmin.project.system.entity.UserInfoEntity;
import com.liyang.helloadmin.project.system.service.UserInfoService;
import com.liyang.helloadmin.project.system.util.UserInfoUtil;
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
@RequestMapping(SystemPaths.USER_INFOS)
@Validated
public class UserInfoController extends WriteController<UserInfoEntity> {

    public UserInfoController(UserInfoService service) {
        super(service);
    }

    @PostMapping
    public Object search(@RequestBody PageRequest pageRequest) {
        val page = pageRequest.<UserInfoEntity>getPage();
        val id = pageRequest.getId();
        val queryWrapper = UserInfoUtil.getQueryWrapper(id);
        val queryColumns = UserInfoUtil.getQueryColumns();
        pageRequest.andQueryWrapperWithOrderBy(queryWrapper, queryColumns);
        val body = this.getService().page(page, queryWrapper);
        return ok(body);
    }
}
