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
          <a href="#" class="nav-link roundLinkIcon">
            <img src="/design/layout/image/icon/Dutch.png" width="25" height="25" />
          </a>
          <a href="#" class="nav-link topBottomSlideIn">Nederlands</a>
        </li>

        <li class="nav-item mx-auto">
          <a href="#" class="nav-link roundLinkIcon">
            <img src="/design/layout/image/icon/French.png" width="25" height="25" />
          </a>
          <a href="#" class="nav-link topBottomSlideIn">Français</a>
        </li>

        <li class="nav-item mx-auto">
          <a href="#" class="nav-link roundLinkIcon">
            <img src="/design/layout/image/icon/English.png" width="25" height="25" />
          </a>
          <a href="#" class="nav-link topBottomSlideIn">English</a>
        </li>
        <li class="nav-item mx-auto" v-if="!loggedIn">
          <a href="member" class="nav-link roundLinkIcon">
            <img src="/design/layout/image/icon/login.png" width="25" height="25" />
          </a>
          <a href="member" class="nav-link topBottomSlideIn">Aanmelden</a>
        </li>

        <li class="nav-item dropdown" v-if="loggedIn">
          <a
            id="navbarDropdownIcon"
            href="#"
            class="nav-link roundLinkIcon"
            role="button"
            data-toggle="dropdown"
            aria-haspopup="true"
            aria-expanded="false"
          >
            <img src="/design/layout/image/icon/login.png" width="25" height="25" />
          </a>
          <a
            id="navbarDropdown"
            href="#"
            class="nav-link topBottomSlideIn"
            role="button"
            data-toggle="dropdown"
            aria-haspopup="true"
            aria-expanded="false"
          >Mijn Profiel</a>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown navbarDropdownIcon">
            <a href="#" class="dropdown-item topBottomSlideIn">Aanpassen</a>
            <div class="dropdown-divider"></div>
            <a href="/logout" class="dropdown-item topBottomSlideIn">Afmelden</a>
          </div>
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
      });
  }
};
</script>