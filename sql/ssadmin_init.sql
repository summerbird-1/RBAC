/*
 Navicat Premium Data Transfer

 Source Server         : 123
 Source Server Type    : MySQL
 Source Server Version : 80029
 Source Host           : localhost:3306
 Source Schema         : rbac

 Target Server Type    : MySQL
 Target Server Version : 80029
 File Encoding         : 65001

 Date: 14/11/2023 13:48:18
*/

SET NAMES utf8;
SET FOREIGN_KEY_CHECKS = 0;
CREATE DATABASE IF NOT EXISTS `rbac` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `rbac`;
-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '菜单ID',
  `menu_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '菜单名称',
  `parent_id` bigint NULL DEFAULT 0 COMMENT '父菜单ID',
  `order_num` int NULL DEFAULT 0 COMMENT '显示顺序',
  `path` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '路由地址',
  `component` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '组件路径',
  `is_frame` int NULL DEFAULT 1 COMMENT '是否为外链（0是 1否）',
  `menu_type` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '菜单类型（M目录 C菜单 F按钮）',
  `visible` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0显示 1隐藏）',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '菜单状态（0正常 1停用）',
  `perms` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限标识',
  `icon` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '#' COMMENT '菜单图标',
  `create_by` bigint NULL DEFAULT NULL COMMENT '创建者',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_by` bigint NULL DEFAULT NULL COMMENT '更新者',
  `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '' COMMENT '备注',
  `del_flag` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2035 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '菜单权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (100, '用户管理', 0, 1, 'user', 'view/user', 1, 'C', '0', '0', 'user:list', 'user', 0, '2021-11-12 10:46:19', 1, '2022-07-31 15:47:58', '用户管理菜单', '0');
INSERT INTO `menu` VALUES (101, '角色管理', 0, 2, 'role', 'view/role', 1, 'C', '0', '0', 'role:list', 'peoples', 0, '2021-11-12 10:46:19', 0, NULL, '角色管理菜单', '0');
INSERT INTO `menu` VALUES (102, '菜单管理', 0, 3, 'menu', 'view/menu', 1, 'C', '0', '0', 'menu:list', 'tree-table', 0, '2021-11-12 10:46:19', 0, NULL, '菜单管理菜单', '0');
INSERT INTO `menu` VALUES (1001, '用户查询', 100, 1, '', '', 1, 'F', '0', '0', 'user:query', '#', 0, '2021-11-12 10:46:19', 0, NULL, '', '0');
INSERT INTO `menu` VALUES (1002, '用户新增', 100, 2, '', '', 1, 'F', '0', '0', 'user:add', '#', 0, '2021-11-12 10:46:19', 0, NULL, '', '0');
INSERT INTO `menu` VALUES (1003, '用户修改', 100, 3, '', '', 1, 'F', '0', '0', 'user:edit', '#', 0, '2021-11-12 10:46:19', 0, NULL, '', '0');
INSERT INTO `menu` VALUES (1004, '用户删除', 100, 4, '', '', 1, 'F', '0', '0', 'user:remove', '#', 0, '2021-11-12 10:46:19', 0, NULL, '', '0');
INSERT INTO `menu` VALUES (1008, '角色查询', 101, 1, '', '', 1, 'F', '0', '0', 'role:query', '#', 0, '2021-11-12 10:46:19', 0, NULL, '', '0');
INSERT INTO `menu` VALUES (1009, '角色新增', 101, 2, '', '', 1, 'F', '0', '0', 'role:add', '#', 0, '2021-11-12 10:46:19', 0, NULL, '', '0');
INSERT INTO `menu` VALUES (1010, '角色修改', 101, 3, '', '', 1, 'F', '0', '0', 'role:edit', '#', 0, '2021-11-12 10:46:19', 0, NULL, '', '0');
INSERT INTO `menu` VALUES (1011, '角色删除', 101, 4, '', '', 1, 'F', '0', '0', 'role:remove', '#', 0, '2021-11-12 10:46:19', 0, NULL, '', '0');
INSERT INTO `menu` VALUES (1013, '菜单查询', 102, 1, '', '', 1, 'F', '0', '0', 'menu:query', '#', 0, '2021-11-12 10:46:19', 0, NULL, '', '0');
INSERT INTO `menu` VALUES (1014, '菜单新增', 102, 2, '', '', 1, 'F', '0', '0', 'menu:add', '#', 0, '2021-11-12 10:46:19', 0, NULL, '', '0');
INSERT INTO `menu` VALUES (1015, '菜单修改', 102, 3, '', '', 1, 'F', '0', '0', 'menu:edit', '#', 0, '2021-11-12 10:46:19', 0, NULL, '', '0');
INSERT INTO `menu` VALUES (1016, '菜单删除', 102, 4, '', '', 1, 'F', '0', '0', 'menu:remove', '#', 0, '2021-11-12 10:46:19', 0, NULL, '', '0');
INSERT INTO `menu` VALUES (2035, '权限管理', 0, 4, '/permission', NULL, 1, 'M', '0', '0', NULL, 'lock', NULL, NULL, NULL, NULL, '', '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `roleId` bigint NOT NULL AUTO_INCREMENT,
  `rolename` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '',
  `description` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT '',
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  PRIMARY KEY (`roleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '管理员', '系统管理员', '0');
INSERT INTO `role` VALUES (2, '编辑', '文章编辑员', '0');
INSERT INTO `role` VALUES (3, '普通用户', '系统普通用户', '0');
INSERT INTO `role` VALUES (20, '咸鱼', '管理用户', '0');
INSERT INTO `role` VALUES (21, '虎鲸', '虎鲸呼呼呼呼', '0');

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu`  (
  `role_id` bigint NOT NULL COMMENT '角色ID',
  `menu_id` bigint NOT NULL COMMENT '菜单ID',
  PRIMARY KEY (`role_id`, `menu_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色和菜单关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_menu
