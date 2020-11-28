/* Vue Core: front-end component development								-------------------------------------------------------------------------------- */
import { createApp, defineAsyncComponent } from 'vue'

// Axios Core: front-end to back-end communication							-------------------------------------------------------------------------------- */
import axios from "axios";
axios.defaults.baseURL = "/rest"; // Url of API. Must be with initial slash, otherwise relative url's are use!
axios.defaults.headers.post['Content-Type'] = 'application/json'; // Not set by default apparently

// PrimeVue Core: enhanced components with theming and icons				-------------------------------------------------------------------------------- */
import 'primevue/resources/primevue.min.css';

// PrimeVue Components
import toast from 'primevue/toast';
import toastService from 'primevue/toastservice';

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
const TitleOptions = {
	DEFAULT: "Mensa.be",
	PAGE: "Mensa - "
};
const TemplateLabels = {
	DOCUMENT_TITLE: 'label.document.title.',
	TITLE_CONTENT: 'content.title.'
};

// Application Logic: translation
import { translate } from "@/component/common/LanguageLogic.js";

// Component Logic: build layout											-------------------------------------------------------------------------------- */
export default async function load(content, title, member) {

	var documentTitle = await translate(TemplateLabels.DOCUMENT_TITLE + title).then(t => { return t.data })

	// await translate(browserTab).then(t => { documentTitle = t.data })

	// set the document title for the browser tab name, we don't do it in the header. 
	// this is different then the title on the page itself (heading or h1 - see further)
	document.title = documentTitle ? TitleOptions.PAGE + documentTitle : TitleOptions.DEFAULT;

	// check if we are in a member page to set the logged in flag
	if (member) {

		axios.get('session/logIn');
		console.log("member log in")
	}


	// start building the page, with the header, navigation, title, content, footer
	createApp(Header).mount('#header')
	createApp(Navigation).mount('#navigation')

	const titleApp = createApp(Title);
	titleApp.config.globalProperties.title = await translate(TemplateLabels.TITLE_CONTENT + title).then(t => { return t.data });
	titleApp.mount('#title')

	const contentApp = createApp(defineAsyncComponent(() => import('@/page/' + content)))

	contentApp.use(toastService);
	contentApp.component('Toast', toast);

	contentApp.mount('#content')

	createApp(Footer).mount('#footer')
}
