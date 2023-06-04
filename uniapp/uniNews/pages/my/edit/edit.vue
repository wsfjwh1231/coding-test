<template>
	<view class="edit">
		<view class="photo" @click="upAvatar">
			<image :src="user.avatar" mode=""></image>
			<image src="/static/avatar.png" mode=""></image>
		</view>
		<view class="inputView">
			<view class="text">username</view>
			<input type="text" class="input" v-model="user.username">
		</view>
		<view class="inputView">
			<view class="text">Email Address*</view>
			<input type="text" class="input" v-model="user.address">
		</view>
		<view class="inputView">
			<view class="text">Phone Number*</view>
			<input type="text" class="input" v-model="user.phone">
		</view>
		<button type="primary" class="nextBtn" @click="upUserInfo">Next</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user:{}
			}
		},
		onLoad() {
			const token = uni.getStorageSync("token")
			if(token == ''){
				uni.navigateTo({
					url:"/pages/my/login/login"
				})
			}
			
			const user = uni.getStorageSync("user")
			if(user != ''){
				console.log(user)
				this.user = user
				console.log(this.user)
				
			}else{
				console.log("未登錄")
			}
		},
		methods: {
			upUserInfo(){
				uni.request({
					url:"user/edit",
					method:"POST",
					data:{
						userId:this.user.id,
						username:this.user.username,
						address:this.user.address,
						phone:this.user.phone,
						avatar:this.user.avatar,
					},
					success: (res) => {
						console.log(res.data)
						if(res.data.code == 200){
							uni.request({
								url:"user/getUserInfo",
								method:"GET",
								header:{
									"Content-Type":"multipart/form-data",
									"authorization":uni.getStorageSync("token")
								},
								success: (res) => {
									if(res.data.code == 200){
										//重新获取用户信息
										uni.setStorageSync("user",res.data.user)
									}else{
										console.log(res.data.code)
									}
								}
							})
						}else{
							console.log(res.data.code)
						}
					}
				})
			},
			// 上传头像
			upAvatar(){
				uni.chooseImage({
					success: (res) => {
						console.log(res)
						const tempFilePaths = res.tempFilePaths;
						uni.uploadFile({
							url:"upload",
							filePath: tempFilePaths[0],
							nmme:"file",
							success: (res) => {
								console.log(res.data)
								const data = JSON.parse(res.data) 
								console.log(data)
								this.user.avatar = data.path
								
							},
							fail: (err) => {
								console.log(err)
							}
						})
					}
				})			
			}
		}
	}
</script>

<style lang="scss">
	.edit{
		padding: 20rpx;
		.photo{
			position: relative;
			margin-top: 50rpx;
			text-align: center;
			image:nth-child(1){
				width: 200rpx;
				height: 200rpx;
				border-radius: 200rpx;
			}
			image:nth-child(2){
				width: 50rpx;
				height: 50rpx;
				border-radius: 50rpx;
				background: blue;
				position: absolute;
				bottom: 10rpx;
				right:300rpx;
				
			}
			
		}
		
		.inputView{
			margin: 30rpx;
			.input{
				border:1rpx solid gray;
				border-radius: 10rpx;
			}
			.text{
				margin-bottom: 10rpx;
			}
		}
		
		.nextBtn{
			margin-top: 450rpx;
		}
	}
</style>
