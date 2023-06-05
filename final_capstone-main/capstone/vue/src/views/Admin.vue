<template>
  <div>
      <shelter-header />
      <approve-pending/>
      <add-admin/>
      <search-user :search-query="searchQuery" @search="handleSearch" />
      <ul>
        <li v-for="user in filteredUsers" :key="user.id">{{ user.first_name }}</li>
      </ul>
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
      users: [],
      searchQuery: '',
    };
  },
  computed: {
    filteredUsers() {
      return this.users.filter(user => user.first_name.includes(this.searchQuery));
  },
  },
  methods: {
    handleSearch(query) {
      console.log('Received search query:', query);
      this.searchQuery = query;
    },
  },
};
</script>
    

<style>


</style>