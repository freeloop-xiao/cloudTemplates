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
-- Table structure for tb_permession
-- ----------------------------
DROP TABLE IF EXISTS `tb_permession`;
CREATE TABLE `tb_permession` (
  `id` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '权限名字',
  `pm_type` varchar(100) DEFAULT NULL COMMENT '权限类型',
  `pm_resource` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '资源',
  `pm_explain` varchar(100) DEFAULT NULL COMMENT '权限说明',
  `app_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '应用id',
  `app_type` varchar(8) DEFAULT NULL COMMENT '应用类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(32) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Table structure for tb_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_role`;
CREATE TABLE `tb_role` (
  `id` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '角色id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '角色名称',
  `rl_explain` varchar(100) DEFAULT NULL COMMENT '角色说明',
  `rl_type` varchar(100) DEFAULT NULL COMMENT '角色说明',
  `app_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '应用id',
  `app_type` varchar(8) DEFAULT NULL COMMENT '应用类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(32) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Table structure for tb_role_permession
-- ----------------------------
DROP TABLE IF EXISTS `tb_role_permession`;
CREATE TABLE `tb_role_permession` (
  `id` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `role_id` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '角色id',
  `permission_id` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '角色id',
  `rp_explain` varchar(100) DEFAULT NULL COMMENT '说明',
  `app_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '应用id',
  `app_type` varchar(8) DEFAULT NULL COMMENT '应用类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(32) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限映射表';

-- ----------------------------
-- Table structure for tb_user
-- ----------------------------
DROP TABLE IF EXISTS `tb_user`;
CREATE TABLE `tb_user` (
  `tm_smp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  `id` varchar(18) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `name` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
  `u_alias` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户别名',
  `phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '手机号',
  `sex` smallint(6) DEFAULT NULL COMMENT '性别 0:女 1：男',
  `id_card_type` smallint(6) DEFAULT NULL COMMENT '证件类型',
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
  `app_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '应用id',
  `app_type` varchar(8) DEFAULT NULL COMMENT '应用类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `remark` varchar(32) DEFAULT NULL COMMENT '备用字段',
  `remark1` varchar(30) DEFAULT NULL COMMENT '备用字段1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `appid_phone_index` (`phone`,`app_id`),
  KEY `user_real_flag` (`real_flag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Table structure for tb_user_role
-- ----------------------------
DROP TABLE IF EXISTS `tb_user_role`;
CREATE TABLE `tb_user_role` (
  `id` varchar(12) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL COMMENT 'id',
  `user_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户id',
  `role_id` varchar(100) DEFAULT NULL COMMENT '角色id',
  `app_id` varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '应用id',
  `app_type` varchar(8) DEFAULT NULL COMMENT '应用类型',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色映射表';
