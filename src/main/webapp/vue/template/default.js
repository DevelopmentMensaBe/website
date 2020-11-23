/* Vue Core: front-end component development								-------------------------------------------------------------------------------- */
import { createApp, defineAsyncComponent } from 'vue'

// Axios Core: front-end to back-end communication							-------------------------------------------------------------------------------- */
import axios from "axios";

// PrimeVue Core: enhanced components with theming and icons				-------------------------------------------------------------------------------- */
import 'primevue/resources/primevue.min.css';

// PrimeVue Theme															-------------------------------------------------------------------------------- */
import 'primevue/resources/themes/luna-blue/theme.css';

// PrimeVue Icons															-------------------------------------------------------------------------------- */
import 'primeicons/primeicons.css';

// PrimeVue Utilities: alternative for bootstrap							-------------------------------------------------------------------------------- */
import 'primeflex/primeflex.css';

// Application Core: layout components										-------------------------------------------------------------------------------- */
import Header from '@/component/template/Header.vue'
import Navigation from '@/component/template/Navigation.vue'
import Title from '@/component/template/Title.vue'
import Footer from '@/component/template/Footer.vue'

// Application Core: constants												-------------------------------------------------------------------------------- */
export const TitleOptions = {
	DEFAULT: "Mensa Belgium",
	PAGE: "Mensa - "
};

// Application Core: build layout											-------------------------------------------------------------------------------- */
export function load(content, documentTitle, title, member) {

	// set the document title for the browser tab name, we don't do it in the header. 
	// this is different then the title on the page itself (heading or h1 - see further)
	document.title = documentTitle ? TitleOptions.PAGE + documentTitle : TitleOptions.DEFAULT;

	// check if we are in a member page to set the logged in flag
	if (member) {

		axios.get(process.env.VUE_APP_HOST_REST + `session/logIn`);
	}

	// start building the page, with the header, navigation, title, content, footer
	createApp(Header).mount('#header')
	createApp(Navigation).mount('#navigation')

	const titleApp = createApp(Title);
	titleApp.config.globalProperties.title = title;
	titleApp.mount('#title')

	createApp(defineAsyncComponent(() => import('@/page/' + content))).mount('#content')

	createApp(Footer).mount('#footer')
}