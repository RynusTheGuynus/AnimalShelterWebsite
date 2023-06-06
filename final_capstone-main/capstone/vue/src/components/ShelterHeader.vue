<template>
  <div>
      <div id='shelterHead'>
        <h1 class="headCenter">Rising Sun Animal Shelter<br>Hours: Tuesday-Saturday, 9-5 Eastern</h1>
        <!-- The img below isn't necessary due to the background image in #shelterHead -->
        <!-- <img src="'shelterheadbanner.png'" alt="banner"> -->
        <ul class="headLeft">
          <router-link :to="{name: 'home'}" tag="li" class="router-link">Home</router-link>
          <router-link :to="{name: 'about'}" tag="li" class="router-link">About Us</router-link>
          <router-link :to="{name: 'pets'}" tag="li" class="router-link">Pets Available for Adoption</router-link>
          <router-link :to="{name: 'celebrate'}" tag="li" class="router-link">Second Chances!</router-link>
          <router-link :to="{name: 'register'}" tag="li" class="router-link">Apply to be a Volunteer!</router-link>
          <!-- We need to add the admin view to the nav and base its visibility on user auth/role -->
          <router-link :to="{ name: 'update' }" tag="li" class="router-link" v-if="$store.state.token != ''">Add/Update Pets</router-link>
          <router-link :to="{ name: 'users' }" tag="li" class="router-link" v-if="$store.state.token != ''">Volunteer Directory</router-link>
          <router-link :to="{ name: 'login' }" tag="li" class="router-link" v-if="$store.state.token == ''">Volunteer Login</router-link>
          <router-link v-bind:to="{ name: 'logout' }" tag="li" class="router-link" v-if="$store.state.token != ''">Volunteer Logout</router-link>
        </ul>
      </div>
  </div>
</template>

<script>

export default {

}
</script>

<style scoped>

#shelterHead {
    max-height: 25vh;
    min-height: 25vh;
    border: 3px solid #a36c2c;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-areas: 
        "headLeft headCenter .";
    background-image: url('shelterheadbanner.png');
    background-repeat: no-repeat;
    background-size: cover;
    background-clip: content-box;
    
}

img {
  object-fit: cover;
}

.headLeft {
    grid-area: headLeft;
    display: flex;
    flex-direction: column;
    height: 15vh;
    width: 15vw;
    justify-content: left;
    align-self: flex-start;
    align-items: left;
    margin-top: 10px;
    font-size: 12px;
    font-weight: 700;
}

.headCenter {
    grid-area: headCenter;
    flex-direction: column;
    width: 50vw;
    justify-items: center;
    margin-top: 5vh;
    margin-left: 30vw;
    font-size: 24px;
    text-shadow: -1px -1px 0 #dc9d4e, 1px -1px 0 #dc9d4e, -1px 1px 0 #dc9d4e, 1px 1px 0 #898686;

}

h1, h2 {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  height: 10vh;
  margin-bottom: 20px;
  justify-content: center;
  color: lightgray;
}

.router-link {
  padding: 3px;
  cursor: pointer;
}

</style>