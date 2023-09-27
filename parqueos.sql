-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3307
-- Generation Time: Apr 21, 2023 at 06:17 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdprueba`
--

-- --------------------------------------------------------

--
-- Table structure for table `parqueos`
--

CREATE TABLE `parqueos` (
  `Nombre` varchar(50) NOT NULL,
  `Apellidos` varchar(50) NOT NULL,
  `Cedula` int(11) NOT NULL,
  `Horas` int(11) NOT NULL,
  `Monto` double NOT NULL,
  `Ubicación` varchar(50) NOT NULL,
  `Placa` varchar(100) NOT NULL,
  `Telefono` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `parqueos`
--

INSERT INTO `parqueos` (`Nombre`, `Apellidos`, `Cedula`, `Horas`, `Monto`, `Ubicación`, `Placa`, `Telefono`) VALUES
('nicole ', 'hiad ', 1, 6, 3, 'w2 ', 'e3 ', 1),
('Ian', 'La', 123, 2, 2000, 'A1', 'BMN300', 456),
('Ra', 'Mendez', 999, 35, 2000, 'A2', 'Ra@Gmail.com', 720933),
('Diego  ', 'Oporta  ', 113230295, 35, 1500000, 'IT Engeneering  ', 'FromCybertron@gmail.com  ', 72093842);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `parqueos`
--
ALTER TABLE `parqueos`
  ADD PRIMARY KEY (`Cedula`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
