<template>
  <div id="wholeFooter">
      <h3 id='shelterFoot'>Location: 123 Front St., ST 11111</h3>
      <div id='social'>
          <a href="http://www.facebook.com"><img src="fbicon.png" alt="Facebook"></a>
          <a href="http://www.instagram.com"><img src="igicon.png" alt="Instagram"></a>
          <a href="http://www.twitter.com"><img src="twicon.png" alt="Twitter"></a>
      </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>

#wholeFooter {
    display: flex;
    justify-content: flex-end;
    flex-direction: row;
    flex-wrap: nowrap;
    width: 100%;
    background-color: #dc9d4e;
    border: 3px solid #a36c2c;
}

#shelterFoot {
    height: 10vh;
    display: flex;
    flex-direction: row;
    flex-wrap: nowrap;
    justify-content: space-evenly;
    color: black;
    margin: 25px;
}



img {
    margin-top: 10px;
    margin-right: 10px;
    align-items: center;
    max-height: 5vh;
}

#social {
    margin-right: 25px;
}
</style>