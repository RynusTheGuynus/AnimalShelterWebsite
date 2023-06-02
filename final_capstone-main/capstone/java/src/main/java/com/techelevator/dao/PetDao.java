package com.techelevator.dao;

import com.techelevator.model.Pet;
import java.util.List;

public interface PetDao {

    List<Pet> findAll();

    Pet getPetById(int petId);

    boolean create(String petName, int age, String species, String breed, int weight,
                   boolean red_flag, String gender, boolean adoptedStatus, String description);
}

