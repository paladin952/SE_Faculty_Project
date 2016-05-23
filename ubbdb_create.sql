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


-- Dumping structure for table ubbdb.activity
CREATE TABLE IF NOT EXISTS `activity` (
  `ActivityID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `ActivityType` int(11) NOT NULL COMMENT '1 = course, 2 = seminar, 3 = lab',
  `HoursPerWeek` int(11) NOT NULL DEFAULT '2',
  `CourseID` varchar(10) NOT NULL,
  PRIMARY KEY (`ActivityID`),
  KEY `FK_ActivityCourseID` (`CourseID`),
  CONSTRAINT `FK_ActivityCourseID` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.activity: ~29 rows (approximately)
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
INSERT INTO `activity` (`ActivityID`, `ActivityType`, `HoursPerWeek`, `CourseID`) VALUES
	(1, 1, 2, 'AI101'),
	(2, 2, 2, 'AI101'),
	(3, 3, 2, 'AI101'),
	(4, 1, 2, 'SE101'),
	(5, 2, 2, 'SE101'),
	(6, 3, 2, 'SE101'),
	(7, 1, 2, 'SDI101'),
	(8, 3, 2, 'SDI101'),
	(9, 1, 2, 'WP101'),
	(10, 3, 2, 'WP101'),
	(11, 1, 2, 'DBMS101'),
	(12, 2, 2, 'DBMS101'),
	(13, 3, 2, 'DBMS101'),
	(14, 1, 2, 'ASM101'),
	(15, 2, 2, 'ASM101'),
	(16, 3, 2, 'ASM101'),
	(17, 1, 2, 'CN101'),
	(18, 3, 2, 'CN101'),
	(19, 1, 2, 'FP101'),
	(20, 2, 2, 'FP101'),
	(21, 3, 2, 'FP101'),
	(22, 1, 2, 'LA101'),
	(23, 2, 2, 'LA101'),
	(24, 1, 2, 'OOP101'),
	(25, 2, 2, 'OOP101'),
	(26, 3, 2, 'OOP101'),
	(27, 1, 2, 'OS101'),
	(28, 2, 2, 'OS101'),
	(29, 3, 2, 'OS101');
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;


-- Dumping structure for table ubbdb.admin
CREATE TABLE IF NOT EXISTS `admin` (
  `AdminID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `UserID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`AdminID`),
  KEY `FK_AdminUserID` (`UserID`),
  CONSTRAINT `FK_AdminUserID` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.admin: ~9 rows (approximately)
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` (`AdminID`, `UserID`) VALUES
	(1, 1),
	(9, 8),
	(2, 14),
	(8, 19),
	(7, 22),
	(3, 24),
	(4, 28),
	(5, 29),
	(6, 30);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;


-- Dumping structure for table ubbdb.course
CREATE TABLE IF NOT EXISTS `course` (
  `CourseID` varchar(10) NOT NULL,
  `DegreeID` int(10) unsigned DEFAULT '0',
  `Name` varchar(50) NOT NULL,
  `Credits` int(10) unsigned NOT NULL DEFAULT '0',
  `AssignedSemester` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`CourseID`),
  KEY `FK_CourseDegreeID` (`DegreeID`),
  CONSTRAINT `FK_CourseDegreeID` FOREIGN KEY (`DegreeID`) REFERENCES `degree` (`DegreeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.course: ~13 rows (approximately)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`CourseID`, `DegreeID`, `Name`, `Credits`, `AssignedSemester`) VALUES
	('AI101', 1, 'Artificial intelligence', 6, 4),
	('ASM101', 1, 'Computer systems architecture', 6, 1),
	('CN101', 1, 'Computer networks', 6, 3),
	('DBMS101', 1, 'Database management systems', 6, 4),
	('FP101', 1, 'Fundamentals of programming', 6, 1),
	('LA101', 1, 'Linear algebra', 6, 1),
	('OOP101', 1, 'Object-oriented programming', 6, 2),
	('OS101', 1, 'Operating systems', 5, 2),
	('PKC101', 1, 'Public key cryptography', 4, 5),
	('SDI101', 1, 'Systems for design and implementation', 6, 4),
	('SE101', 1, 'Software engineering', 6, 4),
	('VR101', 1, 'Virtual reality', 4, 5),
	('WP101', 1, 'Web programming', 6, 4);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


-- Dumping structure for table ubbdb.degree
CREATE TABLE IF NOT EXISTS `degree` (
  `DegreeID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Field` varchar(255) NOT NULL,
  `Type` int(11) DEFAULT NULL COMMENT '1 = BsC, 2 = MsC, 3 = PhD',
  `Duration` int(10) unsigned NOT NULL COMMENT 'in years',
  `FacultyID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`DegreeID`),
  KEY `FK_DegreeFacultyID` (`FacultyID`),
  CONSTRAINT `FK_DegreeFacultyID` FOREIGN KEY (`FacultyID`) REFERENCES `faculty` (`FacultyID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.degree: ~4 rows (approximately)
/*!40000 ALTER TABLE `degree` DISABLE KEYS */;
INSERT INTO `degree` (`DegreeID`, `Field`, `Type`, `Duration`, `FacultyID`) VALUES
	(1, 'Computer Science', 1, 3, 1),
	(2, 'Mathematics', 1, 3, 1),
	(3, 'Mathematics and Computer Science', 1, 3, 1),
	(4, 'Databases', 2, 2, 1);
/*!40000 ALTER TABLE `degree` ENABLE KEYS */;


-- Dumping structure for table ubbdb.degreelanguage
CREATE TABLE IF NOT EXISTS `degreelanguage` (
  `LanguageID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Shorthand` varchar(3) NOT NULL,
  `DegreeID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`LanguageID`),
  KEY `FK_DegreeID` (`DegreeID`),
  CONSTRAINT `FK_DegreeID` FOREIGN KEY (`DegreeID`) REFERENCES `degree` (`DegreeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.degreelanguage: ~9 rows (approximately)
/*!40000 ALTER TABLE `degreelanguage` DISABLE KEYS */;
INSERT INTO `degreelanguage` (`LanguageID`, `Shorthand`, `DegreeID`) VALUES
	(1, 'RO', 1),
	(2, 'RO', 2),
	(3, 'RO', 3),
	(4, 'EN', 1),
	(5, 'DE', 1),
	(6, 'HU', 2),
	(7, 'HU', 3),
	(8, 'HU', 1),
	(9, 'RO', 4);
/*!40000 ALTER TABLE `degreelanguage` ENABLE KEYS */;


-- Dumping structure for table ubbdb.department
CREATE TABLE IF NOT EXISTS `department` (
  `DepartmentID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(50) NOT NULL,
  PRIMARY KEY (`DepartmentID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.department: ~2 rows (approximately)
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`DepartmentID`, `Name`) VALUES
	(1, 'computer science'),
	(2, 'matemathics');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;


-- Dumping structure for table ubbdb.enrolled
CREATE TABLE IF NOT EXISTS `enrolled` (
  `EnrolledID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `StudentID` int(10) unsigned NOT NULL,
  `CourseID` varchar(30) NOT NULL,
  PRIMARY KEY (`EnrolledID`),
  KEY `FK_EnrolledCourseID` (`CourseID`),
  KEY `FK_EnrolledStudentID` (`StudentID`),
  CONSTRAINT `FK_EnrolledCourseID` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_EnrolledStudentID` FOREIGN KEY (`StudentID`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=153 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.enrolled: ~125 rows (approximately)
/*!40000 ALTER TABLE `enrolled` DISABLE KEYS */;
INSERT INTO `enrolled` (`EnrolledID`, `StudentID`, `CourseID`) VALUES
	(3, 4, 'AI101'),
	(4, 5, 'AI101'),
	(5, 6, 'AI101'),
	(6, 7, 'AI101'),
	(7, 8, 'AI101'),
	(8, 9, 'AI101'),
	(9, 10, 'AI101'),
	(10, 11, 'AI101'),
	(11, 12, 'AI101'),
	(12, 13, 'AI101'),
	(13, 14, 'AI101'),
	(14, 16, 'AI101'),
	(15, 17, 'AI101'),
	(16, 18, 'AI101'),
	(17, 19, 'AI101'),
	(18, 20, 'AI101'),
	(19, 21, 'AI101'),
	(20, 22, 'AI101'),
	(21, 23, 'AI101'),
	(22, 25, 'AI101'),
	(23, 26, 'AI101'),
	(24, 27, 'AI101'),
	(25, 28, 'AI101'),
	(26, 29, 'AI101'),
	(27, 4, 'DBMS101'),
	(28, 5, 'DBMS101'),
	(29, 6, 'DBMS101'),
	(30, 7, 'DBMS101'),
	(31, 8, 'DBMS101'),
	(32, 9, 'DBMS101'),
	(33, 10, 'DBMS101'),
	(34, 11, 'DBMS101'),
	(35, 12, 'DBMS101'),
	(36, 13, 'DBMS101'),
	(37, 14, 'DBMS101'),
	(38, 16, 'DBMS101'),
	(39, 17, 'DBMS101'),
	(40, 18, 'DBMS101'),
	(41, 19, 'DBMS101'),
	(42, 20, 'DBMS101'),
	(43, 21, 'DBMS101'),
	(44, 22, 'DBMS101'),
	(45, 23, 'DBMS101'),
	(46, 25, 'DBMS101'),
	(47, 26, 'DBMS101'),
	(48, 27, 'DBMS101'),
	(49, 28, 'DBMS101'),
	(50, 29, 'DBMS101'),
	(51, 24, 'AI101'),
	(52, 24, 'DBMS101'),
	(78, 4, 'SDI101'),
	(79, 5, 'SDI101'),
	(80, 6, 'SDI101'),
	(81, 7, 'SDI101'),
	(82, 8, 'SDI101'),
	(83, 9, 'SDI101'),
	(84, 10, 'SDI101'),
	(85, 11, 'SDI101'),
	(86, 12, 'SDI101'),
	(87, 13, 'SDI101'),
	(88, 14, 'SDI101'),
	(89, 16, 'SDI101'),
	(90, 17, 'SDI101'),
	(91, 18, 'SDI101'),
	(92, 19, 'SDI101'),
	(93, 20, 'SDI101'),
	(94, 21, 'SDI101'),
	(95, 22, 'SDI101'),
	(96, 23, 'SDI101'),
	(97, 25, 'SDI101'),
	(98, 26, 'SDI101'),
	(99, 24, 'SDI101'),
	(100, 27, 'SDI101'),
	(101, 28, 'SDI101'),
	(102, 29, 'SDI101'),
	(103, 4, 'SE101'),
	(104, 5, 'SE101'),
	(105, 6, 'SE101'),
	(106, 7, 'SE101'),
	(107, 8, 'SE101'),
	(108, 9, 'SE101'),
	(109, 10, 'SE101'),
	(110, 11, 'SE101'),
	(111, 12, 'SE101'),
	(112, 13, 'SE101'),
	(113, 14, 'SE101'),
	(114, 16, 'SE101'),
	(115, 17, 'SE101'),
	(116, 18, 'SE101'),
	(117, 19, 'SE101'),
	(118, 20, 'SE101'),
	(119, 21, 'SE101'),
	(120, 22, 'SE101'),
	(121, 23, 'SE101'),
	(122, 25, 'SE101'),
	(123, 26, 'SE101'),
	(124, 24, 'SE101'),
	(125, 27, 'SE101'),
	(126, 28, 'SE101'),
	(127, 29, 'SE101'),
	(128, 4, 'WP101'),
	(129, 5, 'WP101'),
	(130, 6, 'WP101'),
	(131, 7, 'WP101'),
	(132, 8, 'WP101'),
	(133, 9, 'WP101'),
	(134, 10, 'WP101'),
	(135, 11, 'WP101'),
	(136, 12, 'WP101'),
	(137, 13, 'WP101'),
	(138, 14, 'WP101'),
	(139, 16, 'WP101'),
	(140, 17, 'WP101'),
	(141, 18, 'WP101'),
	(142, 19, 'WP101'),
	(143, 20, 'WP101'),
	(144, 21, 'WP101'),
	(145, 22, 'WP101'),
	(146, 23, 'WP101'),
	(147, 25, 'WP101'),
	(148, 26, 'WP101'),
	(149, 24, 'WP101'),
	(150, 27, 'WP101'),
	(151, 28, 'WP101'),
	(152, 29, 'WP101');
/*!40000 ALTER TABLE `enrolled` ENABLE KEYS */;


-- Dumping structure for table ubbdb.evaluation
CREATE TABLE IF NOT EXISTS `evaluation` (
  `EvaluationID` int(11) NOT NULL AUTO_INCREMENT,
  `EvaluationType` int(11) NOT NULL DEFAULT '0' COMMENT '1 = written exam, 2 = practical exam, 3 = project, 4 = misc',
  `CourseID` varchar(10) NOT NULL,
  PRIMARY KEY (`EvaluationID`),
  KEY `FK_EvaluationCourseID` (`CourseID`),
  CONSTRAINT `FK_EvaluationCourseID` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.evaluation: ~19 rows (approximately)
/*!40000 ALTER TABLE `evaluation` DISABLE KEYS */;
INSERT INTO `evaluation` (`EvaluationID`, `EvaluationType`, `CourseID`) VALUES
	(1, 1, 'SE101'),
	(3, 1, 'AI101'),
	(4, 2, 'AI101'),
	(5, 1, 'ASM101'),
	(6, 2, 'ASM101'),
	(7, 1, 'CN101'),
	(8, 2, 'CN101'),
	(9, 1, 'DBMS101'),
	(10, 2, 'DBMS101'),
	(11, 1, 'FP101'),
	(12, 2, 'FP101'),
	(13, 1, 'LA101'),
	(14, 1, 'OOP101'),
	(15, 2, 'OOP101'),
	(16, 1, 'OS101'),
	(17, 2, 'OS101'),
	(18, 1, 'SDI101'),
	(19, 2, 'SDI101'),
	(20, 2, 'WP101');
/*!40000 ALTER TABLE `evaluation` ENABLE KEYS */;


-- Dumping structure for table ubbdb.faculty
CREATE TABLE IF NOT EXISTS `faculty` (
  `FacultyID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (`FacultyID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.faculty: ~1 rows (approximately)
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` (`FacultyID`, `Name`) VALUES
	(1, 'Faculty of mathematics and computer science');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;


-- Dumping structure for table ubbdb.optionalcourse
CREATE TABLE IF NOT EXISTS `optionalcourse` (
  `OptionalCourseID` int(11) NOT NULL AUTO_INCREMENT,
  `CourseID` varchar(30) NOT NULL,
  `GroupNo` int(10) unsigned NOT NULL,
  PRIMARY KEY (`OptionalCourseID`),
  KEY `FK_OptionalCourseCourseID` (`CourseID`),
  CONSTRAINT `FK_OptionalCourseCourseID` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.optionalcourse: ~2 rows (approximately)
/*!40000 ALTER TABLE `optionalcourse` DISABLE KEYS */;
INSERT INTO `optionalcourse` (`OptionalCourseID`, `CourseID`, `GroupNo`) VALUES
	(1, 'VR101', 2),
	(3, 'PKC101', 3);
/*!40000 ALTER TABLE `optionalcourse` ENABLE KEYS */;


-- Dumping structure for table ubbdb.person
CREATE TABLE IF NOT EXISTS `person` (
  `PersonID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(30) NOT NULL,
  `LastName` varchar(30) NOT NULL,
  `DoB` date DEFAULT NULL,
  `SSN` bigint(20) NOT NULL COMMENT ' = CNP',
  `Address` varchar(255) DEFAULT 'Cluj',
  `PhoneNo` int(11) DEFAULT '0',
  `UserID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`PersonID`),
  KEY `FK_PersonUserID` (`UserID`),
  CONSTRAINT `FK_PersonUserID` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.person: ~40 rows (approximately)
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` (`PersonID`, `FirstName`, `LastName`, `DoB`, `SSN`, `Address`, `PhoneNo`, `UserID`) VALUES
	(7, 'Radu', 'Corbu', '1995-06-02', 1, 'Lothric', 743760319, 8),
	(8, 'Helga', 'Fekete', '1995-11-06', 2, 'Cluj', 0, 6),
	(9, 'Felix', 'Dănuț', '1995-01-18', 1, 'Cluj', 0, 7),
	(10, 'Leonard', 'Corocea', '1995-03-08', 1, 'Cluj', 0, 9),
	(11, 'Cosmin', 'Coman', '1995-07-13', 1, 'Cluj', 0, 10),
	(12, 'Daniela', 'Crăciun', '1995-03-19', 2, 'Cluj', 0, 11),
	(13, 'Diana', 'Dobra', '1995-06-09', 2, 'Cluj', 0, 12),
	(14, 'Andreea', 'Coman', '1995-02-19', 2, 'Cluj', 0, 13),
	(15, 'Diana', 'Cosma', '1995-12-04', 2, 'Hogwarts', 0, 14),
	(16, 'Adina', 'Vlașin', '1995-01-01', 2, 'Cluj', 0, 15),
	(17, 'Lucian', 'Clapa', '1995-02-10', 1, 'Cluj', 0, 30),
	(18, 'Gabriel', 'Crăciunaș', '1995-03-24', 1, 'Cluj', 0, 16),
	(19, 'Mircea', 'Ciuciu', '1995-12-19', 1, 'Cluj', 0, 20),
	(20, 'Vasile', 'Drăghiță', '1993-03-31', 1, 'Cluj', 0, 17),
	(21, 'Adrian', 'Crăciunean', '1995-06-12', 1, 'Cluj', 0, 18),
	(22, 'Nichita', 'Diaconu', '1995-01-01', 1, 'Cluj', 0, 19),
	(23, 'Dan', 'Dreve', '1994-09-15', 1, 'Cluj', 0, 21),
	(24, 'Cătălin', 'Cioba', '1995-09-24', 1, 'Cluj', 0, 22),
	(25, 'Adrian', 'Deleanu', '1995-01-01', 1, 'Cluj', 0, 23),
	(26, 'Bianca', 'Ceclan', '1995-02-21', 2, 'Cluj', 0, 24),
	(27, 'Alexandra', 'Petruț', '1995-06-22', 2, 'Cluj', 0, 31),
	(28, 'Daniel', 'Bogdan', '1994-11-23', 1, 'Cluj', 0, 25),
	(29, 'Alexandru', 'Damian', '1995-01-01', 1, 'Cluj', 0, 26),
	(30, 'Dana', 'Rus', '1995-11-05', 2, 'Cluj', 0, 28),
	(31, 'Dana Alexandra', 'Ciubăncan', '1995-01-01', 2, 'Cluj', 0, 30),
	(32, 'Dan', 'Chiorean', '1970-01-01', 1, 'Cluj', 0, 32),
	(33, 'Tudor', 'Mihoc', '1970-01-01', 1, 'Cluj', 0, 43),
	(34, 'Dănuț', 'Pop', '1970-01-01', 1, 'Cluj', 0, 44),
	(35, 'Dan Mircea', 'Suciu', '1970-01-01', 1, 'Cluj', 0, 42),
	(36, 'Adrian', 'Stercă', '1970-01-01', 1, 'Cluj', 0, 41),
	(37, 'Sabina', 'Surdu', '1970-01-01', 1, 'Cluj', 0, 45),
	(38, 'Radu', 'Găceanu', '1970-01-01', 1, 'Cluj', 0, 34),
	(39, 'Diana', 'Haliță', '1970-01-01', 1, 'Cluj', 0, 40),
	(40, 'Camelia', 'Andor', '1970-01-01', 1, 'Cluj', 0, 46),
	(41, 'Alexandru', 'Vancea', '1970-01-01', 1, 'Cluj', 0, 36),
	(42, 'Radu', 'Dragoș', '1970-01-01', 1, 'Cluj', 0, 39),
	(43, 'Rareș', 'Boian', '1970-01-01', 1, 'Cluj', 0, 35),
	(44, 'Iuliana', 'Bocicor', '1970-01-01', 1, 'Cluj', 0, 33),
	(45, 'Istvan', 'Czibula', '1970-01-01', 1, 'Cluj', 0, 38),
	(46, 'Septimiu', 'Crivei', '1970-01-01', 1, 'Cluj', 0, 47);
/*!40000 ALTER TABLE `person` ENABLE KEYS */;


-- Dumping structure for table ubbdb.professor
CREATE TABLE IF NOT EXISTS `professor` (
  `ProfessorID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `DepartmentID` int(10) unsigned NOT NULL DEFAULT '0',
  `IsChief` int(10) NOT NULL DEFAULT '0' COMMENT 'is chief of his/her department?',
  `Wage` float NOT NULL DEFAULT '13.37',
  `PersonID` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`ProfessorID`),
  KEY `FK_ProfessorDepartmentID` (`DepartmentID`),
  KEY `FK_ProfessorPersonID` (`PersonID`),
  CONSTRAINT `FK_ProfessorDepartmentID` FOREIGN KEY (`DepartmentID`) REFERENCES `department` (`DepartmentID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ProfessorPersonID` FOREIGN KEY (`PersonID`) REFERENCES `person` (`PersonID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.professor: ~15 rows (approximately)
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
INSERT INTO `professor` (`ProfessorID`, `DepartmentID`, `IsChief`, `Wage`, `PersonID`) VALUES
	(7, 1, 1, 13.37, 43),
	(9, 1, 0, 13.37, 36),
	(10, 1, 0, 13.37, 41),
	(11, 2, 0, 13.37, 46),
	(12, 1, 0, 13.37, 40),
	(15, 1, 0, 13.37, 35),
	(16, 1, 0, 13.37, 34),
	(17, 1, 0, 13.37, 39),
	(18, 1, 0, 13.37, 32),
	(19, 1, 0, 13.37, 45),
	(20, 1, 0, 13.37, 44),
	(23, 1, 0, 13.37, 42),
	(24, 1, 0, 13.37, 38),
	(27, 1, 0, 13.37, 37),
	(28, 1, 0, 13.37, 33);
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;


-- Dumping structure for table ubbdb.scholarship
CREATE TABLE IF NOT EXISTS `scholarship` (
  `ScholarshipID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `Award` float unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`ScholarshipID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.scholarship: ~4 rows (approximately)
/*!40000 ALTER TABLE `scholarship` DISABLE KEYS */;
INSERT INTO `scholarship` (`ScholarshipID`, `Name`, `Award`) VALUES
	(1, 'study scholarship', 350),
	(2, 'premium scholarship', 400),
	(3, 'gold scholarship', 450),
	(4, 'platinum scholarship', 500);
/*!40000 ALTER TABLE `scholarship` ENABLE KEYS */;


-- Dumping structure for table ubbdb.student
CREATE TABLE IF NOT EXISTS `student` (
  `StudentID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `GroupID` int(10) unsigned NOT NULL DEFAULT '923',
  `Status` varchar(30) DEFAULT 'Enrolled',
  `IsExtended` int(11) DEFAULT '0' COMMENT 'i.e. is taking another year of courses, to accumulate enough credits to graduate',
  `PersonID` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`StudentID`),
  KEY `FK_StudentGroupID` (`GroupID`),
  KEY `FK_StudentPersonID` (`PersonID`),
  CONSTRAINT `FK_StudentGroupID` FOREIGN KEY (`GroupID`) REFERENCES `studentgroup` (`StudentGroupID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_StudentPersonID` FOREIGN KEY (`PersonID`) REFERENCES `person` (`PersonID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.student: ~24 rows (approximately)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`StudentID`, `GroupID`, `Status`, `IsExtended`, `PersonID`) VALUES
	(4, 923, 'Enrolled', 0, 16),
	(5, 923, 'Enrolled', 0, 21),
	(6, 923, 'Enrolled', 0, 25),
	(7, 923, 'Enrolled', 0, 27),
	(8, 923, 'Enrolled', 0, 29),
	(9, 923, 'Enrolled', 0, 14),
	(10, 923, 'Enrolled', 0, 26),
	(11, 923, 'Enrolled', 0, 24),
	(12, 923, 'Enrolled', 0, 11),
	(13, 923, 'Enrolled', 0, 23),
	(14, 923, 'Enrolled', 0, 30),
	(16, 923, 'Enrolled', 0, 28),
	(17, 923, 'Enrolled', 0, 12),
	(18, 923, 'Enrolled', 0, 13),
	(19, 923, 'Enrolled', 0, 15),
	(20, 923, 'Enrolled', 0, 9),
	(21, 923, 'Enrolled', 0, 18),
	(22, 923, 'Enrolled', 0, 8),
	(23, 923, 'Enrolled', 0, 10),
	(24, 923, 'Enrolled', 0, 17),
	(25, 923, 'Enrolled', 0, 19),
	(26, 923, 'Enrolled', 0, 22),
	(27, 923, 'Enrolled', 0, 7),
	(28, 923, 'Enrolled', 0, 20),
	(29, 923, 'Enrolled', 0, 31);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;


-- Dumping structure for table ubbdb.studentevaluation
CREATE TABLE IF NOT EXISTS `studentevaluation` (
  `StudentEvaluationID` int(10) NOT NULL AUTO_INCREMENT,
  `EvaluationID` int(10) NOT NULL,
  `StudentID` int(10) unsigned NOT NULL,
  `Grade` float unsigned DEFAULT NULL,
  `IsAbsent` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`StudentEvaluationID`),
  KEY `FK_StudentEvaluationStudentID` (`StudentID`),
  KEY `FK_StudentEvaluationEvaluationID` (`EvaluationID`),
  CONSTRAINT `FK_StudentEvaluationEvaluationID` FOREIGN KEY (`EvaluationID`) REFERENCES `evaluation` (`EvaluationID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_StudentEvaluationStudentID` FOREIGN KEY (`StudentID`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.studentevaluation: ~1 rows (approximately)
/*!40000 ALTER TABLE `studentevaluation` DISABLE KEYS */;
INSERT INTO `studentevaluation` (`StudentEvaluationID`, `EvaluationID`, `StudentID`, `Grade`, `IsAbsent`) VALUES
	(5, 6, 27, 10, 0),
	(6, 5, 27, 8.92, 0),
	(7, 8, 27, 10, 0),
	(8, 7, 27, 7.3, 0),
	(9, 11, 27, 8.75, 0),
	(10, 12, 27, 10, 0),
	(11, 13, 27, 9, 0),
	(12, 14, 27, 6.2, 0),
	(13, 15, 27, 7, 0),
	(14, 16, 27, 9.3, 0),
	(15, 17, 27, 10, 0);
/*!40000 ALTER TABLE `studentevaluation` ENABLE KEYS */;


-- Dumping structure for table ubbdb.studentgroup
CREATE TABLE IF NOT EXISTS `studentgroup` (
  `StudentGroupID` int(10) unsigned NOT NULL,
  `CurrentSemester` int(10) unsigned NOT NULL,
  PRIMARY KEY (`StudentGroupID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.studentgroup: ~3 rows (approximately)
/*!40000 ALTER TABLE `studentgroup` DISABLE KEYS */;
INSERT INTO `studentgroup` (`StudentGroupID`, `CurrentSemester`) VALUES
	(913, 2),
	(923, 4),
	(933, 5);
/*!40000 ALTER TABLE `studentgroup` ENABLE KEYS */;


-- Dumping structure for table ubbdb.studentoptionalcourse
CREATE TABLE IF NOT EXISTS `studentoptionalcourse` (
  `StudentOptionalCourseID` int(11) NOT NULL AUTO_INCREMENT,
  `OptionalCourseID` int(11) NOT NULL,
  `StudentID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`StudentOptionalCourseID`),
  KEY `FK_StudentOptionalCourseStudentID` (`StudentID`),
  KEY `FK_StudentOptionalCourseOptionalCourseID` (`OptionalCourseID`),
  CONSTRAINT `FK_StudentOptionalCourseOptionalCourseID` FOREIGN KEY (`OptionalCourseID`) REFERENCES `optionalcourse` (`OptionalCourseID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_StudentOptionalCourseStudentID` FOREIGN KEY (`StudentID`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.studentoptionalcourse: ~0 rows (approximately)
/*!40000 ALTER TABLE `studentoptionalcourse` DISABLE KEYS */;
INSERT INTO `studentoptionalcourse` (`StudentOptionalCourseID`, `OptionalCourseID`, `StudentID`) VALUES
	(2, 1, 27),
	(3, 3, 27),
	(4, 1, 24),
	(5, 3, 24);
/*!40000 ALTER TABLE `studentoptionalcourse` ENABLE KEYS */;


-- Dumping structure for table ubbdb.studentscholarship
CREATE TABLE IF NOT EXISTS `studentscholarship` (
  `StudentScholarshipID` int(11) NOT NULL AUTO_INCREMENT,
  `ScholarshipID` int(11) unsigned NOT NULL,
  `StudentID` int(11) unsigned NOT NULL,
  PRIMARY KEY (`StudentScholarshipID`),
  KEY `FK_StudentScholarshipScholarshipID` (`ScholarshipID`),
  KEY `FK_StudentScholarshipStudentID` (`StudentID`),
  CONSTRAINT `FK_StudentScholarshipScholarshipID` FOREIGN KEY (`ScholarshipID`) REFERENCES `scholarship` (`ScholarshipID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_StudentScholarshipStudentID` FOREIGN KEY (`StudentID`) REFERENCES `student` (`StudentID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.studentscholarship: ~0 rows (approximately)
/*!40000 ALTER TABLE `studentscholarship` DISABLE KEYS */;
INSERT INTO `studentscholarship` (`StudentScholarshipID`, `ScholarshipID`, `StudentID`) VALUES
	(2, 1, 11),
	(3, 1, 29);
/*!40000 ALTER TABLE `studentscholarship` ENABLE KEYS */;


-- Dumping structure for table ubbdb.user
CREATE TABLE IF NOT EXISTS `user` (
  `UserID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Username` varchar(30) NOT NULL DEFAULT 'admin',
  `Password` varchar(30) NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.user: ~43 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`UserID`, `Username`, `Password`) VALUES
	(1, 'admin', 'admin'),
	(6, 'helga', 'helga'),
	(7, 'felix', 'felix'),
	(8, 'radu', 'radu'),
	(9, 'leo', 'leo'),
	(10, 'cosmin', 'cosmin'),
	(11, 'daniela', 'daniela'),
	(12, 'dianad', 'dianad'),
	(13, 'andreea', 'andreea'),
	(14, 'dianac', 'dianac'),
	(15, 'adina', 'adina'),
	(16, 'gabi', 'gabi'),
	(17, 'vasile', 'vasile'),
	(18, 'adic', 'adic'),
	(19, 'nichita', 'nichita'),
	(20, 'mircea', 'mircea'),
	(21, 'dan', 'dan'),
	(22, 'cata', 'cata'),
	(23, 'adid', 'adid'),
	(24, 'bianca', 'bianca'),
	(25, 'bogdan', 'bogdan'),
	(26, 'razvan', 'razvan'),
	(27, 'alex', 'alex'),
	(28, 'danar', 'danar'),
	(29, 'danac', 'danac'),
	(30, 'lucian', 'lucian'),
	(31, 'alexandra', 'alexandra'),
	(32, 'p_danch', 'p_danch'),
	(33, 'p_iulianabo', 'p_iulianabo'),
	(34, 'p_raduga', 'p_raduga'),
	(35, 'p_raresbo', 'p_raresbo'),
	(36, 'p_alexandruva', 'p_alexandruva'),
	(37, 'p_sandadr', 'p_sandadr'),
	(38, 'p_istvanc', 'p_istvanc'),
	(39, 'p_radudr', 'p_radudr'),
	(40, 'p_dianaha', 'p_dianaha'),
	(41, 'p_forest', 'p_forest'),
	(42, 'p_tzutzu', 'p_tzutzu'),
	(43, 'p_tudormi', 'p_tudormi'),
	(44, 'p_danutpo', 'p_danutpo'),
	(45, 'p_sabinasu', 'p_sabinasu'),
	(46, 'p_cameliaan', 'p_cameliaan'),
	(47, 'p_septimiucr', 'p_septimiucr');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
