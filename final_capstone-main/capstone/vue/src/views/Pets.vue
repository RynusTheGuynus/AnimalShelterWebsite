<template>
  <div>
      <shelter-header />
      <h1>Pets Now Available for Adoption</h1>
      <h2>Filter by</h2>
      <pet-component id="pets">Pet Component</pet-component>
      <shelter-footer />
  </div>
</template>

<script>

import ShelterHeader from '../components/ShelterHeader.vue'
import PetComponent from '../components/PetComponent.vue'
import ShelterFooter from '../components/ShelterFooter.vue'

export default {
    name: "pets",
    components: { 
        ShelterHeader,
        PetComponent,
        ShelterFooter
    },
    data() {
        return {
            
        }
    }
}
</script>

<style scoped>

div {
    background-color: #dc9d4e;
}

h2 {
    color: antiquewhite;
}

#pets {
    height: 60vh;
    width: 100vw;
}

</style>