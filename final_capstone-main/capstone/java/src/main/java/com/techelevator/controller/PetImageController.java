package com.techelevator.controller;

import com.techelevator.dao.PetDao;
import com.techelevator.dao.PetImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class PetImageController {

    @Autowired
    private PetImageDao petImageDao;
    private PetDao petDao;

    public PetImageController(PetImageDao petImageDao, PetDao petDao) {
        this.petImageDao = petImageDao;
        this.petDao = petDao;
    }



}
