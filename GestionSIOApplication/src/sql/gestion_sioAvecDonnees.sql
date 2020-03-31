-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mar. 24 mars 2020 à 11:56
-- Version du serveur :  5.7.26
-- Version de PHP :  7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";



/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestion_sio`
--

DROP DATABASE IF EXISTS gestion_sio;
CREATE DATABASE IF NOT EXISTS gestion_sio;
USE gestion_sio;

CREATE USER IF NOT EXISTS 'gestion_sio_user'@'localhost' IDENTIFIED BY 'secret';
GRANT ALL PRIVILEGES ON gestion_sio.* TO 'gestion_sio_user'@'localhost';
-- --------------------------------------------------------

--
-- Structure de la table `annee`
--

DROP TABLE IF EXISTS `annee`;
CREATE TABLE IF NOT EXISTS `annee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `annee` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `annee`
--

INSERT INTO `annee` (`id`, `annee`) VALUES
(1, '2018-2019'),
(2, '2019-2020');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_personne` int(11) NOT NULL,
  `id_stage` int(11) DEFAULT NULL,
  `id_annee` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stage` (`id_stage`),
  KEY `fk_personne` (`id_personne`),
  KEY `fk_annee` (`id_annee`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`id`, `id_personne`, `id_stage`, `id_annee`) VALUES
