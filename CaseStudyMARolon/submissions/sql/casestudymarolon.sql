-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.7-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for casestudymarolon
CREATE DATABASE IF NOT EXISTS `casestudymarolon` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `casestudymarolon`;

-- Dumping structure for table casestudymarolon.authorities
CREATE TABLE IF NOT EXISTS `authorities` (
  `Authority` varchar(255) NOT NULL,
  `User_Id` bigint(20) NOT NULL,
  PRIMARY KEY (`User_Id`,`Authority`),
  CONSTRAINT `FKolqa79rfhyd8glm8s8x60ia2y` FOREIGN KEY (`User_Id`) REFERENCES `user` (`User_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table casestudymarolon.authorities: ~6 rows (approximately)
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` (`Authority`, `User_Id`) VALUES
	('ROLE_USER', 1),
	('ROLE_USER', 2),
	('ROLE_USER', 3),
	('ROLE_USER', 4),
	('ROLE_USER', 5),
	('ROLE_ADMIN', 6);
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;

-- Dumping structure for table casestudymarolon.comment
CREATE TABLE IF NOT EXISTS `comment` (
  `Comment_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Comment_Date` datetime NOT NULL,
  `Post` varchar(255) NOT NULL,
  `Event_Id` bigint(20) NOT NULL,
  `User_Id` bigint(20) NOT NULL,
  PRIMARY KEY (`Comment_Id`),
  KEY `FK9l1yqs8ysnqut72fv0strx4u0` (`Event_Id`),
  KEY `FKlqqya9ybucrbxjldrxkqvlhx6` (`User_Id`),
  CONSTRAINT `FK9l1yqs8ysnqut72fv0strx4u0` FOREIGN KEY (`Event_Id`) REFERENCES `event` (`Event_Id`),
  CONSTRAINT `FKlqqya9ybucrbxjldrxkqvlhx6` FOREIGN KEY (`User_Id`) REFERENCES `user` (`User_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- Dumping data for table casestudymarolon.comment: ~12 rows (approximately)
/*!40000 ALTER TABLE `comment` DISABLE KEYS */;
INSERT INTO `comment` (`Comment_Id`, `Comment_Date`, `Post`, `Event_Id`, `User_Id`) VALUES
	(1, '2019-11-09 23:31:34', '1', 1, 1),
	(2, '2019-11-09 23:31:45', '2', 1, 1),
	(3, '2019-11-09 23:31:55', '3', 4, 2),
	(4, '2019-11-09 23:32:04', '4', 4, 3),
	(5, '2019-11-09 23:32:50', '5', 3, 2),
	(6, '2019-11-09 23:41:51', 'Another one', 2, 4),
	(7, '2019-11-10 02:03:44', 'testing', 5, 4),
	(8, '2019-11-10 18:23:04', 'It\'s working!', 5, 1),
	(9, '2019-11-10 19:17:07', 'Yo', 2, 1),
	(10, '2019-11-10 19:17:23', 'Heyyyyyyyyyy', 3, 1),
	(11, '2019-11-10 19:18:55', 'I\'m new', 5, 5),
	(12, '2019-11-10 22:43:20', 'What a show!', 5, 1);
/*!40000 ALTER TABLE `comment` ENABLE KEYS */;

-- Dumping structure for table casestudymarolon.event
CREATE TABLE IF NOT EXISTS `event` (
  `Event_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `City` varchar(50) NOT NULL,
  `Event_Date` datetime NOT NULL,
  `Event_Name` varchar(50) NOT NULL,
  `State` varchar(50) NOT NULL,
  PRIMARY KEY (`Event_Id`),
  UNIQUE KEY `UK_lelx09wmf1snxkl0lg4pdgjb8` (`Event_Name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table casestudymarolon.event: ~5 rows (approximately)
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` (`Event_Id`, `City`, `Event_Date`, `Event_Name`, `State`) VALUES
	(1, 'Paradise', '2019-05-25 20:00:00', 'Double or Nothing', 'Nevada'),
	(2, 'Daytona Beach', '2019-06-29 20:00:00', 'Fyter Fest', 'Florida'),
	(3, 'Jacksonville', '2019-07-13 20:00:00', 'Fight for the Fallen', 'Florida'),
	(4, 'Hoffman Estates', '2019-08-31 20:00:00', 'All Out', 'Illinois'),
	(5, 'Baltimore', '2019-11-09 20:00:00', 'Full Gear', 'Maryland');
/*!40000 ALTER TABLE `event` ENABLE KEYS */;

-- Dumping structure for table casestudymarolon.event_wrestler
CREATE TABLE IF NOT EXISTS `event_wrestler` (
  `Event_Id` bigint(20) NOT NULL,
  `Wrestler_Id` bigint(20) NOT NULL,
  PRIMARY KEY (`Event_Id`,`Wrestler_Id`),
  KEY `FK39ymmyawpu8fo57dy4fvi0pmh` (`Wrestler_Id`),
  CONSTRAINT `FK39ymmyawpu8fo57dy4fvi0pmh` FOREIGN KEY (`Wrestler_Id`) REFERENCES `wrestler` (`Wrest_Id`),
  CONSTRAINT `FKobk1tepip7g6sh5qjjrmgeru3` FOREIGN KEY (`Event_Id`) REFERENCES `event` (`Event_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table casestudymarolon.event_wrestler: ~0 rows (approximately)
/*!40000 ALTER TABLE `event_wrestler` DISABLE KEYS */;
/*!40000 ALTER TABLE `event_wrestler` ENABLE KEYS */;

-- Dumping structure for table casestudymarolon.user
CREATE TABLE IF NOT EXISTS `user` (
  `User_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `User_DOB` datetime NOT NULL,
  `User_Desc` varchar(255) DEFAULT NULL,
  `User_Email` varchar(50) NOT NULL,
  `enabled` bit(1) NOT NULL,
  `User_Password` varchar(255) NOT NULL,
  `Username` varchar(50) NOT NULL,
  PRIMARY KEY (`User_Id`),
  UNIQUE KEY `UK_akxyafi0oics02wy6hspwkuiw` (`User_Email`),
  UNIQUE KEY `UK_581bctwspd9wmn7dtrkdcln8q` (`Username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table casestudymarolon.user: ~6 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`User_Id`, `User_DOB`, `User_Desc`, `User_Email`, `enabled`, `User_Password`, `Username`) VALUES
	(1, '1993-02-15 00:00:00', '', 'd@y.com', b'1', '$2a$10$tCM1MbUnk6TKcyIa7R8EIedgkMotbWjHQHPbIPDGLnjySssyJW9ry', 'm93'),
	(2, '1990-02-05 00:00:00', '', 'd4@g.com', b'1', '$2a$10$4qNaY5/.BapwjYER896oN.M5Iood2B6ULg79t/uz8QJutlo2MDV3q', 'm94'),
	(3, '2019-11-10 00:00:00', '', 'p@whatever.com', b'1', '$2a$10$vR6p4gmfH8IzejXjArIZQ.cLEgDIaW5HbhyVmP.BW3TOb5nQluqsq', 'p'),
	(4, '2019-01-01 00:00:00', 'Yup. ...', 'pega@mediodia.com', b'1', '$2a$10$xI6j2uhAaZjssQPGntJdr.p8RkHTlZQzp60aSsFZBO6TVKxaJtm6y', 'pega'),
	(5, '2019-01-01 00:00:00', '', 'test@g.com', b'1', '$2a$10$kCiKm.cIRnki2IzNd7ecjOS/41qzhtCmUC8..bpCKOzQYDB52h95.', 'test'),
	(6, '1979-11-14 00:00:00', 'admin', 'admin@admin.com', b'1', '$2a$10$WbPlDnCi8R.B1fEARgt6PuSsKcMg9mb1RQaGSB1PtS4GZ0eEVbLR2', 'admin');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table casestudymarolon.user_wrestler
CREATE TABLE IF NOT EXISTS `user_wrestler` (
  `User_Id` bigint(20) NOT NULL,
  `Wrestler_Id` bigint(20) NOT NULL,
  PRIMARY KEY (`User_Id`,`Wrestler_Id`),
  KEY `FK4h3nxpsidk7uayp9h57p1h6jx` (`Wrestler_Id`),
  CONSTRAINT `FK4h3nxpsidk7uayp9h57p1h6jx` FOREIGN KEY (`Wrestler_Id`) REFERENCES `wrestler` (`Wrest_Id`),
  CONSTRAINT `FKpu8uhi9tb7rxrq23krq845k6o` FOREIGN KEY (`User_Id`) REFERENCES `user` (`User_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table casestudymarolon.user_wrestler: ~4 rows (approximately)
/*!40000 ALTER TABLE `user_wrestler` DISABLE KEYS */;
INSERT INTO `user_wrestler` (`User_Id`, `Wrestler_Id`) VALUES
	(1, 1),
	(1, 3),
	(1, 4),
	(1, 5);
/*!40000 ALTER TABLE `user_wrestler` ENABLE KEYS */;

-- Dumping structure for table casestudymarolon.wrestler
CREATE TABLE IF NOT EXISTS `wrestler` (
  `Wrest_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Wrest_DOB` datetime NOT NULL,
  `Wrest_Desc` varchar(255) DEFAULT NULL,
  `Division` varchar(50) NOT NULL,
  `Wrest_Name` varchar(50) NOT NULL,
  PRIMARY KEY (`Wrest_Id`),
  UNIQUE KEY `UK_rl22ng6ymdry34vvjp1dkbavx` (`Wrest_Name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table casestudymarolon.wrestler: ~5 rows (approximately)
/*!40000 ALTER TABLE `wrestler` DISABLE KEYS */;
INSERT INTO `wrestler` (`Wrest_Id`, `Wrest_DOB`, `Wrest_Desc`, `Division`, `Wrest_Name`) VALUES
	(1, '1970-11-09 00:00:00', 'AEW Champion', 'Men\'s', 'Chris Jericho'),
	(2, '1997-06-04 00:00:00', 'AEW Women\'s Champion', 'Women\'s', 'Riho'),
	(3, '1985-06-30 00:00:00', 'AEW Executive Vice President', 'Men\'s', 'Cody'),
	(4, '1969-04-11 00:00:00', 'Coach', 'Men\'s', 'Dustin Rhodes'),
	(5, '1996-03-15 00:00:00', 'Former MLW Tag-Team Champion', 'Men\'s', 'Maxwell Jacob Friedman');
/*!40000 ALTER TABLE `wrestler` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
