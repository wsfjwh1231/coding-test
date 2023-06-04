<template>
	<view class="topic">
		<view class="navTitle">Bookmark</view>
		<view class="search"></view>

		<view class="newList">
			<view class="newItem" v-for="item in newsList" @click="toNew">
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
				newsList: []
			}
		},
		onLoad() {
			this.onCollection()
		},
		methods: {
			onCollection() {
				uni.request({
					url: "http://101.34.49.100:3002/user/getUserCollection",
					method: "GET",
					header: {
						"authorization": uni.getStorageSync("token")
					},
					success: (res) => {
						if (res.data.code == 200) {
							this.newsList = res.data.list
							console.log(this.newsList)
						} else {
							uni.navigateTo({
								url: "/pages/my/login/login?code=" + res.data.code
							})
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
