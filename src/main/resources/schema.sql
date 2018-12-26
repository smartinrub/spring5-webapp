CREATE TABLE IF NOT EXISTS `hotels` (
    `id` FLOAT NOT NULL PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `address` VARCHAR(50) NOT NULL,
    `rating` FLOAT NOT NULL,
  );