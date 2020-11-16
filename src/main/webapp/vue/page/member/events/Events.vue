<template>
  <div id="content">
    <navigation />
    <section class="container-fluid text-center fadeInAndSlideInFromBottom">
      <h1>Activiteiten</h1>
      <img alt="Vue logo" src="@/asset/logo.png" />
      <h2>{{message}}</h2>
    </section>
    <section class="w-50 mx-auto text-center fadeInAndSlideInFromBottom">
      <img src="/design/layout/image/coming-soon.png" />
    </section>
  </div>
</template>

<script>
import Navigation from "@/component/Navigation";
import axios from "axios";

export default {
  data() {
    return {
      message: "Welkom Mensa lid op deze nieuwe versie met Vue"
    };
  },
  created() {
    axios.get(process.env.VUE_APP_HOST_REST + `session/logIn`);
  },
  components: {
    navigation: Navigation
  }
};
</script>

<style>
</style>