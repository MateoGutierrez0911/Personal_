drop database if exists artemisa;

-- -----------------------------------------------------
-- Schema artemisa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `artemisa` DEFAULT CHARACTER SET utf8mb4 ;
USE `artemisa` ;

-- -----------------------------------------------------
-- Table `artemisa`.`tipo_doc`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artemisa`.`tipo_doc` (
  `idDoc` INT(11) NOT NULL,
  `tipoDoc` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`idDoc`));




-- -----------------------------------------------------
-- Table `artemisa`.`rol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artemisa`.`rol` (
  `idRol` INT(11) NOT NULL AUTO_INCREMENT,
  `nombreRol` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`idRol`));
-- -----------------------------------------------------
-- Table `artemisa`.`usuarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artemisa`.`usuarios` (
  `idUsuario` INT(11) NOT NULL AUTO_INCREMENT,
  `docUsuario` VARCHAR(20) NOT NULL,
  `nombreUsuario` VARCHAR(50) NOT NULL,
  `emailUsuario` VARCHAR(120) NOT NULL,
  `Contraseña` VARCHAR(100) NOT NULL,
  `estadoUsuario` VARCHAR(10) NOT NULL,
  `created_at` DATE NULL DEFAULT NULL,
  `updated_at` DATE NULL DEFAULT NULL,
  `idRol` INT(11) NOT NULL,
  `idDoc` INT(11) NOT NULL,
  PRIMARY KEY (`idUsuario`),
  CONSTRAINT `usuarios_ibfk_1`
    FOREIGN KEY (`idRol`)
    REFERENCES `artemisa`.`rol` (`idRol`),
  CONSTRAINT `usuarios_ibfk_2`
    FOREIGN KEY (`idDoc`)
    REFERENCES `artemisa`.`tipo_doc` (`idDoc`));


-- -----------------------------------------------------
-- Table `artemisa`.`alquiler`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artemisa`.`alquiler` (
  `idAlquiler` INT(11) NOT NULL AUTO_INCREMENT,
  `fechaAlquiler` DATE NULL DEFAULT NULL,
  `valorTotal` INT(11) NOT NULL,
  `created_at` DATE NULL DEFAULT NULL,
  `updated_at` DATE NULL DEFAULT NULL,
  `idUsuario` INT(11) NOT NULL,
  PRIMARY KEY (`idAlquiler`),
  CONSTRAINT `alquiler_ibfk_1`
   FOREIGN KEY (`idUsuario`)
    REFERENCES `artemisa`.`usuarios` (`idUsuario`));


