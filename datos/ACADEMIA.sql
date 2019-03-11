-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `mydb` ;

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`ALUMNO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ALUMNO` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ALUMNO` (
  `DNI` INT NOT NULL,
  `NOMBRE` VARCHAR(45) NULL,
  `APELLIDO` VARCHAR(45) NULL,
  PRIMARY KEY (`DNI`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`PROFESOR`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`PROFESOR` ;

CREATE TABLE IF NOT EXISTS `mydb`.`PROFESOR` (
  `DNI` INT NOT NULL,
  `NOMBRE` VARCHAR(45) NULL,
  `APELLIDO` VARCHAR(45) NULL,
  PRIMARY KEY (`DNI`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ASIGNATURA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`ASIGNATURA` ;

CREATE TABLE IF NOT EXISTS `mydb`.`ASIGNATURA` (
  `COD_ASIGNATURA` VARCHAR(45) NOT NULL,
  `NOMBRE` VARCHAR(45) NULL,
  `NUM_CREDITOS` INT NOT NULL,
  PRIMARY KEY (`COD_ASIGNATURA`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`MATRICULA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`MATRICULA` ;

CREATE TABLE IF NOT EXISTS `mydb`.`MATRICULA` (
  `FK_DNI` INT NOT NULL,
  `FK_COD_ASIGNATURA` VARCHAR(45) NOT NULL,
  `NOTA` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`FK_DNI`, `FK_COD_ASIGNATURA`),
  INDEX `fk_ALUMNO_has_ASIGNATURA_ASIGNATURA1_idx` (`FK_COD_ASIGNATURA` ASC) VISIBLE,
  INDEX `fk_ALUMNO_has_ASIGNATURA_ALUMNO_idx` (`FK_DNI` ASC) VISIBLE,
  CONSTRAINT `fk_ALUMNO_has_ASIGNATURA_ALUMNO`
    FOREIGN KEY (`FK_DNI`)
    REFERENCES `mydb`.`ALUMNO` (`DNI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ALUMNO_has_ASIGNATURA_ASIGNATURA1`
    FOREIGN KEY (`FK_COD_ASIGNATURA`)
    REFERENCES `mydb`.`ASIGNATURA` (`COD_ASIGNATURA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`IMPARTE`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `mydb`.`IMPARTE` ;

CREATE TABLE IF NOT EXISTS `mydb`.`IMPARTE` (
  `PROFESOR_DNI` INT NOT NULL,
  `ASIGNATURA_COD_ASIGNATURA` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`PROFESOR_DNI`, `ASIGNATURA_COD_ASIGNATURA`),
  INDEX `fk_PROFESOR_has_ASIGNATURA_ASIGNATURA1_idx` (`ASIGNATURA_COD_ASIGNATURA` ASC) VISIBLE,
  INDEX `fk_PROFESOR_has_ASIGNATURA_PROFESOR1_idx` (`PROFESOR_DNI` ASC) VISIBLE,
  CONSTRAINT `fk_PROFESOR_has_ASIGNATURA_PROFESOR1`
    FOREIGN KEY (`PROFESOR_DNI`)
    REFERENCES `mydb`.`PROFESOR` (`DNI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PROFESOR_has_ASIGNATURA_ASIGNATURA1`
    FOREIGN KEY (`ASIGNATURA_COD_ASIGNATURA`)
    REFERENCES `mydb`.`ASIGNATURA` (`COD_ASIGNATURA`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
