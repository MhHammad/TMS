-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: localhost    Database: tms
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `phone_no` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone_no` (`phone_no`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'Deepali','d@gmail.com','1234','1234567891'),(2,'Hammad','h@gmail.com','12345','9876543219');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `cust_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(30) NOT NULL,
  `phone_no` varchar(10) NOT NULL,
  `city` varchar(40) NOT NULL,
  `pincode` int NOT NULL,
  `primary_addressv` varchar(255) DEFAULT NULL,
  `state` varchar(20) DEFAULT NULL,
  `country` varchar(40) DEFAULT NULL,
  `h_id` int DEFAULT NULL,
  `plan_package` varchar(255) DEFAULT NULL,
  `plan_type` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cust_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone_no` (`phone_no`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (31,'Viplav Sirsikar','viplavsirsikar22@gmail.com','vip@123','9753134689','Jabalpur',482002,'Plot No.13, \nChandrika Heritage Colony Lamti, Karmeta','Madhya Pradesh','India',NULL,NULL,NULL),(32,'Nilkanth Sirsikar','nilkanthsirsikar@gmail.com','nil@123','9425672390','Jabalpur',482002,'Plot No.13,\nChandrika Heritage Colony Lamti, Karmeta','Madhya Pradesh','India',NULL,NULL,NULL),(33,'ABC-1 XYZ','abc-1@gmail.com','abc@123','9448132390','Jabalpur',482002,'Plot No.13, \nChandrika Heritage Colony Lamti, Karmeta','Madhya Pradesh','India',NULL,NULL,NULL),(34,'ABC-2 XYZ','abc-2@gmail.com','abc@123','93571390','Mumbai',482002,'Plot No.13, \nChandrika Heritage Colony Lamti, Karmeta','Maharashtra','India',NULL,NULL,NULL),(35,'ABC-3 XYZ','abc-3@gmail.com','abc@123','942574610','Pune',482002,'Plot No.13, \nChandrika Heritage Colony Lamti, Karmeta','Maharashtra','India',NULL,NULL,NULL),(36,'ABC-4 XYZ','abc-4@gmail.com','abc@123','926657613','Jabalpur',482002,'Plot No.13, \nChandrika Heritage Colony Lamti, Karmeta','Madhya Pradesh','India',NULL,NULL,NULL);
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `home_maker`
--

DROP TABLE IF EXISTS `home_maker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `home_maker` (
  `hm_id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  `password` varchar(30) NOT NULL,
  `phone_no` varchar(10) NOT NULL,
  `primary_address` varchar(40) DEFAULT NULL,
  `city` varchar(80) NOT NULL,
  `state` varchar(30) DEFAULT NULL,
  `pincode` int NOT NULL,
  `country` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`hm_id`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `phone_no` (`phone_no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `home_maker`
--

LOCK TABLES `home_maker` WRITE;
/*!40000 ALTER TABLE `home_maker` DISABLE KEYS */;
INSERT INTO `home_maker` VALUES (1,'ABC-5 XYZ','abc-5@gmail.com','abc@123','874634390','A13, Heritage Colony, Karmeta','Pune','Maharashtra',482002,'India'),(2,'ABC-6 XYZ','abc-6@gmail.com','abc@123','725475390','A14, Heritage Colony, Karmeta','Mumbai','Maharashtra',482003,'India'),(3,'ABC-7 XYZ','abc-7@gmail.com','abc@123','9185381538','A15, Heritage Colony, Karmeta','Indore','Bhopal',482004,'India'),(4,'ABC-8 XYZ','abc-8@gmail.com','abc@123','9815656715','A16, Heritage Colony, Karmeta','Delhi','New Delhi',482005,'India'),(5,'ABC-9 XYZ','abc-9@gmail.com','abc@123','9765712711','A17, Heritage Colony, Karmeta','Nashik','Maharashtra',482006,'India'),(6,'ABC-10 XYZ','abc-10@gmail.com','abc@123','7817186528','A18, Heritage Colony, Karmeta','Pune','Maharashtra',482007,'India');
/*!40000 ALTER TABLE `home_maker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `order_amount_paise` varchar(255) DEFAULT NULL,
  `customer_id` int NOT NULL,
  `date_time` datetime(6) DEFAULT NULL,
  `home_maker_id` int NOT NULL,
  `order_id` varchar(255) DEFAULT NULL,
  `payment_id` varchar(255) DEFAULT NULL,
  `receipt` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-08-04 23:18:57
