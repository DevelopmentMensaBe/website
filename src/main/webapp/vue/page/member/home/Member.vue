<template>
  <div id="content">
    <navigation />
    <section class="container-fluid text-center fadeInAndSlideInFromBottom">
      <h1>Welkom bij het ledengedeelte</h1>
      <img alt="Vue logo" src="@/asset/logo.png" />
      <h2>{{message}}</h2>
    </section>
  </div>
</template>

<script>
import Navigation from "@/component/Navigation";
import axios from "axios";

export default {
  data() {
    return {
      message: null
    };
  },
  created() {
    axios.get(process.env.VUE_APP_HOST_REST + `session/logIn`);
    axios
      .get(process.env.VUE_APP_HOST_REST + `users/message`)
      .then(resp => (this.message = resp.data));
  },
  components: {
    navigation: Navigation
  }
};
</script>

<style>
</style>