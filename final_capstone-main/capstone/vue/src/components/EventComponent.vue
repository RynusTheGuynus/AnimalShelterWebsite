<template>
  <div id="events">
    <h3 id="eventHeader">UPCOMING EVENTS</h3>
    <ul id="eventList">
     <p>Friday, June 9th, 2023: Graduation ceremony for Tech Elevator's NLR-13 Cohort!</p>
     <p>Sunday, June 11th, 2023: Shelter closed to the general public.</p>
     <p>Monday, June 12th, 2023: Shelter closed to the general public.</p>
     <p>Wednesday, June 14th, 2023: Shelter employees will bring their pets to work.</p>
    </ul>
  </div>
</template>

<script>
export default {
  name: "events"
  }

</script>

<style scoped>

#events {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 90%;
  border: 3px solid #a36c2c;
  border-radius: 25px;
  margin-top: 20px;
}

h3 {
  display: flex;
  flex-direction: column;
  justify-content: center;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  font-size: 32px;
  color: #EEE6DB;
  text-align: center;
  font-weight: bold;
}

#eventList {
  display: flex;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  font-size: 16px;
  color: #EEE6DB;
  text-align: center;
  font-weight: bold;
  flex-direction: column;
  justify-content: left;
  margin-left: 20px;
  margin-right: 20px;
  padding-left: 10px;
  text-align: left;
}


</style>