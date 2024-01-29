-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 30, 2021 at 05:03 PM
-- Server version: 8.0.1-dmr-log
-- PHP Version: 7.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `century_inventions`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `all_inventors` ()  NO SQL
Select * from inventor$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `inventions_updates` (IN `uyear` INT(10), IN `iid` INT(10))  NO SQL
UPDATE invention SET year = uyear WHERE invention_id=iid$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `invention_update` ()  NO SQL
UPDATE invention SET year = iyear WHERE invention_id=invid$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `application`
--

CREATE TABLE `application` (
  `application_id` int(10) UNSIGNED NOT NULL,
  `application_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `application`
--

INSERT INTO `application` (`application_id`, `application_name`) VALUES
(1, 'Air conditioners'),
(2, 'Air pollution'),
(3, 'Airplanes'),
(4, 'Bullets'),
(5, 'Car engines'),
(6, 'Chainsaws'),
(7, 'Chromatography'),
(8, 'Clothes washer'),
(9, 'Digital pens'),
(10, 'Electrostatic smoke precipitators'),
(11, 'Geiger counters'),
(12, 'Jet engines'),
(13, 'LCD TV'),
(14, 'Lithium-ion batteries'),
(15, 'Mass spectrometers'),
(16, 'Microwave ovens'),
(17, 'Neoprene-Kevlar'),
(18, 'Neoprene-Nomex'),
(19, 'Neoprene-Nylon'),
(20, 'Neoprene-Wetsuits'),
(21, 'OCR'),
(22, 'pH meters'),
(23, 'Photoelectric cells'),
(24, 'Plastics'),
(25, 'Radio'),
(26, 'Refrigerators'),
(27, 'Robots'),
(28, 'Space rockets'),
(29, 'Television');

-- --------------------------------------------------------

--
-- Table structure for table `application_list`
--

CREATE TABLE `application_list` (
  `application_list_id` int(10) UNSIGNED NOT NULL,
  `application_id` int(10) UNSIGNED NOT NULL,
  `invention_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `application_list`
--

INSERT INTO `application_list` (`application_list_id`, `application_id`, `invention_id`) VALUES
(1, 25, 1),
(2, 3, 2),
(3, 3, 2),
(4, 23, 3),
(5, 6, 4),
(6, 1, 5),
(7, 7, 6),
(8, 24, 7),
(9, 8, 8),
(10, 2, 9),
(11, 10, 9),
(12, 5, 10),
(13, 22, 11),
(14, 12, 11),
(15, 14, 12),
(16, 11, 13),
(17, 28, 14),
(18, 15, 15),
(19, 29, 16),
(20, 13, 17),
(21, 13, 17),
(22, 4, 18),
(23, 28, 18),
(24, 21, 19),
(25, 16, 20),
(26, 27, 21),
(27, 1, 22),
(28, 26, 23),
(29, 29, 24),
(30, 13, 24),
(31, 9, 25),
(32, 17, 26),
(33, 18, 26),
(34, 19, 26),
(35, 20, 26);

-- --------------------------------------------------------

--
-- Table structure for table `attribution_type`
--

CREATE TABLE `attribution_type` (
  `attribution_type_id` int(10) UNSIGNED NOT NULL,
  `attribution_type` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `attribution_claim` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `invention_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `attribution_type`
--

INSERT INTO `attribution_type` (`attribution_type_id`, `attribution_type`, `attribution_claim`, `invention_id`) VALUES
(1, 'infividual', 'general', 1),
(2, 'group', 'general', 2),
(3, 'individual ', 'general', 3),
(4, 'individual ', 'null', 4),
(5, 'individual ', 'general', 5),
(6, 'individual ', 'general', 6),
(7, 'individual ', 'general', 7),
(8, 'individual ', 'null', 8),
(9, 'individual ', 'general', 9),
(10, 'individual ', 'general', 10),
(11, 'group', 'general', 11),
(12, 'individual ', 'general', 12),
(13, 'individual ', 'general', 13),
(14, 'individual ', 'general', 14),
(15, 'individual ', 'general', 15),
(16, 'individual ', 'general', 16),
(17, 'individual ', 'general', 17),
(18, 'individual ', 'general', 18),
(19, 'group', 'general', 19),
(20, 'individual', 'general', 20),
(21, 'individual', 'general', 21),
(22, 'individual', 'general', 22),
(23, 'group', 'general', 23),
(24, 'individual', 'general', 24),
(25, 'group', 'general', 25),
(26, 'individual', 'general', 26);

-- --------------------------------------------------------

--
-- Table structure for table `changelog`
--

CREATE TABLE `changelog` (
  `changelog_id` int(10) UNSIGNED NOT NULL,
  `date_created` date NOT NULL,
  `date_modified` date NOT NULL,
  `invention_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `changelog`
--

INSERT INTO `changelog` (`changelog_id`, `date_created`, `date_modified`, `invention_id`) VALUES
(1, '2019-01-16', '2021-08-03', 1),
(2, '2019-09-27', '2019-09-27', 2),
(3, '2019-10-02', '2019-10-02', 3),
(4, '2019-10-18', '2019-10-18', 4),
(5, '2019-10-23', '2019-10-23', 5),
(6, '2019-10-24', '2019-10-27', 6),
(7, '2019-10-29', '2019-10-29', 7),
(8, '2019-11-07', '2019-11-07', 8),
(9, '2019-11-11', '2019-11-11', 9),
(10, '2019-11-11', '2019-11-11', 10),
(11, '2019-12-09', '2019-12-09', 11),
(12, '2019-12-26', '2019-12-29', 12),
(13, '2019-12-30', '2019-12-30', 13),
(14, '2019-12-31', '2019-12-31', 14),
(15, '2020-01-01', '2020-01-01', 15),
(16, '2020-01-01', '2020-01-05', 16),
(17, '2020-01-02', '2020-01-02', 17),
(18, '2020-01-10', '2020-01-14', 18),
(19, '2020-01-22', '2020-01-22', 19),
(20, '2020-01-27', '2020-02-11', 20),
(21, '2020-01-30', '2020-01-30', 21),
(22, '2020-01-30', '2020-01-30', 22),
(23, '2020-02-07', '2020-02-07', 23),
(24, '2020-02-10', '2020-02-10', 24),
(25, '2020-02-11', '2020-02-11', 25),
(26, '2020-02-20', '2020-02-22', 26),
(27, '2020-03-03', '2020-03-03', 27),
(28, '2020-03-05', '2020-03-05', 28),
(29, '2020-03-12', '2020-03-12', 29),
(30, '2020-03-19', '2020-03-19', 30),
(31, '2020-03-31', '2020-03-31', 31),
(32, '2020-04-14', '2020-04-14', 32),
(33, '2020-04-22', '2020-04-22', 33),
(34, '2020-04-22', '2020-04-22', 34),
(35, '2020-04-23', '2020-06-11', 35),
(36, '2020-05-04', '2020-06-13', 36),
(37, '2020-05-11', '2020-05-11', 37),
(38, '2020-05-13', '2020-05-13', 38),
(39, '2020-05-13', '2020-05-13', 39),
(40, '2020-05-18', '2020-05-18', 40),
(41, '2020-05-21', '2020-05-21', 41),
(42, '2020-05-25', '2020-05-25', 42),
(43, '2020-05-29', '2020-07-12', 43),
(44, '2020-06-03', '2020-06-03', 44),
(45, '2020-06-04', '2020-06-04', 45),
(46, '2020-06-15', '2020-06-15', 46),
(47, '2020-06-18', '2020-06-18', 47),
(48, '2020-06-26', '2020-06-26', 48),
(49, '2020-06-29', '2020-06-29', 49),
(50, '2020-06-29', '2020-07-23', 50),
(51, '2020-07-03', '2020-07-03', 51),
(52, '2020-07-08', '2020-07-08', 52),
(53, '2020-07-14', '2020-07-14', 53),
(54, '2020-07-23', '2020-07-23', 54),
(55, '2020-08-03', '2020-08-03', 55),
(56, '2020-08-19', '2020-08-19', 56),
(57, '2020-08-20', '2020-08-20', 57),
(58, '2020-08-21', '2020-08-21', 58),
(59, '2020-08-21', '2020-08-21', 59),
(60, '2020-08-27', '2020-08-27', 60),
(61, '2020-08-27', '2020-08-27', 61),
(62, '2020-09-03', '2020-09-03', 62),
(63, '2020-09-08', '2020-09-08', 63),
(64, '2020-09-15', '2020-09-15', 64),
(65, '2020-10-05', '2020-10-05', 65),
(66, '2020-10-07', '2020-10-07', 66),
(67, '2020-10-12', '2020-10-12', 67),
(68, '2020-10-14', '2020-10-23', 68),
(69, '2020-10-30', '2020-10-30', 69),
(70, '2020-11-05', '2020-11-05', 70),
(71, '2020-11-27', '2020-11-27', 71),
(72, '2020-12-09', '2020-12-09', 72),
(73, '2020-12-09', '2020-12-09', 73),
(74, '2020-12-11', '2020-12-11', 74),
(75, '2020-12-25', '2020-12-25', 75),
(76, '2021-01-01', '2021-01-01', 76),
(77, '2021-01-05', '2021-01-05', 77),
(78, '2021-02-02', '2021-02-02', 78),
(79, '2021-02-05', '2021-02-07', 79),
(80, '2021-02-05', '2021-02-05', 80),
(81, '2021-03-09', '2021-03-09', 81),
(82, '2021-03-22', '2021-03-22', 82),
(83, '2021-04-02', '2021-04-02', 83),
(84, '2021-04-07', '2021-04-07', 84),
(85, '2021-04-14', '2021-04-18', 85),
(86, '2021-04-15', '2021-04-15', 86),
(87, '2021-04-22', '2021-04-22', 87),
(88, '2021-04-23', '2021-04-23', 88),
(89, '2021-04-26', '2021-04-26', 89),
(90, '2021-05-19', '2021-06-16', 90),
(91, '2021-05-19', '2021-05-19', 91),
(92, '2021-05-21', '2021-05-21', 92),
(93, '2021-05-27', '2021-05-27', 93),
(94, '2021-05-28', '2021-05-28', 94),
(95, '2021-06-03', '2021-06-25', 95),
(96, '2021-06-04', '2021-06-04', 96),
(97, '2021-06-07', '2021-06-07', 97),
(98, '2021-06-10', '2021-06-10', 98),
(99, '2021-06-22', '2021-06-22', 99),
(100, '2021-06-22', '2021-06-27', 100),
(101, '2021-06-30', '2021-06-30', 101),
(102, '2021-07-02', '2021-07-11', 102),
(103, '2021-07-12', '2021-07-12', 103);

-- --------------------------------------------------------

--
-- Table structure for table `discipline`
--

CREATE TABLE `discipline` (
  `discipline_id` int(10) UNSIGNED NOT NULL,
  `discipline_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `description` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `discipline`
--

INSERT INTO `discipline` (`discipline_id`, `discipline_name`, `description`) VALUES
(1, 'Astronomy', 'Astronomy studies the space outside the Earth''s atmosphere'),
(2, 'Biochemistry', 'Biochemistry is the branch of science concerned with the chemical and physico-chemical processes and substances that occur within living organisms'),
(3, 'Botany', 'Botany studies the physiology, structure, genetics, ecology, distribution, classification, and economic importance of plants.'),
(4, 'Chemistry', 'Chemistry, the science that deals with the properties, composition, and structure of substances, the transformations they undergo, and the energy that is released or absorbed during these processes.'),
(5, 'Earth science', 'Earth science is the branch of science dealing with the physical constitution of the earth and its atmosphere.'),
(6, 'Electrical engineering', 'Electrical engineering is an engineering discipline concerned with the study, design and application of equipment, devices and systems which use electricity.'),
(7, 'Engineering', 'Engineering is an engineering discipline concerned with the study, design and application of equipment, devices and systems '),
(8, 'Information technology science', 'ICT science is the study or use of systems - especially computers and telecommunications - for storing, retrieving, and sending information.'),
(9, 'Journalism-writer', 'Journalism the activity or profession of writing for newspapers, magazines, or news websites or preparing news to be broadcast.'),
(10, 'Mathematical sciences', 'Mathematical science studies how the universe works.'),
(11, 'Microbiology', 'Microbiology is the'),
(12, 'Nuclear physics', 'Nuclear physics studies the physics of atomic nuclei and their interactions, especially in the generation of nuclear energy.'),
(13, 'Physics', 'Physical sciences are concerned with the study of inanimate natural objects, including physics, chemistry, astronomy, and related subjects.'),
(14, 'Aerospace engineering', 'Aerospace engineering which deals with the development of aircraft and spacecraft.'),
(15, 'Aviation engineering', 'Aviation engineering is a'),
(16, 'Industrial engineering', 'Industrial engineering is a branch of engineering concerned with the design and operation of industrial processes'),
(17, 'Inventor', 'A person who invents things as an occupation');

--
-- Triggers `discipline`
--
DELIMITER $$
CREATE TRIGGER `check_discipline` BEFORE INSERT ON `discipline` FOR EACH ROW begin
declare msg varchar(255);
if (new.discipline_name IN( SELECT discipline_name FROM discipline))
then set msg = "THis discipline already exists in the database";
SIGNAL SQLSTATE '45000' set message_text = msg;
end if;
end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `discipline_list`
--

CREATE TABLE `discipline_list` (
  `discipline_list_id` int(10) UNSIGNED NOT NULL,
  `discipline_id` int(10) UNSIGNED NOT NULL,
  `inventor_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `discipline_list`
--

INSERT INTO `discipline_list` (`discipline_list_id`, `discipline_id`, `inventor_id`) VALUES
(1, 6, 1),
(2, 15, 2),
(3, 15, 3),
(4, 13, 4),
(5, 7, 4),
(6, 7, 5),
(7, 7, 6),
(8, 3, 7),
(9, 4, 8),
(10, 6, 9),
(11, 13, 10),
(12, 4, 10),
(13, 16, 11),
(14, 4, 12),
(15, 13, 13),
(16, 4, 13),
(17, 13, 14),
(18, 4, 14),
(19, 13, 15),
(20, 7, 16),
(21, 4, 17),
(22, 13, 17),
(23, 6, 18),
(24, 6, 19),
(25, 14, 20),
(26, 7, 21),
(27, 7, 22),
(28, 13, 23),
(29, 6, 23),
(30, 9, 24),
(31, 17, 24),
(32, 4, 25),
(33, 6, 26),
(34, 13, 27),
(35, 7, 27),
(36, 7, 28),
(37, 4, 29),
(38, 9, 30),
(39, 17, 30),
(40, 4, 31);

-- --------------------------------------------------------

--
-- Table structure for table `invention`
--

CREATE TABLE `invention` (
  `invention_id` int(10) UNSIGNED NOT NULL,
  `invention_description` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `year` smallint(4) NOT NULL,
  `discipline_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `invention`
--

INSERT INTO `invention` (`invention_id`, `invention_description`, `year`, `discipline_id`) VALUES
(1, 'radio waves across Atlantic Ocean', 1901, 6),
(2, 'engine-powered plane', 1903, 15),
(3, 'photoelectric effect', 1905, 13),
(4, 'chainsaw', 1905, 7),
(5, 'air-conditioner', 1906, 7),
(6, 'chromatography.', 1906, 4),
(7, 'Bakelite (synthetic plastic', 1907, 4),
(8, 'electric clothes washer', 1907, 6),
(9, 'electrostatic smoke precipitator (smokestack pollution scrubber)', 1006, 13),
(10, 'Ford Model T car', 1908, 7),
(11, 'glass electrode', 1009, 4),
(12, 'lithium-ion rechargeable batteries (chemestry)', 1912, 4),
(13, 'radioactivity detector', 1912, 13),
(14, ' influential ideas on building space rockets', 1916, 7),
(15, 'mass spectrometer ', 1019, 4),
(16, 'mechanical television', 1020, 6),
(17, 'modern electronic television', 1920, 6),
(18, 'liquid fuel space rocket', 1920, 14),
(19, 'optical character recognition (OCR) ', 1920, 7),
(20, 'magnetron', 1920, 13),
(21, 'coined the word robot', 1921, 9),
(22, 'coolant chemicals (air-conditionersand refrigerators)', 1928, 4),
(23, 'electric refrigerator', 1928, 6),
(24, 'televison', 1930, 7),
(25, 'modern ballpoint pen', 1930, 4),
(26, 'neoprene (synthetic rubber)', 1930, 4),
(27, 'oversees radar development', 1930, 1),
(28, 'electronic pH meter', 1930, 1),
(29, 'xenon flash lamp for high-speed photography.', 1931, 1),
(30, 'shape memory effect in a gold-cadmium alloy', 1932, 1),
(31, 'magnetic reed switch', 1936, 1),
(32, 'principle of photocopying (xerography)', 1938, 1),
(33, 'nonstick plastic coating called Teflon.', 1938, 1),
(34, 'builds first practical helicopter', 1939, 1),
(35, 'compact magnetron for use in airplane radar navigation systems', 1939, 1),
(36, 'first nuclear chain reactor', 1942, 1),
(37, 'desk-sized memory store called Memexlater used in WWW', 1945, 1),
(38, 'comminication satelites', 1945, 1),
(39, 'transistor', 1947, 1),
(40, 'patent barcodes', 1949, 1),
(41, 'microwave laser', 1950, 1),
(42, 'various renewable technologies', 1950, 1),
(43, 'flywheels', 1950, 1),
(44, 'microwave oven', 1950, 1),
(45, 'automobile air bags', 1952, 1),
(46, 'pioneers fiber optics', 1954, 1),
(47, 'TV remote control', 1955, 1),
(48, 'commercial nuclear power', 1956, 1),
(49, 'Sputnik space satellites', 1957, 1),
(50, 'fiber-optic gastroscope', 1957, 1),
(51, 'integrated circuit', 1958, 1),
(52, 'first computer-aided design (CAD) system.', 1959, 1),
(53, 'snowmobile', 1960, 1),
(54, 'LED (light-emitting diode)', 1962, 1),
(55, 'e-ommerce introduction with airplane e-tickect reservation', 1964, 1),
(56, 'Defibrillators', 1965, 1),
(57, 'super-strong plastic called Kevla', 1966, 1),
(58, 'DRAM', 1966, 1),
(59, 'vacuum fluorescent display (VFD)', 1967, 1),
(60, ' molecular beam epitaxy (MBE).', 1968, 1),
(61, 'first solar power station', 1969, 1),
(62, 'waterproof material called GORE-TEX', 1969, 1),
(63, 'electronic book concept called Dynabook', 1969, 1),
(64, 'CCD (charge-coupled device)', 1969, 1),
(65, 'astronauts walk on he Moon', 1969, 1),
(66, 'computer mouse', 1968, 1),
(67, 'compact disk', 1967, 1),
(68, 'electronic ink', 1971, 1),
(69, 'single-chip computer or microprocessor', 1971, 1),
(70, 'first handheld cellphone (mobile phone)', 1973, 1),
(71, 'linking computers together that he names Ethernet.', 1973, 1),
(72, 'First grocery-store purchase of an item coded with a barcode.', 1974, 1),
(73, 'public-key cryptography', 1975, 1),
(74, 'public-key cryptography', 1975, 1),
(75, 'Apple I', 1976, 1),
(76, 'bagless, cyclonic vacuum cleaner.', 1980, 1),
(77, 'Sony Walkman, the first truly portable player for recorded music', 1980, 1),
(78, 'IBM releases its own affordable personal computer (PC)', 1981, 1),
(79, ' Space Shuttle makes its maiden voyage', 1981, 1),
(80, 'laser eye surgery for removing cataracts', 1981, 1),
(81, ' patent for flash memory', 1981, 1),
(82, 'quantum dots', 1981, 1),
(83, 'compact CDs', 1983, 1),
(84, 'quantum logic gates for a universal quantum computer', 1985, 1),
(85, ' MEGA 1, believed to be the world''s first radio-controlled wristwatch.', 1990, 1),
(86, 'first version of Linux', 1991, 1),
(87, 'an algorithm to factor numbers with a quantum computer that would require as few as six qubits', 1994, 1),
(88, 'VoIP', 1994, 1),
(89, ' eBay auction website is launched', 1995, 1),
(90, ' agreement to make Wi-Fi a worldwide standard for wireless Internet', 1997, 1),
(91, 'MP3payer', 2001, 1),
(92, 'energy-absorbing D3O plastic', 2001, 1),
(93, 'Wikipedia online encyclopaedia', 2001, 1),
(94, 'BitTorrent file-sharing.', 2001, 1),
(95, 'Roomba', 2002, 1),
(96, 'graphene', 2004, 1),
(97, 'low-cost laptop for developing countries called OLPC', 2005, 1),
(98, 'Kindle electronic book', 2007, 1),
(99, 'touchscreen cellphone called the iPhon', 2007, 1),
(100, 'touchscreen tablet computer, the iPad', 2010, 1),
(101, '3D TV starts to become widley available', 2010, 1),
(102, 'announces "hyperloop" a giant, pneumatic tube transport system', 2013, 1),
(103, 'building miniature machines out of molecules', 2015, 1),
(105, 'Self Cleaning Surfaces', 2019, 4),
(106, 'self cleaning kitchens', 2021, 4);

--
-- Triggers `invention`
--
DELIMITER $$
CREATE TRIGGER `check_future_date` BEFORE INSERT ON `invention` FOR EACH ROW begin declare msg varchar(255); 
 if(new.year > YEAR(current_date))
    then set msg = "Future dates are not allowed"; SIGNAL SQLSTATE '45000' set message_text = msg; end if; end
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `inventions_1030s`
--
CREATE TABLE `inventions_1030s` (
`invention_id` int(10) unsigned
,`invention_description` varchar(255)
,`year` smallint(4)
,`discipline_id` int(10) unsigned
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `inventions_1930s`
--
CREATE TABLE `inventions_1930s` (
`invention_id` int(10) unsigned
,`invention_description` varchar(255)
,`year` smallint(4)
,`discipline_id` int(10) unsigned
);

-- --------------------------------------------------------

--
-- Table structure for table `invention_list`
--

CREATE TABLE `invention_list` (
  `invention_list_id` int(10) UNSIGNED NOT NULL,
  `inventor_id` int(10) UNSIGNED NOT NULL,
  `invention_id` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `invention_list`
--

INSERT INTO `invention_list` (`invention_list_id`, `inventor_id`, `invention_id`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 3, 2),
(4, 4, 3),
(5, 5, 4),
(6, 6, 5),
(7, 7, 6),
(8, 8, 7),
(9, 9, 8),
(10, 10, 9),
(11, 11, 10),
(12, 12, 11),
(13, 13, 11),
(14, 14, 12),
(15, 15, 13),
(16, 16, 14),
(17, 17, 15),
(18, 18, 16),
(19, 19, 17),
(20, 20, 18),
(21, 21, 19),
(22, 22, 19),
(23, 23, 20),
(24, 24, 21),
(25, 25, 22),
(26, 26, 23),
(27, 27, 23),
(28, 28, 24),
(29, 29, 25),
(30, 30, 25),
(31, 31, 26);

-- --------------------------------------------------------

--
-- Table structure for table `inventor`
--

CREATE TABLE `inventor` (
  `inventor_id` int(10) UNSIGNED NOT NULL,
  `inventor_name` varchar(80) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nationality` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `inventor`
--

INSERT INTO `inventor` (`inventor_id`, `inventor_name`, `nationality`) VALUES
(1, 'Guglielmo Marconi ', 'Italian'),
(2, 'Wilbur Wright', 'American'),
(3, 'Orville Wright ', 'American'),
(4, 'Albert Einstein ', 'American'),
(5, 'Samuel J Bens', 'American'),
(6, 'Willis Carrier', 'American'),
(7, 'Mikhail Tswett', 'Russian-Italian'),
(8, 'Leo Baekeland', 'Belgian'),
(9, 'Alva Fisher', 'American'),
(10, 'Frederick Gardner Cottrell ', 'American'),
(11, 'Henry ford', 'American'),
(12, 'Fritz Haber ', 'German'),
(13, 'Zygmunt Klemensiewicz', 'German'),
(14, 'Gilbert Lewis', 'American'),
(15, 'Hans Geiger', 'German'),
(16, 'Robert Hutchings Goddard', 'American'),
(17, 'Francis Aston', 'English'),
(18, 'John Logie Baird ', 'Scottish'),
(19, 'Philo T. Farnsworth', 'American'),
(20, 'Robert Goddard', 'American'),
(21, 'Gustav Tauschek ', 'German'),
(22, 'Paul Handel', 'American'),
(23, 'Albert W. Hull ', 'American'),
(24, 'Karel Capek ', 'Czech'),
(25, 'Thomas Midgley, Jr.', 'American'),
(26, 'Frank Whittle ', 'British'),
(27, 'Hans Pabst von Ohain ', 'German'),
(28, 'Peter Goldmark ', 'Hungarian-American'),
(29, 'Georg Biro ', 'Hungarian-Argentinan'),
(30, 'Laszlo  Biro ', 'Hungarian-Argentinian'),
(31, 'Wallace Carothers', 'American');

-- --------------------------------------------------------

--
-- Structure for view `inventions_1030s`
--
DROP TABLE IF EXISTS `inventions_1030s`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `inventions_1030s`  AS  select `invention`.`invention_id` AS `invention_id`,`invention`.`invention_description` AS `invention_description`,`invention`.`year` AS `year`,`invention`.`discipline_id` AS `discipline_id` from `invention` where (`invention`.`year` between 1930 and 1939) ;

-- --------------------------------------------------------

--
-- Structure for view `inventions_1930s`
--
DROP TABLE IF EXISTS `inventions_1930s`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `inventions_1930s`  AS  select `invention`.`invention_id` AS `invention_id`,`invention`.`invention_description` AS `invention_description`,`invention`.`year` AS `year`,`invention`.`discipline_id` AS `discipline_id` from `invention` where (`invention`.`year` between 1930 and 1939) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `application`
--
ALTER TABLE `application`
  ADD PRIMARY KEY (`application_id`);

--
-- Indexes for table `application_list`
--
ALTER TABLE `application_list`
  ADD PRIMARY KEY (`application_list_id`),
  ADD KEY `fk_appliction_id_idx` (`application_id`),
  ADD KEY `fk_invention_id_idx` (`invention_id`);

--
-- Indexes for table `attribution_type`
--
ALTER TABLE `attribution_type`
  ADD PRIMARY KEY (`attribution_type_id`),
  ADD KEY `fk_invention_id2_idx` (`invention_id`);

--
-- Indexes for table `changelog`
--
ALTER TABLE `changelog`
  ADD PRIMARY KEY (`changelog_id`),
  ADD KEY `fk_invention_id3_idx` (`invention_id`);

--
-- Indexes for table `discipline`
--
ALTER TABLE `discipline`
  ADD PRIMARY KEY (`discipline_id`);

--
-- Indexes for table `discipline_list`
--
ALTER TABLE `discipline_list`
  ADD PRIMARY KEY (`discipline_list_id`),
  ADD KEY `fk_discipline_id_idx` (`discipline_id`),
  ADD KEY `fk_inventor_id_idx` (`inventor_id`);

--
-- Indexes for table `invention`
--
ALTER TABLE `invention`
  ADD PRIMARY KEY (`invention_id`),
  ADD KEY `fk_discipline_id2_idx` (`discipline_id`);

--
-- Indexes for table `invention_list`
--
ALTER TABLE `invention_list`
  ADD PRIMARY KEY (`invention_list_id`),
  ADD KEY `fk_inventor_id2_idx` (`inventor_id`),
  ADD KEY `fk_invention_id4_idx` (`invention_id`);

--
-- Indexes for table `inventor`
--
ALTER TABLE `inventor`
  ADD PRIMARY KEY (`inventor_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `application`
--
ALTER TABLE `application`
  MODIFY `application_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `application_list`
--
ALTER TABLE `application_list`
  MODIFY `application_list_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;
--
-- AUTO_INCREMENT for table `attribution_type`
--
ALTER TABLE `attribution_type`
  MODIFY `attribution_type_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `changelog`
--
ALTER TABLE `changelog`
  MODIFY `changelog_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;
--
-- AUTO_INCREMENT for table `discipline`
--
ALTER TABLE `discipline`
  MODIFY `discipline_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `discipline_list`
--
ALTER TABLE `discipline_list`
  MODIFY `discipline_list_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
--
-- AUTO_INCREMENT for table `invention`
--
ALTER TABLE `invention`
  MODIFY `invention_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=107;
--
-- AUTO_INCREMENT for table `invention_list`
--
ALTER TABLE `invention_list`
  MODIFY `invention_list_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT for table `inventor`
--
ALTER TABLE `inventor`
  MODIFY `inventor_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `application_list`
--
ALTER TABLE `application_list`
  ADD CONSTRAINT `fk_appliction_id` FOREIGN KEY (`application_id`) REFERENCES `application` (`application_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_invention_id` FOREIGN KEY (`invention_id`) REFERENCES `invention` (`invention_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `attribution_type`
--
ALTER TABLE `attribution_type`
  ADD CONSTRAINT `fk_invention_id2` FOREIGN KEY (`invention_id`) REFERENCES `invention` (`invention_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `changelog`
--
ALTER TABLE `changelog`
  ADD CONSTRAINT `fk_invention_id3` FOREIGN KEY (`invention_id`) REFERENCES `invention` (`invention_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `discipline_list`
--
ALTER TABLE `discipline_list`
  ADD CONSTRAINT `fk_discipline_id` FOREIGN KEY (`discipline_id`) REFERENCES `discipline` (`discipline_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_inventor_id` FOREIGN KEY (`inventor_id`) REFERENCES `inventor` (`inventor_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `invention`
--
ALTER TABLE `invention`
  ADD CONSTRAINT `fk_discipline_id2` FOREIGN KEY (`discipline_id`) REFERENCES `discipline` (`discipline_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `invention_list`
--
ALTER TABLE `invention_list`
  ADD CONSTRAINT `fk_invention_id4` FOREIGN KEY (`invention_id`) REFERENCES `invention` (`invention_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_inventor_id2` FOREIGN KEY (`inventor_id`) REFERENCES `inventor` (`inventor_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
