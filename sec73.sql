/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : sec

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2015-07-03 16:05:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `authorities`
-- ----------------------------
DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `authority_name` varchar(100) NOT NULL COMMENT '权限名称',
  `authority_code` varchar(200) NOT NULL COMMENT '权限编码',
  `remark` varchar(200) NOT NULL COMMENT '权限描述',
  `enable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可用 1是  0否',
  `is_sys` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否为系统权限 1是 0否',
  `creater` varchar(20) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifer` varchar(20) NOT NULL,
  `last_modify_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_idx` (`authority_code`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of authorities
-- ----------------------------
INSERT INTO `authorities` VALUES ('1', '导航栏', 'NAV', '菜单类型', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('2', '权限管理', 'AUTH-MANAGER', '一级菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('3', '菜单管理', 'MENU-MANAGER', '二级菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('4', '权限管理', 'AUTH-S-MANAGER', '权限管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('5', '资源管理', 'RESOURCE-MANAGER', '资源管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('6', '员工管理', 'EMPL-MANAGER', '员工管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('7', '会员管理', 'CUST-MANAGER', '会员管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('8', '进销库管理', 'PROD-MANAGER', '商品、其它用品信息管理模块', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('9', '考勤管理', 'CHECK-MANAGER', '考勤管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('10', '角色管理', 'ROLE-MANAGER', '角色管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('11', '用户组管理', 'GROUP-MANAGER', '用户组管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('12', '配置管理', 'CONFIG-MANAGER', '配置管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('13', '系统设置', 'SYS-CONFIG-MANAGER', '系统设置', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('14', '增加菜单', 'ADD-MENU', '增加菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('15', '增加权限', 'ADD-AUTH', '增加权限', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('16', '员工管理', 'EMPL-S-MANAGER', '员工基本信息管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('17', '会员管理', 'CUST-S-MANAGER', '会员信息管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('18', '商品管理', 'PROD-S-MANAGER', '商品管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('19', '修改菜单', 'MODIFY-MENU', '修改菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('20', '删除菜单', 'DELETE-MENU', '删除菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('21', '修改权限', 'MODIFY-AUTH', '修改权限', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('22', '删除权限', 'DELETE-AUTH', '删除权限', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('23', '增加资源', 'ADD-RESOURCE', '增加资源', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('24', '修改资源', 'MODIFY-RESOURCE', '修改资源', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('25', '删除资源', 'DELETE-RESOURCE', '删除资源', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('26', '增加角色', 'ADD-ROLE', '增加角色', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('27', '修改角色', 'MODIFY-ROLE', '修改角色', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('28', '删除角色', 'DELETE-ROLE', '删除角色', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('29', '用户管理', 'USER-MANAGER', '用户管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('30', '加载菜单', 'LOAD-MENU', '加载菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('31', '加载权限', 'LOAD-AUTHORITY', '加载权限', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('32', '加载资源', 'LOAD-RESOURCE', '加载资源', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('33', '加载角色', 'LOAD-ROLE', '加载角色', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('34', '加载用户组', 'LOAD-GROUP', '加载用户组', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('35', '加载用户', 'LOAD-USER', '加载用户', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('36', '访问权限', 'VISIT', '访问权限', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('37', '访问菜单', 'VISIT-MENU', '访问菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('38', '访问资源', 'VISIT-RESOURCE', '访问资源', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('39', '访问角色', 'VISIT-ROLE', '访问角色', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('40', '访问用户组', 'VISIT-GROUP', '访问用户组', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('41', '访问用户', 'VISIT-USER', '访问用户', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `authorities` VALUES ('64', '显示菜单', 'SHOW-MENU', '显示菜单', '1', '1', 'admin', '2015-05-26 23:10:39', 'admin', '2015-05-26 23:10:39');
INSERT INTO `authorities` VALUES ('65', '显示权限', 'SHOW-AUTH', '显示权限', '1', '1', 'admin', '2015-05-26 23:10:45', 'admin', '2015-05-26 23:10:45');
INSERT INTO `authorities` VALUES ('66', '显示资源', 'SHOW-RESOURCE', '显示资源', '1', '1', 'admin', '2015-05-26 23:10:48', 'admin', '2015-05-26 23:10:48');
INSERT INTO `authorities` VALUES ('67', '显示角色', 'SHOW-ROLE', '显示角色', '1', '1', 'admin', '2015-05-26 23:10:52', 'admin', '2015-05-26 23:10:52');
INSERT INTO `authorities` VALUES ('68', '显示用户组', 'SHOW-GROUP', '显示用户组', '1', '1', 'admin', '2015-05-26 23:10:56', 'admin', '2015-05-26 23:10:56');
INSERT INTO `authorities` VALUES ('69', '显示用户', 'SHOW-USER', '显示用户', '1', '1', 'admin', '2015-05-26 23:11:01', 'admin', '2015-05-26 23:11:01');
INSERT INTO `authorities` VALUES ('70', '增加用户组', 'ADD-GROUP', '增加用户组', '1', '1', 'admin', '2015-05-29 21:16:31', 'admin', '2015-05-29 21:16:31');
INSERT INTO `authorities` VALUES ('71', '删除用户组', 'DELETE-GROUP', '删除用户组', '1', '1', 'admin', '2015-05-29 21:16:36', 'admin', '2015-05-29 21:16:36');
INSERT INTO `authorities` VALUES ('72', '修改用户组', 'MODIFY-GROUP', '修改用户组', '1', '1', 'admin', '2015-05-29 21:16:40', 'admin', '2015-05-29 21:16:40');
INSERT INTO `authorities` VALUES ('73', '增加用户', 'ADD-USER', '增加用户', '1', '1', 'admin', '2015-05-29 21:16:44', 'admin', '2015-05-29 21:16:44');
INSERT INTO `authorities` VALUES ('74', '修改用户', 'MODIFY-USER', '修改用户', '1', '1', 'admin', '2015-05-29 21:16:47', 'admin', '2015-05-29 21:16:47');
INSERT INTO `authorities` VALUES ('75', '删除用户', 'DELETE-USER', '删除用户', '1', '1', 'admin', '2015-05-29 21:16:51', 'admin', '2015-05-29 21:16:51');

-- ----------------------------
-- Table structure for `authorities_resources`
-- ----------------------------
DROP TABLE IF EXISTS `authorities_resources`;
CREATE TABLE `authorities_resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `resourceId` bigint(20) DEFAULT NULL COMMENT '标识列',
  `authorityId` bigint(20) DEFAULT NULL COMMENT '标识列',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_7` (`resourceId`),
  KEY `FK_Reference_8` (`authorityId`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='权限、资源关系表';

-- ----------------------------
-- Records of authorities_resources
-- ----------------------------
INSERT INTO `authorities_resources` VALUES ('1', '2', '2');
INSERT INTO `authorities_resources` VALUES ('2', '3', '3');
INSERT INTO `authorities_resources` VALUES ('3', '4', '4');
INSERT INTO `authorities_resources` VALUES ('4', '5', '5');
INSERT INTO `authorities_resources` VALUES ('5', '6', '6');
INSERT INTO `authorities_resources` VALUES ('6', '7', '7');
INSERT INTO `authorities_resources` VALUES ('7', '8', '8');
INSERT INTO `authorities_resources` VALUES ('8', '9', '9');
INSERT INTO `authorities_resources` VALUES ('9', '10', '10');
INSERT INTO `authorities_resources` VALUES ('10', '11', '11');
INSERT INTO `authorities_resources` VALUES ('11', '12', '12');
INSERT INTO `authorities_resources` VALUES ('12', '13', '13');
INSERT INTO `authorities_resources` VALUES ('13', '14', '14');
INSERT INTO `authorities_resources` VALUES ('14', '15', '15');
INSERT INTO `authorities_resources` VALUES ('15', '6', '16');
INSERT INTO `authorities_resources` VALUES ('16', '7', '17');
INSERT INTO `authorities_resources` VALUES ('17', '18', '18');
INSERT INTO `authorities_resources` VALUES ('18', '19', '19');
INSERT INTO `authorities_resources` VALUES ('19', '20', '20');
INSERT INTO `authorities_resources` VALUES ('20', '21', '21');
INSERT INTO `authorities_resources` VALUES ('21', '22', '22');
INSERT INTO `authorities_resources` VALUES ('22', '23', '23');
INSERT INTO `authorities_resources` VALUES ('23', '24', '24');
INSERT INTO `authorities_resources` VALUES ('24', '25', '25');
INSERT INTO `authorities_resources` VALUES ('25', '26', '26');
INSERT INTO `authorities_resources` VALUES ('26', '27', '27');
INSERT INTO `authorities_resources` VALUES ('27', '28', '28');
INSERT INTO `authorities_resources` VALUES ('28', '29', '29');
INSERT INTO `authorities_resources` VALUES ('29', '30', '30');
INSERT INTO `authorities_resources` VALUES ('30', '31', '31');
INSERT INTO `authorities_resources` VALUES ('31', '32', '32');
INSERT INTO `authorities_resources` VALUES ('32', '33', '33');
INSERT INTO `authorities_resources` VALUES ('33', '34', '34');
INSERT INTO `authorities_resources` VALUES ('34', '35', '35');
INSERT INTO `authorities_resources` VALUES ('35', '36', '36');
INSERT INTO `authorities_resources` VALUES ('36', '37', '37');
INSERT INTO `authorities_resources` VALUES ('37', '38', '38');
INSERT INTO `authorities_resources` VALUES ('38', '39', '39');
INSERT INTO `authorities_resources` VALUES ('39', '40', '40');
INSERT INTO `authorities_resources` VALUES ('40', '41', '41');
INSERT INTO `authorities_resources` VALUES ('41', '64', '64');
INSERT INTO `authorities_resources` VALUES ('42', '65', '65');
INSERT INTO `authorities_resources` VALUES ('43', '66', '66');
INSERT INTO `authorities_resources` VALUES ('44', '67', '67');
INSERT INTO `authorities_resources` VALUES ('45', '68', '68');
INSERT INTO `authorities_resources` VALUES ('46', '69', '69');
INSERT INTO `authorities_resources` VALUES ('47', '70', '70');
INSERT INTO `authorities_resources` VALUES ('48', '71', '71');
INSERT INTO `authorities_resources` VALUES ('49', '72', '72');
INSERT INTO `authorities_resources` VALUES ('50', '73', '73');
INSERT INTO `authorities_resources` VALUES ('51', '74', '74');
INSERT INTO `authorities_resources` VALUES ('52', '75', '75');

-- ----------------------------
-- Table structure for `auth_res_group`
-- ----------------------------
DROP TABLE IF EXISTS `auth_res_group`;
CREATE TABLE `auth_res_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `group_name` varchar(50) NOT NULL COMMENT '组名称',
  `group_code` varchar(50) NOT NULL COMMENT '编码',
  `remark` varchar(200) NOT NULL COMMENT '权限描述',
  `enable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可用 1是  0否',
  `creater` varchar(20) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifer` varchar(20) NOT NULL,
  `last_modify_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auth_res_group
-- ----------------------------

-- ----------------------------
-- Table structure for `beauty_authority`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_authority`;
CREATE TABLE `beauty_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `authority_name` varchar(100) NOT NULL DEFAULT '' COMMENT '权限名称',
  `authority_code` varchar(200) NOT NULL DEFAULT '' COMMENT '权限编码',
  `group_id` bigint(20) NOT NULL COMMENT '组id',
  `group_name` varchar(50) NOT NULL DEFAULT '' COMMENT '组名称',
  `remark` varchar(200) NOT NULL DEFAULT '' COMMENT '权限描述',
  `enable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可用 1是  0否',
  `is_sys` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否为系统权限 1是 0否',
  `creater` varchar(20) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifer` varchar(20) NOT NULL,
  `last_modify_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_idx` (`authority_code`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of beauty_authority
-- ----------------------------
INSERT INTO `beauty_authority` VALUES ('1', '导航栏', 'NAV', '0', '', '菜单类型', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '1980-01-01 00:00:00');
INSERT INTO `beauty_authority` VALUES ('2', '权限管理', 'AUTH-MANAGER', '2', '权限组', '一级菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:03:14');
INSERT INTO `beauty_authority` VALUES ('3', '菜单管理', 'MENU-MANAGER', '1', '菜单组', '二级菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-10 21:30:42');
INSERT INTO `beauty_authority` VALUES ('4', '权限管理', 'AUTH-S-MANAGER', '2', '权限组', '权限管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:03:42');
INSERT INTO `beauty_authority` VALUES ('5', '资源管理', 'RESOURCE-MANAGER', '3', '资源组', '资源管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:04:42');
INSERT INTO `beauty_authority` VALUES ('6', '员工管理', 'EMPL-MANAGER', '9', '员工组', '员工管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:05:47');
INSERT INTO `beauty_authority` VALUES ('7', '会员管理', 'CUST-MANAGER', '9', '员工组', '会员管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:05:52');
INSERT INTO `beauty_authority` VALUES ('8', '进销库管理', 'PROD-MANAGER', '11', '进销存组', '商品、其它用品信息管理模块', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:06:54');
INSERT INTO `beauty_authority` VALUES ('9', '考勤管理', 'CHECK-MANAGER', '12', '考勤组', '考勤管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:06:57');
INSERT INTO `beauty_authority` VALUES ('10', '角色管理', 'ROLE-MANAGER', '4', '角色组', '角色管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:07:03');
INSERT INTO `beauty_authority` VALUES ('11', '用户组管理', 'GROUP-MANAGER', '6', '用户组组', '用户组管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:07:13');
INSERT INTO `beauty_authority` VALUES ('12', '配置管理', 'CONFIG-MANAGER', '13', '系统组', '配置管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:07:46');
INSERT INTO `beauty_authority` VALUES ('13', '系统设置', 'SYS-CONFIG-MANAGER', '13', '系统组', '系统设置', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:07:52');
INSERT INTO `beauty_authority` VALUES ('14', '增加菜单', 'ADD-MENU', '1', '菜单组', '增加菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:07:57');
INSERT INTO `beauty_authority` VALUES ('15', '增加权限', 'ADD-AUTH', '2', '权限组', '增加权限', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:08:01');
INSERT INTO `beauty_authority` VALUES ('16', '员工管理', 'EMPL-S-MANAGER', '9', '员工组', '员工基本信息管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:08:11');
INSERT INTO `beauty_authority` VALUES ('17', '会员管理', 'CUST-S-MANAGER', '10', '会员组', '会员信息管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:08:16');
INSERT INTO `beauty_authority` VALUES ('18', '商品管理', 'PROD-S-MANAGER', '11', '进销存组', '商品管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:08:24');
INSERT INTO `beauty_authority` VALUES ('19', '修改菜单', 'MODIFY-MENU', '1', '菜单组', '修改菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-10 21:30:49');
INSERT INTO `beauty_authority` VALUES ('20', '删除菜单', 'DELETE-MENU', '1', '菜单组', '删除菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:08:35');
INSERT INTO `beauty_authority` VALUES ('21', '修改权限', 'MODIFY-AUTH', '2', '权限组', '修改权限', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:08:41');
INSERT INTO `beauty_authority` VALUES ('22', '删除权限', 'DELETE-AUTH', '2', '权限组', '删除权限', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:08:45');
INSERT INTO `beauty_authority` VALUES ('23', '增加资源', 'ADD-RESOURCE', '3', '资源组', '增加资源', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:08:50');
INSERT INTO `beauty_authority` VALUES ('24', '修改资源', 'MODIFY-RESOURCE', '3', '资源组', '修改资源', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:08:54');
INSERT INTO `beauty_authority` VALUES ('25', '删除资源', 'DELETE-RESOURCE', '3', '资源组', '删除资源', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:08:59');
INSERT INTO `beauty_authority` VALUES ('26', '增加角色', 'ADD-ROLE', '4', '角色组', '增加角色', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:09:06');
INSERT INTO `beauty_authority` VALUES ('27', '修改角色', 'MODIFY-ROLE', '4', '角色组', '修改角色', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:09:11');
INSERT INTO `beauty_authority` VALUES ('28', '删除角色', 'DELETE-ROLE', '4', '角色组', '删除角色', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:09:17');
INSERT INTO `beauty_authority` VALUES ('29', '用户管理', 'USER-MANAGER', '5', '用户组', '用户管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:09:45');
INSERT INTO `beauty_authority` VALUES ('30', '加载菜单', 'LOAD-MENU', '1', '菜单组', '加载菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-10 21:30:53');
INSERT INTO `beauty_authority` VALUES ('31', '加载权限', 'LOAD-AUTHORITY', '2', '权限组', '加载权限', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:09:56');
INSERT INTO `beauty_authority` VALUES ('32', '加载资源', 'LOAD-RESOURCE', '3', '资源组', '加载资源', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:10:01');
INSERT INTO `beauty_authority` VALUES ('33', '加载角色', 'LOAD-ROLE', '4', '角色组', '加载角色', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:10:05');
INSERT INTO `beauty_authority` VALUES ('34', '加载用户组', 'LOAD-GROUP', '6', '用户组组', '加载用户组', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:10:12');
INSERT INTO `beauty_authority` VALUES ('35', '加载用户', 'LOAD-USER', '5', '用户组', '加载用户', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:10:17');
INSERT INTO `beauty_authority` VALUES ('36', '访问权限', 'VISIT', '13', '系统组', '访问权限', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:10:25');
INSERT INTO `beauty_authority` VALUES ('37', '访问菜单', 'VISIT-MENU', '1', '菜单组', '访问菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:10:31');
INSERT INTO `beauty_authority` VALUES ('38', '访问资源', 'VISIT-RESOURCE', '3', '资源组', '访问资源', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:10:35');
INSERT INTO `beauty_authority` VALUES ('39', '访问角色', 'VISIT-ROLE', '4', '角色组', '访问角色', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:10:41');
INSERT INTO `beauty_authority` VALUES ('40', '访问用户组', 'VISIT-GROUP', '6', '用户组组', '访问用户组', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:10:46');
INSERT INTO `beauty_authority` VALUES ('41', '访问用户', 'VISIT-USER', '5', '用户组', '访问用户', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-03 22:10:53');
INSERT INTO `beauty_authority` VALUES ('64', '显示菜单', 'SHOW-MENU', '1', '菜单组', '显示菜单', '1', '1', 'admin', '2015-05-26 23:10:39', 'admin', '2015-06-03 22:10:57');
INSERT INTO `beauty_authority` VALUES ('65', '显示权限', 'SHOW-AUTH', '2', '权限组', '显示权限', '1', '1', 'admin', '2015-05-26 23:10:45', 'admin', '2015-06-03 22:11:02');
INSERT INTO `beauty_authority` VALUES ('66', '显示资源', 'SHOW-RESOURCE', '3', '资源组', '显示资源', '1', '1', 'admin', '2015-05-26 23:10:48', 'admin', '2015-06-03 22:11:07');
INSERT INTO `beauty_authority` VALUES ('67', '显示角色', 'SHOW-ROLE', '4', '角色组', '显示角色', '1', '1', 'admin', '2015-05-26 23:10:52', 'admin', '2015-06-03 22:11:11');
INSERT INTO `beauty_authority` VALUES ('68', '显示用户组', 'SHOW-GROUP', '6', '用户组组', '显示用户组', '1', '1', 'admin', '2015-05-26 23:10:56', 'admin', '2015-06-03 22:11:15');
INSERT INTO `beauty_authority` VALUES ('69', '显示用户', 'SHOW-USER', '5', '用户组', '显示用户', '1', '1', 'admin', '2015-05-26 23:11:01', 'admin', '2015-06-03 22:11:20');
INSERT INTO `beauty_authority` VALUES ('70', '增加用户组', 'ADD-GROUP', '6', '用户组组', '增加用户组', '1', '1', 'admin', '2015-05-29 21:16:31', 'admin', '2015-06-03 22:11:24');
INSERT INTO `beauty_authority` VALUES ('71', '删除用户组', 'DELETE-GROUP', '6', '用户组组', '删除用户组', '1', '1', 'admin', '2015-05-29 21:16:36', 'admin', '2015-06-03 22:11:28');
INSERT INTO `beauty_authority` VALUES ('72', '修改用户组', 'MODIFY-GROUP', '6', '用户组组', '修改用户组', '1', '1', 'admin', '2015-05-29 21:16:40', 'admin', '2015-06-03 22:11:31');
INSERT INTO `beauty_authority` VALUES ('73', '增加用户', 'ADD-USER', '5', '用户组', '增加用户', '1', '1', 'admin', '2015-05-29 21:16:44', 'admin', '2015-06-03 22:11:37');
INSERT INTO `beauty_authority` VALUES ('74', '修改用户', 'MODIFY-USER', '5', '用户组', '修改用户', '1', '1', 'admin', '2015-05-29 21:16:47', 'admin', '2015-06-03 22:11:42');
INSERT INTO `beauty_authority` VALUES ('75', '删除用户', 'DELETE-USER', '5', '用户组', '删除用户', '1', '1', 'admin', '2015-05-29 21:16:51', 'admin', '2015-06-03 22:11:47');
INSERT INTO `beauty_authority` VALUES ('76', '资源-权限组管理', 'ARGROUP-MANAGER', '13', '系统组', '资源-权限组管理', '1', '1', 'admin', '2015-06-08 22:41:32', 'admin', '2015-06-08 23:14:41');

-- ----------------------------
-- Table structure for `beauty_authority_resource`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_authority_resource`;
CREATE TABLE `beauty_authority_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `resourceId` bigint(20) DEFAULT NULL COMMENT '标识列',
  `authorityId` bigint(20) DEFAULT NULL COMMENT '标识列',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_7` (`resourceId`),
  KEY `FK_Reference_8` (`authorityId`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8 COMMENT='权限、资源关系表';

-- ----------------------------
-- Records of beauty_authority_resource
-- ----------------------------
INSERT INTO `beauty_authority_resource` VALUES ('1', '2', '2');
INSERT INTO `beauty_authority_resource` VALUES ('2', '3', '3');
INSERT INTO `beauty_authority_resource` VALUES ('3', '4', '4');
INSERT INTO `beauty_authority_resource` VALUES ('4', '5', '5');
INSERT INTO `beauty_authority_resource` VALUES ('5', '6', '6');
INSERT INTO `beauty_authority_resource` VALUES ('6', '7', '7');
INSERT INTO `beauty_authority_resource` VALUES ('7', '8', '8');
INSERT INTO `beauty_authority_resource` VALUES ('8', '9', '9');
INSERT INTO `beauty_authority_resource` VALUES ('9', '10', '10');
INSERT INTO `beauty_authority_resource` VALUES ('10', '11', '11');
INSERT INTO `beauty_authority_resource` VALUES ('11', '12', '12');
INSERT INTO `beauty_authority_resource` VALUES ('12', '13', '13');
INSERT INTO `beauty_authority_resource` VALUES ('13', '14', '14');
INSERT INTO `beauty_authority_resource` VALUES ('14', '15', '15');
INSERT INTO `beauty_authority_resource` VALUES ('15', '6', '16');
INSERT INTO `beauty_authority_resource` VALUES ('16', '7', '17');
INSERT INTO `beauty_authority_resource` VALUES ('17', '18', '18');
INSERT INTO `beauty_authority_resource` VALUES ('18', '19', '19');
INSERT INTO `beauty_authority_resource` VALUES ('19', '20', '20');
INSERT INTO `beauty_authority_resource` VALUES ('20', '21', '21');
INSERT INTO `beauty_authority_resource` VALUES ('21', '22', '22');
INSERT INTO `beauty_authority_resource` VALUES ('22', '23', '23');
INSERT INTO `beauty_authority_resource` VALUES ('23', '24', '24');
INSERT INTO `beauty_authority_resource` VALUES ('24', '25', '25');
INSERT INTO `beauty_authority_resource` VALUES ('25', '26', '26');
INSERT INTO `beauty_authority_resource` VALUES ('26', '27', '27');
INSERT INTO `beauty_authority_resource` VALUES ('27', '28', '28');
INSERT INTO `beauty_authority_resource` VALUES ('28', '29', '29');
INSERT INTO `beauty_authority_resource` VALUES ('29', '30', '30');
INSERT INTO `beauty_authority_resource` VALUES ('30', '31', '31');
INSERT INTO `beauty_authority_resource` VALUES ('31', '32', '32');
INSERT INTO `beauty_authority_resource` VALUES ('32', '33', '33');
INSERT INTO `beauty_authority_resource` VALUES ('33', '34', '34');
INSERT INTO `beauty_authority_resource` VALUES ('34', '35', '35');
INSERT INTO `beauty_authority_resource` VALUES ('35', '36', '36');
INSERT INTO `beauty_authority_resource` VALUES ('36', '37', '37');
INSERT INTO `beauty_authority_resource` VALUES ('37', '38', '38');
INSERT INTO `beauty_authority_resource` VALUES ('38', '39', '39');
INSERT INTO `beauty_authority_resource` VALUES ('39', '40', '40');
INSERT INTO `beauty_authority_resource` VALUES ('40', '41', '41');
INSERT INTO `beauty_authority_resource` VALUES ('41', '64', '64');
INSERT INTO `beauty_authority_resource` VALUES ('42', '65', '65');
INSERT INTO `beauty_authority_resource` VALUES ('43', '66', '66');
INSERT INTO `beauty_authority_resource` VALUES ('44', '67', '67');
INSERT INTO `beauty_authority_resource` VALUES ('45', '68', '68');
INSERT INTO `beauty_authority_resource` VALUES ('46', '69', '69');
INSERT INTO `beauty_authority_resource` VALUES ('47', '70', '70');
INSERT INTO `beauty_authority_resource` VALUES ('48', '71', '71');
INSERT INTO `beauty_authority_resource` VALUES ('49', '72', '72');
INSERT INTO `beauty_authority_resource` VALUES ('50', '73', '73');
INSERT INTO `beauty_authority_resource` VALUES ('51', '74', '74');
INSERT INTO `beauty_authority_resource` VALUES ('52', '75', '75');
INSERT INTO `beauty_authority_resource` VALUES ('53', '76', '76');

-- ----------------------------
-- Table structure for `beauty_auth_res_group`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_auth_res_group`;
CREATE TABLE `beauty_auth_res_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `group_name` varchar(50) NOT NULL COMMENT '组名称',
  `group_code` varchar(50) NOT NULL COMMENT '编码',
  `remark` varchar(200) NOT NULL COMMENT '权限描述',
  `enable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可用 1是  0否',
  `creater` varchar(20) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifer` varchar(20) NOT NULL,
  `last_modify_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of beauty_auth_res_group
-- ----------------------------
INSERT INTO `beauty_auth_res_group` VALUES ('1', '菜单组', 'MENU-GP', '菜单部分权限组', '1', 'admin', '2015-06-03 21:35:37', 'admin', '2015-06-03 21:41:21');
INSERT INTO `beauty_auth_res_group` VALUES ('2', '权限组', 'AUTH-GP', '权限组', '1', 'admin', '2015-06-03 21:36:20', 'admin', '2015-06-03 21:41:24');
INSERT INTO `beauty_auth_res_group` VALUES ('3', '资源组', 'RESE-GP', '资源组', '1', 'admin', '2015-06-03 21:36:50', 'admin', '2015-06-03 21:41:26');
INSERT INTO `beauty_auth_res_group` VALUES ('4', '角色组', 'ROLE-GP', '角色组', '1', 'admin', '2015-06-03 21:37:09', 'admin', '2015-06-03 21:41:28');
INSERT INTO `beauty_auth_res_group` VALUES ('5', '用户组', 'USER-GP', '用户组', '1', 'admin', '2015-06-03 21:37:24', 'admin', '2015-06-03 21:41:30');
INSERT INTO `beauty_auth_res_group` VALUES ('6', '用户组组', 'USER-GROUP-GP', '用户组组', '1', 'admin', '2015-06-03 21:38:14', 'admin', '2015-06-03 21:41:31');
INSERT INTO `beauty_auth_res_group` VALUES ('7', '资源-权限组组', 'AUTH-RESE-GP', '资源-权限组组', '1', 'admin', '2015-06-03 21:38:48', 'admin', '2015-06-03 21:41:33');
INSERT INTO `beauty_auth_res_group` VALUES ('9', '员工组', 'EMP-GP', '员工组', '1', 'admin', '2015-06-03 22:05:17', 'admin', '2015-06-03 22:05:17');
INSERT INTO `beauty_auth_res_group` VALUES ('10', '会员组', 'CUST-GP', '会员组', '1', 'admin', '2015-06-03 22:05:38', 'admin', '2015-06-03 22:05:38');
INSERT INTO `beauty_auth_res_group` VALUES ('11', '进销存组', 'GOOD-GP', '进销存组', '1', 'admin', '2015-06-03 22:06:22', 'admin', '2015-06-03 22:06:22');
INSERT INTO `beauty_auth_res_group` VALUES ('12', '考勤组', 'CHECK-GP', '考勤组', '1', 'admin', '2015-06-03 22:06:44', 'admin', '2015-06-03 22:06:44');
INSERT INTO `beauty_auth_res_group` VALUES ('13', '系统组', 'SYS-GP', '系统组', '1', 'admin', '2015-06-03 22:07:37', 'admin', '2015-06-03 22:07:37');
INSERT INTO `beauty_auth_res_group` VALUES ('14', '导航组', 'NAV-GP', '导航组', '1', 'admin', '2015-06-10 21:24:28', 'admin', '2015-06-10 21:24:28');
INSERT INTO `beauty_auth_res_group` VALUES ('15', '导航-权限组', 'NAV-AUTH-GP', '导航-权限组', '1', 'admin', '2015-06-10 21:26:29', 'admin', '2015-06-10 21:26:29');
INSERT INTO `beauty_auth_res_group` VALUES ('16', '导航-员工组', 'NAV-EMP-GP', '导航-员工组', '1', 'admin', '2015-06-10 21:26:53', 'admin', '2015-06-10 21:26:53');
INSERT INTO `beauty_auth_res_group` VALUES ('17', '导航-会员组', 'NAV-VIP-GP', '导航-会员组', '1', 'admin', '2015-06-10 21:27:19', 'admin', '2015-06-10 21:27:19');
INSERT INTO `beauty_auth_res_group` VALUES ('18', '导航-商品组', 'NAV-PRO-GP', '导航-商品组', '1', 'admin', '2015-06-10 21:27:47', 'admin', '2015-06-10 21:27:47');
INSERT INTO `beauty_auth_res_group` VALUES ('19', '导航-考勤组', 'NAV-CHECK-GP', '导航-考勤组', '1', 'admin', '2015-06-10 21:28:15', 'admin', '2015-06-10 21:28:15');
INSERT INTO `beauty_auth_res_group` VALUES ('20', '导航-系统组', 'NAV-SYS-GP', '导航-系统组', '1', 'admin', '2015-06-10 21:28:47', 'admin', '2015-06-10 21:28:47');

-- ----------------------------
-- Table structure for `beauty_grid_config`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_grid_config`;
CREATE TABLE `beauty_grid_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL DEFAULT '''''' COMMENT '列名',
  `field` varchar(200) NOT NULL DEFAULT 'null' COMMENT '属性名',
  `width` int(200) NOT NULL DEFAULT '80' COMMENT '样式',
  `def1` varchar(200) NOT NULL DEFAULT '''''' COMMENT '预留字段1',
  `def2` varchar(200) NOT NULL DEFAULT '''''' COMMENT '预留字段2',
  `def3` varchar(200) NOT NULL DEFAULT '''''' COMMENT '预留字段3',
  `enable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可用 1是  0否',
  `creater` varchar(20) NOT NULL DEFAULT 'admin',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifer` varchar(20) NOT NULL DEFAULT 'admin',
  `last_modify_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表列配置表';

-- ----------------------------
-- Records of beauty_grid_config
-- ----------------------------

-- ----------------------------
-- Table structure for `beauty_group`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_group`;
CREATE TABLE `beauty_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `group_name` varchar(200) NOT NULL COMMENT '组名称',
  `group_code` varchar(200) NOT NULL COMMENT '编码',
  `remark` varchar(200) NOT NULL COMMENT '组描述',
  `enable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可用  1是  0否',
  `is_sys` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否系统组 1是  0否',
  `creater` varchar(20) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifer` varchar(20) NOT NULL,
  `last_modify_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_idx` (`group_code`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='用户组表';

-- ----------------------------
-- Records of beauty_group
-- ----------------------------
INSERT INTO `beauty_group` VALUES ('1', '管理组', 'group-manage', '管理组', '1', '1', 'admin', '2015-04-25 20:53:21', 'admin', '2015-06-09 23:08:54');

-- ----------------------------
-- Table structure for `beauty_group_role`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_group_role`;
CREATE TABLE `beauty_group_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleId` bigint(20) DEFAULT NULL COMMENT '标识列',
  `groupId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_3` (`groupId`),
  KEY `FK_Reference_4` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组、角色关系表';

-- ----------------------------
-- Records of beauty_group_role
-- ----------------------------

-- ----------------------------
-- Table structure for `beauty_resource`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_resource`;
CREATE TABLE `beauty_resource` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `resource_name` varchar(200) NOT NULL COMMENT '资源名称',
  `resource_code` varchar(200) NOT NULL COMMENT '编码',
  `resource_value` varchar(200) NOT NULL COMMENT '资源值',
  `type` int(11) NOT NULL DEFAULT '3' COMMENT '资源类型 1 url   2 method   3 menu',
  `parent_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '父节点',
  `group_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '组id',
  `group_name` varchar(50) NOT NULL DEFAULT '' COMMENT '组名称',
  `level` int(11) NOT NULL DEFAULT '-1' COMMENT '层级',
  `remark` varchar(200) NOT NULL COMMENT '资源描述',
  `is_sys` int(4) NOT NULL DEFAULT '0' COMMENT '是否系统资源  1是  0否',
  `enable` int(4) NOT NULL DEFAULT '1' COMMENT '是否可用  1是  0否',
  `creater` varchar(20) NOT NULL DEFAULT 'admin',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifer` varchar(20) NOT NULL DEFAULT 'admin',
  `last_modify_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_idx` (`resource_code`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of beauty_resource
-- ----------------------------
INSERT INTO `beauty_resource` VALUES ('1', '导航栏', 'NAV', '/', '3', '0', '-1', '', '1', '菜单类型', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-08 22:28:30');
INSERT INTO `beauty_resource` VALUES ('2', '权限管理', 'AUTH-MANAGER', '/', '3', '1', '14', '导航组', '2', '一级菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-10 21:31:53');
INSERT INTO `beauty_resource` VALUES ('3', '菜单管理', 'MENU-MANAGER', '/common/forward/security.iframe-menus-list.action', '3', '2', '15', '导航-权限组', '3', '二级菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-10 21:32:22');
INSERT INTO `beauty_resource` VALUES ('4', '权限管理', 'AUTH-S-MANAGER', '/common/forward/security.iframe-authorities-list.action', '3', '2', '15', '导航-权限组', '3', '权限管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-10 21:32:27');
INSERT INTO `beauty_resource` VALUES ('5', '资源管理', 'RESOURCE-MANAGER', '/common/forward/security.iframe-resources-list.action', '3', '2', '15', '导航-权限组', '3', '资源管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-10 21:32:31');
INSERT INTO `beauty_resource` VALUES ('6', '员工管理', 'EMPL-MANAGER', 'www', '3', '1', '14', '导航组', '2', '员工管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-10 21:31:59');
INSERT INTO `beauty_resource` VALUES ('7', '会员管理', 'CUST-MANAGER', 'www', '3', '1', '14', '导航组', '2', '会员管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-10 21:32:03');
INSERT INTO `beauty_resource` VALUES ('8', '进销库管理', 'PROD-MANAGER', 'www', '3', '1', '14', '导航组', '2', '商品、其它用品信息管理模块', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-10 21:32:07');
INSERT INTO `beauty_resource` VALUES ('9', '考勤管理', 'CHECK-MANAGER', 'www', '3', '1', '14', '导航组', '2', '考勤管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-06-10 21:32:12');
INSERT INTO `beauty_resource` VALUES ('10', '角色管理', 'ROLE-MANAGER', '/common/forward/security.iframe-roles-list.action', '3', '2', '15', '导航-权限组', '3', '角色管理', '1', '1', 'admin', '2015-04-25 16:39:14', 'admin', '2015-06-10 21:32:35');
INSERT INTO `beauty_resource` VALUES ('11', '用户组管理', 'GROUP-MANAGER', '/common/forward/security.iframe-groups-list.action', '3', '2', '15', '导航-权限组', '3', '用户组管理', '1', '1', 'admin', '2015-04-25 16:39:38', 'admin', '2015-06-10 21:32:38');
INSERT INTO `beauty_resource` VALUES ('12', '配置管理', 'CONFIG-MANAGER', 'www', '3', '13', '20', '导航-系统组', '3', '配置管理', '1', '1', 'admin', '2015-04-25 20:56:00', 'admin', '2015-06-10 21:33:17');
INSERT INTO `beauty_resource` VALUES ('13', '系统设置', 'SYS-CONFIG-MANAGER', 'www', '3', '1', '14', '导航组', '2', '系统设置', '1', '1', 'admin', '2015-04-25 20:56:33', 'admin', '2015-06-10 21:32:16');
INSERT INTO `beauty_resource` VALUES ('14', '增加菜单', 'ADD-MENU', '/resource/insert.action', '1', '-1', '1', '菜单组', '-1', '增加菜单', '1', '1', 'admin', '2015-04-26 17:57:02', 'admin', '2015-06-03 23:04:30');
INSERT INTO `beauty_resource` VALUES ('15', '增加权限', 'ADD-AUTH', '/authority/insert.action', '1', '-1', '2', '权限组', '-1', '增加权限', '1', '1', 'admin', '2015-04-26 17:57:20', 'admin', '2015-06-03 23:04:35');
INSERT INTO `beauty_resource` VALUES ('16', '员工管理', 'EMPL-S-MANAGER', 'www', '3', '6', '16', '导航-员工组', '1', '员工基本信息管理', '1', '1', 'admin', '2015-05-10 15:03:44', 'admin', '2015-06-10 21:33:02');
INSERT INTO `beauty_resource` VALUES ('17', '会员管理', 'CUST-S-MANAGER', 'www', '3', '7', '17', '导航-会员组', '3', '会员信息管理', '1', '1', 'admin', '2015-05-10 19:46:49', 'admin', '2015-06-10 21:32:48');
INSERT INTO `beauty_resource` VALUES ('18', '商品管理', 'PROD-S-MANAGER', 'www', '3', '8', '18', '导航-商品组', '3', '商品管理', '1', '1', 'admin', '2015-05-10 20:38:05', 'admin', '2015-06-10 21:33:12');
INSERT INTO `beauty_resource` VALUES ('19', '修改菜单', 'MODIFY-MENU', '/resource/modify.action', '1', '-1', '1', '菜单组', '-1', '修改菜单', '1', '1', 'admin', '2015-05-16 17:06:16', 'admin', '2015-06-03 23:04:39');
INSERT INTO `beauty_resource` VALUES ('20', '删除菜单', 'DELETE-MENU', '/resource/deletes.action', '1', '-1', '1', '菜单组', '-1', '删除菜单', '1', '1', 'admin', '2015-05-16 17:07:15', 'admin', '2015-06-03 23:04:46');
INSERT INTO `beauty_resource` VALUES ('21', '修改权限', 'MODIFY-AUTH', '/authority/modify.action', '1', '-1', '2', '权限组', '-1', '修改权限', '1', '1', 'admin', '2015-05-16 21:13:53', 'admin', '2015-06-03 23:04:49');
INSERT INTO `beauty_resource` VALUES ('22', '删除权限', 'DELETE-AUTH', '/authority/delete.action', '1', '-1', '2', '权限组', '-1', '删除权限', '1', '1', 'admin', '2015-05-16 21:15:57', 'admin', '2015-06-03 23:04:53');
INSERT INTO `beauty_resource` VALUES ('23', '增加资源', 'ADD-RESOURCE', '/resource/insert.action', '1', '-1', '3', '资源组', '-1', '增加资源', '1', '1', 'admin', '2015-05-16 21:16:55', 'admin', '2015-06-03 23:04:57');
INSERT INTO `beauty_resource` VALUES ('24', '修改资源', 'MODIFY-RESOURCE', '/resource/modify.action', '1', '-1', '3', '资源组', '-1', '修改资源', '1', '1', 'admin', '2015-05-16 21:17:34', 'admin', '2015-06-03 23:05:09');
INSERT INTO `beauty_resource` VALUES ('25', '删除资源', 'DELETE-RESOURCE', '/resource/deletes.action', '1', '-1', '3', '资源组', '-1', '删除资源', '1', '1', 'admin', '2015-05-16 21:18:38', 'admin', '2015-06-03 23:05:15');
INSERT INTO `beauty_resource` VALUES ('26', '增加角色', 'ADD-ROLE', '/role/insert.action', '1', '-1', '4', '角色组', '-1', '增加角色', '1', '1', 'admin', '2015-05-16 21:24:33', 'admin', '2015-06-03 23:05:19');
INSERT INTO `beauty_resource` VALUES ('27', '修改角色', 'MODIFY-ROLE', '/role/modify.action', '1', '-1', '4', '角色组', '-1', '修改角色', '1', '1', 'admin', '2015-05-16 21:24:56', 'admin', '2015-06-03 23:05:23');
INSERT INTO `beauty_resource` VALUES ('28', '删除角色', 'DELETE-ROLE', '/role/delete.action', '1', '-1', '4', '角色组', '-1', '删除角色', '1', '1', 'admin', '2015-05-16 21:25:17', 'admin', '2015-06-03 23:05:28');
INSERT INTO `beauty_resource` VALUES ('29', '用户管理', 'USER-MANAGER', '/common/forward/security.iframe-users-list.action', '3', '13', '20', '导航-系统组', '3', '用户管理', '1', '1', 'admin', '2015-05-18 20:21:45', 'admin', '2015-06-10 21:33:20');
INSERT INTO `beauty_resource` VALUES ('30', '加载菜单', 'LOAD-MENU', '/resource/load/menu.action', '1', '-1', '1', '菜单组', '-1', '加载菜单', '1', '1', 'admin', '2015-05-23 14:56:23', 'admin', '2015-06-03 23:05:32');
INSERT INTO `beauty_resource` VALUES ('31', '加载权限', 'LOAD-AUTHORITY', '/authority/query/page.action', '1', '-1', '2', '权限组', '-1', '加载权限', '1', '1', 'admin', '2015-05-23 14:57:54', 'admin', '2015-06-03 23:05:36');
INSERT INTO `beauty_resource` VALUES ('32', '加载资源', 'LOAD-RESOURCE', '/resource/query/page.action', '1', '-1', '3', '资源组', '-1', '加载资源', '1', '1', 'admin', '2015-05-23 14:58:33', 'admin', '2015-06-03 23:05:41');
INSERT INTO `beauty_resource` VALUES ('33', '加载角色', 'LOAD-ROLE', '/role/query/page.action', '1', '-1', '4', '角色组', '-1', '加载角色', '1', '1', 'admin', '2015-05-23 14:59:30', 'admin', '2015-06-03 23:05:45');
INSERT INTO `beauty_resource` VALUES ('34', '加载用户组', 'LOAD-GROUP', '/group/query/page.action', '1', '-1', '6', '用户组组', '-1', '加载用户组', '1', '1', 'admin', '2015-05-23 15:11:44', 'admin', '2015-06-03 23:05:50');
INSERT INTO `beauty_resource` VALUES ('35', '加载用户', 'LOAD-USER', '/user/query/page.action', '1', '-1', '5', '用户组', '-1', '加载用户', '1', '1', 'admin', '2015-05-23 15:12:16', 'admin', '2015-06-03 23:05:56');
INSERT INTO `beauty_resource` VALUES ('36', '访问权限', 'VISIT', '/common/forward/index.action', '1', '-1', '2', '权限组', '-1', '访问权限', '1', '1', 'admin', '2015-05-26 20:43:29', 'admin', '2015-06-03 23:06:00');
INSERT INTO `beauty_resource` VALUES ('37', '访问菜单', 'VISIT-MENU', '/common/forward/security.iframe-menus-list.action', '1', '-1', '1', '菜单组', '-1', '访问菜单', '1', '1', 'admin', '2015-05-26 20:46:44', 'admin', '2015-06-03 23:06:07');
INSERT INTO `beauty_resource` VALUES ('38', '访问资源', 'VISIT-RESOURCE', '/common/forward/security.iframe-resources-list.action', '1', '-1', '3', '资源组', '-1', '访问资源', '1', '1', 'admin', '2015-05-26 20:50:29', 'admin', '2015-06-03 23:06:11');
INSERT INTO `beauty_resource` VALUES ('39', '访问角色', 'VISIT-ROLE', '/common/forward/security.iframe-roles-list.action', '1', '-1', '4', '角色组', '-1', '访问角色', '1', '1', 'admin', '2015-05-26 20:51:03', 'admin', '2015-06-03 23:06:17');
INSERT INTO `beauty_resource` VALUES ('40', '访问用户组', 'VISIT-GROUP', '/common/forward/security.iframe-groups-list.action', '1', '-1', '6', '用户组组', '-1', '访问用户组', '1', '1', 'admin', '2015-05-26 20:51:39', 'admin', '2015-06-03 23:06:22');
INSERT INTO `beauty_resource` VALUES ('41', '访问用户', 'VISIT-USER', '/common/forward/security.iframe-users-list.action', '1', '-1', '5', '用户组', '-1', '访问用户', '1', '1', 'admin', '2015-05-26 20:52:19', 'admin', '2015-06-03 23:06:25');
INSERT INTO `beauty_resource` VALUES ('64', '显示菜单', 'SHOW-MENU', '/resource/query/page.action', '1', '-1', '1', '菜单组', '-1', '显示菜单', '1', '1', 'admin', '2015-05-26 22:36:56', 'admin', '2015-06-03 23:06:29');
INSERT INTO `beauty_resource` VALUES ('65', '显示权限', 'SHOW-AUTH', '/authority/query/page.action', '1', '-1', '2', '权限组', '-1', '显示权限', '1', '1', 'admin', '2015-05-26 22:37:48', 'admin', '2015-06-03 23:06:34');
INSERT INTO `beauty_resource` VALUES ('66', '显示资源', 'SHOW-RESOURCE', '/resource/query/page.action', '1', '-1', '3', '资源组', '-1', '显示资源', '1', '1', 'admin', '2015-05-26 22:38:32', 'admin', '2015-06-03 23:06:38');
INSERT INTO `beauty_resource` VALUES ('67', '显示角色', 'SHOW-ROLE', '/role/query/page.action', '1', '-1', '4', '角色组', '-1', '显示角色', '1', '1', 'admin', '2015-05-26 22:39:03', 'admin', '2015-06-03 23:06:42');
INSERT INTO `beauty_resource` VALUES ('68', '显示用户组', 'SHOW-GROUP', '/group/query/page.action', '1', '-1', '6', '用户组组', '-1', '显示用户组', '1', '1', 'admin', '2015-05-26 22:39:31', 'admin', '2015-06-03 23:06:49');
INSERT INTO `beauty_resource` VALUES ('69', '显示用户', 'SHOW-USER', '/user/query/page.action', '1', '-1', '5', '用户组', '-1', '显示用户', '1', '1', 'admin', '2015-05-26 22:39:57', 'admin', '2015-06-03 23:06:52');
INSERT INTO `beauty_resource` VALUES ('70', '增加用户组', 'ADD-GROUP', '/group/insert.action', '1', '-1', '6', '用户组组', '-1', '增加用户组', '1', '1', 'admin', '2015-05-29 21:11:38', 'admin', '2015-06-03 23:06:57');
INSERT INTO `beauty_resource` VALUES ('71', '删除用户组', 'DELETE-GROUP', '/group/delete.action', '1', '-1', '6', '用户组组', '-1', '删除用户组', '1', '1', 'admin', '2015-05-29 21:12:09', 'admin', '2015-06-03 23:07:02');
INSERT INTO `beauty_resource` VALUES ('72', '修改用户组', 'MODIFY-GROUP', '/group/modify.action', '1', '-1', '6', '用户组组', '-1', '修改用户组', '1', '1', 'admin', '2015-05-29 21:12:30', 'admin', '2015-06-03 23:07:06');
INSERT INTO `beauty_resource` VALUES ('73', '增加用户', 'ADD-USER', '/user/insert.action', '1', '-1', '5', '用户组', '-1', '增加用户', '1', '1', 'admin', '2015-05-29 21:12:57', 'admin', '2015-06-03 23:07:11');
INSERT INTO `beauty_resource` VALUES ('74', '修改用户', 'MODIFY-USER', '/user/modify.action', '1', '-1', '5', '用户组', '-1', '修改用户', '1', '1', 'admin', '2015-05-29 21:13:14', 'admin', '2015-06-03 23:07:15');
INSERT INTO `beauty_resource` VALUES ('75', '删除用户', 'DELETE-USER', '/user/delete.action', '1', '-1', '5', '用户组', '-1', '删除用户', '1', '1', 'admin', '2015-05-29 21:13:57', 'admin', '2015-06-03 23:07:19');
INSERT INTO `beauty_resource` VALUES ('76', '资源-权限组管理', 'ARGROUP-MANAGER', '/common/forward/security.iframe-argroups-list.action', '3', '13', '20', '导航-系统组', '3', '资源-权限组管理', '1', '1', 'admin', '2015-06-08 22:40:20', 'admin', '2015-06-10 21:33:24');
INSERT INTO `beauty_resource` VALUES ('77', '资源-权限增加', 'ADD-RE-AUTH', '/argroup/insert.action', '1', '-1', '13', '系统组', '-1', '资源-权限增加', '1', '1', 'admin', '2015-06-14 13:18:13', 'admin', '2015-06-14 13:18:13');

-- ----------------------------
-- Table structure for `beauty_resource1`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_resource1`;
CREATE TABLE `beauty_resource1` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `resource_name` varchar(200) NOT NULL COMMENT '资源名称',
  `resource_code` varchar(200) NOT NULL COMMENT '编码',
  `resource_value` varchar(200) NOT NULL COMMENT '资源值',
  `type` int(11) NOT NULL DEFAULT '3' COMMENT '资源类型 1 url   2 method   3 menu',
  `parent_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '父节点',
  `group_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '组id',
  `group_name` varchar(50) NOT NULL DEFAULT '' COMMENT '组名称',
  `level` int(11) NOT NULL DEFAULT '-1' COMMENT '层级',
  `remark` varchar(200) NOT NULL COMMENT '资源描述',
  `is_sys` int(4) NOT NULL DEFAULT '0' COMMENT '是否系统资源  1是  0否',
  `enable` int(4) NOT NULL DEFAULT '1' COMMENT '是否可用  1是  0否',
  `creater` varchar(20) NOT NULL DEFAULT 'admin',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifer` varchar(20) NOT NULL DEFAULT 'admin',
  `last_modify_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_idx` (`resource_code`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of beauty_resource1
-- ----------------------------
INSERT INTO `beauty_resource1` VALUES ('1', '导航栏', 'NAV', '/', '3', '0', '0', '', '1', '菜单类型', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-24 17:55:13');
INSERT INTO `beauty_resource1` VALUES ('2', '权限管理', 'AUTH-MANAGER', '/', '3', '1', '0', '', '2', '一级菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-23 16:10:57');
INSERT INTO `beauty_resource1` VALUES ('3', '菜单管理', 'MENU-MANAGER', '/common/forward/security.iframe-menus-list.action', '3', '2', '0', '', '3', '二级菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-23 16:07:01');
INSERT INTO `beauty_resource1` VALUES ('4', '权限管理', 'AUTH-S-MANAGER', '/common/forward/security.iframe-authorities-list.action', '3', '2', '0', '', '3', '权限管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-23 16:08:35');
INSERT INTO `beauty_resource1` VALUES ('5', '资源管理', 'RESOURCE-MANAGER', '/common/forward/security.iframe-resources-list.action', '3', '2', '0', '', '3', '资源管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-23 16:07:25');
INSERT INTO `beauty_resource1` VALUES ('6', '员工管理', 'EMPL-MANAGER', 'www', '3', '1', '0', '', '2', '员工管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-23 16:10:50');
INSERT INTO `beauty_resource1` VALUES ('7', '会员管理', 'CUST-MANAGER', 'www', '3', '1', '0', '', '2', '会员管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-23 16:10:46');
INSERT INTO `beauty_resource1` VALUES ('8', '进销库管理', 'PROD-MANAGER', 'www', '3', '1', '0', '', '2', '商品、其它用品信息管理模块', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-23 16:10:41');
INSERT INTO `beauty_resource1` VALUES ('9', '考勤管理', 'CHECK-MANAGER', 'www', '3', '1', '0', '', '2', '考勤管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-23 16:10:37');
INSERT INTO `beauty_resource1` VALUES ('19', '角色管理', 'ROLE-MANAGER', '/common/forward/security.iframe-roles-list.action', '3', '2', '0', '', '3', '角色管理', '1', '1', 'admin', '2015-04-25 16:39:14', 'admin', '2015-05-23 16:07:34');
INSERT INTO `beauty_resource1` VALUES ('20', '用户组管理', 'GROUP-MANAGER', '/common/forward/security.iframe-groups-list.action', '3', '2', '0', '', '3', '用户组管理', '1', '1', 'admin', '2015-04-25 16:39:38', 'admin', '2015-05-23 16:07:45');
INSERT INTO `beauty_resource1` VALUES ('21', '配置管理', 'CONFIG-MANAGER', 'www', '3', '22', '0', '', '3', '配置管理', '1', '1', 'admin', '2015-04-25 20:56:00', 'admin', '2015-05-23 16:09:47');
INSERT INTO `beauty_resource1` VALUES ('22', '系统设置', 'SYS-CONFIG-MANAGER', 'www', '3', '1', '0', '', '2', '系统设置', '1', '1', 'admin', '2015-04-25 20:56:33', 'admin', '2015-05-23 16:10:32');
INSERT INTO `beauty_resource1` VALUES ('28', '增加菜单', 'ADD-MENU', '/resource/insert.action', '1', '-1', '1', '菜单组', '-1', '增加菜单', '1', '1', 'admin', '2015-04-26 17:57:02', 'admin', '2015-06-03 22:23:13');
INSERT INTO `beauty_resource1` VALUES ('29', '增加权限', 'ADD-AUTH', '/authority/insert.action', '1', '-1', '2', '权限组', '-1', '增加权限', '1', '1', 'admin', '2015-04-26 17:57:20', 'admin', '2015-06-03 22:23:51');
INSERT INTO `beauty_resource1` VALUES ('48', '员工管理', 'EMPL-S-MANAGER', 'www', '3', '6', '0', '', '1', '员工基本信息管理', '1', '1', 'admin', '2015-05-10 15:03:44', 'admin', '2015-05-23 16:08:18');
INSERT INTO `beauty_resource1` VALUES ('49', '会员管理', 'CUST-S-MANAGER', 'www', '3', '7', '0', '', '3', '会员信息管理', '1', '1', 'admin', '2015-05-10 19:46:49', 'admin', '2015-05-23 16:09:23');
INSERT INTO `beauty_resource1` VALUES ('51', '商品管理', 'PROD-S-MANAGER', 'www', '3', '8', '0', '', '3', '商品管理', '1', '1', 'admin', '2015-05-10 20:38:05', 'admin', '2015-05-23 16:09:36');
INSERT INTO `beauty_resource1` VALUES ('53', '修改菜单', 'MODIFY-MENU', '/resource/modify.action', '1', '-1', '1', '菜单组', '-1', '修改菜单', '1', '1', 'admin', '2015-05-16 17:06:16', 'admin', '2015-06-03 22:23:57');
INSERT INTO `beauty_resource1` VALUES ('54', '删除菜单', 'DELETE-MENU', '/resource/deletes.action', '1', '-1', '1', '菜单组', '-1', '删除菜单', '1', '1', 'admin', '2015-05-16 17:07:15', 'admin', '2015-06-03 22:24:06');
INSERT INTO `beauty_resource1` VALUES ('55', '修改权限', 'MODIFY-AUTH', '/authority/modify.action', '1', '-1', '2', '权限组', '-1', '修改权限', '1', '1', 'admin', '2015-05-16 21:13:53', 'admin', '2015-06-03 22:24:10');
INSERT INTO `beauty_resource1` VALUES ('56', '删除权限', 'DELETE-AUTH', '/authority/delete.action', '1', '-1', '2', '权限组', '-1', '删除权限', '1', '1', 'admin', '2015-05-16 21:15:57', 'admin', '2015-06-03 22:24:15');
INSERT INTO `beauty_resource1` VALUES ('57', '增加资源', 'ADD-RESOURCE', '/resource/insert.action', '1', '-1', '3', '资源组', '-1', '增加资源', '1', '1', 'admin', '2015-05-16 21:16:55', 'admin', '2015-06-03 22:24:22');
INSERT INTO `beauty_resource1` VALUES ('58', '修改资源', 'MODIFY-RESOURCE', '/resource/modify.action', '1', '-1', '3', '资源组', '-1', '修改资源', '1', '1', 'admin', '2015-05-16 21:17:34', 'admin', '2015-06-03 22:24:28');
INSERT INTO `beauty_resource1` VALUES ('59', '删除资源', 'DELETE-RESOURCE', '/resource/deletes.action', '1', '-1', '3', '资源组', '-1', '删除资源', '1', '1', 'admin', '2015-05-16 21:18:38', 'admin', '2015-06-03 22:24:32');
INSERT INTO `beauty_resource1` VALUES ('60', '增加角色', 'ADD-ROLE', '/role/insert.action', '1', '-1', '4', '角色组', '-1', '增加角色', '1', '1', 'admin', '2015-05-16 21:24:33', 'admin', '2015-06-03 22:24:36');
INSERT INTO `beauty_resource1` VALUES ('61', '修改角色', 'MODIFY-ROLE', '/role/modify.action', '1', '-1', '4', '角色组', '-1', '修改角色', '1', '1', 'admin', '2015-05-16 21:24:56', 'admin', '2015-06-03 22:24:41');
INSERT INTO `beauty_resource1` VALUES ('62', '删除角色', 'DELETE-ROLE', '/role/delete.action', '1', '-1', '4', '角色组', '-1', '删除角色', '1', '1', 'admin', '2015-05-16 21:25:17', 'admin', '2015-06-03 22:24:45');
INSERT INTO `beauty_resource1` VALUES ('63', '用户管理', 'USER-MANAGER', '/common/forward/security.iframe-users-list.action', '3', '22', '0', '', '3', '用户管理', '1', '1', 'admin', '2015-05-18 20:21:45', 'admin', '2015-05-23 16:10:20');
INSERT INTO `beauty_resource1` VALUES ('64', '加载菜单', 'LOAD-MENU', '/resource/load/menu.action', '1', '-1', '1', '菜单组', '-1', '加载菜单', '1', '1', 'admin', '2015-05-23 14:56:23', 'admin', '2015-06-03 22:24:50');
INSERT INTO `beauty_resource1` VALUES ('65', '加载权限', 'LOAD-AUTHORITY', '/authority/query/page.action', '1', '-1', '2', '权限组', '-1', '加载权限', '1', '1', 'admin', '2015-05-23 14:57:54', 'admin', '2015-06-03 22:24:55');
INSERT INTO `beauty_resource1` VALUES ('66', '加载资源', 'LOAD-RESOURCE', '/resource/query/page.action', '1', '-1', '3', '资源组', '-1', '加载资源', '1', '1', 'admin', '2015-05-23 14:58:33', 'admin', '2015-06-03 22:25:00');
INSERT INTO `beauty_resource1` VALUES ('67', '加载角色', 'LOAD-ROLE', '/role/query/page.action', '1', '-1', '4', '角色组', '-1', '加载角色', '1', '1', 'admin', '2015-05-23 14:59:30', 'admin', '2015-06-03 22:25:03');
INSERT INTO `beauty_resource1` VALUES ('68', '加载用户组', 'LOAD-GROUP', '/group/query/page.action', '1', '-1', '6', '用户组组', '-1', '加载用户组', '1', '1', 'admin', '2015-05-23 15:11:44', 'admin', '2015-06-03 22:25:08');
INSERT INTO `beauty_resource1` VALUES ('69', '加载用户', 'LOAD-USER', '/user/query/page.action', '1', '-1', '5', '用户组', '-1', '加载用户', '1', '1', 'admin', '2015-05-23 15:12:16', 'admin', '2015-06-03 22:25:12');
INSERT INTO `beauty_resource1` VALUES ('70', '访问权限', 'VISIT', '/common/forward/index.action', '1', '-1', '2', '权限组', '-1', '访问权限', '1', '1', 'admin', '2015-05-26 20:43:29', 'admin', '2015-06-03 22:25:17');
INSERT INTO `beauty_resource1` VALUES ('71', '访问菜单', 'VISIT-MENU', '/common/forward/security.iframe-menus-list.action', '1', '-1', '1', '菜单组', '-1', '访问菜单', '1', '1', 'admin', '2015-05-26 20:46:44', 'admin', '2015-06-03 22:25:21');
INSERT INTO `beauty_resource1` VALUES ('72', '访问资源', 'VISIT-RESOURCE', '/common/forward/security.iframe-resources-list.action', '1', '-1', '3', '资源组', '-1', '访问资源', '1', '1', 'admin', '2015-05-26 20:50:29', 'admin', '2015-06-03 22:25:28');
INSERT INTO `beauty_resource1` VALUES ('73', '访问角色', 'VISIT-ROLE', '/common/forward/security.iframe-roles-list.action', '1', '-1', '4', '角色组', '-1', '访问角色', '1', '1', 'admin', '2015-05-26 20:51:03', 'admin', '2015-06-03 22:25:34');
INSERT INTO `beauty_resource1` VALUES ('74', '访问用户组', 'VISIT-GROUP', '/common/forward/security.iframe-groups-list.action', '1', '-1', '6', '用户组组', '-1', '访问用户组', '1', '1', 'admin', '2015-05-26 20:51:39', 'admin', '2015-06-03 22:25:40');
INSERT INTO `beauty_resource1` VALUES ('75', '访问用户', 'VISIT-USER', '/common/forward/security.iframe-users-list.action', '1', '-1', '5', '用户组', '-1', '访问用户', '1', '1', 'admin', '2015-05-26 20:52:19', 'admin', '2015-06-03 22:25:48');
INSERT INTO `beauty_resource1` VALUES ('76', '资源-权限组管理', 'ARGROUP-MANAGER', '/common/forward/security.iframe-argroups-list.action', '3', '2', '-1', '', '3', '资源-权限组管理', '1', '1', 'admin', '2015-06-03 21:12:34', 'admin', '2015-06-03 21:13:11');

-- ----------------------------
-- Table structure for `beauty_role`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_role`;
CREATE TABLE `beauty_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `role_code` varchar(200) NOT NULL COMMENT '编码',
  `remark` varchar(200) NOT NULL COMMENT '角色描述',
  `enable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可用  1是  0否',
  `is_sys` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否系统角色  1是  0否',
  `creater` varchar(20) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifer` varchar(20) NOT NULL,
  `last_modify_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_idx` (`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of beauty_role
-- ----------------------------
INSERT INTO `beauty_role` VALUES ('1', '超级管理员', 'ADMIN', '超级管理员', '1', '1', 'admin', '2015-04-25 17:36:21', 'admin', '2015-05-18 21:40:43');
INSERT INTO `beauty_role` VALUES ('3', '普通业务员', 'SCOTT', '普通业务员', '1', '0', 'admin', '2015-04-25 17:38:01', 'admin', '2015-05-16 16:49:45');

-- ----------------------------
-- Table structure for `beauty_role_authority`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_role_authority`;
CREATE TABLE `beauty_role_authority` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleId` bigint(20) NOT NULL COMMENT '标识列',
  `authorityId` bigint(20) NOT NULL COMMENT '标识列',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_5` (`roleId`),
  KEY `FK_Reference_6` (`authorityId`)
) ENGINE=InnoDB AUTO_INCREMENT=337 DEFAULT CHARSET=utf8 COMMENT='角色、权限关系表';

-- ----------------------------
-- Records of beauty_role_authority
-- ----------------------------
INSERT INTO `beauty_role_authority` VALUES ('209', '3', '4');
INSERT INTO `beauty_role_authority` VALUES ('210', '3', '1');
INSERT INTO `beauty_role_authority` VALUES ('211', '3', '2');
INSERT INTO `beauty_role_authority` VALUES ('212', '3', '30');
INSERT INTO `beauty_role_authority` VALUES ('213', '3', '31');
INSERT INTO `beauty_role_authority` VALUES ('214', '3', '32');
INSERT INTO `beauty_role_authority` VALUES ('215', '3', '33');
INSERT INTO `beauty_role_authority` VALUES ('216', '3', '34');
INSERT INTO `beauty_role_authority` VALUES ('217', '3', '35');
INSERT INTO `beauty_role_authority` VALUES ('218', '3', '36');
INSERT INTO `beauty_role_authority` VALUES ('219', '3', '37');
INSERT INTO `beauty_role_authority` VALUES ('220', '3', '38');
INSERT INTO `beauty_role_authority` VALUES ('221', '3', '39');
INSERT INTO `beauty_role_authority` VALUES ('222', '3', '40');
INSERT INTO `beauty_role_authority` VALUES ('223', '3', '41');
INSERT INTO `beauty_role_authority` VALUES ('224', '3', '64');
INSERT INTO `beauty_role_authority` VALUES ('225', '3', '65');
INSERT INTO `beauty_role_authority` VALUES ('226', '3', '66');
INSERT INTO `beauty_role_authority` VALUES ('227', '3', '67');
INSERT INTO `beauty_role_authority` VALUES ('228', '3', '68');
INSERT INTO `beauty_role_authority` VALUES ('229', '3', '69');
INSERT INTO `beauty_role_authority` VALUES ('283', '1', '76');
INSERT INTO `beauty_role_authority` VALUES ('284', '1', '1');
INSERT INTO `beauty_role_authority` VALUES ('285', '1', '2');
INSERT INTO `beauty_role_authority` VALUES ('286', '1', '3');
INSERT INTO `beauty_role_authority` VALUES ('287', '1', '4');
INSERT INTO `beauty_role_authority` VALUES ('288', '1', '5');
INSERT INTO `beauty_role_authority` VALUES ('289', '1', '6');
INSERT INTO `beauty_role_authority` VALUES ('290', '1', '7');
INSERT INTO `beauty_role_authority` VALUES ('291', '1', '8');
INSERT INTO `beauty_role_authority` VALUES ('292', '1', '9');
INSERT INTO `beauty_role_authority` VALUES ('293', '1', '10');
INSERT INTO `beauty_role_authority` VALUES ('294', '1', '11');
INSERT INTO `beauty_role_authority` VALUES ('295', '1', '12');
INSERT INTO `beauty_role_authority` VALUES ('296', '1', '13');
INSERT INTO `beauty_role_authority` VALUES ('297', '1', '14');
INSERT INTO `beauty_role_authority` VALUES ('298', '1', '15');
INSERT INTO `beauty_role_authority` VALUES ('299', '1', '16');
INSERT INTO `beauty_role_authority` VALUES ('300', '1', '17');
INSERT INTO `beauty_role_authority` VALUES ('301', '1', '18');
INSERT INTO `beauty_role_authority` VALUES ('302', '1', '19');
INSERT INTO `beauty_role_authority` VALUES ('303', '1', '20');
INSERT INTO `beauty_role_authority` VALUES ('304', '1', '21');
INSERT INTO `beauty_role_authority` VALUES ('305', '1', '22');
INSERT INTO `beauty_role_authority` VALUES ('306', '1', '23');
INSERT INTO `beauty_role_authority` VALUES ('307', '1', '24');
INSERT INTO `beauty_role_authority` VALUES ('308', '1', '25');
INSERT INTO `beauty_role_authority` VALUES ('309', '1', '26');
INSERT INTO `beauty_role_authority` VALUES ('310', '1', '27');
INSERT INTO `beauty_role_authority` VALUES ('311', '1', '28');
INSERT INTO `beauty_role_authority` VALUES ('312', '1', '29');
INSERT INTO `beauty_role_authority` VALUES ('313', '1', '30');
INSERT INTO `beauty_role_authority` VALUES ('314', '1', '31');
INSERT INTO `beauty_role_authority` VALUES ('315', '1', '32');
INSERT INTO `beauty_role_authority` VALUES ('316', '1', '33');
INSERT INTO `beauty_role_authority` VALUES ('317', '1', '34');
INSERT INTO `beauty_role_authority` VALUES ('318', '1', '35');
INSERT INTO `beauty_role_authority` VALUES ('319', '1', '36');
INSERT INTO `beauty_role_authority` VALUES ('320', '1', '37');
INSERT INTO `beauty_role_authority` VALUES ('321', '1', '38');
INSERT INTO `beauty_role_authority` VALUES ('322', '1', '39');
INSERT INTO `beauty_role_authority` VALUES ('323', '1', '40');
INSERT INTO `beauty_role_authority` VALUES ('324', '1', '41');
INSERT INTO `beauty_role_authority` VALUES ('325', '1', '64');
INSERT INTO `beauty_role_authority` VALUES ('326', '1', '65');
INSERT INTO `beauty_role_authority` VALUES ('327', '1', '66');
INSERT INTO `beauty_role_authority` VALUES ('328', '1', '67');
INSERT INTO `beauty_role_authority` VALUES ('329', '1', '68');
INSERT INTO `beauty_role_authority` VALUES ('330', '1', '69');
INSERT INTO `beauty_role_authority` VALUES ('331', '1', '70');
INSERT INTO `beauty_role_authority` VALUES ('332', '1', '71');
INSERT INTO `beauty_role_authority` VALUES ('333', '1', '72');
INSERT INTO `beauty_role_authority` VALUES ('334', '1', '73');
INSERT INTO `beauty_role_authority` VALUES ('335', '1', '74');
INSERT INTO `beauty_role_authority` VALUES ('336', '1', '75');

-- ----------------------------
-- Table structure for `beauty_user`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_user`;
CREATE TABLE `beauty_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `usercode` varchar(200) NOT NULL COMMENT '用户编码',
  `password` varchar(50) NOT NULL COMMENT '登陆密码',
  `enable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可用 1是 0否',
  `remark` varchar(200) NOT NULL COMMENT '描述',
  `is_sys` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否是超级管理员 0否  1是',
  `creater` varchar(20) NOT NULL DEFAULT 'admin',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifer` varchar(20) NOT NULL DEFAULT 'admin',
  `last_modify_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_idx` (`usercode`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of beauty_user
-- ----------------------------
INSERT INTO `beauty_user` VALUES ('1', 'admin', 'admin', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '管理员', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-18 21:41:27');
INSERT INTO `beauty_user` VALUES ('2', 'frinder', 'frinder', '4QrcOUm6Wau+VuBX8g+IPg==', '1', '管理员', '1', 'admin', '2015-05-18 21:49:25', 'admin', '2015-05-18 21:49:25');

-- ----------------------------
-- Table structure for `beauty_user_group`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_user_group`;
CREATE TABLE `beauty_user_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `userId` bigint(20) NOT NULL COMMENT '用户id',
  `groupId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_fk_groupId` (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户、组关系表';

-- ----------------------------
-- Records of beauty_user_group
-- ----------------------------

-- ----------------------------
-- Table structure for `beauty_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `beauty_user_role`;
CREATE TABLE `beauty_user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL COMMENT '标识列',
  `roleId` bigint(20) DEFAULT NULL COMMENT '标识列',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_10` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户、角色关系表';

-- ----------------------------
-- Records of beauty_user_role
-- ----------------------------
INSERT INTO `beauty_user_role` VALUES ('4', '1', '1');
INSERT INTO `beauty_user_role` VALUES ('7', '2', '3');

-- ----------------------------
-- Table structure for `groups`
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `group_name` varchar(200) NOT NULL COMMENT '组名称',
  `group_code` varchar(200) NOT NULL COMMENT '编码',
  `remark` varchar(200) NOT NULL COMMENT '组描述',
  `enable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可用  1是  0否',
  `is_sys` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否系统组 1是  0否',
  `creater` varchar(20) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifer` varchar(20) NOT NULL,
  `last_modify_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_idx` (`group_code`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户组表';

-- ----------------------------
-- Records of groups
-- ----------------------------
INSERT INTO `groups` VALUES ('1', '管理组', '2', '管理组', '1', '1', 'admin', '2015-04-25 20:53:21', 'admin', '2015-04-25 20:53:21');
INSERT INTO `groups` VALUES ('3', '2', '3', '2', '1', '0', 'admin', '2015-05-11 23:12:34', 'admin', '2015-05-11 23:13:17');
INSERT INTO `groups` VALUES ('4', '1', '1', '1', '1', '0', 'admin', '2015-05-24 17:58:22', 'admin', '2015-05-24 21:40:35');

-- ----------------------------
-- Table structure for `group_role`
-- ----------------------------
DROP TABLE IF EXISTS `group_role`;
CREATE TABLE `group_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleId` bigint(20) DEFAULT NULL COMMENT '标识列',
  `groupId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_3` (`groupId`),
  KEY `FK_Reference_4` (`roleId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组、角色关系表';

-- ----------------------------
-- Records of group_role
-- ----------------------------

-- ----------------------------
-- Table structure for `persistent_logins`
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------

-- ----------------------------
-- Table structure for `resources`
-- ----------------------------
DROP TABLE IF EXISTS `resources`;
CREATE TABLE `resources` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `resource_name` varchar(200) NOT NULL COMMENT '资源名称',
  `resource_code` varchar(200) NOT NULL COMMENT '编码',
  `resource_value` varchar(200) NOT NULL COMMENT '资源值',
  `type` int(11) NOT NULL DEFAULT '3' COMMENT '资源类型 1 url   2 method   3 menu',
  `parent_id` bigint(20) NOT NULL DEFAULT '-1' COMMENT '父节点',
  `priority` int(11) NOT NULL DEFAULT '0' COMMENT '优先级',
  `level` int(11) NOT NULL DEFAULT '-1' COMMENT '层级',
  `remark` varchar(200) NOT NULL COMMENT '资源描述',
  `is_sys` int(4) NOT NULL DEFAULT '0' COMMENT '是否系统资源  1是  0否',
  `enable` int(4) NOT NULL DEFAULT '1' COMMENT '是否可用  1是  0否',
  `creater` varchar(20) NOT NULL DEFAULT 'admin',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifer` varchar(20) NOT NULL DEFAULT 'admin',
  `last_modify_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_idx` (`resource_code`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8 COMMENT='资源表';

-- ----------------------------
-- Records of resources
-- ----------------------------
INSERT INTO `resources` VALUES ('1', '导航栏', 'NAV', '/', '3', '0', '0', '1', '菜单类型', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-29 22:45:19');
INSERT INTO `resources` VALUES ('2', '权限管理', 'AUTH-MANAGER', '/', '3', '1', '0', '2', '一级菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-23 16:10:57');
INSERT INTO `resources` VALUES ('3', '菜单管理', 'MENU-MANAGER', '/common/forward/security.iframe-menus-list.action', '3', '2', '0', '3', '二级菜单', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-23 16:07:01');
INSERT INTO `resources` VALUES ('4', '权限管理', 'AUTH-S-MANAGER', '/common/forward/security.iframe-authorities-list.action', '3', '2', '0', '3', '权限管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-23 16:08:35');
INSERT INTO `resources` VALUES ('5', '资源管理', 'RESOURCE-MANAGER', '/common/forward/security.iframe-resources-list.action', '3', '2', '0', '3', '资源管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-23 16:07:25');
INSERT INTO `resources` VALUES ('6', '员工管理', 'EMPL-MANAGER', 'www', '3', '1', '0', '2', '员工管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-23 16:10:50');
INSERT INTO `resources` VALUES ('7', '会员管理', 'CUST-MANAGER', 'www', '3', '1', '0', '2', '会员管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-23 16:10:46');
INSERT INTO `resources` VALUES ('8', '进销库管理', 'PROD-MANAGER', 'www', '3', '1', '0', '2', '商品、其它用品信息管理模块', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-23 16:10:41');
INSERT INTO `resources` VALUES ('9', '考勤管理', 'CHECK-MANAGER', 'www', '3', '1', '0', '2', '考勤管理', '1', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-23 16:10:37');
INSERT INTO `resources` VALUES ('10', '角色管理', 'ROLE-MANAGER', '/common/forward/security.iframe-roles-list.action', '3', '2', '0', '3', '角色管理', '1', '1', 'admin', '2015-04-25 16:39:14', 'admin', '2015-05-23 16:07:34');
INSERT INTO `resources` VALUES ('11', '用户组管理', 'GROUP-MANAGER', '/common/forward/security.iframe-groups-list.action', '3', '2', '0', '3', '用户组管理', '1', '1', 'admin', '2015-04-25 16:39:38', 'admin', '2015-05-23 16:07:45');
INSERT INTO `resources` VALUES ('12', '配置管理', 'CONFIG-MANAGER', 'www', '3', '13', '0', '3', '配置管理', '1', '1', 'admin', '2015-04-25 20:56:00', 'admin', '2015-05-26 21:48:47');
INSERT INTO `resources` VALUES ('13', '系统设置', 'SYS-CONFIG-MANAGER', 'www', '3', '1', '0', '2', '系统设置', '1', '1', 'admin', '2015-04-25 20:56:33', 'admin', '2015-05-23 16:10:32');
INSERT INTO `resources` VALUES ('14', '增加菜单', 'ADD-MENU', '/resource/insert.action', '1', '-1', '0', '-1', '增加菜单', '1', '1', 'admin', '2015-04-26 17:57:02', 'admin', '2015-05-26 21:07:24');
INSERT INTO `resources` VALUES ('15', '增加权限', 'ADD-AUTH', '/authority/insert.action', '1', '-1', '0', '-1', '增加权限', '1', '1', 'admin', '2015-04-26 17:57:20', 'admin', '2015-05-26 21:07:33');
INSERT INTO `resources` VALUES ('16', '员工管理', 'EMPL-S-MANAGER', 'www', '3', '6', '0', '1', '员工基本信息管理', '1', '1', 'admin', '2015-05-10 15:03:44', 'admin', '2015-05-23 16:08:18');
INSERT INTO `resources` VALUES ('17', '会员管理', 'CUST-S-MANAGER', 'www', '3', '7', '0', '3', '会员信息管理', '1', '1', 'admin', '2015-05-10 19:46:49', 'admin', '2015-05-23 16:09:23');
INSERT INTO `resources` VALUES ('18', '商品管理', 'PROD-S-MANAGER', 'www', '3', '8', '0', '3', '商品管理', '1', '1', 'admin', '2015-05-10 20:38:05', 'admin', '2015-05-23 16:09:36');
INSERT INTO `resources` VALUES ('19', '修改菜单', 'MODIFY-MENU', '/resource/modify.action', '1', '-1', '0', '-1', '修改菜单', '1', '1', 'admin', '2015-05-16 17:06:16', 'admin', '2015-05-16 17:06:16');
INSERT INTO `resources` VALUES ('20', '删除菜单', 'DELETE-MENU', '/resource/deletes.action', '1', '-1', '0', '-1', '删除菜单', '1', '1', 'admin', '2015-05-16 17:07:15', 'admin', '2015-05-16 17:07:15');
INSERT INTO `resources` VALUES ('21', '修改权限', 'MODIFY-AUTH', '/authority/modify.action', '1', '-1', '0', '-1', '修改权限', '1', '1', 'admin', '2015-05-16 21:13:53', 'admin', '2015-05-16 21:13:53');
INSERT INTO `resources` VALUES ('22', '删除权限', 'DELETE-AUTH', '/authority/delete.action', '1', '-1', '0', '-1', '删除权限', '1', '1', 'admin', '2015-05-16 21:15:57', 'admin', '2015-05-16 21:16:11');
INSERT INTO `resources` VALUES ('23', '增加资源', 'ADD-RESOURCE', '/resource/insert.action', '1', '-1', '0', '-1', '增加资源', '1', '1', 'admin', '2015-05-16 21:16:55', 'admin', '2015-05-16 21:17:08');
INSERT INTO `resources` VALUES ('24', '修改资源', 'MODIFY-RESOURCE', '/resource/modify.action', '1', '-1', '0', '-1', '修改资源', '1', '1', 'admin', '2015-05-16 21:17:34', 'admin', '2015-05-16 23:51:51');
INSERT INTO `resources` VALUES ('25', '删除资源', 'DELETE-RESOURCE', '/resource/deletes.action', '1', '-1', '0', '-1', '删除资源', '1', '1', 'admin', '2015-05-16 21:18:38', 'admin', '2015-05-16 23:52:00');
INSERT INTO `resources` VALUES ('26', '增加角色', 'ADD-ROLE', '/role/insert.action', '1', '-1', '0', '-1', '增加角色', '1', '1', 'admin', '2015-05-16 21:24:33', 'admin', '2015-05-16 21:25:51');
INSERT INTO `resources` VALUES ('27', '修改角色', 'MODIFY-ROLE', '/role/modify.action', '1', '-1', '0', '-1', '修改角色', '1', '1', 'admin', '2015-05-16 21:24:56', 'admin', '2015-05-16 21:26:07');
INSERT INTO `resources` VALUES ('28', '删除角色', 'DELETE-ROLE', '/role/delete.action', '1', '-1', '0', '-1', '删除角色', '1', '1', 'admin', '2015-05-16 21:25:17', 'admin', '2015-05-16 21:26:16');
INSERT INTO `resources` VALUES ('29', '用户管理', 'USER-MANAGER', '/common/forward/security.iframe-users-list.action', '3', '13', '0', '3', '用户管理', '1', '1', 'admin', '2015-05-18 20:21:45', 'admin', '2015-05-26 21:48:54');
INSERT INTO `resources` VALUES ('30', '加载菜单', 'LOAD-MENU', '/resource/load/menu.action', '1', '-1', '0', '-1', '加载菜单', '1', '1', 'admin', '2015-05-23 14:56:23', 'admin', '2015-05-23 14:56:23');
INSERT INTO `resources` VALUES ('31', '加载权限', 'LOAD-AUTHORITY', '/authority/query/page.action', '1', '-1', '0', '-1', '加载权限', '1', '1', 'admin', '2015-05-23 14:57:54', 'admin', '2015-05-23 14:57:54');
INSERT INTO `resources` VALUES ('32', '加载资源', 'LOAD-RESOURCE', '/resource/query/page.action', '1', '-1', '0', '-1', '加载资源', '1', '1', 'admin', '2015-05-23 14:58:33', 'admin', '2015-05-23 14:58:33');
INSERT INTO `resources` VALUES ('33', '加载角色', 'LOAD-ROLE', '/role/query/page.action', '1', '-1', '0', '-1', '加载角色', '1', '1', 'admin', '2015-05-23 14:59:30', 'admin', '2015-05-23 14:59:30');
INSERT INTO `resources` VALUES ('34', '加载用户组', 'LOAD-GROUP', '/group/query/page.action', '1', '-1', '0', '-1', '加载用户组', '1', '1', 'admin', '2015-05-23 15:11:44', 'admin', '2015-05-23 15:11:44');
INSERT INTO `resources` VALUES ('35', '加载用户', 'LOAD-USER', '/user/query/page.action', '1', '-1', '0', '-1', '加载用户', '1', '1', 'admin', '2015-05-23 15:12:16', 'admin', '2015-05-23 15:12:16');
INSERT INTO `resources` VALUES ('36', '访问权限', 'VISIT', '/common/forward/index.action', '1', '-1', '0', '-1', '访问权限', '1', '1', 'admin', '2015-05-26 20:43:29', 'admin', '2015-05-26 20:43:29');
INSERT INTO `resources` VALUES ('37', '访问菜单', 'VISIT-MENU', '/common/forward/security.iframe-menus-list.action', '1', '-1', '0', '-1', '访问菜单', '1', '1', 'admin', '2015-05-26 20:46:44', 'admin', '2015-05-26 20:52:48');
INSERT INTO `resources` VALUES ('38', '访问资源', 'VISIT-RESOURCE', '/common/forward/security.iframe-resources-list.action', '1', '-1', '0', '-1', '访问资源', '1', '1', 'admin', '2015-05-26 20:50:29', 'admin', '2015-05-26 20:52:57');
INSERT INTO `resources` VALUES ('39', '访问角色', 'VISIT-ROLE', '/common/forward/security.iframe-roles-list.action', '1', '-1', '0', '-1', '访问角色', '1', '1', 'admin', '2015-05-26 20:51:03', 'admin', '2015-05-26 20:53:01');
INSERT INTO `resources` VALUES ('40', '访问用户组', 'VISIT-GROUP', '/common/forward/security.iframe-groups-list.action', '1', '-1', '0', '-1', '访问用户组', '1', '1', 'admin', '2015-05-26 20:51:39', 'admin', '2015-05-26 20:53:07');
INSERT INTO `resources` VALUES ('41', '访问用户', 'VISIT-USER', '/common/forward/security.iframe-users-list.action', '1', '-1', '0', '-1', '访问用户', '1', '1', 'admin', '2015-05-26 20:52:19', 'admin', '2015-05-26 20:53:12');
INSERT INTO `resources` VALUES ('64', '显示菜单', 'SHOW-MENU', '/resource/query/page.action', '1', '-1', '0', '-1', '显示菜单', '1', '1', 'admin', '2015-05-26 22:36:56', 'admin', '2015-05-27 20:53:54');
INSERT INTO `resources` VALUES ('65', '显示权限', 'SHOW-AUTH', '/authority/query/page.action', '1', '-1', '0', '-1', '显示权限', '1', '1', 'admin', '2015-05-26 22:37:48', 'admin', '2015-05-26 22:37:48');
INSERT INTO `resources` VALUES ('66', '显示资源', 'SHOW-RESOURCE', '/resource/query/page.action', '1', '-1', '0', '-1', '显示资源', '1', '1', 'admin', '2015-05-26 22:38:32', 'admin', '2015-05-26 22:38:32');
INSERT INTO `resources` VALUES ('67', '显示角色', 'SHOW-ROLE', '/role/query/page.action', '1', '-1', '0', '-1', '显示角色', '1', '1', 'admin', '2015-05-26 22:39:03', 'admin', '2015-05-26 22:39:03');
INSERT INTO `resources` VALUES ('68', '显示用户组', 'SHOW-GROUP', '/group/query/page.action', '1', '-1', '0', '-1', '显示用户组', '1', '1', 'admin', '2015-05-26 22:39:31', 'admin', '2015-05-26 22:39:31');
INSERT INTO `resources` VALUES ('69', '显示用户', 'SHOW-USER', '/user/query/page.action', '1', '-1', '0', '-1', '显示用户', '1', '1', 'admin', '2015-05-26 22:39:57', 'admin', '2015-05-26 22:39:57');
INSERT INTO `resources` VALUES ('70', '增加用户组', 'ADD-GROUP', '/group/insert.action', '1', '-1', '0', '-1', '增加用户组', '1', '1', 'admin', '2015-05-29 21:11:38', 'admin', '2015-05-29 21:14:28');
INSERT INTO `resources` VALUES ('71', '删除用户组', 'DELETE-GROUP', '/group/delete.action', '1', '-1', '0', '-1', '删除用户组', '1', '1', 'admin', '2015-05-29 21:12:09', 'admin', '2015-05-29 21:15:22');
INSERT INTO `resources` VALUES ('72', '修改用户组', 'MODIFY-GROUP', '/group/modify.action', '1', '-1', '0', '-1', '修改用户组', '1', '1', 'admin', '2015-05-29 21:12:30', 'admin', '2015-05-29 21:15:00');
INSERT INTO `resources` VALUES ('73', '增加用户', 'ADD-USER', '/user/insert.action', '1', '-1', '0', '-1', '增加用户', '1', '1', 'admin', '2015-05-29 21:12:57', 'admin', '2015-05-29 21:15:40');
INSERT INTO `resources` VALUES ('74', '修改用户', 'MODIFY-USER', '/user/modify.action', '1', '-1', '0', '-1', '修改用户', '1', '1', 'admin', '2015-05-29 21:13:14', 'admin', '2015-05-29 21:15:56');
INSERT INTO `resources` VALUES ('75', '删除用户', 'DELETE-USER', '/user/delete.action', '1', '-1', '0', '-1', '删除用户', '1', '1', 'admin', '2015-05-29 21:13:57', 'admin', '2015-05-29 21:16:13');

-- ----------------------------
-- Table structure for `roles`
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `role_name` varchar(100) NOT NULL COMMENT '角色名称',
  `role_code` varchar(200) NOT NULL COMMENT '编码',
  `remark` varchar(200) NOT NULL COMMENT '角色描述',
  `enable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可用  1是  0否',
  `is_sys` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否系统角色  1是  0否',
  `creater` varchar(20) NOT NULL DEFAULT '',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifer` varchar(20) NOT NULL,
  `last_modify_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_idx` (`role_code`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='角色表';

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', '超级管理员', 'ADMIN', '超级管理员', '1', '1', 'admin', '2015-04-25 17:36:21', 'admin', '2015-05-18 21:40:43');
INSERT INTO `roles` VALUES ('3', '普通业务员', 'SCOTT', '普通业务员', '1', '0', 'admin', '2015-04-25 17:38:01', 'admin', '2015-05-16 16:49:45');

-- ----------------------------
-- Table structure for `role_authorities`
-- ----------------------------
DROP TABLE IF EXISTS `role_authorities`;
CREATE TABLE `role_authorities` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `roleId` bigint(20) NOT NULL COMMENT '标识列',
  `authorityId` bigint(20) NOT NULL COMMENT '标识列',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_5` (`roleId`),
  KEY `FK_Reference_6` (`authorityId`)
) ENGINE=InnoDB AUTO_INCREMENT=230 DEFAULT CHARSET=utf8 COMMENT='角色、权限关系表';

-- ----------------------------
-- Records of role_authorities
-- ----------------------------
INSERT INTO `role_authorities` VALUES ('117', '1', '75');
INSERT INTO `role_authorities` VALUES ('118', '1', '74');
INSERT INTO `role_authorities` VALUES ('119', '1', '73');
INSERT INTO `role_authorities` VALUES ('120', '1', '72');
INSERT INTO `role_authorities` VALUES ('121', '1', '71');
INSERT INTO `role_authorities` VALUES ('122', '1', '70');
INSERT INTO `role_authorities` VALUES ('123', '1', '1');
INSERT INTO `role_authorities` VALUES ('124', '1', '2');
INSERT INTO `role_authorities` VALUES ('125', '1', '3');
INSERT INTO `role_authorities` VALUES ('126', '1', '4');
INSERT INTO `role_authorities` VALUES ('127', '1', '5');
INSERT INTO `role_authorities` VALUES ('128', '1', '6');
INSERT INTO `role_authorities` VALUES ('129', '1', '7');
INSERT INTO `role_authorities` VALUES ('130', '1', '8');
INSERT INTO `role_authorities` VALUES ('131', '1', '9');
INSERT INTO `role_authorities` VALUES ('132', '1', '10');
INSERT INTO `role_authorities` VALUES ('133', '1', '11');
INSERT INTO `role_authorities` VALUES ('134', '1', '12');
INSERT INTO `role_authorities` VALUES ('135', '1', '13');
INSERT INTO `role_authorities` VALUES ('136', '1', '14');
INSERT INTO `role_authorities` VALUES ('137', '1', '15');
INSERT INTO `role_authorities` VALUES ('138', '1', '16');
INSERT INTO `role_authorities` VALUES ('139', '1', '17');
INSERT INTO `role_authorities` VALUES ('140', '1', '18');
INSERT INTO `role_authorities` VALUES ('141', '1', '19');
INSERT INTO `role_authorities` VALUES ('142', '1', '20');
INSERT INTO `role_authorities` VALUES ('143', '1', '21');
INSERT INTO `role_authorities` VALUES ('144', '1', '22');
INSERT INTO `role_authorities` VALUES ('145', '1', '23');
INSERT INTO `role_authorities` VALUES ('146', '1', '24');
INSERT INTO `role_authorities` VALUES ('147', '1', '25');
INSERT INTO `role_authorities` VALUES ('148', '1', '26');
INSERT INTO `role_authorities` VALUES ('149', '1', '27');
INSERT INTO `role_authorities` VALUES ('150', '1', '28');
INSERT INTO `role_authorities` VALUES ('151', '1', '29');
INSERT INTO `role_authorities` VALUES ('152', '1', '30');
INSERT INTO `role_authorities` VALUES ('153', '1', '31');
INSERT INTO `role_authorities` VALUES ('154', '1', '32');
INSERT INTO `role_authorities` VALUES ('155', '1', '33');
INSERT INTO `role_authorities` VALUES ('156', '1', '34');
INSERT INTO `role_authorities` VALUES ('157', '1', '35');
INSERT INTO `role_authorities` VALUES ('158', '1', '36');
INSERT INTO `role_authorities` VALUES ('159', '1', '37');
INSERT INTO `role_authorities` VALUES ('160', '1', '38');
INSERT INTO `role_authorities` VALUES ('161', '1', '39');
INSERT INTO `role_authorities` VALUES ('162', '1', '40');
INSERT INTO `role_authorities` VALUES ('163', '1', '41');
INSERT INTO `role_authorities` VALUES ('164', '1', '64');
INSERT INTO `role_authorities` VALUES ('165', '1', '65');
INSERT INTO `role_authorities` VALUES ('166', '1', '66');
INSERT INTO `role_authorities` VALUES ('167', '1', '67');
INSERT INTO `role_authorities` VALUES ('168', '1', '68');
INSERT INTO `role_authorities` VALUES ('169', '1', '69');
INSERT INTO `role_authorities` VALUES ('209', '3', '4');
INSERT INTO `role_authorities` VALUES ('210', '3', '1');
INSERT INTO `role_authorities` VALUES ('211', '3', '2');
INSERT INTO `role_authorities` VALUES ('212', '3', '30');
INSERT INTO `role_authorities` VALUES ('213', '3', '31');
INSERT INTO `role_authorities` VALUES ('214', '3', '32');
INSERT INTO `role_authorities` VALUES ('215', '3', '33');
INSERT INTO `role_authorities` VALUES ('216', '3', '34');
INSERT INTO `role_authorities` VALUES ('217', '3', '35');
INSERT INTO `role_authorities` VALUES ('218', '3', '36');
INSERT INTO `role_authorities` VALUES ('219', '3', '37');
INSERT INTO `role_authorities` VALUES ('220', '3', '38');
INSERT INTO `role_authorities` VALUES ('221', '3', '39');
INSERT INTO `role_authorities` VALUES ('222', '3', '40');
INSERT INTO `role_authorities` VALUES ('223', '3', '41');
INSERT INTO `role_authorities` VALUES ('224', '3', '64');
INSERT INTO `role_authorities` VALUES ('225', '3', '65');
INSERT INTO `role_authorities` VALUES ('226', '3', '66');
INSERT INTO `role_authorities` VALUES ('227', '3', '67');
INSERT INTO `role_authorities` VALUES ('228', '3', '68');
INSERT INTO `role_authorities` VALUES ('229', '3', '69');

-- ----------------------------
-- Table structure for `table_config`
-- ----------------------------
DROP TABLE IF EXISTS `table_config`;
CREATE TABLE `table_config` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL DEFAULT '''''' COMMENT '列名',
  `field` varchar(200) NOT NULL DEFAULT 'null' COMMENT '属性名',
  `width` int(200) NOT NULL DEFAULT '80' COMMENT '样式',
  `def1` varchar(200) NOT NULL DEFAULT '''''' COMMENT '预留字段1',
  `def2` varchar(200) NOT NULL DEFAULT '''''' COMMENT '预留字段2',
  `def3` varchar(200) NOT NULL DEFAULT '''''' COMMENT '预留字段3',
  `enable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可用 1是  0否',
  `creater` varchar(20) NOT NULL DEFAULT 'admin',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifer` varchar(20) NOT NULL DEFAULT 'admin',
  `last_modify_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='表列配置表';

-- ----------------------------
-- Records of table_config
-- ----------------------------

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `usercode` varchar(200) NOT NULL COMMENT '用户编码',
  `password` varchar(50) NOT NULL COMMENT '登陆密码',
  `enable` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否可用 1是 0否',
  `remark` varchar(200) NOT NULL COMMENT '描述',
  `is_sys` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否是超级管理员 0否  1是',
  `creater` varchar(20) NOT NULL DEFAULT 'admin',
  `create_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  `modifer` varchar(20) NOT NULL DEFAULT 'admin',
  `last_modify_time` datetime NOT NULL DEFAULT '1980-01-01 00:00:00',
  PRIMARY KEY (`id`),
  UNIQUE KEY `code_idx` (`usercode`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', 'admin', '123456', '1', '管理员', '1', 'admin', '1980-01-01 00:00:00', 'admin', '2015-05-18 21:41:27');
INSERT INTO `users` VALUES ('2', 'frinder', 'frinder', '123456', '1', '管理员', '1', 'admin', '2015-05-18 21:49:25', 'admin', '2015-05-18 21:49:25');

-- ----------------------------
-- Table structure for `user_group`
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标识列',
  `userId` bigint(20) NOT NULL COMMENT '用户id',
  `groupId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Reference_fk_groupId` (`groupId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户、组关系表';

-- ----------------------------
-- Records of user_group
-- ----------------------------

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `userId` bigint(20) DEFAULT NULL COMMENT '标识列',
  `roleId` bigint(20) DEFAULT NULL COMMENT '标识列',
  PRIMARY KEY (`id`),
  KEY `FK_Reference_10` (`roleId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='用户、角色关系表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('4', '1', '1');
INSERT INTO `user_role` VALUES ('7', '2', '3');
