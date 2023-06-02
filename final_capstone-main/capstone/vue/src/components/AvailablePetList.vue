<template>
  <div class="available-pet-list-container">
      <h1 class="available-pet-list-heading">
          Adopted Pet List Component
      </h1>
      <div 
      class="available-pet"
      v-for="pet in availablePets"
      v-bind:key="pet"
      >
        <h2 class="available-pet-name">
            {{ pet.pet_name }}
        </h2>
        <p>
            {{ pet.species }}
        </p>
        <p>
            {{ pet.breed }}
        </p>
        <p>
            {{ pet.age }}
        </p>
      </div>
  </div>
</template>

<script>

import PetService from '../services/PetService.js';

export default {
name: 'AvailablePetList',
    data() {
        return {
            availablePets: [],

        }
    },
    methods: {
        getAvailablePets() {
            PetService.getAvailablePets()
                .then((response) => {
                    this.availablePets = response.data.map((pet) => {
                        return {
                            pet_name: pet.petName,
                            species: pet.species,
                            breed: pet.breed,
                            age: pet.age
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
        this.getAvailablePets();
    }
}
</script>

<style>

</style>