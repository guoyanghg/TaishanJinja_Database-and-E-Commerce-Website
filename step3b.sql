

CREATE DATABASE IF NOT EXISTS `comicstore4`;

USE `comicstore4`;

/*账户信息表 */

DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `userid` VARCHAR(80) NOT NULL,
  `email` VARCHAR(80) NOT NULL,
  `firstname` VARCHAR(80) NOT NULL,
  `lastname` VARCHAR(80) NOT NULL,
  `status` VARCHAR(2) DEFAULT NULL,
  `addr1` VARCHAR(80) NOT NULL,
  `addr2` VARCHAR(40) DEFAULT NULL,
  `city` VARCHAR(80) NOT NULL,
  `state` VARCHAR(80) NOT NULL,
  `zip` VARCHAR(20) NOT NULL,
  `country` VARCHAR(20) NOT NULL,
  `phone` VARCHAR(80) NOT NULL,
  `balance` DECIMAL(20,2) NOT NULL,      
  PRIMARY KEY  (`userid`)
) CHARSET=utf8;



/*大目录表 */

DROP TABLE IF EXISTS `category`;

CREATE TABLE `category` (
  `catid` VARCHAR(10) NOT NULL,
  `name` VARCHAR(80) DEFAULT NULL,
  PRIMARY KEY  (`catid`),
  KEY `ixcategoryproduct` (`catid`)
) CHARSET=utf8;



/*中类别表 */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `productid` VARCHAR(80) NOT NULL,
  `category` VARCHAR(10) NOT NULL,
  `name` VARCHAR(80) DEFAULT NULL,
  PRIMARY KEY  (`productid`),
  KEY `productcat` (`category`),
  KEY `productname` (`name`),
  CONSTRAINT `product_ibfk_1` FOREIGN KEY (`category`) REFERENCES `category` (`catid`)
) CHARSET=utf8;



/*Table structure for table `item` */

DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `itemid` VARCHAR(10) NOT NULL,
  `productid` VARCHAR(10) NOT NULL,
  `listprice` DECIMAL(10,2) DEFAULT NULL,
  `accountid` VARCHAR(80) DEFAULT NULL,
  `status` VARCHAR(10) DEFAULT NULL,
  `attr1` VARCHAR(80) DEFAULT NULL,
  `attr2` VARCHAR(80) DEFAULT NULL,
  `attr3` VARCHAR(80) DEFAULT NULL,
  `attr4` VARCHAR(80) DEFAULT NULL,
  `attr5` VARCHAR(80) DEFAULT NULL,      
  PRIMARY KEY  (`itemid`),
  KEY `itemprod` (`productid`),
  KEY `accountid` (`accountid`),
  CONSTRAINT `item_ibfk_1` FOREIGN KEY (`productid`) REFERENCES `product` (`productid`),
  CONSTRAINT `item_ibfk_2` FOREIGN KEY (`accountid`) REFERENCES `account` (`userid`)
) CHARSET=utf8;

/*库存量表*/
DROP TABLE IF EXISTS `inventory`;

CREATE TABLE `inventory` (
  `itemid` VARCHAR(10) NOT NULL,
  `qty` INT(11) NOT NULL,
  PRIMARY KEY  (`itemid`),
  CONSTRAINT `item_inventory` FOREIGN KEY (`itemid`) REFERENCES `item`(`itemid`)
) CHARSET=utf8;

/*订单表 */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `orderid` INT(11) NOT NULL AUTO_INCREMENT, 
  `userid` VARCHAR(80) NOT NULL,
  `orderdate` DATE NOT NULL,
  `shipaddr1` VARCHAR(80) NOT NULL,
  `shipaddr2` VARCHAR(80) DEFAULT NULL,
  `shipcity` VARCHAR(80) NOT NULL,
  `shipstate` VARCHAR(80) NOT NULL,
  `shipzip` VARCHAR(20) NOT NULL,
  `shipcountry` VARCHAR(20) NOT NULL,
  `totalprice` DECIMAL(10,2) NOT NULL,
  `shiptofirstname` VARCHAR(80) NOT NULL,
  `shiptolastname` VARCHAR(80) NOT NULL,
  `billaddr1` VARCHAR(80) NOT NULL,
  `billaddr2` VARCHAR(80) DEFAULT NULL,
  `billcity` VARCHAR(80) NOT NULL,
  `billstate` VARCHAR(80) NOT NULL,
  `billzip` VARCHAR(20) NOT NULL,
  `billcountry` VARCHAR(20) NOT NULL,
  `courier` VARCHAR(80) NOT NULL,
  `billtofirstname` VARCHAR(80) NOT NULL,
  `billtolastname` VARCHAR(80) NOT NULL,
  `creditcard` VARCHAR(80) NOT NULL,
  `exprdate` DATE NOT NULL,
  `cardtype` VARCHAR(80) NOT NULL,
  `sellerid` VARCHAR(80) NOT NULL,
  `itemid` VARCHAR(10) NOT NULL,
  `qty` INT NOT NULL,
  PRIMARY KEY  (`orderid`)
) CHARSET=utf8;

/*订单状态表 */

DROP TABLE IF EXISTS `orderstatus`;

CREATE TABLE `orderstatus` (
  `orderid` INT(11) NOT NULL,
  `linenum` INT(11) NOT NULL,
  `timestamp` DATE NOT NULL,
  `status` VARCHAR(2) NOT NULL,
  PRIMARY KEY  (`orderid`,`linenum`),
  CONSTRAINT `order_status` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`)
) CHARSET=utf8;



DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
    `itemid` VARCHAR(10) NOT NULL,
    `userid` VARCHAR(80) NOT NULL,
    `rating` DECIMAL(10,2) DEFAULT 0,
    `content` VARCHAR(800) NOT NULL,
    `date` DATE NOT NULL,
    `orderid` INT(11) NOT NULL,  
    PRIMARY KEY (`orderid`),
    CONSTRAINT `comment_item` FOREIGN KEY (`itemid`) REFERENCES `item` (`itemid`),
    CONSTRAINT `comment_user` FOREIGN KEY (`userid`) REFERENCES `account` (`userid`),
    CONSTRAINT `comment_ord` FOREIGN KEY (`orderid`) REFERENCES `orders` (`orderid`)
)CHARSET=utf8;


DROP TABLE IF EXISTS `signon`;

CREATE TABLE `signon` (
  `username` VARCHAR(80) NOT NULL,
  `password` VARCHAR(25) NOT NULL,
  PRIMARY KEY  (`username`),
  CONSTRAINT `sign_acc` FOREIGN KEY (`username`) REFERENCES `account` (`userid`)
) CHARSET=utf8;
