<template>
	<view class="login">
		<view class="top">Hello</view>
		<view class="described">welcome back you've been missed</view>
		<view class="usernameInput">
				<view class="username" v-model="username">username</view>
				<input type="text"  @input="usernameInput">
		</view>
		<view class="passwordInput">
				<view class="password" v-model="password">password</view>
				<input type="text"  @input="passwordInput">
		</view>
		<view class="remember">
			<checkbox class="checkbox">Remember</checkbox>
		</view>
		<button type="primary" class="loginBtn" @click="loginBtn" >Login</button>
		<view class="register" @click="toRegister">
			<text>前往註冊</text>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				username:"",
				password:"",
				// 是否登錄 0否1是
				isLogin:0
			};
		},
		onLoad(options) {
			if(options.code == 401){
				uni.showToast({
					title:"登录失效，请重新登录",
					icon:"error",
					duration:3000
				})
			}
			// const token = uni.getStorageSync("token")
			// if(token != ''){
			// 	console.log(token)
			// 	console.log(this.isLogin)
			// 	this.isLogin = 1
			// 	uni.switchTab({
			// 		url:"/pages/my/my"
			// 	})
			// }else{
			// 	this.isLogin = 0
			// }
		},
		methods: {
			usernameInput(data){
				this.username = data.detail.value
				console.log(data.detail.value)
			},
			
			passwordInput(data){
				this.password = data.detail.value
				console.log(data.detail.value)
			},
			
			loginBtn(){
				uni.request({
					url:"user/login",
					method:"POST",
					header:{
						"Content-Type":"application/json"
					},
					data:{
						"username":this.username,
						"password":this.password
					},
					success: (res) => {
						if(res.data.code == 200){
							console.log(res.data)
							uni.setStorageSync("token",res.data.token)
							uni.setStorageSync("user",res.data.user)
							this.isLogin = 1
							uni.switchTab({
								url:"/pages/index/index"
							})
						}else{
							console.log(res.data.message)
						}
					}
				})
				
			},
			
			toRegister(){
				uni.navigateTo({
					url:"/pages/my/register/register"
				})
			}
		}
	}
</script>

<style lang="scss">
	.login {
		padding: 30rpx;

		.top {
			font-size: 70rpx;
			font-weight: 600;
			margin-bottom: 20rpx;
			margin-top: 50rpx;
		}

		.described {
			font-size: 50rpx;
			margin-bottom: 20rpx;
		}

		.usernameInput {
			margin-bottom: 20rpx;

			.username {
				margin-bottom: 20rpx;
			}

			&>input {
				width: 98%;
				border: 1rpx solid gray;
				border-radius: 10rpx;
			}
		}

		.passwordInput {
			margin-bottom: 20rpx;

			.password {
				margin-bottom: 20rpx;
			}

			&>input {
				width: 98%;
				border: 1rpx solid gray;
				border-radius: 10rpx;
			}
		}

		.remember {
			margin: 60rpx 0;
		}

		.loginBtn {
			margin: 50rpx 0;
		}

		.register {
			font-size: 30rpx;
			display: flex;
			justify-content: flex-end;
		}


	}
</style>