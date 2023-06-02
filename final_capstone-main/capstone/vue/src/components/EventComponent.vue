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

<style>
#events {
  display: flex;
  flex-direction: column;
  border: 3px solid #a36c2c;
  height: 60vh;
  width: 45vw;
  align-items: right;
}

#eventHeader {
  align-items: flex-start;
  justify-content: flex-start;
}

#eventList {
  grid-area: list;
  justify-content: left;
  margin-left: 10px;
}

</style>