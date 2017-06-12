/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.0.16-nt : Database - rms
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`rms` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `rms`;

/*Table structure for table `anno_sendee` */

DROP TABLE IF EXISTS `anno_sendee`;

CREATE TABLE `anno_sendee` (
  `id` int(11) NOT NULL auto_increment,
  `an_id` int(11) NOT NULL,
  `m_id` int(11) default NULL,
  `state` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `anno_sendee` */

/*Table structure for table `announce_section` */

DROP TABLE IF EXISTS `announce_section`;

CREATE TABLE `announce_section` (
  `as_id` int(11) NOT NULL auto_increment,
  `as_amount` int(11) NOT NULL,
  `as_description` varchar(255) default NULL,
  `as_name` varchar(255) default NULL,
  `as_updatetime` varchar(255) default NULL,
  PRIMARY KEY  (`as_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `announce_section` */

/*Table structure for table `announcement` */

DROP TABLE IF EXISTS `announcement`;

CREATE TABLE `announcement` (
  `announcement_id` int(11) NOT NULL auto_increment,
  `an_jieshouren` varchar(255) default NULL,
  `announcement_amount` int(11) NOT NULL,
  `announcement_info` text,
  `announcement_time` varchar(255) default NULL,
  `announcement_title` varchar(255) default NULL,
  `announcement_type` varchar(255) default NULL,
  `announcement_views` int(11) NOT NULL,
  `as_id` int(11) NOT NULL,
  `as_name` varchar(255) default NULL,
  `getanno_member` varchar(255) default NULL,
  `m_username` varchar(255) default NULL,
  `announ_title` varchar(255) default NULL,
  PRIMARY KEY  (`announcement_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `announcement` */

/*Table structure for table `apply` */

DROP TABLE IF EXISTS `apply`;

CREATE TABLE `apply` (
  `apply_id` int(11) NOT NULL auto_increment,
  `apply_info` varchar(255) default NULL,
  `apply_member` varchar(255) default NULL,
  `apply_time` varchar(255) default NULL,
  `approval_member` varchar(255) default NULL,
  `approval_schedule` varchar(255) default NULL,
  `approval_time` varchar(255) default NULL,
  `approval_type` varchar(255) default NULL,
  `member_section` varchar(255) default NULL,
  PRIMARY KEY  (`apply_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `apply` */

/*Table structure for table `approval` */

DROP TABLE IF EXISTS `approval`;

CREATE TABLE `approval` (
  `approval_id` int(11) NOT NULL auto_increment,
  `apply_info` varchar(255) default NULL,
  `apply_member` varchar(255) default NULL,
  `apply_resource` varchar(255) default NULL,
  `apply_time` varchar(255) default NULL,
  `approval_info` varchar(255) default NULL,
  `approval_member` varchar(255) default NULL,
  `approval_schedule` varchar(255) default NULL,
  `approval_section` varchar(255) default NULL,
  `approval_time` varchar(255) default NULL,
  `approval_type` varchar(255) default NULL,
  PRIMARY KEY  (`approval_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `approval` */

/*Table structure for table `assess` */

DROP TABLE IF EXISTS `assess`;

CREATE TABLE `assess` (
  `id` int(11) NOT NULL auto_increment,
  `ac_id` int(11) NOT NULL,
  `biaoxian` int(11) NOT NULL,
  `heji` int(11) NOT NULL,
  `kaoqin` int(11) NOT NULL,
  `operator_id` int(11) NOT NULL,
  `remark` varchar(255) default NULL,
  `sectionname` varchar(255) default NULL,
  `updatetime` varchar(255) default NULL,
  `user_id` int(11) NOT NULL,
  `username` varchar(255) default NULL,
  `xiangmu` int(11) NOT NULL,
  `xinde` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `assess` */

/*Table structure for table `assesschart` */

DROP TABLE IF EXISTS `assesschart`;

CREATE TABLE `assesschart` (
  `id` int(11) NOT NULL auto_increment,
  `as_endtime` varchar(255) default NULL,
  `as_starttime` varchar(255) default NULL,
  `assessname` varchar(255) default NULL,
  `m_id` int(11) NOT NULL,
  `operatorname` varchar(255) default NULL,
  `updatetime` varchar(255) default NULL,
  `updatetimeinfo` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `assesschart` */

/*Table structure for table `assessexportchart` */

DROP TABLE IF EXISTS `assessexportchart`;

CREATE TABLE `assessexportchart` (
  `id` int(11) NOT NULL auto_increment,
  `exportname` varchar(255) default NULL,
  `updatetime` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `assessexportchart` */

/*Table structure for table `assessoperator` */

DROP TABLE IF EXISTS `assessoperator`;

CREATE TABLE `assessoperator` (
  `id` int(11) NOT NULL auto_increment,
  `ac_id` int(11) NOT NULL,
  `operator_id` int(11) NOT NULL,
  `username` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `assessoperator` */

/*Table structure for table `attendance` */

DROP TABLE IF EXISTS `attendance`;

CREATE TABLE `attendance` (
  `a_id` int(11) NOT NULL auto_increment,
  `a_check_in_time` varchar(255) default NULL,
  `a_check_out_time` varchar(255) default NULL,
  `a_datetime` varchar(255) default NULL,
  `a_nianyuetime` varchar(255) default NULL,
  `a_state` varchar(255) default NULL,
  `a_yueritime` varchar(255) default NULL,
  `m_id` int(11) NOT NULL,
  `time_difference` varchar(255) default NULL,
  `ipaddr_in` varchar(255) default NULL,
  `ipaddr_out` varchar(255) default NULL,
  `ipinfo_in` varchar(255) default NULL,
  `ipinfo_out` varchar(255) default NULL,
  `ipstate` varchar(255) default NULL,
  `shiftsection` varchar(255) default NULL,
  PRIMARY KEY  (`a_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `attendance` */

/*Table structure for table `attendance_unusual` */

DROP TABLE IF EXISTS `attendance_unusual`;

CREATE TABLE `attendance_unusual` (
  `id` int(11) NOT NULL auto_increment,
  `afterstate` varchar(255) default NULL,
  `applyuser_id` int(11) NOT NULL,
  `atten_week` varchar(255) default NULL,
  `attendanceshift` varchar(255) default NULL,
  `beforestate` varchar(255) default NULL,
  `check_in_out_time` varchar(255) default NULL,
  `datetime` varchar(255) default NULL,
  `dtime` varchar(255) default NULL,
  `now_week` varchar(255) default NULL,
  `operator_id` int(11) NOT NULL,
  `remark` varchar(255) default NULL,
  `state` int(11) NOT NULL,
  `time` varchar(255) default NULL,
  `timeinfo` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `attendance_unusual` */

/*Table structure for table `attendancechart` */

DROP TABLE IF EXISTS `attendancechart`;

CREATE TABLE `attendancechart` (
  `id` int(11) NOT NULL auto_increment,
  `exportman` varchar(255) default NULL,
  `filename` varchar(255) default NULL,
  `time` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `attendancechart` */

/*Table structure for table `contest` */

DROP TABLE IF EXISTS `contest`;

CREATE TABLE `contest` (
  `contest_id` int(11) NOT NULL auto_increment,
  `c_image` varchar(255) default NULL,
  `contest_experience` varchar(255) default NULL,
  `contest_info` varchar(255) default NULL,
  `contest_place` varchar(255) default NULL,
  `contest_time` varchar(255) default NULL,
  `contest_title` varchar(255) default NULL,
  `contets_url` varchar(255) default NULL,
  `project_awads` varchar(255) default NULL,
  `project_file` varchar(255) default NULL,
  `project_info` varchar(255) default NULL,
  `project_member` varchar(255) default NULL,
  `project_name` varchar(255) default NULL,
  `project_section` varchar(255) default NULL,
  PRIMARY KEY  (`contest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `contest` */

/*Table structure for table `defaultip` */

DROP TABLE IF EXISTS `defaultip`;

CREATE TABLE `defaultip` (
  `id` int(11) NOT NULL auto_increment,
  `ipaddr` varchar(255) default NULL,
  `ipname` varchar(255) default NULL,
  `operator` varchar(255) default NULL,
  `time` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `defaultip` */

/*Table structure for table `equipment_info` */

DROP TABLE IF EXISTS `equipment_info`;

CREATE TABLE `equipment_info` (
  `e_id` int(11) NOT NULL auto_increment,
  `e_buytime` varchar(255) default NULL,
  `e_checktime` varchar(255) default NULL,
  `e_image` varchar(255) default NULL,
  `e_location` varchar(255) default NULL,
  `e_name` varchar(255) default NULL,
  `e_pattern` varchar(255) default NULL,
  `e_precautions` varchar(255) default NULL,
  `e_price` int(11) NOT NULL,
  `e_principal` varchar(255) default NULL,
  `e_purchaser` varchar(255) default NULL,
  PRIMARY KEY  (`e_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `equipment_info` */

/*Table structure for table `learning_log` */

DROP TABLE IF EXISTS `learning_log`;

CREATE TABLE `learning_log` (
  `l_id` int(11) NOT NULL auto_increment,
  `l_comment` varchar(255) default NULL,
  `l_content` varchar(255) default NULL,
  `l_member` varchar(255) default NULL,
  `l_purview` varchar(255) default NULL,
  `l_state` varchar(255) default NULL,
  `l_subject` varchar(255) default NULL,
  `l_time` varchar(255) default NULL,
  `l_zan` int(11) NOT NULL,
  `lt_id` int(11) NOT NULL,
  `lt_name` varchar(255) default NULL,
  PRIMARY KEY  (`l_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `learning_log` */

/*Table structure for table `learning_plan` */

DROP TABLE IF EXISTS `learning_plan`;

CREATE TABLE `learning_plan` (
  `id` int(11) NOT NULL auto_increment,
  `lcontent` varchar(255) default NULL,
  `ldaylong` varchar(255) default NULL,
  `lendtime` varchar(255) default NULL,
  `lfilename` varchar(255) default NULL,
  `lstarttime` varchar(255) default NULL,
  `lsummarize` varchar(255) default NULL,
  `ltitle` varchar(255) default NULL,
  `m_id` int(11) NOT NULL,
  `sectionname` varchar(255) default NULL,
  `updatetime` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `learning_plan` */

/*Table structure for table `learning_project` */

DROP TABLE IF EXISTS `learning_project`;

CREATE TABLE `learning_project` (
  `project_id` int(11) NOT NULL auto_increment,
  `m_username` varchar(255) default NULL,
  `project_endtime` varchar(255) default NULL,
  `project_starttime` varchar(255) default NULL,
  `project_title` varchar(255) default NULL,
  `project_type` varchar(255) default NULL,
  `project_updatetime` varchar(255) default NULL,
  PRIMARY KEY  (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `learning_project` */

/*Table structure for table `log_type` */

DROP TABLE IF EXISTS `log_type`;

CREATE TABLE `log_type` (
  `lt_id` int(11) NOT NULL auto_increment,
  `lt_name` varchar(255) default NULL,
  `lt_remark` varchar(255) default NULL,
  `lt_time` varchar(255) default NULL,
  PRIMARY KEY  (`lt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `log_type` */

/*Table structure for table `membershipinfo` */

DROP TABLE IF EXISTS `membershipinfo`;

CREATE TABLE `membershipinfo` (
  `m_id` int(11) NOT NULL auto_increment,
  `m_classname` varchar(255) default NULL,
  `m_email` varchar(255) default NULL,
  `m_entermiictime` varchar(255) default NULL,
  `m_password` varchar(255) default NULL,
  `m_phone` varchar(255) default NULL,
  `m_qqchat` varchar(255) default NULL,
  `m_role` varchar(255) default NULL,
  `m_sectionname` varchar(255) default NULL,
  `m_sex` varchar(255) default NULL,
  `m_state` varchar(255) default NULL,
  `m_truename` varchar(255) default NULL,
  `m_username` varchar(255) default NULL,
  `m_userpicture` mediumtext,
  `m_utpitp` varchar(255) default NULL,
  `role_num` int(11) NOT NULL,
  PRIMARY KEY  (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `membershipinfo` */

/*Table structure for table `project` */

DROP TABLE IF EXISTS `project`;

CREATE TABLE `project` (
  `project_id` int(11) NOT NULL auto_increment,
  `contest_experience` varchar(255) default NULL,
  `project_awads` varchar(255) default NULL,
  `project_file` varchar(255) default NULL,
  `project_info` varchar(255) default NULL,
  `project_member` varchar(255) default NULL,
  `project_name` varchar(255) default NULL,
  `project_principal` varchar(255) default NULL,
  `project_uptime` varchar(255) default NULL,
  `section_name` varchar(255) default NULL,
  PRIMARY KEY  (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `project` */

/*Table structure for table `resource_type` */

DROP TABLE IF EXISTS `resource_type`;

CREATE TABLE `resource_type` (
  `rt_id` int(11) NOT NULL auto_increment,
  `re_amount` int(11) NOT NULL,
  `rt_issuer` varchar(255) default NULL,
  `rt_name` varchar(255) default NULL,
  `rt_remark` varchar(255) default NULL,
  `rt_updatime` varchar(255) default NULL,
  PRIMARY KEY  (`rt_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `resource_type` */

/*Table structure for table `resourceinfo` */

DROP TABLE IF EXISTS `resourceinfo`;

CREATE TABLE `resourceinfo` (
  `resource_id` int(11) NOT NULL auto_increment,
  `resource_issuer` varchar(255) default NULL,
  `resource_name` varchar(255) default NULL,
  `resource_remark` varchar(255) default NULL,
  `resource_time` varchar(255) default NULL,
  `rt_id` int(11) NOT NULL,
  PRIMARY KEY  (`resource_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `resourceinfo` */

/*Table structure for table `section` */

DROP TABLE IF EXISTS `section`;

CREATE TABLE `section` (
  `id` int(11) NOT NULL auto_increment,
  `remark` varchar(255) default NULL,
  `section_name` varchar(255) default NULL,
  `time` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `section` */

/*Table structure for table `shift` */

DROP TABLE IF EXISTS `shift`;

CREATE TABLE `shift` (
  `id` int(11) NOT NULL auto_increment,
  `check_in_time_hour` varchar(255) default NULL,
  `check_in_time_minute` varchar(255) default NULL,
  `check_out_time_hour` varchar(255) default NULL,
  `check_out_time_minute` varchar(255) default NULL,
  `elas_time` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `shift` */

insert  into `shift`(`id`,`check_in_time_hour`,`check_in_time_minute`,`check_out_time_hour`,`check_out_time_minute`,`elas_time`) values (1,'19','00','21','45','5');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
