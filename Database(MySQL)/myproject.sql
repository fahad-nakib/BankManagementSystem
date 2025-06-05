-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2025 at 07:20 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `myproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `administrator`
--

CREATE TABLE `administrator` (
  `admin_id` int(10) NOT NULL,
  `admin_pass` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `administrator`
--

INSERT INTO `administrator` (`admin_id`, `admin_pass`) VALUES
(221902149, '$$$$$');

-- --------------------------------------------------------

--
-- Table structure for table `balance`
--

CREATE TABLE `balance` (
  `user_id` int(10) NOT NULL,
  `balance_amount` double(10,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `balance`
--

INSERT INTO `balance` (`user_id`, `balance_amount`) VALUES
(2000, 450.000),
(2001, 10.000),
(2002, 70.000),
(2003, 250.000),
(2004, 890.000),
(2008, 2500.000),
(2009, 5000.000),
(2010, 0.000),
(2011, 0.000),
(2012, 500.000),
(2013, 2500.000),
(2014, 3500.000),
(2015, 3500.000),
(2016, 0.000);

-- --------------------------------------------------------

--
-- Table structure for table `branch`
--

CREATE TABLE `branch` (
  `branch_id` int(11) NOT NULL,
  `branch_name` varchar(30) DEFAULT NULL,
  `location` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `branch`
--

INSERT INTO `branch` (`branch_id`, `branch_name`, `location`) VALUES
(300, 'Araihazar', 'Narayangonj-Araihazar'),
(302, 'Rupganj', 'Narayangonj'),
(304, 'Tongi', 'Gazipur-Tongi'),
(306, 'Uttara', 'Dhaka-Uttara');

-- --------------------------------------------------------

--
-- Table structure for table `designation`
--

CREATE TABLE `designation` (
  `designation_id` int(11) NOT NULL,
  `designation_name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `designation`
--

