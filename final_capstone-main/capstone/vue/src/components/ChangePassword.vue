<template>
  <div class="change-password">
    <div id="change-password-container">
    <h1 class="password-header">CHANGE PASSWORD</h1>
    <form id="changePasswordForm" @submit.prevent="changePassword">
      <div v-if="errorMessage" class="alert alert-danger">{{ errorMessage }}</div>
      <div v-if="successMessage" class="alert alert-success">{{ successMessage }}</div>
      <label for="username">Username</label>
      <input type="text" id="username" placeholder="Username" v-model="user.username" required />
      <br>
      <label for="current-password">Current Password</label>
      <input type="password" id="current-password" placeholder="Current Password" v-model="currentPassword" required />
      <br>
      <label for="new-password">New Password</label>
      <input type="password" id="new-password" placeholder="New Password" v-model="newPassword" required />
      <br>
      <label for="confirm-password">Confirm Password</label>
      <input type="password" id="confirm-password" placeholder="Confirm Password" v-model="confirmPassword" required />
      <br>
      <button class="change-password-submit-button" type="submit">Submit</button>
    </form>
    </div>
    <img id="password-dog" src="@/images/password-dog.png" alt="change password image" />
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
  max-width: 100vw;
  font-family: Helvetica, Arial, sans-serif;
  margin: 0 auto;
  background-image: linear-gradient(to right, tan, #F1ECE4);
  border: 1px solid #ccc;
  border-radius: 4px;
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas: 
  "passwordContainer passwordDog";
  overflow-x:hidden;
}

#change-password-container {
  width: 100%;
  grid-area: passwordContainer;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  justify-content: center;
  margin-left: 30%; 

}

#password-dog {
  grid-area: passwordDog;
  width: 100%;
  
}

.password-header {
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
  padding: 8px;
  margin-bottom: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  background-color: lightgray;
}

button[type="submit"] {
  display: block;
  padding: 10px;
  background-color: #747474;
  color: white;
  border: none;
  border-radius: 4px;
  cursor: pointer;
  margin-top: 5px;
}

button[type="submit"]:hover {
  background-color: #444444;
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