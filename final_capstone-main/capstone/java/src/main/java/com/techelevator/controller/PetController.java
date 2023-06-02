package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
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

    @RequestMapping(path = "/pets", method = RequestMethod.GET)
    public List<Pet> getAll() {
        return petDao.findAll();
    }

    @RequestMapping(path = "/pets/id/{petId}", method = RequestMethod.GET)
    public Pet getPetById(@PathVariable int petId) {
        Pet pet = petDao.getPetById(petId);
        return pet;
    }

}
