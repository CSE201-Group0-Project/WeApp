INSERT INTO users (id, name, password, username) VALUES
(1, 'Amy Nguyen', '$2a$10$wxy7dVnZDcqqHtpkR6RXaO4n7v6LDIatK8nrHhlbAS0QmmBv0qfom', 'aestheteeism');

INSERT INTO authority (id, authority, user_id) VALUES
(1, 'ROLE_ADMIN', 1),
(2, 'ROLE_USER', 1);

INSERT INTO application (id, approved, description, link, name, organization, platform, price, version, user_id) VALUES
(1, 0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 'http://altervista.org	', 'Zamit	', 'Agivu	', NULL, 2.99, 'v1.1', 1),
(2, 0, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.', 'http://hatena.ne.jp	', 'Solarbreeze	', 'Camido	', NULL, 3.99, 'v.2.2', 1),
(3, 0, NULL, 'https://indiegogo.com	', 'Duobam	', 'Jaloo	', NULL, 1.99, 'v1.2.1', 1),
(4, 0, NULL, 'http://sakura.ne.jp	', 'Ventosanzap', 'Jaxworks	', NULL, 2.99, 'v3.2.1', 1),
(5, 0, NULL, 'http://bloomberg.com	', 'Y-Solowarm	', 'Mydo	', NULL, 0.99, 'v.5.7.6', 1),
(6, 0, NULL, 'http://photobucket.com	', 'It	', 'Yadel	', NULL, 2.99, 'v7.5', 1),
(7, 0, NULL, 'https://huffingtonpost.com	', 'Stronghold	', 'Skyvu	', NULL, 1.99, 'v1.1', 1),
(8, 0, NULL, 'http://feedburner.com	', 'Viva	', 'Dynava	', NULL, 2.99, 'v2.4.0', 1),
(9, 0, NULL, 'http://archive.org	', 'Fintone	', 'Skimia	', NULL, 5.99, 'v1.2', 1),
(10, 0, NULL, 'https://senate.gov	', 'Kanlam	', 'Skipstorm', NULL, 6.99, 'v2.2', 1),
(11, 0, NULL, 'https://amazon.com	', 'Bytecard	', 'Twitterwire', NULL, 0.99, 'v3.4.5', 1),
(12, 0, NULL, 'http://addtoany.com	', 'Aerified	', 'Jaxbean', NULL, 0.0, 'v2.2', 1),
(13, 0, NULL, 'https://mashable.com	', 'Konklab	', 'Oyonder', NULL, 0.0, 'v1.1', 1),
(14, 0, NULL, 'http://blogs.com	', 'Pannier	', 'Livefish	', NULL, 0.0, 'v2.2', 1),
(15, 0, NULL, 'http://wikipedia.org	', 'Zamit	', 'Rhycero', NULL, 0.0, 'v3.3', 1);
