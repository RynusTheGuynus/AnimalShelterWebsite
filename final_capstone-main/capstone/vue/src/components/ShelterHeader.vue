<template>
  <div>
      <div id='shelterHead'>
        <h1 class="headCenter">Rising Sun Animal Shelter<br>Hours: Tuesday-Saturday, 9-5 Eastern</h1>
        <img src="'shelterheadbanner.png'" alt="banner">
        <ul class="headLeft">
          <router-link :to="{name: 'home'}" tag="li">Home</router-link>
          <router-link :to="{name: 'about'}" tag="li">About Us</router-link>
          <router-link :to="{name: 'pets'}" tag="li">Pets for Adoption</router-link>
          <router-link :to="{name: 'register'}" tag="li">Apply to be a Volunteer!</router-link>
          <router-link :to="{ name: 'users' }" tag="li">Volunteer directory</router-link>
          <li>Update/Add Pets</li>
          <router-link :to="{name: 'pets'}" tag="li">View Adopted Pets</router-link>
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
    height: 20vh;
    width: 15vw;
    justify-content: left;
    align-self: flex-start;
    align-items: left;
    margin-top: 30px;
    font-size: 16px;
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


</style>