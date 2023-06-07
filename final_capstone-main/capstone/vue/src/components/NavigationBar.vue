<template>
  <div>
    <div id="NavBar">
      <ul>
        <li><router-link :to="{ name: 'home' }" class="router-link">Home</router-link></li>
        <li><router-link :to="{ name: 'about' }" class="router-link">About Us</router-link></li>
        <li><router-link :to="{ name: 'pets' }" class="router-link">Pets Available for Adoption</router-link></li>
        <li><router-link :to="{ name: 'celebrate' }" class="router-link">Second Chances!</router-link></li>
        <li><router-link :to="{ name: 'register' }" class="router-link">Apply to be a Volunteer!</router-link></li>
        <!-- We need to add the admin view to the nav and base its visibility on user auth/role -->
        <li v-if="$store.state.token !== ''"><router-link :to="{ name: 'admin' }" class="router-link">Admin</router-link></li>
        <li v-if="$store.state.token !== ''"><router-link :to="{ name: 'update' }" class="router-link">Add/Update Pets</router-link></li>
        <li v-if="$store.state.token !== ''"><router-link :to="{ name: 'users' }" class="router-link">Volunteer Directory</router-link></li>
        <li v-if="$store.state.token === ''"><router-link :to="{ name: 'login' }" class="router-link">Volunteer Login</router-link></li>
        <li v-if="$store.state.token !== ''"><router-link :to="{ name: 'logout' }" class="router-link">Volunteer Logout</router-link></li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style >

#NavBar {
  display: flex;
  justify-content: center;
  width: 100%;
}

ul {
  display: flex;
  list-style: none;
  margin: 0;
  padding: 0;
}

li {
  margin-right: 20px;
  font-size: 16px;
  color: antiquewhite;
}
</style>
