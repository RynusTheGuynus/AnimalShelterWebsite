<template>
  <div class="adopted-pet-list-container">
      <h1 class="adopted-pet-list-heading">
      </h1>
      <div class="adopted-pet-list-item-container">
        <div 
        class="adopted-pet"
        v-for="pet in adoptedPets"
        v-bind:key="pet.id"
        >
        <div class="adopted-pet-text-box">
            <h2 class="adopted-pet-name">
                Adoptee: {{ pet.pet_name }}
            </h2>
            <p class="adopted-pet-adopter">
                Adopter: {{ pet.owner_name }}
            </p>
            <p class="adopted-pet-gotcha-day">
                "Gotcha" day: {{ pet.adoption_date }}
            </p>
        </div>
            <img class="adopted-pet-image" :src="pet.image_path" alt="Pet Image" /> 
        </div>
        <!-- <router-link v-bind:to="{name: 'PetDetail', params: {id: pet.id}}">Details</router-link> -->
      </div>
  </div>
</template>

<script>
import PetService from '../services/PetService.js';

export default {
    name: 'AdoptedPetList',
    data() {
        return {
            adoptedPets: [],

        }
    },
    methods: {
        getAdoptedPets() {
            PetService.getAdoptedPets()
                .then((response) => {
                    this.adoptedPets = response.data.map((pet) => {
                        return {
                            pet_name: pet.petName,
                            owner_name: pet.ownerName,
                            adoption_date: pet.adoptionDate,
                            image_path: pet.imagePath
                        };
                    });
                }).catch((error) => {
                    console.log(error);
                });
        }, 
    },
    computed: {

    },
    watch: {

    },
    created() {
        this.getAdoptedPets();
    }

}
</script>

<style scoped>

.adopted-pet-list-container {
    background-color: tan;
    width: 100%;
}

.adopted-pet-list-item-container {
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    /* grid-template-areas:
        "adopted-pet adopted-pet adopted-pet"
    ; */
    height: 100%;
    width: 80%;
    gap: 10px;
    margin: 20px 1px;
    text-align: center;
    margin-left: 7%;
}

h1 {
  background-image: none;
  background-color: transparent;
}

.adopted-pet-list-heading {
    text-align: center;
    margin: 20px;
    height: 35vh;
    /* grid-area: header; */
    background-image: url("../images/second-chance-2.png");
    background-repeat: no-repeat;
    background-size: cover;
    background-color: transparent;
    border-radius: 25px;
    /* height: 10vh; */
}

.adopted-pet {
  border-radius: 25px;
  background-color: tan;
  width: 400px;
  padding: 10px 5px;
  margin: 20px;
  justify-items: center;
  /* grid-area: adopted-pet; */
}

.adopted-pet-name {
    text-align: left;
}

.adopted-pet-adopter {
    text-align: left;
}

.adopted-pet-gotcha-day {
    text-align: left;
}

.adopted-pet img {
    height: 240px;
    width: 360px;
    border-radius: 5%;
}

.adopted-pet-text-box {
    display: inline-block;
}

</style>