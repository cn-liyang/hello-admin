-- 管家
INSERT INTO sys_role (id, name, label, create_by, create_at, update_by, update_at)
VALUES (1, 'admin', '管家', 'script', CURRENT_TIMESTAMP, 'script', CURRENT_TIMESTAMP);
-- 游客
INSERT INTO sys_role (id, name, label, create_by, create_at, update_by, update_at)
VALUES (2, 'guest', '游客', 'script', CURRENT_TIMESTAMP, 'script', CURRENT_TIMESTAMP);
-- 员工
INSERT INTO sys_role (id, name, label, create_by, create_at, update_by, update_at)
VALUES (3, 'staff', '员工', 'script', CURRENT_TIMESTAMP, 'script', CURRENT_TIMESTAMP);
