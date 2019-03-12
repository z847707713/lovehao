/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 80013
 File Encoding         : 65001

 Date: 26/02/2019 18:25:08
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `permission` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `permission_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `parent` int(255) NULL DEFAULT NULL COMMENT '父权限',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求地址',
  `type` tinyint(255) NULL DEFAULT NULL COMMENT '0:菜单，1：按钮',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `create_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `update_user` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES (2, 'index:edit', '修改主页', '主页修改权限', 11, NULL, 1, '2019-01-23 11:47:27', NULL, '2019-02-18 10:42:46', 'zh');
INSERT INTO `permission` VALUES (3, 'index:delete', '删除主页', '主页删除权限', 11, NULL, 1, NULL, NULL, '2019-02-18 10:43:40', 'zh');
INSERT INTO `permission` VALUES (4, 'index:add', '主页新增', '主页新增权限', 11, NULL, 1, NULL, NULL, '2019-02-18 10:43:42', 'zh');
INSERT INTO `permission` VALUES (5, 'permission:view', '权限查看', '查看权限', 12, NULL, 1, '2019-02-18 10:32:41', 'zh', '2019-02-19 16:19:08', 'zh');
INSERT INTO `permission` VALUES (6, 'permission:edit', '权限修改', '修改权限', 12, NULL, 1, '2019-02-18 10:34:13', 'zh', '2019-02-19 16:19:16', 'zh');
INSERT INTO `permission` VALUES (7, 'permission:delete', '权限删除', '权限管理的删除权限', 12, NULL, 1, '2019-02-18 10:36:17', 'zh', '2019-02-19 16:29:34', 'zh');
INSERT INTO `permission` VALUES (8, 'permission:add', '权限新增', '新增权限', 12, NULL, 1, '2019-02-18 10:37:40', 'zh', '2019-02-18 10:42:55', 'zh');
INSERT INTO `permission` VALUES (10, 'index:view', '主页查看权限', '查看主页权限', 11, NULL, 1, '2019-02-19 16:15:16', 'zh', '2019-02-19 16:16:34', 'zh');
INSERT INTO `permission` VALUES (11, 'index', '主页菜单', '主页菜单', 0, '/', 0, '2019-02-26 10:18:40', 'zh', '2019-02-26 10:18:35', 'zh');
INSERT INTO `permission` VALUES (12, 'permission', '权限菜单', '权限菜单', 0, '/permissions', 0, '2019-02-26 10:19:28', 'zh', '2019-02-26 10:19:33', 'zh');
INSERT INTO `permission` VALUES (15, 'test01', '测试01', '测试数据01', 0, '/test01', 0, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `role_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_user` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `update_user` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'admin', '管理员', NULL, NULL, 'zh', '2019-02-18 08:42:11');
INSERT INTO `role` VALUES (3, 'user2', '普通用户2', 'zh', '2019-02-01 16:31:49', 'zh', '2019-02-01 16:31:49');
INSERT INTO `role` VALUES (4, 'user1', '角色1', 'zh', '2019-02-12 08:37:17', 'zh', '2019-02-12 08:37:17');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NULL DEFAULT NULL,
  `permission_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES (24, 1, 11);
INSERT INTO `role_permission` VALUES (25, 1, 2);
INSERT INTO `role_permission` VALUES (26, 1, 11);
INSERT INTO `role_permission` VALUES (27, 1, 2);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `delete_flag` tinyint(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'zh', '741a627471982d84d67177464d006a01', '\r\n\r\n\r\n847707713@qq.com', 0);
INSERT INTO `user` VALUES (2, 'zh2', '741a627471982d84d67177464d006a01', '\r\n\r\n\r\n847707713@qq.com', 0);
INSERT INTO `user` VALUES (3, 'zh3', '741a627471982d84d67177464d006a01', '\r\n\r\n\r\n847707713@qq.com', 0);
INSERT INTO `user` VALUES (4, 'zh4', '741a627471982d84d67177464d006a01', '\r\n\r\n\r\n847707713@qq.com', 0);
INSERT INTO `user` VALUES (5, 'zh5', '741a627471982d84d67177464d006a01', '\r\n\r\n\r\n847707713@qq.com', 0);
INSERT INTO `user` VALUES (6, 'zh6', '741a627471982d84d67177464d006a01', '\r\n\r\n\r\n847707713@qq.com', 0);
INSERT INTO `user` VALUES (7, 'zh7', '741a627471982d84d67177464d006a01', '847707713@qq.com', 0);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(255) NULL DEFAULT NULL,
  `role_id` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
