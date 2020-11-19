//CReacion tabla users
CREATE TABLE `db_springboot`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(60) NOT NULL,
  `enabled` TINYINT(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE);

//crear tabla de roles authorities
CREATE TABLE `db_springboot`.`authorities` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `authority` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `user_id_authorities_unique` (`user_id` ASC, `athority` ASC) VISIBLE,
  CONSTRAINT `fk_authorities_users`
    FOREIGN KEY (`user_id`)
    REFERENCES `db_springboot`.`users` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);



//Ingresando datos a las tablas users and athorities
INSERT INTO authorities (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (2,'ROLE_USER');
INSERT INTO authorities (user_id, authority) VALUES (2,'ROLE_ADMIN');


INSERT INTO users (username, password, enabled) VALUES 
('julio','$2a$10$rzL45cn94rhG.Phn6j8PIe/gDeSeQis4htfHzl0vnJI8pqZ.QbkIC',1);
INSERT INTO users (username, password, enabled) VALUES ('admin','$2a$10$54/hPpqgNWwJwq4oESp1weZ49hvlAPdLllDuth0idevE1o9/fB7ji',1);