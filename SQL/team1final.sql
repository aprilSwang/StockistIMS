CREATE schema team1;
USE team1;

CREATE TABLE `team1`.`customer` (
  `customerID` int(15) unsigned NOT NULL AUTO_INCREMENT,
  `customerName` varchar(45) NOT NULL,
  `email` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`customerID`));

CREATE TABLE `team1`.`product` (
  `partNumber` int(15) NOT NULL,
  `unitPrice` int(15) DEFAULT NULL,
  `quantity` int(15) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  `color` varchar(15) DEFAULT NULL,
  `dimension` varchar(45) DEFAULT NULL,
  `manufacturer` varchar(45) DEFAULT NULL,
  `reorderLevel` int(15) DEFAULT NULL,
  `minReorderQnty` int(15) DEFAULT NULL,
  `supplierName` varchar(45) NOT NULL,
  `shelfLocation` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`partNumber`));

CREATE TABLE `team1`.`role` (
  `roleID` varchar(15) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `description` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`roleid`));

CREATE TABLE `team1`.`supplier` (
  `supplierID` int(15) unsigned NOT NULL AUTO_INCREMENT,
  `supplierName` varchar(45) NOT NULL,
  `email` varchar(30) NOT NULL,
  PRIMARY KEY (`supplierID`));

