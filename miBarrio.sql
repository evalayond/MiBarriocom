-- MySQL Script generated by MySQL Workbench
-- Tue Sep 14 21:01:52 2021
-- Model: New Model    Version:productosegresoproductos 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema barriodb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema barriodb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `barriodb` DEFAULT CHARACTER SET utf8 ;
USE `barriodb` ;

-- -----------------------------------------------------
-- Table `barriodb`.`Usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `barriodb`.`Usuarios` (
  `idUsuarios` INT NOT NULL AUTO_INCREMENT,
  `nombres` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `tipoDocumento` VARCHAR(45) NOT NULL,
  `identificacion` VARCHAR(45) NOT NULL,
  `rolUsuario` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `correo` VARCHAR(45) NOT NULL,
  `edad` INT NOT NULL,
  PRIMARY KEY (`idUsuarios`),
  UNIQUE INDEX `idUsuarios_UNIQUE` (`idUsuarios` ASC) VISIBLE,
  UNIQUE INDEX `identificacion_UNIQUE` (`identificacion` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `barriodb`.`Vendedores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `barriodb`.`Vendedores` (
  `idVendedores` INT NOT NULL AUTO_INCREMENT,
  `idUsurioVendedor` INT NOT NULL,
  `usuario` VARCHAR(45) NOT NULL,
  `clave` VARCHAR(45) NOT NULL,
  `fechaLogin` DATE NULL,
  UNIQUE INDEX `idVendedores_UNIQUE` (`idVendedores` ASC) VISIBLE,
  PRIMARY KEY (`idVendedores`),
  INDEX `UsuarioVendedor_idx` (`idUsurioVendedor` ASC) VISIBLE,
  CONSTRAINT `UsuarioVendedor`
    FOREIGN KEY (`idUsurioVendedor`)
    REFERENCES `barriodb`.`Usuarios` (`idUsuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `barriodb`.`Productos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `barriodb`.`Productos` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `nombreProducto` VARCHAR(45) NOT NULL,
  `categoria` VARCHAR(45) NOT NULL,
  `unidadMedida` VARCHAR(45) NOT NULL,
  `cantidad` INT NOT NULL,
  `valorUnitarioCompra` DOUBLE NOT NULL,
  `valorUnitarioVenta` DOUBLE NOT NULL,
  UNIQUE INDEX `idProducto_UNIQUE` (`idProducto` ASC) VISIBLE,
  PRIMARY KEY (`idProducto`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `barriodb`.`Ingresos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `barriodb`.`Ingresos` (
  `idIngresos` INT NOT NULL AUTO_INCREMENT,
  `idProducto` INT NOT NULL,
  `cantidadIngresoProducto` DOUBLE NOT NULL,
  `fechaIngreso` DATE NOT NULL,
  `costoUnitario` DOUBLE NOT NULL,
  `idUsuarios` INT NOT NULL,
  PRIMARY KEY (`idIngresos`),
  UNIQUE INDEX `idIngresos_UNIQUE` (`idIngresos` ASC) VISIBLE,
  INDEX `IngresosProductos_idx` (`idProducto` ASC) VISIBLE,
  INDEX `ProveedorIngresos_idx` (`idUsuarios` ASC) VISIBLE,
  CONSTRAINT `IngresosProductos`
    FOREIGN KEY (`idProducto`)
    REFERENCES `barriodb`.`Productos` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ProveedorIngresos`
    FOREIGN KEY (`idUsuarios`)
    REFERENCES `barriodb`.`Usuarios` (`idUsuarios`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `barriodb`.`Egresos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `barriodb`.`Egresos` (
  `idEgresos` INT NOT NULL AUTO_INCREMENT,
  `fechaVenta` DATE NOT NULL,
  `total` DOUBLE NOT NULL,
  `idVendedor` INT NOT NULL,
  UNIQUE INDEX `idEgresos_UNIQUE` (`idEgresos` ASC) VISIBLE,
  PRIMARY KEY (`idEgresos`),
  INDEX `VendedoresEgresos_idx` (`idVendedor` ASC) VISIBLE,
  CONSTRAINT `VendedoresEgresos`
    FOREIGN KEY (`idVendedor`)
    REFERENCES `barriodb`.`Vendedores` (`idVendedores`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `barriodb`.`EgresoProductos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `barriodb`.`EgresoProductos` (
  `idEgresoProductos` INT NOT NULL AUTO_INCREMENT,
  `idProductos` INT NOT NULL,
  `idEgresos` INT NOT NULL,
  `cantidadVendida` DOUBLE NOT NULL,
  `precioCompra` DOUBLE NOT NULL,
  `precioVenta` DOUBLE NOT NULL,
  PRIMARY KEY (`idEgresoProductos`),
  UNIQUE INDEX `idEgresoProductos_UNIQUE` (`idEgresoProductos` ASC) VISIBLE,
  INDEX `EgresoProductos_idx` (`idProductos` ASC) VISIBLE,
  INDEX `ProductosEgreso_idx` (`idEgresos` ASC) VISIBLE,
  CONSTRAINT `EgresoProductos`
    FOREIGN KEY (`idProductos`)
    REFERENCES `barriodb`.`Productos` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `ProductosEgreso`
    FOREIGN KEY (`idEgresos`)
    REFERENCES `barriodb`.`Egresos` (`idEgresos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
