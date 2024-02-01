-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               8.0.26 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for evidencija_knjiga
DROP DATABASE IF EXISTS `evidencija_knjiga`;
CREATE DATABASE IF NOT EXISTS `evidencija_knjiga` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `evidencija_knjiga`;

-- Dumping structure for table evidencija_knjiga.author
DROP TABLE IF EXISTS `author`;
CREATE TABLE IF NOT EXISTS `author` (
  `author_id` int unsigned NOT NULL AUTO_INCREMENT,
  `first_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `last_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`author_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

-- Dumping data for table evidencija_knjiga.author: ~4 rows (approximately)
/*!40000 ALTER TABLE `author` DISABLE KEYS */;
INSERT INTO `author` (`author_id`, `first_name`, `last_name`) VALUES
	(1, 'Jo', 'Nesbø'),
	(3, 'Viktor', 'Frankl'),
	(5, 'Miodrag', 'Živković'),
	(6, 'Nebojša', 'Bačanin Džakula'),
	(7, 'Eva', 'Tuba'),
	(8, 'Aleksandar', 'Puškin');
/*!40000 ALTER TABLE `author` ENABLE KEYS */;

-- Dumping structure for table evidencija_knjiga.book
DROP TABLE IF EXISTS `book`;
CREATE TABLE IF NOT EXISTS `book` (
  `book_id` int unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(100) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `publication_year` int unsigned NOT NULL,
  `copies_owned` int unsigned NOT NULL,
  `language` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `pages` int unsigned NOT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

-- Dumping data for table evidencija_knjiga.book: ~2 rows (approximately)
/*!40000 ALTER TABLE `book` DISABLE KEYS */;
INSERT INTO `book` (`book_id`, `title`, `publication_year`, `copies_owned`, `language`, `pages`) VALUES
	(1, 'Hodejegerne', 2008, 5, 'norveški', 272),
	(2, 'Lovci na glave', 2008, 2, 'srpski', 272),
	(4, 'Programski jezici, Veb servisi i napredno Java programiranje u Spring okruženju', 2019, 3, 'srpski', 439),
	(5, 'Evgenije Onjegin', 2020, 6, 'srpski', 306),
	(6, 'Man\'s Search for Meaning', 2019, 3, 'engleski', 121);
/*!40000 ALTER TABLE `book` ENABLE KEYS */;

-- Dumping structure for table evidencija_knjiga.book_author
DROP TABLE IF EXISTS `book_author`;
CREATE TABLE IF NOT EXISTS `book_author` (
  `book_author_id` int unsigned NOT NULL AUTO_INCREMENT,
  `book_id` int unsigned NOT NULL,
  `author_id` int unsigned NOT NULL,
  PRIMARY KEY (`book_author_id`),
  KEY `fk_book_author_book_id` (`book_id`),
  KEY `fk_book_author_author_id` (`author_id`),
  CONSTRAINT `fk_book_author_author_id` FOREIGN KEY (`author_id`) REFERENCES `author` (`author_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_book_author_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

-- Dumping data for table evidencija_knjiga.book_author: ~4 rows (approximately)
/*!40000 ALTER TABLE `book_author` DISABLE KEYS */;
INSERT INTO `book_author` (`book_author_id`, `book_id`, `author_id`) VALUES
	(1, 1, 1),
	(2, 2, 1),
	(3, 4, 5),
	(4, 4, 6),
	(5, 4, 7),
	(6, 5, 8),
	(7, 6, 3);
/*!40000 ALTER TABLE `book_author` ENABLE KEYS */;

-- Dumping structure for table evidencija_knjiga.book_category
DROP TABLE IF EXISTS `book_category`;
CREATE TABLE IF NOT EXISTS `book_category` (
  `book_category_id` int unsigned NOT NULL AUTO_INCREMENT,
  `book_id` int unsigned NOT NULL,
  `category_id` int unsigned NOT NULL,
  PRIMARY KEY (`book_category_id`),
  KEY `fk_book_category_book_id` (`book_id`),
  KEY `fk_book_category_category_id` (`category_id`),
  CONSTRAINT `fk_book_category_book_id` FOREIGN KEY (`book_id`) REFERENCES `book` (`book_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk_book_category_category_id` FOREIGN KEY (`category_id`) REFERENCES `category` (`category_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

-- Dumping data for table evidencija_knjiga.book_category: ~4 rows (approximately)
/*!40000 ALTER TABLE `book_category` DISABLE KEYS */;
INSERT INTO `book_category` (`book_category_id`, `book_id`, `category_id`) VALUES
	(1, 2, 7),
	(2, 1, 7),
	(3, 4, 1),
	(4, 4, 4),
	(5, 5, 6),
	(6, 6, 9);
/*!40000 ALTER TABLE `book_category` ENABLE KEYS */;

-- Dumping structure for table evidencija_knjiga.category
DROP TABLE IF EXISTS `category`;
CREATE TABLE IF NOT EXISTS `category` (
  `category_id` int unsigned NOT NULL AUTO_INCREMENT,
  `category_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `category_name` (`category_name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8_unicode_ci;

-- Dumping data for table evidencija_knjiga.category: ~8 rows (approximately)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` (`category_id`, `category_name`) VALUES
	(9, 'Biografija'),
	(2, 'Dečje knjige'),
	(1, 'Domaće knjige'),
	(3, 'Društvene nauke'),
	(6, 'Klasik'),
	(4, 'Prirodne nauke'),
	(7, 'Triler'),
	(5, 'Umetnost');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
