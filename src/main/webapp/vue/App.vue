<template>
  <div id="app">
    <div class="app-container">
      <img alt="Vue logo" src="@/assets/primevue-logo.png" />
      <HelloWorld msg="Welcome to Your PrimeVue App" />
      <form @submit.prevent="greet">
        <InputText type="text" v-model="text" />
        <Button type="submit" label="Submit" />
        <h3>{{message}}</h3>
      </form>
    </div>

    <Toast />
  </div>
</template>

<script>
import HelloWorld from "./components/HelloWorld.vue";
export default {
  data() {
    return {
      message: null,
      text: null,
      title: "testje"
    };
  },
  head: {
    // creates a title tag in header.
    title: {
      inner: "It will be a pleasure"
    },
    meta: [
      { name: "application-name", content: "Name of my application" },
      { name: "description", content: "A description of the page", id: "desc" }, // id to replace intead of create element
      // ...
      // Twitter
      { name: "twitter:title", content: "Content Title" },
      // with shorthand
      {
        n: "twitter:description",
        c: "Content description less than 200 characters"
      },
      // ...
      // Google+ / Schema.org
      { itemprop: "name", content: "Content Title" },
      { itemprop: "description", content: "Content Title" },
      // ...
      // Facebook / Open Graph
      { property: "fb:app_id", content: "123456789" },
      { property: "og:title", content: "Content Title" },
      // with shorthand
      { p: "og:image", c: "https://example.com/image.jpg" }
      // ...
    ],
    // link tags
    link: [
      {
        rel: "canonical",
        href: "http://example.com/#!/contact/",
        id: "canonical"
      }
    ],
    script: [
      {
        type: "text/javascript",
        src: "cdn/to/script.js",
        async: true,
        body: true
      }, // Insert in body
      // with shorthand
      { t: "application/ld+json", i: '{ "@context": "http://schema.org" }' }
      // ...
    ],
    style: [
      {
        type: "text/css",
        inner: "body { background-color: #000; color: #fff}",
        undo: false
      }
      // ...
    ]
  },
  methods: {
    greet() {
      this.$toast.add({ severity: "info", summary: "Hello " + this.text });
      this.message = "Hello " + this.text;
    }
  },
  components: {
    HelloWorld
  }
};
</script>

<style scoped>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}
.app-container {
  text-align: center;
}
body #app .p-button {
  margin-left: 0.2em;
}
form {
  margin-top: 2em;
}
</style>