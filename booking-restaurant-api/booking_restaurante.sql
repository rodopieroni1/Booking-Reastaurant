-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 26-11-2021 a las 13:56:48
-- Versión del servidor: 8.0.27
-- Versión de PHP: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `booking_restaurante`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `board`
--

CREATE TABLE `board` (
  `ID` int NOT NULL,
  `CAPACITY` int DEFAULT NULL,
  `NUMBER` int DEFAULT NULL,
  `RESTAURANT_ID` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `board`
--

INSERT INTO `board` (`ID`, `CAPACITY`, `NUMBER`, `RESTAURANT_ID`) VALUES
(1, 3, 1, '1'),
(2, 6, 2, '1'),
(3, 2, 3, '1'),
(4, 5, 4, '1'),
(5, 4, 1, '2'),
(6, 6, 2, '2'),
(7, 4, 3, '2'),
(8, 8, 4, '2');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reservation`
--

CREATE TABLE `reservation` (
  `ID` int NOT NULL,
  `LOCATOR` varchar(45) DEFAULT NULL,
  `PERSON` varchar(19) DEFAULT NULL,
  `DATE` date DEFAULT NULL,
  `TURN` varchar(45) DEFAULT NULL,
  `RESTAURANTE_ID` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `reservation`
--

INSERT INTO `reservation` (`ID`, `LOCATOR`, `PERSON`, `DATE`, `TURN`, `RESTAURANTE_ID`) VALUES
(1, 'Burger King1', '6', '2021-10-13', 'TURNO_10_00', '1'),
(2, 'Burger King1', '6', '2021-08-13', 'TURNO_10_00', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `restaurant`
--

CREATE TABLE `restaurant` (
  `ID` varchar(45) NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `DESCRIPTION` varchar(100) DEFAULT NULL,
  `ADDRESS` varchar(100) DEFAULT NULL,
  `IMAGEN` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `restaurant`
--

INSERT INTO `restaurant` (`ID`, `NAME`, `DESCRIPTION`, `ADDRESS`, `IMAGEN`) VALUES
('1', 'Burger King1', 'Restaurante de hamburguesas', 'Rivadavia 250', 'https://www.distribuicaohoje.com/wp-content/uploads/sites/2/2020/10/SJ-Porto2-810x608.jpg'),
('2', 'Mc Donals', 'vea de mc donals', 'riv y ejercito', 'https://th.bing.com/th/id/OIP.sn-m19RZtk2Dec8F0dQIfQHaE8?pid=ImgDet&rs=1'),
('3', 'La Manza', 'La Manza', 'Zanjon', 'https://th.bing.com/th/id/OIP.U-KJMoD-k09fCLi2yjopogHaE7?pid=ImgDet&rs=1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turn`
--

CREATE TABLE `turn` (
  `ID` int NOT NULL,
  `NAME` varchar(45) DEFAULT NULL,
  `RESTAURANT_ID` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

--
-- Volcado de datos para la tabla `turn`
--

INSERT INTO `turn` (`ID`, `NAME`, `RESTAURANT_ID`) VALUES
(1, 'TURNO_10_00', 1),
(2, 'TURNO_11_00', 1),
(3, 'TURNO_12_00', 1),
(4, 'TURNO_13_00', 1),
(5, 'TURNO_14_00', 2),
(6, 'TURNO_15_00', 2),
(7, 'TURNO_16_00', 2),
(8, 'TURNO_17_00', 2);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `board`
--
ALTER TABLE `board`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_BOARD_RESTAURANT1_idx` (`RESTAURANT_ID`);

--
-- Indices de la tabla `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `fk_RESERVATION_RESTAURANTE_idx` (`RESTAURANTE_ID`);

--
-- Indices de la tabla `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `turn`
--
ALTER TABLE `turn`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `board`
--
ALTER TABLE `board`
  MODIFY `ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `reservation`
--
ALTER TABLE `reservation`
  MODIFY `ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `turn`
--
ALTER TABLE `turn`
  MODIFY `ID` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `board`
--
ALTER TABLE `board`
  ADD CONSTRAINT `fk_BOARD_RESTAURANT1` FOREIGN KEY (`RESTAURANT_ID`) REFERENCES `restaurant` (`ID`);

--
-- Filtros para la tabla `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `fk_RESERVATION_RESTAURANTE` FOREIGN KEY (`RESTAURANTE_ID`) REFERENCES `restaurant` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
