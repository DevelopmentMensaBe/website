<template>
	<nav class="navbar navbar-expand-lg fixed-top navbar-dark">
		<a class="navbar-brand" href="/">
			<img src="/design/layout/image/logo/mensa-logo.png" width="50" height="50" />
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
					<a class="nav-link topBottomSlideIn" href="/">{{label.home}}</a>
				</li>

				<li class="nav-item mx-auto">
					<a class="nav-link topBottomSlideIn" href="/test">{{label.test}}</a>
				</li>

				<li class="nav-item mx-auto">
					<a class="nav-link topBottomSlideIn" href="/member/events">{{label.events}}</a>
				</li>
			</ul>

			<ul class="navbar-nav ml-auto">
				<li class="nav-item mx-auto">
					<a href @click="changeLanguage('english')" class="nav-link roundLinkIcon">
						<img src="/design/layout/image/icon/English.png" width="25" height="25" />
					</a>
					<a href @click="changeLanguage('english')" class="nav-link topBottomSlideIn">{{label.english}}</a>
				</li>

				<li class="nav-item mx-auto">
					<a href @click="changeLanguage('dutch')" class="nav-link roundLinkIcon">
						<img src="/design/layout/image/icon/Dutch.png" width="25" height="25" />
					</a>
					<a href @click="changeLanguage('dutch')" class="nav-link topBottomSlideIn">{{label.dutch}}</a>
				</li>

				<li class="nav-item mx-auto">
					<a href @click="changeLanguage('french')" class="nav-link roundLinkIcon">
						<img src="/design/layout/image/icon/French.png" width="25" height="25" />
					</a>
					<a href @click="changeLanguage('french')" class="nav-link topBottomSlideIn">{{label.french}}</a>
				</li>

				<li class="nav-item mx-auto">
					<a href @click="changeLanguage('german')" class="nav-link roundLinkIcon">
						<img src="/design/layout/image/icon/German.png" width="25" height="25" />
					</a>
					<a href @click="changeLanguage('german')" class="nav-link topBottomSlideIn">{{label.german}}</a>
				</li>

				<li class="nav-item mx-auto" v-if="!loggedIn">
					<a href="member" class="nav-link roundLinkIcon">
						<img src="/design/layout/image/icon/login.png" width="25" height="25" />
					</a>
					<a href="member" class="nav-link topBottomSlideIn">{{label.login}}</a>
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
					>{{label.profile}}</a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdown navbarDropdownIcon">
						<a href="/member/profile" class="dropdown-item topBottomSlideIn">{{label.edit}}</a>
						<div class="dropdown-divider"></div>
						<a href="/logout" class="dropdown-item topBottomSlideIn">{{label.logout}}</a>
					</div>
				</li>
			</ul>
		</div>
	</nav>
</template>

<script>
import axios from "axios";
import { translate, updateLanguage } from "@/component/common/LanguageLogic.js";

export default {
	data() {
		return {
			loggedIn: false,
			label: {
				home: null,
				test: null,
				events: null,
				profile: null,
				english: null,
				dutch: null,
				french: null,
				german: null,
				login: null,
				edit: null,
				logout: null
			}
		};
	},
	created() {
		// Navigation page
		translate("label.common.navigation.page.home").then(
			t => (this.label.home = t.data)
		);
		translate("label.common.navigation.page.test").then(
			t => (this.label.test = t.data)
		);
		translate("label.common.navigation.page.events").then(
			t => (this.label.events = t.data)
		);
		translate("label.common.navigation.page.profile").then(
			t => (this.label.profile = t.data)
		);

		// Navigation language
		translate("label.common.navigation.language.english").then(
			t => (this.label.english = t.data)
		);
		translate("label.common.navigation.language.dutch").then(
			t => (this.label.dutch = t.data)
		);
		translate("label.common.navigation.language.french").then(
			t => (this.label.french = t.data)
		);
		translate("label.common.navigation.language.german").then(
			t => (this.label.german = t.data)
		);

		// Navigation profile
		translate("label.common.navigation.profile.login").then(
			t => (this.label.login = t.data)
		);
		translate("label.common.navigation.profile.edit").then(
			t => (this.label.edit = t.data)
		);
		translate("label.common.navigation.profile.logout").then(
			t => (this.label.logout = t.data)
		);

		axios
			.get(process.env.VUE_APP_HOST_REST + "session/checkLoggedIn")
			.then(response => {
				this.loggedIn = response.data;
			});
	},
	methods: {
		changeLanguage(language) {
			updateLanguage(language);
		}
	}
};
</script>