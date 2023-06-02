<template>
  <div id="applicationContainer">
      <h2>Pending Volunteer Applications</h2>
      <table id="applicationTable">
          <thead>
              <tr id="tableHeader">
                  <th>Username</th>
                  <th>First Name</th>
                  <th>Last Name</th>
                  <th>Email Address</th>
                  <th>Phone Number</th>
                  <th>Age</th>
                  <th>Emergency Contact First Name</th>
                  <th>Emergency Contact Last Name</th>
                  <th>Emergency Contact Phone</th>
                  <th>Approve</th>
                  <th>Decline</th>
              </tr>
          </thead>
          <tbody>
              <tr id="userRows" v-for="user in pendingApplications" v-bind:key="user.user_id">
                  <td>{{ user.username }}</td>
                  <td>{{ user.first_name }}</td>
                  <td>{{ user.last_name }}</td>
                  <td>{{ user.email_address }}</td>
                  <td>{{ user.phone_number }}</td>
                  <td>{{ user.age }}</td>
                  <td>{{ user.emerg_first_name }}</td>
                  <td>{{ user.emerg_last_name }}</td>
                  <td>{{ user.emerg_phone }}</td>
                  <td><button v-on:click="approveUser(user.user_id)">Approve</button></td>
                  <td><button v-on:click="declineApplication(user.user_id)">Decline</button></td>
              </tr>
          </tbody>
      </table>

  </div>
</template>

<script>
import AdminService from '../services/AdminService.js';
import UserService from '../services/UserService.js';
export default {
    name: 'ApprovePending',
    data() {
        return {
            pendingApplications: [],
        }
    },
    methods: {
        getPendingApplications() {
            AdminService.getPendingApplications()
            .then((response) => {
                this.pendingApplications = response.data;
            })
        },
        approveUser(userId) {
            const user = UserService.get(userId);
            AdminService.approveApplication(user, userId)
            .then((response) => {
                if (response.status == 200) {
                    console.log("Success");
                    this.getPendingApplications();
                }
            })
            .catch(error => {
                if (error.status == 400) {
                    console.log("Client error")
                }
            })
            
        },
        declineApplication(userId) {
            const user = UserService.get(userId);
            AdminService.declineApplication(user, userId)
            .then((response) => {
                if (response.status == 200) {
                    console.log("Success");
                    this.getPendingApplications();
                }
            })
            .catch(error => {
                if (error.status == 400) {
                    console.log("Client error")
                }
            })
            
        }
    
    },
    created() {
        this.getPendingApplications();
    }
}
</script>

<style scoped>
#applicationContainer {
    margin: 20px;
}

#applicationTable {
    width: 100%;
    border-collapse: collapse;
}

#applicationTable th, #applicationTable td {
    padding: 10px;
  text-align: left;
  border-bottom: 1px solid #ccc;
}

tbody tr:nth-child(even) {
    background-color: #f2f2f2;
}

button {
    margin: 0px;
}
</style>