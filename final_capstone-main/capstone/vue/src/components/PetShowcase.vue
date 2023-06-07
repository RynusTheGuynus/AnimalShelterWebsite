<template>
  <div>
    <div class="pet-showcase">
      <div class="available-pet" v-if="currentPet" :key="currentPetIndex">
        <div class="available-pet-text-box">
          <h2 class="available-pet-name">Name: {{ currentPet.pet_name }}</h2>
          <p class="available-pet-species">Species: {{ currentPet.species }}</p>
          <p class="available-pet-breed">Breed: {{ currentPet.breed }}</p>
          <p class="available-pet-age">Age: {{ currentPet.age }}</p>
        </div>
        <img class="available-pet-image" :src="currentPet.image_path" alt="Pet Image" />
      </div>
    </div>
    <div class="available-pet-buttons">
      <!-- <div class="scroll-buttons">
        <button @click="nextPet">Next</button>
      </div> -->
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
      console.log("Current pet index before update:", this.currentPetIndex);
      if (this.currentPetIndex < this.availablePets.length - 1) {
        const randomIndex = Math.floor(Math.random() * this.availablePets.length);
        this.currentPetIndex = randomIndex;
        // this.currentPetIndex++;
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
  justify-content: center;
  align-items: center;
  height: 80vh;
}

.available-pet {
  border-radius: 25px;
  background-color: tan;
  width: 400px;
  padding: 5px 5px;
  margin: 5px;
  text-align: center;
}

.available-pet-name {
  margin-top: 10px;
  font-size: 20px;
}

.available-pet-species,
.available-pet-breed,
.available-pet-age {
  margin-top: 5px;
}

.available-pet img {
  height: 240px;
  width: 360px;
  border-radius: 5%;
  margin-top: -10px;
}

.available-pet-buttons {
  display: flex;
  justify-content: center;
  margin-top: 5px;
  flex-direction: column; /* Added */
  align-items: center; /* Added */
}
</style>
