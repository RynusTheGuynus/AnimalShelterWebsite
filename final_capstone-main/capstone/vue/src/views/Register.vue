<template>
  <div>
  <volunteer-form/>
  <shelter-footer/>
  </div>
</template>

<script>
import ShelterFooter from '../components/ShelterFooter.vue'
import VolunteerForm from '../components/VolunteerForm.vue'



export default {
  components: { VolunteerForm, ShelterFooter },
  
  name: 'register'
}
</script>

<style>


</style>
