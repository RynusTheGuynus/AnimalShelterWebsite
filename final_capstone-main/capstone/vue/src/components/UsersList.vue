<template>
  <div>
    <h1>Users Lists:</h1>
    <table>
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

<style>

</style>
