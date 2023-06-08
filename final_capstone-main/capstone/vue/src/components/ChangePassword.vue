<template>
  <div class="change-password">
    <h1>Change Password</h1>
    <form @submit.prevent="changePassword">
      <div v-if="errorMessage" class="alert alert-danger">{{ errorMessage }}</div>
      <div v-if="successMessage" class="alert alert-success">{{ successMessage }}</div>
      <label for="username">Username:</label>
      <input type="text" id="username" v-model="user.username" required />
      <br>
      <label for="current-password">Current Password:</label>
      <input type="password" id="current-password" v-model="currentPassword" required />
      <br>
      <label for="new-password">New Password:</label>
      <input type="password" id="new-password" v-model="newPassword" required />
      <br>
      <label for="confirm-password">Confirm Password:</label>
      <input type="password" id="confirm-password" v-model="confirmPassword" required />
      <br>
      <button type="submit">Change Password</button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "ChangePassword",
  data() {
    return {
      currentPassword: "",
      newPassword: "",
      confirmPassword: "",
      errorMessage: "",
      successMessage: "",
      user: {
          username: "",
          password: ""
      }
    };
  },
  methods: {
    changePassword() {
      if (this.newPassword !== this.confirmPassword) {
        this.errorMessage = "Passwords do not match.";
        return;
      } else if (this.newPassword === this.currentPassword) {
        this.errorMessage = "New password matches current password. Please use a different password.";
        return;
      }
      this.user.password = this.newPassword;
   
      authService
        .changePassword(this.user)
        .then((response) => {
            if (response.status == 200) {
                this.successMessage = "Password changed successfully.";
                this.$router.push("/");
            }
        })
        .catch(error => {
         const response = error.response;
          if (response.status === 401) {
            this.errorMessage = "Password change unsuccessful.";
          }
        });
    }
  }
};
</script>

<style scoped>

.change-password {
  width: 100%;
  margin: 0 auto;
  padding: 20px;
  background-color: tan;
  border: 1px solid #ccc;
  border-radius: 4px;
}

h1 {
  text-align: center;
}

form {
  margin-top: 20px;
}

label {
  display: block;
  margin-bottom: 8px;
  font-weight: bold;
}

input[type="text"],
input[type="password"] {
  width: 100%;
  padding: 8px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

button[type="submit"] {
  display: block;
  width: 100%;
  padding: 10px;
  background-color: #4caf50;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.alert {
  padding: 10px;
  margin-bottom: 10px;
  border-radius: 4px;
}

.alert-danger {
  background-color: #f8d7da;
  color: #721c24;
  border: 1px solid #f5c6cb;
}

.alert-success {
  background-color: #d4edda;
  color: #155724;
  border: 1px solid #c3e6cb;
}

</style>