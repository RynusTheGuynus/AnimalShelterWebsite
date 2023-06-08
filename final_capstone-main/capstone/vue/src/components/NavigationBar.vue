<template>
  <div>
    <nav id="NavBar">
      <ul>
        <li><router-link :to="{ name: 'home' }" class="router-link">Home</router-link></li>
        <li><router-link :to="{ name: 'about' }" class="router-link">About Us</router-link></li>
        <li><router-link :to="{ name: 'pets' }" class="router-link">Available Pets</router-link></li>
        <li><router-link :to="{ name: 'celebrate' }" class="router-link">Second Chances</router-link></li>
        <li><router-link :to="{ name: 'register' }" class="router-link">Join Us</router-link></li>
        <li v-if="$store.state.token !== ''" class="admin-link"><router-link :to="{ name: 'admin' }" class="router-link">Admin</router-link></li>
        <li v-if="$store.state.token !== ''" class="admin-link"><router-link :to="{ name: 'update' }" class="router-link">Add/Update Pets</router-link></li>
        <li v-if="$store.state.token !== ''" class="admin-link"><router-link :to="{ name: 'users' }" class="router-link">Volunteer Directory</router-link></li>
        <li v-if="$store.state.token === ''"><router-link :to="{ name: 'login' }" class="router-link">Volunteer Login</router-link></li>
        <li v-if="$store.state.token !== ''"><router-link :to="{ name: 'logout' }" class="router-link">Logout</router-link></li>
      </ul>
    </nav>
  </div>
</template>

<style scoped>
#NavBar {
  display: flex;
  justify-content: center;
  align-items: center;
  width: 100%;
  background-color: #CC7700;
  padding: 5px 0;
  white-space: nowrap;
}

ul {
  display: flex;
  list-style: none;
  margin: 0;
  padding: 0;
  justify-content: center;
  flex-wrap: wrap;
  align-items: center;
}

li {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  font-size: 16px;
  text-align: center;
  font-weight: bold;
}

.router-link {
  text-decoration: none;
  color: white;
  padding: 2vh 1vh;
  border-radius: 5px;
  margin: 5px;
  display: inline-block;
  
}

.router-link:hover {
  background-color: #3a4143;
}

#navigationBar {
  grid-area: navigationBar;
  display: flex;
  justify-content: center;
  align-items: center;
}

#navigationBar ul {
  display: flex;
  list-style: none;
  margin: 0;
  padding: 0;
}

#navigationBar li {
  margin-right: 20px;
  font-size: 16px;
  color: antiquewhite;
}
</style>