-- -----------------------------------------------------
-- Table `artemisa`.`categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artemisa`.`categoria` (
  `idCategoriaProducto` INT(11) NOT NULL AUTO_INCREMENT,
  `categoriaProducto` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idCategoriaProducto`));


-- -----------------------------------------------------
-- Table `artemisa`.`producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artemisa`.`producto` (
  `idProducto` INT(11) NOT NULL AUTO_INCREMENT,
  `codProducto` VARCHAR(40) NOT NULL,
  `nombreProducto` VARCHAR(200) NOT NULL,
  `stockProducto` INT(11) NOT NULL,
  `genero` CHAR(1) NOT NULL,
  `estadoProducto` VARCHAR(10) NOT NULL,
  `created_at` DATE NULL DEFAULT NULL,
  `updated_at` DATE NULL DEFAULT NULL,
  `idCategoriaProducto` INT(11) NOT NULL,
  PRIMARY KEY (`idProducto`),
  CONSTRAINT `producto_ibfk_1`
    FOREIGN KEY (`idCategoriaProducto`)
    REFERENCES `artemisa`.`categoria` (`idCategoriaProducto`));


-- -----------------------------------------------------
-- Table `artemisa`.`detallealquiler`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artemisa`.`detallealquiler` (
  `iddetalle_Alquiler` INT(11) NOT NULL AUTO_INCREMENT,
  `valorAlquiler` INT(11) NOT NULL,
  `iva` INT(11) NOT NULL,
  `created_at` DATE NULL DEFAULT NULL,
  `updated_at` DATE NULL DEFAULT NULL,
  `idAlquiler` INT(11) NOT NULL,
  `idProducto` INT(11) NOT NULL,
  PRIMARY KEY (`iddetalle_Alquiler`),
  CONSTRAINT `detallealquiler_ibfk_1`
    FOREIGN KEY (`idAlquiler`)
    REFERENCES `artemisa`.`alquiler` (`idAlquiler`),
  CONSTRAINT `detallealquiler_ibfk_2`
    FOREIGN KEY (`idProducto`)
    REFERENCES `artemisa`.`producto` (`idProducto`));








-- -----------------------------------------------------
-- Table `artemisa`.`ventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artemisa`.`ventas` (
  `idVenta` INT(11) NOT NULL AUTO_INCREMENT,
  `fechaVenta` DATE NULL DEFAULT NULL,
  `valorTotal` INT(11) NOT NULL,
  `created_at` DATE NULL DEFAULT NULL,
  `updated_at` DATE NULL DEFAULT NULL,
  `idUsuario` INT(11) NOT NULL,
  PRIMARY KEY (`idVenta`),
  CONSTRAINT `ventas_ibfk_1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `artemisa`.`usuarios` (`idUsuario`));



-- -----------------------------------------------------
-- Table `artemisa`.`detalleventas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artemisa`.`detalleventas` (
  `idDetalleVenta` INT(11) NOT NULL AUTO_INCREMENT,
  `cantidadProducto` INT(11) NOT NULL,
  `valorProducto` INT(11) NOT NULL,
  `iva` INT(11) NOT NULL,
  `valorTotal` INT(11) NOT NULL,
  `created_at` DATE NULL DEFAULT NULL,
  `updated_at` DATE NULL DEFAULT NULL,
  `idVenta` INT(11) NOT NULL,
  `idProducto` INT(11) NOT NULL,
  PRIMARY KEY (`idDetalleVenta`),
  CONSTRAINT `detalleventas_ibfk_1`
    FOREIGN KEY (`idVenta`)
    REFERENCES `artemisa`.`ventas` (`idVenta`),
  CONSTRAINT `detalleventas_ibfk_2`
    FOREIGN KEY (`idProducto`)
    REFERENCES `artemisa`.`producto` (`idProducto`));


-- -----------------------------------------------------
-- Table `artemisa`.`tipoventaalquiler`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artemisa`.`tipoventaalquiler` (
  `idTipoVentaAlquiler` INT(11) NOT NULL AUTO_INCREMENT,
  `descTipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idTipoVentaAlquiler`));


-- -----------------------------------------------------
-- Table `artemisa`.`visitas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `artemisa`.`visitas` (
  `idVisita` INT(11) NOT NULL AUTO_INCREMENT,
  `fechaVisita` DATE NULL DEFAULT NULL,
  `estadoVisita` VARCHAR(10) NOT NULL,
  `created_at` DATE NULL DEFAULT NULL,
  `updated_at` DATE NULL DEFAULT NULL,
  `idUsuario` INT(11) NOT NULL,
  `idProducto` INT(11) NOT NULL,
  `idTipoVentaAlquiler` INT(11) NOT NULL,
  PRIMARY KEY (`idVisita`),
  CONSTRAINT `visitas_ibfk_1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `artemisa`.`usuarios` (`idUsuario`),
  CONSTRAINT `visitas_ibfk_2`
    FOREIGN KEY (`idTipoVentaAlquiler`)
    REFERENCES `artemisa`.`tipoventaalquiler` (`idTipoVentaAlquiler`),
  CONSTRAINT `visitas_ibfk_3`
    FOREIGN KEY (`idProducto`)
    REFERENCES `artemisa`.`producto` (`idProducto`));
    
USE `artemisa`;

DELIMITER $$

USE `artemisa`$$
CREATE
TRIGGER `artemisa`.`Alquiler_INSERT`
BEFORE INSERT ON `artemisa`.`alquiler`
FOR EACH ROW
BEGIN
        -- Set the creation date
    SET new.created_at = NOW();
    SET new.fechaAlquiler = NOW();

 END$$

