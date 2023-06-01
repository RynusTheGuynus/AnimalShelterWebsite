<template>
  <div id="users" class="text-center">
    <users-list />
    
  </div>
</template>

<script>
import UsersList from '../components/UsersList.vue';

export default {
   components: {
    UsersList
  },
    data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'pending',
        firstName: '',
        lastName: '',
        emailAddress: '',
        phoneNumber: '',
        age: 0,
        emergencyFirstName: '',
        emergencyLastName: '',
        emergencyPhone: '',
      },
    }
  }
};
</script>

