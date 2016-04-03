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
  `ActivityType` int(10) NOT NULL,
  `CourseID` varchar(10) NOT NULL,
  PRIMARY KEY (`ActivityID`),
  KEY `FK_ActivityCourseID` (`CourseID`),
  CONSTRAINT `FK_ActivityCourseID` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.activity: ~0 rows (approximately)
/*!40000 ALTER TABLE `activity` DISABLE KEYS */;
/*!40000 ALTER TABLE `activity` ENABLE KEYS */;


-- Dumping structure for table ubbdb.course
CREATE TABLE IF NOT EXISTS `course` (
  `CourseID` varchar(10) NOT NULL,
  `DegreeID` int(10) unsigned DEFAULT '0',
  `Name` varchar(30) NOT NULL,
  `Credits` int(10) unsigned NOT NULL DEFAULT '0',
  `EvaluationType` int(10) NOT NULL DEFAULT '0',
  `AssignedSemester` int(10) unsigned DEFAULT '0',
  PRIMARY KEY (`CourseID`),
  KEY `FK_CourseDegreeID` (`DegreeID`),
  CONSTRAINT `FK_CourseDegreeID` FOREIGN KEY (`DegreeID`) REFERENCES `degree` (`DegreeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.course: ~0 rows (approximately)
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
/*!40000 ALTER TABLE `course` ENABLE KEYS */;


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


-- Dumping structure for table ubbdb.degreelanguage
CREATE TABLE IF NOT EXISTS `degreelanguage` (
  `LanguageID` int(10) unsigned NOT NULL,
  `DegreeID` int(10) unsigned NOT NULL,
  KEY `FK_DegreeID` (`DegreeID`),
  CONSTRAINT `FK_DegreeID` FOREIGN KEY (`DegreeID`) REFERENCES `degree` (`DegreeID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.degreelanguage: ~0 rows (approximately)
/*!40000 ALTER TABLE `degreelanguage` DISABLE KEYS */;
/*!40000 ALTER TABLE `degreelanguage` ENABLE KEYS */;


-- Dumping structure for table ubbdb.department
CREATE TABLE IF NOT EXISTS `department` (
  `DepartmentID` int(10) unsigned NOT NULL,
  `Name` varchar(30) NOT NULL,
  PRIMARY KEY (`DepartmentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.department: ~0 rows (approximately)
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
/*!40000 ALTER TABLE `department` ENABLE KEYS */;


-- Dumping structure for table ubbdb.enrolled
CREATE TABLE IF NOT EXISTS `enrolled` (
  `StudentID` int(10) unsigned NOT NULL,
  `CourseID` varchar(30) NOT NULL,
  KEY `FK_EnrolledStudentID` (`StudentID`),
  KEY `FK_EnrolledCourseID` (`CourseID`),
  CONSTRAINT `FK_EnrolledCourseID` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_EnrolledStudentID` FOREIGN KEY (`StudentID`) REFERENCES `student` (`PersonID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.enrolled: ~0 rows (approximately)
/*!40000 ALTER TABLE `enrolled` DISABLE KEYS */;
/*!40000 ALTER TABLE `enrolled` ENABLE KEYS */;


-- Dumping structure for table ubbdb.evaluation
CREATE TABLE IF NOT EXISTS `evaluation` (
  `EvaluationID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `EvaluationType` int(10) unsigned NOT NULL,
  PRIMARY KEY (`EvaluationID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.evaluation: ~0 rows (approximately)
/*!40000 ALTER TABLE `evaluation` DISABLE KEYS */;
/*!40000 ALTER TABLE `evaluation` ENABLE KEYS */;


-- Dumping structure for table ubbdb.faculty
CREATE TABLE IF NOT EXISTS `faculty` (
  `FacultyID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(255) NOT NULL,
  PRIMARY KEY (`FacultyID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.faculty: ~0 rows (approximately)
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;


-- Dumping structure for table ubbdb.optionalcourse
CREATE TABLE IF NOT EXISTS `optionalcourse` (
  `CourseID` varchar(30) NOT NULL,
  `GroupNo` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`CourseID`),
  CONSTRAINT `FK_CourseID` FOREIGN KEY (`CourseID`) REFERENCES `course` (`CourseID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.optionalcourse: ~0 rows (approximately)
/*!40000 ALTER TABLE `optionalcourse` DISABLE KEYS */;
/*!40000 ALTER TABLE `optionalcourse` ENABLE KEYS */;


-- Dumping structure for table ubbdb.person
CREATE TABLE IF NOT EXISTS `person` (
  `UserID` int(10) unsigned NOT NULL,
  `FirstName` varchar(30) NOT NULL,
  `LastName` varchar(30) NOT NULL,
  `DoB` date DEFAULT NULL,
  `SSN` bigint(20) NOT NULL,
  `Address` varchar(255) DEFAULT NULL,
  `PhoneNo` int(11) DEFAULT NULL,
  PRIMARY KEY (`UserID`),
  CONSTRAINT `FK_UserID` FOREIGN KEY (`UserID`) REFERENCES `user` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.person: ~0 rows (approximately)
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
/*!40000 ALTER TABLE `person` ENABLE KEYS */;


-- Dumping structure for table ubbdb.professor
CREATE TABLE IF NOT EXISTS `professor` (
  `PersonID` int(10) unsigned NOT NULL,
  `DepartmentID` int(10) unsigned NOT NULL DEFAULT '0',
  `IsChief` int(10) NOT NULL DEFAULT '0',
  `Wage` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`PersonID`),
  KEY `FK_ProfessorDepartmentID` (`DepartmentID`),
  CONSTRAINT `FK_ProfessorDepartmentID` FOREIGN KEY (`DepartmentID`) REFERENCES `department` (`DepartmentID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_ProfessorPersonID` FOREIGN KEY (`PersonID`) REFERENCES `person` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.professor: ~0 rows (approximately)
/*!40000 ALTER TABLE `professor` DISABLE KEYS */;
/*!40000 ALTER TABLE `professor` ENABLE KEYS */;


-- Dumping structure for table ubbdb.scholarship
CREATE TABLE IF NOT EXISTS `scholarship` (
  `ScholarshipID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Name` varchar(30) DEFAULT NULL,
  `Award` float unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`ScholarshipID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.scholarship: ~0 rows (approximately)
/*!40000 ALTER TABLE `scholarship` DISABLE KEYS */;
/*!40000 ALTER TABLE `scholarship` ENABLE KEYS */;


-- Dumping structure for table ubbdb.student
CREATE TABLE IF NOT EXISTS `student` (
  `PersonID` int(10) unsigned NOT NULL DEFAULT '0',
  `GroupID` int(10) unsigned NOT NULL,
  `Status` varchar(30) DEFAULT NULL,
  `IsExtended` int(11) DEFAULT '0',
  PRIMARY KEY (`PersonID`),
  KEY `FK_StudentGroupID` (`GroupID`),
  CONSTRAINT `FK_StudentGroupID` FOREIGN KEY (`GroupID`) REFERENCES `studentgroup` (`StudentGroupID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_StudentPersonID` FOREIGN KEY (`PersonID`) REFERENCES `person` (`UserID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.student: ~0 rows (approximately)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
/*!40000 ALTER TABLE `student` ENABLE KEYS */;


-- Dumping structure for table ubbdb.studentevaluation
CREATE TABLE IF NOT EXISTS `studentevaluation` (
  `EvaluationID` int(10) unsigned NOT NULL,
  `StudentID` int(10) unsigned NOT NULL,
  `Grade` float unsigned DEFAULT NULL,
  `IsAbsent` int(10) unsigned NOT NULL,
  KEY `FK_StudentEvaluationEvaluationID` (`EvaluationID`),
  KEY `FK_StudentEvaluationStudentID` (`StudentID`),
  CONSTRAINT `FK_StudentEvaluationEvaluationID` FOREIGN KEY (`EvaluationID`) REFERENCES `evaluation` (`EvaluationID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_StudentEvaluationStudentID` FOREIGN KEY (`StudentID`) REFERENCES `student` (`PersonID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.studentevaluation: ~0 rows (approximately)
/*!40000 ALTER TABLE `studentevaluation` DISABLE KEYS */;
/*!40000 ALTER TABLE `studentevaluation` ENABLE KEYS */;


-- Dumping structure for table ubbdb.studentgroup
CREATE TABLE IF NOT EXISTS `studentgroup` (
  `StudentGroupID` int(10) unsigned NOT NULL,
  `CurrentSemester` int(10) unsigned NOT NULL,
  PRIMARY KEY (`StudentGroupID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.studentgroup: ~0 rows (approximately)
/*!40000 ALTER TABLE `studentgroup` DISABLE KEYS */;
/*!40000 ALTER TABLE `studentgroup` ENABLE KEYS */;


-- Dumping structure for table ubbdb.studentoptionalcourse
CREATE TABLE IF NOT EXISTS `studentoptionalcourse` (
  `CourseID` varchar(50) NOT NULL,
  `StudentID` int(10) unsigned NOT NULL,
  KEY `FK_StudentOptionalCourseCourseID` (`CourseID`),
  KEY `FK_StudentOptionalCourseStudentID` (`StudentID`),
  CONSTRAINT `FK_StudentOptionalCourseCourseID` FOREIGN KEY (`CourseID`) REFERENCES `optionalcourse` (`CourseID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_StudentOptionalCourseStudentID` FOREIGN KEY (`StudentID`) REFERENCES `student` (`PersonID`) ON DELETE NO ACTION ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.studentoptionalcourse: ~0 rows (approximately)
/*!40000 ALTER TABLE `studentoptionalcourse` DISABLE KEYS */;
/*!40000 ALTER TABLE `studentoptionalcourse` ENABLE KEYS */;


-- Dumping structure for table ubbdb.studentscholarship
CREATE TABLE IF NOT EXISTS `studentscholarship` (
  `ScholarshipID` int(11) unsigned NOT NULL,
  `StudentID` int(11) unsigned NOT NULL,
  KEY `FK_StudentScholarshipScholarshipID` (`ScholarshipID`),
  KEY `FK_StudentScholarshipStudentID` (`StudentID`),
  CONSTRAINT `FK_StudentScholarshipScholarshipID` FOREIGN KEY (`ScholarshipID`) REFERENCES `scholarship` (`ScholarshipID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_StudentScholarshipStudentID` FOREIGN KEY (`StudentID`) REFERENCES `student` (`PersonID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.studentscholarship: ~0 rows (approximately)
/*!40000 ALTER TABLE `studentscholarship` DISABLE KEYS */;
/*!40000 ALTER TABLE `studentscholarship` ENABLE KEYS */;


-- Dumping structure for table ubbdb.user
CREATE TABLE IF NOT EXISTS `user` (
  `UserID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Username` varchar(30) NOT NULL DEFAULT 'admin',
  `Password` varchar(30) NOT NULL DEFAULT 'admin',
  PRIMARY KEY (`UserID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table ubbdb.user: ~0 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
