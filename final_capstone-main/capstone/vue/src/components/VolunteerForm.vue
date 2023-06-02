<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 class="h3 mb-3 font-weight-normal">Volunteer Application</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username: </label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      /> <br>
      <label for="password" class="sr-only">Password: </label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      /> <br>
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      /> <br>
      <label for="firstName" class="sr-only">First Name: </label>
      <input
        type="text"
        id="firstName"
        class="form-control"
        placeholder="First Name"
        v-model="user.firstName"
        required        
      /> <br>
      <label for="lastName" class="sr-only">Last Name: </label>
      <input
        type="text"
        id="lastName"
        class="form-control"
        placeholder="Last Name"
        v-model="user.lastName"
        required        
      /> <br>
      <label for="emailAddress" class="sr-only">Email Address: </label>
      <input
        type="text"
        id="emailAddress"
        class="form-control"
        placeholder="Email Address"
        v-model="user.emailAddress"
        required        
      /> <br>
      <label for="phoneNumber" class="sr-only">Phone Number: </label>
      <input
        type="text"
        id="phoneNumber"
        class="form-control"
        placeholder="Phone Number"
        v-model="user.phoneNumber"
        required        
      /> <br>
      <label for="age" class="sr-only">Age: </label>
      <input
        type="number"
        id="age"
        class="form-control"
        placeholder="Age"
        v-model="user.age"
        required        
      /> <br>
      <h3>Emergency Contact Information</h3>
      <label for="emergFirstName" class="sr-only">First Name: </label>
      <input
        type="text"
        id="emergFirstName"
        class="form-control"
        placeholder="Contact First Name"
        v-model="user.emergencyFirstName"
        required        
      /> <br>
      <label for="emergLastName" class="sr-only">Last Name: </label>
      <input
        type="text"
        id="emergLastName"
        class="form-control"
        placeholder="Contact Last Name"
        v-model="user.emergencyLastName"
        required        
      /> <br>
      <label for="emergPhone" class="sr-only">Phone Number: </label>
      <input
        type="text"
        id="emergPhone"
        class="form-control"
        placeholder="Contact Phone Number"
        v-model="user.emergencyPhone"
        required        
      /> <br>
      <router-link :to="{ name: 'login' }">Already a volunteer?</router-link> <br>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Submit Application
      </button>
    </form>
  </div>
</template>

<script>

import authService from '../services/AuthService';

export default {
  
  name: 'VolunteerForm',
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
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style>
.form-control {
  margin: 10px;
}

button {
  margin-top: 10px;
  margin-left: 10px;
  margin-bottom: 25px;
}


</style>