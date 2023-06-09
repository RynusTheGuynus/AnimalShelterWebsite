<template>
  <div class="update-pet-container">
    <div class="update-pet-form-container">
      <h1 class="update-pet-heading">
            Update Current Shelter Pet's Information
      </h1>
        <div class="update-pet-select-pet">
          <label for="update-pet-select-pet-menu" class="update-pet-input-label">Select a pet: </label>
          <br>
          <select
              id="update-pet-select-pet-menu"
              class="update-pet-input"
              v-model="selectedPet"
              required
              autofocus
          > <option select value="">Choose here</option>
            <option v-for="pet in availablePetsForUpdate" :key="pet.id" :value="pet">NAME: {{pet.pet_name}} - ID#: {{pet.pet_id}} - SPECIES: {{pet.species}} - BREED: {{pet.breed}}</option>
          </select>
        </div>
        <form v-if="selectedPet.pet_name != undefined" class="update-pet-form" @submit.prevent="updatePet">
          <div class="update-pet-form-part-one-container">
            <label for="update-pet-name" class="update-pet-input-label">Name: </label>
            <br>
            <input
                type="text"
                id="update-pet-name"
                class="update-pet-input"
                v-model="updatePetDTO.petName"
                required
            /> <br>
            <label for="update-pet-age" class="update-pet-input-label">Age: </label>
            <br>
            <input
                type="number"
                id="update-pet-age"
                class="update-pet-input"
                v-model="updatePetDTO.age"
                required
            /> <br>
            <label for="update-pet-species" class="update-pet-input-label">Species: </label>
            <br>
            <select
                id="update-pet-species"
                class="update-pet-input"
                v-model="updatePetDTO.species"
                required
            > <option selected disabled>Choose here</option>
              <option value="cat" :selected="selectedPet.species === 'cat'">Cat</option>
              <option value="dog" :selected="selectedPet.species === 'dog'">Dog</option>
            </select>
            <br>
            <label for="update-pet-breed" class="update-pet-input-label">Breed: </label>
            <br>
            <input
                type="text"
                id="update-pet-breed"
                class="update-pet-input"
                v-model="updatePetDTO.breed"
                required
            /> <br>
            <label for="update-pet-weight" class="update-pet-input-label">Weight: </label>
            <br>
            <input
                type="number"
                id="update-pet-weight"
                class="update-pet-input"
                v-model="updatePetDTO.weight"
                required
            /> <br>
            <label for="update-pet-gender" class="update-pet-input-label">Gender: </label>
            <br>
            <select
                id="update-pet-gender"
                class="update-pet-input"
                v-model="updatePetDTO.gender"
                required
            > <option selected disabled>Choose here</option>
              <option value="male" :selected="selectedPet.gender === 'male'">Male</option>
              <option value="female" :selected="selectedPet.gender === 'female'">Female</option>
            </select>
            <br>
            <label for="update-pet-redflag" class="update-pet-input-label">Red flag: </label>
            <br>
            <select
                id="update-pet-redflag"
                class="update-pet-input"
                v-model="updatePetDTO.redFlag"
                required
            > <option selected disabled>Choose here</option>
              <option value="true" :selected="selectedPet.red_flag === true">True</option>
              <option value="false" :selected="selectedPet.red_flag === false">False</option>
            </select>
            <br>
            <label for="update-pet-adoptedstatus" class="update-pet-input-label">Adopted status: </label>
            <br>
            <select
                id="update-pet-adoptedstatus"
                class="update-pet-input"
                v-model="updatePetDTO.adoptedStatus"
                required
            > <option selected disabled>Choose here</option>
              <option value="true" :selected="selectedPet.adopted_status === true">True</option>
              <option value="false" :selected="selectedPet.adopted_status === false">False</option>
            </select>
            <br>
            <label for="update-pet-description" class="update-pet-input-label">Description: </label>
            <br>
            <textarea
                id="update-pet-description"
                class="update-pet-input"
                rows="4"
                cols="50"
                v-model="updatePetDTO.description"
                required
            ></textarea> <br>
          </div>
          <div class="update-pet-form-part-two-container">
            <div v-if="updatePetDTO.adoptedStatus === 'true'" class="update-pet-adoption-info-container">
              <label for="update-pet-owner-name" class="update-pet-input-label">Owner Name: </label>
              <br>
              <input
                  type="text"
                  id="update-pet-owner-name"
                  class="update-pet-input"
                  v-model="updatePetDTO.ownerName"
                  :required="updatePetDTO.adoptedStatus === 'true'"
              /> <br>
              <label for="update-pet-owner-address" class="update-pet-input-label">Owner address: </label>
              <br>
              <input
                  type="text"
                  id="update-pet-owner-address"
                  class="update-pet-input"
                  v-model="updatePetDTO.ownerAddress"
                  :required="updatePetDTO.adoptedStatus === 'true'"
              /> <br>
              <label for="update-pet-owner-email" class="update-pet-input-label">Owner email: </label>
              <br>
              <input
                  type="text"
                  id="update-pet-owner-email"
                  class="update-pet-input"
                  v-model="updatePetDTO.ownerEmail"
                  :required="updatePetDTO.adoptedStatus === 'true'"
              /> <br>
              <label for="update-pet-owner-phone-number" class="update-pet-input-label">Owner phone number: </label>
              <br>
              <input
                  type="text"
                  id="update-pet-owner-phone-number"
                  class="update-pet-input"
                  v-model="updatePetDTO.ownerPhoneNumber"
                  :required="updatePetDTO.adoptedStatus === 'true'"
              /> <br>
              <label for="update-pet-owner-adoption-date" class="update-pet-input-label">Adoption date: </label>
              <br>
              <input
                  type="date"
                  id="update-pet-owner-adoption-date"
                  class="update-pet-input"
                  v-model="updatePetDTO.adoptionDate"
                  :required="updatePetDTO.adoptedStatus === 'true'"
              /> <br>
            </div>
          </div>
          <div class="update-pet-form-part-three-container">
            <div class="update-pet-image-container">
              <label for="update-pet-image-1-name" class="update-pet-input-label">First image name: </label>
              <br>
              <input
                  type="text"
                  id="update-pet-image-1-name"
                  class="update-pet-input update-pet-input-image-name"
                  placeholder="bob1, charley2, etc."
                  v-model="updatePetDTO.petImageDTOOne.imageName"
              /> <image-upload class="update-pet-input-image-upload-button" v-model="updatePetDTO.petImageDTOOne.imagePath" @image-uploaded="updatePetImageOne" />
              <br><br><br>
              <label for="update-pet-image-2-name" class="update-pet-input-label">Second image name: </label>
              <br>
              <input
                  type="text"
                  id="update-pet-image-2-name"
                  class="update-pet-input update-pet-input-image-name"
                  placeholder="bob1, charley2, etc."
                  v-model="updatePetDTO.petImageDTOTwo.imageName"
              /> <image-upload class="update-pet-input-image-upload-button" v-model="updatePetDTO.petImageDTOTwo.imagePath" @image-uploaded="updatePetImageTwo" />
              <br><br><br>
              <label for="update-pet-image-3-name" class="update-pet-input-label">Third image name: </label>
              <br>
              <input
                  type="text"
                  id="update-pet-image-3-name"
                  class="update-pet-input update-pet-input-image-name"
                  placeholder="bob1, charley2, etc."
                  v-model="updatePetDTO.petImageDTOThree.imageName"
              /> <image-upload class="update-pet-input-image-upload-button" v-model="updatePetDTO.petImageDTOThree.imagePath" @image-uploaded="updatePetImageThree" />
              <br><br><br>
            </div>
            <button id="submit-button" class="button" type="submit">
                Submit
            </button>
          </div>
        </form>
      </div>
      <div class="update-pet-photo-container">
        <img src="@/images/updatepetphoto1.jpg" alt="banner" />
      </div>
  </div>
