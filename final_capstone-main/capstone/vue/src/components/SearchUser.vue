<template>
  <div class="user-list-container">
      <input type="text" v-model="searchQuery" placeholder="Search users" @input="searchUsers" />
    <h2 class="center-text">View All Users</h2>
    <table class="user-table">
      <thead>
        <tr>
          <th>Username</th>
          <th>Role</th>
          <th>First Name</th>
          <th>Last Name</th>
          <th>Email</th>
          <th>Phone Number</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="user in filteredUsers" v-bind:key="user.id">
          <td>{{ user.username }}</td>
          <td>{{ extractUserRole(user.authorities) }}</td>
          <td>{{ user.first_name }}</td>
          <td>{{ user.last_name }}</td>
          <td>{{ user.email_address }}</td>
          <td>{{ user.phone_number }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import UserService from '../services/UserService.js';

export default {
  name: 'Users',
  data() {
    return {
      filteredUsers: [],
      searchQuery: '',
    }
  },
  methods: {
    getUsers() {
      UserService.getUsers().then((response) => {
        this.users = response.data;
      });
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
    searchUsers() {
        this.filteredUsers = this.users.filter(user => user.first_name.toLowerCase().includes(this.searchQuery));
    },
  },

  created() {
    this.getUsers();
  }
}
</script>

<style scoped>
.user-list-container {
  margin: 5px;
}

.user-table {
  width: 98%;
  border-collapse: collapse;
  margin-left: auto;
  margin-right: auto;
}

.user-table th, .user-table td {
  padding: 10px;
  text-align: left;
  border-bottom: 1px solid #ccc;
}

.user-table th {
  font-weight: bold;
}

.user-table tbody tr:nth-child(even) {
  background-color: #f2f2f2;
}

.center-text {
    margin-left: 0px;
}
</style>