-- ----------------------------
INSERT INTO `role_menu` VALUES (0, 0);
INSERT INTO `role_menu` VALUES (2, 1);
INSERT INTO `role_menu` VALUES (2, 102);
INSERT INTO `role_menu` VALUES (2, 1013);
INSERT INTO `role_menu` VALUES (2, 1014);
INSERT INTO `role_menu` VALUES (2, 1015);
INSERT INTO `role_menu` VALUES (2, 1016);
INSERT INTO `role_menu` VALUES (2, 2000);
INSERT INTO `role_menu` VALUES (3, 100);
INSERT INTO `role_menu` VALUES (3, 1003);
INSERT INTO `role_menu` VALUES (11, 1);
INSERT INTO `role_menu` VALUES (11, 100);
INSERT INTO `role_menu` VALUES (11, 101);
INSERT INTO `role_menu` VALUES (11, 102);
INSERT INTO `role_menu` VALUES (11, 1001);
INSERT INTO `role_menu` VALUES (11, 1002);
INSERT INTO `role_menu` VALUES (11, 1003);
INSERT INTO `role_menu` VALUES (11, 1004);
INSERT INTO `role_menu` VALUES (11, 1005);
INSERT INTO `role_menu` VALUES (11, 1006);
INSERT INTO `role_menu` VALUES (11, 1007);
INSERT INTO `role_menu` VALUES (11, 1008);
INSERT INTO `role_menu` VALUES (11, 1009);
INSERT INTO `role_menu` VALUES (11, 1010);
INSERT INTO `role_menu` VALUES (11, 1011);
INSERT INTO `role_menu` VALUES (11, 1012);
INSERT INTO `role_menu` VALUES (11, 1013);
INSERT INTO `role_menu` VALUES (11, 1014);
INSERT INTO `role_menu` VALUES (11, 1015);
INSERT INTO `role_menu` VALUES (11, 1016);
INSERT INTO `role_menu` VALUES (11, 2017);
INSERT INTO `role_menu` VALUES (11, 2018);
INSERT INTO `role_menu` VALUES (11, 2019);
INSERT INTO `role_menu` VALUES (11, 2021);
INSERT INTO `role_menu` VALUES (11, 2022);
INSERT INTO `role_menu` VALUES (11, 2024);
INSERT INTO `role_menu` VALUES (11, 2025);
INSERT INTO `role_menu` VALUES (11, 2026);
INSERT INTO `role_menu` VALUES (11, 2027);
INSERT INTO `role_menu` VALUES (11, 2028);
INSERT INTO `role_menu` VALUES (12, 2017);
INSERT INTO `role_menu` VALUES (12, 2022);
INSERT INTO `role_menu` VALUES (12, 2024);
INSERT INTO `role_menu` VALUES (12, 2025);
INSERT INTO `role_menu` VALUES (12, 2026);
INSERT INTO `role_menu` VALUES (12, 2027);
INSERT INTO `role_menu` VALUES (13, 1);
INSERT INTO `role_menu` VALUES (13, 100);
INSERT INTO `role_menu` VALUES (13, 101);
INSERT INTO `role_menu` VALUES (13, 102);
INSERT INTO `role_menu` VALUES (13, 1001);
INSERT INTO `role_menu` VALUES (13, 1002);
INSERT INTO `role_menu` VALUES (13, 1003);
INSERT INTO `role_menu` VALUES (13, 1004);
INSERT INTO `role_menu` VALUES (13, 1005);
INSERT INTO `role_menu` VALUES (13, 1006);
INSERT INTO `role_menu` VALUES (13, 1007);
INSERT INTO `role_menu` VALUES (13, 1008);
INSERT INTO `role_menu` VALUES (13, 1009);
INSERT INTO `role_menu` VALUES (13, 1010);
INSERT INTO `role_menu` VALUES (13, 1011);
INSERT INTO `role_menu` VALUES (13, 1012);
INSERT INTO `role_menu` VALUES (13, 1013);
INSERT INTO `role_menu` VALUES (13, 1014);
INSERT INTO `role_menu` VALUES (13, 1015);
INSERT INTO `role_menu` VALUES (13, 1016);
INSERT INTO `role_menu` VALUES (13, 2017);
INSERT INTO `role_menu` VALUES (13, 2018);
INSERT INTO `role_menu` VALUES (13, 2019);
INSERT INTO `role_menu` VALUES (13, 2021);
INSERT INTO `role_menu` VALUES (13, 2022);
INSERT INTO `role_menu` VALUES (13, 2023);
INSERT INTO `role_menu` VALUES (13, 2024);
INSERT INTO `role_menu` VALUES (13, 2025);
INSERT INTO `role_menu` VALUES (13, 2026);
INSERT INTO `role_menu` VALUES (13, 2027);
INSERT INTO `role_menu` VALUES (13, 2028);
INSERT INTO `role_menu` VALUES (18, 100);
INSERT INTO `role_menu` VALUES (18, 1001);
INSERT INTO `role_menu` VALUES (18, 1002);
INSERT INTO `role_menu` VALUES (18, 1003);
INSERT INTO `role_menu` VALUES (18, 1004);
INSERT INTO `role_menu` VALUES (19, 100);
INSERT INTO `role_menu` VALUES (19, 1001);
INSERT INTO `role_menu` VALUES (19, 1002);
INSERT INTO `role_menu` VALUES (19, 1003);
INSERT INTO `role_menu` VALUES (19, 1004);
INSERT INTO `role_menu` VALUES (20, 100);
INSERT INTO `role_menu` VALUES (20, 1001);
INSERT INTO `role_menu` VALUES (20, 1002);
INSERT INTO `role_menu` VALUES (20, 1003);
INSERT INTO `role_menu` VALUES (20, 1004);
INSERT INTO `role_menu` VALUES (21, 100);
INSERT INTO `role_menu` VALUES (21, 101);
INSERT INTO `role_menu` VALUES (21, 102);
INSERT INTO `role_menu` VALUES (21, 1001);
INSERT INTO `role_menu` VALUES (21, 1002);
INSERT INTO `role_menu` VALUES (21, 1003);
INSERT INTO `role_menu` VALUES (21, 1004);
INSERT INTO `role_menu` VALUES (21, 1008);
INSERT INTO `role_menu` VALUES (21, 1009);
INSERT INTO `role_menu` VALUES (21, 1010);
INSERT INTO `role_menu` VALUES (21, 1011);
INSERT INTO `role_menu` VALUES (21, 1013);
INSERT INTO `role_menu` VALUES (21, 1014);
INSERT INTO `role_menu` VALUES (21, 1015);
INSERT INTO `role_menu` VALUES (21, 1016);

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user`  (
  `userId` bigint NOT NULL AUTO_INCREMENT COMMENT '主键',
  `username` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL DEFAULT 'NULL' COMMENT '用户名',
  `password` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NOT NULL DEFAULT 'NULL' COMMENT '密码',
  `status` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT '0' COMMENT '账号状态（0正常 1停用）',
  `email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci  NULL DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`userId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci  COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES (2, 'zjz', '1234', '0', '123@qq.com', '13031939607');
INSERT INTO `sys_user` VALUES (3, 'hj', '1234', '0', '123@qq.com', '12121212112');
INSERT INTO `sys_user` VALUES (4, '张军钊', '123456', '0', '2718075060@qq.com', '13031939607');
INSERT INTO `sys_user` VALUES (11, '徒生安', 'wewee', '0', 'zhangcoder@foxmail.com', '130319396');
INSERT INTO `sys_user` VALUES (16, '撒贝宁', '1234567', '0', '2324@wew.com', '123432134');

-- ----------------------------
-- Table structure for user_roles
-- ----------------------------
DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles`  (
  `userId` bigint NOT NULL,
  `roleId` bigint NOT NULL,
  PRIMARY KEY (`userId`, `roleId`) USING BTREE,
  INDEX `role_id`(`roleId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_roles
-- ----------------------------
INSERT INTO `user_roles` VALUES (1, 1);
INSERT INTO `user_roles` VALUES (1, 2);
INSERT INTO `user_roles` VALUES (2, 2);
INSERT INTO `user_roles` VALUES (4, 2);
INSERT INTO `user_roles` VALUES (11, 2);
INSERT INTO `user_roles` VALUES (1, 3);
INSERT INTO `user_roles` VALUES (3, 3);
INSERT INTO `user_roles` VALUES (4, 3);
INSERT INTO `user_roles` VALUES (11, 20);
INSERT INTO `user_roles` VALUES (16, 20);

SET FOREIGN_KEY_CHECKS = 1;
