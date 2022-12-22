-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Dic 22, 2022 alle 15:22
-- Versione del server: 10.4.25-MariaDB
-- Versione PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `joyce`
--

-- --------------------------------------------------------

--
-- Struttura stand-in per le viste `dolci`
-- (Vedi sotto per la vista effettiva)
--
CREATE TABLE `dolci` (
`id_recipe` int(11)
,`recipe_name` varchar(50)
,`ingredients` text
,`process` text
,`time` varchar(50)
,`category` varchar(50)
,`difficulty` varchar(50)
);

-- --------------------------------------------------------

--
-- Struttura stand-in per le viste `primi`
-- (Vedi sotto per la vista effettiva)
--
CREATE TABLE `primi` (
`id_recipe` int(11)
,`recipe_name` varchar(50)
,`ingredients` text
,`process` text
,`time` varchar(50)
,`category` varchar(50)
,`difficulty` varchar(50)
);

-- --------------------------------------------------------

--
-- Struttura della tabella `recipes`
--

CREATE TABLE `recipes` (
  `id_recipe` int(11) NOT NULL,
  `recipe_name` varchar(50) NOT NULL,
  `ingredients` text NOT NULL,
  `process` text NOT NULL,
  `time` varchar(50) NOT NULL,
  `category` varchar(50) NOT NULL,
  `difficulty` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `recipes`
--

INSERT INTO `recipes` (`id_recipe`, `recipe_name`, `ingredients`, `process`, `time`, `category`, `difficulty`) VALUES
(43, 'Finocchietto all\'amaretto', 'cose', 's', '7 ore', 'secondo', 'difficile'),
(50, 'Giorgione', 'Oca e Pancetta', 'Stro', '2 ore', 'dolce', 'facile'),
(51, 'Aria', 'Aria', 'Respira', '2 ore', 'primo', 'facile');

-- --------------------------------------------------------

--
-- Struttura stand-in per le viste `secondi`
-- (Vedi sotto per la vista effettiva)
--
CREATE TABLE `secondi` (
`id_recipe` int(11)
,`recipe_name` varchar(50)
,`ingredients` text
,`process` text
,`time` varchar(50)
,`category` varchar(50)
,`difficulty` varchar(50)
);

-- --------------------------------------------------------

--
-- Struttura della tabella `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `user` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `users`
--

INSERT INTO `users` (`id`, `user`, `password`) VALUES
(1, 'user', 'user');

-- --------------------------------------------------------

--
-- Struttura per vista `dolci`
--
DROP TABLE IF EXISTS `dolci`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `dolci`  AS SELECT `recipes`.`id_recipe` AS `id_recipe`, `recipes`.`recipe_name` AS `recipe_name`, `recipes`.`ingredients` AS `ingredients`, `recipes`.`process` AS `process`, `recipes`.`time` AS `time`, `recipes`.`category` AS `category`, `recipes`.`difficulty` AS `difficulty` FROM `recipes` WHERE `recipes`.`category` = 'dolce' GROUP BY `recipes`.`recipe_name``recipe_name`  ;

-- --------------------------------------------------------

--
-- Struttura per vista `primi`
--
DROP TABLE IF EXISTS `primi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `primi`  AS SELECT `recipes`.`id_recipe` AS `id_recipe`, `recipes`.`recipe_name` AS `recipe_name`, `recipes`.`ingredients` AS `ingredients`, `recipes`.`process` AS `process`, `recipes`.`time` AS `time`, `recipes`.`category` AS `category`, `recipes`.`difficulty` AS `difficulty` FROM `recipes` WHERE `recipes`.`category` = 'primo' GROUP BY `recipes`.`recipe_name``recipe_name`  ;

-- --------------------------------------------------------

--
-- Struttura per vista `secondi`
--
DROP TABLE IF EXISTS `secondi`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `secondi`  AS SELECT `recipes`.`id_recipe` AS `id_recipe`, `recipes`.`recipe_name` AS `recipe_name`, `recipes`.`ingredients` AS `ingredients`, `recipes`.`process` AS `process`, `recipes`.`time` AS `time`, `recipes`.`category` AS `category`, `recipes`.`difficulty` AS `difficulty` FROM `recipes` WHERE `recipes`.`category` = 'secondo' GROUP BY `recipes`.`recipe_name``recipe_name`  ;

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `recipes`
--
ALTER TABLE `recipes`
  ADD PRIMARY KEY (`id_recipe`);

--
-- Indici per le tabelle `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `recipes`
--
ALTER TABLE `recipes`
  MODIFY `id_recipe` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=53;

--
-- AUTO_INCREMENT per la tabella `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
