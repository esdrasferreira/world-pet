-- liquibase formatted sql
-- changeset esdras:3
-- comment: Criacao da terceira versao

DROP TABLE IF EXISTS  usuario, pet;

-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema pet_world
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema pet_world
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema pet_world
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `pet_world` DEFAULT CHARACTER SET ascii ;
USE `pet_world` ;

-- -----------------------------------------------------
-- Table `pet_world`.`pet`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pet_world`.`pet` (
                                                 `id` INT NOT NULL AUTO_INCREMENT,
                                                 `nome` VARCHAR(45) NULL DEFAULT NULL,
                                                 `idade` DATE NULL DEFAULT NULL,
                                                 `raca` VARCHAR(45) NULL DEFAULT NULL,
                                                 `sexo` ENUM('masculino', 'feminino') NULL DEFAULT NULL,
                                                 `tipo` VARCHAR(45) NULL DEFAULT NULL,
                                                 PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = ascii;


-- -----------------------------------------------------
-- Table `pet_world`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pet_world`.`usuario` (
                                                     `id` INT NOT NULL AUTO_INCREMENT,
                                                     `nome` VARCHAR(45) NULL DEFAULT NULL,
                                                     `idade` DATE NULL DEFAULT NULL,
                                                     `sexo` ENUM('masculino', 'feminino', 'duvida') NULL DEFAULT NULL,
                                                     `endereco` VARCHAR(45) NULL DEFAULT NULL,
                                                     PRIMARY KEY (`id`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = ascii;


-- -----------------------------------------------------
-- Table `pet_world`.`usuarios_pets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `pet_world`.`usuarios_pets`
(
    usuario_id BIGINT,
    pet_id     BIGINT
)

