<template>
	<header>
		<div id="particles-js" ref="particles"></div>
	</header>
</template>

<script>
export default {
	mounted() {
		let main = document.createElement("script");
		main.setAttribute("src", "/design/script/particles/particles.js");
		this.$refs.particles.appendChild(main);

		let app = document.createElement("script");
		app.setAttribute("src", "/design/script/particles/app.js");
		this.$refs.particles.appendChild(app);
	}
};
</script>

<style scoped>
header {
	background: #acacac;
	overflow: hidden;
}
</style>
