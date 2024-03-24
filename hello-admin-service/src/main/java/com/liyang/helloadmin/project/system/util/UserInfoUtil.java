package com.liyang.helloadmin.project.system.util;

import com.liyang.helloadmin.project.system.entity.table.UserInfoEntityTableDef;
import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.query.QueryWrapper;
import java.io.Serializable;

/**
 * @author cn-liyang
 */
public final class UserInfoUtil {

    public static QueryColumn[] getQueryColumns() {
        return UserInfoEntityTableDef.USER_INFO_ENTITY.DEFAULT_COLUMNS;
    }

    public static QueryWrapper getQueryWrapper(Serializable id) {
        return QueryWrapper
            .create()
            .select(getQueryColumns())
            .from(UserInfoEntityTableDef.USER_INFO_ENTITY)
            .where(UserInfoEntityTableDef.USER_INFO_ENTITY.USER_ID.eq(id));
    }
}
