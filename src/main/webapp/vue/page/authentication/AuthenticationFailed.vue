<template>
	<main class="w-50 mx-auto">
		<p>{{failedMessage}}</p>
		<span class="spanBorderSlideIn">
			<button onclick="window.history.back()" class="buttonBorderSlideIn">{{retryButtonLabel}}</button>
		</span>
	</main>
</template>

<script>
import { translate } from "@/component/common/LanguageLogic.js";

export default {
	data() {
		return {
			failedMessage: null,
			retryButtonLabel: null
		};
	},
	beforeCreate() {
		translate("label.page.authentication.form.failed").then(
			t => (this.failedMessage = t.data)
		);
		translate("label.page.authentication.form.again").then(
			t => (this.retryButtonLabel = t.data)
		);
	}
};
</script>