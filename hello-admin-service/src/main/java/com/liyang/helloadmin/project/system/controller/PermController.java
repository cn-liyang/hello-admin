package com.liyang.helloadmin.project.system.controller;

import com.liyang.helloadmin.framework.web.constant.PathPatterns;
import com.liyang.helloadmin.framework.web.controller.table.WriteReadController;
import com.liyang.helloadmin.framework.web.request.model.IdRequest;
import com.liyang.helloadmin.project.system.constant.SystemPaths;
import com.liyang.helloadmin.project.system.entity.PermEntity;
import com.liyang.helloadmin.project.system.entity.table.PermEntityTableDef;
import com.liyang.helloadmin.project.system.service.PermService;
import com.liyang.helloadmin.project.system.util.PermEntityUtil;
import java.util.Collections;
import lombok.val;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author cn-liyang
 */
@RestController
@RequestMapping(SystemPaths.PERMS)
@Validated
public class PermController extends WriteReadController<PermEntity> {

    public PermController(PermService service) {
        super(service, PermEntityTableDef.PERM_ENTITY.DEFAULT_COLUMNS);
    }

    @PostMapping(PathPatterns.CHILDREN)
    protected Object search(@RequestBody IdRequest idRequest) {
        val id = idRequest.getId();
        val optionalEntities = PermEntityUtil.getOptionalEntitiesByParentId(id);
        val body = optionalEntities.orElse(Collections.emptyList());
        return ok(body);
    }

    @DeleteMapping(PathPatterns.CHILDREN)
    protected Object delete(@RequestBody IdRequest idRequest) {
        val id = idRequest.getId();
        val optionalIds = PermEntityUtil.getOptionalTreeIds(id);
        if (optionalIds.isEmpty()) {
            return ok(false);
        }
        val ids = optionalIds.get();
        val body = this.getService().removeByIds(ids);
        return ok(body);
    }
}
