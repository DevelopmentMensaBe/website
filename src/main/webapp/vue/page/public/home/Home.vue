<template>
  <main>
    <img alt="Vue logo" src="@/asset/logo.png" />
    <h2>{{message}}</h2>
  </main>
</template>

<script>
import { translate } from "@/component/common/LanguageLogic.js";

export default {
  data() {
    return {
      message: null
    };
  },
  beforeCreate() {
    translate("content.welcome.message").then(t => (this.message = t.data));
  }
};
</script>