<template>
  <div>
    <shelter-header />
    <volunteer-form/>
    <shelter-footer/>
  </div>
</template>

<script>
import ShelterFooter from '../components/ShelterFooter.vue'
import VolunteerForm from '../components/VolunteerForm.vue'
import ShelterHeader from '../components/ShelterHeader.vue'



export default {
  components: { VolunteerForm, ShelterHeader, ShelterFooter },
  
  name: 'register'
}
</script>

<style>


</style>