USE `artemisa`$$
CREATE
TRIGGER `artemisa`.`Alquiler_UPDATE`
BEFORE UPDATE ON `artemisa`.`alquiler`
FOR EACH ROW
BEGIN
        -- Set the udpate date
    SET new.updated_at = NOW();
END$$

USE `artemisa`$$
CREATE
TRIGGER `artemisa`.`Producto_INSERT`
BEFORE INSERT ON `artemisa`.`producto`
FOR EACH ROW
BEGIN
        -- Set the creation date
    SET new.created_at = NOW();

 END$$

USE `artemisa`$$
CREATE
TRIGGER `artemisa`.`Producto_UPDATE`
BEFORE UPDATE ON `artemisa`.`producto`
FOR EACH ROW
BEGIN
        -- Set the udpate date
    SET new.updated_at = NOW();
END$$

USE `artemisa`$$
CREATE
TRIGGER `artemisa`.`DetalleAlquiler_INSERT`
BEFORE INSERT ON `artemisa`.`detallealquiler`
FOR EACH ROW
BEGIN
        -- Set the creation date
    SET new.created_at = NOW();

 END$$

USE `artemisa`$$
CREATE
TRIGGER `artemisa`.`DetalleAlquiler_UPDATE`
BEFORE UPDATE ON `artemisa`.`detallealquiler`
FOR EACH ROW
BEGIN
        -- Set the udpate date
    SET new.updated_at = NOW();
END$$

USE `artemisa`$$
CREATE
TRIGGER `artemisa`.`Usuarios_INSERT`
BEFORE INSERT ON `artemisa`.`usuarios`
FOR EACH ROW
BEGIN
        -- Set the creation date
    SET new.created_at = NOW();

 END$$

USE `artemisa`$$
CREATE
TRIGGER `artemisa`.`Usuarios_UPDATE`
BEFORE UPDATE ON `artemisa`.`usuarios`
FOR EACH ROW
BEGIN
        -- Set the udpate date
    SET new.updated_at = NOW();
END$$

USE `artemisa`$$
CREATE
TRIGGER `artemisa`.`Ventas_INSERT`
BEFORE INSERT ON `artemisa`.`ventas`
FOR EACH ROW
BEGIN
        -- Set the creation date
    SET new.created_at = NOW();
    SET new.fechaVenta = NOW();

 END$$

USE `artemisa`$$
CREATE
TRIGGER `artemisa`.`Ventas_UPDATE`
BEFORE UPDATE ON `artemisa`.`ventas`
FOR EACH ROW
BEGIN
        -- Set the udpate date
    SET new.updated_at = NOW();
END$$

USE `artemisa`$$
CREATE
TRIGGER `artemisa`.`DetalleVentas_INSERT`
BEFORE INSERT ON `artemisa`.`detalleventas`
FOR EACH ROW
BEGIN
        -- Set the creation date
    SET new.created_at = NOW();

 END$$

USE `artemisa`$$
CREATE
TRIGGER `artemisa`.`DetalleVentas_UPDATE`
BEFORE UPDATE ON `artemisa`.`detalleventas`
FOR EACH ROW
BEGIN
        -- Set the udpate date
    SET new.updated_at = NOW();
END$$

USE `artemisa`$$
CREATE
TRIGGER `artemisa`.`Visitas_INSERT`
BEFORE INSERT ON `artemisa`.`visitas`
FOR EACH ROW
BEGIN
        -- Set the creation date
    SET new.created_at = NOW();
    SET new.fechaVisita = NOW();

 END$$

USE `artemisa`$$
CREATE
TRIGGER `artemisa`.`Visitas_UPDATE`
BEFORE UPDATE ON `artemisa`.`visitas`
FOR EACH ROW
BEGIN
        -- Set the udpate date
    SET new.updated_at = NOW();
	SET new.fechaVisita = NOW(); 
END$$


DELIMITER ;
