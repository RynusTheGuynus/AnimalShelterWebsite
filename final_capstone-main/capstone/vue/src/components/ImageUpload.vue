<template>
  <span>
      <button v-on:click.prevent="upload">Upload Image</button>
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
      },
      returnImageUrl(result) {
          this.$emit('image-uploaded', result.info.url);
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
          this.returnImageUrl(result);
        }
      }
    );

  }
}
</script>

<style scoped>

</style>