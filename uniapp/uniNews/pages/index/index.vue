<template>
	<view class="content">
		<view class="top">
			<image src="../../static/news/logo.png" class="top-left" mode=""></image>
			<image src="../../static/news/notic.png" class="top-right" mode=""></image>
		</view>

		<view class="newClassList">
			<scroll-view scroll-x="true" class="nav">
				<text :class="['newClassItem',index == selectIndex?'newClassListSelect':'']"
					v-for="(item,index) in newClassList" :key="item.id" @click="selectNews(item,index)">{{item.name}}
				</text>
			</scroll-view>
		</view>

		<view class="newList">
			<view class="newItem" v-for="item in newList">
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
				title: 'Hello',
				newClassList: [],
				newList: [],
				selectIndex: 0
			}
		},
		onLoad() {
			//查询分类
			uni.request({
				url: 'http://101.34.49.100:3002/classify', //仅为示例，并非真实接口地址。
				method: "GET",
				success: (res) => {
					this.newClassList = res.data.list;
					this.newClassList.unshift({
						id: 0,
						name: "全部",
						description: null
					});
					console.log(this.newClassList);
				}
			});

			//显示全部新闻
			uni.request({
				url: 'http://101.34.49.100:3002/news', //仅为示例，并非真实接口地址。
				method: "GET",
				success: (res) => {
					this.newList = res.data.list;
					console.log(res.data.list);
				}
			});
		},
		methods: {
			// 选择新闻
			selectNews(item, index) {
				console.log(item.id, "item")
				console.log(index, "index")
				this.selectIndex = index

				if (item.id == 0) {
					uni.request({
						url: 'http://101.34.49.100:3002/news', //仅为示例，并非真实接口地址。
						method: "GET",
						success: (res) => {
							this.newList = res.data.list;
							console.log(res.data.list);
						}
					});
				} else {
					uni.request({
						url: 'http://101.34.49.100:3002/news', //仅为示例，并非真实接口地址。
						method: "GET",
						data: {
							id: item.id
						},
						success: (res) => {
							this.newList = res.data.list
							console.log(res.data.list);
						}
					});
				}


			}
		}
	}
</script>

<style lang="scss">
	.top {
		width: 100%;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
	}

	.top-left {
		width: 150rpx;
		height: 50rpx;
		margin: 20rpx 20rpx;
	}

	.newClassList {
		margin-top: 20rpx;
		width: 100%;
		display: flex;
		justify-content: space-around;
	}

	.newClassListSelect {
		font-weight: 600;
		border-bottom: 3px solid blue;
	}

	.top-right {
		width: 50rpx;
		height: 50rpx;
		margin: 20rpx 20rpx;
	}

	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		margin: 10px 20px;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}

	.newList {
		flex: 1;
		display: flex;
		flex-direction: column;
	}

	.newItem {
		display: flex;
		flex-direction: row;
		margin: 50rpx 20rpx;
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
		font-size: 40rpx;
	}

	.newImg {
		width: 300rpx;
		height: 300rpx;
		flex-shrink: 0;
	}

	.newRightBottom {
		display: flex;
		align-items: center;
		justify-content: space-around;
	}

	.newRightBottom image {
		border-radius: 50rpx;
		width: 50rpx;
		height: 50rpx;
	}

	.newRightBottomText {
		font-size: 10rpx;
		width: 70%;
		margin-left: 10rpx;
	}

	.newClassItem {
		margin-right: 10px;
		padding-bottom: 5px;
		font-size: 80rpx;
	}

	.nav {
		white-space: nowrap;
		text-align: center;
		width: 100%;
		height:180rpx;

		::-webkit-scrollbar {
			height: 0;
		}
		
		
	}
</style>