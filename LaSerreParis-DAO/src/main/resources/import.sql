-- ROLES

INSERT INTO `user` (`first_name`, `last_name`, `email`, `password`, `salt`, `mail_validation_date`, `phone`, `address`, `birth`, `home_size`) VALUES ('Jean-Antoine', 'Maro', 'jeanantoine.maro@gmail.com', '���A`/r�Ouq�npű����;�6��{�(�Q', 'PQHA', '2022-02-10', '0674809592', '57 avenue de la République 75011 Paris', '1990-03-27', '1');
INSERT INTO `user` (`first_name`, `last_name`, `email`, `password`, `salt`, `mail_validation_date`, `phone`, `address`, `birth`, `home_size`) VALUES ('VisiteurCDA', 'ANONYME', 'visiteur@cda.eql', '��+�k/4p|,��q]{*k���،��jOk�', 'y8LC', '2022-02-10', '01 00 00 00 00', '9 Bd du Général de Gaulle, 92120 Montrouge', '1990-03-27', '10');
INSERT INTO `user` (`first_name`, `last_name`, `email`, `password`, `salt`, `mail_validation_date`, `phone`, `address`, `birth`, `home_size`) VALUES ('VisiteurCDA2', 'ANONYME', 'visiteur@cda.eql2', 'EU���&����L���?�#�G��*�F�Y', 'Iy1N', '2022-02-10', '01 00 00 00 00', '9 Bd du Général de Gaulle, 92120 Montrouge', '1990-03-27', '10');
INSERT INTO `user` (`first_name`, `last_name`) VALUES ('Cécile', 'Dupont');
INSERT INTO `user` (`first_name`, `last_name`) VALUES ('Guillaume', 'Verboise');
INSERT INTO `user` (`first_name`, `last_name`) VALUES ('Fatima', 'Soussa');

-- COMMENTS & CONTACT FORMS
INSERT INTO `comment` (`submission_date`, `text`,  `validation_date`, `user_id`) VALUES ('2022-02-12', 'Ce fut une expérience incroyable, je recommande chaudement !', '2022-02-14', 1);
INSERT INTO `comment` (`submission_date`, `text`, `validation_date`, `user_id`) VALUES ('2022-02-13', 'Top ces livraisons ! Des légumes bios et locaux, et régulièrement des découvertes délicieuses !', '2022-02-14', '2');
INSERT INTO `comment` (`submission_date`, `text`, `validation_date`, `user_id`) VALUES ('2022-02-13', 'La Serre propose de multiples plats végétariens voire vegans, et dans un cadre impressionnant ! Enfin on peut ne pas se limiter quand on sort avec des amis.', '2022-02-14', '3');
INSERT INTO `comment` (`hide_date`, `submission_date`, `text`, `validation_date`, `user_id`) VALUES ('2022-02-15', '2022-02-13', 'Ce commentaire devrait être masqué', '2022-02-14', '1');
INSERT INTO `comment` (`submission_date`, `text`, `user_id`) VALUES ('2022-02-13', 'Commentaire pas encore accepté', '1');
INSERT INTO `laserre_paris_db`.`comment` (`rejection_date`, `submission_date`, `text`, `user_id`) VALUES ('2022-02-14', '2022-02-13', 'Ce commentaire a été rejeté', '1');


INSERT INTO `contact_form_type` (name) VALUES ('Abonnement');
INSERT INTO `contact_form_type` (name) VALUES ('Restaurant');
INSERT INTO `contact_form_type` (name) VALUES ('Renseignement');
INSERT INTO `contact_form_type` (name) VALUES ('Mon compte');
INSERT INTO `contact_form_type` (name) VALUES ('Autre');
INSERT INTO `contact_form` (`body`, `creation_date`, `email`, `name`, `title`, `type_id`) VALUES ('Bonjour ! Peut-on visiter la ferme ?', '2022-02-12', 'curieux@mail.net', 'Monsieur Curieux', 'Visite', '3');

