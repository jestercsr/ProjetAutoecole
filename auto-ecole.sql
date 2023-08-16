-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Lun 31 Octobre 2022 à 13:41
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `auto-ecole`
--

-- --------------------------------------------------------

--
-- Structure de la table `moniteurs`
--

CREATE TABLE IF NOT EXISTS `moniteurs` (
  `id_emp` varchar(50) NOT NULL,
  `mon_emp` varchar(50) NOT NULL,
  `prenom_emp` varchar(50) NOT NULL,
  `num_emp` varchar(50) NOT NULL,
  `mail_emp` varchar(50) NOT NULL,
  `poste` varchar(20) NOT NULL,
  PRIMARY KEY (`id_emp`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `seances`
--

CREATE TABLE IF NOT EXISTS seances (
  nom_eve varchar(50) NOT NULL,
  date_eve datetime NOT NULL,
  date_fin datetime NOT NULL,
  id_user varchar(50) NOT NULL,
  id_emp varchar(50) NOT NULL,
  KEY id_user (id_user),
  KEY id_emp (id_emp)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateurs`
--

CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `id_user` int(3) NOT NULL AUTO_INCREMENT,
  `nom_user` varchar(50) NOT NULL,
  `prenom_user` varchar(50) NOT NULL,
  `mail_user` varchar(50) NOT NULL,
  `num_user` varchar(20) NOT NULL,
  `mot_passe` varchar(25) NOT NULL,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `id_user` (`id_user`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2147483647 ;

--
-- Contenu de la table `utilisateurs`
--

CREATE TABLE IF NOT EXISTS `offres`(
  `id_offre` int NOT NULL AUTO_INCREMENT,
  `nom_offre` varchar(50) NOT NULL,
  `nombre_heure_base` varchar(50) NOT NULL,
  `code compris` boolean NOT NULL,
  `prix_base` int NOT NULL,
  `prix_cours` int NOT NULL,
  `nombre_heure_cours` int NOT NULL,
  PRIMARY KEY(`id_offre`)
);




INSERT INTO `utilisateurs` (`id_user`, `nom_user`, `prenom_user`, `mail_user`, `num_user`, `mot_passe`) VALUES
(1, 'Pierre', 'Paul', 'pierrepaul@gmail.com', '0781175729', 'Azertyuiop01@'),
(2147483647, 'Pierr', 'Pul', 'piepaul@gmail.com', '0781175737', 'Azertyuiop12@');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
