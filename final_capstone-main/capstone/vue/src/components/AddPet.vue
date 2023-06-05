<template>
  <div>
      add test
  </div>
</template>

<script>
import PetService from '../services/PetService.js';

export default {
    name: 'AddPet',
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
            const newPet = {
                petName: this.pet.petName,
                age: this.pet.age,
                species: this.pet.species,
                breed: this.pet.breed,
                weight: this.pet.weight,
                gender: this.pet.gender,
                redFlag: this.pet.redFlag,
                adoptedStatus: this.pet.adoptedStatus,
                description: this.pet.description
            }
            PetService.addPet(newPet)
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
        }

    },
    computed: {

    },
    watch: {

    },
    created() {
        this.addPet();
    }
}

</script>

<style>

</style>