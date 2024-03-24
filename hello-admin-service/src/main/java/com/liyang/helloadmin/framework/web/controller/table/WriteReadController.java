package com.liyang.helloadmin.framework.web.controller.table;

import com.liyang.helloadmin.framework.web.request.model.page.PageRequest;
import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.service.IService;
import lombok.Getter;
import lombok.val;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author cn-liyang
 */
@Getter
public class WriteReadController<T> extends WriteController<T> {

    private final QueryColumn[] columns;

    public WriteReadController(IService<T> service, QueryColumn[] columns) {
        super(service);
        this.columns = columns;
    }

    @PostMapping
    protected Object search(@RequestBody PageRequest pageRequest) {
        val page = pageRequest.<T>getPage();
        val queryWrapper = pageRequest.getQueryWrapperWithOrderBy(columns);
        val body = this.getService().page(page, queryWrapper);
        return ok(body);
    }
}
