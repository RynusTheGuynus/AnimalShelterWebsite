<template>
  <div class="about-container">
    <shelter-header class='shelter-header' />
    <navigation-bar class='navigation-bar' />
    <about-shelter class='about-shelter' />
    <shelter-footer class='shelter-footer'/>
  </div>
</template>

<script>

import ShelterHeader from '../components/ShelterHeader.vue'
import AboutShelter from '../components/AboutShelter.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
import NavigationBar from '../components/NavigationBar.vue'

export default {
  name: "about",
  components: { 
    ShelterHeader,
    AboutShelter,
    NavigationBar,
    ShelterFooter,
  }
}
</script>

<style>

</style>