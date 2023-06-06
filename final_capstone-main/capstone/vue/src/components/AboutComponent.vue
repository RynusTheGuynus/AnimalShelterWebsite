<template>
  <div id="layout">
    <h1 id="aboutUs">About Rising Sun</h1>
    <figure id="aerialPhoto">
        <img id="overhead" src="../images/risingsunaerial.png" alt="aerial photo"/>
        <figcaption id="caption">An aerial photograph of our shelter in autumn.</figcaption>
    </figure>
    <div id="aboutText">
        <p>Welcome to Rising Sun Animal Shelter! We are a compassionate haven dedicated to 
        providing shelter, veterinary care, and enrichment to animals in need. Our mission 
        is to rescue, rehabilitate, and find forever homes for the wonderful furry companions 
        who come through our doors.</p>

        <p>We take pride in our commitment to responsible pet adoption. Every animal that 
        comes into our shelter is thoroughly assessed, vaccinated, and spayed or neutered 
        to promote their well-being. We also offer behavioral training and rehabilitation 
        programs to ensure that each animal has the best chance of finding a loving and 
        supportive home.</p>

        <p>At Rising Sun, we understand that adopting a pet is a lifelong commitment, and we 
        take it seriously. We provide comprehensive adoption counseling and support services 
        to help prospective pet parents find the perfect match for their family and lifestyle. 
        We believe in building strong connections between humans and animals, and we are 
        thrilled to witness countless heartwarming adoption success stories.</p>

        <p>Join us in making a difference in the lives of our furry friends. Whether you're 
        looking to adopt, volunteer, donate, or simply spread the word about responsible pet 
        ownership, Rising Sun Animal Shelter is here to inspire and empower you to be a part 
        of a kinder world for animals. Together, we can create a brighter future for all 
        creatures great and small.</p>
      </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>

#layout {
    border: 3px solid #a36c2c;
    justify-content: center;     
}

#aboutUs {
    display: flex;
    flex-direction: row;
    font-size: 16px;
    grid-area: "aboutTitle";
    height: 4vh;
    width: 30vw;
    margin: auto;
    justify-content: space-around;
}

#aerialPhoto {
    display: inline-block;
    font-size: 12px;
    text-align: center;
    font-style: italic;
    grid-area: "aerialPhoto";
    caption-side: bottom;
}

figcaption {
    text-align: center;
}

img {
    max-height: 40vh;
}

#aboutText {
    justify-content: center;
    font-size: 14px;
    width: 90vw;
    margin-left: 50px;
    margin-right: 50px;
}

</style>