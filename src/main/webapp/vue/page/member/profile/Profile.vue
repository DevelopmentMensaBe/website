<template>
	<main>
		<form class="p-fluid p-formgrid p-grid mx-auto" @submit.prevent="save">
			<div class="p-field p-col-12">
				<label for="mensaId">{{label.mensaId}}:&nbsp;</label>
				<label id="mensaId">{{user.mensaId}}</label>
			</div>
			<div class="p-field p-col-12">
				<label for="role">{{label.role}}:&nbsp;</label>
				<label id="role">{{user.role}}</label>
			</div>
			<div class="p-field p-col-12">
				<label for="language">{{label.language}}:&nbsp;</label>
				<label id="language">{{user.language}}</label>
			</div>
			<div class="p-field p-col-12 p-md-6">
				<label>{{label.firstName}}</label>
				<inputText v-model="user.person.firstName" />
			</div>
			<div class="p-field p-col-12 p-md-6">
				<label>{{label.lastName}}</label>
				<inputText v-model="user.person.lastName" />
			</div>
			<!-- <div class="p-field p-col-12">
				<label>{{label.birthDate}}</label>
				<calendar
					v-model="user.person.birthDate"
					dateFormat="dd/mm/yy"
					:monthNavigator="true"
					:yearNavigator="true"
					yearRange="1900:2000"
				/>
			</div>-->
			<div class="p-field p-col-12">
				<label>{{label.street}}</label>
				<inputText id="street" type="text" v-model="user.person.contact.address.street" />
			</div>
			<div class="p-field p-col-12 p-md-3">
				<label for="number">{{label.number}}</label>
				<inputText id="number" type="text" v-model="user.person.contact.address.number" />
			</div>
			<div class="p-field p-col-12 p-md-3">
				<label for="zip">{{label.zip}}</label>
				<inputText id="zip" type="text" v-model="user.person.contact.address.zipCode" />
			</div>
			<div class="p-field p-col-12 p-md-6">
				<label for="city">{{label.city}}</label>
				<inputText id="city" type="text" v-model="user.person.contact.address.city" />
			</div>
			<div class="p-field p-col-12">
				<span class="spanBorderSlideIn">
					<button type="submit" class="buttonBorderSlideIn">{{label.save}}</button>
				</span>
			</div>
		</form>
		<toast />
	</main>
</template>

<script>
import axios from "axios";
import { translate } from "@/component/common/LanguageLogic.js";

import inputText from "primevue/inputtext";
// import calendar from "primevue/calendar";

export default {
	data() {
		return {
			label: {
				mensaId: null,
				role: null,
				language: null,
				firstName: null,
				lastName: null,
				birthDate: null,
				street: null,
				number: null,
				zip: null,
				city: null,
				save: null
			},
			user: {
				person: { contact: { address: {} } }
			}
		};
	},
	components: {
		inputText
		// calendar
	},
	created() {
		axios.get("user/loggedInUser").then(resp => (this.user = resp.data));

		const label = "label.page.profile.form.";

		translate(label + "mensaId").then(t => (this.label.mensaId = t.data));
		translate(label + "role").then(t => (this.label.role = t.data));
		translate(label + "language").then(t => (this.label.language = t.data));
		translate(label + "firstName").then(
			t => (this.label.firstName = t.data)
		);
		translate(label + "lastName").then(t => (this.label.lastName = t.data));
		translate(label + "birthDate").then(
			t => (this.label.birthDate = t.data)
		);
		translate(label + "street").then(t => (this.label.street = t.data));
		translate(label + "number").then(t => (this.label.number = t.data));
		translate(label + "zip").then(t => (this.label.zip = t.data));
		translate(label + "city").then(t => (this.label.city = t.data));

		translate("label.common.action." + "save").then(
			t => (this.label.save = t.data)
		);
	},
	methods: {
		save() {
			try {
				if (this.user.person.birthDate) {
					var temp = JSON.stringify(this.user.person.birthDate);

					if (temp.includes("-")) {
						const day = temp.substring(9, 11);
						const month = temp.substring(6, 8);
						const year = temp.substring(1, 5);
						this.user.person.birthDate =
							day + "/" + month + "/" + year;
					}
				} else {
					this.$toast.add({
						severity: "error",
						summary: "AI :(",
						detail: "Choose a birth date in the form of dd/mm/yyyy",
						life: 3000
					});
					return;
				}

				axios
					.post("user/save", this.user)
					.then(response => {
						this.user = response.data;
						this.$toast.add({
							severity: "success",
							summary: "OK :)",
							detail: "",
							life: 3000
						});
					})
					.catch(error => {
						this.$toast.add({
							severity: "error",
							summary: "AI :(",
							detail: "API: " + error.response,
							life: 3000
						});
					});
			} catch (error) {
				this.$toast.add({
					severity: "error",
					summary: "AI :(",
					detail: "SAVE: " + error.message,
					life: 3000
				});
			}
		}
	}
};
</script>