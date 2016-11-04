DROP SCHEMA IF EXISTS `demo_jpa` ;
CREATE SCHEMA IF NOT EXISTS `demo_jpa` 
	DEFAULT CHARACTER SET = 'utf8' 
	DEFAULT COLLATE 'utf8_general_ci';
-- CREATE USER 'javauser'@'localhost' IDENTIFIED BY 'javadude';
GRANT ALL PRIVILEGES ON `demo_jpa`.* TO 'javauser'@'%';
FLUSH PRIVILEGES;