-- SUBSCRIPTIONS
INSERT INTO `subscription_size` (`display_home_size`, `home_size_high`, `home_size_low`, `name`) VALUES ('1 personne', '1', '1', 'Small');
INSERT INTO `subscription_size` (`display_home_size`, `home_size_high`, `home_size_low`, `name`) VALUES ('2/3 personnes', '3', '2', 'Medium');
INSERT INTO `subscription_size` (`display_home_size`, `home_size_high`, `home_size_low`, `name`) VALUES ('4/5 personnes', '5', '4', 'Large');
INSERT INTO `subscription_size` (`display_home_size`, `home_size_high`, `home_size_low`, `name`) VALUES ('6/7 personnes', '7', '6', 'X-Large');

INSERT INTO `season` (`name`) VALUES ('Printemps');
INSERT INTO `season` (`name`) VALUES ('Eté');
INSERT INTO `season` (`name`) VALUES ('Automne');
INSERT INTO `season` (`name`) VALUES ('Hiver');

INSERT INTO `subscription_period` (`duration`, `start_date`, `season_id`) VALUES ('13', '2021-09-20', '3');
INSERT INTO `subscription_period` (`duration`, `start_date`, `season_id`) VALUES ('13', '2021-12-20', '4');
INSERT INTO `subscription_period` (`duration`, `start_date`, `season_id`) VALUES ('13', '2022-03-21', '1');
INSERT INTO `subscription_period` (`duration`, `start_date`, `season_id`) VALUES ('13', '2022-06-20', '2');
INSERT INTO `subscription_period` (`duration`, `start_date`, `season_id`) VALUES ('13', '2022-09-19', '3');
INSERT INTO `subscription_period` (`duration`, `start_date`, `season_id`) VALUES ('13', '2022-12-19', '4');

INSERT INTO `subscription_offer` (`price_per_month`, `total_harvest_qty`, `size_id`, `picture`) VALUES ('70', '0', '1', 'offer1S.jpg');
INSERT INTO `subscription_offer` (`price_per_month`, `total_harvest_qty`, `size_id`, `picture`) VALUES ('90', '6', '1', 'offer1SP.jpg');
INSERT INTO `subscription_offer` (`price_per_month`, `total_harvest_qty`, `size_id`, `picture`) VALUES ('126', '0', '2', 'offer23M.PNG');
INSERT INTO `subscription_offer` (`price_per_month`, `total_harvest_qty`, `size_id`, `picture`) VALUES ('151', '12', '2', 'offer23MP.jpg');
INSERT INTO `subscription_offer` (`price_per_month`, `total_harvest_qty`, `size_id`, `picture`) VALUES ('180', '0', '3', 'offer45L.jpg');
INSERT INTO `subscription_offer` (`price_per_month`, `total_harvest_qty`, `size_id`, `picture`) VALUES ('230', '18', '3', 'offer45LP.jpg');
INSERT INTO `subscription_offer` (`hide_date`, `price_per_month`, `total_harvest_qty`, `size_id`, `picture`) VALUES ('2022-01-21', '230', '0', '4', 'offer45LP.jpg');

