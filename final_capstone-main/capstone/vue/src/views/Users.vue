<template>
  <div>
    <h1>User Detail</h1>
    <users-detail />
    <users-list />
    
  </div>
</template>

<script>
import UsersDetail from "../components/UsersDetail.vue";
import UsersList from '../components/UsersList.vue';

export default {
  components: {
    UsersDetail,
    UsersList
  }
};
</script>