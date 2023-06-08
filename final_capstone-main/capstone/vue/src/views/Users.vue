<template>
  <div>
    <shelter-header />
    <navigation-bar id='navigationBar' />
    <users-list/>
    <shelter-footer id="footer" />
  </div>
</template>

<script>
import UsersList from '../components/UsersList.vue';
import ShelterFooter from '../components/ShelterFooter.vue'
import ShelterHeader from '../components/ShelterHeader.vue'
import NavigationBar from '../components/NavigationBar.vue'

export default {
   components: {
    UsersList,
    ShelterHeader,
    ShelterFooter,
    NavigationBar
  },

  
};
</script>

<style scoped>

#footer {
  background-color: #3a4143;
  color: antiquewhite;
}

</style>

