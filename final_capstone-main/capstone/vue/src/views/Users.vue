<template>
  <div>
    <users-list />
    <shelter-footer />
  </div>
</template>

<script>
import UsersList from '../components/UsersList.vue';
import ShelterFooter from '../components/ShelterFooter.vue'

export default {
   components: {
    UsersList,
    ShelterFooter
  },
};
</script>

