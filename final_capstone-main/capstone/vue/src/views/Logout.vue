<template>
  <div>
    <shelter-header />
    <h1>Logout</h1>
    <shelter-footer />
  </div>
</template>

<script>
import ShelterFooter from '../components/ShelterFooter.vue';
import ShelterHeader from '../components/ShelterHeader.vue';


export default {
  components: { ShelterHeader, ShelterFooter },
  created() {
    this.$store.commit("LOGOUT");
    this.$router.push("/");
  }
};
</script>
