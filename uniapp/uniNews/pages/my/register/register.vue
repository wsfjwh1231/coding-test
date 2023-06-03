<template>
	<view class="register">
		<view class="top">Hello!</view>
		<view class="described">Signup to get Started</view>
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
		<button type="primary" class="loginBtn" @click="registerBtn" >Signup</button>
		
		<view class="continueText">
			<text>or continue with</text>
		</view>
		
		<view class="icon">
			<view class="BottomIcon">
				<image src="/static/facebook.png" mode=""></image>
				<view class="BottomIconText">Facebook</view>
			</view>
			<view class="BottomIcon">
				<image src="/static/google.png" mode=""></image>
				<view class="BottomIconText">Facebook</view>
			</view>
		</view>
		
		<view class="isLogin">
			<text>Already have an account?login</text>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				username:"",
				password:""
			};
		},
		onLoad() {
			const token = uni.getStorageSync("token")
			if(token != ''){
				console.log(token)
				console.log(this.isLogin)
				this.isLogin = 1
				uni.switchTab({
					url:"/pages/my/my"
				})
			}else{
				this.isLogin = 0
			}
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
			
			registerBtn(){
				uni.request({
					url:"http://101.34.49.100:3002/user/register",
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
							uni.navigateTo({
								url:"/pages/my/login/login"
							})
						}else{
							console.log(res.data.msg)
						}
					}
				})
				
			},
			
		}
	}
</script>

<style lang="scss">
	.register {
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

		.continueText {
			font-size: 30rpx;
			display: flex;
			justify-content: center;
			margin-bottom: 50rpx;
		}

		.icon{
			display: flex;
			justify-content: space-around;
			margin-bottom: 50rpx;
			.BottomIcon{
				display: flex;
				image{
					width: 50rpx;
					height: 50rpx;
				}
			}
		}
		
		.isLogin{
			display: flex;
			justify-content: center;
		}
		

	}
</style>