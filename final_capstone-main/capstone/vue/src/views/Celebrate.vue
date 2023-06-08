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


h1 {
  color: black;
}

</style>