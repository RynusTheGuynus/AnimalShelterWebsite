import axios from 'axios';


const http = axios.create({
  baseURL: "http://localhost:9000"
});

export default {

    sendApprovedEmail(email) {
      return http.post('/messages/approved', email );
    },

    sendDeclinedEmail(email) {
        return http.post('/messages/declined', email);
    }

}