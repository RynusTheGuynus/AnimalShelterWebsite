<template>
  <div id="login" class="text-center">
    <shelter-header id="header" />
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
      <button type="submit">Sign in</button>
    </form>
    <shelter-footer id="footer" />
  </div>
</template>

<script>
import UserService from "../services/UserService.js";
import ShelterHeader from '../components/ShelterHeader.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
import authService from '../services/AuthService.js'

export default {
  name: "login",
  components: { ShelterHeader, ShelterFooter },
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

<style scoped>

#login {
  background-color: #dc9d4e;
  border: 3px solid #a36c2c;
  max-width: 97.3vw;
  padding-right: -8px;
}

#header {
  margin-top: -3px;
  margin-left: -2px;
  margin-right: 1px;
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
  margin-left: -2px;
  margin-right: -5px;
  margin-bottom: -3px;
}



</style>
