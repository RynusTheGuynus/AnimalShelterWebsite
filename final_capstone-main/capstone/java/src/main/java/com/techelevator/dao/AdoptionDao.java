package com.techelevator.dao;

import com.techelevator.model.Adoption;
import com.techelevator.model.User;

import java.time.LocalDate;
import java.util.List;

public interface AdoptionDao {

    List<Adoption> findAll();

    Adoption getAdoptionById(int adoptionId);

    boolean create(int petId, String ownerName, String ownerAddress, String ownerEmail, String ownerPhoneNumber, LocalDate adoptionDate);

}
