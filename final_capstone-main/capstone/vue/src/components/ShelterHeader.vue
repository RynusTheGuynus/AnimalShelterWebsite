<template>
  <div>
      <div id='shelterHead'>
        <h1 class="headCenter">Rising Sun Animal Shelter</h1>
      </div>
  </div>
</template>

<script>

export default {

}
</script>

<style>

#shelterHead {
 font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  height: 19.5vh;
  border: 3px solid #a36c2c;
  display: flex;
  justify-content: center;
  align-items: center;
  background-image: url('../images/shelterbanner3.png');
  background-repeat: no-repeat;
  background-size: cover;
  background-clip: content-box;
}

img {
  object-fit: cover;
}


.headCenter {
    grid-area: headCenter;
    flex-direction: column;
    width: 50vw;
    justify-items: center;
    margin-top: -5vh;
    margin-left: -20vw;
    font-size: 50px;
    color: antiquewhite;
    text-shadow: -1px -1px 0 #dc9d4e, 1px -1px 0 #dc9d4e, -1px 1px 0 #dc9d4e, 1px 1px 0 #898686;

}

.router-link {
  padding: 3px;
  cursor: pointer;
}

</style>