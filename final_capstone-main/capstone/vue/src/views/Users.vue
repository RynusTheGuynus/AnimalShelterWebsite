<template>
  <div>
    <shelter-header />
    <users-list />
    <shelter-footer />
  </div>
</template>

<script>
import UsersList from '../components/UsersList.vue';
import ShelterFooter from '../components/ShelterFooter.vue'
import ShelterHeader from '../components/ShelterHeader.vue'

export default {
   components: {
    UsersList,
    ShelterHeader,
    ShelterFooter
  },
};
</script>