CREATE TABLE `team1`.`transaction` (
  `transactionID` int(15) unsigned NOT NULL AUTO_INCREMENT,
  `userID` int(15) NOT NULL,
  `quantity` int(15) DEFAULT NULL,
  `partNumber` int(15) NOT NULL,
  `customerName` varchar(45) NOT NULL,
  `transactionDate` date DEFAULT NULL,
  PRIMARY KEY (`transactionID`),
  KEY `part_Number` (`partNumber`),
  CONSTRAINT `part_Number` FOREIGN KEY (`partNumber`) REFERENCES `product` (`partNumber`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

CREATE TABLE `team1`.`user` (
  `userID` int(15) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`userid`));

CREATE TABLE `team1`.`userrole` (
  `roleID` varchar(15) NOT NULL,
  `userID` int(15) NOT NULL,
  PRIMARY KEY (`roleid`,`userid`),
  KEY `ufk` (`userid`),
  CONSTRAINT `rfk` FOREIGN KEY (`roleid`) REFERENCES `role` (`roleid`) ON DELETE NO ACTION ON UPDATE NO ACTION);

INSERT INTO `team1`.`user` (`name`, `password`) VALUES ('Christine', 'password1');
INSERT INTO `team1`.`user` (`name`, `password`) VALUES ('Luowei', 'password2');
INSERT INTO `team1`.`user` (`name`, `password`) VALUES ('Reuben', 'password3');
INSERT INTO `team1`.`user` (`name`, `password`) VALUES ('Sookian', 'password4');

INSERT INTO `team1`.`customer` (`customerID`, `customerName`, `email`) VALUES ('1', 'Caojian', 'cj@yahoo.com');
INSERT INTO `team1`.`customer` (`customerID`, `customerName`, `email`) VALUES ('2', 'Luozhirong', 'lz@yahoo.com');
INSERT INTO `team1`.`customer` (`customerID`, `customerName`, `email`) VALUES ('3', 'April', 'ap@yahoo.com');
INSERT INTO `team1`.`customer` (`customerID`, `customerName`, `email`) VALUES ('4', 'Ariz', 'aa@yahoo.com');

INSERT INTO `team1`.`product` (`partNumber`, `unitPrice`, `quantity`, `description`, `color`, `manufacturer`, `reorderLevel`, `minReorderQnty`, `supplierName`, `shelfLocation`) VALUES ('1000', '3000', '5', 'Flywheel Clutch', 'Silver', 'Lamborghini', '2', '2', 'Zupermann Autospares', 'a1');
INSERT INTO `team1`.`product` (`partNumber`, `unitPrice`, `quantity`, `description`, `color`, `manufacturer`, `reorderLevel`, `minReorderQnty`, `supplierName`, `shelfLocation`) VALUES ('2000', '410', '3', 'Fan wheel', 'Black', 'Lamborghini', '1', '2', 'Zupermann Autospares', 'a2');
INSERT INTO `team1`.`product` (`partNumber`, `unitPrice`, `quantity`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minReorderQnty`, `supplierName`, `shelfLocation`) VALUES ('3000', '127', '2', 'Air Filter', 'White', '50cm', 'Maserati', '1', '2', 'Zupermann Zutospares', 'a3');
INSERT INTO `team1`.`product` (`partNumber`, `unitPrice`, `quantity`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minReorderQnty`, `supplierName`, `shelfLocation`) VALUES ('4000', '527', '4', 'Silent Block Kit', 'Silver', '30cm', 'Maserati', '2', '2', 'Zupermann Autospares', 'a4');
INSERT INTO `team1`.`product` (`partNumber`, `unitPrice`, `quantity`, `description`, `manufacturer`, `reorderLevel`, `minReorderQnty`, `supplierName`, `shelfLocation`) VALUES ('5000', '42', '50', 'Transmission Fluid', 'Toyota', '15', '15', 'Transglober Auto', 'b1');
INSERT INTO `team1`.`product` (`partNumber`, `unitPrice`, `quantity`, `description`, `color`, `manufacturer`, `reorderLevel`, `minReorderQnty`, `supplierName`, `shelfLocation`) VALUES ('6000', '5', '60', 'Spark Plug', 'White', 'Toyota', '20', '20', 'Transglober Auto', 'b2');
INSERT INTO `team1`.`product` (`partNumber`, `unitPrice`, `quantity`, `description`, `manufacturer`, `reorderLevel`, `minReorderQnty`, `supplierName`, `shelfLocation`) VALUES ('7000', '6', '58', 'Oil Filter', 'Toyota', '20', '20', 'Transglober Auto', 'b3');
INSERT INTO `team1`.`product` (`partNumber`, `unitPrice`, `quantity`, `description`, `color`, `manufacturer`, `reorderLevel`, `minReorderQnty`, `supplierName`, `shelfLocation`) VALUES ('8000', '5', '49', 'Brake Pad', 'Black', 'Toyota', '15', '20', 'Transglober Auto', 'b4');
INSERT INTO `team1`.`product` (`partNumber`, `unitPrice`, `quantity`, `description`, `color`, `manufacturer`, `reorderLevel`, `minReorderQnty`, `supplierName`, `shelfLocation`) VALUES ('9000', '60', '30', 'Front/Rear Shock Absorbers', 'Black', 'Toyota', '10', '10', 'Transglober Auto', 'b5');
INSERT INTO `team1`.`product` (`partNumber`, `unitPrice`, `quantity`, `description`, `color`, `manufacturer`, `reorderLevel`, `minReorderQnty`, `supplierName`, `shelfLocation`) VALUES ('1100', '280', '10', 'Throttle Controller', 'Black', 'Honda', '5', '5', 'Gsp Precision', 'c1');
INSERT INTO `team1`.`product` (`partNumber`, `unitPrice`, `quantity`, `description`, `color`, `dimension`, `manufacturer`, `reorderLevel`, `minReorderQnty`, `supplierName`, `shelfLocation`) VALUES ('1200', '200', '15', 'Rim', 'Black', '18 inches', 'Honda', '5', '5', 'Gsp Precision', 'c2');

INSERT INTO `team1`.`supplier` (`supplierID`, `supplierName`, `email`) VALUES ('1', 'Zupermann Autospares', 'zuper@yahoo.com');
INSERT INTO `team1`.`supplier` (`supplierID`, `supplierName`, `email`) VALUES ('2', 'Transglober Auto', 'transglober@yahoo.com');
INSERT INTO `team1`.`supplier` (`supplierID`, `supplierName`, `email`) VALUES ('3', 'Gsp Precision', 'gsp@yahoo.com');

INSERT INTO `team1`.`transaction` (`transactionID`, `userID`, `quantity`, `partNumber`, `customerName`, `transactionDate`) VALUES ('0001', '1', '1', '2000', 'ariz', '2017-01-01');
INSERT INTO `team1`.`transaction` (`transactionID`, `userID`, `quantity`, `partNumber`, `customerName`, `transactionDate`) VALUES ('0002', '2', '2', '8000', 'april', '2017-06-01');
INSERT INTO `team1`.`transaction` (`transactionID`, `userID`, `quantity`, `partNumber`, `customerName`, `transactionDate`) VALUES ('0003', '3', '1', '6000', 'caojian', '2017-12-12');

INSERT INTO `team1`.`role`(`roleID`,`name`, `description`)VALUES('admin','Admin Clerk', 'Administrator');
INSERT INTO `team1`.`role`(`roleID`,`name`, `description`)VALUES('mech','Mechanic', 'Mechanic');

INSERT INTO `team1`.`userrole`(`roleID`,`userID`)VALUES('admin','1');
INSERT INTO `team1`.`userrole`(`roleID`,`userID`)VALUES('admin','2');
INSERT INTO `team1`.`userrole`(`roleID`,`userID`)VALUES('mech','3');
INSERT INTO `team1`.`userrole`(`roleID`,`userID`)VALUES('admin','4');