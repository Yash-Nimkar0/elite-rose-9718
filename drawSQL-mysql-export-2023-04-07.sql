CREATE TABLE `admin`(
    `admin_id` INT NOT NULL,
    `admin_usernamer` VARCHAR(255) NULL,
    `admin_EMAIL` VARCHAR(255) NULL,
    `admin_password` VARCHAR(255) NULL
);
ALTER TABLE
    `admin` ADD PRIMARY KEY(`admin_id`);
CREATE TABLE `consumer`(
    `consumer_id` INT NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(255) NOT NULL,
    `last_name` VARCHAR(255) NOT NULL,
    `username` VARCHAR(255) NOT NULL,
    `password` VARCHAR(255) NOT NULL,
    `address` VARCHAR(255) NOT NULL,
    `mobile_number` VARCHAR(255) NOT NULL,
    `email` VARCHAR(255) NOT NULL,
    `is_active` TINYINT NULL DEFAULT '' 1 ''
);
ALTER TABLE
    `consumer` ADD PRIMARY KEY(`consumer_id`);
ALTER TABLE
    `consumer` ADD UNIQUE `consumer_username_unique`(`username`);
CREATE TABLE `transaction`(
    `transaction_id` INT NOT NULL AUTO_INCREMENT,
    `consumer_id` INT NOT NULL,
    `amount` DECIMAL(8, 2) NOT NULL,
    `payment_date` TIMESTAMP NOT NULL DEFAULT 'CURRENT_TIMESTAMP'
);
ALTER TABLE
    `transaction` ADD PRIMARY KEY(`transaction_id`);
ALTER TABLE
    `transaction` ADD INDEX `transaction_consumer_id_index`(`consumer_id`);
CREATE TABLE `bill`(
    `bill_no` INT NOT NULL AUTO_INCREMENT,
    `consumer_id` INT NOT NULL,
    `amount` DECIMAL(8, 2) NOT NULL,
    `bill_from` DATE NULL,
    `bill_to` DATE NULL,
    `status` INT NULL DEFAULT '' 0 ''
);
ALTER TABLE
    `bill` ADD PRIMARY KEY(`bill_no`);
ALTER TABLE
    `bill` ADD INDEX `bill_consumer_id_index`(`consumer_id`);
ALTER TABLE
    `bill` ADD CONSTRAINT `bill_consumer_id_foreign` FOREIGN KEY(`consumer_id`) REFERENCES `consumer`(`consumer_id`);
ALTER TABLE
    `transaction` ADD CONSTRAINT `transaction_consumer_id_foreign` FOREIGN KEY(`consumer_id`) REFERENCES `consumer`(`consumer_id`);