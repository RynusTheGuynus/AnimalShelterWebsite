package com.techelevator.controller;

import com.techelevator.dao.PetDao;
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

    public PetController(PetDao petDao) {
        this.petDao = petDao;
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
    public void addPet(@RequestBody Pet newPet) {
        try {
            petDao.create(newPet.getPetName(), newPet.getAge(), newPet.getSpecies(), newPet.getBreed(),
                    newPet.getWeight(), newPet.isRedFlag(), newPet.getGender(), newPet.isAdoptedStatus(),
                    newPet.getDescription());
        } catch (Exception e) {
            throw new DaoException("Pet Table Insertion Error.");
        }
    }

}
