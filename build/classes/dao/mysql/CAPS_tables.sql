-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: lala
-- ------------------------------------------------------
-- Server version	5.7.16

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
-- Table structure for table `Admin`
--

DROP TABLE IF EXISTS `Admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Admin` (
  `adminID` int(11) NOT NULL,
  `Password` varchar(10) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`adminID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Admin`
--

LOCK TABLES `Admin` WRITE;
/*!40000 ALTER TABLE `Admin` DISABLE KEYS */;
INSERT INTO `Admin` VALUES (0,'apple',1),(1,'pear',1),(2,'orange',1),(3,'banana',1),(4,'kiwi',1),(5,'tomato',1),(6,'mango',0);
/*!40000 ALTER TABLE `Admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Student`
--

DROP TABLE IF EXISTS `Student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Student` (
  `studentID` int(11) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(25) NOT NULL,
  `firstmidname` varchar(25) NOT NULL,
  `enrolmentdate` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(25) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`studentID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Student`
--

LOCK TABLES `Student` WRITE;
/*!40000 ALTER TABLE `Student` DISABLE KEYS */;
INSERT INTO `Student` VALUES (10001,'Christel','Agripina','2015-08-24','stone@meekness.com','Agripina',1),(10002,'Roosevelt','Alberta','2012-12-17','ca-tech@dps.centrin.net.id','Alberta',1),(10003,'Benito','Aleisha','2012-01-28','trinanda_lestyowati@telkomsel.co.id','Aleisha',1),(10004,'Lexie','Alfonzo','2012-09-18','asst_dos@astonrasuna.com','Alfonzo',1),(10005,'Eleanor','Alphonse','2014-01-17','amartabali@dps.centrin.net.id','Alphonse',1),(10006,'Despina','Annie','2014-07-05','achatv@cbn.net.id','Annie',1),(10007,'September','Antonio','2013-05-16','bali@tuguhotels.com','Antonio',1),(10008,'Lanora','Ashli','2012-05-08','baliminimalist@yahoo.com','Ashli',1),(10009,'Lolita','Augusta','2015-11-15','bliss@thebale.com','Augusta',1),(10010,'Enola','Barrett','2012-05-10','adhidharma@denpasar.wasantara.net.id','Barrett',1),(10011,'Lyle','Beaulah','2014-04-18','centralreservation@ramayanahotel.com','Beaulah',1),(10012,'Cassi','Bernie','2015-12-08','apribadi@balimandira.com','Bernie',1),(10013,'Marie','Bernie','2016-01-18','cdagenhart@ifc.org','Bernie',1),(10014,'Sandy','Bobbi','2013-09-26','dana_supriyanto@interconti.com','Bobbi',1),(10015,'Lucrecia','Booker','2015-04-19','dos@novotelbali.com','Booker',1),(10016,'Julieann','Brandie','2014-07-15','daniel@hotelpadma.com','Brandie',1),(10017,'Palmira','Brittney','2013-04-03','daniel@balibless.com','Brittney',1),(10018,'Herman','Burton','2014-06-04','djoko_p@jayakartahotelsresorts.com','Burton',1),(10019,'Margarite','Camelia','2013-01-07','expdepot@indosat.net.id','Camelia',1),(10020,'Mandi','Carin','2015-01-16','feby.adamsyah@idn.xerox.com','Carin',1),(10021,'Jessenia','Carita','2013-07-18','christian_rizal@interconti.com','Carita',1),(10022,'Lenard','Carmella','2014-10-18','singgih93@mailcity.com','Carmella',1),(10023,'Wynell','Carol','2012-02-02','idonk_gebhoy@yahoo.com','Carol',1),(10024,'Darrel','Carson','2015-06-25','info@houseofbali.com','Carson',1),(10025,'Christoper','Catrina','2015-03-04','kyohana@toureast.net','Catrina',1),(10026,'Mafalda','Chanell','2015-05-27','sales@nusaduahotel.com','Chanell',1),(10027,'Claude','Charlsie','2013-09-12','jayakarta@mataram.wasantara.net.id','Charlsie',1),(10028,'Danilo','Cheyenne','2012-01-14','mapindo@indo.net.id','Cheyenne',1),(10029,'Chong','Chieko','2012-02-10','sm@ramayanahotel.com','Chieko',1),(10030,'Aracely','Christin','2014-11-02','anekabeach@dps.centrin.net.id','Christin',1),(10031,'Krystin','Christine','2013-05-03','yogya@jayakartahotelsresorts.com','Christine',1),(10032,'Migdalia','Chuck','2014-08-24','garudawisatajaya@indo.net.id','Chuck',1),(10033,'Vicki','Chun','2012-01-15','ketut@kbatur.com','Chun',1),(10034,'Juliette','Cicely','2014-08-14','bondps@bonansatours.com','Cicely',1),(10035,'Keva','Claretta','2015-11-11','witamgr@dps.centrin.net.id','Claretta',1),(10036,'Del','Corrie','2012-06-14','dtedja@indosat.net.id','Corrie',1),(10037,'Jennefer','Daisey','2013-04-20','info@stpbali.ac.id','Daisey',1),(10038,'Dorthea','Darin','2015-04-04','baliprestigeho@dps.centrin.net.id','Darin',1),(10039,'Michale','Della','2012-08-12','pamilu@mas-travel.com','Della',1),(10040,'Lou','Devona','2013-04-14','amandabl@indosat.net.id','Devona',1),(10041,'Rolande','Doloris','2012-07-23','marketing@csdwholiday.com','Doloris',1),(10042,'Brian','Dwain','2012-08-04','luha89@yahoo.com','Dwain',1),(10043,'Felix','Epifania','2015-04-05','indahsuluh2002@yahoo.com.sg','Epifania',1),(10044,'Dean','Erick','2014-12-29','imz1991@yahoo.com','Erick',1),(10045,'Corliss','Esperanza','2015-08-03','gus_war81@yahoo.com','Esperanza',1),(10046,'Sixta','Ethan','2013-10-22','kf034@indosat.net.id','Ethan',1),(10047,'Kam','Gayla','2014-07-14','800produkwil@posindonesia.co.id','Gayla',1),(10048,'Sumiko','Gisele','2012-09-20','kontak.synergi@yahoo.com','Gisele',1),(10049,'Janeen','Gracie','2015-05-08','oekaoeka@yahoo.com','Gracie',1),(10050,'Francisco','Harlan','2015-12-20','fitrianti@hotmail.com','Harlan',1),(10051,'Berta','Hassan','2013-07-14','meylina310@yahoo.com','Hassan',1),(10052,'Celine','Hattie','2013-05-03','h4ntoro@yahoo.com','Hattie',1),(10053,'Linette','Irish','2014-08-21','novi_enbe@yahoo.com','Irish',1),(10054,'Shyla','Jayson','2014-12-15','dila_dewata@yahoo.co.id','Jayson',1),(10055,'Harvey','Jeremiah','2014-09-06','tiena_asfary@yahoo.co.id','Jeremiah',1),(10056,'Bernard','Jeromy','2013-08-01','da_lawoffice@yahoo.com','Jeromy',1),(10057,'Asha','Jewel','2013-05-30','rini@ncsecurities.biz','Jewel',1),(10058,'Dorine','Jodee','2016-01-20','sudarnoto_hakim@yahoo.com','Jodee',1),(10059,'Amee','Justine','2013-03-23','wastioke@yahoo.com','Justine',1),(10060,'Carolynn','Kathryne','2015-12-24','leebahri@yahoo.com.','Kathryne',1),(10061,'Albina','Kaylene','2013-06-28','lia_kiara97@yahoo.com','Kaylene',1),(10062,'Mickie','Kiana','2013-08-20','rido@weddingku.com','Kiana',1),(10063,'Bryon','Klara','2016-01-16','b_astuti@telkomsel.co.id','Klara',1),(10064,'Sharie','Larissa','2014-10-13','garudawisata@indo.net.id','Larissa',1),(10065,'Reid','Leon','2013-12-22','grfurniture@yahoo.com','Leon',1),(10066,'Jesusa','Lina','2014-04-14','gosyen2000@hotmail.com','Lina',1),(10067,'Kym','Linsey','2012-03-07','hvhfood@indosat.net.id','Linsey',1),(10068,'Dyan','Lona','2014-07-17','hr@astonbali.com','Lona',1),(10069,'Lindsy','Lorena','2014-11-09','hary@wibisono-family.com','Lorena',1),(10070,'Jenni','Luciano','2015-12-08','fadlycak\'p@yahoo.com','Luciano',1),(10071,'Larae','Lucinda','2013-01-23','ida_sampurniah@telkomsel.co.id','Lucinda',1),(10072,'Adrien','Magen','2015-07-21','muslim-pariwisata-bali@yahoogroups.com','Magen',1),(10073,'Francene','Mandie','2014-09-02','harisnira@yahoo.com','Mandie',1),(10074,'Isa','Mariana','2013-04-26','sales@houseofbali.com','Mariana',1),(10075,'Evalyn','Mary','2013-02-12','baim_ron@yahoo.com','Mary',1),(10076,'Gonzalo','Meghan','2014-03-15','ilhambali222@yahoo.com','Meghan',1),(10077,'Claris','Milton','2012-03-28','bungjon@gmail.com','Milton',1),(10078,'Ilana','Mora','2014-08-30','diar@bdg.centrin.net.id','Mora',1),(10079,'Lashawnda','Natalie','2012-04-12','elmienruge@hotmail.com','Natalie',1),(10080,'Tomas','Odessa','2014-05-30','galaxygarden2006@yahoo.com','Odessa',1),(10081,'Lenny','Ray','2015-08-12','gorisata@indosat.net.id','Ray',1),(10082,'Mira','Reed','2012-11-04','maulitasarihani@yahoo.com','Reed',1),(10083,'Larry','Romelia','2012-07-22','hamiluddakwah@gmail.com.au','Romelia',1),(10084,'Corazon','Rose','2013-12-08','bounty@indo.net.id','Rose',1),(10085,'Chrystal','Ruthanne','2015-11-04','michi@ritzcarlton-bali.com','Ruthanne',1),(10086,'Ernestine','Sammy','2014-04-18','orridor@dps.centrin.net.id','Sammy',1),(10087,'Tashia','Shenika','2012-01-22','ngumina@hotmail.com','Shenika',1),(10088,'Franchesca','Ted','2012-02-15','made@mas-travel.com','Ted',1),(10089,'Rosa','Teresa','2014-03-26','evi@mas-travel.com','Teresa',1),(10090,'Jenifer','Teresia','2013-07-24','wibawa@mas-travel.com','Teresia',1),(10091,'Michel','Tomeka','2015-07-27','saihubaly@yahoo.co.id','Tomeka',1),(10092,'Vernon','Tommye','2013-08-30','swa_candra@yahoo.com','Tommye',1),(10093,'Toby','Tonette','2012-09-18','picapica@denpasar.wasantara.net.id','Tonette',1),(10094,'Kallie','Trudy','2013-12-04','griyasantrian@santrian.com','Trudy',1),(10095,'Shonda','Verda','2014-02-17','yuni6671@gmail.com','Verda',1),(10096,'Lawerence','Verline','2015-09-02','phbalichef@indo.net.id','Verline',1),(10097,'Sulema','Vincent','2013-07-03','vendra@keratonjimbaranresort.com','Vincent',1),(10098,'Enriqueta','Zella','2014-08-25','bali@pansea.com','Zella',1),(10099,'Aurora','Zoella','2013-08-26','sales@legianbeachbali.com','Zoella',1),(10100,'Myrna','Zana','2013-03-31','zhuliana@gmail.com','Zana',1);
/*!40000 ALTER TABLE `Student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Completed`
--

DROP TABLE IF EXISTS `Completed`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Completed` (
  `studentid` int(11) NOT NULL,
  `courseid` int(11) NOT NULL,
  `Grade` int(11) NOT NULL,
  KEY `courseid_idx` (`courseid`),
  KEY `studentid_idx` (`studentid`),
  CONSTRAINT `courseidcompleted` FOREIGN KEY (`courseid`) REFERENCES `Course` (`courseid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `studentidcompleted` FOREIGN KEY (`studentid`) REFERENCES `Student` (`studentID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Completed`
--

LOCK TABLES `Completed` WRITE;
/*!40000 ALTER TABLE `Completed` DISABLE KEYS */;
INSERT INTO `Completed` VALUES (10001,7014,5),(10002,7015,1),(10003,7016,3),(10004,7017,1),(10005,7018,1),(10006,7019,5),(10007,7020,5),(10008,7021,4),(10009,7022,3),(10010,7023,3),(10011,7024,3),(10012,7025,3),(10013,7001,6),(10014,7002,4),(10015,7003,1),(10016,7004,3),(10017,7005,5),(10018,7006,3),(10019,7007,1),(10020,7008,4),(10021,7009,1),(10022,7010,4),(10023,7011,2),(10024,7012,4),(10025,7013,1),(10026,7011,4),(10027,7012,2),(10028,7013,5),(10029,7014,3),(10030,7015,4),(10031,7016,2),(10032,7017,2),(10033,7018,2),(10034,7019,1),(10035,7020,2);
/*!40000 ALTER TABLE `Completed` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Course`
--

DROP TABLE IF EXISTS `Course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Course` (
  `courseid` int(11) NOT NULL AUTO_INCREMENT,
  `coursename` varchar(55) NOT NULL,
  `size` int(11) NOT NULL,
  `credits` int(11) NOT NULL,
  `lecturerid` int(11) NOT NULL,
  `startdate` date NOT NULL,
  `enddate` date NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`courseid`),
  KEY `lecturerid_idx` (`lecturerid`),
  CONSTRAINT `lecturerid` FOREIGN KEY (`lecturerid`) REFERENCES `Lecturer` (`lecturerid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Course`
--

LOCK TABLES `Course` WRITE;
/*!40000 ALTER TABLE `Course` DISABLE KEYS */;
INSERT INTO `Course` VALUES (7001,'Fundamental Programming Concepts',84,4,2002,'2016-08-03','2016-11-28',1),(7002,'Introduction to Computing Using Python',68,5,2003,'2016-08-08','2016-12-06',1),(7003,'Introduction to Computing Using MATLAB',88,6,2004,'2016-08-10','2016-12-03',1),(7004,'Introduction to Computing Using MATLAB and Robotics',57,8,2005,'2016-08-10','2016-12-01',1),(7005,'Transition to Object-Oriented Programming',42,5,2006,'2016-08-10','2016-12-02',1),(7006,'Transition to MATLAB',46,6,2007,'2016-08-09','2016-12-09',1),(7007,'Transition to Python',89,8,2008,'2016-08-05','2016-12-08',1),(7008,'Introduction to MATLAB',75,6,2009,'2016-08-06','2016-12-09',1),(7009,'Introductory Design and Programming for the Web',81,5,2010,'2016-08-06','2016-11-28',1),(7010,'Computation and Culture in a Digital Age',90,8,2001,'2016-08-03','2016-12-10',1),(7011,'Computing in the Arts',78,8,2002,'2016-08-15','2016-11-29',1),(7012,'Visual Imaging in the Electronic Age',66,7,2003,'2016-08-05','2016-12-09',1),(7013,'Introduction to Cognitive Science',53,7,2004,'2016-08-07','2016-12-10',1),(7014,'Freshmen and Nontechnical Team Projects',85,8,2005,'2016-08-05','2016-12-06',1),(7015,'UNIX Tools and Scripting',23,6,2006,'2016-08-03','2016-12-07',1),(7016,'Techniques of Hardware Prototyping',43,8,2007,'2016-08-06','2016-12-05',1),(7017,'Introduction to iPhone and Apple Watch Development',33,8,2008,'2016-08-14','2016-11-30',1),(7018,'Intermediate iPhone Development',87,6,2006,'2016-08-02','2016-12-10',1),(7019,'Object-Oriented Programming and Data Structures',95,8,2007,'2016-08-06','2016-12-12',1),(7020,'Programming Practicum',73,5,2008,'2016-08-05','2016-12-10',1),(7021,'Object-Oriented Design and Data Structures',35,8,2007,'2016-08-02','2016-12-05',1),(7022,'Excursions in Computational Sustainability',49,7,2008,'2016-08-11','2016-12-12',1),(7023,'Networks',41,8,2009,'2016-08-05','2016-11-29',1),(7024,'Data Structures and Functional Programming',28,7,2010,'2016-08-11','2016-12-11',1),(7025,'Introduction to Computer Game Architecture',78,4,2001,'2016-08-09','2016-12-08',1);
/*!40000 ALTER TABLE `Course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Enrolment`
--

DROP TABLE IF EXISTS `Enrolment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Enrolment` (
  `studentid` int(11) NOT NULL,
  `courseid` int(11) NOT NULL,
  KEY `courseid_idx` (`courseid`),
  KEY `studentid` (`studentid`),
  CONSTRAINT `courseid` FOREIGN KEY (`courseid`) REFERENCES `Course` (`courseid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `studentid` FOREIGN KEY (`studentid`) REFERENCES `Student` (`studentID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Enrolment`
--

LOCK TABLES `Enrolment` WRITE;
/*!40000 ALTER TABLE `Enrolment` DISABLE KEYS */;
INSERT INTO `Enrolment` VALUES (10001,7001),(10002,7002),(10003,7003),(10004,7004),(10005,7005),(10006,7006),(10007,7007),(10008,7008),(10009,7009),(10010,7010),(10011,7011),(10012,7012),(10013,7013),(10014,7014),(10015,7015),(10016,7016),(10017,7017),(10018,7018),(10019,7019),(10020,7020),(10021,7021),(10022,7022),(10023,7023),(10024,7024),(10025,7025),(10026,7001),(10027,7002),(10028,7003),(10029,7004),(10030,7005),(10031,7006),(10032,7007),(10033,7008),(10034,7009),(10035,7010),(10036,7011),(10037,7012),(10038,7013),(10039,7014),(10040,7015),(10041,7016),(10042,7017),(10043,7018),(10044,7019),(10045,7020),(10046,7021),(10047,7022),(10048,7023),(10049,7024),(10050,7025),(10051,7001),(10052,7002),(10053,7003),(10054,7004),(10055,7005),(10056,7006),(10057,7007),(10058,7008),(10059,7009),(10060,7010),(10061,7011),(10062,7012),(10063,7013),(10064,7014),(10065,7015),(10066,7016),(10067,7017),(10068,7018),(10069,7019),(10070,7020),(10071,7021),(10072,7022),(10073,7023),(10074,7024),(10075,7025),(10076,7001),(10077,7002),(10078,7003),(10079,7004),(10080,7005),(10081,7006),(10082,7007),(10083,7008),(10084,7009),(10085,7010),(10086,7011),(10087,7012),(10088,7013),(10089,7014),(10090,7015),(10091,7016),(10092,7017),(10093,7018),(10094,7019),(10095,7020),(10096,7021),(10097,7022),(10098,7023),(10099,7024),(10100,7025);
/*!40000 ALTER TABLE `Enrolment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Lecturer`
--

DROP TABLE IF EXISTS `Lecturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Lecturer` (
  `lecturerid` int(11) NOT NULL AUTO_INCREMENT,
  `lastname` varchar(25) NOT NULL,
  `firstmidname` varchar(25) NOT NULL,
  `email` varchar(25) NOT NULL,
  `Password` varchar(25) NOT NULL,
  `status` tinyint(1) NOT NULL,
  PRIMARY KEY (`lecturerid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Lecturer`
--

LOCK TABLES `Lecturer` WRITE;
/*!40000 ALTER TABLE `Lecturer` DISABLE KEYS */;
INSERT INTO `Lecturer` VALUES (2001,'Lavonne','Sheldon','Lavonne@gmail.com','Sheldon',1),(2002,'Sheridan','Arletha','Sheridan@gmail.com','Arletha',1),(2003,'Mindy','Keitha','Mindy@gmail.com','Keitha',1),(2004,'Merle','Velia','Merle@gmail.com','Velia',1),(2005,'Kennith','Marita','Kennith@gmail.com','Marita',1),(2006,'Shaneka','Dreama','Shaneka@gmail.com','Dreama',1),(2007,'Ashlyn','Norma','Ashlyn@gmail.com','Norma',1),(2008,'Frederick','Kecia','Frederick@gmail.com','Kecia',1),(2009,'Layne','Murray','Layne@gmail.com','Murray',1),(2010,'Tim','Shera','Tim@gmail.com','Shera',1);
/*!40000 ALTER TABLE `Lecturer` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Dumping routines for database 'lala'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-12-05 16:06:15

INSERT INTO `Completed` (`studentid`, `courseid`, `Grade`) VALUES ('10001', '7025', '2');
INSERT INTO `Completed` (`studentid`, `courseid`, `Grade`) VALUES ('10001', '7024', '2');
INSERT INTO `Completed` (`studentid`, `courseid`, `Grade`) VALUES ('10001', '7023', '2');
INSERT INTO `Completed` (`studentid`, `courseid`, `Grade`) VALUES ('10001', '7022', '2');
INSERT INTO `Completed` (`studentid`, `courseid`, `Grade`) VALUES ('10001', '7021', '2');
INSERT INTO `Completed` (`studentid`, `courseid`, `Grade`) VALUES ('10001', '7022', '2');
INSERT INTO `Completed` (`studentid`, `courseid`, `Grade`) VALUES ('10002', '7025', '2');
INSERT INTO `Completed` (`studentid`, `courseid`, `Grade`) VALUES ('10003', '7025', '2');
INSERT INTO `Completed` (`studentid`, `courseid`, `Grade`) VALUES ('10004', '7025', '3');
INSERT INTO `Completed` (`studentid`, `courseid`, `Grade`) VALUES ('10005', '7025', '4');


INSERT INTO `Enrolment` (`studentid`, `courseid`) VALUES ('10001', '7002');
INSERT INTO `Enrolment` (`studentid`, `courseid`) VALUES ('10001', '7003');
INSERT INTO `Enrolment` (`studentid`, `courseid`) VALUES ('10001', '7004');
INSERT INTO `Enrolment` (`studentid`, `courseid`) VALUES ('10001', '7005');
