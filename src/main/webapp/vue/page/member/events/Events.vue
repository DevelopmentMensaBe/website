<template>
	<main class="w-50 mx-auto">
		<div>
			<span class="spanBorderSlideIn">
				<button class="buttonBorderSlideIn">{{subscribeButtonLabel}}</button>
			</span>
		</div>
	</main>
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