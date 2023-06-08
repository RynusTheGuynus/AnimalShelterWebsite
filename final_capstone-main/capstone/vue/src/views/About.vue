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

/* #layout {
  max-width: 100vw;
  background-color: #dc9d4e;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: auto auto 1fr auto;
  grid-template-areas:
  "shelterHead"
  "photo"
  "about"
  "shelterFoot"
} */

/* #shelterHeader {
  height: 21vh;
  width: 93vw;  
  grid-area: shelterHead;
  align-content: center;
  color: antiquewhite;
  margin-bottom: 20px;
  margin-right: 10px;
} */

/* img {
  width: 20vw;
  max-height: 50vh;

} */

/* #about {
  max-width: 96.5vw;
  font-size: 12px;
  grid-area: about;
  margin-top: 26px;
  margin-bottom: -5px;
  margin-right: -1px;
} */

/* #shelterFooter {
  max-width: 97vw;
  margin-right: -5px;
  margin-top: 2px;
  grid-area: shelterFoot;
  
} */

</style>