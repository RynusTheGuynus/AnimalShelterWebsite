<template>
  <div>
      <approve-pending/>
      <add-admin/>
      <shelter-footer/>
  </div>
</template>

<script>
import AddAdmin from '../components/AddAdmin.vue'
import ApprovePending from '../components/ApprovePending.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
export default {
  name: 'Admin',
  components: { ApprovePending, AddAdmin, ShelterFooter },

}
</script>

<style>


</style>