(1, 1, 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `organisation`
--

DROP TABLE IF EXISTS `organisation`;
CREATE TABLE IF NOT EXISTS `organisation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `adresse` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `organisation`
--

INSERT INTO `organisation` (`id`, `nom`, `adresse`) VALUES
(1, 'Ars', 'Nantes'),
(2, 'Logimo', 'Saint-seb');

-- --------------------------------------------------------

--
-- Structure de la table `personne`
--

DROP TABLE IF EXISTS `personne`;
CREATE TABLE IF NOT EXISTS `personne` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(255) NOT NULL,
  `prenom` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `civilite` varchar(255) NOT NULL,
  `ville` varchar(255) DEFAULT NULL,
  `adresse` varchar(255) DEFAULT NULL,
  `codePostal` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `personne`
--

INSERT INTO `personne` (`id`, `nom`, `prenom`, `email`, `telephone`, `civilite`, `ville`, `adresse`, `codePostal`) VALUES
(1, 'Nowak', 'Maxence', 'maxence.nowak@hotmail.fr', '07.72.16.62.52', 'Mr', 'Les touches', '10 la gueriniere', 44390),
(2, 'Michaud', 'Valentin', 'valentin.michaud@hotmail.fr', '06.06.06.06.60', 'Mr', 'Saint-Seb', 'Je ne sais plus', 44230),
(3, 'Contant', 'Nelly', 'nelly@hotmail.fr', NULL, 'Mme', NULL, NULL, NULL),
(4, 'Toursi', 'Leila', 'leila@thotmail.fr', NULL, 'Mme', NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `professeur`
--

DROP TABLE IF EXISTS `professeur`;
CREATE TABLE IF NOT EXISTS `professeur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_personne` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_personne` (`id_personne`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `professeur`
--

INSERT INTO `professeur` (`id`, `id_personne`) VALUES
(1, 3);

-- --------------------------------------------------------

--
-- Structure de la table `professionnel`
--

DROP TABLE IF EXISTS `professionnel`;
CREATE TABLE IF NOT EXISTS `professionnel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_personne` int(11) NOT NULL,
  `ancien_eleve` tinyint(1) NOT NULL,
  `fonction` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_personne` (`id_personne`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `professionnel`
--

INSERT INTO `professionnel` (`id`, `id_personne`, `ancien_eleve`, `fonction`) VALUES
(1, 4, 0, 'Developpeuse');

-- --------------------------------------------------------

--
-- Structure de la table `promotion`
--

DROP TABLE IF EXISTS `promotion`;
CREATE TABLE IF NOT EXISTS `promotion` (
  `id_etudiant` int(11) NOT NULL,
  `id_annee` int(11) NOT NULL,
  `option` varchar(255) NOT NULL,
  KEY `fk_etudiant` (`id_etudiant`),
  KEY `fk_annee` (`id_annee`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `promotion`
--

INSERT INTO `promotion` (`id_etudiant`, `id_annee`, `option`) VALUES
(1, 2, 'SLAM');

-- --------------------------------------------------------

--
-- Structure de la table `stage`
--

DROP TABLE IF EXISTS `stage`;
CREATE TABLE IF NOT EXISTS `stage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_etudiant` int(11) NOT NULL,
  `id_professionnel` int(11) NOT NULL,
  `id_organisation` int(11) NOT NULL,
  `debut` date NOT NULL,
  `fin` date NOT NULL,
  `sujet` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_etudiant` (`id_etudiant`),
  KEY `fk_professionnel` (`id_professionnel`),
  KEY `fk_organisation` (`id_organisation`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `stage`
--

INSERT INTO `stage` (`id`, `id_etudiant`, `id_professionnel`, `id_organisation`, `debut`, `fin`, `sujet`) VALUES
(1, 1, 1, 1, '2020-01-06', '2020-02-21', "Developpement d'une solution web");

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(255) NOT NULL,
  `mot_de_passe` text NOT NULL,
  `role` tinyint(1) NOT NULL,
  `id_personne` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_personne` (`id_personne`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `visite`
--

DROP TABLE IF EXISTS `visite`;
CREATE TABLE IF NOT EXISTS `visite` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_stage` int(11) NOT NULL,
  `date` date NOT NULL,
  `jury` tinyint(1) NOT NULL,
  `stage1` tinyint(1) NOT NULL,
  `stage2` tinyint(1) NOT NULL,
  `id_professeur` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stage` (`id_stage`),
  KEY `fk_professeur` (`id_professeur`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `visite`
--

INSERT INTO `visite` (`id`, `id_stage`, `date`, `jury`, `stage1`, `stage2`, `id_professeur`) VALUES
(1, 1, '2020-01-23', 1, 0, 1, 1);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD CONSTRAINT `etudiant_ibfk_1` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id`),
  ADD CONSTRAINT `etudiant_ibfk_2` FOREIGN KEY (`id_annee`) REFERENCES `annee` (`id`);

--
-- Contraintes pour la table `professeur`
--
ALTER TABLE `professeur`
  ADD CONSTRAINT `professeur_ibfk_1` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `professionnel`
--
ALTER TABLE `professionnel`
  ADD CONSTRAINT `professionnel_ibfk_1` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `promotion`
--
ALTER TABLE `promotion`
  ADD CONSTRAINT `promotion_ibfk_1` FOREIGN KEY (`id_etudiant`) REFERENCES `etudiant` (`id`),
  ADD CONSTRAINT `promotion_ibfk_2` FOREIGN KEY (`id_annee`) REFERENCES `annee` (`id`);

--
-- Contraintes pour la table `stage`
--
ALTER TABLE `stage`
  ADD CONSTRAINT `stage_ibfk_1` FOREIGN KEY (`id_etudiant`) REFERENCES `etudiant` (`id`),
  ADD CONSTRAINT `stage_ibfk_2` FOREIGN KEY (`id_professionnel`) REFERENCES `professionnel` (`id`),
  ADD CONSTRAINT `stage_ibfk_3` FOREIGN KEY (`id_organisation`) REFERENCES `organisation` (`id`);

--
-- Contraintes pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD CONSTRAINT `utilisateur_ibfk_1` FOREIGN KEY (`id_personne`) REFERENCES `personne` (`id`);

--
-- Contraintes pour la table `visite`
--
ALTER TABLE `visite`
  ADD CONSTRAINT `visite_ibfk_1` FOREIGN KEY (`id_stage`) REFERENCES `stage` (`id`),
  ADD CONSTRAINT `visite_ibfk_2` FOREIGN KEY (`id_professeur`) REFERENCES `professeur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
