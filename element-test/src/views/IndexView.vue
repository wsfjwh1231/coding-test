<template>
	<div class="page">
		<div class="numberNav">
			<div class="numberItem">
				<i class="el-icon-date"></i>
				<div class="numberItemtext">
					<div>
						今日订单数
					</div>
					<div class="">
						1
					</div>
				</div>
			</div>
			<div class="numberItem">
				<i class="el-icon-money" size="100px"></i>
				<div class="numberItemtext">
					<div>
						今日销售总额
					</div>
					<div class="">
						￥69
					</div>
				</div>
			</div>
			<div class="numberItem">
				<i class="el-icon-coin"></i>
				<div class="numberItemtext">
					<div>
						昨日销售总额
					</div>
					<div class="">
						￥404
					</div>
				</div>
			</div>
		</div>
	</div>

</template>

<script>
</script>

<style lang="scss" scoped>
	.page {
		
		.numberNav {
			display: flex;
			justify-content: space-around;
			
			.numberItem {
				border: 1px solid gray;
				padding: 20px;
				display: flex;
				align-items: center;
				margin:20px 0;
				
				i{
					font-size: 50px;
					color: #409eff;
				}
				.numberItemtext{
					margin-left: 10px;
					font-size: 20px;
				}
			}
		}

	}
</style>