INSERT INTO `premium_crop` (`carousel_description`, `complete_description`, `harvest_qty`, `name`, `picture`) VALUES ('Donec tempus, ante eu euismod mattis, nisi dolor blandit libero, a cursus magna nibh sit amet leo.', 'Aenean a suscipit erat. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus sem enim, vehicula nec congue ut, posuere nec leo. Mauris lacus massa, pellentesque sed faucibus ut, tincidunt et metus. Suspendisse iaculis scelerisque lorem dapibus finibus. Quisque libero magna, egestas ac imperdiet dignissim, hendrerit quis magna. Suspendisse tincidunt fringilla tellus sit amet volutpat. Suspendisse in placerat urna, eu ornare dolor. Vestibulum in metus sit amet eros condimentum blandit. Sed molestie a felis molestie dignissim. Donec non eleifend ante. Vestibulum ut faucibus mauris, sit amet gravida leo. Fusce fermentum sagittis dolor, non feugiat lorem vehicula sit amet. Donec hendrerit sodales pellentesque. Donec porta venenatis eros eget condimentum. ', '1', 'Quinoa rouge', 'redquinoa.jpg');
INSERT INTO `premium_crop` (`carousel_description`, `complete_description`, `harvest_qty`, `name`, `picture`) VALUES ('Donec tempus, ante eu euismod mattis, nisi dolor blandit libero, a cursus magna nibh sit amet leo.', 'Aenean a suscipit erat. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus sem enim, vehicula nec congue ut, posuere nec leo. Mauris lacus massa, pellentesque sed faucibus ut, tincidunt et metus. Suspendisse iaculis scelerisque lorem dapibus finibus. Quisque libero magna, egestas ac imperdiet dignissim, hendrerit quis magna. Suspendisse tincidunt fringilla tellus sit amet volutpat. Suspendisse in placerat urna, eu ornare dolor. Vestibulum in metus sit amet eros condimentum blandit. Sed molestie a felis molestie dignissim. Donec non eleifend ante. Vestibulum ut faucibus mauris, sit amet gravida leo. Fusce fermentum sagittis dolor, non feugiat lorem vehicula sit amet. Donec hendrerit sodales pellentesque. Donec porta venenatis eros eget condimentum. ', '1', 'Crosnes', 'crosnes.jpg');
INSERT INTO `premium_crop` (`carousel_description`, `complete_description`, `harvest_qty`, `name`, `picture`) VALUES ('Donec tempus, ante eu euismod mattis, nisi dolor blandit libero, a cursus magna nibh sit amet leo.', 'Aenean a suscipit erat. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus sem enim, vehicula nec congue ut, posuere nec leo. Mauris lacus massa, pellentesque sed faucibus ut, tincidunt et metus. Suspendisse iaculis scelerisque lorem dapibus finibus. Quisque libero magna, egestas ac imperdiet dignissim, hendrerit quis magna. Suspendisse tincidunt fringilla tellus sit amet volutpat. Suspendisse in placerat urna, eu ornare dolor. Vestibulum in metus sit amet eros condimentum blandit. Sed molestie a felis molestie dignissim. Donec non eleifend ante. Vestibulum ut faucibus mauris, sit amet gravida leo. Fusce fermentum sagittis dolor, non feugiat lorem vehicula sit amet. Donec hendrerit sodales pellentesque. Donec porta venenatis eros eget condimentum. ', '1', 'Pois de senteur', 'senteur.jpg');
INSERT INTO `premium_crop` (`carousel_description`, `complete_description`, `harvest_qty`, `name`, `picture`) VALUES ('Donec tempus, ante eu euismod mattis, nisi dolor blandit libero, a cursus magna nibh sit amet leo.', 'Aenean a suscipit erat. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus sem enim, vehicula nec congue ut, posuere nec leo. Mauris lacus massa, pellentesque sed faucibus ut, tincidunt et metus. Suspendisse iaculis scelerisque lorem dapibus finibus. Quisque libero magna, egestas ac imperdiet dignissim, hendrerit quis magna. Suspendisse tincidunt fringilla tellus sit amet volutpat. Suspendisse in placerat urna, eu ornare dolor. Vestibulum in metus sit amet eros condimentum blandit. Sed molestie a felis molestie dignissim. Donec non eleifend ante. Vestibulum ut faucibus mauris, sit amet gravida leo. Fusce fermentum sagittis dolor, non feugiat lorem vehicula sit amet. Donec hendrerit sodales pellentesque. Donec porta venenatis eros eget condimentum. ', '4', 'Chou rouge', 'chou_rouge.jpg');
INSERT INTO `premium_crop` (`carousel_description`, `complete_description`, `harvest_qty`, `name`, `picture`) VALUES ('Donec tempus, ante eu euismod mattis, nisi dolor blandit libero, a cursus magna nibh sit amet leo.', 'Aenean a suscipit erat. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus sem enim, vehicula nec congue ut, posuere nec leo. Mauris lacus massa, pellentesque sed faucibus ut, tincidunt et metus. Suspendisse iaculis scelerisque lorem dapibus finibus. Quisque libero magna, egestas ac imperdiet dignissim, hendrerit quis magna. Suspendisse tincidunt fringilla tellus sit amet volutpat. Suspendisse in placerat urna, eu ornare dolor. Vestibulum in metus sit amet eros condimentum blandit. Sed molestie a felis molestie dignissim. Donec non eleifend ante. Vestibulum ut faucibus mauris, sit amet gravida leo. Fusce fermentum sagittis dolor, non feugiat lorem vehicula sit amet. Donec hendrerit sodales pellentesque. Donec porta venenatis eros eget condimentum. ', '3', 'Aubergine zébrée', 'zebra_eggplant.jpg');
INSERT INTO `premium_crop` (`carousel_description`, `complete_description`, `harvest_qty`, `name`, `picture`) VALUES ('Donec tempus, ante eu euismod mattis, nisi dolor blandit libero, a cursus magna nibh sit amet leo.', 'Aenean a suscipit erat. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus sem enim, vehicula nec congue ut, posuere nec leo. Mauris lacus massa, pellentesque sed faucibus ut, tincidunt et metus. Suspendisse iaculis scelerisque lorem dapibus finibus. Quisque libero magna, egestas ac imperdiet dignissim, hendrerit quis magna. Suspendisse tincidunt fringilla tellus sit amet volutpat. Suspendisse in placerat urna, eu ornare dolor. Vestibulum in metus sit amet eros condimentum blandit. Sed molestie a felis molestie dignissim. Donec non eleifend ante. Vestibulum ut faucibus mauris, sit amet gravida leo. Fusce fermentum sagittis dolor, non feugiat lorem vehicula sit amet. Donec hendrerit sodales pellentesque. Donec porta venenatis eros eget condimentum. ', '2', 'Tomates anciennes', 'heirloom_tomatoes.jpg');
INSERT INTO `premium_crop` (`carousel_description`, `complete_description`, `harvest_qty`, `name`, `picture`) VALUES ('Donec tempus, ante eu euismod mattis, nisi dolor blandit libero, a cursus magna nibh sit amet leo.', 'Aenean a suscipit erat. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus sem enim, vehicula nec congue ut, posuere nec leo. Mauris lacus massa, pellentesque sed faucibus ut, tincidunt et metus. Suspendisse iaculis scelerisque lorem dapibus finibus. Quisque libero magna, egestas ac imperdiet dignissim, hendrerit quis magna. Suspendisse tincidunt fringilla tellus sit amet volutpat. Suspendisse in placerat urna, eu ornare dolor. Vestibulum in metus sit amet eros condimentum blandit. Sed molestie a felis molestie dignissim. Donec non eleifend ante. Vestibulum ut faucibus mauris, sit amet gravida leo. Fusce fermentum sagittis dolor, non feugiat lorem vehicula sit amet. Donec hendrerit sodales pellentesque. Donec porta venenatis eros eget condimentum. ', '1', 'Kasha', 'kasha.jpg');
INSERT INTO `premium_crop` (`carousel_description`, `complete_description`, `harvest_qty`, `name`, `picture`) VALUES ('Donec tempus, ante eu euismod mattis, nisi dolor blandit libero, a cursus magna nibh sit amet leo.', 'Aenean a suscipit erat. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus sem enim, vehicula nec congue ut, posuere nec leo. Mauris lacus massa, pellentesque sed faucibus ut, tincidunt et metus. Suspendisse iaculis scelerisque lorem dapibus finibus. Quisque libero magna, egestas ac imperdiet dignissim, hendrerit quis magna. Suspendisse tincidunt fringilla tellus sit amet volutpat. Suspendisse in placerat urna, eu ornare dolor. Vestibulum in metus sit amet eros condimentum blandit. Sed molestie a felis molestie dignissim. Donec non eleifend ante. Vestibulum ut faucibus mauris, sit amet gravida leo. Fusce fermentum sagittis dolor, non feugiat lorem vehicula sit amet. Donec hendrerit sodales pellentesque. Donec porta venenatis eros eget condimentum. ', '1', 'Pois', 'pois.jpg');
INSERT INTO `premium_crop` (`carousel_description`, `complete_description`, `harvest_qty`, `name`, `picture`) VALUES ('Donec tempus, ante eu euismod mattis, nisi dolor blandit libero, a cursus magna nibh sit amet leo.', 'Aenean a suscipit erat. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus sem enim, vehicula nec congue ut, posuere nec leo. Mauris lacus massa, pellentesque sed faucibus ut, tincidunt et metus. Suspendisse iaculis scelerisque lorem dapibus finibus. Quisque libero magna, egestas ac imperdiet dignissim, hendrerit quis magna. Suspendisse tincidunt fringilla tellus sit amet volutpat. Suspendisse in placerat urna, eu ornare dolor. Vestibulum in metus sit amet eros condimentum blandit. Sed molestie a felis molestie dignissim. Donec non eleifend ante. Vestibulum ut faucibus mauris, sit amet gravida leo. Fusce fermentum sagittis dolor, non feugiat lorem vehicula sit amet. Donec hendrerit sodales pellentesque. Donec porta venenatis eros eget condimentum. ', '2', 'Herbes médicinales', 'medicinal.jpg');
INSERT INTO `premium_crop` (`carousel_description`, `complete_description`, `harvest_qty`, `hide_date`, `name`, `picture`) VALUES ('Donec tempus, ante eu euismod mattis, nisi dolor blandit libero, a cursus magna nibh sit amet leo.', 'Aenean a suscipit erat. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus sem enim, vehicula nec congue ut, posuere nec leo. Mauris lacus massa, pellentesque sed faucibus ut, tincidunt et metus. Suspendisse iaculis scelerisque lorem dapibus finibus. Quisque libero magna, egestas ac imperdiet dignissim, hendrerit quis magna. Suspendisse tincidunt fringilla tellus sit amet volutpat. Suspendisse in placerat urna, eu ornare dolor. Vestibulum in metus sit amet eros condimentum blandit. Sed molestie a felis molestie dignissim. Donec non eleifend ante. Vestibulum ut faucibus mauris, sit amet gravida leo. Fusce fermentum sagittis dolor, non feugiat lorem vehicula sit amet. Donec hendrerit sodales pellentesque. Donec porta venenatis eros eget condimentum. ', '2', '2022-01-25', 'Fraises des bois', 'fraises_bois.jpg');
INSERT INTO `premium_crop` (`carousel_description`, `complete_description`, `harvest_qty`, `name`, `picture`) VALUES ('Donec tempus, ante eu euismod mattis, nisi dolor blandit libero, a cursus magna nibh sit amet leo.', 'Aenean a suscipit erat. Orci varius natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Phasellus sem enim, vehicula nec congue ut, posuere nec leo. Mauris lacus massa, pellentesque sed faucibus ut, tincidunt et metus. Suspendisse iaculis scelerisque lorem dapibus finibus. Quisque libero magna, egestas ac imperdiet dignissim, hendrerit quis magna. Suspendisse tincidunt fringilla tellus sit amet volutpat. Suspendisse in placerat urna, eu ornare dolor. Vestibulum in metus sit amet eros condimentum blandit. Sed molestie a felis molestie dignissim. Donec non eleifend ante. Vestibulum ut faucibus mauris, sit amet gravida leo. Fusce fermentum sagittis dolor, non feugiat lorem vehicula sit amet. Donec hendrerit sodales pellentesque. Donec porta venenatis eros eget condimentum. ', '3', 'Maïs ancien', 'ancient_corn.jpg');

