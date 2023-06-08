<template>
  <div>
    <input type="text" placeholder="Filter pets by 'cat' or 'dog'" v-model="searchQuery" @input="searchPets" />
  </div>
</template>

<script>
export default {
  props: ['availablePets'],
  data() {
    return {
      searchQuery: '',
    };
  },
  methods: {
    searchPets() {
      this.$emit('search', this.searchQuery);
    },
  },
};
</script>

<style scoped>

input {
  margin-left: 12%;
  padding: 10px;
  border-radius: .25em;
  margin-top: 1%;
  background-color: lightgrey;
}

</style>
