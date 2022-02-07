-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 07, 2022 at 07:35 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.4.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `W_POS_DB`
--

-- --------------------------------------------------------

--
-- Table structure for table `Beer`
--

CREATE TABLE `Beer` (
  `ProductCode` varchar(10) NOT NULL,
  `ProductName` varchar(20) NOT NULL,
  `Quantity` varchar(20) NOT NULL,
  `SellingPrice` varchar(20) NOT NULL,
  `CostPrice` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Beer`
--

INSERT INTO `Beer` (`ProductCode`, `ProductName`, `Quantity`, `SellingPrice`, `CostPrice`) VALUES
('', '', '', '', ''),
('001', 'Black Label', '20', '24', '15'),
('002', 'maluti', '20', '16.80', '11.50'),
('003', 'Castle lager', '20', '18.99', '10.50'),
('004', 'Heineken', '20', '23', '16'),
('005', 'Castle Lite', '20', '25', '16');

-- --------------------------------------------------------

--
-- Table structure for table `Ciders`
--

CREATE TABLE `Ciders` (
  `ProductCode` varchar(10) DEFAULT NULL,
  `ProductName` varchar(20) DEFAULT NULL,
  `Quantinty` int(11) DEFAULT NULL,
  `SellingPrice` float DEFAULT NULL,
  `CostPrice` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Ciders`
--

INSERT INTO `Ciders` (`ProductCode`, `ProductName`, `Quantinty`, `SellingPrice`, `CostPrice`) VALUES
('002', 'Flying Fish', 2, 27, 18),
('100', 'Flying Fish', 25, 27, 19),
('101', 'Savannah', 24, 30, 21);

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `UserID` varchar(20) NOT NULL,
  `Password` varchar(26) NOT NULL,
  `Privilege` varchar(20) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Surname` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`UserID`, `Password`, `Privilege`, `Name`, `Surname`) VALUES
('0000', '0000', 'admin', 'admin', 'admin'),
('0001', '0001', 'Manager', 'Thabo', 'Mahlomaholo'),
('1001', '1001', 'Assistant clerk', 'Mohau', 'Ntlhola'),
('1002', '1002', 'Clerck', 'Tebello', 'Molati'),
('1004', '1004', 'Clerk', 'Maoela', 'Mahase');

-- --------------------------------------------------------

--
-- Table structure for table `Wine`
--

CREATE TABLE `Wine` (
  `ProductCode` varchar(20) DEFAULT NULL,
  `ProductName` text DEFAULT NULL,
  `Quantity` int(20) NOT NULL,
  `SellingPrice` float NOT NULL,
  `CostPrice` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `Wine`
--

INSERT INTO `Wine` (`ProductCode`, `ProductName`, `Quantity`, `SellingPrice`, `CostPrice`) VALUES
('006', 'Drostyhof', 3, 150, 78);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Beer`
--
ALTER TABLE `Beer`
  ADD UNIQUE KEY `ProductCode` (`ProductCode`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD UNIQUE KEY `UserID` (`UserID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
