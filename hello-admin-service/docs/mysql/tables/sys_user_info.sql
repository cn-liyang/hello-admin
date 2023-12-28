DROP TABLE IF EXISTS sys_user_info;
CREATE TABLE sys_user_info
(
    id         BIGINT AUTO_INCREMENT   NOT NULL COMMENT '主键',
    user_id    BIGINT                  NOT NULL COMMENT '账户主键',

    nickname   VARCHAR(100) DEFAULT '' NOT NULL COMMENT '昵称',
    avatar     TEXT                    NOT NULL COMMENT '头像',

    is_deleted BIGINT       DEFAULT 0  NOT NULL COMMENT '是否删除(0:否,时间戳:是)',
    create_by  VARCHAR(100) DEFAULT '' NOT NULL COMMENT '创建人员',
    create_at  DATETIME                NOT NULL COMMENT '创建时间',
    update_by  VARCHAR(100) DEFAULT '' NOT NULL COMMENT '更新人员',
    update_at  DATETIME                NOT NULL COMMENT '更新时间',
    remark     VARCHAR(500) DEFAULT '' NOT NULL COMMENT '备注',
    PRIMARY KEY (id),
    UNIQUE KEY uk_user_info_user_id (user_id, is_deleted)
)
    AUTO_INCREMENT = 100 COMMENT = '用户信息表';
--
INSERT INTO sys_user_info
VALUES (1,
        1,
        '管理员',
        '',
        0,
        'script',
        CURRENT_TIMESTAMP,
        'script',
        CURRENT_TIMESTAMP,
        '脚本');
INSERT INTO sys_user_info
VALUES (2,
        2,
        '游客',
        '',
        0,
        'script',
        CURRENT_TIMESTAMP,
        'script',
        CURRENT_TIMESTAMP,
        '脚本');