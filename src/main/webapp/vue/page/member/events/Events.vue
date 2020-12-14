<template>
	<main>
		<div>
			<!-- <label class="mr-2">Filter:</label>
			<dropdown v-model="value" :options="filter" optionLabel="name" placeholder="Select" />-->
			<br />
			<br />
			<FullCalendar :events="events" :options="options" />
			<span class="spanBorderSlideIn">
				<button class="buttonBorderSlideIn">{{subscribeButtonLabel}}</button>
			</span>
		</div>

		<!-- <GoogleMap
			api-key="AIzaSyDPAh7dWpMwzetzN4-DqyzOH9Qt48zoJ7U"
			style="width: 100%; height: 50rem"
			:center="center"
			:zoom="8"
			:theme="grey"
		>
			<Marker :options="{ position: center }" />
		</GoogleMap>-->
	</main>
</template>

<script>
import { translate } from "@/component/common/LanguageLogic.js";

// import dropdown from "primevue/dropdown";

import FullCalendar from "primevue/fullcalendar";
import dayGridPlugin from "@fullcalendar/daygrid";
import timeGridPlugin from "@fullcalendar/timegrid";
import interactionPlugin from "@fullcalendar/interaction";

// import { GoogleMap, Marker } from "vue3-google-map";

export default {
	data() {
		return {
			subscribeButtonLabel: null,
			value: null,
			options: {
				plugins: [dayGridPlugin, timeGridPlugin, interactionPlugin],
				initialDate: new Date(),
				headerToolbar: {
					left: "prevYear,prev,today,next,nextYear",
					center: "title",
					right: "dayGridMonth,timeGridWeek,timeGridDay"
				},
				buttonText: {
					// today: "Vandaag"
				},
				editable: true,
				weekNumbers: true,
				locale: "en",
				firstDay: 1
				// timeZone: "Europe/Brussels",
				// eventDidMount: function(info) {
				// 	var tooltip = new Tooltip(info.el, {
				// 		title: info.event.extendedProps.description,
				// 		placement: "top",
				// 		trigger: "hover",
				// 		container: "body"
				// 	});
				// }
			},
			events: [
				{
					id: 1,
					title: "SIG",
					start: "2020-12-01"
				},
				{
					id: 2,
					title: "Mensa Weekend",
					start: "2020-12-19",
					end: "2020-12-21"
				},
				{
					id: 3,
					title: "Wandeling",
					start: "2020-12-09T16:00:00"
				},
				{
					id: 4,
					title: "Maandelijkse borrel",
					start: "2020-12-18T20:00:00"
				},
				{
					id: 6,
					title: "Board meeting",
					start: "2020-12-12T10:30:00",
					end: "2020-12-12T12:30:00"
				}
			],
			filter: [
				{ name: "All", code: "NY" },
				{ name: "Borrel", code: "NY" },
				{ name: "Wandeling", code: "RM" },
				{ name: "SIG", code: "LDN" },
				{ name: "Algemene Vergadering", code: "IST" },
				{ name: "Boardmeeting", code: "PRS" }
			],
			center: { lat: 50.85, lng: 4.35 }
		};
	},
	beforeCreate() {
		translate("label.events.button.subscribe").then(
			t => (this.subscribeButtonLabel = t.data)
		);
	},
	components: {
		// dropdown,
		FullCalendar
		// GoogleMap,
		// Marker
	}
};
</script>