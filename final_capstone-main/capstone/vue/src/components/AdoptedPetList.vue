<template>
  <div class="adopted-pet-list-container">
      <h1 class="adopted-pet-list-heading">
          Adopted Pet List Component
      </h1>
      <div 
      class="adopted-pet"
      v-for="pet in adoptedPets"
      v-bind:key="pet"
      >
        <h2 class="adopted-pet-name">
            {{ pet.pet_name }}
        </h2>
        <p>
            {{ pet.owner_name }}
        </p>
        <p>
            {{ pet.adoption_date }}
        </p>
        <img :src="pet.image_path" alt="Pet Image" /> 
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
        }
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

<style>

</style>