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
  min-height: 100vh;
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
    "content content"
    "shelterFoot shelterFoot";
  flex: 1;
}

#shelterHeader {
  width: 100vw;
  grid-area: shelterHead;
  align-content: center;
  color: antiquewhite;
  display: flex;
  justify-content: flex-start;
}

#shelterHeader .nav {
  display: flex;
  justify-content: flex-start;
  align-items: center;
  margin-left: 20px;
}

#shelterHeader .nav li {
  list-style-type: none;
  margin-right: 20px;
  font-size: 16px;
  color: antiquewhite;
}

#content {
  display: flex; /* Added */
  flex-wrap: wrap; /* Added */
  align-items: flex-start; /* Added */
  justify-content: center; /* Added */
}

#pets {
  display: flex; /* Added */
  flex-direction: column; /* Added */
  align-items: center;
  margin-top: 45px;
  margin-bottom: 5px;
  margin-right: 5px;
  justify-content: center;
}

#events {
  display: flex; /* Added */
  flex-direction: column; /* Added */
  align-items: center;
  height: 75vh;
  margin-top: 45px;
}

#shelterFooter {
  height: 8vh;
  width: 100vh;
  display: flex;
  justify-content: flex-end;
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

