<template>
  <div id="volunteerContainer">
      <h2>Promote Volunteer to Admin</h2>
      <table id="volunteerTable">
      <thead>
        <tr>
          <th>Role</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Phone Number</th>
          <th>Promote to Admin</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="user in volunteers" v-bind:key="user.id">
          <td>{{ extractUserRole(user.authorities) }}</td>
          <td>{{ user.first_name }}</td>
          <td>{{ user.last_name }}</td>
          <td>{{ user.email_address }}</td>
          <td>{{ user.phone_number }}</td>
          <td><button id="approveAdminBtn" v-on:click="addAdmin(user.user_id)">Promote to Admin</button></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import AdminService from '../services/AdminService.js'
import UserService from '../services/UserService.js'
export default {
    name: 'AddAdmin',
    data() {
        return {
            volunteers: [],
        }
    },
    methods: {
        getVolunteers() {
            UserService.getUsers().then((response) => {
                this.volunteers = response.data.filter(user => this.isVolunteer(user))
            })
        },
        isVolunteer(user) {
        const userRole = this.extractUserRole(user.authorities)
        return userRole === 'Volunteer';
    },
    extractUserRole(authorities) {
      if (Array.isArray(authorities) && authorities.length > 0) {
        const role = authorities[0].name;
        const roleParts = role.split('_');
        if (roleParts.length === 2 && roleParts[0] === 'ROLE') {
            if(roleParts[1] === 'USER') {
                roleParts[1] = 'Volunteer';
                return roleParts[1];
            }
          return roleParts[1];
        }
      }
      return '';
    },
    addAdmin(userId) {
        const user = UserService.get(userId);
        AdminService.promoteToAdmin(user, userId)
        .then((response) => {
            if (response.status == 200) {
                console.log("Success");
                this.getVolunteers();
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
        this.getVolunteers();
    }
}
</script>

<style scoped>
#volunteerContainer {
    margin: 20px;
}

tbody tr:nth-child(even) {
    background-color: #f2f2f2;
}

#volunteerTable {
    width: 98%;
    border-collapse: collapse;
    margin-left: auto;
    margin-right: auto;
}

#volunteerTable th, #volunteerTable td {
    padding: 10px;
    text-align: left;
    border-bottom: 1px solid #ccc;
}

button {
    margin: 0px;
    border-radius: 5px;
  border: none;
  cursor: pointer;
  padding: 10px 20px;
  color: white;
}

#volunteerContainer > h2 {
    color: black;
}

#approveAdminBtn {
    background-color:limegreen;
}

#approveAdminBtn:hover {
    background-color: darkgreen;
}
</style>