<template>
	<view class="new">
		<view class="nav">
			<image src="/static/back.png" mode="" @click="toBack"></image>
			<view class="navRight">
				<image src="/static/fenxiang.png" mode=""></image>
				<image src="/static/setting.png" mode="aspectFit"></image>
			</view>
		</view>

		<view class="newInfo">
			<view class="newInfoTop">
				<view class="newInfoTopLeft">
					<image src="http://rugxq5a9y.hd-bkt.clouddn.com/1680671355058-news-author.png" mode=""></image>
					<view class="newInfoTopLeftRight">
						<view class="newInfoTopLeftRightTop">
							{{newsInfo.create_user}}
						</view>
						<view class="newInfoTopLeftRightBottom">
							{{newsInfo.create_time}}
						</view>
					</view>
				</view>

				<button type="primary">Following</button>
			</view>
			
			<view class="newInfoContent">
				<image :src="newsInfo.cover" mode=""></image>
				<view class="country">Europe</view>
				<view class="title">{{newsInfo.title}}</view>
				<view class="content" v-html="newsInfo.content"></view>
			</view>
		</view>
		
		<view class="comtentBottom">
			<view class="comtentBottomLeft">
				<view class="comtentBottomLeftImage" @click="onLike">
					<image v-if="isLike == 0" src="/static/like.png" class="likeBlue" mode=""></image>
					<image v-if="isLike == 1" src="/static/like_ok.png" class="likeBlue" mode=""></image>
					<span>{{likeNum}}</span>
				</view>
				<view class="comtentBottomLeftImage">
					<image src="/static/comment.png" mode=""></image>
					<span>{{newsInfo.comment_count}}</span>
				</view>
				
				
			</view>
			<image v-if="isCollection == 1" src="/static/topic_active.png" mode="" @click="onCollection"></image>
			<image v-if="isCollection == 0" src="/static/topic.png" mode="" @click="onCollection"></image>
		</view>
		
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user:{},
				newsInfo:{},
				// 0 未点赞，1已点赞
				isLike:0,
				//0 已收藏 1 未收藏
				isCollection:0,
				likeNum:0
			}
		},
		onLoad() {
			this.getNew();
			this.getUser()
		},
		methods: {
			//回退上一页
			toBack(){
				uni.navigateBack({
					delta:10
				})
			},
			
			//收藏操作
			onCollection(){
				if(this.isCollection == 0){
					uni.request({
						url:"http://101.34.49.100:3002/news/collectionOrCancel",
						method:"POST",
						header:{
							"authorization":uni.getStorageSync("token")
						},
						data:{
							userId:this.user.id,
							newsId:this.newsInfo.id,
							isCollection:1
						},
						success: (res) => {
							console.log(res.data)
							this.isCollection = 1
							uni.showToast({
								title:"收藏成功"
							})
							this.getNew()
						}
						
					})
				}else{
					uni.request({
						url:"http://101.34.49.100:3002/news/collectionOrCancel",
						method:"POST",
						header:{
							"authorization":uni.getStorageSync("token")
						},
						data:{
							userId:this.user.id,
							newsId:this.newsInfo.id,
							isCollection:0
						},
						success: (res) => {
							console.log(res.data)
							this.isCollection = 0
							uni.showToast({
								title:"已取消收藏"
							})
							this.getNew()
						}
						
					})
				}
				
			},
			
			//点赞操作
			onLike(){
				if(this.isLike == 0){
					uni.request({
						url:"http://101.34.49.100:3002/giveLikeOrCancelGiveLike",
						method:"POST",
						header:{
							"authorization":uni.getStorageSync("token")
						},
						data:{
							userId:this.user.id,
							newsId:this.newsInfo.id,
							isLike:1
						},
						success: (res) => {
							console.log(res.data)
							this.isLike = 1
							this.getNew()
						},
						fail: (err) => {
							console.log(err)
						}
					})
				}else{
					
					uni.request({
						url:"http://101.34.49.100:3002/giveLikeOrCancelGiveLike",
						method:"POST",
						header:{
							"authorization":uni.getStorageSync("token")
						},
						data:{
							userId:this.user.id,
							newsId:this.newsInfo.id,
							isLike:0
						},
						success: (res) => {
							console.log(res.data)
							this.isLike = 0
							this.getNew()
						},
						fail: (err) => {
							console.log(err)
						}
					})
				}
			},
			
			// 获取用户信息
			getUser(){
				const user = uni.getStorageSync("user")
				if(user != ''){
					console.log(user)
					console.log(this.isLogin)
					this.user = user
					console.log(this.user)
					
				}else{
					console.log("未登錄")
				}
			},
			
			//获取新闻信息
			getNew(){
				uni.request({
					url:"http://101.34.49.100:3002/news/detail?newsId=2&userId=424",
					method:"GET",
					header:{
						"authorization":uni.getStorageSync("token")
					},
					success: (res) => {
						if(res.data.code == 200){
							console.log(res.data)
							this.newsInfo = res.data.newsInfo
							if(this.newsInfo.is_like){
								this.isLike = 1
							}else{
								this.isLike = 0
							}
							
							if(this.newsInfo.is_collection){
								this.isCollection = 1
							}else{
								this.isCollection = 0
							}
							
							//获取点赞数量
							uni.request({
								url:"http://101.34.49.100:3002/getGiveLikeNum",
								method:"GET",
								data:{
									newsId:2
								},
								success: (res) => {
									console.log(res.data)
									this.likeNum = res.data.num
								}
								
							})
							
						}else if(res.data.code == 401){
							console.log(res.data.msg)
							uni.navigateTo({
								url:"/pages/my/login/login?code=401"
							})
							
							
						}else{
								console.log(res.data)
						}
						
					}
					
				})
				
				
			}
		}
	}
