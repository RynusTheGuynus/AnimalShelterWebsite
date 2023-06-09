<template>
  <div class="update-container">
      <shelter-header />
      <navigation-bar id='navigationBar' />
      <div class="add-update-container">
        <add-pet v-if="isAdd" />
        <update-pet v-if="isUpdate" />
        <div class="button-container">
          <input
          type="button"
          id="add-pet-button"
          class="button"
          value="Add Pet"
          @click="addPetToggle" 
          v-if="!isAdd"  
          />
          <input
          type="button"
          id="update-pet-button"
          class="button"
          value="Update Pet" 
          @click="updatePetToggle"  
          v-if="!isUpdate"
          />
        </div>
      </div>
      <shelter-footer id="footer" />
  </div>
</template>

<script>
import ShelterHeader from '../components/ShelterHeader.vue'
import ShelterFooter from '../components/ShelterFooter.vue'
import AddPet from '../components/AddPet.vue'
import UpdatePet from '../components/UpdatePet.vue'
import NavigationBar from '../components/NavigationBar.vue'

export default {
  name: 'update',
  components: { 
    ShelterHeader,
    ShelterFooter,
    AddPet,
    UpdatePet,
    NavigationBar
    },
  data() {
    return {
      isAdd: false,
      isUpdate: false
    }
  },
  methods: {
    addPetToggle() {
      if(this.isUpdate == false) {
        this.isAdd = !this.isAdd;
      } else if (this.isUpdate == true) {
        this.isUpdate = false;
        this.isAdd = true;
      }
    },
    updatePetToggle() {
      if(this.isAdd == false) {
        this.isUpdate = !this.isUpdate;
      } else if (this.isAdd == true) {
        this.isAdd = false;
        this.isUpdate = true;
      }
    }
  }

}
</script>
    
<style>

.button-container {
  text-align: center;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  margin-top: 20px;
}

.button {
  cursor: pointer;
}

#add-pet-button {
  font-size: 20px;
  text-align: center;
  margin: 50px;
  border-radius: 5px;
  padding: 20px 50px;
}

#update-pet-button {
  font-size: 20px;
  text-align: center;
  margin: 50px;
  border-radius: 5px;
  padding: 20px 38px;
}

#footer {
  background-color: #3a4143;
  color: antiquewhite;
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
}

</style>