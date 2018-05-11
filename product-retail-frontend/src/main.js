// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import BootstrapVue from 'bootstrap-vue'
import VueMaterial from 'vue-material'
import VeeValidate from 'vee-validate'
import VueBreadcrumbs from 'vue-2-breadcrumbs'
import App from './App'
import router from './router'
import { sync } from 'vuex-router-sync'
import store from './store/store'
import VueDragAndDropList from 'vue-drag-and-drop-list'

Vue.use(VueDragAndDropList)

Vue.config.productionTip = false

Vue.use(BootstrapVue)
Vue.use(VueMaterial)
Vue.use(VeeValidate)
Vue.use(VueBreadcrumbs)

sync(store, router)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})
