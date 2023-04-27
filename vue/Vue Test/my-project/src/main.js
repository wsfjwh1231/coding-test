import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import Vant from 'vant';
import 'vant/lib/index.css';
import { NavBar } from 'vant';

Vue.use(NavBar);
Vue.use(Vant);
Vue.config.productionTip = false

// 创建vue实例
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

// $mount('#app')
// el:"#app"

