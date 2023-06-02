package com.techelevator.model;

import java.time.LocalDate;

public class AvailablePetDTO {

    private String petName;
    private String species;
    private String breed;
    private int age;

    // Default Constructor
    public AvailablePetDTO() {

    }

    // Complete Constructor
    public AvailablePetDTO(String petName, String species, String breed, int age) {
        this.petName = petName;
        this.species = species;
        this.breed = breed;
        this.age = age;
    }

    // Getters and Setters
    public String getPetName() {
        return petName;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public String getBreed() {
        return breed;
    }
    public void setBreed(String breed) {
        this.breed = breed;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

}