-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Dic 21, 2022 alle 14:33
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
-- Struttura della tabella `difficulty`
--

CREATE TABLE `difficulty` (
  `id_difficulty` int(11) NOT NULL,
  `difficulty` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `difficulty`
--

INSERT INTO `difficulty` (`id_difficulty`, `difficulty`) VALUES
(1, 'Facile'),
(2, 'Medio'),
(3, 'Difficile');

-- --------------------------------------------------------

--
-- Struttura della tabella `recipes`
--

CREATE TABLE `recipes` (
  `id_recipe` int(11) NOT NULL,
  `recipe_name` varchar(50) NOT NULL,
  `author` int(11) NOT NULL,
  `process` text NOT NULL,
  `ingredients` text NOT NULL,
  `difficulty` int(11) NOT NULL,
  `time` varchar(50) NOT NULL,
  `category` int(11) NOT NULL,
  `suitable_for` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `recipe_category`
--

CREATE TABLE `recipe_category` (
  `id_category` int(11) NOT NULL,
  `category` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `recipe_category`
--

INSERT INTO `recipe_category` (`id_category`, `category`) VALUES
(1, 'Primo'),
(2, 'Secondo'),
(3, 'Dolce');

-- --------------------------------------------------------

--
-- Struttura della tabella `suitable_for`
--

CREATE TABLE `suitable_for` (
  `id_suitable_for` int(11) NOT NULL,
  `suitable_for` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `suitable_for`
--

INSERT INTO `suitable_for` (`id_suitable_for`, `suitable_for`) VALUES
(1, 'Vegan'),
(2, 'Celiaci'),
(3, 'Intolleranti al lattosio');

-- --------------------------------------------------------

--
-- Struttura della tabella `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `user_type` int(11) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `mail` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `newsletter` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Struttura della tabella `user_type`
--

CREATE TABLE `user_type` (
  `id` int(11) NOT NULL,
  `description` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dump dei dati per la tabella `user_type`
--

INSERT INTO `user_type` (`id`, `description`) VALUES
(1, 'user'),
(2, 'admin');

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `difficulty`
--
ALTER TABLE `difficulty`
  ADD PRIMARY KEY (`id_difficulty`);

--
-- Indici per le tabelle `recipes`
--
ALTER TABLE `recipes`
  ADD PRIMARY KEY (`id_recipe`),
  ADD KEY `author` (`author`),
  ADD KEY `recipe_category` (`category`),
  ADD KEY `suitable_for` (`suitable_for`),
  ADD KEY `difficulty` (`difficulty`);

--
-- Indici per le tabelle `recipe_category`
--
ALTER TABLE `recipe_category`
  ADD PRIMARY KEY (`id_category`);

--
-- Indici per le tabelle `suitable_for`
--
ALTER TABLE `suitable_for`
  ADD PRIMARY KEY (`id_suitable_for`);

--
-- Indici per le tabelle `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_type` (`user_type`);

--
-- Indici per le tabelle `user_type`
--
ALTER TABLE `user_type`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `difficulty`
--
ALTER TABLE `difficulty`
  MODIFY `id_difficulty` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `recipes`
--
ALTER TABLE `recipes`
  MODIFY `id_recipe` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `recipe_category`
--
ALTER TABLE `recipe_category`
  MODIFY `id_category` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `suitable_for`
--
ALTER TABLE `suitable_for`
  MODIFY `id_suitable_for` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT per la tabella `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `user_type`
--
ALTER TABLE `user_type`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `recipes`
--
ALTER TABLE `recipes`
  ADD CONSTRAINT `author` FOREIGN KEY (`author`) REFERENCES `users` (`id`),
  ADD CONSTRAINT `difficulty` FOREIGN KEY (`difficulty`) REFERENCES `difficulty` (`id_difficulty`),
  ADD CONSTRAINT `recipe_category` FOREIGN KEY (`category`) REFERENCES `recipe_category` (`id_category`),
  ADD CONSTRAINT `suitable_for` FOREIGN KEY (`suitable_for`) REFERENCES `suitable_for` (`id_suitable_for`);

--
-- Limiti per la tabella `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `user_type` FOREIGN KEY (`user_type`) REFERENCES `user_type` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
