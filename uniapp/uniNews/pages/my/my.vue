<template>
	<view class="personage">
		<view class="top">
			<view>Profile</view>
			<image src="../../static/Vector.png" mode=""></image>
		</view>
		<view class="infoTop">
			<image :src="user.avatar" mode=""></image>
			<view class="infoTopRight">
				<view class="infoTopRightNum">2156</view>
				<view class="infoTopRightText">Followers</view>
			</view>
			<view class="infoTopRight">
				<view class="infoTopRightNum">567</view>
				<view class="infoTopRightText">Following</view>
			</view>
			<view class="infoTopRight">
				<view class="infoTopRightNum">23</view>
				<view class="infoTopRightText">News</view>
			</view>
		</view>
		<view class="infoMiddle">
			<view class="infoMiddleTop">{{user.username}}</view>
			<view class="infoMiddleBotton">{{user.introduction}}</view>
		</view>
		<view class="infoEdit">
			<button type="primary">Edit profile</button>
			<button type="primary">Website</button>
		</view>

		<view class="infoBottomTop">
			<view :class="btnSelect==1?'viewSelect':''">News</view>
			<view :class="btnSelect==2?'viewSelect':''">Recent</view>
		</view>
		<view class="infoBottom">
			<view class="infoBottomList">
				<view class="infoBottomItem">
					<image src="../../static/logo.png" mode=""></image>
					<view class="infoBottomItemRight">
						<view class="infoBottomItemRightTop">NFTs</view>
						<view class="infoBottomItemRightMiddle">Minting Your First NFT:A Beginner's Guide to
							Creating...............................</view>
						<view class="infoBottomItemRightBottom">
							<view class="infoBottomItemRightBottomLeft">
								<image src="../../static/my.png" mode=""></image>
								<view>xxxxxxxx</view>
							</view>
							<view class="infoBottomItemRightBottomRight">
								<image src="../../static/Time.png" mode=""></image>
								<view>xxxxxxxx</view>
							</view>

						</view>
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
				btnSelect:1,
				user:{}
			}
		},
		onLoad() {
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
		methods: {}
	}
</script>

<style lang="scss">
	.personage {
		padding: 50rpx;

		.top {
			position: relative;
			display: flex;
			justify-content: center;

			&>view {
				font-size: 30rpx;
			}

			&>image {
				width: 40rpx;
				height: 40rpx;
				position: absolute;
				right: 0;
			}
		}

		.infoTop {
			margin-top: 50rpx;
			display: flex;
			justify-content: space-between;
			align-items: center;

			&>image {
				width: 120rpx;
				height: 120rpx;
				border-radius: 80rpx;
			}

			.infoTopRight {
				display: flex;
				flex-direction: column;
				align-items: center;

				.infoTopRightText {
					margin-top: 10rpx;
					color: gray;
				}
			}

		}

		.infoMiddle {
			margin-top: 30rpx;

			.infoMiddleTop {
				font-size: 30rpx;
				font-weight: 600;
			}

			.infoMiddleBotton {
				margin-top: 20rpx;
				font-size: 25rpx;
			}
		}

		.infoEdit {
			margin-top: 30rpx;
			display: flex;
			justify-content: space-between;

			button {
				width: 45%;
				margin-left: 0;
				margin-right: 0;
			}
		}

		.infoBottomTop {
			margin-top: 30rpx;
			font-size: 30rpx;
			color: gray;
			display: flex;
			justify-content: center;

			view {
				margin: 10rpx;

			}

			.viewSelect {
				color: black;
			}


		}

		.infoBottom {
			.infoBottomList {
				.infoBottomItem {
					margin-top: 30rpx;
					display: flex;

					&>image {
						width: 300rpx;
						height: 200rpx;
						border-radius: 15rpx;
						margin-right: 10rpx;
					}

					.infoBottomItemRight {
						display: flex;
						flex-direction: column;
						justify-content: space-between;

						.infoBottomItemRightTop {
							font-size: 22rpx;
							color: gray;
						}

						.infoBottomItemRightBottom {
							display: flex;
							align-items: center;

							.infoBottomItemRightBottomLeft {
								display: flex;
								align-items: center;
								margin-right: 20rpx;

								&>image {
									width: 50rpx;
									height: 50rpx;
								}
							}

							.infoBottomItemRightBottomRight {
								display: flex;
								align-items: center;

								&>image {
									width: 30rpx;
									height: 30rpx;
								}
							}
						}
					}
				}
			}
		}

	}
</style>