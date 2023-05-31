package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Min;

public class Pet {

    /* Model data after the following SQL table:
    CREATE TABLE pet (
    pet_id SERIAL,
    pet_name varchar(50) NOT NULL,
    age int NOT NULL,
    species varchar(50) NOT NULL,
    breed varchar(50) NOT NULL,
    weight int NOT NULL,
    gender varchar(50) NOT NULL,
    red_flag boolean NOT NULL,
    adopted_status boolean NOT NULL,
    CONSTRAINT PK_pet PRIMARY KEY (pet_id)
    */

    // Data members
    @JsonProperty("pet_id")
    private int petId;                  // serially assigned by dB
    private String petName;             // pet's name as a string
    @Min(value=0, message="Age cannot be less than zero.")
    private int age;                    // pet's known or estimated age in years as an integer
    private String species;             // pet's species; e.g., dog or cat, as a string
    private String breed;               // pet's possible breed/mix as a string
    @Min(value=0, message="Weight cannot be less than zero.")
    private int weight;                 // pet's weight in pounds as an integer
    private String gender;              // pet's sex as a string
    @JsonProperty("red_flag")
    private boolean redFlag;           // is there a restriction on who should adopt?
    @JsonProperty("adopted_status")
    private boolean adoptedStatus;      // has pet been adopted yet?

    // Constructors
    //default constructor
    Pet(){
    }

    // pet constructor using every attribute but the serially-assigned petId
    public Pet(String petName, int age, String species, int weight, boolean red_flag, String gender, boolean adoptedStatus) {
        this.petName = petName;
        this.age = age;
        this.species = species;
        this.weight = weight;
        this.redFlag = red_flag;
        this.gender = gender;
        this.adoptedStatus = adoptedStatus;
    }

    // Getter
    public int getPetId() {
        return petId;
    }

    // Getters and Setters
    public String getPetName() {
        return petName;
    }
    public void setPetName(String petName) {
        this.petName = petName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public int getWeight() {
        return weight;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public boolean isRed_flag() {
        return redFlag;
    }
    public void setRed_flag(boolean redFlag) {
        this.redFlag = redFlag;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public boolean isAdoptedStatus() {
        return adoptedStatus;
    }
    public void setAdoptedStatus(boolean adoptedStatus) {
        this.adoptedStatus = adoptedStatus;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", petName='" + petName + '\'' +
                ", age=" + age +
                ", species='" + species + '\'' +
                ", breed='" + breed + '\'' +
                ", weight=" + weight +
                ", gender='" + gender + '\'' +
                ", redFlag=" + redFlag +
                ", adoptedStatus=" + adoptedStatus +
                '}';
    }
    
}
