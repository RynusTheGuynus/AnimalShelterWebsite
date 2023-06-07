<template>
  <div class="home">
    <p
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for applying. You will be able to sign in once approved.</p>
      <p
        class="alert alert-failure"
        role="alert"
        v-if="this.$route.query.loggedIn"
      >You have not yet been approved by an Admin.</p>     
    <div class="grid">         
      <shelter-header id='shelterHeader' />
      <pet-showcase id='pets' />
      <event-component id='events' />
      <shelter-footer id='shelterFooter' />
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
body {
  margin: 0;
}

#home {
  background-color: #dc9d4e;
  background-size: 96vw;
  max-width: 96vw;
  display: flex;
  flex-direction: column;
}

.grid {
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
  height: 100vh;
  width: 96vw;
  background-color: #dc9d4e;
}

#shelterHeader {
  grid-area: shelterHead;
  align-content: center;
  color: antiquewhite;
  display: flex;
  justify-content: flex-start;
}

#shelterHeader .nav {
  display: flex;
  flex-direction: row;
  justify-self: flex-start;
  min-width: 60vw;
  width: 20vw;
  height: 84vh;
  margin-top: 30px;
  margin-right: -12px;
  margin-bottom: -17px;
}

#events {
  grid-area: events;
  display: flex;
  flex-direction: row;
  justify-self: flex-end;
  height: 84vh;
  width: 30vw;
  margin-top: 2px;
  margin-left: -15px;
  margin-right: 15px;
  padding-right: 15px;
  margin-bottom: 2px;
  
}

#shelterFooter {
  max-width: 98vw;
  grid-area: shelterFoot;
}

ul {
  font-size: 12px;
  color: antiquewhite;
  justify-content: left;
}

.alert {
  padding: 10px;
  width: 300px;
  border-radius: 5px;
  color: #721c24;
  background-color: #f8d7da;
  border: 1px solid #f5c6cb;
}

</style>

