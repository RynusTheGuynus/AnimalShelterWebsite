<template>
  <div class="home">
    <div>             
      <shelter-header id='shelterHead' />
      <pet-component id='pets' />
      <event-component id='events' />
      <shelter-footer id='shelterFoot'/>
    </div>
  </div>
</template>

<script>

import ShelterHeader from '../components/ShelterHeader.vue'
import PetComponent from '../components/PetComponent.vue'
import EventComponent from '../components/EventComponent.vue'
import ShelterFooter from '../components/ShelterFooter.vue'

export default {
  name: "home",
  components: { 
    ShelterHeader,
    PetComponent,
    EventComponent,
    ShelterFooter
  }
};
</script>

<style>

#home {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
  "shelterHead shelterHead"
  "pets events"
  "shelterFoot shelterFoot"
}

#shelterHead {
  height: 20vh;
  width: 95vw;  
  grid-area: shelterHead;
  align-content: center;
  color: antiquewhite;
  margin-left: 5px;
}

#shelter {
  border: 1px solid green;
  justify-content: center;
}

#shelterFoot {
  height: 10vh;
  width: 100vw;
  justify-content: space-evenly;
  grid-area: shelterFoot;
}

ul {
  font-size: 12px;
  color: antiquewhite;
  justify-content: left;
}



</style>
