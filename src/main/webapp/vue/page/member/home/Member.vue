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
import Navigation from "../../../component/Navigation";
import axios from "axios";

export default {
  data() {
    return {
      message: "Welkom Mensa lid op deze nieuwe versie met Vue"
    };
  },
  created() {
    axios.get(`http://localhost:8080/rest/session/logIn`);
  },
  components: {
    navigation: Navigation
  }
};
</script>

<style>
</style>