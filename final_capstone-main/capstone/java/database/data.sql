BEGIN TRANSACTION;

INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Sparky', 1, 'dog', 'Terrier mix', 6, 'female', false, false, 'placeholder');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Gina', 19, 'dog', 'Shepherd/Collie mix', 42, 'female', true, true, 'placeholder');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Chester', 1, 'cat', 'Domestic Shorthair', 11, 'male', false, false, 'placeholder');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Rosie', 2, 'cat', 'Domestic Shorthair', 10, 'female', false, false, 'placeholder');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Sadie', 2, 'dog', 'Australian Cattle Dog', 23, 'female', true, false, 'placeholder');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Arthur', 3, 'cat', 'Domestic Shorthair', 10, 'male', false, false, 'placeholder');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Sylvie', 1, 'dog', 'Spitz mix', 25, 'female', false, false, 'placeholder');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Oliver', 3, 'cat', 'Domestic Shorthair', 12, 'male', false, true, 'placeholder');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Oberon', 1, 'dog', 'Pit/Lab mix', 20, 'male', false, false, 'placeholder');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Lola', 1, 'cat', 'Himalayan mix', 1, 'female', false, false, 'placeholder');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Rosebud', 2, 'dog', 'Hound mix', 18, 'female', false, false, 'placeholder');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Ginger', 1, 'dog', 'Chow/Golden mix', 5, 'female', false, true, 'placeholder');

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
    VALUES (2, 'gina1', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685925954/Animal%20Shelter/gina1.jpg');
--	VALUES (2, 'gina1', pg_read_binary_file('/static/images/gina1.jpg'));
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (8, 'oliver1', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685925954/Animal%20Shelter/oliver1.jpg');
--	VALUES (8, 'oliver1', pg_read_binary_file('static/images/oliver1.jpg'));
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (12, 'ginger1', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685925954/Animal%20Shelter/ginger1.jpg');
--	VALUES (12, 'ginger1', pg_read_binary_file('static/images/ginger1.jpg'));
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (1, 'sparky1', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954148/Animal%20Shelter/sparky1_qa6pua.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (1, 'sparky2', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954148/Animal%20Shelter/sparky2_orjm50.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (1, 'sparky3', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954148/Animal%20Shelter/sparky3_rumg6h.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (3, 'chester1', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954150/Animal%20Shelter/chester1_hcbtfx.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (3, 'chester2', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954150/Animal%20Shelter/chester2_iovz1j.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (3, 'chester3', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954151/Animal%20Shelter/chester3_gcol3i.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (4, 'rosie1', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954153/Animal%20Shelter/rosie1_zukupp.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (4, 'rosie2', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954153/Animal%20Shelter/rosie2_x1ayon.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (5, 'sadie1', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954148/Animal%20Shelter/sadie1_tsnu5o.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (5, 'sadie2', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954148/Animal%20Shelter/sadie2_o3hzg8.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (6, 'arthur1', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954150/Animal%20Shelter/arthur1_q8cjec.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (6, 'arthur2', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954150/Animal%20Shelter/arthur2_haghof.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (7, 'sylvie1', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954148/Animal%20Shelter/sylvie1_aszyil.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (7, 'sylvie2', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954149/Animal%20Shelter/sylvie2_pd9cft.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (9, 'oberon1', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954152/Animal%20Shelter/oberon1_ymlh6n.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (9, 'oberon2', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954153/Animal%20Shelter/oberon2_voxcqd.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (10, 'lola2', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954151/Animal%20Shelter/lola2_jwxzez.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (11, 'rosebud1', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954152/Animal%20Shelter/rosebud1_fq4nem.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (11, 'rosebud2', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685954153/Animal%20Shelter/rosebud2_n5gwc2.jpg');




COMMIT;