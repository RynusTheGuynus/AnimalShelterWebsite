BEGIN TRANSACTION;

INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Sparky', 0, 'dog', 'Terrier mix', 6, 'female', false, false, ' ');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description))
	VALUES ('Gina', 19, 'dog', 'Shepherd/Collie mix', 42, 'female', true, true, ' ');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description))
	VALUES ('Chester', 0, 'cat', 'Domestic Shorthair', 11, 'male', false, false, ' ');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description))
	VALUES ('Rosie', 2, 'cat', 'Domestic Shorthair', 10, 'female', false, false, ' ');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description))
	VALUES ('Sadie', 2, 'dog', 'Australian Cattle Dog', 23, 'female', true, false, ' ');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description))
	VALUES ('Arthur', 3, 'cat', 'Domestic Shorthair', 10, 'male', false, false, ' ');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description))
	VALUES ('Sylvie', 1, 'dog', 'Spitz mix', 25, 'female', false, false, ' ');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description))
	VALUES ('Oliver', 3, 'cat', 'Domestic Shorthair', 12, 'male', false, true, ' ');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description))
	VALUES ('Oberon', 0, 'dog', 'Pit/Lab mix', 20, 'male', false, false, ' ');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description))
	VALUES ('Lola', 0, 'cat', 'Himalayan mix', 1, 'female', false, true, ' ');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description))
	VALUES ('Rosebud', 2, 'dog', 'Hound mix', 18, 'female', false, false, ' ');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description))
	VALUES ('Ginger', 0, 'dog', 'Chow/Golden mix', 5, 'female', false, true, ' ');

INSERT INTO adoption (owner_name, owner_address, owner_email, owner_phone_number, adoption_date)
	VALUES ('Debra Nichols', '1313 Mockingbird Ln, Halloween Town', 'dln@fakedomain.com', '111-222-333', '1994-03-12');
INSERT INTO adoption (owner_name, owner_address, owner_email, owner_phone_number, adoption_date)
	VALUES ('Dudley Sauve', '45 High St, Farmville', 'dns@fakedomain.com', '111-222-333', '2020-05-24');
INSERT INTO adoption (owner_name, owner_address, owner_email, owner_phone_number, adoption_date)
	VALUES ('Ann Lee', '351 Cherry Rd, Franklin', 'all@fakedomain.com', '111-222-333', '1997-01-07');

INSERT INTO pet_adoption (pet_id, adoption_id)
	VALUES (2, 1);
INSERT INTO pet_adoption (pet_id, adoption_id)
	VALUES (8, 2);
INSERT INTO pet_adoption (pet_id, adoption_id)
	VALUES (12, 3);

INSERT INTO pet_image (pet_id, image_name, image_path)
	VALUES (2, 'gina 1','images/gina/gina1.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
	VALUES (8, 'oliver 1', 'images/oliver/oliver1.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
	VALUES (12, 'ginger 1', 'images/ginger/ginger1.jpg');


COMMIT;