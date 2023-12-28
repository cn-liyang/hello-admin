DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    id         BIGINT AUTO_INCREMENT   NOT NULL COMMENT '主键',

    username   VARCHAR(100) DEFAULT '' NOT NULL COMMENT '账号',
    password   VARCHAR(100) DEFAULT '' NOT NULL COMMENT '密码',

    is_locked  TINYINT      DEFAULT 0  NOT NULL COMMENT '是否锁定(0:否,1:是)',
    is_expired TINYINT      DEFAULT 0  NOT NULL COMMENT '是否过期(0:否,1:是)',
    is_enabled TINYINT      DEFAULT 1  NOT NULL COMMENT '是否启用(0:否,1:是)',

    is_deleted BIGINT       DEFAULT 0  NOT NULL COMMENT '是否删除(0:否,时间戳:是)',
    create_by  VARCHAR(100) DEFAULT '' NOT NULL COMMENT '创建人员',
    create_at  DATETIME                NOT NULL COMMENT '创建时间',
    update_by  VARCHAR(100) DEFAULT '' NOT NULL COMMENT '更新人员',
    update_at  DATETIME                NOT NULL COMMENT '更新时间',
    remark     VARCHAR(500) DEFAULT '' NOT NULL COMMENT '备注',
    PRIMARY KEY (id),
    UNIQUE KEY uk_user_username (username, is_deleted)
)
    AUTO_INCREMENT = 100 COMMENT = '账户表';
--
INSERT INTO sys_user
VALUES (1,
        'Admin',
        '$2a$10$hspnnXO05fin/MiWnso4VeKRRcegLV6We8MRqqO1xWedDk/Ls/gy.',
        0,
        0,
        1,
        0,
        'script',
        CURRENT_TIMESTAMP,
        'script',
        CURRENT_TIMESTAMP,
        '脚本');
INSERT INTO sys_user
VALUES (2,
        'Guest',
        '$2a$10$MUciszgUd47UyGgPdOPpnu2f1VheBMDW3mkui5W2eTFEHeI.WoDiu',
        0,
        0,
        1,
        0,
        'script',
        CURRENT_TIMESTAMP,
        'script',
        CURRENT_TIMESTAMP,
        '脚本');