-- Admin
INSERT INTO sys_user (id, username, password, create_by, create_at, update_by, update_at)
VALUES (1, 'Admin', '$2a$10$hspnnXO05fin/MiWnso4VeKRRcegLV6We8MRqqO1xWedDk/Ls/gy.', 'script', CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- Guest
INSERT INTO sys_user (id, username, password, create_by, create_at, update_by, update_at)
VALUES (2, 'Guest', '$2a$10$MUciszgUd47UyGgPdOPpnu2f1VheBMDW3mkui5W2eTFEHeI.WoDiu', 'script', CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
-- Staff
INSERT INTO sys_user (id, username, password, create_by, create_at, update_by, update_at)
VALUES (3, 'Staff', '$2a$10$g52dskj8E2Kiu4ZOpWDIVOiaVXZ63k8VDgApL8764.DPnbJ7OTcuK', 'script', CURRENT_TIMESTAMP,
        'script', CURRENT_TIMESTAMP);
