package com.liyang.helloadmin.framework.web.request.model.page;

import com.liyang.helloadmin.framework.orm.model.SearchCondition;
import com.liyang.helloadmin.framework.orm.util.QueryColumnUtil;
import com.liyang.helloadmin.framework.orm.util.QueryConditionUtil;
import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.util.StringUtil;
import java.util.Arrays;
import java.util.Collection;
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
public class PageRequest extends IdPaginationRequest {

    private Collection<SearchCondition> conditions;

    public QueryWrapper getQueryWrapperWithOrderBy(QueryColumn[] queryColumns) {
        val queryWrapper = QueryConditionUtil.getQueryWrapper(queryColumns, conditions);
        val sortBy = this.getPagination().getSortBy();
        val descending = this.getPagination().getDescending();
        if (StringUtil.isBlank(sortBy) || Objects.isNull(descending)) {
            return queryWrapper;
        }
        val optionalQueryColumn = Arrays
            .stream(queryColumns)
            .filter(i -> QueryColumnUtil.equals(i, sortBy))
            .findFirst();
        if (optionalQueryColumn.isEmpty()) {
            return queryWrapper;
        }
        val sortByQueryColumn = optionalQueryColumn.get();
        return queryWrapper.orderBy(sortByQueryColumn, !descending);
    }

    public void andQueryWrapperWithOrderBy(QueryWrapper queryWrapper, QueryColumn[] queryColumns) {
        QueryConditionUtil.andQueryWrapper(queryWrapper, queryColumns, conditions);
        val sortBy = this.getPagination().getSortBy();
        val descending = this.getPagination().getDescending();
        if (StringUtil.isBlank(sortBy) || Objects.isNull(descending)) {
            return;
        }
        val optionalQueryColumn = Arrays
            .stream(queryColumns)
            .filter(i -> QueryColumnUtil.equals(i, sortBy))
            .findFirst();
        if (optionalQueryColumn.isEmpty()) {
            return;
        }
        val sortByQueryColumn = optionalQueryColumn.get();
        queryWrapper.orderBy(sortByQueryColumn, !descending);
    }
}
