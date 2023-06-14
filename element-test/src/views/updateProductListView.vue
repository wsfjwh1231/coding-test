<template>
	<div class="updatePage">
		<div class="nav">
			<div class="leftNav">
				<span>编辑商品</span>
			</div>
		</div>
	</div>
</template>

<script>
	import axios from "axios"
	export default {
		data() {
			return {
				
			}
		},
		mounted() {
			// 使用完毕之后，记得删除localStorage
			console.log(JSON.parse(localStorage.getItem("productList")))
		},
		methods:{
			
		}
	}
</script>

<style lang="scss" scoped>
	.updatePage{
		.nav {
			padding: 20px;
			margin-top: 20px;
			border: 1px solid lightgray;
			display: flex;
			justify-content: space-between;
			align-items: center;
			font-size: 16px;
		}
	}
</style>