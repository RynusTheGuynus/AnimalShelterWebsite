<template>
    <div>
        <div id="wholeFooter">
        <h3 id='shelterFoot'>Location: 123 Front St., ST 11111</h3>
        <span id="social">
            <a href="http://www.facebook.com"><img src="../images/fbicon.png" alt="Facebook"></a>
            <a href="http://www.instagram.com"><img src="../images/igicon.png" alt="Instagram"></a>
            <a href="http://www.twitter.com"><img src="../images/twicon.png" alt="Twitter"></a>
        </span>
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
    flex-direction: row;
    background-color: #dc9d4e;
    border: 3px solid #a36c2c;
    justify-content: center;
    margin-top: 2px;
    max-width: 97vw;
    
} 
 
#shelterFoot {
    margin-left: 350px;
    width: 450px;
    height: 3vh;
    display: flex;
    flex-direction: row;
    justify-content: space-evenly;
    padding-left: 10vw;
    color: black;
    
} 
 
#social {
    display: flex;
    padding-top: 15px;
    align-content: center;
    flex-basis: 10%;
    flex-direction: row;
    justify-items: flex-end;
    margin-left: 300px;
} 

img {
    flex-direction: row;
    margin-right: 10px;
    align-items: flex-end;
    max-height: 4vh;
} 

#social {
    margin-right: 25px;
}
</style>