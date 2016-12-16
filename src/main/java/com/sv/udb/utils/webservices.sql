-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-12-2016 a las 01:09:40
-- Versión del servidor: 10.1.13-MariaDB
-- Versión de PHP: 7.0.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `webservices`
--
CREATE DATABASE IF NOT EXISTS `webservices` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `webservices`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `codi` int(11) NOT NULL,
  `carn` varchar(100) DEFAULT NULL,
  `nomb` varchar(100) DEFAULT NULL,
  `apel` varchar(100) DEFAULT NULL,
  `foto` longblob,
  `mail` varchar(100) DEFAULT NULL,
  `grad` varchar(10) DEFAULT NULL,
  `espe` varchar(50) DEFAULT NULL,
  `grup` varchar(10) DEFAULT NULL,
  `secc_acad` varchar(10) DEFAULT NULL,
  `secc_tecn` varchar(10) DEFAULT NULL,
  `reli` varchar(100) DEFAULT NULL,
  `dire` varchar(100) DEFAULT NULL,
  `tele` varchar(9) DEFAULT NULL,
  `luga_naci` varchar(100) DEFAULT NULL,
  `fech_naci` date DEFAULT NULL,
  `fina` varchar(100) DEFAULT NULL,
  `inst_orig` varchar(100) DEFAULT NULL,
  `esta` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`codi`, `carn`, `nomb`, `apel`, `foto`, `mail`, `grad`, `espe`, `grup`, `secc_acad`, `secc_tecn`, `reli`, `dire`, `tele`, `luga_naci`, `fech_naci`, `fina`, `inst_orig`, `esta`) VALUES
