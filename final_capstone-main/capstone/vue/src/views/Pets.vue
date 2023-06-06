<template>
  <div class="pet-container">
      <shelter-header class="shelter-header" />
      <available-pet-list class="pet-list" /> <br><br><br>
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
        ShelterFooter
    }
}
</script>

<style scoped>

.pet-container {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: auto 1fr auto;
  grid-template-areas:
    "shelter-header"
    "pet-list"
    "shelter-footer";
}

/* .shelter-header {
  grid-area: shelter-header;
}

.pet-list {
  grid-area: pet-list;
  max-height: calc(100vh - 200px);
  max-width: 120vh;
  overflow-y: auto;
  overflow-x: auto;
  margin-bottom: 20px;
}

.shelter-footer {
  grid-area: shelter-footer;
} */


</style>