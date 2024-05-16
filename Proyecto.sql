-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: proyecto
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `actividad_programada`
--

DROP TABLE IF EXISTS `actividad_programada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividad_programada` (
  `Id_Actividad` int NOT NULL,
  `Estado` varchar(45) DEFAULT NULL,
  `Comentario_Alojamiento` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`Id_Actividad`),
  CONSTRAINT `FK_Actividad_Programada` FOREIGN KEY (`Id_Actividad`) REFERENCES `actividad_solicitada` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='			';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad_programada`
--

LOCK TABLES `actividad_programada` WRITE;
/*!40000 ALTER TABLE `actividad_programada` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividad_programada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `actividad_solicitada`
--

DROP TABLE IF EXISTS `actividad_solicitada`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividad_solicitada` (
  `Id` int NOT NULL AUTO_INCREMENT,
  `Departamento` int NOT NULL,
  `F_Ini` date DEFAULT NULL,
  `F_Fin` date DEFAULT NULL,
  `H_Ini` time DEFAULT NULL,
  `H_Fin` time DEFAULT NULL,
  `Estado` varchar(45) DEFAULT NULL,
  `Prevista` tinyint DEFAULT NULL,
  `Tipo` varchar(45) DEFAULT NULL,
  `Titulo` varchar(45) DEFAULT NULL,
  `Alojamiento` tinyint DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `FK_Dep_Actividades_idx` (`Departamento`),
  CONSTRAINT `FK_Dep_Actividades` FOREIGN KEY (`Departamento`) REFERENCES `departamento` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad_solicitada`
--

LOCK TABLES `actividad_solicitada` WRITE;
/*!40000 ALTER TABLE `actividad_solicitada` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividad_solicitada` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `curso`
--

DROP TABLE IF EXISTS `curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `curso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `codCurso` varchar(10) NOT NULL,
  `descripcion` varchar(60) NOT NULL,
  `etapa` varchar(15) NOT NULL,
  `activo` tinyint NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `curso`
--

LOCK TABLES `curso` WRITE;
/*!40000 ALTER TABLE `curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Codigo` varchar(6) NOT NULL,
  `Nombre` varchar(30) DEFAULT NULL,
  `JefeDepartamento` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Codigo_UNIQUE` (`Codigo`),
  KEY `JefeDpto` (`JefeDepartamento`),
  CONSTRAINT `JefeDpto` FOREIGN KEY (`JefeDepartamento`) REFERENCES `profesor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto`
--

DROP TABLE IF EXISTS `foto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foto` (
  `URL` varchar(45) NOT NULL,
  `Descripcion` varchar(45) DEFAULT NULL,
  `id_Actividad` int DEFAULT NULL,
  PRIMARY KEY (`URL`),
  KEY `FK_ActvProg_Foto_idx` (`id_Actividad`),
  CONSTRAINT `FK_ActvProg_Foto` FOREIGN KEY (`id_Actividad`) REFERENCES `actividad_programada` (`Id_Actividad`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto`
--

LOCK TABLES `foto` WRITE;
/*!40000 ALTER TABLE `foto` DISABLE KEYS */;
/*!40000 ALTER TABLE `foto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grupo`
--

DROP TABLE IF EXISTS `grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grupo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cod_grupo` varchar(20) NOT NULL,
  `id_curso` int NOT NULL,
  `alumnos` int NOT NULL,
  `activo` tinyint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_Curso_Grupo_idx` (`id_curso`),
  CONSTRAINT `FK_Curso_Grupo` FOREIGN KEY (`id_curso`) REFERENCES `curso` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grupo`
--

LOCK TABLES `grupo` WRITE;
/*!40000 ALTER TABLE `grupo` DISABLE KEYS */;
/*!40000 ALTER TABLE `grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participacion_curso`
--

DROP TABLE IF EXISTS `participacion_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participacion_curso` (
  `id_Curso` int NOT NULL,
  `id_Actividad` int NOT NULL,
  `alumnos_Participantes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_Curso`,`id_Actividad`),
  KEY `FK_Participacion_Act_idx` (`id_Actividad`),
  CONSTRAINT `FK_Participacion_Act` FOREIGN KEY (`id_Actividad`) REFERENCES `actividad_solicitada` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Participacion_Curso` FOREIGN KEY (`id_Curso`) REFERENCES `curso` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participacion_curso`
--

LOCK TABLES `participacion_curso` WRITE;
/*!40000 ALTER TABLE `participacion_curso` DISABLE KEYS */;
/*!40000 ALTER TABLE `participacion_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participacion_grupo`
--

DROP TABLE IF EXISTS `participacion_grupo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participacion_grupo` (
  `id_Grupo` int NOT NULL,
  `id_Actividad` int NOT NULL,
  `alumnos_Participantes` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_Grupo`,`id_Actividad`),
  KEY `FK_ParticipacionGrupo_Act_idx` (`id_Actividad`),
  CONSTRAINT `FK_Participacion_Grupo` FOREIGN KEY (`id_Grupo`) REFERENCES `grupo` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ParticipacionGrupo_Act` FOREIGN KEY (`id_Actividad`) REFERENCES `actividad_solicitada` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participacion_grupo`
--

LOCK TABLES `participacion_grupo` WRITE;
/*!40000 ALTER TABLE `participacion_grupo` DISABLE KEYS */;
/*!40000 ALTER TABLE `participacion_grupo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participacion_profesores`
--

DROP TABLE IF EXISTS `participacion_profesores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participacion_profesores` (
  `id_Actividad` int NOT NULL,
  `id_Prof` int NOT NULL,
  `Rol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_Actividad`,`id_Prof`),
  KEY `FK_Prof_Participante_idx` (`id_Prof`),
  CONSTRAINT `FK_Actividades_Participaciones` FOREIGN KEY (`id_Actividad`) REFERENCES `actividad_solicitada` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_Prof_Participante` FOREIGN KEY (`id_Prof`) REFERENCES `profesor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participacion_profesores`
--

LOCK TABLES `participacion_profesores` WRITE;
/*!40000 ALTER TABLE `participacion_profesores` DISABLE KEYS */;
/*!40000 ALTER TABLE `participacion_profesores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profesor`
--

DROP TABLE IF EXISTS `profesor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profesor` (
  `id` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) DEFAULT NULL,
  `Apellidos` varchar(45) DEFAULT NULL,
  `DNI` varchar(9) NOT NULL,
  `cod_departamento` varchar(45) DEFAULT NULL,
  `Correo_Institucional` varchar(45) NOT NULL,
  `contraseña` varchar(80) NOT NULL,
  `Activo` tinyint NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `DNI_UNIQUE` (`DNI`),
  UNIQUE KEY `Correo_Institucional_UNIQUE` (`Correo_Institucional`),
  KEY `FK_Departamento_Prof_ID_idx` (`cod_departamento`),
  CONSTRAINT `FK_Profesor_Departamento` FOREIGN KEY (`cod_departamento`) REFERENCES `departamento` (`Codigo`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profesor`
--

LOCK TABLES `profesor` WRITE;
/*!40000 ALTER TABLE `profesor` DISABLE KEYS */;
/*!40000 ALTER TABLE `profesor` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `profesor_BEFORE_INSERT` BEFORE INSERT ON `profesor` FOR EACH ROW BEGIN
	set new.contraseña=SHA2(new.contraseña,256);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `transporte`
--

DROP TABLE IF EXISTS `transporte`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transporte` (
  `id_Empresa` int NOT NULL,
  `id_Actividad` int NOT NULL,
  `Tipo` varchar(45) DEFAULT NULL,
  `Comentarios` varchar(200) DEFAULT NULL,
  `Importe` decimal(10,0) DEFAULT NULL,
  PRIMARY KEY (`id_Empresa`),
  UNIQUE KEY `id_Actividad_UNIQUE` (`id_Actividad`),
  CONSTRAINT `FK_ActvSol_Transporte` FOREIGN KEY (`id_Empresa`) REFERENCES `actividad_solicitada` (`Id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transporte`
--

LOCK TABLES `transporte` WRITE;
/*!40000 ALTER TABLE `transporte` DISABLE KEYS */;
/*!40000 ALTER TABLE `transporte` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-16 18:48:59
