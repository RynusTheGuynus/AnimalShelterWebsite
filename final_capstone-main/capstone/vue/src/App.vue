<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'users' }">Users</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'admin' }">Admin</router-link>
    </div>
    <router-view />
  </div>
</template>
<script>


export default {
    
}
</script>

