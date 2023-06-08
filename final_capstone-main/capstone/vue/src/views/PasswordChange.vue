<template>
  <div class="password-change-container">
      <shelter-header />
      <navigation-bar />
      <change-password />
      <shelter-footer />
  </div>
</template>

<script>
import ShelterHeader from '../components/ShelterHeader.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
import NavigationBar from '../components/NavigationBar.vue'
import ChangePassword from '../components/ChangePassword.vue'

export default {
  name: "PasswordChange",
  components: {
    ShelterHeader,
    ShelterFooter,
    NavigationBar,
    ChangePassword
  }
}
</script>
<style>

.password-change-container {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: auto auto 1fr;
  grid-template-areas:
    "shelter-header"
    "navigation"
    "shelter-footer";
}

</style>