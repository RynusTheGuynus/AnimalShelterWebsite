<template>
  <span>
      <button v-on:click="upload">Upload Image</button>
  </span>
</template>

<script>
export default {
  name: 'ImageUpload',
  data() {
    return {
      myWidget : {}
    }
  },
  methods: {
      upload() {
        this.myWidget.open();
      }
  },
  mounted() {
       this.myWidget = window.cloudinary.createUploadWidget(
      {
        cloudName: 'doliuuvrv', 
        uploadPreset: 'cki5dnhj'
      }, 
      (error, result) => { 
        if (!error && result && result.event === "success") { 
          console.log('Done! Here is the image info: ', result.info); 
          console.log("Image URL: " + result.info.url);
        }
      }
    );

  }
}
</script>

<style scoped>

</style>