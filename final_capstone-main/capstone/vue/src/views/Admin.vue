<template>
  <div>
      <shelter-header />
      <approve-pending/>
      <add-admin/>
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

}
</script>

<style>


</style>