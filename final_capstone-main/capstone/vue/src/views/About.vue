<template>
  <div class="about">
    <shelter-header id='shelterHeader' />
      <h1>About Rising Sun</h1>
      <figure>
        <img src="vue\public\risingsunaerial.png" alt="aerial photo">
        <figcaption>An aerial photograph of our shelter in autumn.</figcaption>
      </figure>
      <div></div>
      <div id="about">
          <p>Welcome to Rising Sun Animal Shelter! We are a compassionate haven dedicated to 
            providing shelter, veterinary care, and enrichment to animals in need. Our mission 
            is to rescue, rehabilitate, and find forever homes for the wonderful furry companions 
            who come through our doors.</p>

          <p>We take pride in our commitment to responsible pet adoption. Every animal that 
            comes into our shelter is thoroughly assessed, vaccinated, and spayed or neutered 
            to promote their well-being. We also offer behavioral training and rehabilitation 
            programs to ensure that each animal has the best chance of finding a loving and 
            supportive home.</p>

          <p>At Rising Sun, we understand that adopting a pet is a lifelong commitment, and we 
            take it seriously. We provide comprehensive adoption counseling and support services 
            to help prospective pet parents find the perfect match for their family and lifestyle. 
            We believe in building strong connections between humans and animals, and we are 
            thrilled to witness countless heartwarming adoption success stories.</p>

          <p>Join us in making a difference in the lives of our furry friends. Whether you're 
            looking to adopt, volunteer, donate, or simply spread the word about responsible pet 
            ownership, Rising Sun Animal Shelter is here to inspire and empower you to be a part 
            of a kinder world for animals. Together, we can create a brighter future for all 
            creatures great and small.</p>
      </div>
      <div></div>
      <shelter-footer id='shelterFooter'/>
  </div>
</template>

<script>

import ShelterHeader from '../components/ShelterHeader.vue'
import ShelterFooter from '../components/ShelterFooter.vue'

export default {
  name: "about",
  components: { 
    ShelterHeader,
    ShelterFooter
  }
}
</script>

<style scoped>

div {
  background-color: #dc9d4e;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
  "shelterHead shelterHead"
  "photo photo"
  "history findus"
  "shelterFoot shelterFoot"
}

#shelterHeader {
  height: 20vh;
  width: 100vw;  
  grid-area: shelterHead;
  align-content: center;
  color: antiquewhite;
}

img {
  width: 20vw;
  max-height: 50vh;
}

#about {
  font-size: 12px;
}

#shelterFooter {
  height: 8vh;
  width: 100vw;
  justify-content: space-evenly;
  grid-area: shelterFoot;
}

</style>