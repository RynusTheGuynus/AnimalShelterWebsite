<template>
  <div class="pet-container">
      <shelter-header class="shelter-header" />
      <available-pet-list :filteredPets="filteredPets" class="pet-list" />
      <shelter-footer class="shelter-footer" />
  </div>
</template>

<script>

import ShelterHeader from '../components/ShelterHeader.vue'
import AvailablePetList from '../components/AvailablePetList.vue'
import ShelterFooter from '../components/ShelterFooter.vue'


export default {
    name: "pets",
    components: { 
        ShelterHeader,
        AvailablePetList,
        ShelterFooter,
        
    },
     data() {
    return {
      searchQuery: '',
      availablePets: [],
    };
  },
}
</script>

<style>

/* .pet-container {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: auto 1fr auto;
  grid-template-areas:
    "shelter-header"
    "pet-list"
    "shelter-footer";
} */

.shelter-header {
  /* grid-area: shelter-header; */
  max-width: 100%;
}

/* .pet-list {
  grid-area: pet-list; */
  /* max-height: calc(100vh - 200px);
  max-width: 120vh;
  overflow-y: auto;
  overflow-x: auto; */
  /* margin-bottom: 20px;
} */

.shelter-footer {
  /* grid-area: shelter-footer; */
  max-width: 100%;
} 


</style>