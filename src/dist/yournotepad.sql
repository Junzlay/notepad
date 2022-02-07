-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 02, 2021 at 01:56 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `yournotepad`
--

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

CREATE TABLE `notes` (
  `noteID` int(11) NOT NULL,
  `userID` int(255) NOT NULL,
  `noteTitle` varchar(255) NOT NULL,
  `noteContent` longtext NOT NULL,
  `status` int(1) NOT NULL,
  `isFavorite` int(1) NOT NULL,
  `date_created` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `notes`
--

INSERT INTO `notes` (`noteID`, `userID`, `noteTitle`, `noteContent`, `status`, `isFavorite`, `date_created`) VALUES
(57, 21, 'ken', 'yohh..wazzupssss ', 0, 1, 'June 01, 2021 at 09:59 PM'),
(58, 22, 'animate', 'animation is the best of all', 0, 1, 'May 30, 2021 at 03:17 PM'),
(59, 23, 'undefined', 'hey, I just want to share to all of you how grateful I am today.', 0, 0, 'May 30, 2021 at 04:35 PM'),
(60, 23, 'another one', 'another one', 0, 1, 'May 30, 2021 at 04:56 PM'),
(61, 25, 'goliath', 'david vs goliath\n', 0, 0, 'May 31, 2021 at 08:11 AM'),
(62, 23, 'java today', 'yess', 0, 1, 'May 31, 2021 at 10:37 AM');

-- --------------------------------------------------------

--
-- Table structure for table `shared`
--

CREATE TABLE `shared` (
  `sharedID` int(11) NOT NULL,
  `noteID` int(255) NOT NULL,
  `sharesTo` varchar(255) DEFAULT NULL,
  `status` int(11) NOT NULL,
  `message` varchar(255) DEFAULT NULL,
  `requestby` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `shared`
--

INSERT INTO `shared` (`sharedID`, `noteID`, `sharesTo`, `status`, `message`, `requestby`) VALUES
(44, 59, 'ken', 0, NULL, NULL),
(45, 59, 'kerwien', 0, NULL, NULL),
(46, 57, 'jake', 1, NULL, NULL),
(47, 57, 'kerwien', 1, NULL, NULL),
(48, 60, 'ken', 0, '', NULL),
(49, 60, 'kerwien', 0, NULL, NULL),
(52, 59, 'david', 0, NULL, NULL),
(54, 62, 'david', 0, NULL, NULL),
(58, 60, 'jake', 3, 'pa edita ko plsss hahaha', 'ken');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `username`, `email`, `password`) VALUES
(21, 'ken', 'ken@test', 'ken'),
(22, 'kerwien', 'kerwien@test', 'kerwien'),
(23, 'jake', 'jake@test', 'jake'),
(25, 'david', 'david@test', 'david');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `notes`
--
ALTER TABLE `notes`
  ADD PRIMARY KEY (`noteID`);

--
-- Indexes for table `shared`
--
ALTER TABLE `shared`
  ADD PRIMARY KEY (`sharedID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `notes`
--
ALTER TABLE `notes`
  MODIFY `noteID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=63;

--
-- AUTO_INCREMENT for table `shared`
--
ALTER TABLE `shared`
  MODIFY `sharedID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=59;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
