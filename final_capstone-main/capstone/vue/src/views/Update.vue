<template>
  <div>
      <shelter-header />
      <add-pet />
      <update-pet />
      <shelter-footer />
  </div>
</template>

<script>
import ShelterHeader from '../components/ShelterHeader.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
import AddPet from '../components/AddPet.vue'
import UpdatePet from '../components/UpdatePet.vue'

export default {
  name: 'update',
  components: { 
    ShelterHeader,
    ShelterFooter,
    AddPet,
    UpdatePet
    },

}
</script>
    
<style>

</style>