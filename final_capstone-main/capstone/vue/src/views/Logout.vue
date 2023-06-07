<template>
  <div>
    <shelter-header />
    <navigation-bar id='navigationBar' />
    <h1>Logout</h1>
    <shelter-footer />
  </div>
</template>

<script>
import ShelterFooter from '../components/ShelterFooter.vue';
import ShelterHeader from '../components/ShelterHeader.vue';
import NavigationBar from '../components/NavigationBar.vue'

export default {
  components: { ShelterHeader, ShelterFooter, NavigationBar },
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push("/");
  }
};
</script>
