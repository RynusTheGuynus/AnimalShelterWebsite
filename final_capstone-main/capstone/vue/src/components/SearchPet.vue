<template>
  <div>
    <input type="text" placeholder="Search pets..." v-model="searchQuery" @input="searchPets" />
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

<style>
</style>
