import { createApp } from 'vue'
import { defineAsyncComponent } from 'vue'

import axios from "axios";

import Header from '@/component/template/Header.vue'
import Navigation from '@/component/template/Navigation.vue'
import Title from '@/component/template/Title.vue'
import Footer from '@/component/template/Footer.vue'

export const TitleOptions = {
	DEFAULT: "Mensa België",
	PAGE: "Mensa - "
};

export function load(content, documentTitle, title, member) {

	document.title = documentTitle ? TitleOptions.PAGE + documentTitle : TitleOptions.DEFAULT;

	if (member) {

		axios.get(process.env.VUE_APP_HOST_REST + `session/logIn`);
	}

	createApp(Header).mount('#header')
	createApp(Navigation).mount('#navigation')

	const titleApp = createApp(Title);
	titleApp.config.globalProperties.title = title;
	titleApp.mount('#title')

	const Content = defineAsyncComponent(() => import('@/page/' + content))

	createApp(Content).mount('#content')

	createApp(Footer).mount('#footer')
}