INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');
INSERT INTO `airplane_isa`.`airplane_company` (`id`, `address`, `avrage_rate`, `luggage_price`, `luggage_type`, `name`, `promo_description`) VALUES (1, 'Beograd, Srbija', 0, 123, 'Test type', 'JAT', 'Avio prevoznik');
INSERT INTO `airplane_isa`.`destination` (`id`, `name`, `fk_airplane_company`) VALUES (1, 'Beograd', 1);
INSERT INTO `airplane_isa`.`destination` (`id`, `name`, `fk_airplane_company`) VALUES (2, 'Nis', 1);
INSERT INTO `airplane_isa`.`destination` (`id`, `name`, `fk_airplane_company`) VALUES (3, 'Milan', 1);

INSERT INTO `airplane_isa`.`user` (`id`, `date_of_birth`, `email`, `first_name`, `first_time_login`, `last_name`, `passeport`, `password`, `phone_number`,  `score`, `username`)
VALUES (2,  null, 'test-admin@gmail.com', 'Simo', false, 'Simic', 'asd123', '', '123-223', 0, null);
INSERT INTO `airplane_isa`.`user_roles` (`user_id`, `role_id`) VALUES (2, 2);

INSERT INTO `airplane_isa`.`user` (`id`, `date_of_birth`, `email`, `first_name`, `first_time_login`, `last_name`, `passeport`, `password`, `phone_number`,  `score`, `username`)
VALUES (3,  null, 'test-user@gmail.com', 'Simo', false, 'Simic', 'asd123', '', '123-223', 0, null);
INSERT INTO `airplane_isa`.`user_roles` (`user_id`, `role_id`) VALUES (3, 1);
