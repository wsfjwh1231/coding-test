import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'
import { Empty } from 'vant';

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
    path: '/shoppingCar',
    name: 'shoppingCar',
    component: () => import('../views/shoppingCar.vue'),
    meta:{
      title:"购物车"
    }
  },
  {
    path: '/my',
    name: 'my',
    component: () => import('../views/MyView.vue'),
    meta:{
      title:"我的"
    }
  },
  {
    path: '/helloWorld',
    name: 'helloWorld',
    component: () => import('../views/HelloWorld.vue'),
    meta:{
      title:"接口"
    }
  },
  {
    path: '/category',
    name: 'category',
    component: () => import('../views/CategoryView.vue'),
    meta:{
      title:"分类"
    }
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
