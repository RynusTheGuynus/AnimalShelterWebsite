<template>
  <div>

  </div>
</template>

<script>
export default {
      name: 'usersDetails',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'pending',
        firstName: '',
        lastName: '',
        emailAddress: '',
        phoneNumber: '',
        age: 0,
        emergencyFirstName: '',
        emergencyLastName: '',
        emergencyPhone: '',
      }
    }
  }
}
</script>

<style>

</style>