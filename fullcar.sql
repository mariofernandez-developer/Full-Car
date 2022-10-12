/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 8.0.18 : Database - fullcar
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`fullcar` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `fullcar`;

/*Table structure for table `authorities_users` */

DROP TABLE IF EXISTS `authorities_users`;

CREATE TABLE `authorities_users` (
  `user_id` bigint(20) NOT NULL,
  `authority_id` bigint(20) NOT NULL,
  PRIMARY KEY (`user_id`,`authority_id`),
  KEY `FK1hk335nyb5icwqy64y2mhov2v` (`authority_id`),
  CONSTRAINT `FK1hk335nyb5icwqy64y2mhov2v` FOREIGN KEY (`authority_id`) REFERENCES `authority` (`id`),
  CONSTRAINT `FKc4eanbpu2l39uxbju4u2fm2f1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `authorities_users` */

insert  into `authorities_users`(`user_id`,`authority_id`) values (1,1),(1,2),(2,2);

/*Table structure for table `authority` */

DROP TABLE IF EXISTS `authority`;

CREATE TABLE `authority` (
  `id` bigint(20) NOT NULL,
  `authority` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `authority` */

insert  into `authority`(`id`,`authority`) values (1,'ROLE_ADMIN'),(2,'ROLE_USER');

/*Table structure for table `carrito` */

DROP TABLE IF EXISTS `carrito`;

CREATE TABLE `carrito` (
  `pk` bigint(20) NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `total` double DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pk`),
  KEY `FK9d06e5wu8grcqjes0mf2ekn7c` (`user_id`),
  CONSTRAINT `FK9d06e5wu8grcqjes0mf2ekn7c` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `carrito` */

/*Table structure for table `categoria` */

DROP TABLE IF EXISTS `categoria`;

CREATE TABLE `categoria` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `accesorios` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `activo` bit(1) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `repuestos_originales` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `respuestos_genericos` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `categoria` */

/*Table structure for table `detalle_compra` */

DROP TABLE IF EXISTS `detalle_compra`;

CREATE TABLE `detalle_compra` (
  `pk` bigint(20) NOT NULL,
  `cantidad` bigint(20) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `total` double DEFAULT NULL,
  `carrito_pk` bigint(20) DEFAULT NULL,
  `producto_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`pk`),
  KEY `FKmn1o4m4ncelvdal3tvou6alg1` (`carrito_pk`),
  KEY `FKr6qgt3x215hdq7hmp32ui755t` (`producto_id`),
  CONSTRAINT `FKmn1o4m4ncelvdal3tvou6alg1` FOREIGN KEY (`carrito_pk`) REFERENCES `carrito` (`pk`),
  CONSTRAINT `FKr6qgt3x215hdq7hmp32ui755t` FOREIGN KEY (`producto_id`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `detalle_compra` */

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values (1);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `cantidad` bigint(20) DEFAULT NULL,
  `descripcion` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `importado` bit(1) DEFAULT NULL,
  `marca` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `modelo` int(11) DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `precio` float DEFAULT NULL,
  `fk_categoria` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6i0ille9qx9phe1kwk6swwes` (`fk_categoria`),
  CONSTRAINT `FK6i0ille9qx9phe1kwk6swwes` FOREIGN KEY (`fk_categoria`) REFERENCES `categoria` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `product` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dni` int(11) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `nombre` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`apellido`,`dni`,`enabled`,`nombre`,`password`,`username`) values (1,NULL,NULL,'',NULL,'$2a$04$rXrKbKI/ohp/SExaKwoaYemAMmxRIdbUs263Nt/x9HwuVg4.sqQHK','admin'),(2,NULL,NULL,'',NULL,'$2a$04$rXrKbKI/ohp/SExaKwoaYemAMmxRIdbUs263Nt/x9HwuVg4.sqQHK','user');

/*Table structure for table `user_producto` */

DROP TABLE IF EXISTS `user_producto`;

CREATE TABLE `user_producto` (
  `user_id` bigint(20) NOT NULL,
  `product_id` bigint(20) NOT NULL,
  UNIQUE KEY `UK_9bgn236j7xuwcricwtrnrwl29` (`product_id`),
  KEY `FKmsscv582g60yykbdg2td7xj8y` (`user_id`),
  CONSTRAINT `FK44e30v7sgbikf17o7i7rbhdq1` FOREIGN KEY (`product_id`) REFERENCES `product` (`id`),
  CONSTRAINT `FKmsscv582g60yykbdg2td7xj8y` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `user_producto` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
