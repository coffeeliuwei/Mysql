USE `jsp_db`;

DROP TABLE IF EXISTS `exam`;

CREATE TABLE `exam` (
  `id` int(11) NOT NULL COMMENT '学号',
  `chinese` int(11) DEFAULT NULL COMMENT '语文成绩',
  `english` int(11) DEFAULT NULL COMMENT '英语成绩',
  `math` int(11) DEFAULT NULL COMMENT '数学成线',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `exam`(`id`,`chinese`,`english`,`math`) values (20200001,89,90,98),
(20200002,78,82,93),(20200003,90,73,95),(20200004,88,98,83),
(20200005,96,79,75),(20200006,77,98,82);

DROP TABLE IF EXISTS `leave_event`;

CREATE TABLE `leave_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '请假记录ID',
  `stuId` int(11) NOT NULL COMMENT '学生ID',
  `daysFrom` date DEFAULT NULL COMMENT '哪天开始',
  `daysTo` date DEFAULT NULL COMMENT '哪天结束',
  `type` tinyint(4) DEFAULT NULL COMMENT '类型，0病假，1事假',
  `reason` varchar(256) DEFAULT NULL COMMENT '事由',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

insert  into `leave_event`(`id`,`stuId`,`daysFrom`,`daysTo`,`type`,`reason`) values 
(1,20200001,'2020-01-02','2020-01-03',0,'感冒'),(2,20200001,'2020-03-06','2020-03-08',0,'发烧'),
(3,20200003,'2020-03-01','2020-03-07',1,'出国旅游'),(4,20200005,'2020-03-07','2020-03-07',1,'家里有事'),
(5,20200003,'2020-03-17','2020-03-18',0,'不舒服');

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL COMMENT '学号',
  `name` varchar(32) NOT NULL COMMENT '姓名',
  `sex` tinyint(1) DEFAULT NULL COMMENT '性别',
  `phone` varchar(16) DEFAULT '13800000000' COMMENT '手机号',
  `birthday` date DEFAULT NULL COMMENT '生日',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert  into `student`(`id`,`name`,`sex`,`phone`,`birthday`) values 
(20200001,'刘伟',1,'1409900089','1982-03-09'),(20200002,'曹操',1,'1282399999','1993-10-01'),
(20200003,'刘备',1,NULL,'1996-03-11'),(20200004,'孙权',1,NULL,'1982-09-24'),
(20200005,'吕布',1,'13699292899','1983-11-21'),(20200006,'公孙策',0,'13819289890','1998-03-12'),
(20200007,'马超',0,'13800000000','1978-05-12'),(20200008,'赵云',1,'13410012908','1993-09-10'),
(20200009,'文丑',1,'13509890090','1994-04-20'),(20200010,'司马昭',1,'18799891829','2002-04-19'),
(20200011,'貂蝉',0,'13882938990','2003-06-10');