INSERT INTO `subscription` (`subscription_date`, `period_id`, `offer_id`, `user_id`) VALUES ('2021-09-15', '1', '1', '1');
INSERT INTO `subscription` (`subscription_date`, `period_id`, `offer_id`, `user_id`) VALUES ('2021-09-15', '2', '1', '1');
INSERT INTO `subscription` (`subscription_date`, `period_id`, `offer_id`, `user_id`) VALUES ('2021-09-15', '3', '1', '1');
INSERT INTO `subscription` (`subscription_date`, `period_id`, `offer_id`, `user_id`) VALUES ('2021-09-15', '4', '1', '1');
INSERT INTO `subscription` (`subscription_date`, `period_id`, `offer_id`, `user_id`) VALUES ('2021-09-15', '1', '3', '2');
INSERT INTO `subscription` (`subscription_date`, `period_id`, `offer_id`, `user_id`) VALUES ('2021-09-15', '2', '3', '2');
INSERT INTO `subscription` (`subscription_date`, `period_id`, `offer_id`, `user_id`) VALUES ('2021-09-15', '3', '3', '2');
INSERT INTO `subscription` (`subscription_date`, `period_id`, `offer_id`, `user_id`) VALUES ('2021-09-15', '4', '3', '2');
INSERT INTO `subscription` (`subscription_date`, `period_id`, `offer_id`, `user_id`) VALUES ('2021-09-15', '1', '1', '3');
INSERT INTO `subscription` (`subscription_date`, `period_id`, `offer_id`, `user_id`) VALUES ('2021-09-15', '2', '1', '3');
INSERT INTO `subscription` (`subscription_date`, `period_id`, `offer_id`, `user_id`) VALUES ('2021-09-15', '3', '1', '3');
INSERT INTO `subscription` (`subscription_date`, `period_id`, `offer_id`, `user_id`) VALUES ('2021-09-15', '4', '1', '3');


