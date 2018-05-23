-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: fdb21.awardspace.net
-- Generation Time: May 23, 2018 at 11:53 AM
-- Server version: 5.7.20-log
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `2732514_compumatica`
--

-- --------------------------------------------------------

--
-- Table structure for table `Alergenos`
--

CREATE TABLE `Alergenos` (
  `NombreAlergeno` varchar(45) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Contener`
--

CREATE TABLE `Contener` (
  `Ingredientes_NombreIngrediente` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `Alergenos_NombreAlergeno` varchar(45) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Dieta`
--

CREATE TABLE `Dieta` (
  `Usuario_Correo` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `Usuario_Contrasena` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `Platos_Nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Ingredientes`
--

CREATE TABLE `Ingredientes` (
  `NombreIngrediente` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `Grasas` int(11) NOT NULL,
  `Carbohidratos` int(11) NOT NULL,
  `Proteinas` int(11) NOT NULL,
  `Calorias` int(11) NOT NULL,
  `Precio` int(11) NOT NULL,
  `Platos_Nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Platos`
--

CREATE TABLE `Platos` (
  `Nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `Usuario`
--

CREATE TABLE `Usuario` (
  `Nombre` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `Contrasena` varchar(20) COLLATE latin1_spanish_ci NOT NULL,
  `Edad` int(11) NOT NULL,
  `Correo` varchar(45) COLLATE latin1_spanish_ci NOT NULL,
  `Sexo` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;

--
-- Dumping data for table `Usuario`
--

INSERT INTO `Usuario` (`Nombre`, `Contrasena`, `Edad`, `Correo`, `Sexo`) VALUES
('MARCOS', '123456', 30, 'marquitos@gmail.com', 0),
('MARICARMEN', '654321', 25, 'maricarmen@hotmail.com', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Alergenos`
--
ALTER TABLE `Alergenos`
  ADD PRIMARY KEY (`NombreAlergeno`);

--
-- Indexes for table `Contener`
--
ALTER TABLE `Contener`
  ADD PRIMARY KEY (`Ingredientes_NombreIngrediente`,`Alergenos_NombreAlergeno`),
  ADD KEY `Ingredientes_NombreIngrediente` (`Ingredientes_NombreIngrediente`),
  ADD KEY `Alergenos_NombreAlergeno` (`Alergenos_NombreAlergeno`);

--
-- Indexes for table `Dieta`
--
ALTER TABLE `Dieta`
  ADD PRIMARY KEY (`Usuario_Correo`,`Usuario_Contrasena`,`Platos_Nombre`),
  ADD KEY `Dieta_Usuario_FK` (`Usuario_Contrasena`,`Usuario_Correo`),
  ADD KEY `Dieta_Platos_FK` (`Platos_Nombre`);

--
-- Indexes for table `Ingredientes`
--
ALTER TABLE `Ingredientes`
  ADD PRIMARY KEY (`NombreIngrediente`),
  ADD KEY `Platos_Nombre` (`Platos_Nombre`);

--
-- Indexes for table `Platos`
--
ALTER TABLE `Platos`
  ADD PRIMARY KEY (`Nombre`),
  ADD UNIQUE KEY `Nombre` (`Nombre`);

--
-- Indexes for table `Usuario`
--
ALTER TABLE `Usuario`
  ADD PRIMARY KEY (`Contrasena`,`Correo`),
  ADD UNIQUE KEY `Correo` (`Correo`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Contener`
--
ALTER TABLE `Contener`
  ADD CONSTRAINT `Contener_Alergenos_FK` FOREIGN KEY (`Alergenos_NombreAlergeno`) REFERENCES `Alergenos` (`NombreAlergeno`),
  ADD CONSTRAINT `Contener_Ingredientes_FK` FOREIGN KEY (`Ingredientes_NombreIngrediente`) REFERENCES `Ingredientes` (`NombreIngrediente`);

--
-- Constraints for table `Dieta`
--
ALTER TABLE `Dieta`
  ADD CONSTRAINT `Dieta_Platos_FK` FOREIGN KEY (`Platos_Nombre`) REFERENCES `Platos` (`Nombre`),
  ADD CONSTRAINT `Dieta_Usuario_FK` FOREIGN KEY (`Usuario_Contrasena`,`Usuario_Correo`) REFERENCES `Usuario` (`Contrasena`, `Correo`);

--
-- Constraints for table `Ingredientes`
--
ALTER TABLE `Ingredientes`
  ADD CONSTRAINT `Ingredientes_Platos_FK` FOREIGN KEY (`Platos_Nombre`) REFERENCES `Platos` (`Nombre`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