</template>

<script>
import PetService from '../services/PetService.js';
import ImageUpload from '../components/ImageUpload.vue';

export default {
  name: 'UpdatePet',
  components: {
      ImageUpload
  },
  data() {
      return {
          updatePetDTO: {
              petId: 0,
              petName: "",
              age: 0,
              species: "",
              breed: "",
              weight: 0,
              gender: "",
              redFlag: false,
              adoptedStatus: false,
              description: "",
              petImageDTOOne: {
                  imageName: "",
                  imagePath: ""
              },
              petImageDTOTwo: {
                  imageName: "",
                  imagePath: ""
              },
              petImageDTOThree: {
                  imageName: "",
                  imagePath: ""
              },
              ownerName: "",
              ownerAddress: "",
              ownerEmail: "",
              ownerPhoneNumber: "",
              adoptionDate: ""
          },
          availablePetsForUpdate: [],
          selectedPet: {
            
          }
      }
  },
  methods: {
    updatePet() {
      PetService.updatePet(this.updatePetDTO)
          .then((response) => {
              if(response.status === 201) {
                  this.$router.push(`/pets`);
              }
          }).catch((error) => {
              if(error.response) {
                  window.alert("Bad Request");
              } else if(error.request) {
                  window.alert("Could Not Reach Service");
              }
          });
    },
    updatePetImageOne(url) {
        this.addPetDTO.petImageDTOOne.imagePath = url;
    },
    updatePetImageTwo(url) {
        this.addPetDTO.petImageDTOTwo.imagePath = url;
    },
    updatePetImageThree(url) {
        this.addPetDTO.petImageDTOThree.imagePath = url;
    },
    getAvailablePetsForUpdate() {
      PetService.getAvailablePetsForUpdate()
        .then((response) => {
          this.availablePetsForUpdate = response.data.map((pet) => {
            return {
              pet_id: pet.pet_id,
              pet_name: pet.pet_name,
              age: pet.age,
              species: pet.species,
              breed: pet.breed,
              weight: pet.weight,
              gender: pet.gender,
              red_flag: pet.red_flag,
              adopted_status: pet.adopted_status,
              description: pet.description
            };
          });
        })
        .catch((error) => {
          console.log(error);
        });
    },
    clearAdoptionInfo() {
      this.updatePetDTO.ownerName = '';
      this.updatePetDTO.ownerAddress = '';
      this.updatePetDTO.ownerEmail = '';
      this.updatePetDTO.ownerPhoneNumber = '';
      this.updatePetDTO.adoptionDate = '';
    }

  },
  computed: {

  },
  watch: {
    selectedPet(newPet) {
      if (newPet.pet_name !== undefined) {
        this.updatePetDTO.petId = newPet.pet_id;
        this.updatePetDTO.petName = newPet.pet_name;
        this.updatePetDTO.age = newPet.age;
        this.updatePetDTO.species = newPet.species;
        this.updatePetDTO.breed = newPet.breed;
        this.updatePetDTO.weight = newPet.weight;
        this.updatePetDTO.gender = newPet.gender;
        this.updatePetDTO.redFlag = newPet.red_flag;
        this.updatePetDTO.adoptedStatus = newPet.adopted_status;
        this.updatePetDTO.description = newPet.description;
        this.clearAdoptionInfo();
      }
    },
    'updatePetDTO.adoptedStatus'(newValue) {
      if (newValue === 'false') {
        this.clearAdoptionInfo();
      }
    }
  },
  created() {
    this.getAvailablePetsForUpdate();
    
  },
  updated() {

  }

}
</script>

