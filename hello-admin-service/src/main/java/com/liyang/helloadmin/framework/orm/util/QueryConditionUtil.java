package com.liyang.helloadmin.framework.orm.util;

import com.liyang.helloadmin.application.constant.Chars;
import com.liyang.helloadmin.application.util.ListUtil;
import com.liyang.helloadmin.application.util.TimeUtil;
import com.liyang.helloadmin.framework.orm.constant.QueryOperator;
import com.liyang.helloadmin.framework.orm.constant.ValueType;
import com.liyang.helloadmin.framework.orm.model.SearchCondition;
import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.query.QueryCondition;
import com.mybatisflex.core.query.QueryWrapper;
import com.mybatisflex.core.util.ArrayUtil;
import com.mybatisflex.core.util.CollectionUtil;
import com.mybatisflex.core.util.StringUtil;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import lombok.val;

/**
 * @author cn-liyang
 */
public final class QueryConditionUtil {

    private static final List<QueryOperator> IN_OPERATORS = Arrays.asList(QueryOperator.IN, QueryOperator.NOT_IN);

    private static final List<QueryOperator> BETWEEN_OPERATORS = Arrays.asList(
        QueryOperator.BETWEEN,
        QueryOperator.NOT_BETWEEN
    );

    public static QueryCondition getQueryCondition(
        QueryColumn[] queryColumns,
        Collection<SearchCondition> searchConditions
    ) {
        if (ArrayUtil.isEmpty(queryColumns) || CollectionUtil.isEmpty(searchConditions)) {
            return QueryCondition.createEmpty();
        }
        val optionalQueryCondition = searchConditions
            .stream()
            .map(i -> {
                val optionalQueryColumn = Arrays
                    .stream(queryColumns)
                    .filter(j -> QueryColumnUtil.equals(j, i.getField()))
                    .findFirst();
                if (optionalQueryColumn.isEmpty()) {
                    return Optional.<QueryCondition>empty();
                }
                val queryColumn = optionalQueryColumn.get();
                val value = i.getValue();
                val valueType = i.getValueType();
                val operator = i.getOperator();
                if (StringUtil.isBlank(value)) {
                    return Optional.<QueryCondition>empty();
                }
                val optionalQueryObject = getOptionalQueryObject(valueType, operator, value);
                if (optionalQueryObject.isEmpty()) {
                    return Optional.<QueryCondition>empty();
                }
                val queryCondition = QueryCondition.create(queryColumn, operator.getValue(), optionalQueryObject.get());
                return Optional.of(queryCondition);
            })
            .filter(Optional::isPresent)
            .map(Optional::get)
            .reduce(QueryCondition::and);
        return optionalQueryCondition.orElseGet(QueryCondition::createEmpty);
    }

    private static Optional<Object> getOptionalQueryObject(ValueType valueType, QueryOperator operator, String data) {
        if (ValueType.NUMB.equals(valueType)) {
            if (IN_OPERATORS.contains(operator)) {
                val split = data.split(Chars.COMMA);
                val list = ListUtil.toList(split);
                if (CollectionUtil.isEmpty(list)) {
                    return Optional.empty();
                }
                return Optional.of(list.stream().map(Long::valueOf).toArray());
            }
            if (BETWEEN_OPERATORS.contains(operator)) {
                return getOptionalQueryObjectBetween(valueType, data);
            }
            return Optional.of(Long.valueOf(data));
        }
        if (ValueType.TEXT.equals(valueType)) {
            if (IN_OPERATORS.contains(operator)) {
                val split = data.split(Chars.COMMA);
                val list = ListUtil.toList(split);
                if (CollectionUtil.isEmpty(list)) {
                    return Optional.empty();
                }
                return Optional.of(list.toArray());
            }
            return Optional.of(data);
        }
        if (ValueType.BOOL.equals(valueType)) {
            return Optional.of(Boolean.valueOf(data));
        }
        if (ValueType.TIME.equals(valueType)) {
            if (BETWEEN_OPERATORS.contains(operator)) {
                return getOptionalQueryObjectBetween(valueType, data);
            }
            return Optional.of(TimeUtil.parseTimeObject(data));
        }
        return Optional.of(data);
    }

    private static Optional<Object> getOptionalQueryObjectBetween(ValueType valueType, String data) {
        val split = data.split(Chars.TILDE);
        val list = ListUtil.toList(split);
        if (CollectionUtil.isEmpty(list) || list.size() != 2) {
            return Optional.empty();
        }
        if (ValueType.NUMB.equals(valueType)) {
            return Optional.of(list.stream().map(Long::valueOf).toArray());
        }
        if (ValueType.TIME.equals(valueType)) {
            return Optional.of(list.stream().map(TimeUtil::parseTimeObject).toArray());
        }
        return Optional.of(list);
    }

    public static QueryWrapper getQueryWrapper(
        QueryColumn[] queryColumns,
        Collection<SearchCondition> searchConditions
    ) {
        if (ArrayUtil.isEmpty(queryColumns) || CollectionUtil.isEmpty(searchConditions)) {
            return QueryWrapper.create();
        }
        val queryCondition = getQueryCondition(queryColumns, searchConditions);
        return QueryWrapper.create().where(queryCondition);
    }

    public static void andQueryWrapper(
        QueryWrapper queryWrapper,
        QueryColumn[] queryColumns,
        Collection<SearchCondition> searchConditions
    ) {
        if (ArrayUtil.isEmpty(queryColumns) || CollectionUtil.isEmpty(searchConditions)) {
            return;
        }
        val queryCondition = getQueryCondition(queryColumns, searchConditions);
        queryWrapper.and(queryCondition);
    }
}
