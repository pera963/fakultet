-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 16, 2022 at 11:11 PM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fakultet`
--

-- --------------------------------------------------------

--
-- Table structure for table `predmet`
--

CREATE TABLE `predmet` (
  `IDPredmet` int(100) NOT NULL,
  `NazivPredmeta` varchar(100) NOT NULL,
  `OpisPredmeta` varchar(100) NOT NULL,
  `BrojCasova` int(100) NOT NULL,
  `ImeProfesora` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `predmet`
--

INSERT INTO `predmet` (`IDPredmet`, `NazivPredmeta`, `OpisPredmeta`, `BrojCasova`, `ImeProfesora`) VALUES
(1, 'Mtematika_1', 'funkcije,linearne jednačine,diferencijalne jednačine,integrali', 120, 'prof. dr. Miladin krsmanović'),
(2, 'Hemija_1', 'periodni sistem elemenata,kiseline,baze,soli', 110, 'prof.dr.Vera Šćepanović'),
(3, 'Programiranje', 'Programski jezik Java,', 115, 'prof. dr.Laslo Klaus'),
(4, 'Fizika_1', 'mehanika,optika,gravitacija,elektrotehnika', 110, 'prof.dr.Damjana Simić'),
(5, 'Organska hemija', 'fenoli,benzoli,benzeni,šećeri', 130, 'prof.dr. Tadić'),
(6, 'OOP', 'Java rogramski jezik,Laslo klaus zbirka', 90, 'prof.ing.Sava Balašević'),
(7, 'Biologija', 'peprati,plaktoni,bakterije,virusi', 70, 'Obradović biljana'),
(8, 'Fizičko', 'gimnastika ,trčanje na 100,50,30 metara\nruomet,fudbal', 45, 'Đorđe Stojaković');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `IDStudent` int(11) NOT NULL,
  `Ime` varchar(100) NOT NULL,
  `Prezime` varchar(100) NOT NULL,
  `Telefon` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`IDStudent`, `Ime`, `Prezime`, `Telefon`) VALUES
(1, 'Radomir', 'Samardžić', '060-777-555'),
(2, 'Dragoljub', 'Samardžić', '060-888-999'),
(3, 'Petar', 'Samardžić', '011-558-997'),
(4, 'Sonja', 'Samardžić', '060-445-774'),
(5, 'Željko ', 'Josipović', '069-887-556'),
(6, 'Zoran', 'Tomović', '063-778-665');

-- --------------------------------------------------------

--
-- Table structure for table `student_predmet`
--

CREATE TABLE `student_predmet` (
  `ID` int(11) NOT NULL,
  `IDPredmet` int(11) NOT NULL,
  `IDStudent` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student_predmet`
--

INSERT INTO `student_predmet` (`ID`, `IDPredmet`, `IDStudent`) VALUES
(1, 1, 1),
(2, 3, 1),
(3, 3, 2),
(4, 6, 2),
(5, 8, 5),
(6, 5, 3);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `predmet`
--
ALTER TABLE `predmet`
  ADD PRIMARY KEY (`IDPredmet`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`IDStudent`);

--
-- Indexes for table `student_predmet`
--
ALTER TABLE `student_predmet`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `predmet`
--
ALTER TABLE `predmet`
  MODIFY `IDPredmet` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `IDStudent` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `student_predmet`
--
ALTER TABLE `student_predmet`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
