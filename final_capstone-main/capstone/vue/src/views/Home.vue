<template>
  <div class="home">
    <p class="alert alert-success" role="alert" v-if="$route.query.registration">Thank you for applying. You will be able to sign in once approved.</p>
    <p class="alert alert-failure" role="alert" v-if="$route.query.loggedIn">You have not yet been approved by an Admin.</p>     
    <div class="grid">         
      <div id="shelterHeader">
        <shelter-header />
      </div>
      <div id="navigationBar">
        <navigation-bar />
      </div>
      <div class="content">
        <pet-showcase />
        <div id='events' class="events-box">
          <event-component />
        </div>
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
.home {
  background-color: #dc9d4e;
<<<<<<< HEAD
  max-width: 100%;
=======
  background-size: 96vw;
  max-width: 96vw;
>>>>>>> main
  display: flex;
  flex-direction: column;
  align-items: center;
}

.grid {
  background-color: #dc9d4e;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-rows: auto auto auto;
  grid-template-areas:
<<<<<<< HEAD
    "shelterHead shelterHead"
    "navigationBar navigationBar"
    "content content"
    "shelterFoot shelterFoot";
  width: 100%;
  height: 100%;
=======
  "shelterHead shelterHead"
  "pets events"
  "shelterFoot shelterFoot"
}
#home {
  height: 100vh;
  width: 96vw;
  background-color: #dc9d4e;
>>>>>>> main
}

#shelterHeader {
  grid-area: shelterHead;
  display: flex;
  justify-content: center;
  align-items: center;
  color: antiquewhite;
}

#navigationBar {
  grid-area: navigationBar;
  display: flex;
<<<<<<< HEAD
  justify-content: center;
=======
  flex-direction: row;
  justify-self: flex-start;
  min-width: 60vw;
  width: 20vw;
  height: 84vh;
>>>>>>> main
  margin-top: 30px;
}

#navigationBar ul {
  display: flex;
<<<<<<< HEAD
  list-style: none;
  margin: 0;
  padding: 0;
}

#navigationBar li {
  margin-right: 20px;
  font-size: 16px;
  color: antiquewhite;
}

.content {
  grid-area: content;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-gap: 20px;
  margin: 30px 0;
  justify-items: center;
=======
  flex-direction: row;
  justify-self: flex-end;
  height: 84vh;
  width: 30vw;
  margin-top: 2px;
  margin-left: -15px;
  margin-right: 15px;
  padding-right: 15px;
  margin-bottom: 2px;
  
>>>>>>> main
}

#shelterFooter {
  grid-area: shelterFoot;
  display: flex;
  justify-content: center;
  align-items: center;
  max-width: 100%;
}

.events-box {
  max-width: 100%;
  overflow: hidden;
  text-overflow: ellipsis;
  white-space: nowrap;
  padding: 0.5em;
  box-sizing: border-box;
}


</style>
