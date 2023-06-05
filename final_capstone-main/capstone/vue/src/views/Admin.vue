<template>
  <div>
      <shelter-header/>
      
      <approve-pending v-if="access === true" />
      <p v-else>You do not have permission to view this page.</p>
      <add-admin v-if="access === true"/>
      
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
  computed: {
    access() {
      if (this.$store.state.user === {}) {
        return false;
      }
      else if (this.$store.state.user.authorities[0].name === 'ROLE_ADMIN') {
        return true;
      } else {
        return false;
      }
    }
  }

  

}
</script>

<style>


</style>