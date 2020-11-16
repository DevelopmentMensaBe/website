<template>
  <nav class="navbar navbar-expand-sm sticky-top navbar-dark fadeInAndSlideInFromTop">
    <a class="navbar-brand" href>
      <img src="/design/layout/image/logo/mensa-logo.png" width="30" height="30" />
    </a>

    <button
      class="navbar-toggler"
      type="button"
      data-toggle="collapse"
      data-target="#collapsibleNavbar"
      id="test"
    >
      <div class="navbar-toggler-icon-animated">
        <span></span>
        <span></span>
        <span></span>
      </div>
    </button>

    <div class="navbar-collapse collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
        <li class="nav-item mx-auto">
          <a class="nav-link topBottomSlideIn" href="/">Welkom</a>
        </li>

        <li class="nav-item mx-auto">
          <a class="nav-link topBottomSlideIn" href="/test">IQ Test</a>
        </li>

        <li class="nav-item mx-auto">
          <a class="nav-link topBottomSlideIn" href="/member/events">Activiteiten</a>
        </li>
      </ul>

      <ul class="navbar-nav ml-auto">
        <li class="nav-item mx-auto">
          <a href="#" class="nav-link round-link-icon">
            <img src="/design/layout/image/icon/Dutch.png" width="25" height="25" />
          </a>
          <a href="#" class="nav-link topBottomSlideIn">Nederlands</a>
        </li>

        <li class="nav-item mx-auto">
          <a href="#" class="nav-link round-link-icon">
            <img src="/design/layout/image/icon/French.png" width="25" height="25" />
          </a>
          <a href="#" class="nav-link topBottomSlideIn">Français</a>
        </li>

        <li class="nav-item mx-auto">
          <a href="#" class="nav-link round-link-icon">
            <img src="/design/layout/image/icon/English.png" width="25" height="25" />
          </a>
          <a href="#" class="nav-link topBottomSlideIn">English</a>
        </li>

        <li class="nav-item mx-auto">
          <a href="member" class="nav-link round-link-icon">
            <img src="/design/layout/image/icon/login.png" width="25" height="25" />
          </a>
          <a href="member" :hidden="loggedIn" class="nav-link topBottomSlideIn">Aanmelden</a>
          <a href="/logout" :hidden="!loggedIn" class="nav-link topBottomSlideIn">Afmelden</a>
        </li>
      </ul>
    </div>
  </nav>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      loggedIn: false
    };
  },
  created() {
    axios
      .get(process.env.VUE_APP_HOST_REST + `session/checkLoggedIn`)
      .then(response => {
        this.loggedIn = response.data;
        console.log("nav created: " + response.data);
      });
  }
};
</script>