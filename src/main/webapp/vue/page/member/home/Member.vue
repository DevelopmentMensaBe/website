<template>
  <main>
    <img alt="Vue logo" src="@/asset/logo.png" />

    <h2>{{message}}</h2>
  </main>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      message: null
    };
  },
  created() {
    axios
      .get(process.env.VUE_APP_HOST_REST + `users/message`)
      .then(resp => (this.message = resp.data));
  }
};
</script>