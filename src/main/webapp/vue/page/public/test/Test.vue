<template>
  <div id="content">
    <navigation />
    <section class="container-fluid text-center fadeInAndSlideInFromBottom">
      <h1>IQ Testen</h1>
      <img alt="Vue logo" src="@/asset/logo.png" />
      <h2>{{message}}</h2>
    </section>
    <section class="w-50 mx-auto text-center fadeInAndSlideInFromBottom">
      <img src="/design/layout/image/coming-soon.png" />
    </section>
  </div>
</template>

<script>
import Navigation from "../../../component/Navigation";

export default {
  data() {
    return {
      message: "Welkom bezoeker op deze nieuwe versie met Vue"
    };
  },
  components: {
    navigation: Navigation
  }
};
</script>

<style>
</style>