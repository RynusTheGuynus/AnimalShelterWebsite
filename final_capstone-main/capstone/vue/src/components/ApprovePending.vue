<template>
  <div>
      <h1>Pending Volunteer Applications</h1>
      <table>
          <thead>
              <tr>
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
              <tr v-for="user in pendingApplications" v-bind:key="user.username">
                  <td>{{ user.username }}</td>
                  <td>{{ user.first_name }}</td>
                  <td>{{ user.last_name }}</td>
                  <td>{{ user.email_address }}</td>
                  <td>{{ user.phone_number }}</td>
                  <td>{{ user.age }}</td>
                  <td>{{ user.emerg_first_name }}</td>
                  <td>{{ user.emerg_last_name }}</td>
                  <td>{{ user.emerg_phone }}</td>
                  <td><button>Approve</button></td>
                  <td><button>Decline</button></td>
              </tr>
          </tbody>
      </table>

  </div>
</template>

<script>
import AdminService from '../services/AdminService.js';
export default {
    name: 'ApprovePending',
    data() {
        return {
            pendingApplications: []
        }
    },
    methods: {
        getPendingApplications() {
            AdminService.getPendingApplications()
            .then((response) => {
                this.pendingApplications = response.data;
            })
        },
        approveApplication() {
            AdminService.approveApplication(this.user)
        },
        declineApplication() {

        }
    
    },
    created() {
        this.getPendingApplications();
    }
}
</script>

<style>

</style>