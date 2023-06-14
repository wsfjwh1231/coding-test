import Vue from 'vue'
import VueRouter from 'vue-router'
import HomeView from '../views/HomeView.vue'

Vue.use(VueRouter)

const routes = [
	// {
	//   path: '/',
	//   name: 'home',
	//   component: HomeView,
	// },
	{
		path: '/',
		name: 'login',
		component: () => import('../views/LoginView.vue')
	},
	{
		path: '/home',
		name: 'home',
		component: () => import('../views/HomeView.vue'),
		children: [{
				path: '/category',
				name: 'category',
				component: () => import('../views/CategoryView.vue'),
				meta: {
					title: "商品分类"
				}
			},
			{
				path: '/specification',
				name: 'specification',
				component: () => import('../views/SpecificationView.vue'),
				meta: {
					title: "商品规格"
				}
			},
			{
				path: '/productList',
				name: 'productList',
				component: () => import('../views/ProductListView.vue'),
				meta: {
					title: "商品列表"
				}

			},
			{
				path: '/statistics',
				name: 'statistics',
				component: () => import('../views/StatisticsView.vue'),
				meta: {
					title: "数据统计"
				}
			},
			{
				path: '/orderManagement',
				name: 'orderManagement',
				component: () => import('../views/OrderManagementView.vue'),
				meta: {
					title: "订单管理"
				}
			},
			{
				path: '/userList',
				name: 'userList',
				component: () => import('../views/UserListView.vue'),
				meta: {
					title: "用户列表"
				}
			},
			{
				path: '/index',
				name: 'index',
				component: () => import('../views/IndexView.vue'),
				meta: {
					title: "首页"
				}
			},
			{
				path: '/updateProductList',
				name: 'updateProductList',
			
				component: () => import('../views/updateProductListView.vue'),
				meta: {
					title: "修改商品"
				}
			},
			{
				path: '/addProductList',
				name: 'addProductList',
			
				component: () => import('../views/addProductListView.vue'),
				meta: {
					title: "添加商品"
				}
			},

		]
	},

	{
		path: '/about',
		name: 'about',
		// route level code-splitting
		// this generates a separate chunk (about.[hash].js) for this route
		// which is lazy-loaded when the route is visited.
		component: () => import( /* webpackChunkName: "about" */ '../views/AboutView.vue')
	}

]

const router = new VueRouter({
	routes
})

export default router