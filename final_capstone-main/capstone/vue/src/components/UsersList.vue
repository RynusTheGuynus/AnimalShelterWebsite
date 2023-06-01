<template>
  <div class="user-list-container">
    <h1 class="center-text">Users Lists:</h1>
    <table class="user-table">
      <thead>
        <tr>
          <th>User Role</th>
          <th>User First Name</th>
          <th>User Last Name</th>
          <th>User Email</th>
          <th>User Phone Number</th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="user in users" v-bind:key="user.id">
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
      users: []
    }
  },
  methods: {
    getUsers() {
      UserService.getUsers().then((response) => {
        this.users = response.data.filter(user => !this.isPending(user));
      });
    },
    isPending(user) {
        const userRole = this.extractUserRole(user.authorities)
        return userRole === 'PENDING';
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
    }
  },
  created() {
    this.getUsers();
  }
}
</script>

<style scoped>
.user-list-container {
  margin: 20px;
}

.user-table {
  width: 100%;
  border-collapse: collapse;
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
