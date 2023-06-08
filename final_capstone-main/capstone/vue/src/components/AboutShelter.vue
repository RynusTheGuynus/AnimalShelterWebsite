<template>
  <div class="about-shelter-container">
    <div class="about-photo-text-container">
        <figure id="aerialPhoto">
            <img id="overhead" src="../images/risingsunaerial.png" alt="aerial photo"/>
            <figcaption id="caption">An aerial photograph of our shelter in autumn.</figcaption>
        </figure>
        <div class="about-photo-text-paragraph-container">
            <div id="aboutText">
                <h1 class="about-photo-text-paragraph-header">ABOUT RISING SUN</h1>

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
    <div class="about-shelter-meet-team-container">
        <div class="about-shelter-meet-team-member-text-container-left">
            <h3>MEET JOHN - SHELTER MANAGER</h3>
            <div class="about-shelter-meet-team-member-text-container">
                <p>
                    John emerged from the dark heart of the forest to volunteer at Rising Sun. He has logged considerable time in our Kitten Pen, and from there plots world domination by crushing any who would oppose him. He spends his off days creating CSS code professionally, and Java unprofessionally.
                </p>
            </div>
        </div>
        <div class="about-shelter-meet-team-member-photo-container-right">
            <img id="john-headshot" src="@/images/johnheadshot.png" alt="member photo" />
        </div>
        <div class="about-shelter-meet-team-member-photo-container-left">
            <img id="jarrod-headshot" src="@/images/jarrodheadshot.png" alt="member photo" />
        </div>
        <div class="about-shelter-meet-team-member-text-container-right">
            <h3>MEET JARROD - VOLUNTEER</h3>
            <div class="about-shelter-meet-team-member-text-container">
                <p>
                    They are a passionate animal shelter volunteer dedicated to making a difference, promoting animal welfare, and providing lov and care to furry friends. They happen to be an incredible, absolutely gifted Software Developer in their spare time. As the proud owner of a lovable German Shepherd companion, their commitment to ensuring the well-being and happiness of animals in need is fueled by a heart full of compassion. From diligently walking shelter dogs to organizing adoption events, their goal is to establish a nurturing environment where every pet feels safe and cherished.
                </p>
                <p>
                    Their German Shepherd has taught them invaluable lessons about loyalty and unconditional love, serving as an inspiration to extend kindness to other animals in need. Together, they tirelessly work to advocate for animal rights and raise awareness about responsible pet ownership. Join them on this meaningful journey and together, let's make a lasting difference, one wagging tail at a time.
                </p>
            </div>
        </div>
        <div class="about-shelter-meet-team-member-text-container-left">
            <h3>MEET ADAM - VOLUNTEER</h3>
            <div class="about-shelter-meet-team-member-text-container">
                <p>
                    Intrepid animal shelter volunteer who embarks on unforgettable journeys throughout the Amazon, accompanied by his beloved pet panda, Paul. Driven by a deep love for animals and a thirst for exploration, I find solace in the enchanting rainforests of the Amazon while advocating for the welfare of its diverse wildlife.
                </p>
                <p>
                    Together with Paul, we venture into remote areas, lending a helping hand to local animal shelters and fostering a greater understanding of the unique challenges faced by the region's inhabitants. Through our travels, we aim to promote conservation efforts and shed light on the incredible beauty and fragility of this precious ecosystem. Join us as we navigate the lush jungles, protect endangered species, and make a lasting impact on the lives of Amazonian animals.
                </p>
            </div>
        </div>
        <div class="about-shelter-meet-team-member-photo-container-right">
            <img id="adam-headshot" src="@/images/adamheadshot.jpg" alt="member photo" />
        </div>
        <div class="about-shelter-meet-team-member-photo-container-left">
            <img id="riley-headshot" src="@/images/rileyheadshot.jpg" alt="member photo" />
        </div>
        <div class="about-shelter-meet-team-member-text-container-right">
            <h3>MEET RILEY - VOLUNTEER</h3>
            <div class="about-shelter-meet-team-member-text-container">
                <p>
                    They are a resilient animal shelter volunteer who defied the odds after surviving a skydiving accident, finding solace and purpose in caring for shelter animals. In their free time, they selflessly devote themselves to looking after their beloved grandma, providing her with unwavering love and support. Inspired by their own journey of resilience, they channel their passion for animals into creating a positive impact at the shelter.
                </p>
                <p>
                    Whether it's feeding, exercising, or simply showering them with affection, they are committed to ensuring the well-being and happiness of every furry friend they encounter. Through their experiences, they have come to appreciate the healing power of animals and the importance of compassionate care. Join them in this meaningful endeavor as together, we give these innocent creatures a second chance at a joyful life.
                </p>
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

.about-shelter-container {
    display: grid;
    grid-template-columns: 1fr;
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
    font-size: 15px;
    width: 100%;
    text-align: left;
}

.about-shelter-meet-team-container {
    display: grid;
    grid-template-columns: 1fr 1fr;
    margin-bottom: 2%;
}

.about-shelter-meet-team-member-photo-container-left img {
    width: 30vw;
    margin-left: -8%;
    border-radius: 50%;
}

.about-shelter-meet-team-member-photo-container-right img {
    width: 30vw;
    margin-right: -8%; 
    border-radius: 50%;
    margin-bottom: 3%;
}

.about-shelter-meet-team-member-text-container-left {
    text-align: center;
    padding-top: 4%;
    margin-left: 15%;
}

.about-shelter-meet-team-member-text-container-left h3{
    text-align: left;
}

.about-shelter-meet-team-member-text-container-right {
    text-align: center;
    padding-top: 3%;
    margin-right: 15%;
    margin-bottom: 5%;
}

.about-shelter-meet-team-member-text-container-right h3 {
    text-align: left;

}

.about-shelter-meet-team-member-text-container {
    display: inline-block;
}

.about-shelter-meet-team-member-text-container p {
    text-align: left;
}

#john-headshot {
    height: 25vh;
}

#riley-headshot {
    height: 30vh;
}

</style>