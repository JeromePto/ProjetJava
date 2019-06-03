-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  lun. 03 juin 2019 à 08:27
-- Version du serveur :  5.7.24
-- Version de PHP :  7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ecole`
--
DROP DATABASE IF EXISTS `ecole`;
CREATE DATABASE IF NOT EXISTS `ecole` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `ecole`;

-- --------------------------------------------------------

--
-- Structure de la table `anneescolaire`
--

DROP TABLE IF EXISTS `anneescolaire`;
CREATE TABLE IF NOT EXISTS `anneescolaire` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `anneescolaire`
--

INSERT INTO `anneescolaire` (`ID`) VALUES
(2017),
(2018);

-- --------------------------------------------------------

--
-- Structure de la table `bulletin`
--

DROP TABLE IF EXISTS `bulletin`;
CREATE TABLE IF NOT EXISTS `bulletin` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `APPRECIATION` text NOT NULL,
  `INSCRIPTION_ID` int(11) NOT NULL,
  `TRIMESTRE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_trimestre_id` (`TRIMESTRE_ID`),
  KEY `fk_inscription_id` (`INSCRIPTION_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `bulletin`
--

INSERT INTO `bulletin` (`ID`, `APPRECIATION`, `INSCRIPTION_ID`, `TRIMESTRE_ID`) VALUES
(1, 'Bien', 1, 1),
(2, 'Bien', 2, 1),
(3, 'Bien', 3, 1),
(4, 'Bien', 4, 1),
(5, 'Bien', 5, 1),
(6, 'Bien', 6, 1),
(7, 'Bien', 1, 2),
(8, 'Bien', 2, 2),
(9, 'Bien', 3, 2),
(10, 'Bien', 4, 2),
(11, 'Bien', 5, 2),
(12, 'Bien', 6, 2),
(13, 'Bien', 1, 3),
(14, 'Bien', 2, 3),
(15, 'Bien', 3, 3),
(16, 'Bien', 4, 3),
(17, 'Bien', 5, 3),
(18, 'Bien', 6, 3),
(19, 'Bien', 7, 4),
(20, 'Bien', 8, 4),
(21, 'Bien', 9, 4),
(22, 'Bien', 10, 4),
(23, 'Bien', 11, 4),
(24, 'Bien', 12, 4);

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  `NIVEAU_ID` int(11) NOT NULL,
  `ANNEESCOLAIRE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_anneescolaire_id2` (`ANNEESCOLAIRE_ID`),
  KEY `fk_niveau_id` (`NIVEAU_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`ID`, `NOM`, `NIVEAU_ID`, `ANNEESCOLAIRE_ID`) VALUES
(1, 'CP-1', 1, 2017),
(2, 'CP-2', 1, 2017),
(3, 'CP-1', 1, 2018),
(4, 'CE1-1', 2, 2017),
(5, 'CP-2', 1, 2018),
(6, 'CE1-1', 2, 2018);

-- --------------------------------------------------------

--
-- Structure de la table `detailbulletin`
--

DROP TABLE IF EXISTS `detailbulletin`;
CREATE TABLE IF NOT EXISTS `detailbulletin` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `APPRECIATION` text NOT NULL,
  `BULLETIN_ID` int(11) NOT NULL,
  `ENSEIGNEMENT_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_bulletin_id` (`BULLETIN_ID`),
  KEY `fk_enseignement_id` (`ENSEIGNEMENT_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `detailbulletin`
--

INSERT INTO `detailbulletin` (`ID`, `APPRECIATION`, `BULLETIN_ID`, `ENSEIGNEMENT_ID`) VALUES
(1, 'Très Bien', 1, 1),
(2, 'Très Bien', 7, 1),
(3, 'Très Bien', 13, 1),
(4, 'Très Bien', 1, 2),
(5, 'Très Bien', 7, 2),
(6, 'Très Bien', 13, 2),
(7, 'Très Bien', 2, 1),
(8, 'Très Bien', 8, 1),
(9, 'Très Bien', 14, 1),
(10, 'Très Bien', 2, 2),
(11, 'Très Bien', 8, 2),
(12, 'Très Bien', 14, 2),
(13, 'Très Bien', 3, 3),
(14, 'Très Bien', 9, 3),
(15, 'Très Bien', 15, 3),
(16, 'Très Bien', 3, 4),
(17, 'Très Bien', 9, 4),
(18, 'Très Bien', 15, 4),
(19, 'Très Bien', 4, 3),
(20, 'Très Bien', 10, 3),
(21, 'Très Bien', 16, 3),
(22, 'Très Bien', 4, 4),
(23, 'Très Bien', 10, 4),
(24, 'Très Bien', 16, 4),
(25, 'Très Bien', 5, 9),
(26, 'Très Bien', 11, 9),
(27, 'Très Bien', 17, 9),
(28, 'Très Bien', 5, 10),
(29, 'Très Bien', 11, 10),
(30, 'Très Bien', 17, 10),
(31, 'Très Bien', 6, 9),
(32, 'Très Bien', 12, 9),
(33, 'Très Bien', 18, 9),
(34, 'Très Bien', 6, 10),
(35, 'Très Bien', 12, 10),
(36, 'Très Bien', 18, 10),
(37, 'Très Bien', 23, 5),
(38, 'Très Bien', 23, 6),
(39, 'Très Bien', 24, 7),
(40, 'Très Bien', 24, 8),
(41, 'Très Bien', 19, 11),
(42, 'Très Bien', 19, 12),
(43, 'Très Bien', 20, 11),
(44, 'Très Bien', 20, 12),
(45, 'Très Bien', 21, 11),
(46, 'Très Bien', 21, 12),
(47, 'Très Bien', 22, 11),
(48, 'Très Bien', 22, 12);

-- --------------------------------------------------------

--
-- Structure de la table `discipline`
--

DROP TABLE IF EXISTS `discipline`;
CREATE TABLE IF NOT EXISTS `discipline` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `discipline`
--

INSERT INTO `discipline` (`ID`, `NOM`) VALUES
(1, 'Francais'),
(2, 'Physique'),
(3, 'Histoire');

-- --------------------------------------------------------

--
-- Structure de la table `enseignement`
--

DROP TABLE IF EXISTS `enseignement`;
CREATE TABLE IF NOT EXISTS `enseignement` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CLASSE_ID` int(11) NOT NULL,
  `DISCIPLINE_ID` int(11) NOT NULL,
  `PERSONNE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_classe_id` (`CLASSE_ID`),
  KEY `fk_discipline_id` (`DISCIPLINE_ID`),
  KEY `fk_enseignant_id` (`PERSONNE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `enseignement`
--

INSERT INTO `enseignement` (`ID`, `CLASSE_ID`, `DISCIPLINE_ID`, `PERSONNE_ID`) VALUES
(1, 1, 1, 10),
(2, 1, 2, 11),
(3, 2, 1, 10),
(4, 2, 2, 11),
(5, 3, 1, 10),
(6, 3, 2, 11),
(7, 5, 1, 10),
(8, 5, 2, 11),
(9, 4, 3, 12),
(10, 4, 2, 10),
(11, 6, 3, 12),
(12, 6, 2, 10);

-- --------------------------------------------------------

--
-- Structure de la table `evaluation`
--

DROP TABLE IF EXISTS `evaluation`;
CREATE TABLE IF NOT EXISTS `evaluation` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOTE` float NOT NULL,
  `APPRECIATION` text NOT NULL,
  `DETAILBULLETIN_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_detailbulletin_id` (`DETAILBULLETIN_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `evaluation`
--

INSERT INTO `evaluation` (`ID`, `NOTE`, `APPRECIATION`, `DETAILBULLETIN_ID`) VALUES
(1, 7, 'Bof', 1),
(2, 7, 'Bof', 4),
(3, 7, 'Bof', 7),
(4, 7, 'Bof', 10),
(5, 7, 'Bof', 13),
(6, 7, 'Bof', 16),
(7, 7, 'Bof', 19),
(8, 7, 'Bof', 22),
(9, 7, 'Bof', 25),
(10, 7, 'Bof', 28),
(11, 7, 'Bof', 31),
(12, 7, 'Bof', 34),
(13, 7, 'Bof', 2),
(14, 7, 'Bof', 5),
(15, 7, 'Bof', 8),
(16, 7, 'Bof', 11),
(17, 7, 'Bof', 14),
(18, 7, 'Bof', 17),
(19, 7, 'Bof', 20),
(20, 7, 'Bof', 23),
(21, 7, 'Bof', 26),
(22, 7, 'Bof', 29),
(23, 7, 'Bof', 32),
(24, 7, 'Bof', 35),
(25, 7, 'Bof', 3),
(26, 7, 'Bof', 6),
(27, 7, 'Bof', 9),
(28, 7, 'Bof', 12),
(29, 7, 'Bof', 15),
(30, 7, 'Bof', 18),
(31, 7, 'Bof', 21),
(32, 7, 'Bof', 24),
(33, 7, 'Bof', 27),
(34, 7, 'Bof', 30),
(35, 7, 'Bof', 33),
(36, 7, 'Bof', 36),
(37, 7, 'Bof', 41),
(38, 7, 'Bof', 42),
(39, 7, 'Bof', 43),
(40, 7, 'Bof', 44),
(41, 7, 'Bof', 45),
(42, 7, 'Bof', 46),
(43, 7, 'Bof', 47),
(44, 7, 'Bof', 48),
(45, 7, 'Bof', 37),
(46, 7, 'Bof', 38),
(47, 7, 'Bof', 39),
(48, 7, 'Bof', 40),
(49, 10.5, 'Moyen', 1),
(50, 10.5, 'Moyen', 4),
(51, 10.5, 'Moyen', 7),
(52, 10.5, 'Moyen', 10),
(53, 10.5, 'Moyen', 13),
(54, 10.5, 'Moyen', 16),
(55, 10.5, 'Moyen', 19),
(56, 10.5, 'Moyen', 22),
(57, 10.5, 'Moyen', 25),
(58, 10.5, 'Moyen', 28),
(59, 10.5, 'Moyen', 31),
(60, 10.5, 'Moyen', 34),
(61, 10.5, 'Moyen', 2),
(62, 10.5, 'Moyen', 5),
(63, 10.5, 'Moyen', 8),
(64, 10.5, 'Moyen', 11),
(65, 10.5, 'Moyen', 14),
(66, 10.5, 'Moyen', 17),
(67, 10.5, 'Moyen', 20),
(68, 10.5, 'Moyen', 23),
(69, 10.5, 'Moyen', 26),
(70, 10.5, 'Moyen', 29),
(71, 10.5, 'Moyen', 32),
(72, 10.5, 'Moyen', 35),
(73, 10.5, 'Moyen', 3),
(74, 10.5, 'Moyen', 6),
(75, 10.5, 'Moyen', 9),
(76, 10.5, 'Moyen', 12),
(77, 10.5, 'Moyen', 15),
(78, 10.5, 'Moyen', 18),
(79, 10.5, 'Moyen', 21),
(80, 10.5, 'Moyen', 24),
(81, 10.5, 'Moyen', 27),
(82, 10.5, 'Moyen', 30),
(83, 10.5, 'Moyen', 33),
(84, 10.5, 'Moyen', 36),
(85, 10.5, 'Moyen', 41),
(86, 10.5, 'Moyen', 42),
(87, 10.5, 'Moyen', 43),
(88, 10.5, 'Moyen', 44),
(89, 10.5, 'Moyen', 45),
(90, 10.5, 'Moyen', 46),
(91, 10.5, 'Moyen', 47),
(92, 10.5, 'Moyen', 48),
(93, 10.5, 'Moyen', 37),
(94, 10.5, 'Moyen', 38),
(95, 10.5, 'Moyen', 39),
(96, 10.5, 'Moyen', 40);

-- --------------------------------------------------------

--
-- Structure de la table `inscription`
--

DROP TABLE IF EXISTS `inscription`;
CREATE TABLE IF NOT EXISTS `inscription` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `CLASSE_ID` int(11) NOT NULL,
  `PERSONNE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_classe_id2` (`CLASSE_ID`),
  KEY `fk_eleve_id` (`PERSONNE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `inscription`
--

INSERT INTO `inscription` (`ID`, `CLASSE_ID`, `PERSONNE_ID`) VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 3),
(4, 2, 4),
(5, 4, 5),
(6, 4, 6),
(7, 6, 1),
(8, 6, 2),
(9, 6, 3),
(10, 6, 4),
(11, 3, 13),
(12, 5, 14);

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

DROP TABLE IF EXISTS `niveau`;
CREATE TABLE IF NOT EXISTS `niveau` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `niveau`
--

INSERT INTO `niveau` (`ID`, `NOM`) VALUES
(1, 'CP'),
(2, 'CE1');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NOM` varchar(255) NOT NULL,
  `PRENOM` varchar(255) NOT NULL,
  `TYPE` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`ID`, `NOM`, `PRENOM`, `TYPE`) VALUES
(1, 'Dupond', 'Pierre', 1),
(2, 'Polo', 'Hugo', 1),
(3, 'Capot', 'Julie', 1),
(4, 'Smith', 'Kevin', 1),
(5, 'Dule', 'Marie', 1),
(6, 'Dule', 'Pierre', 1),
(10, 'Busca', 'Jean-Michel', 2),
(11, 'Segado', 'Jean-Pierre', 2),
(12, 'Hina', 'Manolo', 2),
(13, 'Lili', 'Maurice', 1),
(14, 'Peter', 'Marc', 1);

-- --------------------------------------------------------

--
-- Structure de la table `trimestre`
--

DROP TABLE IF EXISTS `trimestre`;
CREATE TABLE IF NOT EXISTS `trimestre` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NUMERO` int(11) NOT NULL,
  `DEBUT` date NOT NULL,
  `FIN` date NOT NULL,
  `ANNEESCOLAIRE_ID` int(11) NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `fk_anneescolaire_id` (`ANNEESCOLAIRE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `trimestre`
--

INSERT INTO `trimestre` (`ID`, `NUMERO`, `DEBUT`, `FIN`, `ANNEESCOLAIRE_ID`) VALUES
(1, 1, '2017-09-01', '2018-01-01', 2017),
(2, 2, '2018-01-01', '2018-03-01', 2017),
(3, 3, '2018-03-01', '2018-06-01', 2017),
(4, 1, '2018-08-01', '2019-01-01', 2018),
(5, 2, '2019-01-01', '2019-03-01', 2018);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `bulletin`
--
ALTER TABLE `bulletin`
  ADD CONSTRAINT `fk_inscription_id` FOREIGN KEY (`INSCRIPTION_ID`) REFERENCES `inscription` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_trimestre_id` FOREIGN KEY (`TRIMESTRE_ID`) REFERENCES `trimestre` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `fk_anneescolaire_id2` FOREIGN KEY (`ANNEESCOLAIRE_ID`) REFERENCES `anneescolaire` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_niveau_id` FOREIGN KEY (`NIVEAU_ID`) REFERENCES `niveau` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `detailbulletin`
--
ALTER TABLE `detailbulletin`
  ADD CONSTRAINT `fk_bulletin_id` FOREIGN KEY (`BULLETIN_ID`) REFERENCES `bulletin` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_enseignement_id` FOREIGN KEY (`ENSEIGNEMENT_ID`) REFERENCES `enseignement` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `enseignement`
--
ALTER TABLE `enseignement`
  ADD CONSTRAINT `fk_classe_id` FOREIGN KEY (`CLASSE_ID`) REFERENCES `classe` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_discipline_id` FOREIGN KEY (`DISCIPLINE_ID`) REFERENCES `discipline` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_enseignant_id` FOREIGN KEY (`PERSONNE_ID`) REFERENCES `personne` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `evaluation`
--
ALTER TABLE `evaluation`
  ADD CONSTRAINT `fk_detailbulletin_id` FOREIGN KEY (`DETAILBULLETIN_ID`) REFERENCES `detailbulletin` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `inscription`
--
ALTER TABLE `inscription`
  ADD CONSTRAINT `fk_classe_id2` FOREIGN KEY (`CLASSE_ID`) REFERENCES `classe` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_eleve_id` FOREIGN KEY (`PERSONNE_ID`) REFERENCES `personne` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `trimestre`
--
ALTER TABLE `trimestre`
  ADD CONSTRAINT `fk_anneescolaire_id` FOREIGN KEY (`ANNEESCOLAIRE_ID`) REFERENCES `anneescolaire` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
