<template>
  <div>
    <shelter-header />
    <navigation-bar id='navigationBar' />
    <volunteer-form/>
    <shelter-footer id="footer" />
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

<style scoped>
#footer {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  border: 3px solid #a36c2c;
}


</style>
