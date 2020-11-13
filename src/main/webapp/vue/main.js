import { createApp } from 'vue'
import App from './App.vue';

import InputText from 'primevue/inputtext';
import Button from 'primevue/button';
import Toast from 'primevue/toast';
import ToastService from 'primevue/toastservice';

import 'primevue/resources/primevue.min.css';
import 'primeicons/primeicons.css';

const app = createApp(App);

app.use(ToastService);

app.component('InputText', InputText);
app.component('Button', Button);
app.component('Toast', Toast);

app.mount('#app')