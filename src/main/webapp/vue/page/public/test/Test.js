/* -------------------------------------- Adapt below part ----------------------------------- */

const component = 'public/test/Test.vue'

// needs translation
const page = 'IQ Test'
const title = page

/* -------------------------------------- Adapt above part ----------------------------------- */

import { load } from '@/template/default.js'
load(component, page, title, false)