</script>

<style lang="scss">
	.new {
		position: relative;
		padding: 30rpx;
		.nav {
			display: flex;
			justify-content: space-between;
			margin-bottom: 30rpx;

			image {
				width: 30rpx;
				height: 30rpx;
			}


			.navRight {
				image:nth-child(1) {
					margin-right: 20rpx;
				}
			}
		}

		.newInfo {
			.newInfoTop{
				width: 100%;
				display: flex;
				justify-content: space-between;
				align-items: center;
				margin-bottom: 30rpx;
				.newInfoTopLeft{
					display: flex;
					align-items: center;
					font-size: 20rpx;
					image{
						width: 80rpx;
						height: 80rpx;
						border-radius: 80rpx;
						margin-right: 10rpx;
					}
					
					.newInfoTopLeftRightTop{
						font-weight: 600;
					}
				}
				
				button{
					margin-left: 0;
					margin-right: 0;
					
					height: 50rpx;
					line-height: 50rpx;
					font-size: 25rpx;
				}
			}
			
			.newInfoContent{
				display: flex;
				flex-direction: column;
				align-items: center;  
				
				image{
					width: 100%;
					height: 500rpx;
				}
				
				.country{
					align-self:flex-start;
					font-size: 20rpx;
					color:gray;
					margin: 20rpx 0;
				}
				
				.title{
					font-weight: 600;
					font-size: 35rpx;
				}
				
				
			}
			
		}
		
		.comtentBottom{
			// border: 1rpx solid red;
			display: flex;
			justify-content: space-between;
			position: fixed;
			background-color: white;
			width: 90%;
			bottom: 0;
			
			.comtentBottomLeft{
				display: flex;
				
				.comtentBottomLeftImage{
					margin-right: 80rpx;
					display: flex;
					align-items: center;
					
					image{
						margin-right: 10rpx;
					}
					
				}
			}
			
			image{
				width:50rpx;
				height: 50rpx;
			}
			
			
			
			
		}
	}
</style>