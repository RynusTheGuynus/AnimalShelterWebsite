<template>
  <div>
      <approve-pending/>
      <add-admin/>
  </div>
</template>

<script>
import AddAdmin from '../components/AddAdmin.vue'
import ApprovePending from '../components/ApprovePending.vue'
export default {
  name: 'Admin',
  components: { ApprovePending, AddAdmin },

}
</script>

<style>

</style>