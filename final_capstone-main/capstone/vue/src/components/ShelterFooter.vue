<template>
  <div id="wholeFooter">
    <div id="shelter-location-info">
      <div id="shelter-location-info-items">
        <img src="@/images/shelterlogo.png" alt="shelter logo" />
        <p>123 Front St.<br>Cleveland, OH 44101</p>
        <i class="fa fa-phone"></i>    <span>216-252-7700</span><br>
        <i class="fa fa-envelope"></i>    <a href="mailto:rsanimalshelter@gmail.com">Email Us</a><br>
      </div>
    </div>
    <div id="shelter-hours-info">
      <div id="shelter-hours-info-items">
        <h3>Hours of Operation</h3>
        <table id="hours-table">
          <tbody>
            <tr>
              <td class="day">Sunday</td>
              <td class="hours">Closed</td>
            </tr>
            <tr>
              <td class="day">Monday</td>
              <td class="hours">Closed</td>
            </tr>
            <tr>
              <td class="day">Tuesday</td>
              <td class="hours">11 AM - 7 PM EST</td>
            </tr>
            <tr>
              <td class="day">Wednesday</td>
              <td class="hours">11 AM - 7 PM EST</td>
            </tr>
            <tr>
              <td class="day">Thursday</td>
              <td class="hours">11 AM - 7 PM EST</td>
            </tr>
            <tr>
              <td class="day">Friday</td>
              <td class="hours">11 AM - 7 PM EST</td>
            </tr>
            <tr>
              <td class="day">Saturday</td>
              <td class="hours">11 AM - 4 PM EST</td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div class="social-container">
      <span id="social">
        <a href="http://www.facebook.com"><img src="../images/fbicon.png" alt="Facebook"></a>
        <a href="http://www.instagram.com"><img src="../images/igicon.png" alt="Instagram"></a>
        <a href="http://www.twitter.com"><img src="../images/twicon.png" alt="Twitter"></a>
      </span>
    </div>
  </div>
</template>

<style scoped>

div {
  color: antiquewhite;
}

#wholeFooter {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  background-color: #3a4143;
  border: 3px solid #a36c2c;
  justify-content: center;
  bottom: 0; 
}

#shelter-location-info {
  width: 450px;
  height: 100%;
  text-align: center;
  color: antiquewhite;
  margin-top: 1%;
}

#shelter-location-info-items {
  display: inline-block;
  text-align: left;
}

#shelter-location-info img {
  width: auto;
  height: auto;
}

#shelter-location-info a:link {
  color: antiquewhite;
}

#shelter-hours-info {
  display: flex;
  justify-content: center;
  align-items: center;
}

#shelter-hours-info-items h3 {
  /* text-decoration: underline; */
  text-align: center;
  margin-bottom: 10px;
}

.social-container {
  margin-top: 2%;
  display: flex;
  justify-content: center;
}

#social {
  display: flex;
  text-align: center;
}

img {
  margin-right: 10px;
  max-height: 4vh;
}

#hours-table {
  width: 100%;
  border-spacing: 10px;
}

.day {
  text-align: left;
  padding-right: 10px;
}

.hours {
  text-align: right;
  padding-left: 10px;
}

</style>
