<template>
  <div class="adopted-pet-list-container">
    <div class="adopted-pet-list-heading">
      <img src="@/images/second-chance-2.png" alt="banner" />
      <h1>ADOPTED PETS</h1>
    </div>
    <div class="adopted-pet-list-item-container">
      <div class="adopted-pet" v-for="pet in adoptedPets" :key="pet.id">
        <div class="adopted-pet-text-box">
            <p class="adopted-pet-name">
                {{ pet.pet_name.toUpperCase() }}
            </p>
            <p class="adopted-pet-gotcha-day">
                {{ formatDate(pet.adoption_date) }}
            </p>
        </div>
            <img class="adopted-pet-image" :src="pet.image_path" alt="Pet Image" /> 
        </div>
      </div>
    </div>
</template>

<script>
import PetService from '../services/PetService.js';

export default {
    name: 'AdoptedPetList',
    data() {
        return {
            adoptedPets: [],

        }
    },
    methods: {
        getAdoptedPets() {
            PetService.getAdoptedPets()
                .then((response) => {
                    this.adoptedPets = response.data.map((pet) => {
                        return {
                            pet_name: pet.petName,
                            owner_name: pet.ownerName,
                            adoption_date: pet.adoptionDate,
                            image_path: pet.imagePath
                        };
                    });
                }).catch((error) => {
                    console.log(error);
                });
        }, 
        formatDate(date) {
            const newDate = new Date(date);
            const month = String(newDate.getMonth() + 1)
            const day = String(newDate.getDate())
            const year = newDate.getFullYear();
            return `${month}-${day}-${year}`;
        },
    },
    computed: {

    },
    watch: {

    },
  created() {
    this.getAdoptedPets();
  },
}
</script>

<style scoped>
.adopted-pet-list-container {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-areas:
    'header'
    'pet-items';
  background-color: tan;
  width: 100%;
  text-align: center;
  font-family: Arial, Helvetica, sans-serif;
}

.adopted-pet-list-heading {
  grid-area: header;
  width: 100%;
  height: 100%;
}

.adopted-pet-list-heading h1 {
  font-size: 50px;
  color: antiquewhite;
}

.adopted-pet-list-heading img {
  border-radius: 25px;
}

.adopted-pet-list-item-container {
  grid-area: pet-items;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  gap: 10px;
  text-align: center;
  justify-items: center;
  margin-left: auto; 
  margin-right: auto;
}

.adopted-pet {
  border-radius: 25px;
  background-color: tan;
  padding: 5px 5px;
  margin: 5px;
}

.adopted-pet-name {
  text-align: left;
}

.adopted-pet-adopter {
  text-align: left;
}

.adopted-pet-gotcha-day {
  text-align: left;
}

.adopted-pet img {
  height: 240px;
  width: 360px;
  border-radius: 5%;
}

.adopted-pet-text-box {
  display: grid;
  grid-template-columns: 1fr 1fr;
  width: 100%;
}

.adopted-pet-text-box p {
  font-size: 12px;
  font-weight: bolder;
  margin: 5%;
}

.adopted-pet-gotcha-day {
    justify-self: right;
}

#detailLink:hover {
  color: blue;
}

#detailLink {
  color: antiquewhite;
  font-weight: bolder;
}

</style>