INSERT INTO `laserre_paris_db`.`weekly_status` (`delivery_date`, `delivery_decision_date`, `start_day`, `subscription_id`) VALUES ('2021-12-25', '2021-12-21', '2021-12-20', '1');
INSERT INTO `laserre_paris_db`.`weekly_status` (`delivery_date`, `delivery_decision_date`, `start_day`, `subscription_id`) VALUES ('2021-12-30', '2021-12-28', '2021-12-27', '1');
INSERT INTO `laserre_paris_db`.`weekly_status` (`delivery_date`, `delivery_decision_date`, `start_day`, `subscription_id`) VALUES ('2022-01-03', NULL, '2022-01-03', '1');
INSERT INTO `laserre_paris_db`.`weekly_status` (`delivery_date`, `start_day`, `subscription_id`) VALUES ('2022-01-10', '2022-01-10', '1');
INSERT INTO `laserre_paris_db`.`weekly_status` (`delivery_date`, `delivery_decision_date`, `start_day`, `subscription_id`) VALUES ('2022-01-21', '2022-01-19', '2022-01-17', '1');
INSERT INTO `laserre_paris_db`.`weekly_status` (`delivery_date`, `delivery_decision_date`, `start_day`, `subscription_id`) VALUES ('2022-01-24', NULL, '2022-01-24', '1');
INSERT INTO `laserre_paris_db`.`weekly_status` (`delivery_date`, `delivery_decision_date`, `start_day`, `subscription_id`) VALUES ('2022-01-31', '2022-01-31', '2022-01-31', '1');
INSERT INTO `laserre_paris_db`.`weekly_status` (`delivery_date`, `delivery_decision_date`, `start_day`, `subscription_id`) VALUES (NULL, NULL, '2022-02-07', '1');
INSERT INTO `laserre_paris_db`.`weekly_status` (`delivery_date`, `start_day`, `subscription_id`) VALUES (NULL, '2022-02-14', '1');
INSERT INTO `laserre_paris_db`.`weekly_status` (`delivery_date`, `start_day`, `subscription_id`) VALUES (NULL, '2022-02-21', '1');
INSERT INTO `laserre_paris_db`.`weekly_status` (`delivery_date`, `start_day`, `subscription_id`) VALUES (NULL, '2022-02-28', '1');
INSERT INTO `laserre_paris_db`.`weekly_status` (`start_day`, `subscription_id`) VALUES ('2022-03-07', '1');
INSERT INTO `laserre_paris_db`.`weekly_status` (`start_day`, `subscription_id`) VALUES ('2022-03-14', '1');

