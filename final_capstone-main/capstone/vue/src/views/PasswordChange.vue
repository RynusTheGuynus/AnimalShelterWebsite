<template>
  <div class="password-change-container">
      <shelter-header />
      <navigation-bar />
      <change-password id="change-password"/>
      <shelter-footer id="footer"/>
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
<style scoped>

.password-change-container {
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: auto auto 1fr;
  grid-template-areas:
    "shelter-header"
    "navigation"
    "shelter-footer";
}
#footer {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  border: 3px solid #a36c2c;
  width: 100vw;
}
#change-password {
  width: 100vw;
  margin: auto;
}

</style>