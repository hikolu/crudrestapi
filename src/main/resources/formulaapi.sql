--
-- Table structure for table `drivers`
--

DROP TABLE IF EXISTS `drivers`;

CREATE TABLE `drivers` (
    `id` int NOT NULL AUTO_INCREMENT,
    `first_name` varchar(45) DEFAULT NULL,
    `last_name` varchar(45) DEFAULT NULL,
    `team` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Data for table `employee`
--

INSERT INTO `drivers` VALUES
   (1,'Max','Verstappen','Red Bull Racing'),
   (2,'Sergio','Perez','Red Bull Racing'),
   (3,'Lewis','Hamilton','Mercedes'),
   (4,'George','Russel','Mercedes'),
   (5,'Fernando','Alonso','Aston Martin'),
   (6,'Lance','Stroll','Aston Martin'),
   (7,'Carlos','Sainz','Ferrari'),
   (8,'Charles','Leclerc','Ferrari'),
   (9,'Lando','Norris','McLaren'),
   (10,'Oscar','Piastri','McLaren'),
   (11,'Pierre','Gasly','Alpine'),
   (12,'Esteban','Ocon','Alpine'),
   (13,'Alexander','Albon','Williams'),
   (14,'Logan','Sargeant','Williams'),
   (15,'Valtteri','Bottas','Alfa Romeo'),
   (16,'Zhou','Guanyu','Alfa Romeo'),
   (17,'Nico','Hulkenberg','Haas F1 Team'),
   (18,'Kevin','Magnussen','Haas F1 Team'),
   (19,'Daniel','Ricciardo','AlphaTauri'),
   (20,'Yuki','Tsunoda','AlphaTauri');