-- RESTAURANT

-- TABLES
INSERT INTO `laserre_paris_db`.`social_table` (`seats_quantity`, `subscriptors_held_seats`) VALUES ('30', '6');

INSERT INTO `laserre_paris_db`.`restaurant_table` (`max_guests`, `min_guests`) VALUES ('4', '3');
INSERT INTO `laserre_paris_db`.`restaurant_table` (`max_guests`, `min_guests`) VALUES ('4', '3');
INSERT INTO `laserre_paris_db`.`restaurant_table` (`max_guests`, `min_guests`) VALUES ('2', '1');
INSERT INTO `laserre_paris_db`.`restaurant_table` (`max_guests`, `min_guests`) VALUES ('6', '5');

-- BOOKING
INSERT INTO `laserre_paris_db`.`opening_period` (`first_day`, `last_day`) VALUES ('2022-02-22', '2022-02-27');
INSERT INTO `laserre_paris_db`.`opening_period` (`first_day`, `last_day`) VALUES ('2022-03-01', '2022-03-06');
INSERT INTO `laserre_paris_db`.`opening_period` (`first_day`, `last_day`) VALUES ('2022-03-08', '2022-03-13');
INSERT INTO `laserre_paris_db`.`opening_period` (`first_day`, `last_day`) VALUES ('2022-03-15', '2022-03-20');
INSERT INTO `laserre_paris_db`.`opening_period` (`first_day`, `last_day`) VALUES ('2022-03-22', '2022-03-27');
INSERT INTO `laserre_paris_db`.`opening_period` (`first_day`, `last_day`) VALUES ('2022-03-29', '2022-04-03');
INSERT INTO `laserre_paris_db`.`opening_period` (`first_day`, `last_day`) VALUES ('2022-04-05', '2022-04-10');
INSERT INTO `laserre_paris_db`.`opening_period` (`first_day`, `last_day`) VALUES ('2022-04-12', '2022-04-17');

