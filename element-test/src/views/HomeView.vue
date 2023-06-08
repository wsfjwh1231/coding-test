<template>
	<div class="home">
		<el-container>
			<el-aside width="200px" style="height: 100vh;background-color: #545c64;">
				<el-menu router default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
					background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
					<el-menu-item index="/index">
						<i class="el-icon-s-home"></i>
						<span slot="title">首页</span>
					</el-menu-item>
					<el-submenu index="2">
						<template slot="title">
							<i class="el-icon-shopping-bag-1"></i>
							<span>商品</span>
						</template>
						<el-menu-item-group>
							<el-menu-item index="/category">商品分类</el-menu-item>
							<el-menu-item index="/specification">商品规格</el-menu-item>
							<el-menu-item index="/productList">商品列表</el-menu-item>
							<el-menu-item index="/statistics">数据统计</el-menu-item>
						</el-menu-item-group>
					</el-submenu>
					<el-menu-item index="/orderManagement">
						<i class="el-icon-s-order"></i>
						<span slot="title">订单管理</span>
					</el-menu-item>
					<el-menu-item index="/userList">
						<i class="el-icon-document"></i>
						<span slot="title">用户列表</span>
					</el-menu-item>
				</el-menu>
			</el-aside>
			<el-main>
				<div class="nav-menu">
					<el-breadcrumb separator="/">
						<el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
						<el-breadcrumb-item v-if="$route.meta.title != '首页'">
							<a href="/">{{ $route.meta.title }}</a>
						</el-breadcrumb-item>
					</el-breadcrumb>
					<div class="rightIcon">
						<span>{{user.username}}</span>
						<img :src="user.avatar" alt="头像">
					</div>
				</div>
				
				<router-view />
			</el-main>
		</el-container>



	</div>
</template>

<script>
	import axios from 'axios'
	export default {
		name: 'HomeView',
		data() {
			return {
				user: {}
			}
		},
		watch: {

		},
		filters: {},
		mounted() {
			this.user = JSON.parse(localStorage.getItem("pc-user"))
			console.log(this.user)
		},
		methods: {
			handleOpen(key, keyPath) {
				console.log(key, keyPath);
			},
			handleClose(key, keyPath) {
				console.log(key, keyPath);
			}
		}
	}
	
	
</script>

<style lang="scss" scoped>
	.home {
		height: 100vh;

		.nav-menu {
			// border-bottom: 1rpx solid gray;
			display: flex;
			justify-content: space-between;
			align-items: center;
			padding: 10px 0;
			border-bottom: 1px solid gray;

			.rightIcon {
				display: flex;
				align-items: center;
				margin-right: 20px;
				font-size: 18px;
				font-weight: 600;
				color: gray;
				img {
					margin-left: 10px;
					width: 50px;
					height: 50px;
				}
			}

		}
	}
</style>