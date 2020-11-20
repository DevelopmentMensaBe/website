<template>
  <main class="w-50 mx-auto text-center">
    <img alt="Vue logo" src="@/asset/logo.png" />
    <h2>{{message}}</h2>
    <img src="/design/layout/image/coming-soon.png" class="fadeInAndSlideInFromBottom" />
  </main>
</template>

<script>
export default {
  data() {
    return {
      message: "Welkom bezoeker op deze nieuwe versie met Vue"
    };
  }
};
</script>