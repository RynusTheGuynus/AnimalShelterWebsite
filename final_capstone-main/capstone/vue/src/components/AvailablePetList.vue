<template>
  <div class="available-pet-list-container">
    <div class="available-pet-list-heading">
      <img src="@/images/availablepetsbanner1.jpg" alt="banner" />
      <h1>PETS</h1>
      <h3>CURRENTLY AVAILABLE FOR ADOPTION</h3>
    </div>
    <div class="available-pet-search">
      <SearchPet id="available-pet-search-bar" :availablePets="availablePets" @search="handleSearch" />
    </div>
    <div class="available-pet-list-item-container">
      <div class="available-pet" v-for="pet in filteredPets" :key="pet.id">
        <div class="available-pet-text-box">
          <div class="available-pet-text-box-name">
            <p class="available-pet-name">{{ pet.pet_name }}</p>
          </div>
          <div class="available-pet-text-box-else">
            <p class="available-pet-species">SPECIES: {{ pet.species }}</p>
            <p class="available-pet-breed">{{ pet.breed }}</p>
            <p class="available-pet-age">AGE: {{ pet.age }}</p>
          </div>
        </div>
        <router-link id="detailLink" v-bind:to="{name: 'detail', params: {id: pet.pet_id} }"><img class="available-pet-image" :src="pet.image_path" alt="Pet Image" /></router-link> <br>
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
              pet_name: pet.petName.toUpperCase(),
              species: pet.species.toUpperCase(),
              breed: pet.breed.toUpperCase(),
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
  color: antiquewhite;
}

.available-pet-list-heading h3 {
  color: black;
}

.available-pet-list-heading img {
  border-radius: 25px;
}

.available-pet-search {
  text-align: left;
  margin-bottom: 1%;
  margin-left: 15%;
  justify-self: left;
}

.available-pet-list-item-container {
  grid-area: pet-items;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-rows: auto;
  gap: 20px;
  text-align: center;
  justify-items: center;
  margin-left: auto;
  margin-right: auto; 
}

h1 {
  background-image: none;
  background-color: transparent;
}

.available-pet {
  border-radius: 25px;
  background-color: tan;

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

.available-pet img:hover {
  opacity: 0.5;
}

.available-pet-text-box {
  display: grid;
  grid-template-columns: 1fr 1fr;
  width: 100%;
}

.available-pet-text-box-name p {
  text-align: left;
  font-size: 30px;
  font-weight: bolder;
}

.available-pet-text-box-else p {
  font-size: 12px;
  font-weight: bolder;
  margin: 5%;
  text-align: right;
}

#detailLink:hover {
  color: blue;
}

#detailLink {
  color: antiquewhite;
  font-weight: bolder;
}

</style>
