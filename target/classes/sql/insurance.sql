/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50018
Source Host           : localhost:3306
Source Database       : insurance

Target Server Type    : MYSQL
Target Server Version : 50018
File Encoding         : 65001

Date: 2018-05-28 13:11:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `adminuser`
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(20) default NULL,
  `password` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminuser
-- ----------------------------
INSERT INTO `adminuser` VALUES ('1', 'admin', '123456');

-- ----------------------------
-- Table structure for `commerialinquiry`
-- ----------------------------
DROP TABLE IF EXISTS `commerialinquiry`;
CREATE TABLE `commerialinquiry` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `address` varchar(20) default NULL,
  `postalCode` varchar(20) default NULL,
  `type` varchar(20) default NULL,
  `propertyat` varchar(20) default NULL,
  `propertyEnvironment` varchar(20) default NULL,
  `commissionTime` datetime default NULL,
  `insuranceSlipId` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `inquiry_insurance` (`insuranceSlipId`),
  CONSTRAINT `commerialinquiry_insurance` FOREIGN KEY (`insuranceSlipId`) REFERENCES `insuranceslip` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commerialinquiry
-- ----------------------------
INSERT INTO `commerialinquiry` VALUES ('1', '北京', '北京', '100192', null, null, null, null, '4');

-- ----------------------------
-- Table structure for `enterprise`
-- ----------------------------
DROP TABLE IF EXISTS `enterprise`;
CREATE TABLE `enterprise` (
  `id` int(11) NOT NULL auto_increment,
  `type` varchar(10) default NULL COMMENT '生产性企业  /  商业性企业',
  `name` varchar(50) default NULL,
  `address` varchar(100) default NULL,
  `postalcode` varchar(8) default NULL,
  `registeredCapital` double default NULL,
  `userId` int(11) default NULL,
  `createby` varchar(20) default NULL,
  `createdate` datetime default NULL,
  `updateby` varchar(20) default NULL,
  `updatedate` datetime default NULL,
  PRIMARY KEY  (`id`),
  KEY `enterprise_user` (`userId`),
  CONSTRAINT `enterprise_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of enterprise
-- ----------------------------
INSERT INTO `enterprise` VALUES ('1', '商业性企业', '拓尔思信息技术股份有限公司', '北京市朝阳区西奥中心', '100192', '50', '1', null, null, null, null);
INSERT INTO `enterprise` VALUES ('4', '商业性企业', '北京网易云', '北京市海淀区清河小营东路十二号', '100192', '1000', '4', '肖既滨', '2018-05-25 15:53:07', '肖既滨', '2018-05-25 15:53:07');

-- ----------------------------
-- Table structure for `insuranceslip`
-- ----------------------------
DROP TABLE IF EXISTS `insuranceslip`;
CREATE TABLE `insuranceslip` (
  `id` int(11) NOT NULL auto_increment,
  `sureName` varchar(255) default NULL,
  `surePostalAddress` varchar(255) default NULL,
  `sureOrigin` varchar(255) default NULL,
  `surePerson` varchar(255) default NULL,
  `surePhone` varchar(255) default NULL,
  `surePostalcode` varchar(255) default NULL,
  `sureType` varchar(255) default NULL,
  `insuredName` varchar(255) default NULL,
  `insuredPostalAddress` varchar(255) default NULL,
  `insuredOrigin` varchar(255) default NULL,
  `insuredPerson` varchar(255) default NULL,
  `insuredPhone` varchar(255) default NULL,
  `insuredPostalcode` varchar(255) default NULL,
  `industryCategory` varchar(255) default NULL,
  `industryCode` varchar(255) default NULL,
  `insuredNum` varchar(255) default NULL,
  `insuredAddress` varchar(255) default NULL,
  `insuredRegisteredCapital` varchar(255) default NULL,
  `insuredTotalAssets` varchar(255) default NULL,
  `insuredOldTurnover` varchar(255) default NULL,
  `insuredType` varchar(255) default NULL,
  `deductibleExcess` varchar(255) default NULL,
  `haveRelevantInsurance` varchar(255) default NULL,
  `isNewInsurance` varchar(255) default NULL,
  `totalAmountInsured` varchar(255) default NULL,
  `startdate` date default NULL,
  `enddate` date default NULL,
  `totalCost` varchar(255) default NULL,
  `leadTime` datetime default NULL,
  `disputeMethod` varchar(255) default NULL,
  `remark` varchar(255) default NULL,
  `firstTrialState` varchar(255) default '审核中',
  `firstTrialPerson` varchar(255) default NULL,
  `firstTrialtime` datetime default NULL,
  `safeguardsOpinion` varchar(255) default NULL,
  `safeguardsPerson` varchar(255) default NULL,
  `safeguardstime` datetime default NULL,
  `createby` varchar(255) default NULL,
  `createtime` datetime default NULL,
  `updateby` varchar(255) default NULL,
  `updatetime` datetime default NULL,
  `userId` int(11) default NULL,
  `enterpriseId` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `insuranceSlip_user` (`userId`),
  KEY `insuranceSlip_enterprise` (`enterpriseId`),
  CONSTRAINT `insuranceSlip_enterprise` FOREIGN KEY (`enterpriseId`) REFERENCES `enterprise` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `insuranceSlip_user` FOREIGN KEY (`userId`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of insuranceslip
-- ----------------------------
INSERT INTO `insuranceslip` VALUES ('3', '托俄日四新', '131', '', '', '', '100192', null, '', '', '', '', '', '', '生产性企业', '', '', '', '', '', '', '', '', '', '', '', null, null, '', null, '', '', '审核中', null, null, null, null, null, '肖既滨', '2018-05-27 15:27:43', '肖既滨', '2018-05-27 15:27:43', '4', '1');
INSERT INTO `insuranceslip` VALUES ('4', '北京', '北京', '', '', '15600693173', '100192', null, '', '', '', '', '', '', '商业性企业', '', '', '', '', '', '', '', '', '', '', '', null, null, '', null, '', '', '审核中', null, null, null, null, null, '肖既滨', '2018-05-27 16:17:32', '肖既滨', '2018-05-27 16:17:32', '4', '1');

-- ----------------------------
-- Table structure for `productiveinquiry`
-- ----------------------------
DROP TABLE IF EXISTS `productiveinquiry`;
CREATE TABLE `productiveinquiry` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `address` varchar(20) default NULL,
  `postalCode` varchar(20) default NULL,
  `type` varchar(20) default NULL,
  `propertyat` varchar(20) default NULL,
  `propertyEnvironment` varchar(20) default NULL,
  `commissionTime` datetime default NULL,
  `insuranceSlipId` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `inquiry_insurance` (`insuranceSlipId`),
  CONSTRAINT `inquiry_insurance` FOREIGN KEY (`insuranceSlipId`) REFERENCES `insuranceslip` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productiveinquiry
-- ----------------------------
INSERT INTO `productiveinquiry` VALUES ('1', '托俄日四新', '131', '100192', null, null, null, null, '3');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `email` varchar(30) NOT NULL,
  `phone` varchar(11) NOT NULL,
  `realname` varchar(20) NOT NULL,
  `idcard` char(18) NOT NULL,
  `password` varchar(20) NOT NULL,
  `createdate` datetime default NULL,
  `updatedate` datetime default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'www.941623975@qq.com', '15600693173', '肖既滨', '513001199702010837', '123456', null, null);
INSERT INTO `user` VALUES ('3', 'cuiruibiubiu@163.com', '18201140855', '崔蕊', '513001199702010837', '123456', null, null);
INSERT INTO `user` VALUES ('4', 'xjbbiubiu@qq.com', '15600693173', '肖既滨', '513001199702010837', '123', '2018-05-24 23:43:20', null);
