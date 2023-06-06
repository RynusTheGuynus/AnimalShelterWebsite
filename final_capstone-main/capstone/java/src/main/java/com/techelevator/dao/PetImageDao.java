package com.techelevator.dao;

import com.techelevator.model.PetImage;
import com.techelevator.model.PetImageDTO;

import java.util.List;

public interface PetImageDao {

    List<PetImage> getAllImagesByPetId();
    void addImage(int petId, String imageName, String imagePath);

}
