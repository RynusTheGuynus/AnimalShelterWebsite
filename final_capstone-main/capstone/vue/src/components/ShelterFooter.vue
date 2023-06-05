<template>
  <div>
      <h3 id='shelterFoot'>🐶 Location: 123 Front St., ST 11111 🐱</h3>
      <p id='social'>Social Media</p>
      
      
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>

div {
    display: flex;
    justify-content: flex-end;
    flex-direction: row;
    background-color: #dc9d4e;
    border: 3px solid #a36c2c;
}


#shelterFoot {
    width: 45vw;
    margin-left: 500px;
    
}

h3 {
    
    color: black;
    margin-left: 100px;
    flex-wrap: nowrap;
}

p {
    justify-items: right;
    justify-content: right;
    width: 25vw;
    margin-left: 150px;
}

</style>