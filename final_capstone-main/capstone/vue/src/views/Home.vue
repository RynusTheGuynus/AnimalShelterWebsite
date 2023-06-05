<template>
  <div class="home">
    <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for applying. You will be able to sign in once approved.</div>   
    <div id="grid">         
      <shelter-header id='shelterHeader' />
      <pet-showcase id='pets' />
      <event-component id='events' />
      <shelter-footer id='shelterFooter'/>
    </div>
  </div>
</template>

<script>

import ShelterHeader from '../components/ShelterHeader.vue'
import PetShowcase from '../components/PetShowcase.vue'
import EventComponent from '../components/EventComponent.vue'
import ShelterFooter from '../components/ShelterFooter.vue'

export default {
  name: "home",
  components: { 
    ShelterHeader,
    PetShowcase,
    EventComponent,
    ShelterFooter
  }
};
</script>

<style>

#grid {
  background-color: #dc9d4e;
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
#home {
  background-color: #dc9d4e;
}

#shelterHeader {
  height: 21vh;
  width: 100vw;  
  grid-area: shelterHead;
  align-content: center;
  color: antiquewhite;
}

#pets {
  grid-area: pets;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  width: 60vw;
  height: 75vh;
  margin-top: 45px;
  margin-bottom: 5px;
  margin-right: 5px;
}

#events {
  grid-area: events;
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  width: 40vw;
  height: 75vh;
  margin-top: 45px;
}

#shelterFooter {
  height: 8vh;
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
