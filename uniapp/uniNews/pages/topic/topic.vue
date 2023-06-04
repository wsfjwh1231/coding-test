<template>
	<view class="topic">
		<view class="navTitle">Bookmark</view>
		<view class="search">
				<icon type="search" class="leftIcon"></icon>
				<input class="searchInput" placeholder="搜索" v-model="searchInput" @input="onSearchInput" />
				<icon v-if="showClearIcon" type="clear" class="rightIcon" @click="onCleanInput"></icon>
		</view>

		<view class="newList">
			<view class="newItem" v-for="(item,index) in newsList" @click="toNew(index)">
				<image :src="item.cover" mode="" class="newImg"></image>
				<view class="newRight">
					<view class="newRightTop">Europe</view>
					<view class="newRightTitle">{{item.title}}</view>
					<view class="newRightBottom">
						<image :src="item.publisher_img" mode=""></image>
						<view class="newRightBottomText">{{item.create_user}}</view>
						<view class="newRightBottomTime">{{item.create_time}}</view>
					</view>
				</view>
			</view>
		</view>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				user: {},
				newsList: [],
				searchInput:"",
				showClearIcon:false
			}
		},
		onShow() {
			this.onCollection()
		},
		methods: {
			
			//跳转新闻详情
			toNew(index){
				console.log(index)
				console.log(this.newsList[index])
				uni.navigateTo({
					url:"/pages/index/new/new?newId="+this.newsList[index].id
				})
				
			},
			
			// 清除搜索框
			onCleanInput(){
				this.searchInput = "";
				this.showClearIcon = false;
			},
			
			// 搜索输入框
			onSearchInput(data){
				console.log(data)
				if (data.detail.value.length > 0) {
					this.showClearIcon = true
				} else{
					this.showClearIcon = false
				}
			},
			
			// 查询收藏
			onCollection() {
				uni.request({
					url: "user/getUserCollection",
					method: "GET",
					header: {
						"authorization": uni.getStorageSync("token")
					},
					success: (res) => {
						if (res.data.code == 200) {
							this.newsList = res.data.list
							console.log(this.newsList)
						} else {
							console.log(this.data)
						}

					},
					fail: (err) => {
						console.log(err)
					}
				})
			}
		}
	}
</script>

<style lang="scss">
	.topic {
		padding: 20rpx;

		.navTitle {
			font-size: 40rpx;
			font-weight: 600;
		}
		
		.search{
			margin: 40rpx 0;
			display: flex;
			justify-content: center;
			align-items: center;
			position: relative;
			.searchInput{
				width: 90%;
				height: 80rpx;
				border: 1rpx solid gray;
				border-radius: 80rpx;
				padding-left: 100rpx;
			}
			
			.leftIcon{
				position: absolute;
				left:3%;
				width: 50rpx;
				height: 50rpx;
			}
			
			.rightIcon{
				position: absolute;
				right:3%;
				width: 50rpx;
				height: 50rpx;
			}
			
		}

		.newList {
			flex: 1;
			display: flex;
			flex-direction: column;

			.newItem {
				display: flex;
				flex-direction: row;
				margin: 50rpx 0;
			}

			.newRight {
				display: flex;
				flex-direction: column;
				justify-content: space-between;
				margin: 0 20rpx;
			}

			.newRightTop {
				font-size: 30rpx;
			}

			.newRightTitle {
				font-size: 35rpx;
			}

			.newRightBottom {
				display: flex;
				align-items: center;
				justify-content: space-around;

				image {
					border-radius: 50rpx;
					width: 50rpx;
					height: 50rpx;
				}

				.newRightBottomText {
					font-size: 10rpx;
					width: 70%;
					margin-left: 10rpx;
				}

				.newRightBottomTime {
					font-size: 10rpx;
				}
			}


			.newImg {
				width: 200rpx;
				height: 200rpx;
				border-radius: 10rpx;
				flex-shrink: 0;
			}
		}
	}
</style>