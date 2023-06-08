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
						{{orderInfo.today_orders}}
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
						￥{{orderInfo.today_total_amount}}
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
						￥{{orderInfo.yester_total_amount}}
					</div>
				</div>
			</div>
		</div>
		
		<div class="toDo">
			<div class="top">待处理事务</div>
			<div class="toDoList">
				<div class="toDoItem">
					<div class="toDoText">已取消订单</div>
					<div class="toDoNum">(0)</div>
				</div>
				<div class="toDoItem">
					<div class="toDoText">待付款订单</div>
					<div class="toDoNum">(0)</div>
				</div>
				<div class="toDoItem">
					<div class="toDoText">待发货订单</div>
					<div class="toDoNum">(0)</div>
				</div>
				<div class="toDoItem">
					<div class="toDoText">待确认收获订单</div>
					<div class="toDoNum">(0)</div>
				</div>
				<div class="toDoItem">
					<div class="toDoText">待评价订单</div>
					<div class="toDoNum">(0)</div>
				</div>
				<div class="toDoItem">
					<div class="toDoText">已完成订单</div>
					<div class="toDoNum">(0)</div>
				</div>
			</div>
		</div>
	</div>

</template>

<script>
	import axios from "axios";
	export default {
		data() {
			return {
				orderInfo:{},
			}
		},
		mounted() {
			this.getHomeData()
		},
		methods:{
			getHomeData(){
				axios({
					url:"http://101.34.49.100:3001/home/home_data",
					method:"GET"
				}).then(res => {
					console.log(res.data)
					if(res.data.code == 200){
						this.orderInfo = res.data.orderInfo
						console.log(this.orderInfo)
					}else{
						console.log(res.data)
					}
				})
			}
		}
	}
</script>

<style lang="scss" scoped>
	.page {
		display: flex;
		flex-direction: column;
		align-items: center;
		.numberNav {
			// background-color: red;
			display: flex;
			justify-content: space-between;
			width: 1000px;

			.numberItem {
				border: 1px solid gray;
				padding: 20px;
				display: flex;
				align-items: center;
				margin: 20px 0;

				i {
					font-size: 50px;
					color: #409eff;
				}

				.numberItemtext {
					margin-left: 10px;
					font-size: 20px;
				}
				
			}
		}
		
		.toDo{
			// background-color: red;
			width: 1000px;
			
			.top{
				font-size: 20px;
				border-bottom: 1px solid gray;
				padding: 5px 0;
			}
			
			.toDoList{
				display: flex;
				justify-content: space-between;
				text-align: center;
				flex-wrap: wrap;
				margin-top: 10px;
				.toDoItem{
					
					display: flex;
					justify-content: space-between;
					width: 280px;
					font-size: 15px;
					border-bottom: 1px solid gray;
					padding: 15px;
					.toDoText{
						margin-right: 100px;
					}
				}
			}
		}

	}
</style>
