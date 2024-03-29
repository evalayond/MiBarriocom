-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: localhost    Database: barriodb
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `egresoproductos`
--

DROP TABLE IF EXISTS `egresoproductos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `egresoproductos` (
  `idEgresoProductos` int NOT NULL AUTO_INCREMENT,
  `idProductos` int NOT NULL,
  `idEgresos` int NOT NULL,
  `cantidadVendida` double NOT NULL,
  `precioCompra` double NOT NULL,
  `precioVenta` double NOT NULL,
  PRIMARY KEY (`idEgresoProductos`),
  UNIQUE KEY `idEgresoProductos_UNIQUE` (`idEgresoProductos`),
  KEY `EgresoProductos_idx` (`idProductos`),
  KEY `ProductosEgreso_idx` (`idEgresos`),
  CONSTRAINT `EgresoProductos` FOREIGN KEY (`idProductos`) REFERENCES `productos` (`idProducto`),
  CONSTRAINT `ProductosEgreso` FOREIGN KEY (`idEgresos`) REFERENCES `egresos` (`idEgresos`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `egresoproductos`
--

LOCK TABLES `egresoproductos` WRITE;
/*!40000 ALTER TABLE `egresoproductos` DISABLE KEYS */;
/*!40000 ALTER TABLE `egresoproductos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `egresos`
--

DROP TABLE IF EXISTS `egresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `egresos` (
  `idEgresos` int NOT NULL AUTO_INCREMENT,
  `fechaVenta` date NOT NULL,
  `total` double NOT NULL,
  `idVendedor` int NOT NULL,
  PRIMARY KEY (`idEgresos`),
  UNIQUE KEY `idEgresos_UNIQUE` (`idEgresos`),
  KEY `VendedoresEgresos_idx` (`idVendedor`),
  CONSTRAINT `VendedoresEgresos` FOREIGN KEY (`idVendedor`) REFERENCES `vendedores` (`idVendedores`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `egresos`
--

LOCK TABLES `egresos` WRITE;
/*!40000 ALTER TABLE `egresos` DISABLE KEYS */;
/*!40000 ALTER TABLE `egresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresos`
--

DROP TABLE IF EXISTS `ingresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingresos` (
  `idIngresos` int NOT NULL AUTO_INCREMENT,
  `idProducto` int NOT NULL,
  `cantidadIngresoProducto` double NOT NULL,
  `fechaIngreso` date NOT NULL,
  `costoUnitario` double NOT NULL,
  `idUsuarios` int NOT NULL,
  PRIMARY KEY (`idIngresos`),
  UNIQUE KEY `idIngresos_UNIQUE` (`idIngresos`),
  KEY `IngresosProductos_idx` (`idProducto`),
  KEY `ProveedorIngresos_idx` (`idUsuarios`),
  CONSTRAINT `IngresosProductos` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`idProducto`),
  CONSTRAINT `ProveedorIngresos` FOREIGN KEY (`idUsuarios`) REFERENCES `usuarios` (`idUsuarios`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresos`
--

LOCK TABLES `ingresos` WRITE;
/*!40000 ALTER TABLE `ingresos` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productos` (
  `idProducto` int NOT NULL AUTO_INCREMENT,
  `nombreProducto` varchar(45) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  `unidadMedida` varchar(45) NOT NULL,
  `cantidad` int NOT NULL,
  `valorUnitarioCompra` double NOT NULL,
  `valorUnitarioVenta` double NOT NULL,
  PRIMARY KEY (`idProducto`),
  UNIQUE KEY `idProducto_UNIQUE` (`idProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES (1,'Jabon fab en polvo x500','Aseo','und',1,13000,14300);
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `idUsuarios` int NOT NULL AUTO_INCREMENT,
  `nombres` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `tipoDocumento` varchar(45) NOT NULL,
  `identificacion` varchar(45) NOT NULL,
  `rolUsuario` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) NOT NULL,
  `correo` varchar(45) NOT NULL,
  `edad` int NOT NULL,
  PRIMARY KEY (`idUsuarios`),
  UNIQUE KEY `idUsuarios_UNIQUE` (`idUsuarios`),
  UNIQUE KEY `identificacion_UNIQUE` (`identificacion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'Edwin','Alayon','cc','12345678','vendedor','bucaramanga','3001234567','a@a.com',25);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendedores`
--

DROP TABLE IF EXISTS `vendedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vendedores` (
  `idVendedores` int NOT NULL AUTO_INCREMENT,
  `idUsurioVendedor` int NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `clave` varchar(45) NOT NULL,
  `fechaLogin` date DEFAULT NULL,
  PRIMARY KEY (`idVendedores`),
  UNIQUE KEY `idVendedores_UNIQUE` (`idVendedores`),
  KEY `UsuarioVendedor_idx` (`idUsurioVendedor`),
  CONSTRAINT `UsuarioVendedor` FOREIGN KEY (`idUsurioVendedor`) REFERENCES `usuarios` (`idUsuarios`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendedores`
--

LOCK TABLES `vendedores` WRITE;
/*!40000 ALTER TABLE `vendedores` DISABLE KEYS */;
INSERT INTO `vendedores` VALUES (1,1,'ealayon','1234',NULL);
/*!40000 ALTER TABLE `vendedores` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-14 21:42:02
