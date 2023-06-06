<template>
  <div id="events">
    <h3 id="eventHeader">Events</h3>
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
  border: 3px solid #a36c2c;
  height: 75vh;
  width: 30vw;
  align-items: center;
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
  margin-left: -10px;
  padding-right: 40px;
}

</style>