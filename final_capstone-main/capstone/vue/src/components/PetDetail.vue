<template>
  <div id="pet-detail-container">
      <h1 id="nameHeader">{{this.pet.pet_name.toUpperCase()}}</h1>
      <div id="photoAndDetails">
      <div id="imageContainer">
      <img :src="images[this.currentIndex].image_path" alt="Available Pet Image" id="detailImage"> <br>
      <button id="nextPhotoBtn" v-on:click="changePhoto">Next Photo</button>
      </div>
      <table id="detailsTable" style="width:35%">
  <tr class="detailsRow">
    <th>Age</th>
    <td>{{this.pet.age}}</td>
  </tr>
  <tr class="detailsRow">
    <th>Species</th>
    <td>{{this.pet.species.toUpperCase()}}</td>
  </tr>
  <tr class="detailsRow">
    <th>Breed</th>
    <td>{{this.pet.breed.toUpperCase()}}</td>
  </tr>
  <tr class="detailsRow">
    <th>Weight</th>
    <td>{{this.pet.weight}} lbs.</td>
  </tr>
  <tr class="detailsRow">
    <th>Gender</th>
    <td>{{this.pet.gender.toUpperCase()}}</td>
  </tr>
</table>
</div>
    <p id="petDescription">{{this.pet.description}}</p>
  </div>
</template>

<script>
import PetService from '../services/PetService.js'

export default {
    name: 'pet-detail',
    data() {
        return {
            images: [],
            id: this.$route.params.id,
            pet: {},
            currentIndex: 0,
        }
    },
    methods: {
        getAllImages(id) {
            PetService.getPetImages(id)
            .then(response => {
                this.images = response.data;
            })
        },
        getPetDetails(id) {
            PetService.getPetById(id)
            .then(response => {
                this.pet = response.data;
            })
        },
        changePhoto() {
            if (this.currentIndex < this.images.length -1) {
                this.currentIndex++;
            } else {
                this.currentIndex = 0;
            }
        }
    
    },
    created() {
        this.getPetDetails(this.id);
        this.getAllImages(this.id);
    }
}
</script>

<style scoped>
#pet-detail-container {
    display: flex;
    flex-direction: column;
    align-items: stretch;
    background-image: linear-gradient(to right, tan, #F1ECE4);
    font-family: Verdana, Helvetica, sans-serif;
}

#imageContainer {
    display: flex;
    flex-direction: column;
    align-items: center;
}

#photoAndDetails {
    display: flex;
    margin-top: 50px;
    justify-content: space-evenly;
}

#petDescription {
    margin: auto;
    margin-bottom: 50px;
    margin-top: 25px;
}

#detailsTable {
    border-collapse: collapse;
}

#detailsTable td {
    border-bottom: 1px solid #ECECEC;
}
#detailImage {
  height: 240px;
  width: 360px;
  border-radius: 5%;
}
#nameHeader {
    color: black;
    text-align: center;
}

#nextPhotoBtn {
  margin: 0px;
  border-radius: 5px;
  border: none;
  cursor: pointer;
  padding: 10px 20px;
  color: white;
  background-color: #747474;
}

#nextPhotoBtn:hover {
    background-color: #444444;
}
</style>