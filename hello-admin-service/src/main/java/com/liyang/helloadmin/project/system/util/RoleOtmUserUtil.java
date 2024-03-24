package com.liyang.helloadmin.project.system.util;

import com.liyang.helloadmin.project.system.entity.table.UserEntityTableDef;
import com.liyang.helloadmin.project.system.entity.table.UserMtmRoleEntityTableDef;
import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.query.QueryWrapper;
import java.io.Serializable;
import java.util.ArrayList;
import lombok.val;
import org.springframework.util.CollectionUtils;

/**
 * @author cn-liyang
 */
public final class RoleOtmUserUtil {

    public static QueryColumn[] getQueryColumns() {
        val columns = new ArrayList<QueryColumn>();
        columns.add(UserEntityTableDef.USER_ENTITY.USERNAME);
        CollectionUtils.mergeArrayIntoCollection(
            UserMtmRoleEntityTableDef.USER_MTM_ROLE_ENTITY.DEFAULT_COLUMNS,
            columns
        );
        return columns.toArray(new QueryColumn[0]);
    }

    public static QueryWrapper getQueryWrapper(Serializable roleId) {
        return QueryWrapper
            .create()
            .select(getQueryColumns())
            .from(UserMtmRoleEntityTableDef.USER_MTM_ROLE_ENTITY)
            .join(UserEntityTableDef.USER_ENTITY)
            .on(UserMtmRoleEntityTableDef.USER_MTM_ROLE_ENTITY.USER_ID.eq(UserEntityTableDef.USER_ENTITY.ID))
            .where(UserMtmRoleEntityTableDef.USER_MTM_ROLE_ENTITY.ROLE_ID.eq(roleId));
    }
}
