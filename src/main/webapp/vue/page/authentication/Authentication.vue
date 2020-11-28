<template>
	<form action="j_security_check" method="post" class="mx-auto">
		<div class="d-inline-block">
			<label>Gebruikersnaam</label>
			<!-- Must be a JSF inputText element -->
			<div v-pre>
				<h:inputText id="j_username" class="form-control" />
			</div>
		</div>

		<br />
		<br />

		<div class="d-inline-block">
			<label>Wachtwoord</label>
			<!-- Must be a JSF inputSecret element -->
			<div v-pre>
				<h:inputSecret id="j_password" class="form-control" />
			</div>
		</div>

		<br />
		<br />

		<span class="spanBorderSlideIn">
			<button type="submit" class="buttonBorderSlideIn">Verzenden</button>
		</span>
	</form>
</template>

<script>
import { translate } from "@/component/common/LanguageLogic.js";

export default {
	data() {
		return {
			subscribeButtonLabel: null
		};
	},
	beforeCreate() {
		translate("label.events.button.subscribe").then(
			t => (this.subscribeButtonLabel = t.data)
		);
	}
};
</script>