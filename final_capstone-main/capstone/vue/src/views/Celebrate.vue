<template>
  <div id="celebrate">
    <shelter-header />
    <navigation-bar id='navigationBar' />
    <adopted-pet-list class="adopted" />
    <shelter-footer class="shelterFooter" />
  </div>
</template>

<script>
import AdoptedPetList from '../components/AdoptedPetList.vue'
import ShelterHeader from '../components/ShelterHeader.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
import NavigationBar from '../components/NavigationBar.vue'

export default {
  name: 'celebrate',
  components: { 
      AdoptedPetList,
      ShelterHeader,
      ShelterFooter,
      NavigationBar
    },

}
</script>

<style scoped>
/* #celebrate {
  display: flex;
  flex-direction: column;
}

.adopted {
  margin-top: -118px;
  margin-bottom: 2px;
  max-width: 97vw;
  border: 3px solid #a36c2c;
} */

.shelterFooter {
  /* max-width: 98vw; */
}

h1 {
  color: black;
}

</style>