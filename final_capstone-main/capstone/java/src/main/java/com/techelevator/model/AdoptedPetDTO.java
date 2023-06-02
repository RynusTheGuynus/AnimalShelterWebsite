package com.techelevator.model;

import java.time.LocalDate;

public class AdoptedPetDTO {

    private String petName;
    private String ownerName;
    private LocalDate adoptionDate;

    public AdoptedPetDTO() {

    }

    public AdoptedPetDTO(String petName, String ownerName, LocalDate adoptionDate) {
        this.petName = petName;
        this.ownerName = ownerName;
        this.adoptionDate = adoptionDate;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public LocalDate getAdoptionDate() {
        return adoptionDate;
    }

    public void setAdoptionDate(LocalDate adoptionDate) {
        this.adoptionDate = adoptionDate;
    }

}
