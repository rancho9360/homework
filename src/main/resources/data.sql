

-- ----------------------------
-- Records for user0
-- H2 支持标准 SQL 插入语法，日期格式需兼容（此处手机号作为字符串处理）
-- ----------------------------
INSERT INTO "user0" ("id", "username", "name", "phone_number", "email")
VALUES
    (1, 'songhuizong', '宋徽宗', '18621139000', 'songhuizong@163.com'),
    (2, 'suxun', '苏洵', '18621139001', 'suxun@163.com'),
    (3, 'sushi', '苏轼', '18621139002', 'sushi@163.com'),
    (4, 'suzhe', '苏辙', '18621139003', 'suzhe@163.com');


-- ----------------------------
-- Records for account
-- 注意：DECIMAL 类型需使用标准数值格式，避免科学计数法
-- ----------------------------
INSERT INTO "account" ("id", "code", "user_id", "balance")
VALUES
    (1, 'songhuizong-01', 1, 10000.00),
    (2, 'songhuizong-02', 1, 20000.00),
    (3, 'songxun-01', 2, 1000.00),
    (4, 'sushi-01', 3, 0.00),
    (5, 'suzhe-01', 4, 2000.00);




