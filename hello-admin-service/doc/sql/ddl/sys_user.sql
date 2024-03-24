DROP TABLE IF EXISTS sys_user;
--
CREATE TABLE sys_user
(
  id                  BIGINT AUTO_INCREMENT   NOT NULL COMMENT '主键',

  username            VARCHAR(100) DEFAULT '' NOT NULL COMMENT '账号',
  password            VARCHAR(100) DEFAULT '' NOT NULL COMMENT '密码',
  is_expired_account  TINYINT      DEFAULT 0  NOT NULL COMMENT '是否过期账户(0:否,1:是)',
  is_expired_password TINYINT      DEFAULT 0  NOT NULL COMMENT '是否过期密码(0:否,1:是)',
  is_locked           TINYINT      DEFAULT 0  NOT NULL COMMENT '是否锁定(0:否,1:是)',
  is_enabled          TINYINT      DEFAULT 1  NOT NULL COMMENT '是否启用(0:否,1:是)',

  is_deleted          BIGINT       DEFAULT 0  NOT NULL COMMENT '是否删除(0:否,时间戳:是)',

  create_by           VARCHAR(100) DEFAULT '' NOT NULL COMMENT '创建人员',
  create_at           DATETIME                NOT NULL COMMENT '创建时间',
  update_by           VARCHAR(100) DEFAULT '' NOT NULL COMMENT '更新人员',
  update_at           DATETIME                NOT NULL COMMENT '更新时间',
  remark              VARCHAR(500) DEFAULT '' NOT NULL COMMENT '备注',
  PRIMARY KEY (id),
  UNIQUE KEY uni_sys_user (username, is_deleted),
  INDEX idx_sys_user_create_at (create_at),
  INDEX idx_sys_user_update_at (update_at)
)
  AUTO_INCREMENT = 100 COMMENT = '系统账户表';
