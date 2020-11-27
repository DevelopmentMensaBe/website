<template>
	<main>
		<img alt="Vue logo" src="@/asset/logo.png" />
		<img alt="PrimeVue logo" src="@/asset/primevue-logo.png" />
		<h2 v-html="message"></h2>
	</main>
</template>

<script>
import axios from "axios";

export default {
	data() {
		return {
			message: null
		};
	},
	created() {
		axios.get("user/message").then(resp => (this.message = resp.data));
	}
};
</script>