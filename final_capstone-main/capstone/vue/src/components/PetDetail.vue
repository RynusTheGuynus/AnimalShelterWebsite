<template>
  <div id="pet-detail-container">

  </div>
</template>

<script>
import PetService from '../services/PetService.js'

export default {
    name: 'pet-detail',
    data() {
        return {
            images: [],
        }
    },
    methods: {
        getPetImages(id) {
            PetService.getPetImages(id)
            .then(response => {
                this.images = response.data;
            })
        }
    }
}
</script>

<style>

</style>