(1, '20150001', 'Juan', 'Perez', NULL, 'jp@gmail.com', '2°', 'Sistemas Informáticos', '1', 'A1', 'A', NULL, 'San Salvador', '5555-1234', 'San Salvador', '1990-10-25', 'Padres', 'Instituto Nacional de Olocuilta', 1),
(2, '20130670', 'Kevin', 'Guevara', NULL, 'keid-gt@gmail.com', '2°', 'Diseño', '1', 'A1', 'A', NULL, 'Soyapango', '71717171', 'Soyapango', '1997-06-27', 'Padres', 'Instituto Técnico Ricaldone', 1),
(3, '20130134', 'Alba Vanessa ', 'Urrutia Cruz', NULL, 'vaneurrutia1@gmail.com', '3º', 'Arquitectura', '1', 'A2', 'A', NULL, 'San Salvador', '74152365', 'San Salvador', '1998-01-12', 'Padres', 'Instituto Técnico Ricaldone', 1),
(4, '20130698', 'Keneth Orlando', 'Vasquez Cruz', NULL, 'vasquezcruz95@gmail.com', '3º', 'Informática', '2', 'A4', 'A', NULL, 'Los Planes De Renderos', '78984565', 'San Salvador', '1995-12-15', 'Padres', 'Instituto Técnico Ricaldone', 1),
(5, '20145503', 'Carlos Roberto', 'Marroquin Aparicio', NULL, 'carlos_a@outlook.com', '2º', 'Diseño grafico', '1', 'A3', 'B', NULL, 'San Jacinto', '64159878', 'Zacamil', '1997-10-02', 'Padres', 'Instituto Emiliani', 1),
(6, '20130087', 'Tania Maria', 'Santos Hernandez', NULL, 'MariaSa12@hotmail.com', '1º', 'Electrónica ', '2', 'B1', 'B', NULL, 'San Salvador', '77774565', 'San Miguel', '1996-06-05', 'Padres', 'Instituto Técnico Ricaldone', 1),
(7, '20130732', 'Alvin', 'Baires', NULL, 'alvinbaires@gmail.com', '2°', 'Info', '1', 'A1', 'A', NULL, 'Soyapango', '71717171', 'Soyapango', '1997-06-27', 'Padres', 'Instituto Técnico Ricaldone', 1),
(8, '20160707', 'Tania', 'Guillermina', NULL, 'tania@gmail.com', '9°', NULL, '1', NULL, NULL, NULL, 'San Salvador', '2222-2222', NULL, '2016-11-16', 'Padres', 'Instituto Técnico Ricaldone', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `codi` int(11) NOT NULL,
  `nomb` varchar(100) DEFAULT NULL,
  `apel` varchar(100) DEFAULT NULL,
  `foto` longblob,
  `mail` varchar(100) DEFAULT NULL,
  `tipo_empl` int(1) DEFAULT NULL,
  `tipo_doce` int(1) DEFAULT NULL,
  `grup_guia` varchar(50) DEFAULT NULL,
  `esta` int(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`codi`, `nomb`, `apel`, `foto`, `mail`, `tipo_empl`, `tipo_doce`, `grup_guia`, `esta`) VALUES
(1, 'Rubén', 'Jirafales', NULL, 'jirafales@ricaldone.edu.sv', 1, 1, '2° Informáticos 1', 1),
(2, 'Kelvin Ernesto', 'Carranza Molina', NULL, 'kelvinC1@ricaldone.edu.sv', 4, 1, '3º informática', 1),
(3, 'Susana Carolina', 'De la O Salandra', NULL, 'salandra0@outlook.com', 2, 1, '1º Diseño gráfico ', 1),
(4, 'Bryan Melvin', 'Castro Melendez ', NULL, 'bryanCastro@ricaldone.edu.sv', 3, 1, '2º Arquitectura ', 1),
(5, 'Kevin Raul', 'Rosales Alas', NULL, 'KevinAlas@hotmail.com', 1, 1, '3º Electronica', 1),
(6, 'Gerson', 'Mendoza', '', 'gersonmendoza@ricaldone.edu.sv', 4, NULL, NULL, 1),
(7, 'Alexander', 'Gutierrez', NULL, 'alexgutierrez@ricaldone.edu.sv', 4, NULL, NULL, 1),
(8, 'Jose', 'Mulato', NULL, 'josemulato@ricaldone.edu.sv', 4, NULL, NULL, 1),
(9, 'Oscar', 'Garrest', NULL, 'oscargarrest@ricaldone.edu.sv', 4, NULL, NULL, 1),
(10, 'Israel', 'Hernandez', NULL, 'israelhernandez@ricaldone.edu.sv', 4, NULL, NULL, 1),
(11, 'Eduardo', 'Mendez', NULL, 'eduardomendez@ricaldone.edu.sv', 4, NULL, NULL, 1),
(12, 'Francisco', 'Carranza', NULL, 'franciscocarranza@ricaldone.edu.sv', 4, NULL, NULL, 1),
(13, 'Valeria', 'Ticket', NULL, 'valeriasalas@ricaldone.edu.sv', 4, NULL, NULL, 1),
(14, 'Larry', 'Ticket', NULL, 'larryorellana@ricaldone.edu.sv', 4, NULL, NULL, 1),
(15, 'Ariel', 'Chepito', NULL, 'arizul96@gmail.com', 4, NULL, NULL, 1),
(16, 'Marvin', 'Torres', NULL, 'mtorres@ricaldone.edu.sv', 3, NULL, NULL, 1),
(17, 'Francisco', 'Chávez', NULL, 'chavez@ricaldone.edu.sv', 3, NULL, NULL, 1),
(18, 'Dr. Malito', 'Tamalito', NULL, 'Mr.Malito@PuraMaldad.com', 1, NULL, 'Gobernador de las Tinieblas', 1),
(19, 'Mario ', 'Beltran', NULL, 'mario@ricaldone.edu.sv', 1, NULL, 'Electronica', 1),
(20, 'Ricki', 'Moran', NULL, 'moranr@ricaldone.edu.sv', 1, NULL, 'Diseño grafico', 1),
(21, 'Jose Ernesto', 'Alas', NULL, 'jose_e@ricaldone.edu.sv', 1, NULL, 'PILET', 1),
(22, 'Guadalupe', 'Melgar', NULL, 'lupe@ricaldone.edu.sv', 1, NULL, 'Informatica', 1),
(23, 'Maricela', 'Castillo', NULL, 'mari@ricaldone.edu.sv', 1, NULL, 'Arquitectura', 1),
(24, 'Paola', 'Hernandez', NULL, 'paom@ricaldone.edu.sv', 1, NULL, 'Electromecanica', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `famialum`
--

CREATE TABLE `famialum` (
  `codi` int(11) NOT NULL,
  `codi_alum` int(11) DEFAULT NULL,
  `nomb` varchar(100) DEFAULT NULL,
  `apel` varchar(100) DEFAULT NULL,
  `corr` varchar(50) DEFAULT NULL,
  `pare` varchar(100) DEFAULT NULL,
  `esta` int(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `famialum`
--

INSERT INTO `famialum` (`codi`, `codi_alum`, `nomb`, `apel`, `corr`, `pare`, `esta`) VALUES
(1, 1, 'Juan', 'Pérez', 'juanperez@hotmail.com', 'Padre', 1),
(2, 1, 'María', 'De Pérez', 'mariadeperez@hotmail.com', 'Madre', 1),
(3, 2, 'Carlos', 'Guevara', 'cguevara@hotmail.com', 'Padre', 1),
(4, 2, 'Maria', 'Tolentino', 'maritole@gmail.com', 'Madre', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seccalum`
--

CREATE TABLE `seccalum` (
  `codi` int(11) NOT NULL,
  `codi_secc` int(11) DEFAULT NULL,
  `codi_alum` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `seccalum`
--

INSERT INTO `seccalum` (`codi`, `codi_secc`, `codi_alum`) VALUES
(1, 1, 1),
(2, 2, 1),
(3, 1, 2),
(4, 2, 4),
(5, 3, 5),
(6, 2, 2),
(7, 1, 5),
(8, 2, 6),
(9, 4, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `seccempl`
--

CREATE TABLE `seccempl` (
  `codi` int(11) NOT NULL,
  `codi_secc` int(11) DEFAULT NULL,
  `codi_empl` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `seccempl`
--

INSERT INTO `seccempl` (`codi`, `codi_secc`, `codi_empl`) VALUES
(1, 2, 1),
(2, 1, 1),
(3, 3, 1),
(4, 2, 5),
(5, 3, 5),
(6, 3, 3),
(7, 1, 5),
(11, 3, 2),
(12, 3, 2),
(13, 1, 19),
(15, 2, 20),
(17, 3, 21),
(19, 4, 22),
(21, 5, 23),
(23, 6, 24);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `secciones`
--

CREATE TABLE `secciones` (
  `codi` int(11) NOT NULL,
  `grad` varchar(100) DEFAULT NULL,
  `nomb` varchar(100) DEFAULT NULL,
  `desc` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `secciones`
--

INSERT INTO `secciones` (`codi`, `grad`, `nomb`, `desc`) VALUES
(1, '2°', 'A1', 'Lenguaje y Literatura'),
(2, '2°', '1A', 'Tecnología'),
(3, '2°', '1A', 'LP2'),
(4, '1º', 'A2', 'Matemáticas '),
(5, '1º', 'B3', 'Biología '),
(6, '3º', 'A2', 'Mantenimiento de computadoras'),
(7, '2º', 'b4', 'Dibujo técnico ');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `codi` int(11) NOT NULL,
  `codi_alum` int(11) DEFAULT NULL,
  `codi_empl` int(11) DEFAULT NULL,
  `acce_usua` varchar(100) NOT NULL,
  `cont_usua` varchar(100) DEFAULT NULL,
  `esta_usua` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`codi`, `codi_alum`, `codi_empl`, `acce_usua`, `cont_usua`, `esta_usua`) VALUES
(1, NULL, 1, 'jirafales@ricaldone.edu.sv', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(2, 1, NULL, 'demo@ricaldone.edu.sv', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(3, NULL, 5, 'KevinAlas@hotmail.com', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(4, 3, 4, 'bryanCastro@ricaldone.edu.sv', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(5, 4, 3, 'salandra0@outlook.com', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 0),
(6, 5, 2, 'kelvinC1@ricaldone.edu.sv', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 0),
(7, NULL, 6, 'gersonmendoza@ricaldone.edu.sv', '03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', 1),
(8, NULL, 7, 'alexandergutierrez@ricaldone.edu.sv', '03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', 1),
(9, NULL, 8, 'josemulato@ricaldone.edu.sv', '03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', 1),
(10, NULL, 9, 'oscargaresst@ricaldone.edu.sv', '03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', 1),
(11, NULL, 10, 'israelhernandez@ricaldone.edu.sv', '03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', 1),
(12, NULL, 11, 'eduardomendez@ricaldone.edu.sv', '03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', 1),
(13, NULL, 12, 'franciscocarranza@ricaldone.edu.sv', '03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', 1),
(14, NULL, 13, 'valeriasalas@ricaldone.edu.sv', '03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', 1),
(15, NULL, 14, 'larryorellana@ricaldone.edu.sv', '03AC674216F3E15C761EE1A5E255F067953623C8B388B4459E13F978D7C846F4', 1),
(18, 2, NULL, '20130670', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(19, NULL, 4, 'recepcionista@ricaldone.edu.sv', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(20, NULL, 12, 'administrador@ricaldone.edu.sv', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(21, NULL, 15, 'arizul96@gmail.com', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(22, 1, NULL, '20150001', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(23, 3, NULL, '20130134', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(24, 4, NULL, '20130698', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(25, 5, NULL, '20145503', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(26, 6, NULL, '20130087', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(27, 7, NULL, '20130732', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(28, NULL, 16, 'mtorres@ricaldone.edu.sv', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(29, NULL, 17, 'chavez@ricaldone.edu.sv', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(30, NULL, 18, 'Mr.Malito@PuraMaldad.com', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(31, NULL, 19, 'mario@ricaldone.edu.sv', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(33, NULL, 20, 'moranr@ricaldone.edu.sv', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(35, NULL, 21, 'jose_e@ricaldone.edu.sv', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(37, NULL, 22, 'lupe@ricaldone.edu.sv', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(39, NULL, 23, 'mari@ricaldone.edu.sv', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1),
(41, NULL, 24, 'paom@ricaldone.edu.sv', 'A665A45920422F9D417E4867EFDC4FB8A04A1F3FFF1FA07E998E86F7F7A27AE3', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`codi`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`codi`);

--
-- Indices de la tabla `famialum`
--
ALTER TABLE `famialum`
  ADD PRIMARY KEY (`codi`),
  ADD KEY `alum3_fk` (`codi_alum`);

--
-- Indices de la tabla `seccalum`
--
ALTER TABLE `seccalum`
  ADD PRIMARY KEY (`codi`),
  ADD KEY `secc_fk` (`codi_secc`),
  ADD KEY `alum_fk` (`codi_alum`);

--
-- Indices de la tabla `seccempl`
--
ALTER TABLE `seccempl`
  ADD PRIMARY KEY (`codi`),
  ADD KEY `secc2_fk` (`codi_secc`),
  ADD KEY `empl_fk` (`codi_empl`);

--
-- Indices de la tabla `secciones`
--
ALTER TABLE `secciones`
  ADD PRIMARY KEY (`codi`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`codi`),
  ADD KEY `alum2_fk` (`codi_alum`),
  ADD KEY `empl2_fk` (`codi_empl`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `codi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `empleados`
--
ALTER TABLE `empleados`
  MODIFY `codi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT de la tabla `famialum`
--
ALTER TABLE `famialum`
  MODIFY `codi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `seccalum`
--
ALTER TABLE `seccalum`
  MODIFY `codi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `seccempl`
--
ALTER TABLE `seccempl`
  MODIFY `codi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT de la tabla `secciones`
--
ALTER TABLE `secciones`
  MODIFY `codi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `codi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `famialum`
--
ALTER TABLE `famialum`
  ADD CONSTRAINT `alum3_fk` FOREIGN KEY (`codi_alum`) REFERENCES `alumnos` (`codi`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `seccalum`
--
ALTER TABLE `seccalum`
  ADD CONSTRAINT `alum_fk` FOREIGN KEY (`codi_alum`) REFERENCES `alumnos` (`codi`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `secc_fk` FOREIGN KEY (`codi_secc`) REFERENCES `secciones` (`codi`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `seccempl`
--
ALTER TABLE `seccempl`
  ADD CONSTRAINT `empl_fk` FOREIGN KEY (`codi_empl`) REFERENCES `empleados` (`codi`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `secc2_fk` FOREIGN KEY (`codi_secc`) REFERENCES `secciones` (`codi`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `alum2_fk` FOREIGN KEY (`codi_alum`) REFERENCES `alumnos` (`codi`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `empl2_fk` FOREIGN KEY (`codi_empl`) REFERENCES `empleados` (`codi`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
