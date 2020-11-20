/* -------------------------------------- Adapt below part ----------------------------------- */

const component = 'public/home/Home.vue'

// needs translation
const page = 'Welkom'
const title = `Welkom bij <em><span class="text-secondary">Mensa</span></em>`

/* -------------------------------------- Adapt above part ----------------------------------- */

import { load } from '@/template/default.js'
load(component, page, title, false)