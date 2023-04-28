import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginView from '../views/LoginView.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'login',
    component: LoginView
  },
  {
    path: '/home',
    name: 'home',
    component: () => import('../views/HomeView.vue'),
    children: [
      {
        path: '/user-list',
        name: 'user-list',
        component: () => import('../views/UserListView.vue'),
        meta: {
          title: "用户列表"
        }
      },
      {
        path: '/shop',
        name: 'shop',
        component: () => import('../views/ShopView.vue'),
        meta: {
          title: "商品列表"
        },

      },
      {
        path: '/statitistic',
        name: 'statitistic',
        component: () => import('../views/StatitisticView.vue'),
        meta: {
          title: "数据统计"
        }
      },
      {
        path: '/category',
        name: 'category',
        component: () => import('../views/CategoryView.vue'),
        meta: {
          title: "商品分类"
        }
      },
      {
        path: '/addCategoryView',
        name: 'addCategoryView',
        component: () => import('../views/addCategoryView.vue'),
        meta: {
          title: "添加分类"
        }
      }
    ],
    meta: {
      title: "首页"
    }
  },


  {
    path: '/about',
    name: 'about',
    component: () => import('../views/AboutView.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
