/*
Navicat MySQL Data Transfer

Source Server         : test
Source Server Version : 50562
Source Host           : 47.100.59.206:3306
Source Database       : oauth

Target Server Type    : MYSQL
Target Server Version : 50562
File Encoding         : 65001

Date: 2019-06-27 14:18:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(32) NOT NULL,
  `nick_name` varchar(20) DEFAULT NULL,
  `user_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `age` int(2) DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  `head_url` varchar(100) DEFAULT NULL,
  `phone` varchar(13) DEFAULT NULL COMMENT '手机号',
  `state` int(1) DEFAULT NULL,
  `zone` varchar(2) DEFAULT NULL COMMENT '地区',
  `modify_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for oauth_refresh_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_refresh_token`;
CREATE TABLE `oauth_refresh_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication` blob
) ENGINE=MyISAM DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for oauth_client_details
-- ----------------------------
DROP TABLE IF EXISTS `oauth_client_details`;
CREATE TABLE `oauth_client_details` (
  `client_id` varchar(48) NOT NULL,
  `resource_ids` varchar(256) DEFAULT NULL,
  `client_secret` varchar(256) DEFAULT NULL,
  `scope` varchar(256) DEFAULT NULL,
  `authorized_grant_types` varchar(256) DEFAULT NULL,
  `web_server_redirect_uri` varchar(256) DEFAULT NULL,
  `authorities` varchar(256) DEFAULT NULL,
  `access_token_validity` int(11) DEFAULT NULL,
  `refresh_token_validity` int(11) DEFAULT NULL,
  `additional_information` varchar(4096) DEFAULT NULL,
  `autoapprove` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for oauth_access_token
-- ----------------------------
DROP TABLE IF EXISTS `oauth_access_token`;
CREATE TABLE `oauth_access_token` (
  `token_id` varchar(256) DEFAULT NULL,
  `token` blob,
  `authentication_id` varchar(256) DEFAULT NULL,
  `user_name` varchar(256) DEFAULT NULL,
  `client_id` varchar(256) DEFAULT NULL,
  `authentication` blob,
  `refresh_token` varchar(256) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8;



-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('8554a021adee46fe88f579274a7b4b24', null, 'root', '$2a$10$1Ep6eG2OE1XvMY9JkAIu.u5R7ncr5iJlvdrSgg7YrJ8evyaV55tzu', 'USER_ROLE', null, null, null, null, null, null, null, null, null);


-- ----------------------------
-- Records of oauth_client_details
-- ----------------------------
INSERT INTO `oauth_client_details` VALUES ('webapp', 'webapp', '$2a$10$tJYzuIw6wAkAnUofSAvMaOlYKZH.rowPJV56KN5SU8OZh4J3iFilm', 'read_userInfo,read_contacts', 'password,refresh_token', null, 'USER_ROLE', '400', '500', null, 'true');

