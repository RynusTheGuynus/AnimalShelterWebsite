import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:9000"
  });
  
  export default {
      getPendingApplications() {
          return http.get('/users/pending');
      },

      approveApplication(user) {
          return http.put('/users/approve', user);
      },

      declineApplication(user) {
          return http.put('/users/decline', user);
      }
  }