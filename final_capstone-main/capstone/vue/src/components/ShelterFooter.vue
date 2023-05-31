<template>
  <div>
      <h3 id='shelterFoot'>Location: 123 Front St., ST 11111</h3>
      <p>Social Media</p>
  </div>
</template>

<script>
export default {

}
</script>

<style>
#shelterFoot {
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
}

h3 {
    justify-content: center;
    flex-wrap: nowrap;
}

p {
    justify-content: right;
    padding-right: 40px;
    margin-right: 10px;
    flex-wrap: nowrap;
}

</style>