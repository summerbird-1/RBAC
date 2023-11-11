-- 创建数据库（如果尚未创建）
CREATE DATABASE IF NOT EXISTS rbac;
USE rbac;
-- 创建用户表
CREATE TABLE IF NOT EXISTS sys_user (
    userId INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    phone VARCHAR(15),
    email VARCHAR(255) NOT NULL
);
-- 插入示例用户数据
INSERT INTO user (username, password, phone, email) VALUES
    ('zjz', '1234', '123-456-7890', 'user1@example.com'),
    ('user2', 'password2', '987-654-3210', 'user2@example.com'),
    ('user3', 'password3', NULL, 'user3@example.com'); -- 这里phone列为NULL