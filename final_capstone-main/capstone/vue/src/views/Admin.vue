<template>
  <div>
      <shelter-header/>
      
      <approve-pending v-if="isAuthorized"/>
      
      <add-admin v-if="isAuthorized"/>
      <p v-else>You are not authorized to view this page.</p>
      <shelter-footer/>
  </div>
</template>

<script>
import AddAdmin from '../components/AddAdmin.vue'
import ApprovePending from '../components/ApprovePending.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
import ShelterHeader from '../components/ShelterHeader.vue'

export default {
  name: 'Admin',
  components: { ApprovePending, AddAdmin, ShelterHeader, ShelterFooter },

  data() {
    return {
    isAuthorized: false,
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