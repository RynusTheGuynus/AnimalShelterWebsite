<template>
  <div id="wholeFooter">
    <h3 id='shelterFoot'>Location: 123 Front St., ST 11111</h3>
    <span id="social">
      <a href="http://www.facebook.com"><img src="../images/fbicon.png" alt="Facebook"></a>
      <a href="http://www.instagram.com"><img src="../images/igicon.png" alt="Instagram"></a>
      <a href="http://www.twitter.com"><img src="../images/twicon.png" alt="Twitter"></a>
    </span>
  </div>
</template>

<style scoped>

#wholeFooter {
  display: flex;
  flex-direction: row;
  background-color: #dc9d4e;
  border: 3px solid #a36c2c;
  justify-content: center;
  padding: 20px;
  width: 100%;
  bottom: 0; 
}

#shelterFoot {
  width: 450px;
  height: 3vh;
  text-align: center;
  color: black;
  margin: 0;
}

#social {
  display: flex;
  align-items: center;
}

img {
  margin-right: 10px;
  max-height: 4vh;
}
</style>
