import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import * as echarts from 'echarts';

// 引入封装好的axios
import instance from './utils/http';

// 全局挂载
Vue.prototype.$http = instance
Vue.prototype.$echarts = echarts
// 取消警告
Vue.config.productionTip = false
Vue.use(ElementUI);


new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
