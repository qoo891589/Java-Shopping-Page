// import './assets/main.css'
// import axios from 'axios'

import { createApp } from 'vue'
import { createPinia } from 'pinia'

import App from './App.vue'
import router from './router'

import { lazyPlugin } from '@/directives'

import '@/styles/common.scss'

// import { getCategory } from './apis/testAPI'
// getCategory().then(res => { 
//     console.log(res)
// })

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(lazyPlugin)

app.mount('#app')

