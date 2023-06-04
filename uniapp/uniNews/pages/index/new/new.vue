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
					<image v-if="newsInfo.is_like" src="/static/like_ok.png" class="likeBlue" mode=""></image>
					<image v-else src="/static/like.png" class="likeBlue" mode=""></image>
					<span>{{likeNum}}</span>
				</view>
				<view class="comtentBottomLeftImage" @click="toComment">
					<image src="/static/comment.png" mode=""></image>
					<span>{{commentNum}}</span>
				</view>
				
				
			</view>
			<image v-if="newsInfo.is_collection" src="/static/topic_active.png" mode="" @click="onCollection"></image>
			<image v-else src="/static/topic.png" mode="" @click="onCollection"></image>
		</view>
		
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				newsId:0,
				user:{},
				newsInfo:{},
				// 0 未点赞，1已点赞
				isLike:0,
				//0 已收藏 1 未收藏
				isCollection:0,
				likeNum:0,
				commentNum:0,
			}
		},
		onLoad(options) {
			console.log(options.newId)
			this.user = uni.getStorageSync("user")
			this.newsId = options.newId
			this.getNew();
			this.getUser();
			this.getCommentNum();
		},
		methods: {
			//获取评论数量
			getCommentNum(){
				uni.request({
					url:"commentCount",
					method:"GET",
					data:{
						newsId:this.newsId
					},
					success: (res) => {
						console.log(res.data)
						this.commentNum = res.data.count
					}
				})
			},
			
			//前往留言界面
			toComment(){
				console.log()
				uni.navigateTo({
					url:"/pages/index/comment/comment?newsId="+this.newsId
				})
			},
			
			//回退上一页
			toBack(){
				uni.navigateBack({
					delta:1
				})
			},
			
			//收藏操作
			onCollection(){
				if(this.isCollection == 0){
					uni.request({
						url:"news/collectionOrCancel",
						method:"POST",
						header:{
							"authorization":uni.getStorageSync("token")
						},
						data:{
							userId:this.user.id,
							newsId:this.newsId,
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
						url:"news/collectionOrCancel",
						method:"POST",
						header:{
							"authorization":uni.getStorageSync("token")
						},
						data:{
							userId:this.user.id,
							newsId:this.newsId,
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
						url:"giveLikeOrCancelGiveLike",
						method:"POST",
						header:{
							"authorization":uni.getStorageSync("token")
						},
						data:{
							userId:this.user.id,
							newsId:this.newsId,
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
						url:"giveLikeOrCancelGiveLike",
						method:"POST",
						header:{
							"authorization":uni.getStorageSync("token")
						},
						data:{
							userId:this.user.id,
							newsId:this.newsId,
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
					url:"news/detail?newsId="+this.newsId+"&userId="+this.user.id,
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
								url:"getGiveLikeNum",
								method:"GET",
								data:{
									newsId:this.newsId
								},
								success: (res) => {
									console.log(res.data)
									this.likeNum = res.data.num
								}
								
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
				
				.content{
					width: 100%;
				}
				
				
			}
			
		}
		
		.comtentBottom{
			// border: 1rpx solid red;
			display: flex;
			justify-content: space-between;
			position: fixed;
			background-color: white;
			width: 95%;
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