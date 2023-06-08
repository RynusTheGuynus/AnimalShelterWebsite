<template>
  <div class="pet-container">
    <shelter-header class="shelter-header" />
    <navigation-bar id="navigation-bar" />
    <adopted-pet-list :filteredPets="filteredPets" class="pet-list" />
    <shelter-footer class="shelter-footer" />
  </div>
</template>

<script>
import ShelterHeader from '../components/ShelterHeader.vue'
import AdoptedPetList from '../components/AdoptedPetList.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
import NavigationBar from '../components/NavigationBar.vue'

export default {
  name: "celebrate",
  components: {
    ShelterHeader,
    AdoptedPetList,
    ShelterFooter,
    NavigationBar,
  },
  data() {
    return {
      searchQuery: '',
      filteredPets: [], // Add the filteredPets data property
    };
  },
  mounted() {
    this.filteredPets = [
      // Sample data for testing
      { pet_name: "Pet 1", species: "Dog", breed: "Labrador", age: 3, image_path: "pet1.jpg" },
      { pet_name: "Pet 2", species: "Cat", breed: "Siamese", age: 2, image_path: "pet2.jpg" },
      { pet_name: "Pet 3", species: "Bird", breed: "Parrot", age: 1, image_path: "pet3.jpg" },
      // Add more pets as needed
    ];
  },
};
</script>

<style>
.pet-container {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas:
    "shelter-header"
    "navigation"
    "pet-list"
    "shelter-footer";
  grid-auto-rows: auto minmax(0, 1fr) auto;
}

.shelter-header {
  grid-area: shelter-header;
}

.pet-list {
  grid-area: pet-list;
  max-width: 100%;
}

.shelter-footer {
  background-color: #3a4143;
  color: antiquewhite;
  grid-area: shelter-footer;
}

#navigation-bar {
  grid-area: navigation;
}
</style>
