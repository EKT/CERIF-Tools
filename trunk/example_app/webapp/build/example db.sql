CREATE DATABASE  IF NOT EXISTS `example_app` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `example_app`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: example_app
-- ------------------------------------------------------
-- Server version	5.5.27-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cfcite`
--

DROP TABLE IF EXISTS `cfcite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfcite` (
  `cfCiteId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfCiteId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfcite_class`
--

DROP TABLE IF EXISTS `cfcite_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfcite_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCiteId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfCiteId` (`cfCiteId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKA2F92133DFB9C55A` (`cfClassId`),
  KEY `FKA2F92133E615308D` (`cfCiteId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfcite_medium`
--

DROP TABLE IF EXISTS `cfcite_medium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfcite_medium` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCiteId` bigint(20) NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfCiteId` (`cfCiteId`,`cfMediumId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKCCDA0F1A2D8C1F39` (`cfMediumId`),
  KEY `FKCCDA0F1ADFB9C55A` (`cfClassId`),
  KEY `FKCCDA0F1AE615308D` (`cfCiteId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfcitedescr`
--

DROP TABLE IF EXISTS `cfcitedescr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfcitedescr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfCiteId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfCiteId` (`cfCiteId`,`cfLangCode`,`cfTrans`),
  KEY `FKFB92DBC7189DA867` (`cfLangCode`),
  KEY `FKFB92DBC7E615308D` (`cfCiteId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfcitetitle`
--

DROP TABLE IF EXISTS `cfcitetitle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfcitetitle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfTitle` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfCiteId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfCiteId` (`cfCiteId`,`cfLangCode`,`cfTrans`),
  KEY `FKFC762A1E189DA867` (`cfLangCode`),
  KEY `FKFC762A1EE615308D` (`cfCiteId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfclass`
--

DROP TABLE IF EXISTS `cfclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfclass` (
  `cfClassId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime DEFAULT NULL,
  `cfStartDate` datetime DEFAULT NULL,
  `cfUri` varchar(255) DEFAULT NULL,
  `cfClassSchemeId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cfClassId`),
  KEY `FK26F9F2D559E8DC44` (`cfClassSchemeId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfclass_class`
--

DROP TABLE IF EXISTS `cfclass_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfclass_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  `cfClassId1` bigint(20) NOT NULL,
  `cfClassId2` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfClassId1` (`cfClassId1`,`cfClassId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK95CADB6EA79A91EB` (`cfClassId1`),
  KEY `FK95CADB6EDFB9C55A` (`cfClassId`),
  KEY `FK95CADB6EA79A91EC` (`cfClassId2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfclassdef`
--

DROP TABLE IF EXISTS `cfclassdef`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfclassdef` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDef` varchar(255) DEFAULT NULL,
  `cfDefSrc` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfClassSchemeId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfClassId` (`cfClassId`,`cfClassSchemeId`,`cfLangCode`,`cfTrans`),
  KEY `FKB8CAACF0DFB9C55A` (`cfClassId`),
  KEY `FKB8CAACF0189DA867` (`cfLangCode`),
  KEY `FKB8CAACF059E8DC44` (`cfClassSchemeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfclassdescr`
--

DROP TABLE IF EXISTS `cfclassdescr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfclassdescr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfDescrSrc` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfClassSchemeId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfClassId` (`cfClassId`,`cfClassSchemeId`,`cfLangCode`,`cfTrans`),
  KEY `FKB0D36E2CDFB9C55A` (`cfClassId`),
  KEY `FKB0D36E2C189DA867` (`cfLangCode`),
  KEY `FKB0D36E2C59E8DC44` (`cfClassSchemeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfclassex`
--

DROP TABLE IF EXISTS `cfclassex`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfclassex` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEx` varchar(255) DEFAULT NULL,
  `cfExSrc` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfClassSchemeId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfClassId` (`cfClassId`,`cfClassSchemeId`,`cfLangCode`,`cfTrans`),
  KEY `FK50489A68DFB9C55A` (`cfClassId`),
  KEY `FK50489A68189DA867` (`cfLangCode`),
  KEY `FK50489A6859E8DC44` (`cfClassSchemeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfclassscheme`
--

DROP TABLE IF EXISTS `cfclassscheme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfclassscheme` (
  `cfClassSchemeId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfClassSchemeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfclassscheme_classscheme`
--

DROP TABLE IF EXISTS `cfclassscheme_classscheme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfclassscheme_classscheme` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfClassSchemeId1` bigint(20) NOT NULL,
  `cfClassSchemeId2` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfClassSchemeId1` (`cfClassSchemeId1`,`cfClassSchemeId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK43604138DFB9C55A` (`cfClassId`),
  KEY `FK43604138913342B` (`cfClassSchemeId1`),
  KEY `FK43604138913342C` (`cfClassSchemeId2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfclassschemedescr`
--

DROP TABLE IF EXISTS `cfclassschemedescr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfclassschemedescr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfDescrSrc` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfClassSchemeId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfClassSchemeId` (`cfClassSchemeId`,`cfLangCode`,`cfTrans`),
  KEY `FK75087B47189DA867` (`cfLangCode`),
  KEY `FK75087B4759E8DC44` (`cfClassSchemeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfclassschemename`
--

DROP TABLE IF EXISTS `cfclassschemename`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfclassschemename` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfNameSrc` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfClassSchemeId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfClassSchemeId` (`cfClassSchemeId`,`cfLangCode`,`cfTrans`),
  KEY `FKF346D285189DA867` (`cfLangCode`),
  KEY `FKF346D28559E8DC44` (`cfClassSchemeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfclassterm`
--

DROP TABLE IF EXISTS `cfclassterm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfclassterm` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfRoleExpr` varchar(255) DEFAULT NULL,
  `cfRoleExprOpp` varchar(255) DEFAULT NULL,
  `cfTerm` varchar(255) DEFAULT NULL,
  `cfTermSrc` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfClassSchemeId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfClassId` (`cfClassId`,`cfClassSchemeId`,`cfLangCode`,`cfTrans`),
  KEY `FK609238E1DFB9C55A` (`cfClassId`),
  KEY `FK609238E1189DA867` (`cfLangCode`),
  KEY `FK609238E159E8DC44` (`cfClassSchemeId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfcountry`
--

DROP TABLE IF EXISTS `cfcountry`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfcountry` (
  `cfCountryCode` varchar(255) NOT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfCountryCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfcountry_class`
--

DROP TABLE IF EXISTS `cfcountry_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfcountry_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCountryCode` varchar(255) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfCountryCode` (`cfCountryCode`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK9CB787CCDFB9C55A` (`cfClassId`),
  KEY `FK9CB787CC100568E5` (`cfCountryCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfcountryname`
--

DROP TABLE IF EXISTS `cfcountryname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfcountryname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfCountryCode` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfCountryCode` (`cfCountryCode`,`cfLangCode`,`cfTrans`),
  KEY `FK58D79ADE189DA867` (`cfLangCode`),
  KEY `FK58D79ADE100568E5` (`cfCountryCode`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfcurrency`
--

DROP TABLE IF EXISTS `cfcurrency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfcurrency` (
  `cfCurrCode` varchar(5) NOT NULL,
  `cfNumCurrCode` varchar(3) DEFAULT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfcurrency_class`
--

DROP TABLE IF EXISTS `cfcurrency_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfcurrency_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfCurrCode` (`cfCurrCode`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKCBFCEAEDDFB9C55A` (`cfClassId`),
  KEY `FKCBFCEAED1D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfcurrencyentname`
--

DROP TABLE IF EXISTS `cfcurrencyentname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfcurrencyentname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEntName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfCurrCode` varchar(5) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfCurrCode` (`cfCurrCode`,`cfLangCode`,`cfTrans`),
  KEY `FK9E06A5E2189DA867` (`cfLangCode`),
  KEY `FK9E06A5E21D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfcurrencyname`
--

DROP TABLE IF EXISTS `cfcurrencyname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfcurrencyname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfCurrCode` varchar(5) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfCurrCode` (`cfCurrCode`,`cfLangCode`,`cfTrans`),
  KEY `FKA6AD523F189DA867` (`cfLangCode`),
  KEY `FKA6AD523F1D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfcv`
--

DROP TABLE IF EXISTS `cfcv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfcv` (
  `cfCVId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfCVDoc` longblob,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfCVId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfcv_class`
--

DROP TABLE IF EXISTS `cfcv_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfcv_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCVId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfCVId` (`cfCVId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK26F0BBEFDFB9C55A` (`cfClassId`),
  KEY `FK26F0BBEF7FDC2B95` (`cfCVId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdc`
--

DROP TABLE IF EXISTS `cfdc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdc` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCSchemeURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdcaudience`
--

DROP TABLE IF EXISTS `cfdcaudience`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdcaudience` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdccontributor`
--

DROP TABLE IF EXISTS `cfdccontributor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdccontributor` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdccoverage`
--

DROP TABLE IF EXISTS `cfdccoverage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdccoverage` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdccoveragespatial`
--

DROP TABLE IF EXISTS `cfdccoveragespatial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdccoveragespatial` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfFDCPrecision` varchar(255) DEFAULT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  `cfFDCXCoordinate` varchar(255) DEFAULT NULL,
  `cfFDCYCoordinate` varchar(255) DEFAULT NULL,
  `cfFDCZCoordinate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdccoveragetemporal`
--

DROP TABLE IF EXISTS `cfdccoveragetemporal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdccoveragetemporal` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfFDCEndDateTime` datetime DEFAULT NULL,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfFDCPrecision` varchar(255) DEFAULT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfFDCStartDateTime` datetime DEFAULT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdccreator`
--

DROP TABLE IF EXISTS `cfdccreator`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdccreator` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdcdate`
--

DROP TABLE IF EXISTS `cfdcdate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdcdate` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCDateBegin` datetime DEFAULT NULL,
  `cfDCDateEnd` datetime DEFAULT NULL,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdcdescription`
--

DROP TABLE IF EXISTS `cfdcdescription`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdcdescription` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdcformat`
--

DROP TABLE IF EXISTS `cfdcformat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdcformat` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdclanguage`
--

DROP TABLE IF EXISTS `cfdclanguage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdclanguage` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdcprovenance`
--

DROP TABLE IF EXISTS `cfdcprovenance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdcprovenance` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdcpublisher`
--

DROP TABLE IF EXISTS `cfdcpublisher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdcpublisher` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdcrelation`
--

DROP TABLE IF EXISTS `cfdcrelation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdcrelation` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCEndDate` datetime NOT NULL,
  `cfDCId1` bigint(20) DEFAULT NULL,
  `cfDCId2` bigint(20) NOT NULL,
  `cfDCLangTag` varchar(5) NOT NULL,
  `cfDCScheme1` varchar(255) NOT NULL,
  `cfDCScheme2` varchar(255) NOT NULL,
  `cfDCStartDate` datetime NOT NULL,
  `cfDCTrans` varchar(1) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCId2`,`cfDCScheme1`,`cfDCScheme2`,`cfDCLangTag`,`cfDCTrans`,`cfDCStartDate`,`cfDCEndDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdcresourceidentifier`
--

DROP TABLE IF EXISTS `cfdcresourceidentifier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdcresourceidentifier` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdcresourcetype`
--

DROP TABLE IF EXISTS `cfdcresourcetype`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdcresourcetype` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdcrightsholder`
--

DROP TABLE IF EXISTS `cfdcrightsholder`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdcrightsholder` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdcrightsmm`
--

DROP TABLE IF EXISTS `cfdcrightsmm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdcrightsmm` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdcrightsmmaccessrights`
--

DROP TABLE IF EXISTS `cfdcrightsmmaccessrights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdcrightsmmaccessrights` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdcrightsmmlicense`
--

DROP TABLE IF EXISTS `cfdcrightsmmlicense`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdcrightsmmlicense` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdcsource`
--

DROP TABLE IF EXISTS `cfdcsource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdcsource` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdcsubject`
--

DROP TABLE IF EXISTS `cfdcsubject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdcsubject` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfdctitle`
--

DROP TABLE IF EXISTS `cfdctitle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfdctitle` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  `cfDCType` varchar(255) DEFAULT NULL,
  `cfDCValue` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfeaddr`
--

DROP TABLE IF EXISTS `cfeaddr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfeaddr` (
  `cfEaddrId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfURI` varchar(255) DEFAULT NULL,
  `PAddrId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`cfEaddrId`),
  KEY `FK27029F532D7B41B4` (`PAddrId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfeaddr_class`
--

DROP TABLE IF EXISTS `cfeaddr_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfeaddr_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEAddrId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEAddrId` (`cfEAddrId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK28F3B16CDFB9C55A` (`cfClassId`),
  KEY `FK28F3B16CCCF995D5` (`cfEAddrId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfequip`
--

DROP TABLE IF EXISTS `cfequip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfequip` (
  `cfEquipId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAcro` varchar(255) DEFAULT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfequip_class`
--

DROP TABLE IF EXISTS `cfequip_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfequip_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEquipId` (`cfEquipId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK6CDDB026DFB9C55A` (`cfClassId`),
  KEY `FK6CDDB0267FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfequip_equip`
--

DROP TABLE IF EXISTS `cfequip_equip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfequip_equip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEquipId1` bigint(20) NOT NULL,
  `cfEquipId2` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEquipId1` (`cfEquipId1`,`cfEquipId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK6CFC6EDEDFB9C55A` (`cfClassId`),
  KEY `FK6CFC6EDECE128FF6` (`cfEquipId2`),
  KEY `FK6CFC6EDECE128FF5` (`cfEquipId1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfequip_event`
--

DROP TABLE IF EXISTS `cfequip_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfequip_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfEventId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`,`cfEquipId`),
  UNIQUE KEY `cfEquipId` (`cfEquipId`,`cfEventId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK6CFE7948DFB9C55A` (`cfClassId`),
  KEY `FK6CFE7948A03A58DB` (`cfEventId`),
  KEY `FK6CFE79487FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfequip_fund`
--

DROP TABLE IF EXISTS `cfequip_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfequip_fund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAmount` double DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEquipId` (`cfEquipId`,`cfFundId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK87A58E57DFB9C55A` (`cfClassId`),
  KEY `FK87A58E57B798AACF` (`cfFundId`),
  KEY `FK87A58E571D977764` (`cfCurrCode`),
  KEY `FK87A58E577FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfequip_indic`
--

DROP TABLE IF EXISTS `cfequip_indic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfequip_indic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEquipId` (`cfEquipId`,`cfIndicId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK6D332FE7DFB9C55A` (`cfClassId`),
  KEY `FK6D332FE760EF2FAF` (`cfIndicId`),
  KEY `FK6D332FE77FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfequip_meas`
--

DROP TABLE IF EXISTS `cfequip_meas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfequip_meas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEquipId` (`cfEquipId`,`cfMeasId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK87A87F5CDFB9C55A` (`cfClassId`),
  KEY `FK87A87F5C58267D3` (`cfMeasId`),
  KEY `FK87A87F5C7FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfequip_medium`
--

DROP TABLE IF EXISTS `cfequip_medium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfequip_medium` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEquipId` (`cfEquipId`,`cfMediumId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK3F875E872D8C1F39` (`cfMediumId`),
  KEY `FK3F875E87DFB9C55A` (`cfClassId`),
  KEY `FK3F875E877FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfequip_paddr`
--

DROP TABLE IF EXISTS `cfequip_paddr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfequip_paddr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfPAddrId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEquipId` (`cfEquipId`,`cfPAddrId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK6D815F2FDFB9C55A` (`cfClassId`),
  KEY `FK6D815F2FE7AA0FF1` (`cfPAddrId`),
  KEY `FK6D815F2F7FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfequip_srv`
--

DROP TABLE IF EXISTS `cfequip_srv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfequip_srv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEquipId` (`cfEquipId`,`cfSrvId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKA1479825DFB9C55A` (`cfClassId`),
  KEY `FKA1479825119BF1C2` (`cfSrvId`),
  KEY `FKA14798257FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfequipdescr`
--

DROP TABLE IF EXISTS `cfequipdescr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfequipdescr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEquipId` (`cfEquipId`,`cfLangCode`,`cfTrans`),
  KEY `FK86372274189DA867` (`cfLangCode`),
  KEY `FK863722747FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfequipkeyw`
--

DROP TABLE IF EXISTS `cfequipkeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfequipkeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEquipId` (`cfEquipId`,`cfLangCode`,`cfTrans`),
  KEY `FKA13EC525189DA867` (`cfLangCode`),
  KEY `FKA13EC5257FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfequipname`
--

DROP TABLE IF EXISTS `cfequipname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfequipname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEquipId` (`cfEquipId`,`cfLangCode`,`cfTrans`),
  KEY `FKA14011B8189DA867` (`cfLangCode`),
  KEY `FKA14011B87FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfevent`
--

DROP TABLE IF EXISTS `cfevent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfevent` (
  `cfEventId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfCityTown` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime DEFAULT NULL,
  `cfFeeOrFree` varchar(255) NOT NULL,
  `cfStartDate` datetime DEFAULT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  `cfCountryCode` varchar(255) NOT NULL,
  PRIMARY KEY (`cfEventId`),
  KEY `FK271ABBF7100568E5` (`cfCountryCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfevent_class`
--

DROP TABLE IF EXISTS `cfevent_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfevent_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEventId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEventId` (`cfEventId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKC904C310DFB9C55A` (`cfClassId`),
  KEY `FKC904C310A03A58DB` (`cfEventId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfevent_event`
--

DROP TABLE IF EXISTS `cfevent_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfevent_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEventId1` bigint(20) NOT NULL,
  `cfEventId2` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEventId1` (`cfEventId1`,`cfEventId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKC9258C32DFB9C55A` (`cfClassId`),
  KEY `FKC9258C32D4562869` (`cfEventId2`),
  KEY `FKC9258C32D4562868` (`cfEventId1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfevent_fund`
--

DROP TABLE IF EXISTS `cfevent_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfevent_fund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAmount` double DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfEventId` bigint(20) NOT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEventId` (`cfEventId`,`cfFundId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKFE3B762DDFB9C55A` (`cfClassId`),
  KEY `FKFE3B762DB798AACF` (`cfFundId`),
  KEY `FKFE3B762DA03A58DB` (`cfEventId`),
  KEY `FKFE3B762D1D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfevent_indic`
--

DROP TABLE IF EXISTS `cfevent_indic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfevent_indic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEventId` bigint(20) NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEventId` (`cfEventId`,`cfIndicId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKC95A42D1DFB9C55A` (`cfClassId`),
  KEY `FKC95A42D160EF2FAF` (`cfIndicId`),
  KEY `FKC95A42D1A03A58DB` (`cfEventId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfevent_meas`
--

DROP TABLE IF EXISTS `cfevent_meas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfevent_meas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEventId` bigint(20) NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEventId` (`cfEventId`,`cfMeasId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKFE3E6732DFB9C55A` (`cfClassId`),
  KEY `FKFE3E6732A03A58DB` (`cfEventId`),
  KEY `FKFE3E673258267D3` (`cfMeasId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfevent_medium`
--

DROP TABLE IF EXISTS `cfevent_medium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfevent_medium` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEventId` bigint(20) NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEventId` (`cfEventId`,`cfMediumId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK6842A8DD2D8C1F39` (`cfMediumId`),
  KEY `FK6842A8DDDFB9C55A` (`cfClassId`),
  KEY `FK6842A8DDA03A58DB` (`cfEventId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfeventdescr`
--

DROP TABLE IF EXISTS `cfeventdescr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfeventdescr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfEventId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEventId` (`cfEventId`,`cfLangCode`,`cfTrans`),
  KEY `FKFCCD0A4A189DA867` (`cfLangCode`),
  KEY `FKFCCD0A4AA03A58DB` (`cfEventId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfeventkeyw`
--

DROP TABLE IF EXISTS `cfeventkeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfeventkeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfEventId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEventId` (`cfEventId`,`cfLangCode`,`cfTrans`),
  KEY `FK63018A8F189DA867` (`cfLangCode`),
  KEY `FK63018A8FA03A58DB` (`cfEventId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfeventname`
--

DROP TABLE IF EXISTS `cfeventname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfeventname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfEventId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfEventId` (`cfEventId`,`cfLangCode`,`cfTrans`),
  KEY `FK6302D722189DA867` (`cfLangCode`),
  KEY `FK6302D722A03A58DB` (`cfEventId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfexpskills`
--

DROP TABLE IF EXISTS `cfexpskills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfexpskills` (
  `cfExpSkillsId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfExpSkillsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfexpskills_class`
--

DROP TABLE IF EXISTS `cfexpskills_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfexpskills_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfExpSkillsId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfExpSkillsId` (`cfExpSkillsId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK38D476F5DFB9C55A` (`cfClassId`),
  KEY `FK38D476F51E5DC530` (`cfExpSkillsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfexpskillsdescr`
--

DROP TABLE IF EXISTS `cfexpskillsdescr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfexpskillsdescr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfExpSkillsId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfExpSkillsId` (`cfExpSkillsId`,`cfLangCode`,`cfTrans`),
  KEY `FK31F4C5C5189DA867` (`cfLangCode`),
  KEY `FK31F4C5C51E5DC530` (`cfExpSkillsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfexpskillskeyw`
--

DROP TABLE IF EXISTS `cfexpskillskeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfexpskillskeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfExpSkillsId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK9E86F3B4189DA867` (`cfLangCode`),
  KEY `FK9E86F3B41E5DC530` (`cfExpSkillsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfexpskillsname`
--

DROP TABLE IF EXISTS `cfexpskillsname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfexpskillsname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfExpSkillsId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfExpSkillsId` (`cfExpSkillsId`,`cfLangCode`,`cfTrans`),
  KEY `FK9E884047189DA867` (`cfLangCode`),
  KEY `FK9E8840471E5DC530` (`cfExpSkillsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffacil`
--

DROP TABLE IF EXISTS `cffacil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffacil` (
  `cfFacilId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAcro` varchar(255) DEFAULT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfFacilId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffacil_class`
--

DROP TABLE IF EXISTS `cffacil_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffacil_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFacilId` (`cfFacilId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK7CC295E1DFB9C55A` (`cfClassId`),
  KEY `FK7CC295E15C15A0E8` (`cfFacilId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffacil_equip`
--

DROP TABLE IF EXISTS `cffacil_equip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffacil_equip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFacilId` (`cfFacilId`,`cfEquipId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK7CE15499DFB9C55A` (`cfClassId`),
  KEY `FK7CE154995C15A0E8` (`cfFacilId`),
  KEY `FK7CE154997FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffacil_event`
--

DROP TABLE IF EXISTS `cffacil_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffacil_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEventId` bigint(20) NOT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFacilId` (`cfFacilId`,`cfEventId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK7CE35F03DFB9C55A` (`cfClassId`),
  KEY `FK7CE35F03A03A58DB` (`cfEventId`),
  KEY `FK7CE35F035C15A0E8` (`cfFacilId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffacil_facil`
--

DROP TABLE IF EXISTS `cffacil_facil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffacil_facil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfFacilId1` bigint(20) NOT NULL,
  `cfFacilId2` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFacilId1` (`cfFacilId1`,`cfFacilId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK7CE7E2948C8A13F4` (`cfFacilId2`),
  KEY `FK7CE7E294DFB9C55A` (`cfClassId`),
  KEY `FK7CE7E2948C8A13F3` (`cfFacilId1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffacil_fund`
--

DROP TABLE IF EXISTS `cffacil_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffacil_fund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAmount` double DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFacilId` (`cfFacilId`,`cfFundId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKE2FF853CDFB9C55A` (`cfClassId`),
  KEY `FKE2FF853CB798AACF` (`cfFundId`),
  KEY `FKE2FF853C5C15A0E8` (`cfFacilId`),
  KEY `FKE2FF853C1D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffacil_indic`
--

DROP TABLE IF EXISTS `cffacil_indic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffacil_indic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFacilId` (`cfFacilId`,`cfIndicId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK7D1815A2DFB9C55A` (`cfClassId`),
  KEY `FK7D1815A260EF2FAF` (`cfIndicId`),
  KEY `FK7D1815A25C15A0E8` (`cfFacilId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffacil_meas`
--

DROP TABLE IF EXISTS `cffacil_meas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffacil_meas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFacilId` (`cfFacilId`,`cfMeasId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKE3027641DFB9C55A` (`cfClassId`),
  KEY `FKE30276415C15A0E8` (`cfFacilId`),
  KEY `FKE302764158267D3` (`cfMeasId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffacil_medium`
--

DROP TABLE IF EXISTS `cffacil_medium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffacil_medium` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFacilId` (`cfFacilId`,`cfMediumId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK2C3F302C2D8C1F39` (`cfMediumId`),
  KEY `FK2C3F302CDFB9C55A` (`cfClassId`),
  KEY `FK2C3F302C5C15A0E8` (`cfFacilId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffacil_paddr`
--

DROP TABLE IF EXISTS `cffacil_paddr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffacil_paddr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfPAddrId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFacilId` (`cfFacilId`,`cfPAddrId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK7D6644EADFB9C55A` (`cfClassId`),
  KEY `FK7D6644EAE7AA0FF1` (`cfPAddrId`),
  KEY `FK7D6644EA5C15A0E8` (`cfFacilId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffacil_srv`
--

DROP TABLE IF EXISTS `cffacil_srv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffacil_srv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFacilId` (`cfFacilId`,`cfSrvId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKFF10B0A0DFB9C55A` (`cfClassId`),
  KEY `FKFF10B0A0119BF1C2` (`cfSrvId`),
  KEY `FKFF10B0A05C15A0E8` (`cfFacilId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffacildescr`
--

DROP TABLE IF EXISTS `cffacildescr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffacildescr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFacilId` (`cfFacilId`,`cfLangCode`,`cfTrans`),
  KEY `FKE1911959189DA867` (`cfLangCode`),
  KEY `FKE19119595C15A0E8` (`cfFacilId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffacilkeyw`
--

DROP TABLE IF EXISTS `cffacilkeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffacilkeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFacilId` (`cfFacilId`,`cfLangCode`,`cfTrans`),
  KEY `FKFF07DDA0189DA867` (`cfLangCode`),
  KEY `FKFF07DDA05C15A0E8` (`cfFacilId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffacilname`
--

DROP TABLE IF EXISTS `cffacilname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffacilname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFacilId` (`cfFacilId`,`cfLangCode`,`cfTrans`),
  KEY `FKFF092A33189DA867` (`cfLangCode`),
  KEY `FKFF092A335C15A0E8` (`cfFacilId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffdcrightsmmpricing`
--

DROP TABLE IF EXISTS `cffdcrightsmmpricing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffdcrightsmmpricing` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfFDCPriceConstraint` varchar(255) DEFAULT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffdcrightsmmprivacy`
--

DROP TABLE IF EXISTS `cffdcrightsmmprivacy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffdcrightsmmprivacy` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfFDCPrivacyConstraint` varchar(255) DEFAULT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffdcrightsmmrights`
--

DROP TABLE IF EXISTS `cffdcrightsmmrights`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffdcrightsmmrights` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfFDCRightsConstraint` varchar(255) DEFAULT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffdcsecuritymmsecurity`
--

DROP TABLE IF EXISTS `cffdcsecuritymmsecurity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffdcsecuritymmsecurity` (
  `cfDCId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDCLangTag` varchar(255) NOT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfFDCSecurityConstraint` varchar(255) DEFAULT NULL,
  `cfDCTrans` varchar(255) NOT NULL,
  PRIMARY KEY (`cfDCId`),
  UNIQUE KEY `cfDCId` (`cfDCId`,`cfDCScheme`,`cfDCLangTag`,`cfDCTrans`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffedid`
--

DROP TABLE IF EXISTS `cffedid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffedid` (
  `cfFedIdId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime DEFAULT NULL,
  `cfFedId` varchar(255) DEFAULT NULL,
  `cfInstId` bigint(20) DEFAULT NULL,
  `cfStartDate` datetime DEFAULT NULL,
  `cfClassSchemeId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`cfFedIdId`),
  KEY `FK272110DDDFB9C55A` (`cfClassId`),
  KEY `FK272110DD59E8DC44` (`cfClassSchemeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffedid_class`
--

DROP TABLE IF EXISTS `cffedid_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffedid_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfFedIdId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFedIdId` (`cfFedIdId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK3ED55376DFB9C55A` (`cfClassId`),
  KEY `FK3ED553766EC03D14` (`cfFedIdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffund`
--

DROP TABLE IF EXISTS `cffund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffund` (
  `cfFundId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAcro` varchar(255) DEFAULT NULL,
  `cfAmount` double DEFAULT NULL,
  `cfEndDate` datetime DEFAULT NULL,
  `cfStartDate` datetime DEFAULT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`cfFundId`),
  KEY `FKAEAEB9C81D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffund_class`
--

DROP TABLE IF EXISTS `cffund_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffund_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFundId` (`cfFundId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKCEDD6021DFB9C55A` (`cfClassId`),
  KEY `FKCEDD6021B798AACF` (`cfFundId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffund_fund`
--

DROP TABLE IF EXISTS `cffund_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffund_fund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfFundId1` bigint(20) NOT NULL,
  `cfFundId2` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFundId1` (`cfFundId1`,`cfFundId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK594272FCDFB9C55A` (`cfClassId`),
  KEY `FK594272FC5EE4B1DA` (`cfFundId1`),
  KEY `FK594272FC5EE4B1DB` (`cfFundId2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffund_indic`
--

DROP TABLE IF EXISTS `cffund_indic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffund_indic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAmount` double DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFundId` (`cfFundId`,`cfIndicId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKCF32DFE2DFB9C55A` (`cfClassId`),
  KEY `FKCF32DFE260EF2FAF` (`cfIndicId`),
  KEY `FKCF32DFE2B798AACF` (`cfFundId`),
  KEY `FKCF32DFE21D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffund_meas`
--

DROP TABLE IF EXISTS `cffund_meas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffund_meas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAmount` double DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFundId` (`cfFundId`,`cfMeasId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK59456401DFB9C55A` (`cfClassId`),
  KEY `FK59456401B798AACF` (`cfFundId`),
  KEY `FK5945640158267D3` (`cfMeasId`),
  KEY `FK594564011D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffunddescr`
--

DROP TABLE IF EXISTS `cffunddescr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffunddescr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFundId` (`cfFundId`,`cfLangCode`,`cfTrans`),
  KEY `FK57D40719189DA867` (`cfLangCode`),
  KEY `FK57D40719B798AACF` (`cfFundId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffundkeyw`
--

DROP TABLE IF EXISTS `cffundkeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffundkeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFundId` (`cfFundId`,`cfLangCode`,`cfTrans`),
  KEY `FKE1D037E0189DA867` (`cfLangCode`),
  KEY `FKE1D037E0B798AACF` (`cfFundId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cffundname`
--

DROP TABLE IF EXISTS `cffundname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cffundname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfFundId` (`cfFundId`,`cfLangCode`,`cfTrans`),
  KEY `FKE1D18473189DA867` (`cfLangCode`),
  KEY `FKE1D18473B798AACF` (`cfFundId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfgeobbox`
--

DROP TABLE IF EXISTS `cfgeobbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfgeobbox` (
  `cfGeoBBoxId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEBLong` varchar(255) DEFAULT NULL,
  `cfMaxElev` varchar(255) DEFAULT NULL,
  `cfMinELev` varchar(255) DEFAULT NULL,
  `cfNBLat` varchar(255) DEFAULT NULL,
  `cfSBLat` varchar(255) DEFAULT NULL,
  `cfWBLong` varchar(255) DEFAULT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfGeoBBoxId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfgeobbox_class`
--

DROP TABLE IF EXISTS `cfgeobbox_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfgeobbox_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfGeoBBoxId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfGeoBBoxId` (`cfGeoBBoxId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK2DF01A3089489F1` (`cfGeoBBoxId`),
  KEY `FK2DF01A30DFB9C55A` (`cfClassId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfgeobbox_geobbox`
--

DROP TABLE IF EXISTS `cfgeobbox_geobbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfgeobbox_geobbox` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfGeoBBoxId1` bigint(20) NOT NULL,
  `cfGeoBBoxId2` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfGeoBBoxId1` (`cfGeoBBoxId1`,`cfGeoBBoxId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK3AA7A7B2DFB9C55A` (`cfClassId`),
  KEY `FK3AA7A7B2EC8BF73E` (`cfGeoBBoxId1`),
  KEY `FK3AA7A7B2EC8BF73F` (`cfGeoBBoxId2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfgeobboxdesc`
--

DROP TABLE IF EXISTS `cfgeobboxdesc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfgeobboxdesc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfGeoBBoxId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfGeoBBoxId` (`cfGeoBBoxId`,`cfLangCode`,`cfTrans`),
  KEY `FK7314FA4889489F1` (`cfGeoBBoxId`),
  KEY `FK7314FA48189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfgeobboxkeyw`
--

DROP TABLE IF EXISTS `cfgeobboxkeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfgeobboxkeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfGeoBBoxId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfGeoBBoxId` (`cfGeoBBoxId`,`cfLangCode`,`cfTrans`),
  KEY `FK731829AF89489F1` (`cfGeoBBoxId`),
  KEY `FK731829AF189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfgeobboxname`
--

DROP TABLE IF EXISTS `cfgeobboxname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfgeobboxname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfGeoBBoxId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfGeoBBoxId` (`cfGeoBBoxId`,`cfLangCode`,`cfTrans`),
  KEY `FK7319764289489F1` (`cfGeoBBoxId`),
  KEY `FK73197642189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfindic`
--

DROP TABLE IF EXISTS `cfindic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfindic` (
  `cfIndicId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfIndicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfindic_class`
--

DROP TABLE IF EXISTS `cfindic_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfindic_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfIndicId` (`cfIndicId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK5B57C66FDFB9C55A` (`cfClassId`),
  KEY `FK5B57C66F60EF2FAF` (`cfIndicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfindic_indic`
--

DROP TABLE IF EXISTS `cfindic_indic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfindic_indic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfIndicId1` bigint(20) NOT NULL,
  `cfIndicId2` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfIndicId1` (`cfIndicId1`,`cfIndicId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK5BAD4630DFB9C55A` (`cfClassId`),
  KEY `FK5BAD4630C579455E` (`cfIndicId1`),
  KEY `FK5BAD4630C579455F` (`cfIndicId2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfindic_meas`
--

DROP TABLE IF EXISTS `cfindic_meas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfindic_meas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfIndicId` (`cfIndicId`,`cfMeasId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK9FDDFBF3DFB9C55A` (`cfClassId`),
  KEY `FK9FDDFBF360EF2FAF` (`cfIndicId`),
  KEY `FK9FDDFBF358267D3` (`cfMeasId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfindicdescr`
--

DROP TABLE IF EXISTS `cfindicdescr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfindicdescr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfIndicId` (`cfIndicId`,`cfLangCode`,`cfTrans`),
  KEY `FK9E6C9F0B189DA867` (`cfLangCode`),
  KEY `FK9E6C9F0B60EF2FAF` (`cfIndicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfindickeyw`
--

DROP TABLE IF EXISTS `cfindickeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfindickeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfIndicId` (`cfIndicId`,`cfLangCode`,`cfTrans`),
  KEY `FK36ABD9AE189DA867` (`cfLangCode`),
  KEY `FK36ABD9AE60EF2FAF` (`cfIndicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfindicname`
--

DROP TABLE IF EXISTS `cfindicname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfindicname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfIndicId` (`cfIndicId`,`cfLangCode`,`cfTrans`),
  KEY `FK36AD2641189DA867` (`cfLangCode`),
  KEY `FK36AD264160EF2FAF` (`cfIndicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cflang`
--

DROP TABLE IF EXISTS `cflang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cflang` (
  `cfLangCode` varchar(255) NOT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cflang_class`
--

DROP TABLE IF EXISTS `cflang_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cflang_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfLangCode` (`cfLangCode`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK91F00C8ADFB9C55A` (`cfClassId`),
  KEY `FK91F00C8A189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cflangname`
--

DROP TABLE IF EXISTS `cflangname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cflangname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfLangCodeOfLangName` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfLangCodeOfLangName` (`cfLangCodeOfLangName`,`cfLangCode`,`cfTrans`),
  KEY `FK2F46371C189DA867` (`cfLangCode`),
  KEY `FK2F46371C269E1F37` (`cfLangCodeOfLangName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmeas`
--

DROP TABLE IF EXISTS `cfmeas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmeas` (
  `cfMeasId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfCountFloatPChange` double DEFAULT NULL,
  `cfCountIntChange` int(11) DEFAULT NULL,
  `cfCountInt` int(11) DEFAULT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  `cfValFloatP` double DEFAULT NULL,
  `cfValJudgeNum` double DEFAULT NULL,
  `cfValJudgeNumChange` double DEFAULT NULL,
  `cfValJudgeText` varchar(255) DEFAULT NULL,
  `cfValJudgeTextChange` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfMeasId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmeas_class`
--

DROP TABLE IF EXISTS `cfmeas_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmeas_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMeasId` (`cfMeasId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKBA6B966DFB9C55A` (`cfClassId`),
  KEY `FKBA6B96658267D3` (`cfMeasId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmeas_meas`
--

DROP TABLE IF EXISTS `cfmeas_meas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmeas_meas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMeasId1` bigint(20) NOT NULL,
  `cfMeasId2` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMeasId1` (`cfMeasId1`,`cfMeasId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK52F94E1CDFB9C55A` (`cfClassId`),
  KEY `FK52F94E1CF8115FF5` (`cfMeasId2`),
  KEY `FK52F94E1CF8115FF4` (`cfMeasId1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmeasdescr`
--

DROP TABLE IF EXISTS `cfmeasdescr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmeasdescr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMeasId` (`cfMeasId`,`cfLangCode`,`cfTrans`),
  KEY `FK5187F134189DA867` (`cfLangCode`),
  KEY `FK5187F13458267D3` (`cfMeasId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmeaskeyw`
--

DROP TABLE IF EXISTS `cfmeaskeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmeaskeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMeasId` (`cfMeasId`,`cfLangCode`,`cfTrans`),
  KEY `FK55391E65189DA867` (`cfLangCode`),
  KEY `FK55391E6558267D3` (`cfMeasId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmeasname`
--

DROP TABLE IF EXISTS `cfmeasname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmeasname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMeasId` (`cfMeasId`,`cfLangCode`,`cfTrans`),
  KEY `FK553A6AF8189DA867` (`cfLangCode`),
  KEY `FK553A6AF858267D3` (`cfMeasId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmedium`
--

DROP TABLE IF EXISTS `cfmedium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmedium` (
  `cfMediumId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfMediumCreationDate` varchar(255) DEFAULT NULL,
  `cfMimeType` varchar(255) DEFAULT NULL,
  `cfSize` double DEFAULT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfMediumId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmedium_class`
--

DROP TABLE IF EXISTS `cfmedium_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmedium_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMediumId` (`cfMediumId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK525464112D8C1F39` (`cfMediumId`),
  KEY `FK52546411DFB9C55A` (`cfClassId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmedium_fund`
--

DROP TABLE IF EXISTS `cfmedium_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmedium_fund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAmount` double DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMediumId` (`cfMediumId`,`cfFundId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKE9E3310C2D8C1F39` (`cfMediumId`),
  KEY `FKE9E3310CDFB9C55A` (`cfClassId`),
  KEY `FKE9E3310CB798AACF` (`cfFundId`),
  KEY `FKE9E3310C1D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmedium_indic`
--

DROP TABLE IF EXISTS `cfmedium_indic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmedium_indic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMediumId` (`cfMediumId`,`cfIndicId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK52A9E3D22D8C1F39` (`cfMediumId`),
  KEY `FK52A9E3D2DFB9C55A` (`cfClassId`),
  KEY `FK52A9E3D260EF2FAF` (`cfIndicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmedium_meas`
--

DROP TABLE IF EXISTS `cfmedium_meas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmedium_meas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMediumId` (`cfMediumId`,`cfMeasId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKE9E622112D8C1F39` (`cfMediumId`),
  KEY `FKE9E62211DFB9C55A` (`cfClassId`),
  KEY `FKE9E6221158267D3` (`cfMeasId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmedium_medium`
--

DROP TABLE IF EXISTS `cfmedium_medium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmedium_medium` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMediumId1` bigint(20) NOT NULL,
  `cfMediumId2` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMediumId1` (`cfMediumId1`,`cfMediumId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK8E727FC41F69C64` (`cfMediumId1`),
  KEY `FK8E727FCDFB9C55A` (`cfClassId`),
  KEY `FK8E727FC41F69C65` (`cfMediumId2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmediumdescr`
--

DROP TABLE IF EXISTS `cfmediumdescr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmediumdescr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMediumId` (`cfMediumId`,`cfLangCode`,`cfTrans`),
  KEY `FKE874C5292D8C1F39` (`cfMediumId`),
  KEY `FKE874C529189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmediumkeyw`
--

DROP TABLE IF EXISTS `cfmediumkeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmediumkeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMediumId` (`cfMediumId`,`cfLangCode`,`cfTrans`),
  KEY `FK5A1777D02D8C1F39` (`cfMediumId`),
  KEY `FK5A1777D0189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmediumtitle`
--

DROP TABLE IF EXISTS `cfmediumtitle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmediumtitle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfTitle` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMediumId` (`cfMediumId`,`cfLangCode`,`cfTrans`),
  KEY `FKE95813802D8C1F39` (`cfMediumId`),
  KEY `FKE9581380189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmetrics`
--

DROP TABLE IF EXISTS `cfmetrics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmetrics` (
  `cfCMetricsId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfCMetricsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmetrics_class`
--

DROP TABLE IF EXISTS `cfmetrics_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmetrics_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMetricsId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMetricsId` (`cfMetricsId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK2A9E9B39DFB9C55A` (`cfClassId`),
  KEY `FK2A9E9B39E1EEFBED` (`cfMetricsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmetricsdescr`
--

DROP TABLE IF EXISTS `cfmetricsdescr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmetricsdescr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfMetricsId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMetricsId` (`cfMetricsId`,`cfLangCode`,`cfTrans`),
  KEY `FKFFF30901189DA867` (`cfLangCode`),
  KEY `FKFFF30901E1EEFBED` (`cfMetricsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmetricskeyw`
--

DROP TABLE IF EXISTS `cfmetricskeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmetricskeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfMetricsId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMetricsId` (`cfMetricsId`,`cfLangCode`,`cfTrans`),
  KEY `FK4A5558F8189DA867` (`cfLangCode`),
  KEY `FK4A5558F8E1EEFBED` (`cfMetricsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfmetricsname`
--

DROP TABLE IF EXISTS `cfmetricsname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfmetricsname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfMetricsId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfMetricsId` (`cfMetricsId`,`cfLangCode`,`cfTrans`),
  KEY `FK4A56A58B189DA867` (`cfLangCode`),
  KEY `FK4A56A58BE1EEFBED` (`cfMetricsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit`
--

DROP TABLE IF EXISTS `cforgunit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit` (
  `cfOrgUnitId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAcro` varchar(255) DEFAULT NULL,
  `cfHeadcount` int(11) DEFAULT NULL,
  `cfTurn` double DEFAULT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`cfOrgUnitId`),
  KEY `FKD59750A51D977764` (`cfCurrCode`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_class`
--

DROP TABLE IF EXISTS `cforgunit_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKB93E9D3EDFB9C55A` (`cfClassId`),
  KEY `FKB93E9D3E19AE44D2` (`cfOrgUnitId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_dc`
--

DROP TABLE IF EXISTS `cforgunit_dc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_dc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfDCId` bigint(20) NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfDCId`,`cfDCScheme`,`cfStartDate`,`cfEndDate`),
  KEY `FKD3B31E5970540C76` (`cfDCId`),
  KEY `FKD3B31E5919AE44D2` (`cfOrgUnitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_eaddr`
--

DROP TABLE IF EXISTS `cforgunit_eaddr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_eaddr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEAddrId` bigint(20) NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfEAddrId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKB94749BCDFB9C55A` (`cfClassId`),
  KEY `FKB94749BCCCF995D5` (`cfEAddrId`),
  KEY `FKB94749BC19AE44D2` (`cfOrgUnitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_equip`
--

DROP TABLE IF EXISTS `cforgunit_equip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_equip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAvailability` varchar(255) DEFAULT NULL,
  `cfConditions` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfPrice` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfEquipId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKB95D5BF6DFB9C55A` (`cfClassId`),
  KEY `FKB95D5BF619AE44D2` (`cfOrgUnitId`),
  KEY `FKB95D5BF61D977764` (`cfCurrCode`),
  KEY `FKB95D5BF67FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_event`
--

DROP TABLE IF EXISTS `cforgunit_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEventId` bigint(20) NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfEventId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKB95F6660DFB9C55A` (`cfClassId`),
  KEY `FKB95F6660A03A58DB` (`cfEventId`),
  KEY `FKB95F666019AE44D2` (`cfOrgUnitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_expskills`
--

DROP TABLE IF EXISTS `cforgunit_expskills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_expskills` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAvailability` varchar(255) DEFAULT NULL,
  `cfConditions` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfPrice` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfExpSkillsId` bigint(20) NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfExpSkillsId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK7BCBCD85DFB9C55A` (`cfClassId`),
  KEY `FK7BCBCD8519AE44D2` (`cfOrgUnitId`),
  KEY `FK7BCBCD851E5DC530` (`cfExpSkillsId`),
  KEY `FK7BCBCD851D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_facil`
--

DROP TABLE IF EXISTS `cforgunit_facil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_facil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAvailability` varchar(255) DEFAULT NULL,
  `cfConditions` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfPrice` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfFacilId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKB963E9F1DFB9C55A` (`cfClassId`),
  KEY `FKB963E9F15C15A0E8` (`cfFacilId`),
  KEY `FKB963E9F119AE44D2` (`cfOrgUnitId`),
  KEY `FKB963E9F11D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_fund`
--

DROP TABLE IF EXISTS `cforgunit_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_fund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAmount` double DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfFundId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKB3669E3FDFB9C55A` (`cfClassId`),
  KEY `FKB3669E3FB798AACF` (`cfFundId`),
  KEY `FKB3669E3F19AE44D2` (`cfOrgUnitId`),
  KEY `FKB3669E3F1D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_indic`
--

DROP TABLE IF EXISTS `cforgunit_indic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_indic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfIndicId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKB9941CFFDFB9C55A` (`cfClassId`),
  KEY `FKB9941CFF60EF2FAF` (`cfIndicId`),
  KEY `FKB9941CFF19AE44D2` (`cfOrgUnitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_meas`
--

DROP TABLE IF EXISTS `cforgunit_meas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_meas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfMeasId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKB3698F44DFB9C55A` (`cfClassId`),
  KEY `FKB3698F4458267D3` (`cfMeasId`),
  KEY `FKB3698F4419AE44D2` (`cfOrgUnitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_medium`
--

DROP TABLE IF EXISTS `cforgunit_medium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_medium` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfMediumId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK7F44146F2D8C1F39` (`cfMediumId`),
  KEY `FK7F44146FDFB9C55A` (`cfClassId`),
  KEY `FK7F44146F19AE44D2` (`cfOrgUnitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_orgunit`
--

DROP TABLE IF EXISTS `cforgunit_orgunit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_orgunit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfOrgUnitId1` bigint(20) NOT NULL,
  `cfOrgUnitId2` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId1` (`cfOrgUnitId1`,`cfOrgUnitId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKE95B04CEDFB9C55A` (`cfClassId`),
  KEY `FKE95B04CE87285C04` (`cfOrgUnitId2`),
  KEY `FKE95B04CE87285C03` (`cfOrgUnitId1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_paddr`
--

DROP TABLE IF EXISTS `cforgunit_paddr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_paddr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfPAddrId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfPAddrId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKB9E24C47DFB9C55A` (`cfClassId`),
  KEY `FKB9E24C47E7AA0FF1` (`cfPAddrId`),
  KEY `FKB9E24C4719AE44D2` (`cfOrgUnitId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_prize`
--

DROP TABLE IF EXISTS `cforgunit_prize`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_prize` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfFraction` double DEFAULT NULL,
  `cfPrizeDate` datetime NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfPrizeId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfPrizeId`,`cfClassId`,`cfPrizeDate`),
  KEY `FKB9F8A7D8DFB9C55A` (`cfClassId`),
  KEY `FKB9F8A7D8E0225DCB` (`cfPrizeId`),
  KEY `FKB9F8A7D819AE44D2` (`cfOrgUnitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_respat`
--

DROP TABLE IF EXISTS `cforgunit_respat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_respat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfResPatId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfResPatId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK87D2C0DDDFB9C55A` (`cfClassId`),
  KEY `FK87D2C0DD3B234AEE` (`cfResPatId`),
  KEY `FK87D2C0DD19AE44D2` (`cfOrgUnitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_resprod`
--

DROP TABLE IF EXISTS `cforgunit_resprod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_resprod` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAvailability` varchar(255) DEFAULT NULL,
  `cfConditions` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfPrice` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfResProdId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK72859A5DDFB9C55A` (`cfClassId`),
  KEY `FK72859A5D19AE44D2` (`cfOrgUnitId`),
  KEY `FK72859A5D1D977764` (`cfCurrCode`),
  KEY `FK72859A5D46EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_respubl`
--

DROP TABLE IF EXISTS `cforgunit_respubl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_respubl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfCopyright` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfResPublId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK7285A415DFB9C55A` (`cfClassId`),
  KEY `FK7285A415973D478E` (`cfResPublId`),
  KEY `FK7285A41519AE44D2` (`cfOrgUnitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunit_srv`
--

DROP TABLE IF EXISTS `cforgunit_srv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunit_srv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAvailability` varchar(255) DEFAULT NULL,
  `cfConditions` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfPrice` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfSrvId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKA2B0EB3DDFB9C55A` (`cfClassId`),
  KEY `FKA2B0EB3D119BF1C2` (`cfSrvId`),
  KEY `FKA2B0EB3D19AE44D2` (`cfOrgUnitId`),
  KEY `FKA2B0EB3D1D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunitkeyw`
--

DROP TABLE IF EXISTS `cforgunitkeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunitkeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfLangCode`,`cfTrans`),
  KEY `FKA2A8183D189DA867` (`cfLangCode`),
  KEY `FKA2A8183D19AE44D2` (`cfOrgUnitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunitname`
--

DROP TABLE IF EXISTS `cforgunitname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunitname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfLangCode`,`cfTrans`),
  KEY `FKA2A964D0189DA867` (`cfLangCode`),
  KEY `FKA2A964D019AE44D2` (`cfOrgUnitId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cforgunitresact`
--

DROP TABLE IF EXISTS `cforgunitresact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cforgunitresact` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfResAct` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfOrgUnitId` (`cfOrgUnitId`,`cfLangCode`,`cfTrans`),
  KEY `FKA4F170D7189DA867` (`cfLangCode`),
  KEY `FKA4F170D719AE44D2` (`cfOrgUnitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpaddr`
--

DROP TABLE IF EXISTS `cfpaddr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpaddr` (
  `cfPAddrId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAddrline1` varchar(255) DEFAULT NULL,
  `cfAddrline2` varchar(255) DEFAULT NULL,
  `cfAddrline3` varchar(255) DEFAULT NULL,
  `cfAddrline4` varchar(255) DEFAULT NULL,
  `cfAddrline5` varchar(255) DEFAULT NULL,
  `cfCityTown` varchar(255) DEFAULT NULL,
  `cfPostCode` varchar(255) DEFAULT NULL,
  `cfStateOfCountry` varchar(255) DEFAULT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  `cfCountryCode` varchar(255) NOT NULL,
  PRIMARY KEY (`cfPAddrId`),
  KEY `FK279DA1DE100568E5` (`cfCountryCode`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpaddr_class`
--

DROP TABLE IF EXISTS `cfpaddr_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpaddr_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfPAddrId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPAddrId` (`cfPAddrId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK8EC75FB7DFB9C55A` (`cfClassId`),
  KEY `FK8EC75FB7E7AA0FF1` (`cfPAddrId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpaddr_geobbox`
--

DROP TABLE IF EXISTS `cfpaddr_geobbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpaddr_geobbox` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfGeoBBoxId` bigint(20) NOT NULL,
  `cfPAddrId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPAddrId` (`cfPAddrId`,`cfGeoBBoxId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKC2C3A77989489F1` (`cfGeoBBoxId`),
  KEY `FKC2C3A779DFB9C55A` (`cfClassId`),
  KEY `FKC2C3A779E7AA0FF1` (`cfPAddrId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers`
--

DROP TABLE IF EXISTS `cfpers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers` (
  `cfPersId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfBirthdate` datetime DEFAULT NULL,
  `cfGender` varchar(255) DEFAULT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfPersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_class`
--

DROP TABLE IF EXISTS `cfpers_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKCE770792DFB9C55A` (`cfClassId`),
  KEY `FKCE77079237561BDD` (`cfPersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_country`
--

DROP TABLE IF EXISTS `cfpers_country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCountryCode` varchar(255) NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfCountryCode`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK13099730DFB9C55A` (`cfClassId`),
  KEY `FK1309973037561BDD` (`cfPersId`),
  KEY `FK13099730100568E5` (`cfCountryCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_cv`
--

DROP TABLE IF EXISTS `cfpers_cv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_cv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCVId` bigint(20) NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfCVId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKF4F6F479DFB9C55A` (`cfClassId`),
  KEY `FKF4F6F4797FDC2B95` (`cfCVId`),
  KEY `FKF4F6F47937561BDD` (`cfPersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_dc`
--

DROP TABLE IF EXISTS `cfpers_dc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_dc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfDCId` bigint(20) NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfDCId`,`cfDCScheme`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKF4F6F485DFB9C55A` (`cfClassId`),
  KEY `FKF4F6F48537561BDD` (`cfPersId`),
  KEY `FKF4F6F48570540C76` (`cfDCId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_eaddr`
--

DROP TABLE IF EXISTS `cfpers_eaddr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_eaddr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEAddrId` bigint(20) NOT NULL,
  `cfPersonId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersonId` (`cfPersonId`,`cfEAddrId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKCE7FB410DFB9C55A` (`cfClassId`),
  KEY `FKCE7FB410CCF995D5` (`cfEAddrId`),
  KEY `FKCE7FB410D8B7ABBC` (`cfPersonId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_equip`
--

DROP TABLE IF EXISTS `cfpers_equip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_equip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAvailability` varchar(255) DEFAULT NULL,
  `cfConditions` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfPrice` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfEquipId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKCE95C64ADFB9C55A` (`cfClassId`),
  KEY `FKCE95C64A37561BDD` (`cfPersId`),
  KEY `FKCE95C64A1D977764` (`cfCurrCode`),
  KEY `FKCE95C64A7FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_event`
--

DROP TABLE IF EXISTS `cfpers_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEventId` bigint(20) NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfEventId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKCE97D0B4DFB9C55A` (`cfClassId`),
  KEY `FKCE97D0B4A03A58DB` (`cfEventId`),
  KEY `FKCE97D0B437561BDD` (`cfPersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_expskills`
--

DROP TABLE IF EXISTS `cfpers_expskills`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_expskills` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAvailability` varchar(255) DEFAULT NULL,
  `cfConditions` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfPrice` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfExpSkillsId` bigint(20) NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfExpSkillsId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKF5EEDD9DFB9C55A` (`cfClassId`),
  KEY `FKF5EEDD937561BDD` (`cfPersId`),
  KEY `FKF5EEDD91E5DC530` (`cfExpSkillsId`),
  KEY `FKF5EEDD91D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_facil`
--

DROP TABLE IF EXISTS `cfpers_facil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_facil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAvailability` varchar(255) DEFAULT NULL,
  `cfConditions` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfPrice` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfFacilId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKCE9C5445DFB9C55A` (`cfClassId`),
  KEY `FKCE9C54455C15A0E8` (`cfFacilId`),
  KEY `FKCE9C544537561BDD` (`cfPersId`),
  KEY `FKCE9C54451D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_fund`
--

DROP TABLE IF EXISTS `cfpers_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_fund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAmount` double DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfFundId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK930D996BDFB9C55A` (`cfClassId`),
  KEY `FK930D996BB798AACF` (`cfFundId`),
  KEY `FK930D996B37561BDD` (`cfPersId`),
  KEY `FK930D996B1D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_indic`
--

DROP TABLE IF EXISTS `cfpers_indic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_indic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfIndicId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKCECC8753DFB9C55A` (`cfClassId`),
  KEY `FKCECC875360EF2FAF` (`cfIndicId`),
  KEY `FKCECC875337561BDD` (`cfPersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_lang`
--

DROP TABLE IF EXISTS `cfpers_lang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_lang` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `reading` varchar(255) DEFAULT NULL,
  `speaking` varchar(255) DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `writing` varchar(255) DEFAULT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfLangCode`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK93100894DFB9C55A` (`cfClassId`),
  KEY `FK93100894189DA867` (`cfLangCode`),
  KEY `FK9310089437561BDD` (`cfPersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_meas`
--

DROP TABLE IF EXISTS `cfpers_meas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_meas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfMeasId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK93108A70DFB9C55A` (`cfClassId`),
  KEY `FK93108A7037561BDD` (`cfPersId`),
  KEY `FK93108A7058267D3` (`cfMeasId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_medium`
--

DROP TABLE IF EXISTS `cfpers_medium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_medium` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfMediumId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK1118F49B2D8C1F39` (`cfMediumId`),
  KEY `FK1118F49BDFB9C55A` (`cfClassId`),
  KEY `FK1118F49B37561BDD` (`cfPersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_orgunit`
--

DROP TABLE IF EXISTS `cfpers_orgunit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_orgunit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfOrgUnitId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK92222A22DFB9C55A` (`cfClassId`),
  KEY `FK92222A2237561BDD` (`cfPersId`),
  KEY `FK92222A2219AE44D2` (`cfOrgUnitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_paddr`
--

DROP TABLE IF EXISTS `cfpers_paddr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_paddr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfPAddrId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfPAddrId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKCF1AB69BDFB9C55A` (`cfClassId`),
  KEY `FKCF1AB69BE7AA0FF1` (`cfPAddrId`),
  KEY `FKCF1AB69B37561BDD` (`cfPersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_pers`
--

DROP TABLE IF EXISTS `cfpers_pers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_pers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfPersId1` bigint(20) NOT NULL,
  `cfPersId2` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId1` (`cfPersId1`,`cfPersId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK9311E99CDFB9C55A` (`cfClassId`),
  KEY `FK9311E99CC4611126` (`cfPersId1`),
  KEY `FK9311E99CC4611127` (`cfPersId2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_prize`
--

DROP TABLE IF EXISTS `cfpers_prize`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_prize` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfPrizeId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfPrizeId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKCF31122CDFB9C55A` (`cfClassId`),
  KEY `FKCF31122CE0225DCB` (`cfPrizeId`),
  KEY `FKCF31122C3D641B95` (`cfPersId`),
  KEY `FKCF31122C37561BDD` (`cfPersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_qual`
--

DROP TABLE IF EXISTS `cfpers_qual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_qual` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfQualId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfQualId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK931297F5DFB9C55A` (`cfClassId`),
  KEY `FK931297F5DC11428B` (`cfQualId`),
  KEY `FK931297F5D982C672` (`cfPersId`),
  KEY `FK931297F537561BDD` (`cfPersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_respat`
--

DROP TABLE IF EXISTS `cfpers_respat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_respat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfResPatId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfResPatId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK19A7A109DFB9C55A` (`cfClassId`),
  KEY `FK19A7A1093B234AEE` (`cfResPatId`),
  KEY `FK19A7A10937561BDD` (`cfPersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_resprod`
--

DROP TABLE IF EXISTS `cfpers_resprod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_resprod` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAvailability` varchar(255) DEFAULT NULL,
  `cfConditions` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime DEFAULT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfIPR` varchar(255) DEFAULT NULL,
  `cfPrice` double DEFAULT NULL,
  `cfStartDate` datetime DEFAULT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfResProdId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK1B4CBFB1DFB9C55A` (`cfClassId`),
  KEY `FK1B4CBFB137561BDD` (`cfPersId`),
  KEY `FK1B4CBFB11D977764` (`cfCurrCode`),
  KEY `FK1B4CBFB146EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_respubl`
--

DROP TABLE IF EXISTS `cfpers_respubl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_respubl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfCopyright` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfResPublId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK1B4CC969DFB9C55A` (`cfClassId`),
  KEY `FK1B4CC969973D478E` (`cfResPublId`),
  KEY `FK1B4CC96937561BDD` (`cfPersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpers_srv`
--

DROP TABLE IF EXISTS `cfpers_srv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpers_srv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAvailability` varchar(255) DEFAULT NULL,
  `cfConditions` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfPrice` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfSrvId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKA9E7DA91DFB9C55A` (`cfClassId`),
  KEY `FKA9E7DA91119BF1C2` (`cfSrvId`),
  KEY `FKA9E7DA9137561BDD` (`cfPersId`),
  KEY `FKA9E7DA911D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfperskeyw`
--

DROP TABLE IF EXISTS `cfperskeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfperskeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfLangCode`,`cfTrans`),
  KEY `FKA9DF0791189DA867` (`cfLangCode`),
  KEY `FKA9DF079137561BDD` (`cfPersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpersname`
--

DROP TABLE IF EXISTS `cfpersname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpersname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfFamilyNames` varchar(255) DEFAULT NULL,
  `cfFirstNames` varchar(255) DEFAULT NULL,
  `cfOtherNames` varchar(255) DEFAULT NULL,
  `cfPersId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`),
  KEY `FKA9E0542437561BDD` (`cfPersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfpersresint`
--

DROP TABLE IF EXISTS `cfpersresint`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfpersresint` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfResInt` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPersId` (`cfPersId`,`cfLangCode`,`cfTrans`),
  KEY `FKBA29FA88189DA867` (`cfLangCode`),
  KEY `FKBA29FA8837561BDD` (`cfPersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfprize`
--

DROP TABLE IF EXISTS `cfprize`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfprize` (
  `cfPrizeId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfPrizeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfprize_class`
--

DROP TABLE IF EXISTS `cfprize_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfprize_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfPrizeId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPrizeId` (`cfPrizeId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK7597FAA8DFB9C55A` (`cfClassId`),
  KEY `FK7597FAA8E0225DCB` (`cfPrizeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfprizedescr`
--

DROP TABLE IF EXISTS `cfprizedescr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfprizedescr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfPrizeId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPrizeId` (`cfPrizeId`,`cfLangCode`,`cfTrans`),
  KEY `FK2B99F3D2189DA867` (`cfLangCode`),
  KEY `FK2B99F3D2E0225DCB` (`cfPrizeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfprizekeyw`
--

DROP TABLE IF EXISTS `cfprizekeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfprizekeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfPrizeId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPrizeId` (`cfPrizeId`,`cfLangCode`,`cfTrans`),
  KEY `FK9AD5007189DA867` (`cfLangCode`),
  KEY `FK9AD5007E0225DCB` (`cfPrizeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfprizename`
--

DROP TABLE IF EXISTS `cfprizename`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfprizename` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfPrizeId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfPrizeId` (`cfPrizeId`,`cfLangCode`,`cfTrans`),
  KEY `FK9AE9C9A189DA867` (`cfLangCode`),
  KEY `FK9AE9C9AE0225DCB` (`cfPrizeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj`
--

DROP TABLE IF EXISTS `cfproj`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj` (
  `cfProjId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAcro` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime DEFAULT NULL,
  `cfStartDate` datetime DEFAULT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfProjId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_class`
--

DROP TABLE IF EXISTS `cfproj_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK42350EB9DFB9C55A` (`cfClassId`),
  KEY `FK42350EB93D189920` (`cfProjId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_dc`
--

DROP TABLE IF EXISTS `cfproj_dc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_dc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfDCId` bigint(20) NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfDCId`,`cfDCScheme`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKAF796BEDFB9C55A` (`cfClassId`),
  KEY `FKAF796BE3D189920` (`cfProjId`),
  KEY `FKAF796BE70540C76` (`cfDCId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_equip`
--

DROP TABLE IF EXISTS `cfproj_equip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_equip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAvailability` varchar(255) DEFAULT NULL,
  `cfConditions` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfPrice` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfEquipId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK4253CD71DFB9C55A` (`cfClassId`),
  KEY `FK4253CD713D189920` (`cfProjId`),
  KEY `FK4253CD711D977764` (`cfCurrCode`),
  KEY `FK4253CD717FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_event`
--

DROP TABLE IF EXISTS `cfproj_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEventId` bigint(20) NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfEventId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK4255D7DBDFB9C55A` (`cfClassId`),
  KEY `FK4255D7DBA03A58DB` (`cfEventId`),
  KEY `FK4255D7DB3D189920` (`cfProjId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_facil`
--

DROP TABLE IF EXISTS `cfproj_facil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_facil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAvailability` varchar(255) DEFAULT NULL,
  `cfConditions` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfPrice` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfFacilId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK425A5B6CDFB9C55A` (`cfClassId`),
  KEY `FK425A5B6C5C15A0E8` (`cfFacilId`),
  KEY `FK425A5B6C3D189920` (`cfProjId`),
  KEY `FK425A5B6C1D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_fund`
--

DROP TABLE IF EXISTS `cfproj_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_fund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAmount` double DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfFundId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK2B6E9164DFB9C55A` (`cfClassId`),
  KEY `FK2B6E9164B798AACF` (`cfFundId`),
  KEY `FK2B6E91643D189920` (`cfProjId`),
  KEY `FK2B6E91641D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_indic`
--

DROP TABLE IF EXISTS `cfproj_indic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_indic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfIndicId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK428A8E7ADFB9C55A` (`cfClassId`),
  KEY `FK428A8E7A60EF2FAF` (`cfIndicId`),
  KEY `FK428A8E7A3D189920` (`cfProjId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_meas`
--

DROP TABLE IF EXISTS `cfproj_meas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_meas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfMeasId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK2B718269DFB9C55A` (`cfClassId`),
  KEY `FK2B7182693D189920` (`cfProjId`),
  KEY `FK2B71826958267D3` (`cfMeasId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_medium`
--

DROP TABLE IF EXISTS `cfproj_medium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_medium` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfMediumId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK151BD2542D8C1F39` (`cfMediumId`),
  KEY `FK151BD254DFB9C55A` (`cfClassId`),
  KEY `FK151BD2543D189920` (`cfProjId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_orgunit`
--

DROP TABLE IF EXISTS `cfproj_orgunit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_orgunit` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfOrgUnitId` bigint(20) NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfOrgUnitId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKE7B0389DFB9C55A` (`cfClassId`),
  KEY `FKE7B03893D189920` (`cfProjId`),
  KEY `FKE7B038919AE44D2` (`cfOrgUnitId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_pers`
--

DROP TABLE IF EXISTS `cfproj_pers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_pers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfPersId` bigint(20) NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfPersId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK2B72E195DFB9C55A` (`cfClassId`),
  KEY `FK2B72E1953D189920` (`cfProjId`),
  KEY `FK2B72E19537561BDD` (`cfPersId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_prize`
--

DROP TABLE IF EXISTS `cfproj_prize`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_prize` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfPrizeDate` datetime NOT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfPrizeId` bigint(20) NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfPrizeId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK42EF1953DFB9C55A` (`cfClassId`),
  KEY `FK42EF19533D189920` (`cfProjId`),
  KEY `FK42EF1953E0225DCB` (`cfPrizeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_proj`
--

DROP TABLE IF EXISTS `cfproj_proj`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_proj` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfProjId1` bigint(20) NOT NULL,
  `cfProjId2` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId1` (`cfProjId1`,`cfProjId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK2B7311FCDF6E7DFC` (`cfProjId2`),
  KEY `FK2B7311FCDFB9C55A` (`cfClassId`),
  KEY `FK2B7311FCDF6E7DFB` (`cfProjId1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_respat`
--

DROP TABLE IF EXISTS `cfproj_respat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_respat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  `cfResPatId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfResPatId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK1DAA7EC2DFB9C55A` (`cfClassId`),
  KEY `FK1DAA7EC23B234AEE` (`cfResPatId`),
  KEY `FK1DAA7EC23D189920` (`cfProjId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_resprod`
--

DROP TABLE IF EXISTS `cfproj_resprod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_resprod` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime DEFAULT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime DEFAULT NULL,
  `cfProjId` bigint(20) NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfResProdId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK97A59918DFB9C55A` (`cfClassId`),
  KEY `FK97A599183D189920` (`cfProjId`),
  KEY `FK97A5991846EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_respubl`
--

DROP TABLE IF EXISTS `cfproj_respubl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_respubl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfCopyright` double DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfResPublId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK97A5A2D0DFB9C55A` (`cfClassId`),
  KEY `FK97A5A2D0973D478E` (`cfResPublId`),
  KEY `FK97A5A2D03D189920` (`cfProjId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfproj_srv`
--

DROP TABLE IF EXISTS `cfproj_srv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfproj_srv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAvailability` varchar(255) DEFAULT NULL,
  `cfConditions` varchar(255) DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfPrice` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfProjId` bigint(20) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfSrvId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK53FB7F78DFB9C55A` (`cfClassId`),
  KEY `FK53FB7F78119BF1C2` (`cfSrvId`),
  KEY `FK53FB7F783D189920` (`cfProjId`),
  KEY `FK53FB7F781D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfprojabstr`
--

DROP TABLE IF EXISTS `cfprojabstr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfprojabstr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAbstr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfLangCode`,`cfTrans`),
  KEY `FK29D483F0189DA867` (`cfLangCode`),
  KEY `FK29D483F03D189920` (`cfProjId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfprojkeyw`
--

DROP TABLE IF EXISTS `cfprojkeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfprojkeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfLangCode`,`cfTrans`),
  KEY `FK53F2AC78189DA867` (`cfLangCode`),
  KEY `FK53F2AC783D189920` (`cfProjId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfprojtitle`
--

DROP TABLE IF EXISTS `cfprojtitle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfprojtitle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfTitle` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfProjId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfProjId` (`cfProjId`,`cfLangCode`,`cfTrans`),
  KEY `FK2AE373D8189DA867` (`cfLangCode`),
  KEY `FK2AE373D83D189920` (`cfProjId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfqual`
--

DROP TABLE IF EXISTS `cfqual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfqual` (
  `cfQualId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfQualId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfqual_class`
--

DROP TABLE IF EXISTS `cfqual_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfqual_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfQualId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfQualId` (`cfQualId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKB08ABF4BDFB9C55A` (`cfClassId`),
  KEY `FKB08ABF4BDC11428B` (`cfQualId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfqualdescr`
--

DROP TABLE IF EXISTS `cfqualdescr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfqualdescr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfQualId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfQualId` (`cfQualId`,`cfLangCode`,`cfTrans`),
  KEY `FK14BA8ECFDC11428B` (`cfQualId`),
  KEY `FK14BA8ECF189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfqualkeyw`
--

DROP TABLE IF EXISTS `cfqualkeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfqualkeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfQualId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfQualId` (`cfQualId`,`cfLangCode`,`cfTrans`),
  KEY `FK42BEE16ADC11428B` (`cfQualId`),
  KEY `FK42BEE16A189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfqualtitle`
--

DROP TABLE IF EXISTS `cfqualtitle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfqualtitle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfTitle` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfQualId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfQualId` (`cfQualId`,`cfLangCode`,`cfTrans`),
  KEY `FK159DDD26DC11428B` (`cfQualId`),
  KEY `FK159DDD26189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespat`
--

DROP TABLE IF EXISTS `cfrespat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespat` (
  `cfResPatId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfApprovDate` datetime DEFAULT NULL,
  `cfCountryCode` tinyblob,
  `cfPatentNum` varchar(255) DEFAULT NULL,
  `cfRegistrDate` datetime DEFAULT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfResPatId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespat_class`
--

DROP TABLE IF EXISTS `cfrespat_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespat_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfResPatId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPatId` (`cfResPatId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKA31F85FFDFB9C55A` (`cfClassId`),
  KEY `FKA31F85FF3B234AEE` (`cfResPatId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespat_equip`
--

DROP TABLE IF EXISTS `cfrespat_equip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespat_equip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfResPatId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPatId` (`cfResPatId`,`cfEquipId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKA33E44B7DFB9C55A` (`cfClassId`),
  KEY `FKA33E44B73B234AEE` (`cfResPatId`),
  KEY `FKA33E44B77FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespat_facil`
--

DROP TABLE IF EXISTS `cfrespat_facil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespat_facil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfResPatId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPatId` (`cfResPatId`,`cfFacilId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKA344D2B2DFB9C55A` (`cfClassId`),
  KEY `FKA344D2B23B234AEE` (`cfResPatId`),
  KEY `FKA344D2B25C15A0E8` (`cfFacilId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespat_fund`
--

DROP TABLE IF EXISTS `cfrespat_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespat_fund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAmount` double DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfResPatId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPatId` (`cfResPatId`,`cfFundId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK4755195EDFB9C55A` (`cfClassId`),
  KEY `FK4755195E3B234AEE` (`cfResPatId`),
  KEY `FK4755195EB798AACF` (`cfFundId`),
  KEY `FK4755195E1D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespat_indic`
--

DROP TABLE IF EXISTS `cfrespat_indic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespat_indic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfResPatId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPatId` (`cfResPatId`,`cfIndicId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKA37505C0DFB9C55A` (`cfClassId`),
  KEY `FKA37505C03B234AEE` (`cfResPatId`),
  KEY `FKA37505C060EF2FAF` (`cfIndicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespat_meas`
--

DROP TABLE IF EXISTS `cfrespat_meas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespat_meas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  `cfResPatId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPatId` (`cfResPatId`,`cfMeasId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK47580A63DFB9C55A` (`cfClassId`),
  KEY `FK47580A633B234AEE` (`cfResPatId`),
  KEY `FK47580A6358267D3` (`cfMeasId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespat_medium`
--

DROP TABLE IF EXISTS `cfrespat_medium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespat_medium` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  `cfResPatId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPatId` (`cfResPatId`,`cfMediumId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKD18043CE2D8C1F39` (`cfMediumId`),
  KEY `FKD18043CEDFB9C55A` (`cfClassId`),
  KEY `FKD18043CE3B234AEE` (`cfResPatId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespat_respat`
--

DROP TABLE IF EXISTS `cfrespat_respat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespat_respat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfResPatId1` bigint(20) NOT NULL,
  `cfResPatId2` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPatId1` (`cfResPatId1`,`cfResPatId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKDA0EF03CDFB9C55A` (`cfClassId`),
  KEY `FKDA0EF03C37E477BE` (`cfResPatId2`),
  KEY `FKDA0EF03C37E477BD` (`cfResPatId1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespat_srv`
--

DROP TABLE IF EXISTS `cfrespat_srv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespat_srv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfResPatId` bigint(20) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPatId` (`cfResPatId`,`cfSrvId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKE987103EDFB9C55A` (`cfClassId`),
  KEY `FKE987103E119BF1C2` (`cfSrvId`),
  KEY `FKE987103E3B234AEE` (`cfResPatId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespatabstr`
--

DROP TABLE IF EXISTS `cfrespatabstr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespatabstr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAbstr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfResPatId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPatId` (`cfResPatId`,`cfLangCode`,`cfTrans`),
  KEY `FK45BB0BEA3B234AEE` (`cfResPatId`),
  KEY `FK45BB0BEA189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespatkeyw`
--

DROP TABLE IF EXISTS `cfrespatkeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespatkeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfResPatId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPatId` (`cfResPatId`,`cfLangCode`,`cfTrans`),
  KEY `FKE97E3D3E3B234AEE` (`cfResPatId`),
  KEY `FKE97E3D3E189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespattitle`
--

DROP TABLE IF EXISTS `cfrespattitle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespattitle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfTitle` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfResPatId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPatId` (`cfResPatId`,`cfLangCode`,`cfTrans`),
  KEY `FK46C9FBD23B234AEE` (`cfResPatId`),
  KEY `FK46C9FBD2189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespatversinfo`
--

DROP TABLE IF EXISTS `cfrespatversinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespatversinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfTrans` varchar(255) NOT NULL,
  `cfVersInfo` varchar(255) DEFAULT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfResPatId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPatId` (`cfResPatId`,`cfLangCode`,`cfTrans`),
  KEY `FKC426EA443B234AEE` (`cfResPatId`),
  KEY `FKC426EA44189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfresprod`
--

DROP TABLE IF EXISTS `cfresprod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfresprod` (
  `cfResProdId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfResProdInternId` varchar(255) DEFAULT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  `cfVersion` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfresprod_class`
--

DROP TABLE IF EXISTS `cfresprod_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfresprod_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResProdId` (`cfResProdId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKC8008B8DDFB9C55A` (`cfClassId`),
  KEY `FKC8008B8D46EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfresprod_country`
--

DROP TABLE IF EXISTS `cfresprod_country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfresprod_country` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCountryId` varchar(255) NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResProdId` (`cfResProdId`,`cfCountryId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKD042086BDFB9C55A` (`cfClassId`),
  KEY `FKD042086B54E1C0D3` (`cfCountryId`),
  KEY `FKD042086B46EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfresprod_equip`
--

DROP TABLE IF EXISTS `cfresprod_equip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfresprod_equip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResProdId` (`cfResProdId`,`cfEquipId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKC81F4A45DFB9C55A` (`cfClassId`),
  KEY `FKC81F4A4546EEDC19` (`cfResProdId`),
  KEY `FKC81F4A457FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfresprod_facil`
--

DROP TABLE IF EXISTS `cfresprod_facil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfresprod_facil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResProdId` (`cfResProdId`,`cfFacilId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKC825D840DFB9C55A` (`cfClassId`),
  KEY `FKC825D8405C15A0E8` (`cfFacilId`),
  KEY `FKC825D84046EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfresprod_fund`
--

DROP TABLE IF EXISTS `cfresprod_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfresprod_fund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAmount` double DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResProdId` (`cfResProdId`,`cfFundId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK8A962A10DFB9C55A` (`cfClassId`),
  KEY `FK8A962A10B798AACF` (`cfFundId`),
  KEY `FK8A962A101D977764` (`cfCurrCode`),
  KEY `FK8A962A1046EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfresprod_geobbox`
--

DROP TABLE IF EXISTS `cfresprod_geobbox`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfresprod_geobbox` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfGeographicBoundingBoxId` bigint(20) NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResProdId` (`cfResProdId`,`cfGeographicBoundingBoxId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK926135CFDFB9C55A` (`cfClassId`),
  KEY `FK926135CFCC6DF387` (`cfGeographicBoundingBoxId`),
  KEY `FK926135CF46EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfresprod_indic`
--

DROP TABLE IF EXISTS `cfresprod_indic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfresprod_indic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResProdId` (`cfResProdId`,`cfIndicId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKC8560B4EDFB9C55A` (`cfClassId`),
  KEY `FKC8560B4E60EF2FAF` (`cfIndicId`),
  KEY `FKC8560B4E46EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfresprod_meas`
--

DROP TABLE IF EXISTS `cfresprod_meas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfresprod_meas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResProdId` (`cfResProdId`,`cfMeasId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK8A991B15DFB9C55A` (`cfClassId`),
  KEY `FK8A991B1558267D3` (`cfMeasId`),
  KEY `FK8A991B1546EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfresprod_medium`
--

DROP TABLE IF EXISTS `cfresprod_medium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfresprod_medium` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResProdId` (`cfResProdId`,`cfMediumId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK48BFF0002D8C1F39` (`cfMediumId`),
  KEY `FK48BFF000DFB9C55A` (`cfClassId`),
  KEY `FK48BFF00046EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfresprod_resprod`
--

DROP TABLE IF EXISTS `cfresprod_resprod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfresprod_resprod` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfResProdId1` bigint(20) NOT NULL,
  `cfResProdId2` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResProdId1` (`cfResProdId1`,`cfResProdId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKD88530ECDFB9C55A` (`cfClassId`),
  KEY `FKD88530ECFE1FD18C` (`cfResProdId1`),
  KEY `FKD88530ECFE1FD18D` (`cfResProdId2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfresprod_srv`
--

DROP TABLE IF EXISTS `cfresprod_srv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfresprod_srv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResProdId` (`cfResProdId`,`cfSrvId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKC268214CDFB9C55A` (`cfClassId`),
  KEY `FKC268214C119BF1C2` (`cfSrvId`),
  KEY `FKC268214C46EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfresproddescr`
--

DROP TABLE IF EXISTS `cfresproddescr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfresproddescr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResProdId` (`cfResProdId`,`cfLangCode`,`cfTrans`),
  KEY `FK8927BE2D189DA867` (`cfLangCode`),
  KEY `FK8927BE2D46EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfresprodkeyw`
--

DROP TABLE IF EXISTS `cfresprodkeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfresprodkeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResProdId` (`cfResProdId`,`cfLangCode`,`cfTrans`),
  KEY `FKC25F4E4C189DA867` (`cfLangCode`),
  KEY `FKC25F4E4C46EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfresprodname`
--

DROP TABLE IF EXISTS `cfresprodname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfresprodname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResProdId` (`cfResProdId`,`cfLangCode`,`cfTrans`),
  KEY `FKC2609ADF189DA867` (`cfLangCode`),
  KEY `FKC2609ADF46EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfresprodversinfo`
--

DROP TABLE IF EXISTS `cfresprodversinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfresprodversinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfTrans` varchar(255) NOT NULL,
  `cfVersInfo` varchar(255) DEFAULT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResProdId` (`cfResProdId`,`cfLangCode`,`cfTrans`),
  KEY `FK34DCC452189DA867` (`cfLangCode`),
  KEY `FK34DCC45246EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubl`
--

DROP TABLE IF EXISTS `cfrespubl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubl` (
  `cfResPublId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfResPublDate` datetime DEFAULT NULL,
  `cfEdition` varchar(255) DEFAULT NULL,
  `cfEndPage` varchar(255) DEFAULT NULL,
  `cfISBN` varchar(255) DEFAULT NULL,
  `cfISSN` varchar(255) DEFAULT NULL,
  `cfIssue` varchar(255) DEFAULT NULL,
  `cfNum` varchar(255) DEFAULT NULL,
  `cfSeries` varchar(255) DEFAULT NULL,
  `cfStartPage` varchar(255) DEFAULT NULL,
  `cfTotalPages` varchar(255) DEFAULT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  `cfVol` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfResPublId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubl_cite`
--

DROP TABLE IF EXISTS `cfrespubl_cite`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubl_cite` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfCount` double DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfYear` int(11) DEFAULT NULL,
  `cfCiteId` bigint(20) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfCiteId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK202DE9EADFB9C55A` (`cfClassId`),
  KEY `FK202DE9EA973D478E` (`cfResPublId`),
  KEY `FK202DE9EAE615308D` (`cfCiteId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubl_class`
--

DROP TABLE IF EXISTS `cfrespubl_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubl_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKE5906B45DFB9C55A` (`cfClassId`),
  KEY `FKE5906B45973D478E` (`cfResPublId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubl_dc`
--

DROP TABLE IF EXISTS `cfrespubl_dc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubl_dc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfDCScheme` varchar(255) NOT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfDCId` bigint(20) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfDCId`,`cfDCScheme`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKAB065B2DFB9C55A` (`cfClassId`),
  KEY `FKAB065B2973D478E` (`cfResPublId`),
  KEY `FKAB065B270540C76` (`cfDCId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubl_equip`
--

DROP TABLE IF EXISTS `cfrespubl_equip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubl_equip` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEquipId` bigint(20) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfEquipId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKE5AF29FDDFB9C55A` (`cfClassId`),
  KEY `FKE5AF29FD973D478E` (`cfResPublId`),
  KEY `FKE5AF29FD7FC78DD4` (`cfEquipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubl_event`
--

DROP TABLE IF EXISTS `cfrespubl_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubl_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEventId` bigint(20) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfEventId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKE5B13467DFB9C55A` (`cfClassId`),
  KEY `FKE5B13467973D478E` (`cfResPublId`),
  KEY `FKE5B13467A03A58DB` (`cfEventId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubl_facil`
--

DROP TABLE IF EXISTS `cfrespubl_facil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubl_facil` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfFacilId` bigint(20) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfFacilId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKE5B5B7F8DFB9C55A` (`cfClassId`),
  KEY `FKE5B5B7F8973D478E` (`cfResPublId`),
  KEY `FKE5B5B7F85C15A0E8` (`cfFacilId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubl_fund`
--

DROP TABLE IF EXISTS `cfrespubl_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubl_fund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAmount` double DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfFundId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK202F7358DFB9C55A` (`cfClassId`),
  KEY `FK202F7358973D478E` (`cfResPublId`),
  KEY `FK202F7358B798AACF` (`cfFundId`),
  KEY `FK202F73581D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubl_indic`
--

DROP TABLE IF EXISTS `cfrespubl_indic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubl_indic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfIndicId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKE5E5EB06DFB9C55A` (`cfClassId`),
  KEY `FKE5E5EB06973D478E` (`cfResPublId`),
  KEY `FKE5E5EB0660EF2FAF` (`cfIndicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubl_meas`
--

DROP TABLE IF EXISTS `cfrespubl_meas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubl_meas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfMeasId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK2032645DDFB9C55A` (`cfClassId`),
  KEY `FK2032645D973D478E` (`cfResPublId`),
  KEY `FK2032645D58267D3` (`cfMeasId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubl_medium`
--

DROP TABLE IF EXISTS `cfrespubl_medium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubl_medium` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfMediumId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKDD2C07482D8C1F39` (`cfMediumId`),
  KEY `FKDD2C0748DFB9C55A` (`cfClassId`),
  KEY `FKDD2C0748973D478E` (`cfResPublId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubl_metrics`
--

DROP TABLE IF EXISTS `cfrespubl_metrics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubl_metrics` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfCount` double DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfYear` int(11) DEFAULT NULL,
  `cfMetricsId` bigint(20) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfMetricsId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKC93A4350DFB9C55A` (`cfClassId`),
  KEY `FKC93A4350973D478E` (`cfResPublId`),
  KEY `FKC93A4350E1EEFBED` (`cfMetricsId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubl_respat`
--

DROP TABLE IF EXISTS `cfrespubl_respat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubl_respat` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfResPatId` bigint(20) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfResPatId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKE5BAB3B6DFB9C55A` (`cfClassId`),
  KEY `FKE5BAB3B6973D478E` (`cfResPublId`),
  KEY `FKE5BAB3B63B234AEE` (`cfResPatId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubl_resprod`
--

DROP TABLE IF EXISTS `cfrespubl_resprod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubl_resprod` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime DEFAULT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime DEFAULT NULL,
  `cfResProdId` bigint(20) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfResProdId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKD19C02A4DFB9C55A` (`cfClassId`),
  KEY `FKD19C02A4973D478E` (`cfResPublId`),
  KEY `FKD19C02A446EEDC19` (`cfResProdId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubl_respubl`
--

DROP TABLE IF EXISTS `cfrespubl_respubl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubl_respubl` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfResPublId1` bigint(20) NOT NULL,
  `cfResPublId2` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId1` (`cfResPublId1`,`cfResPublId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKD19C0C5C52B4BC92` (`cfResPublId2`),
  KEY `FKD19C0C5CDFB9C55A` (`cfClassId`),
  KEY `FKD19C0C5C52B4BC91` (`cfResPublId1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubl_srv`
--

DROP TABLE IF EXISTS `cfrespubl_srv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubl_srv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfSrvId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK4B5C8F04DFB9C55A` (`cfClassId`),
  KEY `FK4B5C8F04119BF1C2` (`cfSrvId`),
  KEY `FK4B5C8F04973D478E` (`cfResPublId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespublabstr`
--

DROP TABLE IF EXISTS `cfrespublabstr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespublabstr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAbstr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfLangCode`,`cfTrans`),
  KEY `FK1E9565E4973D478E` (`cfResPublId`),
  KEY `FK1E9565E4189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespublbiblnote`
--

DROP TABLE IF EXISTS `cfrespublbiblnote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespublbiblnote` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfBiblNote` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfLangCode`,`cfTrans`),
  KEY `FKC8471E6F973D478E` (`cfResPublId`),
  KEY `FKC8471E6F189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespublkeyw`
--

DROP TABLE IF EXISTS `cfrespublkeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespublkeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfLangCode`,`cfTrans`),
  KEY `FK4B53BC04973D478E` (`cfResPublId`),
  KEY `FK4B53BC04189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespublnameabbrev`
--

DROP TABLE IF EXISTS `cfrespublnameabbrev`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespublnameabbrev` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfNameAbbrev` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfLangCode`,`cfTrans`),
  KEY `FK91BA4019973D478E` (`cfResPublId`),
  KEY `FK91BA4019189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespublsubtitle`
--

DROP TABLE IF EXISTS `cfrespublsubtitle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespublsubtitle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfSubtitle` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfLangCode`,`cfTrans`),
  KEY `FK2982F424973D478E` (`cfResPublId`),
  KEY `FK2982F424189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespubltitle`
--

DROP TABLE IF EXISTS `cfrespubltitle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespubltitle` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfTitle` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfLangCode`,`cfTrans`),
  KEY `FK1FA455CC973D478E` (`cfResPublId`),
  KEY `FK1FA455CC189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfrespublversinfo`
--

DROP TABLE IF EXISTS `cfrespublversinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfrespublversinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfTrans` varchar(255) NOT NULL,
  `cfVersInfo` varchar(255) DEFAULT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfResPublId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfResPublId` (`cfResPublId`,`cfLangCode`,`cfTrans`),
  KEY `FK2DF3960A973D478E` (`cfResPublId`),
  KEY `FK2DF3960A189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfsrv`
--

DROP TABLE IF EXISTS `cfsrv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfsrv` (
  `cfSrvId` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAcro` varchar(255) DEFAULT NULL,
  `cfURI` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cfSrvId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfsrv_class`
--

DROP TABLE IF EXISTS `cfsrv_class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfsrv_class` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfSrvId` (`cfSrvId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK464897EDDFB9C55A` (`cfClassId`),
  KEY `FK464897ED119BF1C2` (`cfSrvId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfsrv_event`
--

DROP TABLE IF EXISTS `cfsrv_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfsrv_event` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfEventId` bigint(20) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfSrvId` (`cfSrvId`,`cfEventId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK4669610FDFB9C55A` (`cfClassId`),
  KEY `FK4669610F119BF1C2` (`cfSrvId`),
  KEY `FK4669610FA03A58DB` (`cfEventId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfsrv_fedid`
--

DROP TABLE IF EXISTS `cfsrv_fedid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfsrv_fedid` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfFedId` bigint(20) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfSrvId` (`cfSrvId`,`cfFedId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK466FB5F517ADF339` (`cfFedId`),
  KEY `FK466FB5F5DFB9C55A` (`cfClassId`),
  KEY `FK466FB5F5119BF1C2` (`cfSrvId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfsrv_fund`
--

DROP TABLE IF EXISTS `cfsrv_fund`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfsrv_fund` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfAmount` double DEFAULT NULL,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfCurrCode` varchar(5) DEFAULT NULL,
  `cfFundId` bigint(20) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfSrvId` (`cfSrvId`,`cfFundId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK96EB11B0DFB9C55A` (`cfClassId`),
  KEY `FK96EB11B0119BF1C2` (`cfSrvId`),
  KEY `FK96EB11B0B798AACF` (`cfFundId`),
  KEY `FK96EB11B01D977764` (`cfCurrCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfsrv_indic`
--

DROP TABLE IF EXISTS `cfsrv_indic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfsrv_indic` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfIndicId` bigint(20) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfSrvId` (`cfSrvId`,`cfIndicId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK469E17AEDFB9C55A` (`cfClassId`),
  KEY `FK469E17AE119BF1C2` (`cfSrvId`),
  KEY `FK469E17AE60EF2FAF` (`cfIndicId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfsrv_meas`
--

DROP TABLE IF EXISTS `cfsrv_meas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfsrv_meas` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMeasId` bigint(20) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfSrvId` (`cfSrvId`,`cfMeasId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK96EE02B5DFB9C55A` (`cfClassId`),
  KEY `FK96EE02B5119BF1C2` (`cfSrvId`),
  KEY `FK96EE02B558267D3` (`cfMeasId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfsrv_medium`
--

DROP TABLE IF EXISTS `cfsrv_medium`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfsrv_medium` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfMediumId` bigint(20) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfSrvId` (`cfSrvId`,`cfMediumId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK93796FA02D8C1F39` (`cfMediumId`),
  KEY `FK93796FA0DFB9C55A` (`cfClassId`),
  KEY `FK93796FA0119BF1C2` (`cfSrvId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfsrv_paddr`
--

DROP TABLE IF EXISTS `cfsrv_paddr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfsrv_paddr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfPAddrId` bigint(20) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfSrvId` (`cfSrvId`,`cfPAddrId`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FK46EC46F6DFB9C55A` (`cfClassId`),
  KEY `FK46EC46F6119BF1C2` (`cfSrvId`),
  KEY `FK46EC46F6E7AA0FF1` (`cfPAddrId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfsrv_srv`
--

DROP TABLE IF EXISTS `cfsrv_srv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfsrv_srv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfEndDate` datetime NOT NULL,
  `cfFraction` double DEFAULT NULL,
  `cfStartDate` datetime NOT NULL,
  `cfSrvId1` bigint(20) NOT NULL,
  `cfSrvId2` bigint(20) NOT NULL,
  `cfClassId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfSrvId1` (`cfSrvId1`,`cfSrvId2`,`cfClassId`,`cfStartDate`,`cfEndDate`),
  KEY `FKAA07C5ACDFB9C55A` (`cfClassId`),
  KEY `FKAA07C5ACF2858636` (`cfSrvId2`),
  KEY `FKAA07C5ACF2858635` (`cfSrvId1`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfsrvdescr`
--

DROP TABLE IF EXISTS `cfsrvdescr`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfsrvdescr` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfDescr` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfSrvId` (`cfSrvId`,`cfLangCode`,`cfTrans`),
  KEY `FK957CA5CD119BF1C2` (`cfSrvId`),
  KEY `FK957CA5CD189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfsrvkeyw`
--

DROP TABLE IF EXISTS `cfsrvkeyw`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfsrvkeyw` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfKeyw` varchar(20000) NOT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cfSrvId` (`cfSrvId`,`cfLangCode`,`cfTrans`),
  KEY `FKA9FEF2AC119BF1C2` (`cfSrvId`),
  KEY `FKA9FEF2AC189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `cfsrvname`
--

DROP TABLE IF EXISTS `cfsrvname`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cfsrvname` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cfName` varchar(255) DEFAULT NULL,
  `cfTrans` varchar(255) NOT NULL,
  `cfLangCode` varchar(255) NOT NULL,
  `cfSrvId` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKAA003F3F119BF1C2` (`cfSrvId`),
  KEY `FKAA003F3F189DA867` (`cfLangCode`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `comments` varchar(255) DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sentemails`
--

DROP TABLE IF EXISTS `sentemails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sentemails` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `message` varchar(255) DEFAULT NULL,
  `receiverEmail` varchar(255) DEFAULT NULL,
  `receiverName` varchar(255) DEFAULT NULL,
  `senderEmail` varchar(255) DEFAULT NULL,
  `senderName` varchar(255) DEFAULT NULL,
  `senderOrg` varchar(255) DEFAULT NULL,
  `subject` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Dumping data for table `cfclass`
--

INSERT INTO `cfclass` VALUES (1,NULL,NULL,'Biological and Medical Sciences',1),(2,NULL,NULL,'Energy',1),(3,NULL,NULL,'Public Sector',2),(4,NULL,NULL,'Private Sector',2),(5,NULL,NULL,'void',3),(6,NULL,NULL,'Partner',4),(7,NULL,NULL,'Coordinator',4);

--
-- Dumping data for table `cfclassscheme`
--

INSERT INTO `cfclassscheme` VALUES (1,'scientificdomain'),(2,'orgtype'),(3,'void'),(4,'org_proj_relationship');

--
-- Dumping data for table `cfclassterm`
--

INSERT INTO `cfclassterm` VALUES (1,NULL,NULL,'Biological and Medical Sciences',NULL,'HUMAN',1,'en',1),(2,NULL,NULL,'Energy',NULL,'HUMAN',1,'en',2),(3,NULL,NULL,'Public Sector',NULL,'HUMAN',2,'en',3),(4,NULL,NULL,'Private Sector',NULL,'HUMAN',2,'en',4),(5,NULL,NULL,'Partner',NULL,'HUMAN',4,'en',6),(6,NULL,NULL,'Coordinator',NULL,'HUMAN',4,'en',7);

--
-- Dumping data for table `cfcountry`
--

INSERT INTO `cfcountry` VALUES ('GR','Greece'),('US','United States of America');

--
-- Dumping data for table `cfcountryname`
--

INSERT INTO `cfcountryname` VALUES (1,'Greece','HUMAN','GR','en'),(2,'United States of America','HUMAN','US','en');

--
-- Dumping data for table `cflang`
--

INSERT INTO `cflang` VALUES ('en','English');

--
-- Dumping data for table `cforgunit`
--

INSERT INTO `cforgunit` VALUES (1,'Org1',NULL,NULL,'www.org1url.com',NULL),(2,'Org2',NULL,NULL,'www.org2url.com',NULL),(3,'Org3',NULL,NULL,'www.org3url.com',NULL);

--
-- Dumping data for table `cforgunit_class`
--

INSERT INTO `cforgunit_class` VALUES (1,'2011-03-31 00:00:00',0,'2011-03-31 00:00:00',1,3),(2,'2011-03-31 00:00:00',0,'2011-03-31 00:00:00',2,4);

--
-- Dumping data for table `cforgunit_paddr`
--

INSERT INTO `cforgunit_paddr` VALUES (1,'2011-03-31 00:00:00',0,'2011-03-31 00:00:00',1,1,5),(2,'2011-03-31 00:00:00',0,'2011-03-31 00:00:00',2,2,5),(3,'2011-03-31 00:00:00',0,'2011-03-31 00:00:00',3,3,5);

--
-- Dumping data for table `cforgunitname`
--

INSERT INTO `cforgunitname` VALUES (1,'Organisation One','HUMAN','en',1),(2,'Organisation Two','HUMAN','en',2),(3,'Organisation Three','HUMAN','en',3);

--
-- Dumping data for table `cfpaddr`
--

INSERT INTO `cfpaddr` VALUES (1,'Address of Org1','Telephone num of Org1',NULL,NULL,NULL,'Athens',NULL,NULL,NULL,'GR'),(2,'Address of Org2','Telephone num of Org2',NULL,NULL,NULL,'Seatle',NULL,NULL,NULL,'US'),(3,'Address of Org3','Telephone num of Org3',NULL,NULL,NULL,'New York',NULL,NULL,NULL,'US');

--
-- Dumping data for table `cfproj`
--

INSERT INTO `cfproj` VALUES (1,'Proj1','2011-03-31 00:00:00','2010-03-31 00:00:00',NULL),(2,'Proj2','2012-03-31 00:00:00','2011-03-31 00:00:00',NULL);

--
-- Dumping data for table `cfproj_class`
--

INSERT INTO `cfproj_class` VALUES (1,'2011-03-31 00:00:00',0,'2011-03-31 00:00:00',1,1),(2,'2011-03-31 00:00:00',0,'2011-03-31 00:00:00',2,2);

--
-- Dumping data for table `cfproj_orgunit`
--

INSERT INTO `cfproj_orgunit` VALUES (1,'2011-03-31 00:00:00',0,'2011-03-31 00:00:00',1,1,6),(2,'2011-03-31 00:00:00',0,'2011-03-31 00:00:00',2,2,7),(3,'2011-03-31 00:00:00',0,'2011-03-31 00:00:00',2,1,6),(4,'2011-03-31 00:00:00',0,'2011-03-31 00:00:00',3,1,7),(5,'2011-03-31 00:00:00',0,'2011-03-31 00:00:00',3,2,6);

--
-- Dumping data for table `cfprojabstr`
--

INSERT INTO `cfprojabstr` VALUES (1,'Some text regarding Proj1','HUMAN','en',1),(2,'Some text regarding Proj2','HUMAN','en',2);

--
-- Dumping data for table `cfprojtitle`
--

INSERT INTO `cfprojtitle` VALUES (1,'Project One','HUMAN','en',1),(2,'Project Two','HUMAN','en',2);

UNLOCK TABLES;
alter table cfCV_Class add constraint FK26F0BBEFDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfCV_Class add constraint FK26F0BBEF7FDC2B95 foreign key (cfCVId) references cfCV (cfCVId);
alter table cfCiteDescr add constraint FKFB92DBC7189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfCiteDescr add constraint FKFB92DBC7E615308D foreign key (cfCiteId) references cfCite (cfCiteId);
alter table cfCiteTitle add constraint FKFC762A1E189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfCiteTitle add constraint FKFC762A1EE615308D foreign key (cfCiteId) references cfCite (cfCiteId);
alter table cfCite_Class add constraint FKA2F92133DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfCite_Class add constraint FKA2F92133E615308D foreign key (cfCiteId) references cfCite (cfCiteId);
alter table cfCite_Medium add constraint FKCCDA0F1A2D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfCite_Medium add constraint FKCCDA0F1ADFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfCite_Medium add constraint FKCCDA0F1AE615308D foreign key (cfCiteId) references cfCite (cfCiteId);
alter table cfClass add constraint FK26F9F2D559E8DC44 foreign key (cfClassSchemeId) references cfClassScheme (cfClassSchemeId);
alter table cfClassDef add constraint FKB8CAACF0DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfClassDef add constraint FKB8CAACF0189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfClassDef add constraint FKB8CAACF059E8DC44 foreign key (cfClassSchemeId) references cfClassScheme (cfClassSchemeId);
alter table cfClassDescr add constraint FKB0D36E2CDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfClassDescr add constraint FKB0D36E2C189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfClassDescr add constraint FKB0D36E2C59E8DC44 foreign key (cfClassSchemeId) references cfClassScheme (cfClassSchemeId);
alter table cfClassEx add constraint FK50489A68DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfClassEx add constraint FK50489A68189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfClassEx add constraint FK50489A6859E8DC44 foreign key (cfClassSchemeId) references cfClassScheme (cfClassSchemeId);
alter table cfClassSchemeDescr add constraint FK75087B47189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfClassSchemeDescr  add constraint FK75087B4759E8DC44 foreign key (cfClassSchemeId) references cfClassScheme (cfClassSchemeId);
alter table cfClassSchemeName add constraint FKF346D285189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfClassSchemeName add constraint FKF346D28559E8DC44 foreign key (cfClassSchemeId) references cfClassScheme (cfClassSchemeId);
alter table cfClassScheme_ClassScheme add constraint FK43604138DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfClassScheme_ClassScheme add constraint FK43604138913342B foreign key (cfClassSchemeId1) references cfClassScheme (cfClassSchemeId);
alter table cfClassScheme_ClassScheme add constraint FK43604138913342C foreign key (cfClassSchemeId2) references cfClassScheme (cfClassSchemeId);
alter table cfClassTerm add constraint FK609238E1DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfClassTerm add constraint FK609238E1189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfClassTerm add constraint FK609238E159E8DC44 foreign key (cfClassSchemeId) references cfClassScheme (cfClassSchemeId);
alter table cfClass_Class add constraint FK95CADB6EA79A91EB foreign key (cfClassId1) references cfClass (cfClassId);
alter table cfClass_Class add constraint FK95CADB6EDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfClass_Class add constraint FK95CADB6EA79A91EC foreign key (cfClassId2) references cfClass (cfClassId);
alter table cfCountryName add constraint FK58D79ADE189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfCountryName add constraint FK58D79ADE100568E5 foreign key (cfCountryCode) references cfCountry (cfCountryCode);
alter table cfCountry_Class add constraint FK9CB787CCDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfCountry_Class add constraint FK9CB787CC100568E5 foreign key (cfCountryCode) references cfCountry (cfCountryCode);
alter table cfCurrencyEntName add constraint FK9E06A5E2189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfCurrencyEntName add constraint FK9E06A5E21D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfCurrencyName  add constraint FKA6AD523F189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfCurrencyName add constraint FKA6AD523F1D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfCurrency_Class add constraint FKCBFCEAEDDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfCurrency_Class add constraint FKCBFCEAED1D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfEAddr  add constraint FK27029F532D7B41B4 foreign key (PAddrId) references cfPAddr (cfPAddrId);
alter table cfEAddr_Class add constraint FK28F3B16CDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfEAddr_Class add constraint FK28F3B16CCCF995D5 foreign key (cfEAddrId) references cfEAddr (cfEaddrId);
alter table cfEquipDescr add constraint FK86372274189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfEquipDescr add constraint FK863722747FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfEquipKeyw add constraint FKA13EC525189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfEquipKeyw add constraint FKA13EC5257FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfEquipName add constraint FKA14011B8189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfEquipName add constraint FKA14011B87FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfEquip_Class add constraint FK6CDDB026DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfEquip_Class add constraint FK6CDDB0267FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfEquip_Equip add constraint FK6CFC6EDEDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfEquip_Equip add constraint FK6CFC6EDECE128FF6 foreign key (cfEquipId2) references cfEquip (cfEquipId);
alter table cfEquip_Equip add constraint FK6CFC6EDECE128FF5 foreign key (cfEquipId1) references cfEquip (cfEquipId);
alter table cfEquip_Event add constraint FK6CFE7948DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfEquip_Event add constraint FK6CFE7948A03A58DB foreign key (cfEventId) references cfEvent (cfEventId);
alter table cfEquip_Event add constraint FK6CFE79487FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfEquip_Fund add constraint FK87A58E57DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfEquip_Fund add constraint FK87A58E57B798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfEquip_Fund add constraint FK87A58E571D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfEquip_Fund add constraint FK87A58E577FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfEquip_Indic add constraint FK6D332FE7DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfEquip_Indic add constraint FK6D332FE760EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfEquip_Indic add constraint FK6D332FE77FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfEquip_Meas add constraint FK87A87F5CDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfEquip_Meas add constraint FK87A87F5C58267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfEquip_Meas add constraint FK87A87F5C7FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfEquip_Medium add constraint FK3F875E872D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfEquip_Medium add constraint FK3F875E87DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfEquip_Medium add constraint FK3F875E877FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfEquip_PAddr add constraint FK6D815F2FDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfEquip_PAddr add constraint FK6D815F2FE7AA0FF1 foreign key (cfPAddrId) references cfPAddr (cfPAddrId);
alter table cfEquip_PAddr add constraint FK6D815F2F7FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfEquip_Srv add constraint FKA1479825DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfEquip_Srv add constraint FKA1479825119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfEquip_Srv add constraint FKA14798257FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfEvent add constraint FK271ABBF7100568E5 foreign key (cfCountryCode) references cfCountry (cfCountryCode);
alter table cfEventDescr add constraint FKFCCD0A4A189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfEventDescr add constraint FKFCCD0A4AA03A58DB foreign key (cfEventId) references cfEvent (cfEventId);
alter table cfEventKeyw add constraint FK63018A8F189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfEventKeyw add constraint FK63018A8FA03A58DB foreign key (cfEventId) references cfEvent (cfEventId);
alter table cfEventName add constraint FK6302D722189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfEventName add constraint FK6302D722A03A58DB foreign key (cfEventId) references cfEvent (cfEventId);
alter table cfEvent_Class add constraint FKC904C310DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfEvent_Class add constraint FKC904C310A03A58DB foreign key (cfEventId) references cfEvent (cfEventId);
alter table cfEvent_Event add constraint FKC9258C32DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfEvent_Event add constraint FKC9258C32D4562869 foreign key (cfEventId2) references cfEvent (cfEventId);
alter table cfEvent_Event add constraint FKC9258C32D4562868 foreign key (cfEventId1) references cfEvent (cfEventId);
alter table cfEvent_Fund add constraint FKFE3B762DDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfEvent_Fund add constraint FKFE3B762DB798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfEvent_Fund add constraint FKFE3B762DA03A58DB foreign key (cfEventId) references cfEvent (cfEventId);
alter table cfEvent_Fund add constraint FKFE3B762D1D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfEvent_Indic add constraint FKC95A42D1DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfEvent_Indic add constraint FKC95A42D160EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfEvent_Indic add constraint FKC95A42D1A03A58DB foreign key (cfEventId) references cfEvent (cfEventId);
alter table cfEvent_Meas add constraint FKFE3E6732DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfEvent_Meas add constraint FKFE3E6732A03A58DB foreign key (cfEventId) references cfEvent (cfEventId);
alter table cfEvent_Meas add constraint FKFE3E673258267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfEvent_Medium add constraint FK6842A8DD2D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfEvent_Medium add constraint FK6842A8DDDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfEvent_Medium add constraint FK6842A8DDA03A58DB foreign key (cfEventId) references cfEvent (cfEventId);
alter table cfExpSkillsDescr add constraint FK31F4C5C5189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfExpSkillsDescr add constraint FK31F4C5C51E5DC530 foreign key (cfExpSkillsId) references cfExpSkills (cfExpSkillsId);
alter table cfExpSkillsKeyw add constraint FK9E86F3B4189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfExpSkillsKeyw add constraint FK9E86F3B41E5DC530 foreign key (cfExpSkillsId) references cfExpSkills (cfExpSkillsId);
alter table cfExpSkillsName add constraint FK9E884047189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfExpSkillsName add constraint FK9E8840471E5DC530 foreign key (cfExpSkillsId) references cfExpSkills (cfExpSkillsId);
alter table cfExpSkills_Class add constraint FK38D476F5DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfExpSkills_Class add constraint FK38D476F51E5DC530 foreign key (cfExpSkillsId) references cfExpSkills (cfExpSkillsId);
alter table cfFacilDescr add constraint FKE1911959189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfFacilDescr add constraint FKE19119595C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfFacilKeyw add constraint FKFF07DDA0189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfFacilKeyw add constraint FKFF07DDA05C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfFacilName add constraint FKFF092A33189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfFacilName add constraint FKFF092A335C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfFacil_Class add constraint FK7CC295E1DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfFacil_Class add constraint FK7CC295E15C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfFacil_Equip add constraint FK7CE15499DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfFacil_Equip add constraint FK7CE154995C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfFacil_Equip add constraint FK7CE154997FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfFacil_Event add constraint FK7CE35F03DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfFacil_Event add constraint FK7CE35F03A03A58DB foreign key (cfEventId) references cfEvent (cfEventId);
alter table cfFacil_Event add constraint FK7CE35F035C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfFacil_Facil add constraint FK7CE7E2948C8A13F4 foreign key (cfFacilId2) references cfFacil (cfFacilId);
alter table cfFacil_Facil add constraint FK7CE7E294DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfFacil_Facil add constraint FK7CE7E2948C8A13F3 foreign key (cfFacilId1) references cfFacil (cfFacilId);
alter table cfFacil_Fund add constraint FKE2FF853CDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfFacil_Fund add constraint FKE2FF853CB798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfFacil_Fund add constraint FKE2FF853C5C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfFacil_Fund add constraint FKE2FF853C1D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfFacil_Indic add constraint FK7D1815A2DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfFacil_Indic add constraint FK7D1815A260EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfFacil_Indic add constraint FK7D1815A25C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfFacil_Meas add constraint FKE3027641DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfFacil_Meas add constraint FKE30276415C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfFacil_Meas add constraint FKE302764158267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfFacil_Medium add constraint FK2C3F302C2D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfFacil_Medium add constraint FK2C3F302CDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfFacil_Medium add constraint FK2C3F302C5C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfFacil_PAddr add constraint FK7D6644EADFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfFacil_PAddr add constraint FK7D6644EAE7AA0FF1 foreign key (cfPAddrId) references cfPAddr (cfPAddrId);
alter table cfFacil_PAddr add constraint FK7D6644EA5C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfFacil_Srv add constraint FKFF10B0A0DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfFacil_Srv add constraint FKFF10B0A0119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfFacil_Srv add constraint FKFF10B0A05C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfFedId add constraint FK272110DDDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfFedId add constraint FK272110DD59E8DC44 foreign key (cfClassSchemeId) references cfClassScheme (cfClassSchemeId);
alter table cfFedId_Class add constraint FK3ED55376DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfFedId_Class add constraint FK3ED553766EC03D14 foreign key (cfFedIdId) references cfFedId (cfFedIdId);
alter table cfFund add constraint FKAEAEB9C81D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfFundDescr add constraint FK57D40719189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfFundDescr add constraint FK57D40719B798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfFundKeyw add constraint FKE1D037E0189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfFundKeyw add constraint FKE1D037E0B798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfFundName add constraint FKE1D18473189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfFundName add constraint FKE1D18473B798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfFund_Class add constraint FKCEDD6021DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfFund_Class add constraint FKCEDD6021B798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfFund_Fund add constraint FK594272FCDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfFund_Fund add constraint FK594272FC5EE4B1DA foreign key (cfFundId1) references cfFund (cfFundId);
alter table cfFund_Fund add constraint FK594272FC5EE4B1DB foreign key (cfFundId2) references cfFund (cfFundId);
alter table cfFund_Indic add constraint FKCF32DFE2DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfFund_Indic add constraint FKCF32DFE260EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfFund_Indic add constraint FKCF32DFE2B798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfFund_Indic add constraint FKCF32DFE21D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfFund_Meas add constraint FK59456401DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfFund_Meas add constraint FK59456401B798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfFund_Meas add constraint FK5945640158267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfFund_Meas add constraint FK594564011D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfGeoBBoxDesc add constraint FK7314FA4889489F1 foreign key (cfGeoBBoxId) references cfGeoBBox (cfGeoBBoxId);
alter table cfGeoBBoxDesc add constraint FK7314FA48189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfGeoBBoxKeyw add constraint FK731829AF89489F1 foreign key (cfGeoBBoxId) references cfGeoBBox (cfGeoBBoxId);
alter table cfGeoBBoxKeyw add constraint FK731829AF189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfGeoBBoxName add constraint FK7319764289489F1 foreign key (cfGeoBBoxId) references cfGeoBBox (cfGeoBBoxId);
alter table cfGeoBBoxName add constraint FK73197642189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfGeoBBox_Class add constraint FK2DF01A3089489F1 foreign key (cfGeoBBoxId) references cfGeoBBox (cfGeoBBoxId);
alter table cfGeoBBox_Class add constraint FK2DF01A30DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfGeoBBox_GeoBBox add constraint FK3AA7A7B2DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfGeoBBox_GeoBBox add constraint FK3AA7A7B2EC8BF73E foreign key (cfGeoBBoxId1) references cfGeoBBox (cfGeoBBoxId);
alter table cfGeoBBox_GeoBBox add constraint FK3AA7A7B2EC8BF73F foreign key (cfGeoBBoxId2) references cfGeoBBox (cfGeoBBoxId);
alter table cfIndicDescr add constraint FK9E6C9F0B189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfIndicDescr add constraint FK9E6C9F0B60EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfIndicKeyw add constraint FK36ABD9AE189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfIndicKeyw add constraint FK36ABD9AE60EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfIndicName add constraint FK36AD2641189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfIndicName add constraint FK36AD264160EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfIndic_Class add constraint FK5B57C66FDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfIndic_Class add constraint FK5B57C66F60EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfIndic_Indic add constraint FK5BAD4630DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfIndic_Indic add constraint FK5BAD4630C579455E foreign key (cfIndicId1) references cfIndic (cfIndicId);
alter table cfIndic_Indic add constraint FK5BAD4630C579455F foreign key (cfIndicId2) references cfIndic (cfIndicId);
alter table cfIndic_Meas add constraint FK9FDDFBF3DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfIndic_Meas add constraint FK9FDDFBF360EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfIndic_Meas add constraint FK9FDDFBF358267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfLangName add constraint FK2F46371C189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfLangName add constraint FK2F46371C269E1F37 foreign key (cfLangCodeOfLangName) references cfLang (cfLangCode);
alter table cfLang_Class add constraint FK91F00C8ADFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfLang_Class add constraint FK91F00C8A189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfMeasDescr add constraint FK5187F134189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfMeasDescr add constraint FK5187F13458267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfMeasKeyw add constraint FK55391E65189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfMeasKeyw add constraint FK55391E6558267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfMeasName add constraint FK553A6AF8189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfMeasName add constraint FK553A6AF858267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfMeas_Class add constraint FKBA6B966DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfMeas_Class add constraint FKBA6B96658267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfMeas_Meas add constraint FK52F94E1CDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfMeas_Meas add constraint FK52F94E1CF8115FF5 foreign key (cfMeasId2) references cfMeas (cfMeasId);
alter table cfMeas_Meas add constraint FK52F94E1CF8115FF4 foreign key (cfMeasId1) references cfMeas (cfMeasId);
alter table cfMediumDescr add constraint FKE874C5292D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfMediumDescr add constraint FKE874C529189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfMediumKeyw add constraint FK5A1777D02D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfMediumKeyw add constraint FK5A1777D0189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfMediumTitle add constraint FKE95813802D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfMediumTitle add constraint FKE9581380189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfMedium_Class add constraint FK525464112D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfMedium_Class add constraint FK52546411DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfMedium_Fund add constraint FKE9E3310C2D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfMedium_Fund add constraint FKE9E3310CDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfMedium_Fund add constraint FKE9E3310CB798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfMedium_Fund add constraint FKE9E3310C1D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfMedium_Indic add constraint FK52A9E3D22D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfMedium_Indic add constraint FK52A9E3D2DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfMedium_Indic add constraint FK52A9E3D260EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfMedium_Meas add constraint FKE9E622112D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfMedium_Meas add constraint FKE9E62211DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfMedium_Meas add constraint FKE9E6221158267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfMedium_Medium add constraint FK8E727FC41F69C64 foreign key (cfMediumId1) references cfMedium (cfMediumId);
alter table cfMedium_Medium add constraint FK8E727FCDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfMedium_Medium add constraint FK8E727FC41F69C65 foreign key (cfMediumId2) references cfMedium (cfMediumId);
alter table cfMetricsDescr add constraint FKFFF30901189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfMetricsDescr add constraint FKFFF30901E1EEFBED foreign key (cfMetricsId) references cfMetrics (cfCMetricsId);
alter table cfMetricsKeyw add constraint FK4A5558F8189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfMetricsKeyw add constraint FK4A5558F8E1EEFBED foreign key (cfMetricsId) references cfMetrics (cfCMetricsId);
alter table cfMetricsName add constraint FK4A56A58B189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfMetricsName add constraint FK4A56A58BE1EEFBED foreign key (cfMetricsId) references cfMetrics (cfCMetricsId);
alter table cfMetrics_Class add constraint FK2A9E9B39DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfMetrics_Class add constraint FK2A9E9B39E1EEFBED foreign key (cfMetricsId) references cfMetrics (cfCMetricsId);
alter table cfOrgUnit add constraint FKD59750A51D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfOrgUnitKeyw add constraint FKA2A8183D189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfOrgUnitKeyw add constraint FKA2A8183D19AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnitName add constraint FKA2A964D0189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfOrgUnitName add constraint FKA2A964D019AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnitResAct add constraint FKA4F170D7189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfOrgUnitResAct add constraint FKA4F170D719AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_Class add constraint FKB93E9D3EDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_Class add constraint FKB93E9D3E19AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_DC add constraint FKD3B31E5970540C76 foreign key (cfDCId) references cfDC (cfDCId);
alter table cfOrgUnit_DC add constraint FKD3B31E5919AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_EAddr add constraint FKB94749BCDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_EAddr add constraint FKB94749BCCCF995D5 foreign key (cfEAddrId) references cfEAddr (cfEaddrId);
alter table cfOrgUnit_EAddr add constraint FKB94749BC19AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_Equip add constraint FKB95D5BF6DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_Equip add constraint FKB95D5BF619AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_Equip add constraint FKB95D5BF61D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfOrgUnit_Equip add constraint FKB95D5BF67FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfOrgUnit_Event add constraint FKB95F6660DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_Event add constraint FKB95F6660A03A58DB foreign key (cfEventId) references cfEvent (cfEventId);
alter table cfOrgUnit_Event add constraint FKB95F666019AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_ExpSkills add constraint FK7BCBCD85DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_ExpSkills add constraint FK7BCBCD8519AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_ExpSkills add constraint FK7BCBCD851E5DC530 foreign key (cfExpSkillsId) references cfExpSkills (cfExpSkillsId);
alter table cfOrgUnit_ExpSkills add constraint FK7BCBCD851D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfOrgUnit_Facil add constraint FKB963E9F1DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_Facil add constraint FKB963E9F15C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfOrgUnit_Facil add constraint FKB963E9F119AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_Facil add constraint FKB963E9F11D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfOrgUnit_Fund add constraint FKB3669E3FDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_Fund add constraint FKB3669E3FB798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfOrgUnit_Fund add constraint FKB3669E3F19AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_Fund add constraint FKB3669E3F1D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfOrgUnit_Indic add constraint FKB9941CFFDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_Indic add constraint FKB9941CFF60EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfOrgUnit_Indic add constraint FKB9941CFF19AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_Meas add constraint FKB3698F44DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_Meas add constraint FKB3698F4458267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfOrgUnit_Meas add constraint FKB3698F4419AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_Medium add constraint FK7F44146F2D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfOrgUnit_Medium add constraint FK7F44146FDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_Medium add constraint FK7F44146F19AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_OrgUnit add constraint FKE95B04CEDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_OrgUnit add constraint FKE95B04CE87285C04 foreign key (cfOrgUnitId2) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_OrgUnit add constraint FKE95B04CE87285C03 foreign key (cfOrgUnitId1) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_PAddr add constraint FKB9E24C47DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_PAddr add constraint FKB9E24C47E7AA0FF1 foreign key (cfPAddrId) references cfPAddr (cfPAddrId);
alter table cfOrgUnit_PAddr add constraint FKB9E24C4719AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_Prize add constraint FKB9F8A7D8DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_Prize add constraint FKB9F8A7D8E0225DCB foreign key (cfPrizeId) references cfPrize (cfPrizeId);
alter table cfOrgUnit_Prize add constraint FKB9F8A7D819AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_ResPat add constraint FK87D2C0DDDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_ResPat add constraint FK87D2C0DD3B234AEE foreign key (cfResPatId) references cfResPat (cfResPatId);
alter table cfOrgUnit_ResPat add constraint FK87D2C0DD19AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_ResProd add constraint FK72859A5DDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_ResProd add constraint FK72859A5D19AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_ResProd add constraint FK72859A5D1D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfOrgUnit_ResProd add constraint FK72859A5D46EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfOrgUnit_ResPubl add constraint FK7285A415DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_ResPubl add constraint FK7285A415973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfOrgUnit_ResPubl add constraint FK7285A41519AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_Srv add constraint FKA2B0EB3DDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfOrgUnit_Srv add constraint FKA2B0EB3D119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfOrgUnit_Srv add constraint FKA2B0EB3D19AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfOrgUnit_Srv add constraint FKA2B0EB3D1D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfPAddr add constraint FK279DA1DE100568E5 foreign key (cfCountryCode) references cfCountry (cfCountryCode);
alter table cfPAddr_Class add constraint FK8EC75FB7DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPAddr_Class add constraint FK8EC75FB7E7AA0FF1 foreign key (cfPAddrId) references cfPAddr (cfPAddrId);
alter table cfPAddr_GeoBBox add constraint FKC2C3A77989489F1 foreign key (cfGeoBBoxId) references cfGeoBBox (cfGeoBBoxId);
alter table cfPAddr_GeoBBox add constraint FKC2C3A779DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPAddr_GeoBBox add constraint FKC2C3A779E7AA0FF1 foreign key (cfPAddrId) references cfPAddr (cfPAddrId);
alter table cfPersKeyw add constraint FKA9DF0791189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfPersKeyw add constraint FKA9DF079137561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPersName add constraint FKA9E0542437561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPersResInt add constraint FKBA29FA88189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfPersResInt add constraint FKBA29FA8837561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_CV add constraint FKF4F6F479DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_CV add constraint FKF4F6F4797FDC2B95 foreign key (cfCVId) references cfCV (cfCVId);
alter table cfPers_CV add constraint FKF4F6F47937561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_Class add constraint FKCE770792DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_Class add constraint FKCE77079237561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_Country add constraint FK13099730DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_Country add constraint FK1309973037561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_Country add constraint FK13099730100568E5 foreign key (cfCountryCode) references cfCountry (cfCountryCode);
alter table cfPers_DC add constraint FKF4F6F485DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_DC add constraint FKF4F6F48537561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_DC add constraint FKF4F6F48570540C76 foreign key (cfDCId) references cfDC (cfDCId);
alter table cfPers_EAddr add constraint FKCE7FB410DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_EAddr add constraint FKCE7FB410CCF995D5 foreign key (cfEAddrId) references cfEAddr (cfEaddrId);
alter table cfPers_EAddr add constraint FKCE7FB410D8B7ABBC foreign key (cfPersonId) references cfPers (cfPersId);
alter table cfPers_Equip add constraint FKCE95C64ADFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_Equip add constraint FKCE95C64A37561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_Equip add constraint FKCE95C64A1D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfPers_Equip add constraint FKCE95C64A7FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfPers_Event add constraint FKCE97D0B4DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_Event add constraint FKCE97D0B4A03A58DB foreign key (cfEventId) references cfEvent (cfEventId);
alter table cfPers_Event add constraint FKCE97D0B437561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_ExpSkills add constraint FKF5EEDD9DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_ExpSkills add constraint FKF5EEDD937561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_ExpSkills add constraint FKF5EEDD91E5DC530 foreign key (cfExpSkillsId) references cfExpSkills (cfExpSkillsId);
alter table cfPers_ExpSkills add constraint FKF5EEDD91D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfPers_Facil add constraint FKCE9C5445DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_Facil add constraint FKCE9C54455C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfPers_Facil add constraint FKCE9C544537561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_Facil add constraint FKCE9C54451D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfPers_Fund add constraint FK930D996BDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_Fund add constraint FK930D996BB798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfPers_Fund add constraint FK930D996B37561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_Fund add constraint FK930D996B1D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfPers_Indic add constraint FKCECC8753DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_Indic add constraint FKCECC875360EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfPers_Indic add constraint FKCECC875337561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_Lang add constraint FK93100894DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_Lang add constraint FK93100894189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfPers_Lang add constraint FK9310089437561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_Meas add constraint FK93108A70DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_Meas add constraint FK93108A7037561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_Meas add constraint FK93108A7058267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfPers_Medium add constraint FK1118F49B2D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfPers_Medium add constraint FK1118F49BDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_Medium add constraint FK1118F49B37561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_OrgUnit add constraint FK92222A22DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_OrgUnit add constraint FK92222A2237561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_OrgUnit add constraint FK92222A2219AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfPers_PAddr add constraint FKCF1AB69BDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_PAddr add constraint FKCF1AB69BE7AA0FF1 foreign key (cfPAddrId) references cfPAddr (cfPAddrId);
alter table cfPers_PAddr add constraint FKCF1AB69B37561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_Pers add constraint FK9311E99CDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_Pers add constraint FK9311E99CC4611126 foreign key (cfPersId1) references cfPers (cfPersId);
alter table cfPers_Pers add constraint FK9311E99CC4611127 foreign key (cfPersId2) references cfPers (cfPersId);
alter table cfPers_Prize add constraint FKCF31122CDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_Prize add constraint FKCF31122CE0225DCB foreign key (cfPrizeId) references cfPrize (cfPrizeId);
alter table cfPers_Prize add constraint FKCF31122C3D641B95 foreign key (cfPersId) references cfPrize (cfPrizeId);
alter table cfPers_Prize add constraint FKCF31122C37561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_Qual add constraint FK931297F5DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_Qual add constraint FK931297F5DC11428B foreign key (cfQualId) references cfQual (cfQualId);
alter table cfPers_Qual add constraint FK931297F5D982C672 foreign key (cfPersId) references cfQual (cfQualId);
alter table cfPers_Qual add constraint FK931297F537561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_ResPat add constraint FK19A7A109DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_ResPat add constraint FK19A7A1093B234AEE foreign key (cfResPatId) references cfResPat (cfResPatId);
alter table cfPers_ResPat add constraint FK19A7A10937561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_ResProd add constraint FK1B4CBFB1DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_ResProd add constraint FK1B4CBFB137561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_ResProd add constraint FK1B4CBFB11D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfPers_ResProd add constraint FK1B4CBFB146EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfPers_ResPubl add constraint FK1B4CC969DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_ResPubl add constraint FK1B4CC969973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfPers_ResPubl add constraint FK1B4CC96937561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_Srv add constraint FKA9E7DA91DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPers_Srv add constraint FKA9E7DA91119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfPers_Srv add constraint FKA9E7DA9137561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfPers_Srv add constraint FKA9E7DA911D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfPrizeDescr add constraint FK2B99F3D2189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfPrizeDescr add constraint FK2B99F3D2E0225DCB foreign key (cfPrizeId) references cfPrize (cfPrizeId);
alter table cfPrizeKeyw add constraint FK9AD5007189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfPrizeKeyw add constraint FK9AD5007E0225DCB foreign key (cfPrizeId) references cfPrize (cfPrizeId);
alter table cfPrizeName add constraint FK9AE9C9A189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfPrizeName add constraint FK9AE9C9AE0225DCB foreign key (cfPrizeId) references cfPrize (cfPrizeId);
alter table cfPrize_class add constraint FK7597FAA8DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfPrize_class add constraint FK7597FAA8E0225DCB foreign key (cfPrizeId) references cfPrize (cfPrizeId);
alter table cfProjAbstr add constraint FK29D483F0189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfProjAbstr add constraint FK29D483F03D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProjKeyw add constraint FK53F2AC78189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfProjKeyw add constraint FK53F2AC783D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProjTitle add constraint FK2AE373D8189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfProjTitle add constraint FK2AE373D83D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_Class add constraint FK42350EB9DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_Class add constraint FK42350EB93D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_DC add constraint FKAF796BEDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_DC add constraint FKAF796BE3D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_DC add constraint FKAF796BE70540C76 foreign key (cfDCId) references cfDC (cfDCId);
alter table cfProj_Equip add constraint FK4253CD71DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_Equip add constraint FK4253CD713D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_Equip add constraint FK4253CD711D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfProj_Equip add constraint FK4253CD717FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfProj_Event add constraint FK4255D7DBDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_Event add constraint FK4255D7DBA03A58DB foreign key (cfEventId) references cfEvent (cfEventId);
alter table cfProj_Event add constraint FK4255D7DB3D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_Facil add constraint FK425A5B6CDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_Facil add constraint FK425A5B6C5C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfProj_Facil add constraint FK425A5B6C3D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_Facil add constraint FK425A5B6C1D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfProj_Fund add constraint FK2B6E9164DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_Fund add constraint FK2B6E9164B798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfProj_Fund add constraint FK2B6E91643D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_Fund add constraint FK2B6E91641D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfProj_Indic add constraint FK428A8E7ADFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_Indic add constraint FK428A8E7A60EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfProj_Indic add constraint FK428A8E7A3D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_Meas add constraint FK2B718269DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_Meas add constraint FK2B7182693D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_Meas add constraint FK2B71826958267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfProj_Medium add constraint FK151BD2542D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfProj_Medium add constraint FK151BD254DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_Medium add constraint FK151BD2543D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_OrgUnit add constraint FKE7B0389DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_OrgUnit add constraint FKE7B03893D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_OrgUnit add constraint FKE7B038919AE44D2 foreign key (cfOrgUnitId) references cfOrgUnit (cfOrgUnitId);
alter table cfProj_Pers add constraint FK2B72E195DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_Pers add constraint FK2B72E1953D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_Pers add constraint FK2B72E19537561BDD foreign key (cfPersId) references cfPers (cfPersId);
alter table cfProj_Prize add constraint FK42EF1953DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_Prize add constraint FK42EF19533D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_Prize add constraint FK42EF1953E0225DCB foreign key (cfPrizeId) references cfPrize (cfPrizeId);
alter table cfProj_Proj add constraint FK2B7311FCDF6E7DFC foreign key (cfProjId2) references cfProj (cfProjId);
alter table cfProj_Proj add constraint FK2B7311FCDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_Proj add constraint FK2B7311FCDF6E7DFB foreign key (cfProjId1) references cfProj (cfProjId);
alter table cfProj_ResPat add constraint FK1DAA7EC2DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_ResPat add constraint FK1DAA7EC23B234AEE foreign key (cfResPatId) references cfResPat (cfResPatId);
alter table cfProj_ResPat add constraint FK1DAA7EC23D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_ResProd add constraint FK97A59918DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_ResProd add constraint FK97A599183D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_ResProd add constraint FK97A5991846EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfProj_ResPubl add constraint FK97A5A2D0DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_ResPubl add constraint FK97A5A2D0973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfProj_ResPubl add constraint FK97A5A2D03D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_Srv add constraint FK53FB7F78DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfProj_Srv add constraint FK53FB7F78119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfProj_Srv add constraint FK53FB7F783D189920 foreign key (cfProjId) references cfProj (cfProjId);
alter table cfProj_Srv add constraint FK53FB7F781D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfQualDescr add constraint FK14BA8ECFDC11428B foreign key (cfQualId) references cfQual (cfQualId);
alter table cfQualDescr add constraint FK14BA8ECF189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfQualKeyw add constraint FK42BEE16ADC11428B foreign key (cfQualId) references cfQual (cfQualId);
alter table cfQualKeyw add constraint FK42BEE16A189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfQualTitle add constraint FK159DDD26DC11428B foreign key (cfQualId) references cfQual (cfQualId);
alter table cfQualTitle add constraint FK159DDD26189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfQual_class add constraint FKB08ABF4BDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfQual_class add constraint FKB08ABF4BDC11428B foreign key (cfQualId) references cfQual (cfQualId);
alter table cfResPatAbstr add constraint FK45BB0BEA3B234AEE foreign key (cfResPatId) references cfResPat (cfResPatId);
alter table cfResPatAbstr add constraint FK45BB0BEA189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfResPatKeyw add constraint FKE97E3D3E3B234AEE foreign key (cfResPatId) references cfResPat (cfResPatId);
alter table cfResPatKeyw add constraint FKE97E3D3E189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfResPatTitle add constraint FK46C9FBD23B234AEE foreign key (cfResPatId) references cfResPat (cfResPatId);
alter table cfResPatTitle add constraint FK46C9FBD2189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfResPatVersInfo add constraint FKC426EA443B234AEE foreign key (cfResPatId) references cfResPat (cfResPatId);
alter table cfResPatVersInfo add constraint FKC426EA44189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfResPat_Class add constraint FKA31F85FFDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPat_Class add constraint FKA31F85FF3B234AEE foreign key (cfResPatId) references cfResPat (cfResPatId);
alter table cfResPat_Equip add constraint FKA33E44B7DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPat_Equip add constraint FKA33E44B73B234AEE foreign key (cfResPatId) references cfResPat (cfResPatId);
alter table cfResPat_Equip add constraint FKA33E44B77FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfResPat_Facil add constraint FKA344D2B2DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPat_Facil add constraint FKA344D2B23B234AEE foreign key (cfResPatId) references cfResPat (cfResPatId);
alter table cfResPat_Facil add constraint FKA344D2B25C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfResPat_Fund add constraint FK4755195EDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPat_Fund add constraint FK4755195E3B234AEE foreign key (cfResPatId) references cfResPat (cfResPatId);
alter table cfResPat_Fund add constraint FK4755195EB798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfResPat_Fund add constraint FK4755195E1D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfResPat_Indic add constraint FKA37505C0DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPat_Indic add constraint FKA37505C03B234AEE foreign key (cfResPatId) references cfResPat (cfResPatId);
alter table cfResPat_Indic add constraint FKA37505C060EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfResPat_Meas add constraint FK47580A63DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPat_Meas add constraint FK47580A633B234AEE foreign key (cfResPatId) references cfResPat (cfResPatId);
alter table cfResPat_Meas add constraint FK47580A6358267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfResPat_Medium add constraint FKD18043CE2D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfResPat_Medium add constraint FKD18043CEDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPat_Medium add constraint FKD18043CE3B234AEE foreign key (cfResPatId) references cfResPat (cfResPatId);
alter table cfResPat_ResPat add constraint FKDA0EF03CDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPat_ResPat add constraint FKDA0EF03C37E477BE foreign key (cfResPatId2) references cfResPat (cfResPatId);
alter table cfResPat_ResPat add constraint FKDA0EF03C37E477BD foreign key (cfResPatId1) references cfResPat (cfResPatId);
alter table cfResPat_Srv add constraint FKE987103EDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPat_Srv add constraint FKE987103E119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfResPat_Srv add constraint FKE987103E3B234AEE foreign key (cfResPatId) references cfResPat (cfResPatId);
alter table cfResProdDescr add constraint FK8927BE2D189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfResProdDescr add constraint FK8927BE2D46EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfResProdKeyw add constraint FKC25F4E4C189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfResProdKeyw add constraint FKC25F4E4C46EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfResProdName add constraint FKC2609ADF189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfResProdName add constraint FKC2609ADF46EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfResProdVersInfo add constraint FK34DCC452189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfResProdVersInfo add constraint FK34DCC45246EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfResProd_Class add constraint FKC8008B8DDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResProd_Class add constraint FKC8008B8D46EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfResProd_Country add constraint FKD042086BDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResProd_Country add constraint FKD042086B54E1C0D3 foreign key (cfCountryId) references cfCountry (cfCountryCode);
alter table cfResProd_Country add constraint FKD042086B46EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfResProd_Equip add constraint FKC81F4A45DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResProd_Equip add constraint FKC81F4A4546EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfResProd_Equip add constraint FKC81F4A457FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfResProd_Facil add constraint FKC825D840DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResProd_Facil add constraint FKC825D8405C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfResProd_Facil add constraint FKC825D84046EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfResProd_Fund add constraint FK8A962A10DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResProd_Fund add constraint FK8A962A10B798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfResProd_Fund add constraint FK8A962A101D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfResProd_Fund add constraint FK8A962A1046EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfResProd_GeoBBox add constraint FK926135CFDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResProd_GeoBBox add constraint FK926135CFCC6DF387 foreign key (cfGeographicBoundingBoxId) references cfGeoBBox (cfGeoBBoxId);
alter table cfResProd_GeoBBox add constraint FK926135CF46EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfResProd_Indic add constraint FKC8560B4EDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResProd_Indic add constraint FKC8560B4E60EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfResProd_Indic add constraint FKC8560B4E46EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfResProd_Meas add constraint FK8A991B15DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResProd_Meas add constraint FK8A991B1558267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfResProd_Meas add constraint FK8A991B1546EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfResProd_Medium add constraint FK48BFF0002D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfResProd_Medium add constraint FK48BFF000DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResProd_Medium add constraint FK48BFF00046EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfResProd_ResProd add constraint FKD88530ECDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResProd_ResProd add constraint FKD88530ECFE1FD18C foreign key (cfResProdId1) references cfResProd (cfResProdId);
alter table cfResProd_ResProd add constraint FKD88530ECFE1FD18D foreign key (cfResProdId2) references cfResProd (cfResProdId);
alter table cfResProd_Srv add constraint FKC268214CDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResProd_Srv add constraint FKC268214C119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfResProd_Srv add constraint FKC268214C46EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfResPublAbstr add constraint FK1E9565E4973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPublAbstr add constraint FK1E9565E4189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfResPublBiblNote add constraint FKC8471E6F973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPublBiblNote add constraint FKC8471E6F189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfResPublKeyw add constraint FK4B53BC04973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPublKeyw add constraint FK4B53BC04189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfResPublNameAbbrev add constraint FK91BA4019973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPublNameAbbrev add constraint FK91BA4019189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfResPublSubtitle add constraint FK2982F424973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPublSubtitle add constraint FK2982F424189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfResPublTitle add constraint FK1FA455CC973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPublTitle add constraint FK1FA455CC189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfResPublVersInfo add constraint FK2DF3960A973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPublVersInfo add constraint FK2DF3960A189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfResPubl_Cite add constraint FK202DE9EADFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPubl_Cite add constraint FK202DE9EA973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPubl_Cite add constraint FK202DE9EAE615308D foreign key (cfCiteId) references cfCite (cfCiteId);
alter table cfResPubl_Class add constraint FKE5906B45DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPubl_Class add constraint FKE5906B45973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPubl_DC add constraint FKAB065B2DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPubl_DC add constraint FKAB065B2973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPubl_DC add constraint FKAB065B270540C76 foreign key (cfDCId) references cfDC (cfDCId);
alter table cfResPubl_Equip add constraint FKE5AF29FDDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPubl_Equip add constraint FKE5AF29FD973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPubl_Equip add constraint FKE5AF29FD7FC78DD4 foreign key (cfEquipId) references cfEquip (cfEquipId);
alter table cfResPubl_Event add constraint FKE5B13467DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPubl_Event add constraint FKE5B13467973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPubl_Event add constraint FKE5B13467A03A58DB foreign key (cfEventId) references cfEvent (cfEventId);
alter table cfResPubl_Facil add constraint FKE5B5B7F8DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPubl_Facil add constraint FKE5B5B7F8973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPubl_Facil add constraint FKE5B5B7F85C15A0E8 foreign key (cfFacilId) references cfFacil (cfFacilId);
alter table cfResPubl_Fund add constraint FK202F7358DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPubl_Fund add constraint FK202F7358973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPubl_Fund add constraint FK202F7358B798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfResPubl_Fund add constraint FK202F73581D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfResPubl_Indic add constraint FKE5E5EB06DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPubl_Indic add constraint FKE5E5EB06973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPubl_Indic add constraint FKE5E5EB0660EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfResPubl_Meas add constraint FK2032645DDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPubl_Meas add constraint FK2032645D973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPubl_Meas add constraint FK2032645D58267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfResPubl_Medium add constraint FKDD2C07482D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfResPubl_Medium add constraint FKDD2C0748DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPubl_Medium add constraint FKDD2C0748973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPubl_Metrics add constraint FKC93A4350DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPubl_Metrics add constraint FKC93A4350973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPubl_Metrics add constraint FKC93A4350E1EEFBED foreign key (cfMetricsId) references cfMetrics (cfCMetricsId);
alter table cfResPubl_ResPat add constraint FKE5BAB3B6DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPubl_ResPat add constraint FKE5BAB3B6973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPubl_ResPat add constraint FKE5BAB3B63B234AEE foreign key (cfResPatId) references cfResPat (cfResPatId);
alter table cfResPubl_ResProd add constraint FKD19C02A4DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPubl_ResProd add constraint FKD19C02A4973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfResPubl_ResProd add constraint FKD19C02A446EEDC19 foreign key (cfResProdId) references cfResProd (cfResProdId);
alter table cfResPubl_ResPubl add constraint FKD19C0C5C52B4BC92 foreign key (cfResPublId2) references cfResPubl (cfResPublId);
alter table cfResPubl_ResPubl add constraint FKD19C0C5CDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPubl_ResPubl add constraint FKD19C0C5C52B4BC91 foreign key (cfResPublId1) references cfResPubl (cfResPublId);
alter table cfResPubl_Srv add constraint FK4B5C8F04DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfResPubl_Srv add constraint FK4B5C8F04119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfResPubl_Srv add constraint FK4B5C8F04973D478E foreign key (cfResPublId) references cfResPubl (cfResPublId);
alter table cfSrvDescr add constraint FK957CA5CD119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfSrvDescr add constraint FK957CA5CD189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfSrvKeyw add constraint FKA9FEF2AC119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfSrvKeyw add constraint FKA9FEF2AC189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfSrvName add constraint FKAA003F3F119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfSrvName add constraint FKAA003F3F189DA867 foreign key (cfLangCode) references cfLang (cfLangCode);
alter table cfSrv_Class add constraint FK464897EDDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfSrv_Class add constraint FK464897ED119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfSrv_Event add constraint FK4669610FDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfSrv_Event add constraint FK4669610F119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfSrv_Event add constraint FK4669610FA03A58DB foreign key (cfEventId) references cfEvent (cfEventId);
alter table cfSrv_FedId add constraint FK466FB5F517ADF339 foreign key (cfFedId) references cfFedId (cfFedIdId);
alter table cfSrv_FedId add constraint FK466FB5F5DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfSrv_FedId add constraint FK466FB5F5119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfSrv_Fund add constraint FK96EB11B0DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfSrv_Fund add constraint FK96EB11B0119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfSrv_Fund add constraint FK96EB11B0B798AACF foreign key (cfFundId) references cfFund (cfFundId);
alter table cfSrv_Fund add constraint FK96EB11B01D977764 foreign key (cfCurrCode) references cfCurrency (cfCurrCode);
alter table cfSrv_Indic add constraint FK469E17AEDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfSrv_Indic add constraint FK469E17AE119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfSrv_Indic add constraint FK469E17AE60EF2FAF foreign key (cfIndicId) references cfIndic (cfIndicId);
alter table cfSrv_Meas add constraint FK96EE02B5DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfSrv_Meas add constraint FK96EE02B5119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfSrv_Meas add constraint FK96EE02B558267D3 foreign key (cfMeasId) references cfMeas (cfMeasId);
alter table cfSrv_Medium add constraint FK93796FA02D8C1F39 foreign key (cfMediumId) references cfMedium (cfMediumId);
alter table cfSrv_Medium add constraint FK93796FA0DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfSrv_Medium add constraint FK93796FA0119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfSrv_PAddr add constraint FK46EC46F6DFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfSrv_PAddr add constraint FK46EC46F6119BF1C2 foreign key (cfSrvId) references cfSrv (cfSrvId);
alter table cfSrv_PAddr add constraint FK46EC46F6E7AA0FF1 foreign key (cfPAddrId) references cfPAddr (cfPAddrId);
alter table cfSrv_Srv add constraint FKAA07C5ACDFB9C55A foreign key (cfClassId) references cfClass (cfClassId);
alter table cfSrv_Srv add constraint FKAA07C5ACF2858636 foreign key (cfSrvId2) references cfSrv (cfSrvId);
alter table cfSrv_Srv add constraint FKAA07C5ACF2858635 foreign key (cfSrvId1) references cfSrv (cfSrvId);



/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-09-27 11:47:46
