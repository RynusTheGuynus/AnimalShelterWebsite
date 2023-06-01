<template>
  <div>
      <div id='shelterHead'>
        <h1 class="headCenter">Rising Sun Animal Shelter<br>Hours: Tuesday-Saturday, 9-5 Eastern</h1>
        <ul class="headLeft">
          <li>Home</li>
          <li>About Us</li>
          <li>Pets for Adoption</li>
          <router-link :to="{name: 'register'}" tag="li">Apply to be a Volunteer!</router-link>
          <router-link :to="{ name: 'users' }" tag="li">Volunteer directory</router-link>
          <li>Update/Add Pets</li>
          <li>View Adopted Pets</li>
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
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-areas: 
        "headLeft headCenter .";
    background-image: url('shelterheadbanner.png');  
    background-repeat: no-repeat;
    background-size: auto;
    background-position-y: -10px;
    
}

.headLeft {
    grid-area: headLeft;
    flex-direction: column;
    height: 20vh;
    width: 10vw;
    display: flex;
    justify-content: left;
    align-self: flex-start;
    align-items: left;
    margin-top: 30px;
}

.headCenter {
    grid-area: headCenter;
    flex-direction: column;
    width: 50vw;
    justify-items: center;
    margin-top: 100px;
    margin-left: 630px;
    font-size: 24px;

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