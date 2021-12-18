-- phpMyAdmin SQL Dump
-- version 4.9.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 18, 2021 at 09:13 AM
-- Server version: 10.5.12-MariaDB
-- PHP Version: 7.3.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `id18141585_bddhamoud`
--
CREATE DATABASE IF NOT EXISTS `id18141585_bddhamoud` DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci;
USE `id18141585_bddhamoud`;

-- --------------------------------------------------------

--
-- Table structure for table `ads`
--

CREATE TABLE `ads` (
  `id` int(11) NOT NULL,
  `imageUrl` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `distributeurs`
--

CREATE TABLE `distributeurs` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `wilaya` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `location` varchar(100) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `distributeurs`
--

INSERT INTO `distributeurs` (`id`, `name`, `phone`, `email`, `password`, `wilaya`, `location`) VALUES
(1, 'BBADist', '0674291619', 'abd@gmail.com', '123456', 'BBA', '');

-- --------------------------------------------------------

--
-- Table structure for table `feedbacks`
--

CREATE TABLE `feedbacks` (
  `id` int(11) NOT NULL,
  `id_product` int(11) NOT NULL,
  `client_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `feedback_msg` text COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `name` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(1000) COLLATE utf8_unicode_ci NOT NULL,
  `picture` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `ratingups` int(11) NOT NULL,
  `ratingdowns` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `name`, `description`, `picture`, `ratingups`, `ratingdowns`) VALUES
(191900, 'Hamoud Gazouz blanche', 'Vériable emblème de Hamoud Boualem, l’incomparable limonade acquit ses lettres de noblesse en 1889 lors de l’exposition universelle de Paris. Celle que l’on nommait alors « La Royale » remporta une médaille d’or classée hors concours ainsi que diverses autres distinctions.\r\n\r\nDisponible en : \r\n\r\n    Pet : 1L\r\n    Canette : 33 cl\r\n', '', 0, 0),
(191901, 'Hamoud Gazouz blanche light', 'Savourez la boisson mythique de Hamoud Boualem avec 0% de sucres.\r\n\r\nDisponible en : \r\n\r\n    Pet : 1L\r\n    Canette : 33 cl\r\n', '', 0, 0),
(191902, 'Selecto', 'Lancée en 1907 sous le nom de marque « Victoria », la boisson Selecto incarne de par son goût unique l’originalité algérienne. Elle allie avec douceur les arômes naturels de pomme et de caramel\r\n\r\nDisponible en : \r\n\r\n    Verre : 25 cl,1L \r\n    Pet : 33 cl, 1L, 2L\r\n    Canette : 33 cl\r\n', '', 0, 0),
(191903, 'Selecto light', 'profitez du goût exceptionnel de Selecto, la boisson culte de Hamoud Boualem, avec 0% de sucres. \r\n\r\nDisponible en : \r\n\r\n    Pet : 1L\r\n    Canette : 33 cl\r\n', '', 0, 0),
(191904, 'Slim Fraise', 'Accompagnée par le mélodieux slogan « Slim, le citron qui prime », la commercialisation de cette boisson au fort goût fruité débuta dans les années 1950. Dès lors, la gamme n’a eu de cesse de s’élargir en réunissant au côté du Slim Citron originel d’autres parfums tels que l’Orange, l’Ananas , la Fraise ou encore la Pomme.Accompagnée par le mélodieux slogan « Slim, le citron qui prime », la commercialisation de cette boisson au fort goût fruité débuta dans les années 1950. Dès lors, la gamme n’a eu de cesse de s’élargir en réunissant au côté du Slim Citron originel d’autres parfums tels que l’Orange, l’Ananas , la Fraise ou encore la Pomme.\r\n\r\n Disponible en : \r\n\r\n    Verre : 25 cl,1L \r\n    Pet : 33 cl, 1L, 2L\r\n    Canette : 33 cl\r\n\r\n', '', 0, 0),
(191905, 'Slim Pomme', 'Accompagnée par le mélodieux slogan « Slim, le citron qui prime », la commercialisation de cette boisson au fort goût fruité débuta dans les années 1950. Dès lors, la gamme n’a eu de cesse de s’élargir en réunissant au côté du Slim Citron originel d’autres parfums tels que l’Orange, l’Ananas , la Fraise ou encore la Pomme.\r\n\r\n Disponible en : \r\n\r\n    Verre : 25 cl,1L \r\n    Pet : 33 cl, 1L, 2L\r\n    Canette : 33 cl', '', 0, 0),
(191906, 'Slim Ananas', 'Accompagnée par le mélodieux slogan « Slim, le citron qui prime », la commercialisation de cette boisson au fort goût fruité débuta dans les années 1950. Dès lors, la gamme n’a eu de cesse de s’élargir en réunissant au côté du Slim Citron originel d’autres parfums tels que l’Orange, l’Ananas , la Fraise ou encore la Pomme.Accompagnée par le mélodieux slogan « Slim, le citron qui prime », la commercialisation de cette boisson au fort goût fruité débuta dans les années 1950. Dès lors, la gamme n’a eu de cesse de s’élargir en réunissant au côté du Slim Citron originel d’autres parfums tels que l’Orange, l’Ananas , la Fraise ou encore la Pomme.\r\n\r\n Disponible en : \r\n\r\n    Verre : 25 cl,1L \r\n    Pet : 33 cl, 1L, 2L\r\n    Canette : 33 cl\r\n\r\n', '', 0, 0),
(191907, 'Slim Orange', 'Accompagnée par le mélodieux slogan « Slim, le citron qui prime », la commercialisation de cette boisson au fort goût fruité débuta dans les années 1950. Dès lors, la gamme n’a eu de cesse de s’élargir en réunissant au côté du Slim Citron originel d’autres parfums tels que l’Orange, l’Ananas , la Fraise ou encore la Pomme.\r\n\r\n Disponible en : \r\n\r\n    Verre : 25 cl,1L \r\n    Pet : 33 cl, 1L, 2L\r\n    Canette : 33 cl', '', 0, 0),
(191908, 'Slim Citron', 'Accompagnée par le mélodieux slogan « Slim, le citron qui prime », la commercialisation de cette boisson au fort goût fruité débuta dans les années 1950. Dès lors, la gamme n’a eu de cesse de s’élargir en réunissant au côté du Slim Citron originel d’autres parfums tels que l’Orange, l’Ananas , la Fraise ou encore la Pomme.Accompagnée par le mélodieux slogan « Slim, le citron qui prime », la commercialisation de cette boisson au fort goût fruité débuta dans les années 1950. Dès lors, la gamme n’a eu de cesse de s’élargir en réunissant au côté du Slim Citron originel d’autres parfums tels que l’Orange, l’Ananas , la Fraise ou encore la Pomme.\r\n\r\n Disponible en : \r\n\r\n    Verre : 25 cl,1L \r\n    Pet : 33 cl, 1L, 2L\r\n    Canette : 33 cl\r\n\r\n', '', 0, 0),
(191909, 'Slim Bitter', 'Accompagnée par le mélodieux slogan « Slim, le citron qui prime », la commercialisation de cette boisson au fort goût fruité débuta dans les années 1950. Dès lors, la gamme n’a eu de cesse de s’élargir en réunissant au côté du Slim Citron originel d’autres parfums tels que l’Orange, l’Ananas , la Fraise ou encore la Pomme.\r\n\r\n Disponible en : \r\n\r\n    Verre : 25 cl,1L \r\n    Pet : 33 cl, 1L, 2L\r\n    Canette : 33 cl', '', 0, 0),
(191910, 'Hamoud Sirop Citron', 'Le sirop mythique de Hamoud Boualem offre un goût de citron fraîche d’une finesse inégalée.\r\n', '', 0, 0),
(191911, 'Hamoud Sirop Menthe', 'Le sirop mythique de Hamoud Boualem offre un goût de menthe fraîche d’une finesse inégalée.', '', 0, 0),
(191912, 'Hamoud Sirop Grenadine', 'Le sirop à la grenadine est un concentré de sensations explosives, alliant cet agréable goût de fruit et cette couleur appétissante, idéal nature ou en cocktail, tel que le fameux diabolo grenadine.', '', 0, 0),
(191913, 'Lim ON - Orange purplée', 'Découvrez nos nouvelles boissons aux jus de fruits gazeifiées, déclinées en trois saveurs:\r\n\r\nAgrumes: un mélange de quatre différents agrumes, le pamplemousse, l\'orange, la mandarine et le citron.\r\n\r\nOrange pulpée: une boisson au jus d\'orange avec sa pulpe au goût naturel.\r\n\r\nMojito: un doux melange de citron et de menthe jardin.\r\n\r\nAux arômes et colorants naturels, les boissons Lim ON seront parfaites pour des cocktails rafraichissants.\r\n\r\nDisponible sur :\r\n\r\n    Pet : 33 cl, 1L\r\n    Canette : 25 cl\r\n\r\n', '', 0, 0),
(191914, 'Lim ON - Mojito', 'Découvrez nos nouvelles boissons aux jus de fruits gazeifiées, déclinées en trois saveurs:\r\n\r\nAgrumes: un mélange de quatre différents agrumes, le pamplemousse, l\'orange, la mandarine et le citron.\r\n\r\nOrange pulpée: une boisson au jus d\'orange avec sa pulpe au goût naturel.\r\n\r\nMojito: un doux melange de citron et de menthe jardin.\r\n\r\nAux arômes et colorants naturels, les boissons Lim ON seront parfaites pour des cocktails rafraichissants.\r\n\r\nDisponible sur :\r\n\r\n    Pet : 33 cl, 1L\r\n    Canette : 25 cl\r\n\r\n', '', 0, 0),
(191915, 'Lim ON - Agrumes', 'Découvrez nos nouvelles boissons aux jus de fruits gazeifiées, déclinées en trois saveurs:\r\n\r\nAgrumes: un mélange de quatre différents agrumes, le pamplemousse, l\'orange, la mandarine et le citron.\r\n\r\nOrange pulpée: une boisson au jus d\'orange avec sa pulpe au goût naturel.\r\n\r\nMojito: un doux melange de citron et de menthe jardin.\r\n\r\nAux arômes et colorants naturels, les boissons Lim ON seront parfaites pour des cocktails rafraichissants.\r\n\r\nDisponible sur :\r\n\r\n    Pet : 33 cl, 1L\r\n    Canette : 25 cl\r\n\r\n', '', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `requests`
--

CREATE TABLE `requests` (
  `id` int(11) NOT NULL,
  `reqStoreName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `reqManagerName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `reqStorePhone` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `reqEmail` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `reqStoreWilaya` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `reqStoreLocation` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `reqDistName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `quantity` int(11) NOT NULL,
  `product_name` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `shopkeepers`
--

CREATE TABLE `shopkeepers` (
  `id` int(11) NOT NULL,
  `storeName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `managerName` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `managerPhone` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `email` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `wilaya` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Location` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `distName` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `shopkeepers`
--

INSERT INTO `shopkeepers` (`id`, `storeName`, `managerName`, `managerPhone`, `email`, `password`, `wilaya`, `Location`, `distName`) VALUES
(1, 'ElBaraka', 'Abd Errahmane', '0674291619', 'anis@gmail.com', '123456', 'Bordj Bou Arreridj', '', 'BBA_Dist');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ads`
--
ALTER TABLE `ads`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `distributeurs`
--
ALTER TABLE `distributeurs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `feedbacks`
--
ALTER TABLE `feedbacks`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `requests`
--
ALTER TABLE `requests`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `shopkeepers`
--
ALTER TABLE `shopkeepers`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ads`
--
ALTER TABLE `ads`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `distributeurs`
--
ALTER TABLE `distributeurs`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `feedbacks`
--
ALTER TABLE `feedbacks`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=191927;

--
-- AUTO_INCREMENT for table `requests`
--
ALTER TABLE `requests`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `shopkeepers`
--
ALTER TABLE `shopkeepers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
