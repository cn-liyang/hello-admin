package com.liyang.helloadmin.project.system.util;

import com.liyang.helloadmin.project.system.entity.table.UserEntityTableDef;
import com.liyang.helloadmin.project.system.entity.table.UserMtmRoleEntityTableDef;
import com.mybatisflex.core.query.QueryColumn;
import com.mybatisflex.core.query.QueryMethods;
import com.mybatisflex.core.query.QueryWrapper;
import java.io.Serializable;

/**
 * @author cn-liyang
 */
public final class RoleNotUserUtil {

    public static QueryColumn[] getQueryColumns() {
        return new QueryColumn[] {
            UserEntityTableDef.USER_ENTITY.USERNAME,
            UserEntityTableDef.USER_ENTITY.ID,
            UserEntityTableDef.USER_ENTITY.CREATE_AT,
            UserEntityTableDef.USER_ENTITY.CREATE_BY,
            UserEntityTableDef.USER_ENTITY.UPDATE_AT,
            UserEntityTableDef.USER_ENTITY.UPDATE_BY,
            UserEntityTableDef.USER_ENTITY.REMARK,
        };
    }

    public static QueryWrapper getQueryWrapper(Serializable roleId) {
        return QueryWrapper
            .create()
            .select(getQueryColumns())
            .from(UserEntityTableDef.USER_ENTITY)
            .where(
                QueryMethods.notExists(
                    QueryMethods
                        .selectOne()
                        .from(UserMtmRoleEntityTableDef.USER_MTM_ROLE_ENTITY)
                        .where(
                            UserMtmRoleEntityTableDef.USER_MTM_ROLE_ENTITY.USER_ID.eq(UserEntityTableDef.USER_ENTITY.ID)
                        )
                        .and(UserMtmRoleEntityTableDef.USER_MTM_ROLE_ENTITY.DELETED.eq(0))
                        .and(UserMtmRoleEntityTableDef.USER_MTM_ROLE_ENTITY.ROLE_ID.eq(roleId))
                )
            );
    }
}
