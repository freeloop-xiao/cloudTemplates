/*
Navicat MySQL Data Transfer

Source Server         : 本机数据库
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : auth
Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-01-24 17:37:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_permission`;
CREATE TABLE `sys_permission` (
  `permission_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '权限id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '权限名字',
  `type` varchar(64) DEFAULT NULL COMMENT '权限类型',
  `resource` varchar(64) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '资源',
  `permission_desc` varchar(100) DEFAULT NULL COMMENT '权限说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `del_flag` char(1) DEFAULT '0' COMMENT '0--正常 1--删除',
  `remark` varchar(32) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Table structure for sys_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '角色名称',
  `role_code` varchar(32) DEFAULT NULL COMMENT '角色编码',
  `role_desc` varchar(100) DEFAULT NULL COMMENT '角色说明',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `del_flag` char(1) COLLATE utf8mb4_bin DEFAULT '0' COMMENT '删除标识（0-正常,1-删除）',
  `remark` varchar(32) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for sys_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_permission`;
CREATE TABLE `sys_role_permission` (
  `role_id` int(11) NOT NULL COMMENT '角色id',
  `permission_id` int(11) NOT NULL COMMENT '权限id',
  PRIMARY KEY (`role_id`,`permission_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限映射表';

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `user_id` varchar(18) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `user_type` varchar(8) DEFAULT NULL COMMENT '用户类型',
  `user_alias` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户别名',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `sex` smallint(1) DEFAULT NULL COMMENT '性别 0:女 1：男',
  `id_card_type` smallint(2) DEFAULT NULL COMMENT '证件类型',
  `id_card_no` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '证件号码',
  `birthday` varchar(10) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户出生年月YYYY-MM-DD',
  `email` varchar(62) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱地址',
  `prov` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '省',
  `city` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '市',
  `area` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '区',
  `level` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户等级',
  `ref_id` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '推荐人id',
  `login_pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '登录密码',
  `login_salt` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '登录密码盐值',
  `hand_pwd` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '手势密码',
  `hand_salt` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '手势密码盐值',
  `head_url` varchar(100) DEFAULT NULL COMMENT '头像地址',
  `real_flag` smallint(6) DEFAULT NULL COMMENT '实名标识  0:未实名  1:实名',
  `lock_flag` smallint(6) DEFAULT NULL COMMENT '是否锁定 0：正常 1：锁定',
  `del_flag` char(1) DEFAULT '0' COMMENT '0--正常 1--删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `remark` varchar(32) DEFAULT NULL COMMENT '备用字段',
  `app_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '应用id',
  `remark1` varchar(30) DEFAULT NULL COMMENT '备用字段1',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `appId_phone_index` (`phone`,`app_id`),
  KEY `user_real_flag` (`real_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Table structure for sys_user_role
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_role`;
CREATE TABLE `sys_user_role` (
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户id',
  `role_id` int(11) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色映射表';
