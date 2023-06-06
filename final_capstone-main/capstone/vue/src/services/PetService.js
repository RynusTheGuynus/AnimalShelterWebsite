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

  addPet(addPetDTO) {
    return http.post('/update', addPetDTO);
  },

  updatePet(updatePetDTO) {
    return http.put('/update', updatePetDTO);
  }

}