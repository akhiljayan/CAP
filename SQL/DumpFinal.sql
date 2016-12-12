-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: caps
-- ------------------------------------------------------
-- Server version	5.7.16-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `courseinfo`
--

DROP TABLE IF EXISTS `courseinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courseinfo` (
  `CourseID` int(11) NOT NULL AUTO_INCREMENT,
  `CourseName` varchar(120) DEFAULT NULL,
  `CourseDescription` varchar(300) DEFAULT NULL,
  `MaxClassSize` int(11) DEFAULT NULL,
  `Credits` int(11) DEFAULT NULL,
  `CourseFacultyID` int(11) DEFAULT NULL,
  `CourseDepartmentID` int(11) DEFAULT NULL,
  `CourseActiveStatus` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`CourseID`),
  KEY `FK_courseDepartmentID_departmentDepartmentID_idx` (`CourseDepartmentID`),
  KEY `FK_courseFacultyID_facultyFacultyID_idx` (`CourseFacultyID`),
  CONSTRAINT `FK_courseDepartmentID_departmentDepartmentID` FOREIGN KEY (`CourseDepartmentID`) REFERENCES `department` (`DepartmentID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_courseFacultyID_facultyFacultyID` FOREIGN KEY (`CourseFacultyID`) REFERENCES `faculty` (`FacultyID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courseinfo`
--

LOCK TABLES `courseinfo` WRITE;
/*!40000 ALTER TABLE `courseinfo` DISABLE KEYS */;
INSERT INTO `courseinfo` VALUES (1,'Advanced Thermodynamics','Monte Carlo and other simulation techniques in heat transfer modeling',10,4,1,3,'Active'),(2,'ULSI Circuit Design','Circuit design for sub-10nm technology',10,6,1,4,'Active'),(3,'Advanced Bayesian Statistics','Application of Bayesian statistics to economics, data analytics etc',10,6,2,5,'Active'),(4,'Physics of Quantum Computing','Study of sub-atomic particles properties in computing efficiency etc',10,5,2,6,'Active'),(5,'Application of Nanotubes','Use of nanotubes in material science',10,5,2,7,'Active'),(6,'Fundamentals of Mircofinancing','Theory of microfinancing and impact e.g poverty lifiting',10,4,3,8,'Active'),(7,'Child Development Psychology','Theory of child developement',10,4,3,9,'Active'),(8,'Geopolitical Trends in Middle East','Examines impact of recent political trends in Middle East',10,4,3,10,'Active'),(9,'Encryption in NFC technology','Examines hardware encryption in NFC',10,4,1,4,'Active'),(10,'Wave Engineering','Harnassing the power of ocean waves',10,4,1,3,'Active'),(11,'Aerodynamics Simulation','Improving aircraft performance through simulation',10,3,1,3,'Active'),(12,'Artificial Neural Networks','Introduction to neural networks',10,6,1,4,'Active'),(13,'Embedded system microprocessor design','Reducing power consumption in embedded microprocesors',10,6,1,4,'Active'),(14,'Linear Programming','Linear Programming',10,4,2,5,'Active'),(15,'Advanced Statistics for Predictive Analytics','Advanced Statistics for Predictive Analytics',10,4,2,5,'Active'),(16,'Advanced Statistics for Predictive Analytics','Applications of Graphene',10,4,2,7,'Active'),(17,'Introduction to Fintech','Introduction to Fintech',10,4,3,8,'Active'),(18,'Cognitive study of monkeys','Cognitive study of monkeys',10,4,3,9,'Active'),(19,'Study of White Nationalism in United State','Study of White Nationalism in United State',10,4,3,10,'Active'),(28,'IoT Course','Internet of things',10,16,2,4,'Active'),(36,'ssssaaaa','asss',12,3,2,6,'Inactive'),(37,'CC Name 2','asss',12,3,3,6,'Inactive'),(38,'CC NameDD 2','asss',34,3,3,6,'Inactive');
/*!40000 ALTER TABLE `courseinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courserun`
--

DROP TABLE IF EXISTS `courserun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courserun` (
  `CourseID` int(11) NOT NULL,
  `CourseStartDate` date NOT NULL,
  `CourseEndDate` date DEFAULT NULL,
  `ClassSize` int(11) DEFAULT NULL,
  `CourseStatus` varchar(20) DEFAULT NULL,
  `CourseVenue` varchar(60) DEFAULT NULL,
  `CourseGrading` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`CourseID`,`CourseStartDate`),
  CONSTRAINT `FK_courserunCourseID_courseinfoCourseID` FOREIGN KEY (`CourseID`) REFERENCES `courseinfo` (`CourseID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courserun`
--

LOCK TABLES `courserun` WRITE;
/*!40000 ALTER TABLE `courserun` DISABLE KEYS */;
INSERT INTO `courserun` VALUES (1,'2016-08-01','2016-11-01',6,'completed','E5-03-01','lock'),(2,'2016-08-01','2016-09-01',4,'completed','E6-04-01','lock'),(3,'2016-08-01','2016-09-01',3,'completed','SC14-02-01','unlock'),(4,'2016-09-10','2016-10-11',3,'completed','SC12-02-05','unlock'),(5,'2016-08-01','2016-09-30',4,'completed','SC12-06-03','unlock'),(6,'2016-10-01','2016-11-05',2,'completed','SC15-06-03','unlock'),(7,'2016-08-01','2016-09-30',4,'completed','AS7-02-03','unlock'),(8,'2016-09-15','2016-11-30',2,'completed','AS3-03-05','unlock'),(9,'2016-09-15','2016-10-30',4,'completed','E3-01-03','unlock');
/*!40000 ALTER TABLE `courserun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `department` (
  `DepartmentID` int(11) NOT NULL AUTO_INCREMENT,
  `DepartmentName` varchar(60) DEFAULT NULL,
  `FacultyID` int(11) DEFAULT NULL,
  PRIMARY KEY (`DepartmentID`),
  KEY `FK_departmentFacultyID_facultyFacultyID_idx` (`FacultyID`),
  CONSTRAINT `FK_departmentFacultyID_facultyFacultyID` FOREIGN KEY (`FacultyID`) REFERENCES `faculty` (`FacultyID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (3,'Mechnical Engineering',1),(4,'Electrical And Computer Engineering',1),(5,'Mathematics',2),(6,'Physics',2),(7,'Chemistry',2),(8,'Economics',3),(9,'Psychology',3),(10,'Political Science',3),(13,'IoT',1);
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `faculty`
--

DROP TABLE IF EXISTS `faculty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `faculty` (
  `FacultyID` int(11) NOT NULL AUTO_INCREMENT,
  `FacultyName` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`FacultyID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `faculty`
--

LOCK TABLES `faculty` WRITE;
/*!40000 ALTER TABLE `faculty` DISABLE KEYS */;
INSERT INTO `faculty` VALUES (1,'Engineering'),(2,'Science'),(3,'Arts And Social Science'),(7,'TEst Facut');
/*!40000 ALTER TABLE `faculty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecturer`
--

DROP TABLE IF EXISTS `lecturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lecturer` (
  `LecturerID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) DEFAULT NULL,
  `LecturerName` varchar(100) DEFAULT NULL,
  `LecturerFacultyID` int(11) DEFAULT NULL,
  `LecturerDepartmentID` int(11) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `Gender` varchar(20) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Email` varchar(120) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `EmployedDate` date DEFAULT NULL,
  PRIMARY KEY (`LecturerID`),
  KEY `FK_lecturerDepartmentID_departmentDepartmentID_idx` (`LecturerDepartmentID`),
  KEY `FK_lecturerFacultyID_facultyFacultyID_idx` (`LecturerFacultyID`),
  KEY `FK_lecture_userId_idx` (`UserID`),
  CONSTRAINT `FK_lecture_userId` FOREIGN KEY (`UserID`) REFERENCES `loginauthenticate` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_lecturerDepartmentID_departmentDepartmentID` FOREIGN KEY (`LecturerDepartmentID`) REFERENCES `department` (`DepartmentID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_lecturerFacultyID_facultyFacultyID` FOREIGN KEY (`LecturerFacultyID`) REFERENCES `faculty` (`FacultyID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecturer`
--

LOCK TABLES `lecturer` WRITE;
/*!40000 ALTER TABLE `lecturer` DISABLE KEYS */;
INSERT INTO `lecturer` VALUES (1,3,'Liew Ah Choy',1,3,'Employed','M','1955-05-01','T00001@nus.edu.sg',NULL,'1990-07-04'),(2,5,'Lawrence Wong',1,4,'Employed','M','1954-06-21','T00002@nus.edu.sg',NULL,'1992-09-02'),(3,6,'John Thong',1,4,'Employed','M','1960-08-15','T00003@nus.edu.sg',NULL,'1993-04-02'),(4,9,'Charlene Goh',2,5,'Employed','F','1973-08-15','T00004@nus.edu.sg',NULL,'2000-03-22'),(5,10,'R. Gupta',2,6,'Employed','M','1969-08-15','T00005@nus.edu.sg',NULL,'2001-03-22'),(6,13,'Christopher De Souza',2,7,'Employed','M','1965-08-15','T00006@nus.edu.sg',NULL,'2009-03-22'),(7,18,'Bitty Coin',3,8,'Employed','M','1968-02-14','T00007@nus.edu.sg',NULL,'2010-08-20'),(8,19,'Richard Attenbourough',3,9,'Employed','M','1948-02-14','T00008@nus.edu.sg',NULL,'2010-07-20'),(9,21,'Amos Yee',3,10,'Employed','M','1980-02-14','T00009@nus.edu.sg',NULL,'2015-07-20'),(10,NULL,'Lecturer',3,10,'Unemployed','M','2016-08-15','jydci21s.jvb@20email.eu','Address','2016-12-06'),(11,NULL,'Steven',7,8,'Unemployed','M','1913-02-21','matthew@gmail.com','Singapore','1913-01-03');
/*!40000 ALTER TABLE `lecturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lecturercourse`
--

DROP TABLE IF EXISTS `lecturercourse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lecturercourse` (
  `LecturerID` int(11) NOT NULL,
  `CourseID` int(11) NOT NULL,
  PRIMARY KEY (`LecturerID`,`CourseID`),
  KEY `FK_lecturercourseCourseID_courseCourseID_idx` (`CourseID`),
  CONSTRAINT `FK_lecturercourseCourseID_courseCourseID` FOREIGN KEY (`CourseID`) REFERENCES `courseinfo` (`CourseID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_lecturercourseLecturerID_lecturerLecturerID` FOREIGN KEY (`LecturerID`) REFERENCES `lecturer` (`LecturerID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lecturercourse`
--

LOCK TABLES `lecturercourse` WRITE;
/*!40000 ALTER TABLE `lecturercourse` DISABLE KEYS */;
INSERT INTO `lecturercourse` VALUES (1,1),(2,2),(4,3),(5,4),(6,5),(7,6),(8,7),(9,8),(1,9),(3,9);
/*!40000 ALTER TABLE `lecturercourse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loginauthenticate`
--

DROP TABLE IF EXISTS `loginauthenticate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loginauthenticate` (
  `UserID` int(11) NOT NULL AUTO_INCREMENT,
  `Username` varchar(45) NOT NULL,
  `Password` varchar(45) NOT NULL,
  `RoleID` int(11) NOT NULL,
  `CreatedBy` int(11) DEFAULT NULL,
  `CreatedDate` date DEFAULT NULL,
  `IsLogedIn` int(1) DEFAULT NULL,
  PRIMARY KEY (`UserID`),
  KEY `FK_loginauthenticateRoleID_loginroleRoleID_idx` (`RoleID`),
  KEY `FK_logincreated_by_idx` (`CreatedBy`),
  CONSTRAINT `FK_loginauthenticateRoleID_loginroleRoleID` FOREIGN KEY (`RoleID`) REFERENCES `loginrole` (`RoleID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_logincreated_by` FOREIGN KEY (`CreatedBy`) REFERENCES `loginauthenticate` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginauthenticate`
--

LOCK TABLES `loginauthenticate` WRITE;
/*!40000 ALTER TABLE `loginauthenticate` DISABLE KEYS */;
INSERT INTO `loginauthenticate` VALUES (2,'A00001','password',1,2,NULL,NULL),(3,'T00001','password',2,2,NULL,NULL),(4,'S00001','password',3,2,NULL,NULL),(5,'T00002','password',2,2,NULL,NULL),(6,'T00003','password',2,2,NULL,NULL),(7,'S00002','password',3,2,NULL,NULL),(8,'S00003','password',1,2,NULL,NULL),(9,'T00004','password',2,2,NULL,NULL),(10,'T00005','password',2,2,NULL,NULL),(11,'S00004','password',3,2,NULL,NULL),(12,'S00005','password',3,2,NULL,NULL),(13,'T00006','password',2,2,NULL,NULL),(14,'S00006','password',3,2,NULL,NULL),(15,'S00007','passwordd',3,2,NULL,NULL),(16,'S00008','password',3,2,NULL,NULL),(17,'S00009','password',3,2,NULL,NULL),(18,'T00007','password',2,2,NULL,NULL),(19,'T00008','password',2,2,NULL,NULL),(20,'S00010','password',3,2,NULL,NULL),(21,'T00009','password',2,2,NULL,NULL),(22,'S00011','password',3,2,NULL,NULL),(23,'S00012','password',3,2,NULL,NULL),(24,'S00013','password',3,2,NULL,NULL),(25,'S00014','password',3,2,NULL,NULL),(26,'S00015','password',3,2,NULL,NULL),(27,'S00016','password',3,2,NULL,NULL),(28,'S00017','password',3,2,NULL,NULL),(29,'S00018','password',3,2,NULL,NULL),(30,'S00019','password',3,2,NULL,NULL),(31,'S00020','password',3,2,NULL,NULL),(32,'S00021','password',3,2,NULL,NULL),(33,'S00022','password',3,2,NULL,NULL),(34,'S00023','password',3,2,NULL,NULL),(35,'S00024','password',3,2,NULL,NULL),(36,'S00025','password',3,2,NULL,NULL),(37,'S00026','password',3,2,NULL,NULL),(38,'S00027','password',3,2,NULL,NULL),(39,'S00028','password',3,2,NULL,NULL),(40,'S00029','password',3,2,NULL,NULL),(41,'S00030','password',3,2,NULL,NULL),(42,'S00031','password',3,2,NULL,NULL),(43,'S00032','password',3,2,NULL,NULL),(45,'akjn','password',3,2,NULL,NULL),(47,'akjn','akjn',3,2,NULL,NULL),(52,'LE001','password',2,2,NULL,NULL),(53,'U0999','password',2,2,NULL,NULL);
/*!40000 ALTER TABLE `loginauthenticate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loginrole`
--

DROP TABLE IF EXISTS `loginrole`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `loginrole` (
  `RoleID` int(11) NOT NULL,
  `Role` varchar(45) NOT NULL,
  PRIMARY KEY (`RoleID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loginrole`
--

LOCK TABLES `loginrole` WRITE;
/*!40000 ALTER TABLE `loginrole` DISABLE KEYS */;
INSERT INTO `loginrole` VALUES (1,'Admin'),(2,'Lecturer'),(3,'Student');
/*!40000 ALTER TABLE `loginrole` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `StudentID` int(11) NOT NULL AUTO_INCREMENT,
  `UserID` int(11) DEFAULT NULL,
  `StudentName` varchar(100) DEFAULT NULL,
  `StudentFacultyID` int(11) DEFAULT NULL,
  `StudentDepartmentID` int(11) DEFAULT NULL,
  `Status` varchar(45) DEFAULT NULL,
  `Gender` varchar(20) DEFAULT NULL,
  `DOB` date DEFAULT NULL,
  `Email` varchar(120) DEFAULT NULL,
  `Address` varchar(200) DEFAULT NULL,
  `MatricDate` date DEFAULT NULL,
  PRIMARY KEY (`StudentID`),
  KEY `FK_studentDepartmentID_departmentDepartmentID_idx` (`StudentDepartmentID`),
  KEY `FK_studentFacultyID_facultyFacultyID_idx` (`StudentFacultyID`),
  KEY `FK_studentUserId_idx` (`UserID`),
  CONSTRAINT `FK_studentDepartmentID_departmentDepartmentID` FOREIGN KEY (`StudentDepartmentID`) REFERENCES `department` (`DepartmentID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_studentFacultyID_facultyFacultyID` FOREIGN KEY (`StudentFacultyID`) REFERENCES `faculty` (`FacultyID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_studentUserId` FOREIGN KEY (`UserID`) REFERENCES `loginauthenticate` (`UserID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,4,'Tan Tock Seng',1,3,'undergrad','M','1994-05-25','S00001@nus.edu.sg',NULL,'2014-07-01'),(2,7,'Francis Seow',1,3,'undergrad','M','1994-05-25','S00002@nus.edu.sg',NULL,'2014-07-01'),(3,8,'Edward Pillay',1,3,'undergrad','M','1994-09-11','S00003@nus.edu.sg',NULL,'2014-07-01'),(4,11,'Lim Yew Hock',1,3,'undergrad','M','1994-08-11','S00004@nus.edu.sg',NULL,'2014-07-01'),(5,12,'Magnum Pi',1,3,'undergrad','F','1994-08-16','S00005@nus.edu.sg',NULL,'2014-07-01'),(6,14,'Si Bei Yao',1,4,'undergrad','M','1994-08-16','S00006@nus.edu.sg',NULL,'2014-07-01'),(7,15,'Zoe Tay',1,3,'undergradss','F','0031-06-17','S00007@nus.edu.sg','Address','0006-07-07'),(8,16,'Tan Chor Chuan',1,4,'undergrad','M','1994-08-16','S00008@nus.edu.sg',NULL,'2014-07-01'),(9,17,'Felicia Chin',1,4,'undergrad','F','1994-04-20','S00009@nus.edu.sg',NULL,'2014-07-01'),(12,20,'Emilia Pujol',1,4,'undergrad','F','1993-04-20','S00010@nus.edu.sg',NULL,'2014-07-01'),(13,22,'DeMoirve Tan',2,5,'undergrad','M','1993-11-20','S00011@nus.edu.sg',NULL,'2014-07-01'),(14,23,'Curie Lim',2,5,'undergrad','F','1994-11-11','S00012@nus.edu.sg',NULL,'2014-07-01'),(15,24,'Avogadro Constant',2,5,'undergrad','M','1994-10-23','S00013@nus.edu.sg',NULL,'2014-07-01'),(16,25,'Max Plank',2,6,'undergrad','M','1994-09-03','S00014@nus.edu.sg',NULL,'2014-07-01'),(17,26,'Niel Bohr',2,6,'undergrad','M','1994-03-13','S00015@nus.edu.sg',NULL,'2014-07-01'),(18,27,'Quark Tan',2,6,'undergrad','M','1994-04-27','S00016@nus.edu.sg',NULL,'2014-07-01'),(19,28,'Rachel Wong',2,7,'undergrad','F','1994-05-17','S00017@nus.edu.sg',NULL,'2014-07-01'),(20,29,'Carol King',2,7,'undergrad','F','1994-07-27','S00018@nus.edu.sg',NULL,'2014-07-01'),(21,30,'Abe Shinzo',2,7,'undergrad','M','1994-08-20','S00019@nus.edu.sg',NULL,'2014-07-01'),(22,31,'Donald Triumph',2,7,'undergrad','M','1994-01-20','S00020@nus.edu.sg',NULL,'2014-07-01'),(23,32,'Hilarious Clinton',3,8,'undergrad','F','1994-02-22','S00021@nus.edu.sg',NULL,'2014-07-01'),(24,33,'Angela Merkel',3,8,'undergrad','F','1994-12-21','S00022@nus.edu.sg',NULL,'2014-07-01'),(25,34,'Fidel Castro',3,9,'undergrad','M','1994-10-09','S00023@nus.edu.sg',NULL,'2014-07-01'),(26,35,'Che Guava',3,9,'undergrad','M','1994-09-19','S00024@nus.edu.sg',NULL,'2014-07-01'),(27,36,'Zhao ZiYang',3,9,'undergrad','M','1994-09-11','S00025@nus.edu.sg',NULL,'2014-07-01'),(28,37,'John Kennedy',3,9,'undergrad','M','1994-09-11','S00026@nus.edu.sg',NULL,'2014-07-01'),(29,38,'Hu YaoBang',3,10,'undergrad','M','1994-09-11','S00027@nus.edu.sg',NULL,'2014-07-01'),(30,39,'Richard Nixon',3,10,'undergrad','M','1994-01-07','S00028@nus.edu.sg',NULL,'2014-07-01'),(31,40,'Kim JongUn',3,10,'undergrad','M','1994-06-15','S00029@nus.edu.sg',NULL,'2014-07-01'),(32,41,'Segovia Andreas',3,10,'undergrad','M','1994-07-15','S00030@nus.edu.sg',NULL,'2014-07-01'),(33,42,'Barrios Augustin',1,4,'undergrad','M','1994-07-15','S00031@nus.edu.sg',NULL,'2014-07-01'),(34,43,'Joaqium Rodrigo',1,4,'undergrad','M','1994-06-20','S00032@nus.edu.sg',NULL,'2014-07-01'),(45,8,'Edward Pillay',1,3,'undergradss','M',NULL,'S00003@nus.edu.sg','Address',NULL),(46,47,'Akhil Jayan',1,4,'Graduate','M','2016-12-06','mailtoakjn@gmail.com','Address','2016-12-12');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentgrade`
--

DROP TABLE IF EXISTS `studentgrade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `studentgrade` (
  `StudentID` int(11) DEFAULT NULL,
  `CourseID` int(11) DEFAULT NULL,
  `Grade` varchar(10) DEFAULT NULL,
  `EnrolledDate` date DEFAULT NULL,
  `CompletionStatus` varchar(45) DEFAULT NULL,
  `EnrolmentID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`EnrolmentID`),
  KEY `FK_gradeCourse_idx` (`CourseID`),
  KEY `FK_gradeStudent_idx` (`StudentID`),
  CONSTRAINT `FK_gradeCourse` FOREIGN KEY (`CourseID`) REFERENCES `courseinfo` (`CourseID`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_gradeStudent` FOREIGN KEY (`StudentID`) REFERENCES `student` (`StudentID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentgrade`
--

LOCK TABLES `studentgrade` WRITE;
/*!40000 ALTER TABLE `studentgrade` DISABLE KEYS */;
INSERT INTO `studentgrade` VALUES (1,1,'E','2016-07-10','Completed',1),(1,9,'A','2016-07-20','Completed',2),(2,1,'B','2016-07-06','Completed',3),(2,9,'C','2016-07-10','Completed',4),(3,1,'A','2016-06-29','Completed',5),(6,1,'B','2016-07-03','Completed',6),(7,1,'A','2016-07-11','Completed',7),(7,2,'C','2016-06-26','Completed',8),(8,1,'A','2016-07-07','Completed',9),(8,2,'B','2016-06-20','Completed',10),(9,2,'C','2016-06-22','Completed',11),(12,2,'A','2016-06-19','Completed',12),(13,3,'C','2016-07-01','Completed',13),(13,4,'D','2016-07-30','Completed',14),(13,5,'C','2016-06-13','Completed',15),(14,3,'A','2016-07-02','Completed',16),(16,3,'D','2016-07-11','Completed',17),(16,4,'A','2016-08-03','Completed',18),(16,5,'B','2016-07-03','Completed',19),(17,4,'A','2016-08-11','Completed',20),(19,5,'B','2016-07-03','Completed',21),(22,5,'C','2016-07-05','Completed',22),(23,6,'A','2016-09-03','Completed',23),(25,7,'B','2016-06-22','Completed',24),(26,7,'A','2016-06-20','Completed',25),(26,8,'A','2016-07-18','Completed',26),(28,7,'C','2016-06-20','Completed',27),(29,6,'A','2016-08-22','Completed',28),(29,7,'A','2016-06-29','Completed',29),(29,8,'B','2016-08-10','Completed',30),(30,8,'B','2016-08-01','Completed',31),(32,8,'C','2016-07-29','Completed',32),(4,1,'A','2016-12-11','Enroled',33),(5,1,NULL,'2016-12-11','Enroled',34),(33,1,NULL,'2016-12-11','Enroled',35),(9,1,NULL,'2016-12-11','Enroled',36),(17,1,NULL,'2016-12-11','Enroled',37),(7,28,NULL,'2016-12-11','Enroled',47),(7,19,NULL,'2016-12-11','Enroled',48),(7,18,NULL,'2016-12-11','Enroled',49),(46,28,NULL,'2016-12-11','Enroled',50),(46,2,NULL,'2016-12-11','Enroled',51),(1,28,NULL,'2016-12-12','Enroled',52),(1,2,NULL,'2016-12-12','Failed',53),(1,18,NULL,'2016-12-12','Enroled',54);
/*!40000 ALTER TABLE `studentgrade` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-12 14:48:05
