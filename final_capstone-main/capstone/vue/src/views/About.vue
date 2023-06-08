<template>
  <div class="layout">
    <shelter-header id='shelterHeader' />
    <navigation-bar id='navigationBar' />
    <about-component id="about" />
    <shelter-footer id='shelterFooter'/>
  </div>
</template>

<script>

import ShelterHeader from '../components/ShelterHeader.vue'
import AboutComponent from '../components/AboutComponent.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
import NavigationBar from '../components/NavigationBar.vue'

export default {
  name: "about",
  components: { 
    ShelterHeader,
    AboutComponent,
    NavigationBar,
    ShelterFooter,
  }
}
</script>

<style scoped>

#layout {
  max-width: 97vw;

  background-color: #dc9d4e;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas:
  "shelterHead"
  "photo"
  "about"
  "shelterFoot"
}

#shelterHeader {
  height: 21vh;
  width: 93vw;  
  grid-area: shelterHead;
  align-content: center;
  color: antiquewhite;
  margin-bottom: 20px;
  margin-right: 10px;
}

img {
  width: 20vw;
  max-height: 50vh;

}

#about {
  max-width: 96.5vw;
  font-size: 12px;
  grid-area: about;
  margin-top: 26px;
  margin-bottom: -5px;
  margin-right: -1px;
}

#shelterFooter {
  background-color: #3a4143;
  color: antiquewhite;
  max-width: 97vw;
  margin-right: -5px;
  margin-top: 2px;
  grid-area: shelterFoot;
  
}

</style>