package com.liyang.helloadmin.project.system.util;

import com.liyang.helloadmin.project.system.entity.table.RoleEntityTableDef;
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
public final class UserOtmRoleUtil {

    public static QueryColumn[] getQueryColumns() {
        val columns = new ArrayList<QueryColumn>();
        columns.add(RoleEntityTableDef.ROLE_ENTITY.NAME);
        columns.add(RoleEntityTableDef.ROLE_ENTITY.LABEL);
        CollectionUtils.mergeArrayIntoCollection(
            UserMtmRoleEntityTableDef.USER_MTM_ROLE_ENTITY.DEFAULT_COLUMNS,
            columns
        );
        return columns.toArray(new QueryColumn[0]);
    }

    public static QueryWrapper getQueryWrapper(Serializable userId) {
        return QueryWrapper
            .create()
            .select(getQueryColumns())
            .from(UserMtmRoleEntityTableDef.USER_MTM_ROLE_ENTITY)
            .join(RoleEntityTableDef.ROLE_ENTITY)
            .on(UserMtmRoleEntityTableDef.USER_MTM_ROLE_ENTITY.ROLE_ID.eq(RoleEntityTableDef.ROLE_ENTITY.ID))
            .where(UserMtmRoleEntityTableDef.USER_MTM_ROLE_ENTITY.USER_ID.eq(userId));
    }
}
