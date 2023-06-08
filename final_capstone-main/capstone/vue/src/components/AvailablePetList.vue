<template>
  <div class="available-pet-list-container">
    <div class="available-pet-list-heading">
      <img src="@/images/availablepetsbanner1.jpg" alt="banner" />
      <h1>PETS</h1>
      <h3>CURRENTLY AVAILABLE FOR ADOPTION</h3>
    </div>
    <div class="search">
      <SearchPet :availablePets="availablePets" @search="handleSearch" />
    </div>
    <div class="available-pet-list-item-container">
      <div class="available-pet" v-for="pet in filteredPets" :key="pet.id">
        <div class="available-pet-text-box">
          <h2 class="available-pet-name">{{ pet.pet_name }}</h2>
          <p class="available-pet-species">Species: {{ pet.species }}</p>
          <p class="available-pet-breed">Breed: {{ pet.breed }}</p>
          <p class="available-pet-age">Age: {{ pet.age }}</p>
        </div>
        <img class="available-pet-image" :src="pet.image_path" alt="Pet Image" /> <br>
        <router-link id="detailLink" v-bind:to="{name: 'detail', params: {id: pet.pet_id} }">Learn More</router-link>
      </div>
    </div>
  </div>
</template>

<script>
import PetService from '../services/PetService.js';
import SearchPet from '../components/SearchPet.vue';

export default {
  components: {
    SearchPet
  },
  name: 'AvailablePetList',
  data() {
    return {
      availablePets: [],
      searchQuery: '',
    };
  },
  methods: {
    getAvailablePets() {
      PetService.getAvailablePets()
        .then((response) => {
          this.availablePets = response.data.map((pet) => {
            return {
              pet_id: pet.petId,
              pet_name: pet.petName,
              species: pet.species,
              breed: pet.breed,
              age: pet.age,
              image_path: pet.imagePath
            };
          });
        })
        .catch((error) => {
          console.log(error);
        });
    },
    handleSearch(query) {
      this.searchQuery = query;
    },
  },
  computed: {
    filteredPets() {
      if (!this.searchQuery) {
        return this.availablePets;
      } else {
        const query = this.searchQuery.toLowerCase();
        return this.availablePets.filter(pet =>
          pet.species.toLowerCase().includes(query)
        );
      }
    },
  },
  created() {
    this.getAvailablePets();
  },
};
</script>

<style scoped>

.available-pet-list-container {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas: 
  "header"
  "search"
  "pet-items";
  background-color: tan;
  width: 100%;
  text-align: center;
  font-family: Arial, Helvetica, sans-serif;
}

.available-pet-list-heading {
  grid-area: header;
  width: 100%;
  height: 100%;
}

.available-pet-list-heading h1 {
  font-size: 50px;
  color: red;
}

.available-pet-list-heading h3 {
  color: black;
}

.available-pet-list-heading img {
  border-radius: 25px;
}

.search {
  text-align: left;
}

.available-pet-list-item-container {
  grid-area: pet-items;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: auto;
  height: 50%;
  gap: 10px;

  text-align: center;
}

h1 {
  background-image: none;
  background-color: transparent;
}

/* .available-pet-list-heading {
  text-align: center;
  margin: 20px;
  height: 2vh;
} */

.available-pet {
  border-radius: 25px;
  background-color: tan;
  width: 400px;
  padding: 5px 5px;
  margin: 5px;
}

.available-pet-name {
  text-align: left;
}

.available-pet-species {
  text-align: left;
}

.available-pet-breed {
  text-align: left;
}

.available-pet-age {
  text-align: left;
}

.available-pet img {
  height: 240px;
  width: 360px;
  border-radius: 5%;
}

.available-pet-text-box {
  display: inline-block;
}

#detailLink:hover {
  color: white;
}

#detailLink {
  color: blue;
}

</style>
