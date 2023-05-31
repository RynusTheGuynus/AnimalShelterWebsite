<template>
  <div>Pet Component</div>
</template>

<script>
export default {
    name: 'pet-component'

}
</script>

<style>
#pets {
  display: flex;
  flex-direction: row;
  grid-area: pets;
  border: 1px solid black;
  height: 60vh;
  width: 45vw;
  margin-left: 5px;
  justify-content: flex-start;
}
</style>