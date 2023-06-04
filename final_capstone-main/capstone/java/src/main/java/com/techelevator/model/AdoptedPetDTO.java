package com.techelevator.model;

import java.time.LocalDate;

public class AdoptedPetDTO {

    private String petName;
    private String ownerName;
    private LocalDate adoptionDate;
    private String imagePath;

    public AdoptedPetDTO() {

    }

    public AdoptedPetDTO(String petName, String ownerName,
                         LocalDate adoptionDate, String imagePath) {
        this.petName = petName;
        this.ownerName = ownerName;
        this.adoptionDate = adoptionDate;
        this.imagePath = imagePath;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
