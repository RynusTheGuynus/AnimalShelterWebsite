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
      this.user.username = this.username;
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

</style>