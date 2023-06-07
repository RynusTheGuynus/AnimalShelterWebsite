<template>
  <div>
    <shelter-header />
    <navigation-bar id='navigationBar' />
    <volunteer-form/>
    <shelter-footer/>
  </div>
</template>

<script>
import ShelterFooter from '../components/ShelterFooter.vue'
import VolunteerForm from '../components/VolunteerForm.vue'
import ShelterHeader from '../components/ShelterHeader.vue'
import NavigationBar from '../components/NavigationBar.vue'


export default {
  components: { VolunteerForm, ShelterHeader, ShelterFooter, NavigationBar },
  
  name: 'register'
}
</script>

<style>


</style>
