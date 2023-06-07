<template>
  <div>
      <shelter-header/>
      <navigation-bar id="navigationBar"/>
      <pet-detail></pet-detail>
      <shelter-footer/>
  </div>
</template>

<script>
import NavigationBar from '../components/NavigationBar.vue'
import PetDetail from '../components/PetDetail.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
import ShelterHeader from '../components/ShelterHeader.vue'
export default {
    name: 'detail',
    components: { PetDetail, ShelterHeader, ShelterFooter, NavigationBar },
}
</script>
    

<style>

</style>