<template>
  <div>
      <div id='shelterHead'>
        <h1 class="headCenter">Rising Sun Animal Shelter<br>Hours: Tuesday-Saturday, 9-5 Eastern</h1>
        <ul class="headLeft">
          <li>Home</li>
          <li>About Us</li>
          <li>Pets for Adoption</li>
          <router-link :to="{name: 'register'}" tag="li">Apply to be a Volunteer!</router-link>
          <router-link :to="{ name: 'users' }">Volunteer directory</router-link>&nbsp;|&nbsp;
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

<style>

#shelterHead {
    height: 45vh;
    display: grid;
    grid-template-columns: 1fr 1fr 1fr;
    grid-template-areas: 
        "headLeft headCenter .";
    background-image: url('shelterheadbanner.png');
    background-repeat: no-repeat;
    background-size: 105%;
    margin-top: 5px;
    
}

.headLeft {
    grid-area: headLeft;
    flex-direction: column;
    width: 10vw;
    display: flex;
    justify-content: left;
    align-self: flex-start;
    align-items: left;
    border: 1px solid black;
    margin-top: 50px;
}

.headCenter {
    grid-area: headCenter;
    flex-direction: column;
    width: 50vw;
    justify-items: center;
    margin-top: 220px;
    margin-right: 350px;

}

h1, h2 {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  height: 10vh;
  margin-left: 500px;
  justify-content: center;
  color: lightgray;
  border: 1px solid black;
}

</style>