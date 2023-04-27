import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    meta:{
      title:"首页"
    }
  },
  {
    path: '/about',
    name: 'about',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
  },
  
  // 显示登录界面
  {
    // path: '/login/:params',
    path: '/login',
    name: 'login',
    component: () => import('../views/Login.vue'),
    meta:{
      title:"登录"
    }
  }
]

// 创建一个路由实例 ES6 const let var
const router = new VueRouter({
  routes
})

// 导出外面，以便其他文件调用它
export default router
