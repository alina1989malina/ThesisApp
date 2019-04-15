-- -----------------------------------------------------
-- Table `thesis`
-- ----------------------------------------------------

DROP TABLE IF EXISTS thesis;

CREATE TABLE IF NOT EXISTS thesis (
	id              SERIAL        NOT NULL  PRIMARY KEY,
	thesis_title	TEXT	      NOT NULL  UNIQUE,
	pages_num		INTEGER	      NOT NULL,
	supervisor_fio  VARCHAR(500)  NOT NULL,
	aspirant_fio    VARCHAR(500)  NOT NULL,
 	diss_def_time   DATE		  NOT NULL,
    science_code    VARCHAR(100)  NOT NULL,
    science_field   VARCHAR(100)  NOT NULL,
    org_title       TEXT          NOT NULL,
    thesis_type     VARCHAR(100)  NOT NULL
);

-- Insert data

INSERT INTO thesis VALUES (1, 'Fully homomorphic encryption', 200, 'Dan Boneh', 'Craig Gentry', '2009-06-23', '05.13.19', 'Cryptography', 'Stanford', 'phd');

INSERT INTO thesis VALUES (2, 'Fully homomorphic encryption2', 200, 'Dan Boneh2', 'Craig Gentry2', '2008-06-23', '05.13.19', 'Cryptography', 'Stanford', 'phd');

