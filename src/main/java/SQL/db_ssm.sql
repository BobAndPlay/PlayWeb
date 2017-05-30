/*
Navicat MySQL Data Transfer

Source Server         : localhost_53306
Source Server Version : 50505
Source Host           : localhost:53306
Source Database       : db_ssm

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2017-05-30 21:42:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_banner
-- ----------------------------
DROP TABLE IF EXISTS `t_banner`;
CREATE TABLE `t_banner` (
  `pic_url` varchar(255) DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `point_url` varchar(255) DEFAULT NULL,
  `des` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_banner
-- ----------------------------
INSERT INTO `t_banner` VALUES ('banner1.jpg', '1', '', 'python最新课程', 'python', 'main');
INSERT INTO `t_banner` VALUES ('banner2.jpg', '2', '', 'java最新课程', 'java', 'main');
INSERT INTO `t_banner` VALUES ('banner3.jpg', '3', '', 'php最新课程', 'php', 'main');
INSERT INTO `t_banner` VALUES ('banner4.jpg', '4', '', 'UI最新课程', 'UI', 'main');
INSERT INTO `t_banner` VALUES ('banner5.jpg', '5', null, 'Android最新课程', 'Android', 'main');
INSERT INTO `t_banner` VALUES ('hot1.png', '6', null, '', 'JavaEE公开课', 'hot');
INSERT INTO `t_banner` VALUES ('hot2.jpg', '7', null, null, '前端', 'hot');
INSERT INTO `t_banner` VALUES ('hot3.jpg', '8', null, null, 'UI', 'hot');
INSERT INTO `t_banner` VALUES ('hot4.jpg', '9', null, null, 'PHP基础入门', 'hot');
INSERT INTO `t_banner` VALUES ('hot5.jpg', '10', null, null, 'C语言小项目-贪食蛇', 'hot');
INSERT INTO `t_banner` VALUES ('hot6.jpg', '11', null, null, '云计算之大数据', 'hot');

-- ----------------------------
-- Table structure for t_subject
-- ----------------------------
DROP TABLE IF EXISTS `t_subject`;
CREATE TABLE `t_subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `class-id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_subject
-- ----------------------------
INSERT INTO `t_subject` VALUES ('1', 'java', null);
INSERT INTO `t_subject` VALUES ('2', '前端', null);
INSERT INTO `t_subject` VALUES ('3', '大数据', null);
INSERT INTO `t_subject` VALUES ('4', 'Android', null);
INSERT INTO `t_subject` VALUES ('5', 'Php', null);
INSERT INTO `t_subject` VALUES ('6', 'C/C++', null);
INSERT INTO `t_subject` VALUES ('7', 'iOS', null);
INSERT INTO `t_subject` VALUES ('8', 'UI', null);
INSERT INTO `t_subject` VALUES ('9', '网络营销', null);
INSERT INTO `t_subject` VALUES ('10', 'Python', null);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL COMMENT '用户名',
  `user_phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `user_email` varchar(255) DEFAULT NULL COMMENT '邮箱地址',
  `user_pwd` varchar(32) DEFAULT NULL COMMENT '加盐后用户密码',
  `pwd_salt` varchar(6) DEFAULT NULL COMMENT 'MD5盐',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '最后修改时间',
  `is_delete` tinyint(4) DEFAULT NULL COMMENT '是否删除，0-未删除；1-已删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户登录表';

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '赵大宝', '13285250574', '1045221654@qq.com', '05126a423a9379d529e4ee61a212fa55', 'KJUYT5', '2016-07-15 23:38:56', '2016-07-15 23:39:09', '0');
INSERT INTO `t_user` VALUES ('2', '张三丰', '15985250574', '1198224554@qq.com', '98bd3a1bebde01ad363d3c5a0d1e56da', '656JHU', '2016-07-15 23:39:01', '2016-07-15 23:39:13', '0');
INSERT INTO `t_user` VALUES ('3', '王尼玛', '13685250574', '1256221654@qq.com', '5470db9b63c354f6c8d628b80ae2f3c3', '89UIKQ', '2016-07-15 23:39:05', '2016-07-15 23:39:16', '0');
