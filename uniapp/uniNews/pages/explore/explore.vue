<template>
	<view class="page">explore</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		onLoad() {
			const token = uni.getStorageSync("token")
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
		},
		methods: {

		}
	}
</script>

<style lang="scss">
	
</style>
