<template>
  <div>
      <shelter-header />
      <adopted-pet-list />
      <shelter-footer />
  </div>
</template>

<script>
import AdoptedPetList from '../components/AdoptedPetList.vue'
import ShelterHeader from '../components/ShelterHeader.vue'
import ShelterFooter from '../components/ShelterFooter.vue'

export default {
  name: 'Celebrate',
  components: { 
      AdoptedPetList,
      ShelterHeader,
      ShelterFooter
    },

}
</script>
    ShelterFooter
    ShelterHeader

<style>

</style>