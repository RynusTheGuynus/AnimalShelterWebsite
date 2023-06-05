import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

  getAdoptedPets() {
    return http.get('/celebrate');
  },

  getAvailablePets() {
    return http.get('/pets');
  },

  addPet(newPet) {
    return http.post('/update', newPet);
  },

  updatePet(pet) {
    return http.put('/update', pet);
  }

}