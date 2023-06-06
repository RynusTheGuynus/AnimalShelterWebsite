import axios from 'axios';

const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

  getUsers() {
    return http.get('/users');
  },

  get(id) {
    return http.get(`/users/id/${id}`)
  },

  getUserByName(username) {
    return http.get(`/users/username/${username}`)
  }
}