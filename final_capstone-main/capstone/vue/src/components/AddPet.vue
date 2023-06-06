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
            v-model="addPetDTO.petName"
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
            v-model="addPetDTO.age"
            required
            autofocus
        /> <br>
        <label for="add-pet-species" class="add-pet-input-label">Species: </label>
        <br>
        <select
            id="add-pet-species"
            class="add-pet-input"
            value="Choose here"
            v-model="addPetDTO.species"
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
            v-model="addPetDTO.breed"
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
            v-model="addPetDTO.weight"
            required
            autofocus
        /> <br>
        <label for="add-pet-gender" class="add-pet-input-label">Gender: </label>
        <br>
        <select
            id="add-pet-gender"
            class="add-pet-input"
            value="Choose here"
            v-model="addPetDTO.gender"
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
            v-model="addPetDTO.redFlag"
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
            v-model="addPetDTO.adoptedStatus"
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
            v-model="addPetDTO.description"
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
            v-model="addPetDTO.petImageDTOOne.imageName"
            autofocus
        /> <image-upload v-model="addPetDTO.petImageDTOOne.imagePath" @image-uploaded="updatePetImageOne" />
        <br>
        <label for="add-pet-image-2-name" class="add-pet-input-label">Second image name: </label>
        <br>
        <input
            type="text"
            id="add-pet-image-2-name"
            class="add-pet-input"
            placeholder="bob1, charley2, etc."
            v-model="addPetDTO.petImageDTOTwo.imageName"
            autofocus
        /> <image-upload v-model="addPetDTO.petImageDTOTwo.imagePath" @image-uploaded="updatePetImageTwo" />
        <br>
        <label for="add-pet-image-3-name" class="add-pet-input-label">Third image name: </label>
        <br>
        <input
            type="text"
            id="add-pet-image-3-name"
            class="add-pet-input"
            placeholder="bob1, charley2, etc."
            v-model="addPetDTO.petImageDTOThree.imageName"
            autofocus
        /> <image-upload v-model="addPetDTO.petImageDTOThree.imagePath" @image-uploaded="updatePetImageThree" />
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
            addPetDTO: {
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
                }
            },
        }
    },
    methods: {
        addPet() {
            PetService.addPet(this.addPetDTO)
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