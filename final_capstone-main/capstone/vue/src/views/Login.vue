<template>
  <div id="login" class="text-center">
    <shelter-header class="shelter-header" />
    <navigation-bar id='navigationBar' />
    <form class="form-signin" @submit.prevent="login">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
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
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link :to="{ name: 'register' }">Interested in becoming a volunteer? Apply here!</router-link>
      <button class="loginBtn" type="submit">Sign in</button>
    </form>
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

#login {
  background-color: tan;
  max-width: 100vw;
  padding-right: -8px;
}

#shelterHeader {
 grid-area: shelterHead;
}

.form-control {
  margin-left: 10px;
  margin-right: 10px;
  margin-bottom: 50px;
  background-color: lightgrey;
}

.sr-only {
  margin-left: 25px;
}

#footer {
  display: flex;
  justify-content: space-evenly;
  background-color: #3a4143;
  color: antiquewhite;
  max-width: 100vw;
  border: 3px solid #a36c2c;
}

.loginBtn {
  color: #fff;
  background-color: #747474;
  border-radius: 5px;
  border: none;
  cursor: pointer;
  padding: 10px 20px;
  margin-left: 15px;
}
.loginBtn:hover {
  background-color: #444444;
}

.h3 {
  margin-left: 10px;
}
</style>
