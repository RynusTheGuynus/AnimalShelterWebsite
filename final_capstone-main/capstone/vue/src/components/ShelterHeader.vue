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
  width: 100%;
  border: 3px solid #a36c2c;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas: 
    "headLeft headCenter .";
  background-image: url('../images/shelterbanner3.png');
  background-repeat: no-repeat;
  background-size: 138%;
  background-clip: content-box;
    
}

img {
  object-fit: cover;
}

.headLeft {
    grid-area: headLeft;
    display: flex;
    flex-direction: column;
    height: 15vh;
    width: 15vw;
    justify-content: left;
    align-self: flex-start;
    align-items: left;
    margin-top: 10px;
    font-size: 12px;
    font-weight: 700;
    list-style-type: none;
    margin-left: -20px;
}

.headCenter {
    grid-area: headCenter;
    flex-direction: column;
    width: 50vw;
    justify-items: center;
    margin-top: 5vh;
    margin-left: 5vw;
    font-size: 24px;
    color: antiquewhite;
    text-shadow: -1px -1px 0 #dc9d4e, 1px -1px 0 #dc9d4e, -1px 1px 0 #dc9d4e, 1px 1px 0 #898686;

}

/* h1, h2 {
  display: flex;
  flex-direction: row;
  flex-wrap: nowrap;
  height: 10vh;
  margin-bottom: 20px;
  justify-content: center;
  color: lightgray;
} */

.router-link {
  padding: 3px;
  cursor: pointer;
}

</style>