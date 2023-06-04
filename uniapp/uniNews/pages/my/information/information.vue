<template>
	<view class="page">
			<view class="topNav"></view>
			<view class="explore">
				<view class="top">参赛证件</view>
				<view class="content">
					<image src="/static/logo.png" mode=""></image>
					<view class="userInfo">
						<view class="name">姓名</view>
						<view class="competition">第十三届全国大学生数学竞赛</view>
					</view>
				</view>
	
				<image src="https://img.xjishu.com/img/zl/2018/6/30/1241359458913.gif" mode="" class="qrCode"></image>
				<view class="describe">微信扫码了解更多信息</view>
			</view>
		</view>
</template>

<script>
	export default {
		data() {
			return {
				
			};
		}
	}
</script>

<style lang="scss">
.page {
		background-color:gray;
		padding: 10rpx;
		height: 95vh;
		.topNav{
			width: 100%;
			height: 5%;
		}
		.explore {
			height: 89vh;
			background-color: #467CF6;
			border-radius: 10rpx;
			// padding: 10rpx;
			display: flex;
			flex-direction: column;
			align-items: center;

			.top {
				text-align: center;
				font-size: 40rpx;
				margin: 50rpx 0;
			}

			.content {
				display: flex;
				flex-direction: column;
				align-items: center;
				

				image {
					width: 300rpx;
					height: 300rpx;
					border-radius: 300rpx;
					margin: 20rpx 0;
				}

				.userInfo {
					margin-top: -60rpx;
					.name {
						padding: 10rpx;
						text-align: center;
						font-size: 40rpx;
						width: 100%;
						color: white;
						background-color: blue;
						border-radius: 1em 1em 0 0;
						opacity:0.6;
						
					}

					.competition {
						padding: 10rpx;
						background-color: white;
						height: 70rpx;
						line-height: 70rpx;
						text-align: center;
						width: 100%;
						border-radius: 0 0 1em 1em;
						
					}
				}

			}

			.qrCode {
				width: 200rpx;
				height: 200rpx;
				margin: 100rpx 0 20rpx 0;
			}

			.describe {
				margin: 50rpx 0;
			}
		}
	}
</style>
