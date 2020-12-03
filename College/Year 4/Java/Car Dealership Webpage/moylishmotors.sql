-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 02, 2020 at 02:11 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `moylishmotors`
--

-- --------------------------------------------------------

--
-- Table structure for table `favourites`
--

CREATE TABLE `favourites` (
  `username` varchar(200) NOT NULL,
  `listing` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `favourites`
--

INSERT INTO `favourites` (`username`, `listing`) VALUES
('Admin', 4294194);

-- --------------------------------------------------------

--
-- Table structure for table `sold_cars`
--

CREATE TABLE `sold_cars` (
  `id` int(11) NOT NULL,
  `sold_car_listing` int(100) NOT NULL,
  `sold_to` varchar(200) NOT NULL,
  `sold_car_price` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `sold_cars`
--

INSERT INTO `sold_cars` (`id`, `sold_car_listing`, `sold_to`, `sold_car_price`) VALUES
(3, 4294194, 'Jack_Wanye', 39742);

-- --------------------------------------------------------

--
-- Table structure for table `trades`
--

CREATE TABLE `trades` (
  `trade_id` int(11) NOT NULL,
  `user_car_listing` int(100) NOT NULL,
  `traded_car_listing` int(100) NOT NULL,
  `adjusted_price` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `trades`
--

INSERT INTO `trades` (`trade_id`, `user_car_listing`, `traded_car_listing`, `adjusted_price`) VALUES
(4, 12575, 123456789, -998920);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `username` varchar(100) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(100) NOT NULL,
  `roleId` int(11) NOT NULL,
  `phone` int(200) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `fax` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `name`, `password`, `roleId`, `phone`, `email`, `address`, `fax`) VALUES
('Admin', 'Sean D', '*A4B6157319038724E3560894F7F932C8886EBFCF', 1, 35386777, 'SeanD@moylishmotors.com', 'United States', '0000'),
('Bianca_Davies', 'Bianca Davies', 'No Password, as salesperson have no dashboard', 2, 61208206, 'bianca.davie@moylishmotors.ie', 'United States', '061208206'),
('Connie_Jackson', 'Connie Jackson', 'No Password, as salesperson have no dashboard', 2, 61208208, 'connie.jackson@moylishmotors.ie', 'United States', '061208208'),
('Dave_Lindale', 'Dave Lindale', 'No Password, as salesperson have no dashboard', 2, 61208209, 'dave.lindale@moylishmotors.ie', 'United States', '061209209'),
('Jack_Wanye', 'Jackie', '*23AE809DDACAF96AF0FD78ED04B6A265E05AA257', 3, NULL, 'Jack_Wanye@moylishmotor.ie', NULL, NULL),
('Mary_McKeown', 'Mary McKeown', 'No Password, as salesperson have no dashboard', 2, 61208207, 'mary.mckeown@moylishmotors.ie', 'United States', '061208207'),
('Terry_Dunlee', 'Terry Dunlee', 'No Password, as salesperson have no dashboard', 2, 61208205, 'terry.dunlee@moylishmotors.ie', 'United States', '061208205');

-- --------------------------------------------------------

--
-- Table structure for table `vehicles`
--

CREATE TABLE `vehicles` (
  `listing` int(100) NOT NULL,
  `year` int(100) DEFAULT NULL,
  `reg` varchar(100) DEFAULT NULL,
  `make` varchar(100) DEFAULT NULL,
  `model` varchar(100) DEFAULT NULL,
  `colour` varchar(100) DEFAULT NULL,
  `discription` text DEFAULT NULL,
  `buy_price` int(100) DEFAULT NULL,
  `list_price` int(100) DEFAULT NULL,
  `odometer` int(100) DEFAULT NULL,
  `kph` varchar(100) DEFAULT NULL,
  `engine` double DEFAULT NULL,
  `fuel` varchar(50) DEFAULT NULL,
  `transmission` varchar(50) DEFAULT NULL,
  `body` varchar(20) DEFAULT NULL,
  `isofix` varchar(20) DEFAULT NULL,
  `motor_tax` int(100) DEFAULT NULL,
  `previous_owners` int(100) DEFAULT NULL,
  `sales_person_username` varchar(20) DEFAULT NULL,
  `previous_owner_username` varchar(20) DEFAULT NULL,
  `full_service_history` varchar(50) DEFAULT NULL,
  `note` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicles`
--

INSERT INTO `vehicles` (`listing`, `year`, `reg`, `make`, `model`, `colour`, `discription`, `buy_price`, `list_price`, `odometer`, `kph`, `engine`, `fuel`, `transmission`, `body`, `isofix`, `motor_tax`, `previous_owners`, `sales_person_username`, `previous_owner_username`, `full_service_history`, `note`) VALUES
(12434, 2017, '02-D-567', 'Toyota', 'elite 50i', 'black', '                                                                                                                                                                                                                                                                        sdsd\r\n                         apple               \r\n                                        \r\n                                        \r\n                                        \r\n                                        \r\n                                        ', 12345, 13332, 564322, '5', 2, 'Diesel', 'Automatic', 'Saloon', 'Yes', 270, 2, 'Mary_McKeown', 'Jack_Wanye', 'No', 'sd'),
(12575, 2020, '12-D-450', 'Nissan', 'Caravan', 'white', 'okakakak', 1000000, 1080000, 56, '2', 2.1, 'Diesel', 'Automatic', 'Saloon', 'No', 2323, 2, 'Mary_McKeown', 'Jack_Wanye', 'Yes', 'sdsd'),
(232323, 2019, '119-L-7895', 'Lambo', '123', 'White', 'lambosss', 1000, 1080, 23235, '4', 2, 'Electric', 'Automatic', 'Hatchback', 'Yes', 2323, 2, 'Bianca_Davies', 'Jack_Wanye', 'Yes', 'none'),
(4294194, 2020, '202-CE-853', 'Opel', 'Elite 2.0D 170 Auto', 'Black', '                                                                                                                                                                                Highlights includes twin-spoke alloy wheels, IntelliLux LED matrix headlights, Front fog lights, Dark-tinted rear windows, Ergonomic active front seats, Leather seat facings, Heated front seats, 8-inch colour information display, Multimedia Navi Pro infotainment system with fully integrated European sat nav system, 8-inch colour touchscreen, AM/FM/DAB digital radio, BluetoothÃ????Ã???Ã??Ã?Â® audio streaming / mobile phone portal, Apple CarPlay / Android Auto, USB audio connection, Seven speakers (five front, two rear), Dual-zone electronic climate control, Illuminated vanity mirrors, Storage pockets on front seat backs, Ambient LED lighting in front doors, Twin rear USB sockets, Auto-dimming rear-view mirror and more\r\n                                        \r\n                                        \r\n                                        \r\n                                        ', 36799, 39742, 25462, '9', 2, 'Diesel', 'Automatic', 'Hatchback', 'No', 270, 1, 'Terry_Dunlee', 'Jack_Wanye', 'No', 'Reduced from Euros 41,000'),
(4294195, 2019, '202-CE-853', 'Hyundai', 'i30 i30N 2.0 T-GDi', 'Grey', 'Hello from the other side', 32200, 34776, 19855, '9.6', 2, 'Petrol', 'Manual', 'Hatchback', 'Yes', 270, 1, 'Bianca_Davies', 'Jack_Wanye', 'Yes', 'None'),
(4294196, 2016, '161-T-365', 'Toyota', 'Rav4 Luna 2.0D-4D', 'Slate', ' Highlights include reversing camera ,alloy wheels, abs brakes, fog lights bluetooth isofix points multiple airbags cloth trim electric windows and wing mirrors automatic headlights, immobiliser and cruise control.\r\n                                        ', 18308, 19772, 85411, '8.5', 2, 'Petrol', 'Manual', 'Hatchback', 'Yes', 270, 1, 'Dave_Lindale', 'Jack_Wanye', 'Yes', 'None'),
(123456789, 2020, 'REG-123', 'Tesla', 'Latest', 'Black', '                                            This car is the future of all\r\n                                        sdsd', 1000, 1080, 200, '2', 5.4, 'Electric', 'Automatic', 'Fit', 'Yes', 2000, 1, 'Mary_McKeown', 'Jack_Wanye', 'Yes', 'No note for now');

-- --------------------------------------------------------

--
-- Table structure for table `vehicle_images`
--

CREATE TABLE `vehicle_images` (
  `id` int(11) NOT NULL,
  `listing` int(200) NOT NULL,
  `image_path` varchar(1000) NOT NULL,
  `image_type` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `vehicle_images`
--

INSERT INTO `vehicle_images` (`id`, `listing`, `image_path`, `image_type`) VALUES
(60, 4294194, 'C:\\Users\\dell\\Documents\\NetBeansProjects\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/4294194/images\\4294194.JPG', 'I'),
(61, 4294194, 'C:\\Users\\dell\\Documents\\NetBeansProjects\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/4294194/images\\4294194-1.JPG', 'I'),
(62, 4294194, 'C:\\Users\\dell\\Documents\\NetBeansProjects\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/4294194/images\\4294194-2.JPG', 'I'),
(63, 4294194, 'C:\\Users\\dell\\Documents\\NetBeansProjects\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/4294194/images\\4294194-3.JPG', 'I'),
(65, 4294194, 'C:\\Users\\dell\\Documents\\NetBeansProjects\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/4294194/thumbnail/\\4294194.JPG', 'T'),
(74, 12434, 'C:\\Users\\HP\\Desktop\\Projects\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/12434/images\\4294224-1.JPG', 'I'),
(76, 4294195, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/4294195/images\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42941984294198-1.JPG', 'I'),
(77, 4294195, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/4294195/images\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42941984294198-2.JPG', 'I'),
(78, 4294195, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/4294195/images\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42941984294198-3.JPG', 'I'),
(79, 4294195, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/4294195/thumbnail/\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42941984294198.JPG', 'T'),
(80, 4294196, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/4294196/images\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42941984294198-1.JPG', 'I'),
(81, 4294196, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/4294196/images\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42941984294198-2.JPG', 'I'),
(82, 4294196, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/4294196/images\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42941984294198-5.JPG', 'I'),
(83, 4294196, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/4294196/images\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42941984294198-6.JPG', 'I'),
(84, 4294196, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/4294196/thumbnail/\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42941984294198.JPG', 'T'),
(85, 123456789, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/123456789/images\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42942024294202.JPG', 'I'),
(86, 123456789, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/123456789/images\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42942024294202-1.JPG', 'I'),
(87, 123456789, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/123456789/thumbnail/\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42942024294202.JPG', 'T'),
(88, 12575, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/12575/images\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42942134294213.jpg', 'I'),
(89, 12575, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/12575/images\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42942134294213-1.JPG', 'I'),
(90, 12575, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/12575/images\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42942134294213-2.JPG', 'I'),
(91, 12575, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/12575/images\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42942134294213-3.JPG', 'I'),
(92, 12575, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/12575/thumbnail/\\C:UsersHPDesktopGitHubassignment-two-sean-daly1337Supplementary MaterialsStockLarge42942134294213.jpg', 'T'),
(101, 12434, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/12434/images\\4294198-3.JPG', 'I'),
(102, 12434, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/12434/images\\4294198-4.JPG', 'I'),
(103, 12434, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/12434/images\\4294198-5.JPG', 'I'),
(104, 12434, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/12434/images\\4294198-6.JPG', 'I'),
(105, 12434, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/12434/thumbnail/\\4294200.jpg', 'T'),
(106, 232323, 'C:\\Users\\HP\\Desktop\\GitHub\\assignment-two-sean-daly1337\\Moylish_Motors3\\target\\Moylish_Motors3-1.0-SNAPSHOT\\UPLOADS/232323/images\\4294202.JPG', 'I');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `favourites`
--
ALTER TABLE `favourites`
  ADD PRIMARY KEY (`username`,`listing`),
  ADD KEY `FK_listing22` (`listing`);

--
-- Indexes for table `sold_cars`
--
ALTER TABLE `sold_cars`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `trades`
--
ALTER TABLE `trades`
  ADD PRIMARY KEY (`trade_id`),
  ADD KEY `FK_User_Car_Listing` (`user_car_listing`),
  ADD KEY `FK_traded_Car_Listing` (`traded_car_listing`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `vehicles`
--
ALTER TABLE `vehicles`
  ADD PRIMARY KEY (`listing`),
  ADD KEY `sp_username_fk` (`sales_person_username`),
  ADD KEY `owner_username_fk` (`previous_owner_username`);

--
-- Indexes for table `vehicle_images`
--
ALTER TABLE `vehicle_images`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Listing1` (`listing`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `sold_cars`
--
ALTER TABLE `sold_cars`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `trades`
--
ALTER TABLE `trades`
  MODIFY `trade_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `vehicles`
--
ALTER TABLE `vehicles`
  MODIFY `listing` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=123456790;

--
-- AUTO_INCREMENT for table `vehicle_images`
--
ALTER TABLE `vehicle_images`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=178;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `favourites`
--
ALTER TABLE `favourites`
  ADD CONSTRAINT `FK_listing22` FOREIGN KEY (`listing`) REFERENCES `vehicles` (`listing`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_username` FOREIGN KEY (`username`) REFERENCES `user` (`username`) ON DELETE CASCADE;

--
-- Constraints for table `trades`
--
ALTER TABLE `trades`
  ADD CONSTRAINT `FK_User_Car_Listing` FOREIGN KEY (`user_car_listing`) REFERENCES `vehicles` (`listing`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_traded_Car_Listing` FOREIGN KEY (`traded_car_listing`) REFERENCES `vehicles` (`listing`) ON DELETE CASCADE;

--
-- Constraints for table `vehicles`
--
ALTER TABLE `vehicles`
  ADD CONSTRAINT `owner_username_fk` FOREIGN KEY (`previous_owner_username`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `sp_username_fk` FOREIGN KEY (`sales_person_username`) REFERENCES `user` (`username`);

--
-- Constraints for table `vehicle_images`
--
ALTER TABLE `vehicle_images`
  ADD CONSTRAINT `FK_Listing` FOREIGN KEY (`listing`) REFERENCES `vehicles` (`listing`),
  ADD CONSTRAINT `FK_Listing1` FOREIGN KEY (`listing`) REFERENCES `vehicles` (`listing`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
