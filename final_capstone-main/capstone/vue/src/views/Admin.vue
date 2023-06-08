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
      </div>
      <shelter-footer/>
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

#approvePending {
  margin-top: 100px;
  margin-left: auto;
  margin-right: auto;
  
}

#approvePending > h2 {
  color: black;
}

#adminContent {
  font-family: Arial, Helvetica, sans-serif;
  margin-left: 1%;
  margin-right: 1%;
}

#addAdmin {
  margin-top: 8%;
  margin-bottom: 6%;
}

</style>