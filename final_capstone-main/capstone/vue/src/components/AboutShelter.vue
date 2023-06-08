<template>
  <div class="layout">
    <!-- <h1 id="about-us-header">About Rising Sun</h1> -->
    <div class="about-photo-text-container">
        <figure id="aerialPhoto">
            <img id="overhead" src="../images/risingsunaerial.png" alt="aerial photo"/>
            <figcaption id="caption">An aerial photograph of our shelter in autumn.</figcaption>
        </figure>
        <div class="about-photo-text-paragraph-container">
            <div id="aboutText">
                <h1 class="about-photo-text-paragraph-header">About Rising Sun</h1>

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
    </div>
  </div>
</template>

<script>
export default {
    name: "AboutShelter",

}
</script>

<style>

.layout {
    background-color: tan;
    justify-content: center; 
    text-align: center;
    max-width: 100vw;   
    font-family: Arial, Helvetica, sans-serif; 
}

#about-us-header {
    font-size: 20px;
    color: black;
    margin: auto;
    padding-top: 2%;
}

.about-photo-text-container {
    display: grid;
    grid-template-columns: 1fr 1fr;
}

.about-photo-text-paragraph-container {
    display: inline-block;
    margin-top: 3%;
    margin-right: 20%;
    margin-left: -10%;
}

.about-photo-text-paragraph-header {
    font-size: 20px;
    color: black;
    margin: auto;
    padding-top: 2%;
}

#aerialPhoto {
    display: flex;
    flex-direction: column;
    font-size: 12px;
    text-align: center;
    font-style: italic;
    caption-side: bottom;
    justify-items: center;
    /* max-width: 20vw;
    max-height: 35vh; */
    width: 30vw;
    /* height: 35vh; */
    margin-top: 3%;
    margin-bottom: 3%;
    margin-left: 15%;
}

figcaption {
    text-align: center;
    margin-bottom: 10px;
}

#overhead {
    display: flex;
    flex-direction: row;
    justify-content: center;
    border-radius: 1%;
}

#aboutText {
    justify-content: center;
    font-size: 14px;
    width: 100%;
    text-align: left;
}

</style>