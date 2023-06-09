BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role,first_name,last_name,email_address, phone_number, age, emerg_first_name, emerg_last_name, emerg_phone, first_login)
VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Ron', 'Dudley', 'rdudley@email.com', '440-123-5467', 28, 'Ronda', 'Dudley', '440-123-5468', false);
INSERT INTO users (username,password_hash,role,first_name,last_name,email_address, phone_number, age, emerg_first_name, emerg_last_name, emerg_phone, first_login)
VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN', 'Don', 'Dudley', 'ddudley@email.com', '440-123-5469', 54, 'Ronda', 'Dudley', '440-123-5468', false);
INSERT INTO users (username,password_hash,role,first_name,last_name,email_address, phone_number, age, emerg_first_name, emerg_last_name, emerg_phone, first_login)
VALUES ('msmith12','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER', 'Mike', 'Smith', 'msmith@example.com', '4401250000', 37, 'Jessica', 'Smith', '4401250001', true);
INSERT INTO users (username,password_hash,role,first_name,last_name,email_address, phone_number, age, emerg_first_name, emerg_last_name, emerg_phone, first_login)
VALUES ('msmith123','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_PENDING', 'Mike', 'Smith', 'msmith@example.com', '4401250000', 37, 'Jessica', 'Smith', '4401250001', true);

INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Sparky', 1, 'dog', 'Terrier mix', 6, 'female', false, false, 'Sparky: An energetic Terrier mix bursting with love and a zest for life. Adopt this playful companion and fill your days with happiness!');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Gina', 19, 'dog', 'Shepherd/Collie mix', 42, 'female', true, true, 'placeholder');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Chester', 1, 'cat', 'Domestic Shorthair', 11, 'male', false, false, 'Meet Chester: A playful 1-year-old male cat, eager to bring joy to your home. Adopt this charming feline today!');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Rosie', 2, 'cat', 'Domestic Shorthair', 10, 'female', false, false, 'Rosie: A graceful 10-year-old cat with a heart full of love. Ready to bring warmth to your home. Adopt this charming feline today!');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Sadie', 2, 'dog', 'Australian Cattle Dog', 23, 'female', true, false, 'Meet Sadie: An intelligent Australian Cattle Dog eager to be your loyal and active partner. Experience the boundless energy and devotion of Sadie today!');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Arthur', 3, 'cat', 'Domestic Shorthair', 10, 'male', false, false, 'Meet Arthur: A charming and curious cat, longing for a loving home. Ready to be your lifelong feline companion. Adopt Arthur today!');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Sylvie', 1, 'dog', 'Spitz mix', 25, 'female', false, false, 'Say hello to Sylvie: An adorable female Spitz mix puppy just waiting to melt your heart. Bring love into your home by adopting Sylvie today!');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Oliver', 3, 'cat', 'Domestic Shorthair', 12, 'male', false, true, 'placeholder');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Oberon', 1, 'dog', 'Pit/Lab mix', 20, 'male', false, false, 'Introducing Oberon: A playful 1-year-old male Pit/Lab mix ready to bring joy and loyalty to your family. Do not miss out on adopting him!');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Lola', 1, 'cat', 'Himalayan mix', 1, 'female', false, false, 'Meet Lola: A sweet Himalayan mix kitten full of cuddles and purrs. Bring home this bundle of joy and experience pure feline bliss!');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Rosebud', 2, 'dog', 'Hound mix', 18, 'female', false, false, 'Rosebud: A friendly female hound mix seeking a loving home. Embrace the joy of adopting this affectionate canine companion today!');
INSERT INTO pet (pet_name, age, species, breed, weight, gender, red_flag, adopted_status, description)
	VALUES ('Ginger', 1, 'dog', 'Chow/Golden mix', 5, 'female', false, true, 'placeholder');

INSERT INTO adoption (owner_name, owner_address, owner_email, owner_phone_number, adoption_date)
	VALUES ('Debra Nichols', '1313 Mockingbird Ln, Halloween Town', 'dln@fakedomain.com', '111-222-333', '2023-03-12');
INSERT INTO adoption (owner_name, owner_address, owner_email, owner_phone_number, adoption_date)
	VALUES ('Dudley Sauve', '45 High St, Farmville', 'dns@fakedomain.com', '111-222-333', '2023-05-24');
INSERT INTO adoption (owner_name, owner_address, owner_email, owner_phone_number, adoption_date)
	VALUES ('Ann Lee', '351 Cherry Rd, Franklin', 'all@fakedomain.com', '111-222-333', '2023-01-07');

INSERT INTO pet_adoption (pet_id, adoption_id)
	VALUES (2, 1);
INSERT INTO pet_adoption (pet_id, adoption_id)
	VALUES (8, 2);
INSERT INTO pet_adoption (pet_id, adoption_id)
	VALUES (12, 3);

INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (2, 'gina1', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685925954/Animal%20Shelter/gina1.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (8, 'oliver1', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685925954/Animal%20Shelter/oliver1.jpg');
INSERT INTO pet_image (pet_id, image_name, image_path)
    VALUES (12, 'ginger1', 'https://res.cloudinary.com/doliuuvrv/image/upload/v1685925954/Animal%20Shelter/ginger1.jpg');
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