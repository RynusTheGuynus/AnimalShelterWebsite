<template>
  <div id="celebrate">
    <shelter-header />
    <h1>Our latest adoption success story!</h1>
    <adopted-pet-list class="adopted" />
    <shelter-footer class="shelterFooter" />
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

<style scoped>
#celebrate {
  display: flex;
  flex-direction: column;
}

.adopted {
  margin-top: -118px;
  margin-bottom: 2px;
  max-width: 97vw;
  border: 3px solid #a36c2c;
}

.shelterFooter {
  max-width: 97vw;
}

h1 {
  color: black;
}

</style>