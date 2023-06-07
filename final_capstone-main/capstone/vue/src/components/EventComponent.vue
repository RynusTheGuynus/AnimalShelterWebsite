<template>
  <div id="events">
    <h3 id="eventHeader">Upcoming Events!</h3>
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
  height: 35vh;
  border: 3px solid #a36c2c;
  border-radius: 25px;
  margin-top: 20px;
}

h3 {
  display: flex;
  flex-direction: column;
  justify-content: center;
}

#eventList {
  display: flex;
  flex-direction: column;
  justify-content: left;
  margin-left: 20px;
  margin-right: 20px;
  padding-left: 10px;
  overflow: auto;
}


</style>