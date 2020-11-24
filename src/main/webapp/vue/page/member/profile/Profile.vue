<template>
  <main>
    <form class="p-fluid p-formgrid p-grid mx-auto" @submit.prevent="save">
      <div class="p-field p-col-12">
        <label for="firstName">Member Id:&nbsp;</label>
        <label id="firstName">MBE_0001</label>
      </div>
      <div class="p-field p-col-12 p-md-6">
        <label>First Name</label>
        <inputText v-model="user.person.firstName" />
      </div>
      <div class="p-field p-col-12 p-md-6">
        <label>Last Name</label>
        <inputText v-model="user.person.lastName" />
      </div>
      <div class="p-field p-col-12">
        <label>Birth date</label>
        <calendar
          v-model="user.person.birthDate"
          dateFormat="dd/mm/yy"
          :monthNavigator="true"
          :yearNavigator="true"
          yearRange="1900:2000"
        />
      </div>
      <div class="p-field p-col-12">
        <label>Street</label>
        <inputText id="street" type="text" v-model="user.person.contact.address.street" />
      </div>
      <div class="p-field p-col-12 p-md-3">
        <label for="number">Number</label>
        <inputText id="number" type="text" v-model="user.person.contact.address.number" />
      </div>
      <div class="p-field p-col-12 p-md-3">
        <label for="zip">Zip</label>
        <inputText id="zip" type="text" v-model="user.person.contact.address.zipCode" />
      </div>
      <div class="p-field p-col-12 p-md-6">
        <label for="city">City</label>
        <inputText id="city" type="text" v-model="user.person.contact.address.city" />
      </div>
      <div class="p-field p-col-12">
        <span class="spanBorderSlideIn">
          <button type="submit" class="buttonBorderSlideIn">Save</button>
        </span>
      </div>
    </form>
  </main>
</template>

<script>
import axios from "axios";

import inputText from "primevue/inputtext";
import calendar from "primevue/calendar";

export default {
  data() {
    return {
      user: {
        person: { contact: { address: {} } }
      }
    };
  },
  components: {
    inputText,
    calendar
  },
  created() {
    axios
      .get(process.env.VUE_APP_HOST_REST + "users/loggedInUser")
      .then(resp => (this.user = resp.data));
  },
  methods: {
    save() {
      var temp = JSON.stringify(this.user.person.birthDate);

      if (temp.includes("-")) {
        const day = temp.substring(9, 11);
        const month = temp.substring(6, 8);
        const year = temp.substring(1, 5);
        this.user.person.birthDate = day + "/" + month + "/" + year;
      }

      axios
        .post(process.env.VUE_APP_HOST_REST + "users/save", this.user, {
          headers: {
            "Content-Type": "application/json"
          }
        })
        .then(response => (this.user = response.data));
    }
  }
};
</script>