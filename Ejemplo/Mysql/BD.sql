CREATE SCHEMA `bd_ejemplo` DEFAULT CHARACTER SET utf8 ;
CREATE TABLE `bd_ejemplo`.`tipo_conductor` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(255) NULL,
  PRIMARY KEY (`id`)) 
  ENGINE = InnoDB;

CREATE TABLE `bd_ejemplo`.`tipo_vehiculo` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
  ENGINE = InnoDB;

CREATE TABLE `bd_ejemplo`.`vehiculo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `marca` VARCHAR(255) NOT NULL,
  `modelo` VARCHAR(255) NOT NULL,
  `matricula` VARCHAR(255) NULL,
  `anio` INT NULL,
  `id_tipo_vehiculo` INT,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_vehiculo_tipo_vehiculo`
    FOREIGN KEY (`id_tipo_vehiculo`)
    REFERENCES `bd_ejemplo`.`tipo_vehiculo` (`id`))
  ENGINE = InnoDB;

CREATE TABLE `bd_ejemplo`.`conductor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(255) NOT NULL,
  `tipo_licencia` VARCHAR(255) NOT NULL,
  `id_vehiculo` INT,
  `id_tipo_conductor` INT,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_conductor_vehiculo`
    FOREIGN KEY (`id_vehiculo`)
    REFERENCES `bd_ejemplo`.`vehiculo` (`id`),
  CONSTRAINT `fk_conductor_tipo_conductor`
    FOREIGN KEY (`id_tipo_conductor`)
    REFERENCES `bd_ejemplo`.`tipo_conductor` (`id`))
  ENGINE = InnoDB;

CREATE TABLE `bd_ejemplo`.`contrato` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_vehiculo` INT,
  `id_conductor` INT,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_contrato_vehiculo`
    FOREIGN KEY (`id_vehiculo`)
    REFERENCES `bd_ejemplo`.`vehiculo` (`id`),
  CONSTRAINT `fk_contrato_conductor`
    FOREIGN KEY (`id_conductor`)
    REFERENCES `bd_ejemplo`.`conductor` (`id`))
  ENGINE = InnoDB;

CREATE TABLE `bd_ejemplo`.`ruta` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `estacion` VARCHAR(255) NOT NULL,
  `id_vehiculo` INT,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_ruta_vehiculo`
    FOREIGN KEY (`id_vehiculo`)
    REFERENCES `bd_ejemplo`.`vehiculo` (`id`))
  ENGINE = InnoDB;
  
INSERT INTO `bd_ejemplo`.`tipo_vehiculo`(`id`,`nombre`) VALUES (1, "Taxi");
INSERT INTO `bd_ejemplo`.`tipo_vehiculo`(`id`,`nombre`) VALUES (2, "Bus");