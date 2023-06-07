<template>
  <div id="pet-detail-container">
      {{pet.name}}
  </div>
</template>

<script>
import PetService from '../services/PetService.js'

export default {
    name: 'pet-detail',
    data() {
        return {
            images: [],
            id: this.$route.params.id,
            pet: {},
        }
    },
    methods: {
        getPetImages(id) {
            PetService.getPetImages(id)
            .then(response => {
                this.images = response.data;
            })
        },
        getPetDetails(id) {
            PetService.getPetById(id)
            .then(response => {
                this.pet = response.data;
            })
        }
    },
    created() {
        this.getPetDetails(this.id);
    }
}
</script>

<style>

</style>