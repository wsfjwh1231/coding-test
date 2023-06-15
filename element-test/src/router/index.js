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
			{
				path: '/addCategory',
				name: 'addCategory',
			
				component: () => import('../views/addCategoryView.vue'),
				meta: {
					title: "添加分类"
				}
			},
			{
				path: '/updateCategory',
				name: 'updateCategory',
			
				component: () => import('../views/updateCategoryView.vue'),
				meta: {
					title: "修改分类"
				}
			},
			{
				path: '/test1',
				name: 'test1',
			
				component: () => import('../views/test/TestView1.vue'),
				meta: {
					title: "测试界面1"
				}
			},
			{
				path: '/test2',
				name: 'test2',
			
				component: () => import('../views/test/TestView2.vue'),
				meta: {
					title: "测试界面2"
				}
			},
			{
				path: '/test3',
				name: 'test3',
			
				component: () => import('../views/test/TestView3.vue'),
				meta: {
					title: "测试界面3"
				}
			},
			{
				path: '/test4',
				name: 'test4',
			
				component: () => import('../views/test/TestView4.vue'),
				meta: {
					title: "测试界面4"
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