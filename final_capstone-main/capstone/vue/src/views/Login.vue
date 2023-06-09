<template>
  <div id="login-container" class="text-center">
    <shelter-header class="shelter-header" />
    <navigation-bar id='navigationBar' />
    <div class="login-item-container">
      <form class="form-signin" @submit.prevent="login">
        <h1 class="login-header h3 mb-3 font-weight-normal">LOGIN</h1>
        <div
          class="alert alert-danger"
          role="alert"
          v-if="invalidCredentials"
        >Invalid username and password!</div>
        <div>
          <label for="username" class="sr-only">Username</label>
          <input
            type="text"
            id="username"
            class="form-control"
            placeholder="Username"
            v-model="user.username"
            required
            autofocus
          />
        </div>
        <div>
          <label for="password" class="sr-only">Password</label>
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />
        </div>
        <button class="login-button" type="submit">Sign in</button>
        <br>
        <br>
        <router-link class="application-link" :to="{ name: 'register' }">Interested in becoming a volunteer? Apply here!</router-link>
      </form>
      <img src="@/images/login2.jpg" alt="login image" />
    </div>
    <shelter-footer id="footer" />
  </div>
</template>

<script>
import UserService from "../services/UserService.js";
import ShelterHeader from '../components/ShelterHeader.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
import authService from '../services/AuthService.js'
import NavigationBar from '../components/NavigationBar.vue'

export default {
  name: "login",
  components: { ShelterHeader, ShelterFooter, NavigationBar },
  data() {
    return {
      user: {
        username: "",
        password: "",
        authorities: [],
      },
      invalidCredentials: false,
      role: '',
      message: ''
    };
  },
  methods: {
    async login() {
        const results = await UserService.getUserByName(this.user.username);
          this.authorities = results.data.authorities;
          if (Array.isArray(this.authorities) && this.authorities.length >0) {
            const role = this.authorities[0].name;
            console.log(role);
            
            if (role === 'ROLE_PENDING' || role === 'ROLE_DECLINED') {
              
              this.$router.push({
                path: '/',
                query: {loggedIn: 'failure'}
              })
              return;
            }
          }
        
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            const firstLogin = response.data.firstLogin;
            if(firstLogin) { 
                // Prompt user to change their password
                this.$router.push("/change-password");
            } else {
              // Go back to the home page upon successful login
              this.$router.push("/");
            }
          }
        })
        .catch(error => {
          const response = error.response;
          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        })
    }
  },
};
</script>

<style>

#login-container {
  background-image: linear-gradient(to right, tan, #F1ECE4);
  max-width: 100vw;
  padding-right: -8px;
  font-family: Arial, Helvetica, sans-serif;
}

#shelterHeader {
 grid-area: shelterHead;
}

.login-item-container {
  display: grid;
  grid-template-columns: 1fr 1fr;
}

.login-item-container img {
  width: 100%;
}

.form-control {
  margin-left: 10px;
  margin-right: 10px;
  margin-bottom: 50px;
  background-color: lightgrey;
}

.login-header {
  margin-left: .7%;
}

.form-signin {
  margin-left: 30%;
  margin-top: auto;
  margin-bottom: auto;
}

.login-button {
  display: block;
  padding: 10px;
  margin-left: 1.6%;
  background-color: #747474;
  color: white;
  border-radius: 4px;
  border: none;

}

.login-button:hover {
  cursor: pointer;
  background-color: #444444;
}

.application-link {
  margin-left: 1.6%;
}

.sr-only {
  margin-left: 25px;
}

#footer {
  display: flex;
  justify-content: space-evenly;
  background-color: #3a4143;
  color: antiquewhite;
  max-width: 100%;
  border: 3px solid #a36c2c;
}

.h3 {
  margin-left: 10px;
}
</style>