<style scoped>

.update-pet-container {
  display: grid;
  grid-template-columns: 1fr 1fr;
  padding: 20px;
  background-color: #f1f1f1;
  box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
  font-family: Arial, Helvetica, sans-serif;
}

.update-pet-heading {
  font-size: 24px;
  text-align: center;
  margin-bottom: 20px;
}

.update-pet-form {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
}

.update-pet-form-part-one-container {
  grid-column: 1;
  align-self: start;
}

.update-pet-form-part-two-container {
  grid-column: 2;
  align-self: start;
}

.update-pet-form-part-three-container {
  grid-column: 3;
  align-self: start;
}

.update-pet-select-pet {
  margin-bottom: 20px;
}

.update-pet-input-label {
  font-weight: bold;
  font-family: Arial, Helvetica, sans-serif;
}

.update-pet-input,
.button {
  display: block;
  width: 80%;
  padding: 10px;
  margin-bottom: 10px;
  margin-top: 25px;
  border-radius: 4px;
  border: 1px solid #ccc;
}

.update-pet-input-image-name {
  margin-bottom: 3%;
}

.button {
  background-color: #747474;
  color: white;
  padding: 10px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  width: 50%;
}

#submit-button {
  width: 85%;
}

.button:hover {
  background-color: #444444;
}

.image-upload-container {
  margin-top: 10px;
}

.update-pet-photo-container {
  justify-self: right;
}

.update-pet-photo-container img {
  height: 100%;
  border-radius: 5px;
}

#update-pet-description {
  height: 100px; 
}


</style>