INSERT INTO `laserre_paris_db`.`booking_time` (`time`) VALUES ('12:00:00');
INSERT INTO `laserre_paris_db`.`booking_time` (`time`) VALUES ('13:00:00');
INSERT INTO `laserre_paris_db`.`booking_time` (`time`) VALUES ('19:00:00');
INSERT INTO `laserre_paris_db`.`booking_time` (`time`) VALUES ('20:30:00');
INSERT INTO `laserre_paris_db`.`booking_time` (`time`) VALUES ('22:00:00');

INSERT INTO `laserre_paris_db`.`week_day` (`id`, `name`) VALUES ('1', 'Dimanche');
INSERT INTO `laserre_paris_db`.`week_day` (`id`, `name`) VALUES ('2', 'Lundi');
INSERT INTO `laserre_paris_db`.`week_day` (`id`, `name`) VALUES ('3', 'Mardi');
INSERT INTO `laserre_paris_db`.`week_day` (`id`, `name`) VALUES ('4', 'Mercredi');
INSERT INTO `laserre_paris_db`.`week_day` (`id`, `name`) VALUES ('5', 'Jeudi');
INSERT INTO `laserre_paris_db`.`week_day` (`id`, `name`) VALUES ('6', 'Vendredi');
INSERT INTO `laserre_paris_db`.`week_day` (`id`, `name`) VALUES ('7', 'Samedi');

INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('1', '2');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('2', '2');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('1', '3');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('2', '3');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('1', '4');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('2', '4');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('1', '5');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('2', '5');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('3', '5');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('4', '5');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('5', '5');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('1', '6');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('2', '6');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('3', '6');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('4', '6');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('5', '6');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('1', '7');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('2', '7');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('3', '7');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('4', '7');
INSERT INTO `laserre_paris_db`.`weekly_booking_time` (`bookingTime_id`, `weekDay_id`) VALUES ('5', '7');

INSERT INTO `laserre_paris_db`.`booking` (`booking_type`, `id`, `booked_date`, `booking_date`, `bookingTime_id`, `user_id`) VALUES ('social', '1', '2022-02-26', '2022-02-23', '1', '1');
INSERT INTO `laserre_paris_db`.`social_table_booking` (`guest_number`, `id`, `socialTable_id`) VALUES ('30', '1', '1');


