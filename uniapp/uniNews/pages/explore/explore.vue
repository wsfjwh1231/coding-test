<template>
	<view class="page">explore</view>
</template>

<script>
	export default {
		data() {
			return {
				time:""
			}
		},
		onLoad() {
			let token = uni.getStorageSync("token")
			if (token != '') {
				console.log(token)
				uni.switchTab({
					url: "/pages/my/my"
				})
			} else {
				uni.navigateTo({
					url: "/pages/my/login/login"
				})
			}
			
			this.getTime();
		},
		methods: {
			getTime(){
				let date = new Date();
				console.log(date);
			}
		}
	}
</script>

<style lang="scss">
	
</style>
