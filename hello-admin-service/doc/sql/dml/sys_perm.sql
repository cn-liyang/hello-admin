-- 目录 --
-- 目录: /系统管理/
INSERT INTO sys_perm (id, parent_id, perm_type, name, icon, label, caption, sort_by, create_by, create_at, update_by,
                      update_at)
VALUES (1, 0, 0, 'system', 'mdi-cog-outline', '系统管理', '管理系统数据等', 1, 'script', CURRENT_TIMESTAMP, 'script',
        CURRENT_TIMESTAMP);
-- 视图 --
-- 视图: /系统管理/账户设置
INSERT INTO sys_perm (id, parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (11, 1, 1, '/src/pages/main/system/user/UserPage.vue', 'user', 'mdi-account-cog', '账户设置', '系统账户表', 1,
        'script', CURRENT_TIMESTAMP, 'script', CURRENT_TIMESTAMP);
-- 视图: /系统管理/角色设置
INSERT INTO sys_perm (id, parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (12, 1, 1, '/src/pages/main/system/role/RolePage.vue', 'role', 'mdi-star-cog', '角色设置', '系统角色表', 2,
        'script', CURRENT_TIMESTAMP, 'script', CURRENT_TIMESTAMP);
-- 视图: /系统管理/权限设置
INSERT INTO sys_perm (id, parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (13, 1, 1, '/src/pages/main/system/perm/PermPage.vue', 'perm', 'mdi-window-shutter-cog', '权限设置',
        '系统权限表', 3,
        'script', CURRENT_TIMESTAMP, 'script', CURRENT_TIMESTAMP);
-- 视图接口 --
-- 接口: /系统管理/账户设置$查
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (11, 2, 'post#/system/users', 'search', 'mdi-table-search', '搜索', '搜索记录', 1, 'script', CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/账户设置$增
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (11, 2, 'put#/system/users', 'create', 'mdi-table-plus', '新增', '新增记录', 2, 'script', CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/账户设置$改
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (11, 2, 'patch#/system/users', 'update', 'mdi-table-edit', '修改', '修改记录', 3, 'script', CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/账户设置$批删
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (11, 2, 'delete#/system/users/batch', 'deleteBatch', 'mdi-table-remove', '删除', '删除记录', 4, 'script',
        CURRENT_TIMESTAMP, 'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/账户设置>账户信息设置$查
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (11, 2, 'post#/system/user_infos', 'search', 'mdi-table-search', '搜索', '搜索记录', 1, 'script',
        CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/账户设置>账户信息设置$增
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (11, 2, 'put#/system/user_infos', 'create', 'mdi-table-plus', '新增', '新增记录', 2, 'script', CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/账户设置>账户信息设置$改
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (11, 2, 'patch#/system/user_infos', 'update', 'mdi-table-edit', '修改', '修改记录', 3, 'script',
        CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/账户设置>账户信息设置$批删
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (11, 2, 'delete#/system/user_infos/batch', 'deleteBatch', 'mdi-table-remove', '删除', '删除记录', 4, 'script',
        CURRENT_TIMESTAMP, 'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/账户设置>账户关联角色设置$查
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (11, 2, 'post#/system/user_otm_roles', 'search', 'mdi-table-search', '搜索', '搜索记录', 1, 'script',
        CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/账户设置>账户关联角色设置$批增
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (11, 2, 'put#/system/user_otm_roles/batch', 'createBatch', 'mdi-table-plus', '新增', '新增记录', 2, 'script',
        CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/账户设置>账户关联角色设置$批删
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (11, 2, 'delete#/system/user_otm_roles/batch', 'deleteBatch', 'mdi-table-remove', '删除', '删除记录', 4,
        'script',
        CURRENT_TIMESTAMP, 'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/账户设置>账户关联角色设置>账户新增角色查询$查
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (11, 2, 'post#/system/user_not_roles', 'search', 'mdi-table-search', '搜索', '搜索记录', 1, 'script',
        CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/角色设置$查
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (12, 2, 'post#/system/roles', 'search', 'mdi-table-search', '搜索', '搜索记录', 1, 'script', CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/角色设置$增
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (12, 2, 'put#/system/roles', 'create', 'mdi-table-plus', '新增', '新增记录', 2, 'script', CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/角色设置$改
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (12, 2, 'patch#/system/roles', 'update', 'mdi-table-edit', '修改', '修改记录', 3, 'script', CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/角色设置$批删
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (12, 2, 'delete#/system/roles/batch', 'deleteBatch', 'mdi-table-remove', '删除', '删除记录', 4, 'script',
        CURRENT_TIMESTAMP, 'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/权限设置$查
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (13, 2, 'post#/system/perms', 'search', 'mdi-table-search', '搜索', '搜索记录', 1, 'script', CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/权限设置$增
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (13, 2, 'put#/system/perms', 'create', 'mdi-table-plus', '新增', '新增记录', 2, 'script', CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/权限设置$改
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (13, 2, 'patch#/system/perms', 'update', 'mdi-table-edit', '修改', '修改记录', 3, 'script', CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/权限设置$批删
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (13, 2, 'delete#/system/perms/batch', 'deleteBatch', 'mdi-table-remove', '删除', '删除记录', 4, 'script',
        CURRENT_TIMESTAMP, 'script', CURRENT_TIMESTAMP);
-- 接口: /系统管理/权限设置$查子
INSERT INTO sys_perm (parent_id, perm_type, perm_sign, name, icon, label, caption, sort_by, create_by, create_at,
                      update_by, update_at)
VALUES (13, 2, 'post#/system/perms/children', 'search', 'mdi-tag-search', '查询', '查询子树', 1, 'script',
        CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
