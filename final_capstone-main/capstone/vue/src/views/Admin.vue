<template>
  <div>
      <shelter-header/>
      <navigation-bar id="navigationBar" />
      <div id="adminContent">
      <search-user id="userSearch" :search-query="searchQuery" @search="handleSearch" v-if="isAuthorized"/>
      <ul>
        <li v-for="user in filteredUsers" :key="user.id">{{ user.first_name }}</li>
      </ul>
      <approve-pending id="approvePending" v-if="isAuthorized"/>
      
      <add-admin id="addAdmin" v-if="isAuthorized"/>
      <p v-else>You are not authorized to view this page.</p>
<<<<<<< HEAD
      
      <shelter-footer id="footer" />
=======
      </div>
      <shelter-footer/>
>>>>>>> main
  </div>
</template>

<script>
import AddAdmin from '../components/AddAdmin.vue'
import ApprovePending from '../components/ApprovePending.vue'
import SearchUser from '../components/SearchUser.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
import ShelterHeader from '../components/ShelterHeader.vue'
import NavigationBar from '../components/NavigationBar.vue'

export default {
  name: 'Admin',
  components: { ApprovePending, AddAdmin, ShelterHeader, ShelterFooter, SearchUser, NavigationBar },

  data() {
    return {
    isAuthorized: false,
    users: [],
      searchQuery: ''
    }
  },
  methods: {
    handleSearch(query) {
      console.log('Received search query:', query);
      this.searchQuery = query;
    }
  },

    computed: {
    filteredUsers() {
      return this.users.filter(user => user.first_name.includes(this.searchQuery));
  }
  },

  created() {
    if (this.$store.state.user.authorities[0].name === 'ROLE_ADMIN') {
      this.isAuthorized = true;
    }
    }
  }


</script>
    

<style scoped>
<<<<<<< HEAD

=======
>>>>>>> main
#approvePending {
  margin-top: 100px;
  margin-left: auto;
  margin-right: auto;
  
}

#approvePending > h2 {
  color: black;
}

<<<<<<< HEAD
#footer {
  background-color: #3a4143;
  color: antiquewhite;
=======
#adminContent {
  font-family: "Verdana", "Helvetica", sans-serif;
>>>>>>> main
}

</style>