package com.liyang.helloadmin.framework.web.request.model.page;

import com.liyang.helloadmin.framework.orm.model.QuasarPagination;
import com.liyang.helloadmin.framework.web.request.model.IdRequest;
import com.mybatisflex.core.paginate.Page;
import jakarta.validation.constraints.NotEmpty;
import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.val;

/**
 * @author cn-liyang
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class IdPaginationRequest extends IdRequest {

    @NotEmpty
    private QuasarPagination pagination;

    public <T> Page<T> getPage() {
        val pageNumber = pagination.getPage();
        val pageSize = pagination.getRowsPerPage();
        val rowsNumber = pagination.getRowsNumber();
        if (Objects.isNull(pageNumber) || Objects.isNull(pageSize) || pageNumber <= 0 || pageSize <= 0) {
            return new Page<>();
        }
        if (Objects.isNull(rowsNumber)) {
            return Page.of(pageNumber, pageSize);
        }
        if (rowsNumber == 0) {
            return Page.of(pageNumber, pageSize, -1);
        }
        return Page.of(pageNumber, pageSize, rowsNumber);
    }
}
