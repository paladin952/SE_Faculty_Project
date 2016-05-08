-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.7.11-log - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for ubbdb
CREATE DATABASE IF NOT EXISTS `ubbdb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `ubbdb`;


-- Dumping structure for table ubbdb.degree
CREATE TABLE IF NOT EXISTS `degree` (
  `DegreeID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Field` varchar(255) NOT NULL,
  `Type` int(11) DEFAULT NULL,
  `Duration` int(10) unsigned NOT NULL,
  `FacultyID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`DegreeID`),
  KEY `FK_DegreeFacultyID` (`FacultyID`),
  CONSTRAINT `FK_DegreeFacultyID` FOREIGN KEY (`FacultyID`) REFERENCES `faculty` (`FacultyID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.degree: ~0 rows (approximately)
/*!40000 ALTER TABLE `degree` DISABLE KEYS */;
/*!40000 ALTER TABLE `degree` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
