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

-- Dumping structure for table casestudymarolon.event
CREATE TABLE IF NOT EXISTS `event` (
  `Event_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `City` varchar(255) NOT NULL,
  `Event_Date` datetime NOT NULL,
  `State` varchar(255) NOT NULL,
  PRIMARY KEY (`Event_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table casestudymarolon.event_wrestler
CREATE TABLE IF NOT EXISTS `event_wrestler` (
  `Event_Id` bigint(20) NOT NULL,
  `Wrestler_Id` bigint(20) NOT NULL,
  PRIMARY KEY (`Event_Id`,`Wrestler_Id`),
  KEY `FK39ymmyawpu8fo57dy4fvi0pmh` (`Wrestler_Id`),
  CONSTRAINT `FK39ymmyawpu8fo57dy4fvi0pmh` FOREIGN KEY (`Wrestler_Id`) REFERENCES `wrestler` (`Wrest_Id`),
  CONSTRAINT `FKobk1tepip7g6sh5qjjrmgeru3` FOREIGN KEY (`Event_Id`) REFERENCES `event` (`Event_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table casestudymarolon.user
CREATE TABLE IF NOT EXISTS `user` (
  `User_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `User_DOB` datetime NOT NULL,
  `User_Desc` varchar(255) DEFAULT NULL,
  `User_Email` varchar(255) NOT NULL,
  PRIMARY KEY (`User_Id`),
  UNIQUE KEY `UK_akxyafi0oics02wy6hspwkuiw` (`User_Email`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table casestudymarolon.user_wrestler
CREATE TABLE IF NOT EXISTS `user_wrestler` (
  `User_Id` bigint(20) NOT NULL,
  `Wrestler_Id` bigint(20) NOT NULL,
  PRIMARY KEY (`User_Id`,`Wrestler_Id`),
  KEY `FK4h3nxpsidk7uayp9h57p1h6jx` (`Wrestler_Id`),
  CONSTRAINT `FK4h3nxpsidk7uayp9h57p1h6jx` FOREIGN KEY (`Wrestler_Id`) REFERENCES `wrestler` (`Wrest_Id`),
  CONSTRAINT `FKpu8uhi9tb7rxrq23krq845k6o` FOREIGN KEY (`User_Id`) REFERENCES `user` (`User_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

-- Dumping structure for table casestudymarolon.wrestler
CREATE TABLE IF NOT EXISTS `wrestler` (
  `Wrest_Id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Wrest_DOB` datetime NOT NULL,
  `Wrest_Desc` varchar(255) DEFAULT NULL,
  `Division` varchar(255) NOT NULL,
  `Wrest_Name` varchar(255) NOT NULL,
  PRIMARY KEY (`Wrest_Id`),
  UNIQUE KEY `UK_rl22ng6ymdry34vvjp1dkbavx` (`Wrest_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Data exporting was unselected.

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
