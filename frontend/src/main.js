import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store";
import vuetify from "./plugins/vuetify";
import axios from 'axios';

Vue.config.productionTip = false;
Vue.prototype.$axios = axios;

axios.defaults.baseURL = 'http://localhost:8081/api/v1/';
axios.defaults.headers.get['Accepts'] = 'application/json';

new Vue({
  router,
  store,
  vuetify,
  render: (h) => h(App),
}).$mount("#app");
