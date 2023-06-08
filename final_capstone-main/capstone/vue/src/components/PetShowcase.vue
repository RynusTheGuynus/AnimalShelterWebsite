<template>
  <div>
    <div class="pet-showcase">
      <div class="available-pet" v-if="currentPet" :key="currentPetIndex">
        <div class="available-pet-text-box">
          <h2 class="available-pet-name">{{ currentPet.pet_name.toUpperCase() }}</h2>
        </div>
        <img class="available-pet-image" :src="currentPet.image_path" alt="Pet Image" />
      </div>
    </div>
    <div class="available-pet-buttons">
    </div>
  </div>
</template>


<script>
import PetService from '../services/PetService.js';

export default {
  name: "PetShowcase",
  data() {
    return {
      availablePets: [],
      currentPetIndex: 0,
      timer: null
    };
  },
  computed: {
    currentPet() {
      return this.availablePets[this.currentPetIndex];
    },
  },
  methods: {
    getAvailablePets() {
      PetService.getAvailablePets()
        .then((response) => {
          this.availablePets = response.data.map((pet) => {
            return {
              pet_name: pet.petName,
              species: pet.species,
              breed: pet.breed,
              age: pet.age,
              image_path: pet.imagePath,
            };
          });
          this.randomlySelectPet();
          this.startTimer(); // Start the timer after getting available pets
        })
        .catch((error) => {
          console.log(error);
        });
    },
    randomlySelectPet() {
      const randomIndex = Math.floor(Math.random() * this.availablePets.length);
      this.currentPetIndex = randomIndex;
    },
    nextPet() {
      if (this.currentPetIndex < this.availablePets.length - 1) {
        const randomIndex = Math.floor(Math.random() * this.availablePets.length);
        this.currentPetIndex = randomIndex;
      } else {
        this.currentPetIndex = 0;
      }
    },
    startTimer() {
      this.timer = setInterval(() => {
        this.nextPet();
      }, 5000); // Change the interval value as desired
  },
  stopTimer() {
    clearInterval(this.timer);
  }
  },
  created() {
    this.getAvailablePets();
  },
  beforeDestroy() {
    this.stopTimer(); // Stop the timer when the component is destroyed
  }
};
</script>

<style>
.pet-showcase {
  display: flex;
  flex-direction: column;
  justify-content: left;
  align-items: center;
  overflow: hidden;
}

.available-pet {
  border-radius: 25px;
  background-color: tan;
  max-width: 600px;
  padding: 5px 5px;
  margin: 5px;
  text-align: center;
  
}

.available-pet-name {
  margin-top: 10px;
   font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  font-size: 32px;
  color: #EEE6DB;
}

.available-pet-species,
.available-pet-breed,
.available-pet-age {
  margin-top: 5px;
}

.available-pet img {
  height: auto;
  width: 100%;
  border-radius: 5%;
  margin-top: 0px;
}

.available-pet-buttons {
  display: flex;
  justify-content: center;
  margin-top: 1%;
  
}
</style>
