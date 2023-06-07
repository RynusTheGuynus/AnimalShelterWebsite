<template>
  <div>
    <nav id="NavBar">
      <ul>
        <li><router-link :to="{ name: 'home' }" class="router-link">Home</router-link></li>
        <li><router-link :to="{ name: 'about' }" class="router-link">About Us</router-link></li>
        <li><router-link :to="{ name: 'pets' }" class="router-link">Pets Available</router-link><br>for Adoption</li>
        <li><router-link :to="{ name: 'celebrate' }" class="router-link">Second Chances!</router-link></li>
        <li><router-link :to="{ name: 'register' }" class="router-link">Apply to be a<br>Volunteer!</router-link></li>
        <li v-if="$store.state.token !== ''" class="admin-link"><router-link :to="{ name: 'admin' }" class="router-link">Admin</router-link></li>
        <li v-if="$store.state.token !== ''" class="admin-link"><router-link :to="{ name: 'update' }" class="router-link">Add/Update Pets</router-link></li>
        <li v-if="$store.state.token !== ''" class="admin-link"><router-link :to="{ name: 'users' }" class="router-link">Volunteer Directory</router-link></li>
        <li v-if="$store.state.token === ''"><router-link :to="{ name: 'login' }" class="router-link">Volunteer Login</router-link></li>
        <li v-if="$store.state.token !== ''" class="router-link"><router-link :to="{ name: 'logout' }" class="router-link">Volunteer Logout</router-link></li>
      </ul>
    </nav>
  </div>
</template>

<script>
export default {};
</script>

<style>
#NavBar {
  display: flex;
  justify-content: center;
  width: 100%;
  background-color: rgb(92, 59, 10);
  padding: 10px 0;
  border-radius: 5px;
  white-space: nowrap; /* Prevent line breaks within the navigation links */
}

ul {
  display: flex;
  list-style: none;
  margin: 0;
  padding: 0;
  justify-content: center; /* Center the navigation links */
  flex-wrap: wrap; /* Allow wrapping of the navigation items */
}

li {
  font-size: 12px;
  text-align: center;
}

.router-link {
  text-decoration: none;
  color: white;
  padding: 5px 5px; /* Adjust the padding to reduce the spaces */
  border-radius: 5px;
  margin: 5px; /* Adjust the margin to reduce the spaces */
}

.router-link:hover {
  background-color: rgb(85, 85, 85); /* Change the background color of the links on hover */
}
</style>
