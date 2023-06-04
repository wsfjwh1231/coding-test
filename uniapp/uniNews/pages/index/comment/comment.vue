<template>
	<view class="page">
		<view class="commentList">
			<view class="commentItem" v-for="(item,index) in commentList">
				<image :src="item.avatar" mode=""></image>
				<view class="commentItemRight">
					<view class="username">{{item.username}}</view>
					<view class="content">{{item.content}}</view>
					<view v-if="user.id == item.user_id" class="delteComment" @click="deleteComment(item)">删除</view>
				</view>
			</view>
		</view>
		<view class="commentInput">
			<input type="text" placeholder="Type your comment" placeholder-style="placeholderStyle" v-model="commentInput" @input="onComment">
			<image src="../../../static/send.png" mode="" @click="sendComment"></image>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				user:{},
				commentList:[],
				newsId:0,
				commentInput:""
			};
		},
		onLoad(options) {
			this.newsId = options.newsId
			this.user = uni.getStorageSync("user")
			this.getComment();
			
		},
		methods:{
			//输入评论
			onComment(data){
				this.commentInput = data.detail.value
			},
			
			
			//获取评论列表
			getComment(){
				uni.request({
					url:"commentList",
					method:"GET",
					header:{
						"authorization":uni.getStorageSync("token")
					},
					data:{
						newsId:this.newsId
					},
					success: (res) => {
						if (res.data.code == 200) {
							console.log(res.data)
							this.commentList = res.data.list
						} else{
							console.log(res.data)
						}
						
					}
				})
			},
			
			//发送评论
			sendComment(){
				
				uni.request({
					url:"comment",
					method:"POST",
					data:{
						userId:this.user.id,
						newsId:this.newsId,
						content:this.commentInput
						
					},
					header:{
						"authorization":uni.getStorageSync("token")
					},
					success: (res) => {
						if (res.data.code == 200) {
							//发送评论成功后，重新加载评论列表
							this.getComment();
							
							uni.showToast({
								title:"评论成功"
							})
							
							this.commentInput = ""
						} else{
							console.log(res.data)
						}
						
					}
				})
			},
			
			//删除留言
			deleteComment(data){
				console.log(data)
				uni.showModal({
					title:"警告",
					content:"确定要删除这条评论吗？",
					success: (res) => {
						if (res.confirm) {
							console.log("确定")
							
							uni.request({
								url:"commentDel",
								method:"DELETE",
								header:{
									"authorization":uni.getStorageSync("token")
								},
								data:{
									commentId:data.id
								},
								success: (res) => {
									if (res.data.code == 200) {
										uni.showToast({
											title:"删除评论成功"
										})
										this.getComment()
									} else{
										console.log(res.data)
									}
									
								}
							})
							
						} else{
							console.log("点击了取消按钮")
						}
					},
					
				})
				
			},
		}
	}
</script>

<style lang="scss">
.page{
	position: relative;
	padding: 5%;
	
	.commentList{
		.commentItem{
			display: flex;
			margin: 40rpx 0;
			width: 90%;
			image{
				width: 40rpx;
				height: 40rpx;
				border-radius: 40rpx;
			}
			.commentItemRight{
				flex: 1;
				margin-left: 10rpx;
				
				.username{
					font-size: 20rpx;
					font-weight: 600;
					margin-bottom: 5rpx;
				}
				
				.content{
					
				}
				
				.delteComment{
					font-size: 10rpx;
					color: gray;
				}
			}
		}
	}
	
	.commentInput{
		display: flex;
		align-items: center;
		justify-content: center;
		position: fixed;
		left: 5%;
		right: 5%;
		bottom: 0;
		width: 90%;
		background-color: white;
		input{
			padding-left: 10rpx;
			border:1rpx solid gray;
			border-radius: 5rpx;
			height: 50rpx;
			width: 90%;
			margin-right: 5rpx;
		}
		image{
			width: 60rpx;
			height: 60rpx;
		}
	}
}
</style>
