DROP TABLE IF EXISTS sys_role_mtm_perm;
--
CREATE TABLE sys_role_mtm_perm
(
  id         BIGINT AUTO_INCREMENT   NOT NULL COMMENT '主键',

  role_id    BIGINT       DEFAULT 0  NOT NULL COMMENT '角色主键',
  perm_id    BIGINT       DEFAULT 0  NOT NULL COMMENT '权限主键',

  is_deleted BIGINT       DEFAULT 0  NOT NULL COMMENT '是否删除(0:否,时间戳:是)',

  create_by  VARCHAR(100) DEFAULT '' NOT NULL COMMENT '创建人员',
  create_at  DATETIME                NOT NULL COMMENT '创建时间',
  update_by  VARCHAR(100) DEFAULT '' NOT NULL COMMENT '更新人员',
  update_at  DATETIME                NOT NULL COMMENT '更新时间',
  remark     VARCHAR(500) DEFAULT '' NOT NULL COMMENT '备注',
  PRIMARY KEY (id),
  UNIQUE KEY uni_sys_role_mtm_perm (role_id, perm_id, is_deleted),
  INDEX idx_sys_role_mtm_perm_create_at (create_at),
  INDEX idx_sys_role_mtm_perm_update_at (update_at)
)
  COMMENT = '系统角色多对多权限表';
