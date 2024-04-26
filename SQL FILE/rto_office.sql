-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 05, 2023 at 06:22 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rto_office`
--

-- --------------------------------------------------------

--
-- Table structure for table `city`
--

CREATE TABLE `city` (
  `name` varchar(20) NOT NULL,
  `id` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `city`
--

INSERT INTO `city` (`name`, `id`) VALUES
('Bardoli', 19),
('Vadodara', 6),
('Ahmedabad', 1),
('Ahmedabad East', 27),
('Amreli', 14),
('Anand', 23),
('Arvalli', 31),
('Bavla', 38),
('Bharuch', 16),
('Bhavnagar', 4),
('Botad', 33),
('Chhotaudepur', 34),
('Dahod', 20),
('Dang Aahwa', 30),
('Devbhumi Dwarka', 37),
('Gandhinagar', 18),
('Gir Somnath', 32),
('Godhara', 17),
('Himmatnagar', 9),
('Jamnagar', 10),
('Junagadh', 11),
('Kuchh', 12),
('Mahisagar', 35),
('Mehsana', 2),
('Morbi', 36),
('Nadiad', 7),
('Navsari', 21),
('Palanpur', 8),
('Patan', 24),
('Porbandar', 25),
('Rajkot', 3),
('Rajpipla', 22),
('Surat', 5),
('Surendranagar', 13),
('Valsad', 15),
('Vyara', 26);

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

CREATE TABLE `registration` (
  `number_plate` varchar(50) NOT NULL,
  `owner_name` varchar(50) NOT NULL,
  `vehicle_name` varchar(50) NOT NULL,
  `vehicle_color` varchar(50) NOT NULL,
  `vehicle_type` varchar(50) NOT NULL,
  `fines` double NOT NULL,
  `insurance` varchar(20) NOT NULL,
  `puc` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `owner_phone_no` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `registration`
--

INSERT INTO `registration` (`number_plate`, `owner_name`, `vehicle_name`, `vehicle_color`, `vehicle_type`, `fines`, `insurance`, `puc`, `password`, `owner_phone_no`) VALUES
('GJ 8 NI 0001', 'nishit', 'Range Rover sport', 'white', 'car', 0, '14/07/2025', '5/08/2023', 'Nishit1234$', '1234');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `city`
--
ALTER TABLE `city`
  ADD PRIMARY KEY (`name`);

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`number_plate`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
