<template>
  <div>
      <shelter-header/>
      <search-user :search-query="searchQuery" @search="handleSearch" v-if="isAuthorized"/>
      <ul>
        <li v-for="user in filteredUsers" :key="user.id">{{ user.first_name }}</li>
      </ul>
      <approve-pending v-if="isAuthorized"/>
      
      <add-admin v-if="isAuthorized"/>
      <p v-else>You are not authorized to view this page.</p>
      
      <shelter-footer/>
  </div>
</template>

<script>
import AddAdmin from '../components/AddAdmin.vue'
import ApprovePending from '../components/ApprovePending.vue'
import SearchUser from '../components/SearchUser.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
import ShelterHeader from '../components/ShelterHeader.vue'

export default {
  name: 'Admin',
  components: { ApprovePending, AddAdmin, ShelterHeader, ShelterFooter, SearchUser },

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
    

<style>


</style>