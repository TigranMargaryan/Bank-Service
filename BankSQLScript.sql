-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema onlainBank
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema onlainBank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `onlainBank` DEFAULT CHARACTER SET utf8 ;
USE `onlainBank` ;

-- -----------------------------------------------------
-- Table `onlainBank`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlainBank`.`customer` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `adress` VARCHAR(45) NOT NULL,
  `update_date` DATETIME NOT NULL,
  `birthday` DATE NOT NULL,
  `phone` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlainBank`.`credit_card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlainBank`.`credit_card` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `limit` INT NULL,
  `expiry_date` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlainBank`.`account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlainBank`.`account` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `category` VARCHAR(45) NOT NULL,
  `balance` DOUBLE NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlainBank`.`customer_credit_card_account`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlainBank`.`customer_credit_card_account` (
  `customer_id` INT NOT NULL,
  `credit_card_id` INT NOT NULL,
  `account_id` INT NOT NULL,
  PRIMARY KEY (`customer_id`, `credit_card_id`, `account_id`),
  INDEX `fk_customer_has_credit_card_credit_card1_idx` (`credit_card_id` ASC) VISIBLE,
  INDEX `fk_customer_has_credit_card_customer_idx` (`customer_id` ASC) VISIBLE,
  INDEX `fk_customer_has_credit_card_account1_idx` (`account_id` ASC) VISIBLE,
  CONSTRAINT `fk_customer_has_credit_card_customer`
    FOREIGN KEY (`customer_id`)
    REFERENCES `onlainBank`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_has_credit_card_credit_card1`
    FOREIGN KEY (`credit_card_id`)
    REFERENCES `onlainBank`.`credit_card` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_has_credit_card_account1`
    FOREIGN KEY (`account_id`)
    REFERENCES `onlainBank`.`account` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlainBank`.`banker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlainBank`.`banker` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlainBank`.`branch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlainBank`.`branch` (
  `name` VARCHAR(45) NOT NULL,
  `assets` INT NOT NULL,
  `branch-city` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`name`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlainBank`.`customer_banker`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlainBank`.`customer_banker` (
  `customer_id` INT NOT NULL,
  `banker_id` INT NOT NULL,
  `branch_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`customer_id`, `banker_id`, `branch_name`),
  INDEX `fk_customer_has_banker_banker1_idx` (`banker_id` ASC) VISIBLE,
  INDEX `fk_customer_has_banker_customer1_idx` (`customer_id` ASC) VISIBLE,
  INDEX `fk_customer_has_banker_branch1_idx` (`branch_name` ASC) VISIBLE,
  CONSTRAINT `fk_customer_has_banker_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `onlainBank`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_has_banker_banker1`
    FOREIGN KEY (`banker_id`)
    REFERENCES `onlainBank`.`banker` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_has_banker_branch1`
    FOREIGN KEY (`branch_name`)
    REFERENCES `onlainBank`.`branch` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlainBank`.`loan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlainBank`.`loan` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `amount` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlainBank`.`loan_branch`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlainBank`.`loan_branch` (
  `loan_id` INT NOT NULL,
  `branch_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`loan_id`, `branch_name`),
  INDEX `fk_loan_has_branch_branch1_idx` (`branch_name` ASC) VISIBLE,
  INDEX `fk_loan_has_branch_loan1_idx` (`loan_id` ASC) VISIBLE,
  CONSTRAINT `fk_loan_has_branch_loan1`
    FOREIGN KEY (`loan_id`)
    REFERENCES `onlainBank`.`loan` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_loan_has_branch_branch1`
    FOREIGN KEY (`branch_name`)
    REFERENCES `onlainBank`.`branch` (`name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlainBank`.`customer_loan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlainBank`.`customer_loan` (
  `customer_id` INT NOT NULL,
  `loan_id` INT NOT NULL,
  PRIMARY KEY (`customer_id`, `loan_id`),
  INDEX `fk_customer_has_loan_loan1_idx` (`loan_id` ASC) VISIBLE,
  INDEX `fk_customer_has_loan_customer1_idx` (`customer_id` ASC) VISIBLE,
  CONSTRAINT `fk_customer_has_loan_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `onlainBank`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_has_loan_loan1`
    FOREIGN KEY (`loan_id`)
    REFERENCES `onlainBank`.`loan` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlainBank`.`water`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlainBank`.`water` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `debt` DOUBLE NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlainBank`.`gas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlainBank`.`gas` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `debt` DOUBLE NOT NULL,
  `date` DATETIME NOT NULL,
  `gas_service` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlainBank`.`electricity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlainBank`.`electricity` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `debt` DOUBLE NOT NULL,
  `date` DATETIME NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `onlainBank`.`customer_utility`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `onlainBank`.`customer_utility` (
  `customer_id` INT NOT NULL,
  `water_id` INT NOT NULL,
  `gas_id` INT NOT NULL,
  `electricity_id` INT NOT NULL,
  PRIMARY KEY (`customer_id`, `water_id`, `gas_id`, `electricity_id`),
  INDEX `fk_customer_has_water_water1_idx` (`water_id` ASC) VISIBLE,
  INDEX `fk_customer_has_water_customer1_idx` (`customer_id` ASC) VISIBLE,
  INDEX `fk_customer_has_water_gas1_idx` (`gas_id` ASC) VISIBLE,
  INDEX `fk_customer_has_water_electricity1_idx` (`electricity_id` ASC) VISIBLE,
  CONSTRAINT `fk_customer_has_water_customer1`
    FOREIGN KEY (`customer_id`)
    REFERENCES `onlainBank`.`customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_has_water_water1`
    FOREIGN KEY (`water_id`)
    REFERENCES `onlainBank`.`water` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_has_water_gas1`
    FOREIGN KEY (`gas_id`)
    REFERENCES `onlainBank`.`gas` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_customer_has_water_electricity1`
    FOREIGN KEY (`electricity_id`)
    REFERENCES `onlainBank`.`electricity` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
