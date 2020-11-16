<template>
  <div id="content">
    <navigation />
    <section class="container-fluid text-center fadeInAndSlideInFromBottom">
      <h1>
        Welkom bij
        <em>
          <span class="text-secondary">Mensa</span>
        </em>
      </h1>
      <img alt="Vue logo" src="@/asset/logo.png" />
      <h2>{{message}}</h2>
    </section>
  </div>
</template>

<script>
import Navigation from "@/component/Navigation";

export default {
  data() {
    return {
      message: "Welkom bezoeker op deze nieuwe versie met Vue"
    };
  },
  created: function() {
    document.title = "Welkom bij Mensa";
  },
  components: {
    navigation: Navigation
  }
};
</script>

<style>
</style>