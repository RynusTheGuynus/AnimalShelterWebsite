<template>
  <div>
    <shelter-header />
    <h1>Our latest adoption success story!</h1>
    <adopted-pet-list />
    <shelter-footer />
  </div>
</template>

<script>
import AdoptedPetList from '../components/AdoptedPetList.vue'
import ShelterHeader from '../components/ShelterHeader.vue'
import ShelterFooter from '../components/ShelterFooter.vue'

export default {
  name: 'celebrate',
  components: { 
      AdoptedPetList,
      ShelterHeader,
      ShelterFooter
    },

}
</script>

<style>

h1 {
  color: black;
}

</style>