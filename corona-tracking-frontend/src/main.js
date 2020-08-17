import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import vuetify from './plugins/vuetify'
import toastr from "vue-toastr"
import Vuelidate from 'vuelidate'
Vue.config.productionTip = false

Vue.use(Vuelidate)
Vue.use(toastr, {
	defaultTimeout: 2000,
	defaultProgressBar: false,
	defaultProgressBarValue: 0,
	defaultType: "error",
	defaultPosition: "toast-bottom-right",
	defaultCloseOnHover: false,
	defaultClassNames: ["animated", "zoomInUp"]
});

new Vue({
  router,
  store,
  vuetify,
  beforeCreate() {
		store.commit('initialiseAuth');
	},
  render: h => h(App)
}).$mount('#app')
