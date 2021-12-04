import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import ViewUI from 'view-design';
import axios from 'axios'
import { mavonEditor } from "mavon-editor";

import  "./util/http"

import 'element-ui/lib/theme-chalk/index.css';
import 'view-design/dist/styles/iview.css';
import "mavon-editor/dist/css/index.css";

Vue.config.productionTip = false
Vue.prototype.$axios = axios //

Vue.use(ElementUI);
Vue.use(ViewUI);
// Vue.use(mavonEditor);
Vue.component("mavon-editor", mavonEditor);

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
