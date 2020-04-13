-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 06, 2019 at 04:37 PM
-- Server version: 10.1.8-MariaDB
-- PHP Version: 5.6.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `aggregator`
--

-- --------------------------------------------------------

--
-- Table structure for table `wm_articles`
--

CREATE TABLE `wm_articles` (
  `id` int(11) NOT NULL,
  `category_id` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `description` text NOT NULL,
  `link` varchar(250) NOT NULL,
  `pubDate` varchar(250) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `wm_categories`
--

CREATE TABLE `wm_categories` (
  `id` int(11) NOT NULL,
  `title` varchar(250) NOT NULL,
  `description` text NOT NULL,
  `feed` varchar(250) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wm_categories`
--

INSERT INTO `wm_categories` (`id`, `title`, `description`, `feed`, `created_at`) VALUES
(1, 'New Scientist - Humans', 'New Scientist - Humans', 'http://feeds.newscientist.com/humans/', '2019-04-06 13:55:58'),
(2, 'New Scientist - Physics', 'New Scientist - Physics', 'http://feeds.newscientist.com/physics-math/', '2019-04-06 14:28:56'),
(3, 'New Scientist - Earth', 'New Scientist - Earth', 'http://feeds.newscientist.com/environment/', '2019-04-06 14:29:58'),
(4, 'New Scientist - Health', 'New Scientist - Health', 'http://feeds.newscientist.com/health/', '2019-04-06 14:29:58'),
(5, 'New Scientist - Space', 'New Scientist - Space', 'http://feeds.newscientist.com/space/', '2019-04-06 14:30:28');

-- --------------------------------------------------------

--
-- Table structure for table `wm_users`
--

CREATE TABLE `wm_users` (
  `userid` int(11) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `emailadd` varchar(50) NOT NULL,
  `gender` varchar(50) NOT NULL,
  `city` varchar(50) NOT NULL,
  `country` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `type_of_user` enum('user','admin') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `wm_users`
--

INSERT INTO `wm_users` (`userid`, `first_name`, `last_name`, `emailadd`, `gender`, `city`, `country`, `password`, `type_of_user`) VALUES
(11, 'Sean ', 'Daly', 'Sean@yahoo.com', 'Male', 'Nenagh', 'Ireland', '202cb962ac59075b964b07152d234b70', 'user'),
(12, 'Peter', 'Parker', 'Peter@yahoo.com', 'Male', 'New York', 'America', '202cb962ac59075b964b07152d234b70', 'user'),
(13, 'admin', 'a', 'admin@yahoo.com', 'Male', 's', 's', '202cb962ac59075b964b07152d234b70', 'admin'),
(14, 'Paul', 'Marks', 'Paul@yahoo.com', 'Male', 'Amsterdam', 'Netherlands', '202cb962ac59075b964b07152d234b70', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `wm_articles`
--
ALTER TABLE `wm_articles`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `wm_categories`
--
ALTER TABLE `wm_categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `wm_users`
--
ALTER TABLE `wm_users`
  ADD PRIMARY KEY (`userid`),
  ADD UNIQUE KEY `emailadd` (`emailadd`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `wm_articles`
--
ALTER TABLE `wm_articles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `wm_categories`
--
ALTER TABLE `wm_categories`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `wm_users`
--
ALTER TABLE `wm_users`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
