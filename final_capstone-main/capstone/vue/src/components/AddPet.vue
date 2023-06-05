<template>
  <div class="add-pet-container">
      <h1 class="add-pet-heading">
          Add A New Pet To The Shelter
      </h1>
      <form class="add-pet-form" @submit.prevent="addPet">
        <label for="add-pet-name" class="add-pet-input-label">Name: </label>
        <br>
        <input
            type="text"
            id="add-pet-name"
            class="add-pet-input"
            placeholder="Ralph, Charley, etc."
            v-model="pet.petName"
            required
            autofocus
        /> <br>
        <label for="add-pet-age" class="add-pet-input-label">Age: </label>
        <br>
        <input
            type="number"
            id="add-pet-age"
            class="add-pet-input"
            placeholder="Whole numbers only"
            v-model="pet.age"
            required
            autofocus
        /> <br>
        <label for="add-pet-species" class="add-pet-input-label">Species: </label>
        <br>
        <select
            id="add-pet-species"
            class="add-pet-input"
            value="Choose here"
            v-model="pet.species"
            required
            autofocus
        > <option selected disabled>Choose here</option>
          <option value="cat">Cat</option>
          <option value="dog">Dog</option>
        </select>
        <br>
        <label for="add-pet-breed" class="add-pet-input-label">Breed: </label>
        <br>
        <input
            type="text"
            id="add-pet-breed"
            class="add-pet-input"
            placeholder="Shepherd mix, hound, etc."
            v-model="pet.breed"
            required
            autofocus
        /> <br>
        <label for="add-pet-weight" class="add-pet-input-label">Weight: </label>
        <br>
        <input
            type="number"
            id="add-pet-weight"
            class="add-pet-input"
            placeholder="Whole numbers only"
            v-model="pet.weight"
            required
            autofocus
        /> <br>
        <label for="add-pet-gender" class="add-pet-input-label">Gender: </label>
        <br>
        <select
            id="add-pet-gender"
            class="add-pet-input"
            value="Choose here"
            v-model="pet.gender"
            required
            autofocus
        > <option selected disabled>Choose here</option>
          <option value="male">Male</option>
          <option value="dog">Female</option>
        </select>
        <br>
        <label for="add-pet-redflag" class="add-pet-input-label">Red flag: </label>
        <br>
        <select
            id="add-pet-redflag"
            class="add-pet-input"
            value="Choose here"
            v-model="pet.redFlag"
            required
            autofocus
        > <option selected disabled>Choose here</option>
          <option value="true">True</option>
          <option value="false">False</option>
        </select>
        <br>
        <label for="add-pet-adoptedstatus" class="add-pet-input-label">Adopted status: </label>
        <br>
        <select
            id="add-pet-adoptedstatus"
            class="add-pet-input"
            value="Choose here"
            v-model="pet.adoptedStatus"
            required
            autofocus
        > <option selected disabled>Choose here</option>
          <option value="true">True</option>
          <option value="false">False</option>
        </select>
        <br>
        <label for="add-pet-description" class="add-pet-input-label">Description: </label>
        <br>
        <input
            type="text"
            id="add-pet-description"
            class="add-pet-input"
            placeholder="140 characters or less"
            v-model="pet.description"
            required
            autofocus
        /> <br>
        <br>
        <label for="add-pet-image-1-name" class="add-pet-input-label">First image name: </label>
        <br>
        <input
            type="text"
            id="add-pet-image-1-name"
            class="add-pet-input"
            placeholder="bob1, charley2, etc."
            v-model="placeholder"
            required
            autofocus
        /> <image-upload />
        <br>
        <label for="add-pet-image-2-name" class="add-pet-input-label">Second image name: </label>
        <br>
        <input
            type="text"
            id="add-pet-image-2-name"
            class="add-pet-input"
            placeholder="bob1, charley2, etc."
            v-model="placeholder"
            required
            autofocus
        /> <image-upload />
        <br>
        <label for="add-pet-image-3-name" class="add-pet-input-label">Third image name: </label>
        <br>
        <input
            type="text"
            id="add-pet-image-3-name"
            class="add-pet-input"
            placeholder="bob1, charley2, etc."
            v-model="placeholder"
            required
            autofocus
        /> <image-upload />
        <br>
        <button id="submit-button" class="button" type="submit">
            Submit
        </button>
      </form>
  </div>
</template>

<script>
import PetService from '../services/PetService.js';
import ImageUpload from '../components/ImageUpload.vue';

export default {
    name: 'AddPet',
    components: {
        ImageUpload
    },
    data() {
        return {
            pet: {
                petName: "",
                age: 0,
                species: "",
                breed: "",
                weight: 0,
                gender: "",
                redFlag: false,
                adoptedStatus: false,
                description: ""
            },

        }
    },
    methods: {
        addPet() {
            // const newPet = {
            //     petName: this.pet.petName,
            //     age: this.pet.age,
            //     species: this.pet.species,
            //     breed: this.pet.breed,
            //     weight: this.pet.weight,
            //     gender: this.pet.gender,
            //     redFlag: this.pet.redFlag,
            //     adoptedStatus: this.pet.adoptedStatus,
            //     description: this.pet.description
            // }
            PetService.addPet(this.pet)
                .then((response) => {
                    if(response.status === 201) {
                        // this.$router.push(`/pets`);
                    }
                }).catch((error) => {
                    if(error.response) {
                        window.alert("Bad Request");
                    } else if(error.request) {
                        window.alert("Could Not Reach Service");
                    }
                });
        }

    },
    computed: {

    },
    watch: {

    },
    created() {
        
    }
}

</script>

<style>

</style>