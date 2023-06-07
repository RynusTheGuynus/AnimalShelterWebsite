<template>
  <div class="available-pet-list-container">
    <h1 class="available-pet-list-heading">Pets Available For Adoption</h1>
    <SearchPet :availablePets="availablePets" @search="handleSearch" />
    <div class="available-pet-list-item-container">
      <div class="available-pet" v-for="pet in filteredPets" :key="pet.id">
        <div class="available-pet-text-box">
          <h2 class="available-pet-name">Name: {{ pet.pet_name }}</h2>
          <p class="available-pet-species">Species: {{ pet.species }}</p>
          <p class="available-pet-breed">Breed: {{ pet.breed }}</p>
          <p class="available-pet-age">Age: {{ pet.age }}</p>
        </div>
        <img class="available-pet-image" :src="pet.image_path" alt="Pet Image" /> <br>
        <router-link v-bind:to="{name: 'detail', params: {id: pet.pet_id} }">Learn More</router-link>
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
          console.log('API Response:', response.data);
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
          console.log('Available Pets:', this.availablePets);
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
          pet.pet_name.toLowerCase().includes(query)
        );
      }
    },
  },
  created() {
    this.getAvailablePets();
    console.log('Available Pets (AvailablePetList): ', this.availablePets);
  },
};
</script>

<style scoped>

.available-pet-list-item-container {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  height: 100%;
  width: 80%;
  gap: 10px;
  margin: 30px;
  text-align: center;
  margin-left: 10%;
}

h1 {
  background-image: none;
  background-color: transparent;
}

.available-pet-list-heading {
  text-align: center;
  margin: 20px;
  height: 2vh;
}

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

</style>
