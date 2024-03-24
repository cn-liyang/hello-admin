package com.liyang.helloadmin.project.system.util;

import com.liyang.helloadmin.project.system.entity.table.RoleEntityTableDef;
import com.liyang.helloadmin.project.system.entity.table.UserMtmRoleEntityTableDef;
import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.query.QueryMethods;
import com.mybatisflex.core.query.QueryWrapper;
import java.io.Serializable;

/**
 * @author cn-liyang
 */
public final class UserNotRoleUtil {

    public static QueryColumn[] getQueryColumns() {
        return new QueryColumn[] {
            RoleEntityTableDef.ROLE_ENTITY.NAME,
            RoleEntityTableDef.ROLE_ENTITY.LABEL,
            RoleEntityTableDef.ROLE_ENTITY.ID,
            RoleEntityTableDef.ROLE_ENTITY.CREATE_AT,
            RoleEntityTableDef.ROLE_ENTITY.CREATE_BY,
            RoleEntityTableDef.ROLE_ENTITY.UPDATE_AT,
            RoleEntityTableDef.ROLE_ENTITY.UPDATE_BY,
            RoleEntityTableDef.ROLE_ENTITY.REMARK,
        };
    }

    public static QueryWrapper getQueryWrapper(Serializable userId) {
        return QueryWrapper
            .create()
            .select(getQueryColumns())
            .from(RoleEntityTableDef.ROLE_ENTITY)
            .where(
                QueryMethods.notExists(
                    QueryMethods
                        .selectOne()
                        .from(UserMtmRoleEntityTableDef.USER_MTM_ROLE_ENTITY)
                        .where(
                            UserMtmRoleEntityTableDef.USER_MTM_ROLE_ENTITY.ROLE_ID.eq(RoleEntityTableDef.ROLE_ENTITY.ID)
                        )
                        .and(UserMtmRoleEntityTableDef.USER_MTM_ROLE_ENTITY.DELETED.eq(0))
                        .and(UserMtmRoleEntityTableDef.USER_MTM_ROLE_ENTITY.USER_ID.eq(userId))
                )
            );
    }
}
