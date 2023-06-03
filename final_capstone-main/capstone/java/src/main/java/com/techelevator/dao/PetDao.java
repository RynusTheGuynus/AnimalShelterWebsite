// "The Data Access Object (DAO) pattern is a structural pattern that allows us to isolate
// the application/business layer from the persistence layer (usually a relational database
// but could be any other persistence mechanism) using an abstract API.
//
// "The API hides from the application all the complexity of performing CRUD operations in
// the underlying storage mechanism. This permits both layers to evolve separately without
// knowing anything about each other.  -- https://www.baeldung.com/java-dao-pattern

package com.techelevator.dao;

import com.techelevator.model.AdoptedPetDTO;
import com.techelevator.model.AvailablePetDTO;
import com.techelevator.model.Pet;
import java.util.List;

public interface PetDao {

    // Data members
    List<Pet> findAll();
    List<AdoptedPetDTO> getAdoptedPets();
    List<AvailablePetDTO> getAvailablePets();
    Pet getPetById(int petId);

    // Methods
    boolean create(String petName, int age, String species, String breed, int weight,
                   boolean red_flag, String gender, boolean adoptedStatus, String description);

}

