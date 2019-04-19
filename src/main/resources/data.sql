-- User stuff

-- -----------------------------------------------------
-- Table `users`
-- -----------------------------------------------------

DROP TABLE IF EXISTS users CASCADE;

CREATE TABLE IF NOT EXISTS  users (
  id        SERIAL        NOT NULL  PRIMARY KEY,
  username  VARCHAR(255)  NOT NULL  UNIQUE,
  password  VARCHAR(255)  NOT NULL,
  name      VARCHAR(255), 
  surname   VARCHAR(255), 
  email     VARCHAR(100)
);

-- -----------------------------------------------------
-- Table `users`
-- -----------------------------------------------------

DROP TABLE IF EXISTS roles CASCADE;

CREATE TABLE IF NOT EXISTS roles (
  id         SERIAL        NOT NULL  PRIMARY KEY,
  role_name  VARCHAR(100)  NOT NULL  UNIQUE
);

-- -----------------------------------------------------
-- Table `user_roles`
-- -----------------------------------------------------

DROP TABLE IF EXISTS user_roles;

CREATE TABLE IF NOT EXISTS user_roles (
  user_id  SERIAL  NOT NULL,
  role_id  SERIAL  NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
);


-- Thesis stuff

-- -----------------------------------------------------
-- Table `thesis_types`
-- -----------------------------------------------------

DROP TABLE IF EXISTS thesis_types CASCADE;

CREATE TABLE IF NOT EXISTS  thesis_types (
	id           SERIAL        NOT NULL  PRIMARY KEY,
	thesis_type  VARCHAR(100)  NOT NULL  UNIQUE
);

INSERT INTO thesis_types VALUES
(1, 'Кандидатская'),
(2, 'Докторская');

-- -----------------------------------------------------
-- Table `organizations`
-- -----------------------------------------------------

DROP TABLE IF EXISTS organizations CASCADE;

CREATE TABLE IF NOT EXISTS  organizations (
	id     SERIAL  NOT NULL  PRIMARY KEY,
	title  TEXT    NOT NULL  UNIQUE
);

INSERT INTO organizations VALUES
(1, 'МГУ'),
(2, 'ЮФУ'),
(3, 'Stanford');

-----------------------------------------------------
-- Table `science_fields`
-----------------------------------------------------

DROP TABLE IF EXISTS science_fields CASCADE;

CREATE TABLE IF NOT EXISTS  science_fields (
	id     SERIAL        NOT NULL  PRIMARY KEY,
	code   VARCHAR(100)  NOT NULL  UNIQUE,
	title  TEXT          NOT NULL  UNIQUE
);

INSERT INTO science_fields VALUES
(1, '01', 'Физико-математические науки'),
(2, '02', 'Химические науки'),
(3, '03', 'Биологические науки'),
(4, '04', 'Геолого-минералогические науки'),
(5, '05', 'Технические науки');

-----------------------------------------------------
-- Table `science_codes`
-----------------------------------------------------

DROP TABLE IF EXISTS science_codes CASCADE;

CREATE TABLE IF NOT EXISTS  science_codes (
	id        SERIAL        NOT NULL  PRIMARY KEY,
	science_field_id  SERIAL        NOT NULL,
	code      VARCHAR(100)  NOT NULL  UNIQUE,
	title     TEXT          NOT NULL  UNIQUE,
	
	FOREIGN KEY (science_field_id) REFERENCES science_fields (id)
);

INSERT INTO science_codes VALUES
(1, 1, '01.01.01', 'Вещественный, комплексный и функциональный анализ'),
(2, 1, '01.01.02', 'Дифференциальные уравнения, динамические системы и оптимальное управление'),
(3, 5, '05.13.17', 'Теоретические основы информатики'),
(4, 5, '05.13.18', 'Математическое моделирование, численные методы и комплексы программ'),
(5, 5, '05.13.19', 'Методы и системы защиты информации, информационная безопасность');

-----------------------------------------------------
-- Table `adverts`
-----------------------------------------------------

DROP TABLE IF EXISTS adverts CASCADE;

CREATE TABLE IF NOT EXISTS  adverts (
 	id             SERIAL        NOT NULL  PRIMARY KEY,
 	aspirant_fio   VARCHAR(500)  NOT NULL,
 	diss_def_time  DATE			 NOT NULL,
 	adv_url	       TEXT			 NOT NULL  UNIQUE,
 	council        TEXT			 NOT NULL,
	org_id         SERIAL        NOT NULL,
 	FOREIGN KEY (org_id) REFERENCES organizations (id)
);

INSERT INTO adverts VALUES
(1, 'Кокорев Денис Сергеевич', '2019-04-15', 'http://vak.ed.gov.ru/dis-details?xPARAM=100036866:100', 'Д 002.077.05',  1),
(2, 'Стародумов Илья Олегович', '2019-05-15', 'http://vak.ed.gov.ru/dis-details?xPARAM=100038445:100', 'Д 212.285.25',  2),
(3, 'Буртыка Филипп Борисович', '2020-06-15', 'http://vak.ed.gov.ru/dis-details?xPARAM=100038445:101', 'Д 212.285.26',  3);

-----------------------------------------------------
-- Table `autorefs`
-----------------------------------------------------

DROP TABLE IF EXISTS autorefs CASCADE;

CREATE TABLE IF NOT EXISTS autorefs (
 	id            SERIAL  NOT NULL  PRIMARY KEY,
 	autoref_pdf   BYTEA, --NOT NULL,
 	advert_id     SERIAL  NOT NULL,
 	FOREIGN KEY (advert_id) REFERENCES adverts (id)
 );

-- pg_read_binary_file takes fies from postgres data directory
-- use SHOW  data_directory; to find the location

INSERT INTO autorefs VALUES
(1, pg_read_binary_file('autorefs/uploaded2.pdf')::bytea, 1),
(2, pg_read_binary_file('autorefs/uploaded1.pdf')::bytea, 2),
(3, pg_read_binary_file('autorefs/uploaded3.pdf')::bytea, 3);

-----------------------------------------------------
-- Table `thesis`
-----------------------------------------------------

DROP TABLE IF EXISTS thesis;

CREATE TABLE IF NOT EXISTS thesis (
 	id                SERIAL        NOT NULL  PRIMARY KEY,
 	thesis_title	  TEXT			NOT NULL  UNIQUE,
 	thesis_pdf		  BYTEA,        --NOT NULL,
-- 	--pages_num		  INTEGER	    NOT NULL,
 	advert_id         SERIAL        NOT NULL,
 	thesis_type_id    SERIAL        NOT NULL,
 	science_code_id   SERIAL        NOT NULL,
 	FOREIGN KEY (advert_id) REFERENCES adverts (id),
 	FOREIGN KEY (thesis_type_id) REFERENCES thesis_types (id),
 	FOREIGN KEY (science_code_id) REFERENCES science_codes (id)
);

INSERT INTO thesis VALUES
(1, 'Разработка и исследование методов и программных средств вписывания многогранных трехмерных объектов', pg_read_binary_file('thesis/kokorev.pdf')::bytea, 1, 1, 4),
(2, 'Математическое моделирование структурно-фазовых превращений модифицированным методом кристаллического фазового поля', pg_read_binary_file('thesis/starodumov.pdf')::bytea, 2, 1, 4),
(3, 'Homomorphic encryption', pg_read_binary_file('thesis/burtyka.pdf')::bytea, 3, 1, 5);
