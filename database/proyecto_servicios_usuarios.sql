-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: proyecto_servicios
-- ------------------------------------------------------
-- Server version	9.7.0

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '83f11905-5308-11f1-ae8f-a44cc883fd7a:1-43';

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `foto_perfil` varchar(255) DEFAULT NULL,
  `correo` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `password_hash` varchar(255) NOT NULL,
  `foto_cedula` varchar(255) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `estado` enum('Activo','Pendiente','Rechazado','Eliminado') NOT NULL DEFAULT 'Pendiente',
  `rol` enum('Cliente','Prestador') NOT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `correo` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Prueba prueba','https://cdn.pixabay.com/photo/2020/10/17/13/52/woman-5662208_1280.jpg','prueba@gmail.com','3001234567','12345','https://cdn.pixabay.com/photo/2020/10/17/13/52/woman-5662208_1280.jpg','2000-01-01','Activo','Cliente'),(5,'Hernan Herrera','nn','98monikalejandeeera@gmail.com','3204948279','2345','ced','1988-06-10','Pendiente','Cliente'),(6,'laur','s','CIPAGAUTA.MONICAA@GMAIL.COM','3204948279','2345','ced','1988-06-10','Pendiente','Cliente'),(7,'Laura','https://thumbs.dreamstime.com/b/se%C3%B1ora-joven-hermosa-en-fondo-gris-128392566.jpg','laurita33@gmail.com','3333333','12345','https://thumbs.dreamstime.com/b/se%C3%B1ora-joven-hermosa-en-fondo-gris-128392566.jpg','1999-06-24','Pendiente','Cliente'),(8,'Ivanna','https://cdn.pixabay.com/photo/2020/10/17/13/52/woman-5662208_1280.jpg','IVANNA@GMAIL.COM','2344444','12345','https://cdn.pixabay.com/photo/2020/10/17/13/52/woman-5662208_1280.jpg','1999-06-16','Pendiente','Cliente'),(9,'ivan','https://cdn.pixabay.com/photo/2020/10/17/13/52/woman-5662208_1280.jpg','Ivan@gmail.com','56777777','12345','https://cdn.pixabay.com/photo/2020/10/17/13/52/woman-5662208_1280.jpg','2026-06-18','Pendiente','Cliente'),(10,'ivan','https://cdn.pixabay.com/photo/2020/10/17/13/52/woman-5662208_1280.jpg','Ivan111@gmail.com','56777777','12345','https://cdn.pixabay.com/photo/2020/10/17/13/52/woman-5662208_1280.jpg','2026-06-18','Pendiente','Cliente'),(11,'Monica','https://cdn.pixabay.com/photo/2020/10/17/13/52/woman-5662208_1280.jpg','mmmm@gmail.com','56777777','12345','https://cdn.pixabay.com/photo/2020/10/17/13/52/woman-5662208_1280.jpg','2026-06-18','Pendiente','Cliente'),(12,'Monica','https://cdn.pixabay.com/photo/2020/10/17/13/52/woman-5662208_1280.jpg','monicaproveedor@gmail.com','56777777','12345','https://cdn.pixabay.com/photo/2020/10/17/13/52/woman-5662208_1280.jpg','2026-06-18','Pendiente','Prestador'),(13,'Monica','https://cdn.pixabay.com/photo/2020/10/17/13/52/woman-5662208_1280.jpg','mhg@gmail.com','56777777','12345','https://cdn.pixabay.com/photo/2020/10/17/13/52/woman-5662208_1280.jpg','2026-06-18','Pendiente','Cliente'),(14,'Prueba prueba','https://cdn.pixabay.com/photo/2020/10/17/13/52/woman-5662208_1280.jpg','prueba12@gmail.com','34566677','12345','https://thumbs.dreamstime.com/b/se%C3%B1ora-joven-hermosa-en-fondo-gris-128392566.jpg','2000-01-01','Pendiente','Cliente');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-06-24 22:12:24
