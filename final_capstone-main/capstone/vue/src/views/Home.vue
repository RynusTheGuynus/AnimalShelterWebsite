<template>
  <div class="home">
    <p class="alert alert-success" role="alert" v-if="$route.query.registration">Thank you for applying. You will be able to sign in once approved.</p>
    <p class="alert alert-failure" role="alert" v-if="$route.query.loggedIn">You have not yet been approved by an Admin.</p>     
    <div class="grid">         
        <shelter-header class="shelter-header" />
      
      <navigation-bar id="navigationBar"/>
     
        <div class="pet-container">
          <pet-showcase />
        </div>
        <div id='events' class="events-box">
          <event-component />
        </div>
      
      <div id="shelterFooter">
        <shelter-footer />
      </div>
    </div>
  </div>
</template>

<script>
import ShelterHeader from '../components/ShelterHeader.vue'
import PetShowcase from '../components/PetShowcase.vue'
import EventComponent from '../components/EventComponent.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
import NavigationBar from '../components/NavigationBar.vue'

export default {
  name: "home",
  components: {
    ShelterHeader,
    PetShowcase,
    EventComponent,
    ShelterFooter,
    NavigationBar
  }
}
</script>


<style>
/* .home {
  background-color: #dc9d4e;
  min-height: 100vh;
  display: flex;
  flex-direction: column;
  align-items: center;
} */

.grid {
  background-color: tan;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-auto-rows: auto minmax(0, 1fr) auto;
  grid-template-areas:
    "shelter-header shelter-header"
    "navigationBar navigationBar"
    "pet-container events-box"
    "shelterFoot shelterFoot";
  width: 100%;
  flex-grow: 1;
}

.shelter-header {
  grid-area: shelter-header;


}

.pet-container {
  display: flex;
  justify-content: center;
}

#shelterFooter {
  background-color: #3a4143;
  color: antiquewhite;
  grid-area: shelterFoot;
  /* display: flex;
  justify-content: center;
  align-items: center; */
  max-width: 100%;
}

.events-box {
  max-width: 100%;
  overflow: auto; 
  white-space: normal;
  padding: 0.5em;
  box-sizing: border-box;
  margin-right: 120px;
}



</style>
