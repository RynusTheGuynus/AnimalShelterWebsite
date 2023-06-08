<template>
  <div class="pet-container">
      <shelter-header class="shelter-header" />
      <navigation-bar id='navigation-bar' />
      <available-pet-list :filteredPets="filteredPets" class="pet-list" />
      <shelter-footer class="shelter-footer" />
  </div>
</template>

<script>

import ShelterHeader from '../components/ShelterHeader.vue'
import AvailablePetList from '../components/AvailablePetList.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
import NavigationBar from '../components/NavigationBar.vue'

export default {
    name: "pets",
    components: { 
        ShelterHeader,
        AvailablePetList,
        ShelterFooter,
        NavigationBar,
        
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

.pet-container {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: auto auto 70% 350px;
  grid-template-areas:
    "shelter-header"
    "navigation"
    "pet-list"
    "shelter-footer";
}

.shelter-header {
  grid-area: shelter-header; 
  /* width: 100%; */
}

.pet-list {
  grid-area: pet-list;
  /* height: calc(100% - 300px); */
  /* max-height: calc(100vh - 200px);
  max-width: 120vh;
  overflow-y: auto;
  overflow-x: auto;
  margin-bottom: 20px; */
}

.shelter-footer {
  grid-area: shelter-footer;
  /* height: 300px; */
} 

#navigation-bar {
  grid-area: navigation;
}


</style>