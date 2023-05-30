BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, pets, adoption, pet_adoption;

CREATE TABLE users (
	user_id SERIAL,
    username varchar(50) NOT NULL UNIQUE,
    password_hash varchar(200) NOT NULL,
    role varchar(50) NOT NULL,
	first_name varchar(50) NOT NULL,
	last_name varchar(50) NOT NULL,
	email_address varchar(50) NOT NULL,
	age int NOT NULL,
	emerg_first_name varchar(50) NOT NULL,
	emerg_last_name varchar(50) NOT NULL,
	emerg_phone int,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE adoption (
	adoption_id SERIAL,
	owner_name varchar(50) NOT NULL,
	owner_address varchar(50) NOT NULL,
	owner_email varchar(50) NOT NULL,
	adoption_date date NOT NULL,
	CONSTRAINT PK_adoption PRIMARY KEY (adoption_id)
);

CREATE TABLE pet (
	pet_id SERIAL,
	pet_name varchar(50) NOT NULL,
	age int NOT NULL,
	species varchar(50) NOT NULL,
	breed varchar(50) NOT NULL,
	weight int NOT NULL,
	gender varchar(50) NOT NULL,
	red_flag boolean NOT NULL,
	adopted_status boolean NOT NULL,
	adoption_id int,
	CONSTRAINT PK_pet PRIMARY KEY (pet_id),
	CONSTRAINT FK_adopted_id FOREIGN KEY (adoption_id) REFERENCES adoption(adoption_id)
);

CREATE TABLE pet_adoption (
	pet_id int,
	adoption_id int,
	PRIMARY KEY (adoption_id, pet_id),
	CONSTRAINT FK_adopted_id FOREIGN KEY (adoption_id) REFERENCES adoption(adoption_id),
	CONSTRAINT FK_pet_id FOREIGN KEY (pet_id) REFERENCES pet(pet_id)
);

COMMIT TRANSACTION;