package com.liyang.helloadmin.project.system.controller;

import com.liyang.helloadmin.framework.web.constant.PathPatterns;
import com.liyang.helloadmin.framework.web.controller.table.WriteController;
import com.liyang.helloadmin.framework.web.request.model.IdRequest;
import com.liyang.helloadmin.project.system.constant.SystemPaths;
import com.liyang.helloadmin.project.system.entity.RoleMtmPermEntity;
import com.liyang.helloadmin.project.system.entity.table.RoleMtmPermEntityTableDef;
import com.liyang.helloadmin.project.system.service.RoleMtmPermService;
import com.liyang.helloadmin.project.system.util.PermEntityUtil;
import java.util.Collections;
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
@RequestMapping(SystemPaths.ROLE_OTM_PERMS)
@Validated
public class RoleOtmPermController extends WriteController<RoleMtmPermEntity> {

    public RoleOtmPermController(RoleMtmPermService service) {
        super(service);
    }

    @PostMapping(PathPatterns.CHILDREN)
    protected Object searchChildren(@RequestBody IdRequest idRequest) {
        val id = idRequest.getId();
        val optionalEntities = PermEntityUtil.getOptionalEntitiesWithRelationsByParentId(id);
        val body = optionalEntities.orElse(Collections.emptyList());
        return ok(body);
    }

    @PostMapping(PathPatterns.LEAFS)
    protected Object searchLeafs(@RequestBody IdRequest idRequest) {
        val id = idRequest.getId();
        val queryCondition = RoleMtmPermEntityTableDef.ROLE_MTM_PERM_ENTITY.ROLE_ID.eq(id);
        val body = this.getService().list(queryCondition);
        return ok(body);
    }
}
