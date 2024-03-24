package com.liyang.helloadmin.framework.web.controller.table;

import com.liyang.helloadmin.framework.web.constant.PathPatterns;
import com.liyang.helloadmin.framework.web.controller.BaseController;
import com.liyang.helloadmin.framework.web.request.model.IdRequest;
import com.liyang.helloadmin.framework.web.request.model.IdsRequest;
import com.mybatisflex.core.service.IService;
import java.util.Collection;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.val;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author cn-liyang
 */
@Getter
@AllArgsConstructor
public class WriteController<T> extends BaseController {

    private final IService<T> service;

    @PutMapping
    protected Object create(@RequestBody T entity) {
        val body = service.save(entity);
        return ok(body);
    }

    @PutMapping(PathPatterns.BATCH)
    protected Object createBatch(@RequestBody Collection<T> entities) {
        val body = service.saveBatch(entities);
        return ok(body);
    }

    @PatchMapping
    protected Object update(@RequestBody T entity) {
        val body = service.updateById(entity);
        return ok(body);
    }

    @PatchMapping(PathPatterns.BATCH)
    protected Object updateBatch(@RequestBody Collection<T> entities) {
        val body = service.updateBatch(entities);
        return ok(body);
    }

    @DeleteMapping
    protected Object delete(@RequestBody IdRequest idRequest) {
        val id = idRequest.getId();
        val body = service.removeById(id);
        return ok(body);
    }

    @DeleteMapping(PathPatterns.BATCH)
    protected Object deleteBatch(@RequestBody IdsRequest idsRequest) {
        val ids = idsRequest.getIds();
        val body = service.removeByIds(ids);
        return ok(body);
    }
}
