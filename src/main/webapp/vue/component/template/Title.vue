<template>
  <h1 class="fadeInAndSlideInFromBottom" v-html="value"></h1>
</template>

<script>
export default {
  data() {
    return {
      value: null
    };
  },
  mounted() {
    this.value = this.title;
  }
};
</script>