INSERT INTO `designation` (`designation_id`, `designation_name`) VALUES
(500, 'Administrator'),
(501, 'Manager'),
(502, 'Accountant'),
(503, 'Security Gard'),
(504, 'Electritian'),
(505, 'Helper');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `employee_id` int(11) NOT NULL,
  `employee_name` varchar(40) DEFAULT NULL,
  `address` varchar(70) DEFAULT NULL,
  `phone` int(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `age` int(5) DEFAULT NULL,
  `emp_pass` varchar(30) DEFAULT NULL,
  `joining_date` varchar(15) DEFAULT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `designation_id` int(10) DEFAULT NULL,
  `branch_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`employee_id`, `employee_name`, `address`, `phone`, `email`, `age`, `emp_pass`, `joining_date`, `gender`, `designation_id`, `branch_id`) VALUES
(1001, 'Rasel Moa', 'Digholdi-Araihazar-Narayangonj', 1933345672, 'rasel@gmail.com', 30, '1234567', '11-12-12', 'Male', 502, 300),
(1003, 'Md. Anik Hasan', 'Narayangonj-Chasara', 1978654325, 'anik@gmail.com', 34, '2255', '23-9-23', 'Male', 502, 300),
(1004, 'Md.Fahad Nakib', 'Narayanganj-Araihazar-Digholdi', 1963642898, 'fahadnakib@gmail.com', 22, '*****', '11-12-2001', 'Male', 501, 300),
(1005, 'Md. Nafijul Islam', 'Gazipur-Tongi', 1876452378, 'nafijul@gmail.com', 22, '008877', '11-12-2002', 'Male', 501, 304),
(1006, 'Md. Shihabur Rahman', 'Comilla-kurigram', 1999233344, 'shihabur@gmail.com', 22, '446688', '14-06-2001', 'Male', 501, 302),
(1007, 'Rafiqu Mahbub', 'Narayanganj-Kachan', 1823456432, 'mahbub@gmail.com', 23, '335577', '22-12-2001', 'Male', 502, 302),
(1008, 'Himal Chowdhuri', 'Narayanganj-Rupganj-Kanchan', 184554543, 'Himal@gmail.com', 21, '113300', '11-02-2002', 'Male', 502, 302),
(1009, 'Shamima Akter', 'Gazipur-Tongi', 132456789, 'shamima@gmail.com', 19, 'sa11ma', '11-12-2003', 'Female', 502, 304),
(1010, 'Sadia Akter', 'Gazipur-Tongi', 187675433, 'sadia@gmail.com', 20, 'sa91ya', '22-12-2002', 'Female', 502, 304),
(1011, 'Hasnat Zamil Sayed', 'Tangail', 199834334, 'zamil@gmail.com', 24, '224477', '11-03-2000', 'Male', 501, 306),
(1012, 'Sumaiya Akter', 'Dhaka-Airport Road', 87543344, 'emon@gamil.com', 22, '33551', '13-05-2001', 'Male', 502, 306),
(1013, 'Obontika Jannat', 'Dhaka-Airport Road', 17634364, 'obontika@gmail.com', 22, 'obonti22', '23-02-2001', 'Male', 502, 306),
(1014, 'Hasan Ali', 'Araihazar-Narayanganj', 998332213, 'hasan@gmail.com', 22, 'has123', '18-12-23', 'Male', 503, 300),
(1015, 'Arif Khan', 'Araihazar-Narayangonj', 222343344, 'arifkhan@gmail.com', 23, 'arif123', '18-12-23', 'Male', 503, 300),
(1016, 'Masum Mia', 'Narshindi', 3455643, 'masum@gmail.com', 25, 'masum123', '18-12-23', 'Male', 504, 300),
(1017, 'Nasir Ali', 'Narshindi', 3435546, 'nasirali@gmail.com', 19, 'nasir123', '12-18-23', 'Male', 505, 300),
(1018, 'Himel Khan', 'Rupganj-Narayangonj', 233566643, 'himel@gmail.com', 23, 'himel123', '12-12-23', 'Male', 503, 302),
(1019, 'Rahul', 'Mayarbari-Narayanganj', 212445432, 'rahul@gmail.com', 21, 'rahul123', '18-12-23', 'Male', 503, 302),
(1020, 'Sahida Begum', 'Rupganj-Narayanganj', 543434342, 'sahida@gmail.com', 36, 'sahida123', '12-12-23', 'Female', 505, 302),
(1021, 'Saiful Mia', 'Voal_Sylhet', 64543322, 'saiful@gmail.com', 29, 'saiful123', '14-07-21', 'Male', 504, 302),
(1023, 'Sapuri', 'Chasara-Narayanganj', 44342323, 'sapuri@gmail.com', 22, 'sapuri123', '18-12-23', 'Female', 502, 302),
(1024, 'Dipuri', 'Chasara-Narayanganj', 34324232, 'dipuri@gmail.com', 23, 'dipuri123', '12-12-23', 'Female', 505, 302),
(1028, 'Md.Farukh Ahmed', 'Araihazar-Narayanganj', 932323, 'farukh@gmail.com', 34, '1144', '12-12-23', 'Male', 502, 306);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `user_id` int(11) DEFAULT NULL,
  `oppinion` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `loan`
--

CREATE TABLE `loan` (
  `user_id` int(11) NOT NULL,
  `amount` double(10,3) DEFAULT NULL,
  `issu_date` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `loan`
--

INSERT INTO `loan` (`user_id`, `amount`, `issu_date`) VALUES
(2000, 600.000, '12-12-23'),
(2001, 250.000, '12-7-23'),
(2002, 350.000, '12-12-23'),
(2008, 700.000, '12-12-23');

-- --------------------------------------------------------

--
-- Table structure for table `practice`
--

CREATE TABLE `practice` (
  `roll` int(11) NOT NULL,
  `name` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `practice`
--

INSERT INTO `practice` (`roll`, `name`) VALUES
(1000, 'Fahad'),
(1001, 'Nakib'),
(1002, 'Mohammad'),
(1004, 'Rahman'),
(1005, '[value-2]'),
(1006, 'Another');

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `designation_id` int(10) NOT NULL,
  `salary_amount` double(10,3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `salary`
--

INSERT INTO `salary` (`designation_id`, `salary_amount`) VALUES
(500, 800000.000),
(501, 600000.000),
(502, 30000.000),
(503, 7000.000),
(504, 15000.000),
(505, 7000.000);

-- --------------------------------------------------------

--
-- Table structure for table `user_table`
--

CREATE TABLE `user_table` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(40) DEFAULT NULL,
  `address` varchar(70) DEFAULT NULL,
  `phone` int(15) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `age` int(5) DEFAULT NULL,
  `user_pass` varchar(30) DEFAULT NULL,
  `branch_id` int(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user_table`
--

INSERT INTO `user_table` (`user_id`, `user_name`, `address`, `phone`, `email`, `age`, `user_pass`, `branch_id`) VALUES
(2000, 'Karim Mia', 'Barishal', 2147483647, 'karim@gmail.com', 34, 'abcd3321', 300),
(2001, 'Shamir', 'Bhulta-Rupganj-Narayangonj', 1544333223, 'shamir@gmail.com', 34, '444333', 302),
(2002, 'Shibra', 'Araihazar-Narayangonj', 196364422, 'shibra@gmail.com', 23, '3333', 300),
(2003, 'Rahim', 'Araihazar-Narayangonj', 1345678343, 'rahim@gmail.com', 30, '2222', 300),
(2004, 'Rasel Mia', 'Araihazar-Narayangonj', 1487668767, 'rasel@gmail.com', 39, '1111', 300),
(2008, 'Abdur Rahman', 'Araihazare-Narayangonj', 34343323, 'arahman@gmail.com', 35, 'rahman123', 300),
(2009, 'Abul Kasem', 'Araihazare-Narayangonj', 454533, 'akasem@gmail.com', 40, 'kasem123', 300),
(2010, 'Mr.Wahid Khan', 'Rupganj-Narayngonj', 3432232, 'wahid@gmail.com', 45, 'wahid123', 302),
(2011, 'Mr.Wahid Khan', 'Rupganj-Narayngonj', 3432232, 'wahid@gmail.com', 45, 'wahid123', 300),
(2012, 'Amena Begum', 'Rupganj-Narayngonj', 3445343, 'amena@gmail.com', 40, 'amena123', 302),
(2013, 'Rahima Begum', 'Rupganj-Narayngonj', 6786564, 'rahima@gmail.com', 38, 'rahima123', 302),
(2014, 'Karim Mia', 'Rupganj-Narayngonj', 77734342, 'karim@gmail.com', 55, 'karim123', 302),
(2015, 'Malek Mia', 'Rupganj-Narayngonj', 11123343, 'malek@gmail.com', 60, 'malek123', 302),
(2016, 'Malek Mia', 'Araihazar-Narayanganj', 45434, 'malek@gmail.com', 43, '2233', 300);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `administrator`
--
ALTER TABLE `administrator`
  ADD PRIMARY KEY (`admin_id`);

--
-- Indexes for table `balance`
--
ALTER TABLE `balance`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `branch`
--
ALTER TABLE `branch`
  ADD PRIMARY KEY (`branch_id`);

--
-- Indexes for table `designation`
--
ALTER TABLE `designation`
  ADD PRIMARY KEY (`designation_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`employee_id`),
  ADD KEY `branch_id` (`branch_id`),
  ADD KEY `designation_id` (`designation_id`);

--
-- Indexes for table `loan`
--
ALTER TABLE `loan`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `practice`
--
ALTER TABLE `practice`
  ADD PRIMARY KEY (`roll`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD PRIMARY KEY (`designation_id`);

--
-- Indexes for table `user_table`
--
ALTER TABLE `user_table`
  ADD PRIMARY KEY (`user_id`),
  ADD KEY `branch_id` (`branch_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `branch`
--
ALTER TABLE `branch`
  MODIFY `branch_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=308;

--
-- AUTO_INCREMENT for table `designation`
--
ALTER TABLE `designation`
  MODIFY `designation_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=506;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `employee_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1029;

--
-- AUTO_INCREMENT for table `practice`
--
ALTER TABLE `practice`
  MODIFY `roll` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1007;

--
-- AUTO_INCREMENT for table `user_table`
--
ALTER TABLE `user_table`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2017;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employee`
--
ALTER TABLE `employee`
  ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`),
  ADD CONSTRAINT `employee_ibfk_2` FOREIGN KEY (`designation_id`) REFERENCES `designation` (`designation_id`);

--
-- Constraints for table `user_table`
--
ALTER TABLE `user_table`
  ADD CONSTRAINT `user_table_ibfk_1` FOREIGN KEY (`branch_id`) REFERENCES `branch` (`branch_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
