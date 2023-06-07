<template>
  <div>
      <shelter-header/>
      <pet-detail></pet-detail>
      <shelter-footer/>
  </div>
</template>

<script>
import PetDetail from '../components/PetDetail.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
import ShelterHeader from '../components/ShelterHeader.vue'
export default {
    name: 'detail',
    components: { PetDetail, ShelterHeader, ShelterFooter },
}
</script>
    

<style>

</style>