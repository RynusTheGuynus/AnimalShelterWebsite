package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.dao.PetImageDao;
import com.techelevator.dao.UserDao;
import com.techelevator.exception.DaoException;
import com.techelevator.model.*;

import com.techelevator.model.AdoptedPetDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PetController {

    @Autowired
    private PetDao petDao;
    private PetImageDao petImageDao;

    public PetController(PetDao petDao, PetImageDao petImageDao) {
        this.petDao = petDao;
        this.petImageDao = petImageDao;
    }

    @RequestMapping(path = "/pets/id/{petId}", method = RequestMethod.GET)
    public Pet getPetById(@PathVariable int petId) {
        Pet pet = petDao.getPetById(petId);
        return pet;
    }

    @RequestMapping(path = "/pets", method = RequestMethod.GET)
    public List<AvailablePetDTO> getAvailablePets() {
        return petDao.getAvailablePets();
    }

    @RequestMapping(path = "/celebrate", method = RequestMethod.GET)
    public List<AdoptedPetDTO> getAdoptedPets() {
        return petDao.getAdoptedPets();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public void addPet(@RequestBody AddPetDTO addPetDTO) {
        try {
            int newPetId = petDao.create(addPetDTO.getPetName(), addPetDTO.getAge(), addPetDTO.getSpecies(), addPetDTO.getBreed(),
                    addPetDTO.getWeight(), addPetDTO.isRedFlag(), addPetDTO.getGender(), addPetDTO.isAdoptedStatus(),
                    addPetDTO.getDescription());
            if(!addPetDTO.getPetImageDTOOne().getImagePath().isEmpty()) {
                petImageDao.addImage(newPetId, addPetDTO.getPetImageDTOOne().getImageName(), addPetDTO.getPetImageDTOOne().getImagePath());
            }
            if(!addPetDTO.getPetImageDTOTwo().getImagePath().isEmpty()) {
                petImageDao.addImage(newPetId, addPetDTO.getPetImageDTOTwo().getImageName(), addPetDTO.getPetImageDTOTwo().getImagePath());
            }
            if(!addPetDTO.getPetImageDTOThree().getImagePath().isEmpty()) {
                petImageDao.addImage(newPetId, addPetDTO.getPetImageDTOThree().getImageName(), addPetDTO.getPetImageDTOThree().getImagePath());
            }
        } catch (Exception e) {
            throw new DaoException("Pet Table Insertion Error.");
        }
    }

}
