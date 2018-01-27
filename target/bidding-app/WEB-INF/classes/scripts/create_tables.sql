CREATE TABLE `user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(50) NOT NULL DEFAULT '',
  `name` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `catalog` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `bid_start` datetime DEFAULT NULL,
  `bid_end` datetime DEFAULT NULL,
  `creator_id` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_catalog_user_idx` (`creator_id`),
  CONSTRAINT `fk_catalog_user_idx` FOREIGN KEY (`creator_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `item` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `catalog_id` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_item_catalog_idx` (`catalog_id`),
  CONSTRAINT `fk_item_catalog_idx` FOREIGN KEY (`catalog_id`) REFERENCES `catalog` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE `bid` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `amount` float(10,0) NOT NULL,
  `catalog_id` int(11) unsigned NOT NULL,
  `bidder_id` int(11) unsigned NOT NULL,
  `bid_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bid_catalog_idx` (`catalog_id`),
  CONSTRAINT `fk_bid_catalog_idx` FOREIGN KEY (`catalog_id`) REFERENCES `catalog` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  KEY `fk_bid_user_idx` (`bidder_id`),
  CONSTRAINT `fk_bid_user_idx` FOREIGN KEY (`bidder_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;