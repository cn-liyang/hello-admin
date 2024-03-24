DROP TABLE IF EXISTS sys_role;
--
CREATE TABLE sys_role
(
  id         BIGINT AUTO_INCREMENT   NOT NULL COMMENT '主键',

  name       VARCHAR(100) DEFAULT '' NOT NULL COMMENT '名称',
  label      VARCHAR(100) DEFAULT '' NOT NULL COMMENT '标签',

  is_deleted BIGINT       DEFAULT 0  NOT NULL COMMENT '是否删除(0:否,时间戳:是)',

  create_by  VARCHAR(100) DEFAULT '' NOT NULL COMMENT '创建人员',
  create_at  DATETIME                NOT NULL COMMENT '创建时间',
  update_by  VARCHAR(100) DEFAULT '' NOT NULL COMMENT '更新人员',
  update_at  DATETIME                NOT NULL COMMENT '更新时间',
  remark     VARCHAR(500) DEFAULT '' NOT NULL COMMENT '备注',
  PRIMARY KEY (id),
  UNIQUE KEY uni_sys_role (name, is_deleted),
  INDEX idx_sys_role_create_at (create_at),
  INDEX idx_sys_role_update_at (update_at)
)
  AUTO_INCREMENT = 100 COMMENT = '系统角色表';
