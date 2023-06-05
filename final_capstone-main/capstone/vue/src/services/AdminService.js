import axios from "axios";

const http = axios.create({
    baseURL: "http://localhost:9000"
  });
  
  export default {
      getPendingApplications() {
          return http.get('/users/pending');
      },

      approveApplication(user, userId) {
          return http.put(`/users/approve/${userId}`, user);
      },

      declineApplication(user, userId) {
          return http.put(`/users/decline/${userId}`, user);
      },

      promoteToAdmin(user, userId) {
          return http.put(`/admin/promote/${userId}`, user);
      },
  }