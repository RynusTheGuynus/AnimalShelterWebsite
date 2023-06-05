<template>
  <div class="about">
    <shelter-header id='shelterHeader' />
    <about-component />
    <shelter-footer id='shelterFooter'/>
  </div>
</template>

<script>

import ShelterHeader from '../components/ShelterHeader.vue'
import AboutComponent from '../components/AboutComponent.vue'
import ShelterFooter from '../components/ShelterFooter.vue'

export default {
  name: "about",
  components: { 
    ShelterHeader,
    AboutComponent,
    ShelterFooter
  }
}
</script>

<style scoped>

div {
  background-color: #dc9d4e;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
  "shelterHead shelterHead"
  "photo photo"
  "history findus"
  "shelterFoot shelterFoot"
}

#shelterHeader {
  height: 21vh;
  width: 100vw;  
  grid-area: shelterHead;
  align-content: center;
  color: antiquewhite;
}

img {
  width: 20vw;
  max-height: 50vh;
}

#about {
  font-size: 12px;
}

#shelterFooter {
  height: 8vh;
  width: 100vw;
  justify-content: space-evenly;
  grid-area: shelterFoot;
}

</style>