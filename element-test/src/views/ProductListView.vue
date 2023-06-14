<template>
	<div class="product">
		<div class="nav">
			<div class="leftNav">
				<i class="el-icon-tickets">数据列表</i>
			</div>
			<el-button @click="toAddPage">添加</el-button>
		</div>
		<el-table :data="productList" style="width: 100%;margin-top: 20px;">
			<el-table-column label="编号" width="200">
				<template slot-scope="scope">
					<i class="el-icon-time"></i>
					<span style="margin-left: 10px">{{ scope.row.id }}</span>
				</template>
			</el-table-column>
			<el-table-column label="商品图片" width="200">
				<template slot-scope="scope">
					<el-image style="width: 100px; height: 100px"
						src="https://upload.jianshu.io/users/upload_avatars/13762297/80740476-43b5-415f-a911-56c4d6255036.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240"
						fit="fill"></el-image>
				</template>
			</el-table-column>
			<el-table-column label="商品名称" width="300">
				<template slot-scope="scope">
					<span style="margin-left: 10px">{{ scope.row.name }}</span>
				</template>
			</el-table-column>
			<el-table-column label="价格" width="200">
				<template slot-scope="scope">
					<span style="margin-left: 10px">{{ scope.row.price }}</span>
				</template>
			</el-table-column>
			<el-table-column label="规格" width="200">
				<template slot-scope="scope">
					<span style="margin-left: 10px">515</span>
				</template>
			</el-table-column>
			<el-table-column label="库存" width="200">
				<template slot-scope="scope">
					<span style="margin-left: 10px">{{ scope.row.inventory }}</span>
				</template>
			</el-table-column>
			<el-table-column label="销量" width="200">
				<template slot-scope="scope">
					<span style="margin-left: 10px">{{ scope.row.sales }}</span>
				</template>
			</el-table-column>
			<el-table-column label="操作">
				<template slot-scope="scope">
					<el-button size="mini" @click="toUpdatePage(scope.$index, scope.row)">编辑</el-button>
					<el-button size="mini" type="danger" @click="delBtn(scope.$index, scope.row)">删除</el-button>
				</template>
			</el-table-column>
		</el-table>
		
	</div>
</template>

<script>
	import axios from "axios"
	export default {
		data() {
			return {
				showAddProduct:false,
				productList: [],
				addProductData:{},
				formLabelWidth:"120px"
			}
		},
		mounted() {
			this.getproduct()
		},
		methods: {
			getproduct() {
				axios({
					url: "http://101.34.49.100:3001/product/productList",
					method: "GET"
				}).then(res => {
					if (res.data.code == 200) {
						console.log(res.data)
						this.productList = res.data.list
						// this.$message({
						// 	message:"请求成功",
						// 	type:"success"
						// })
					} else {
						console.log(res.data)
					}

				})
			},
			// 跳转到添加界面
			toAddPage(){
				this.$router.push("/addProductList")
			},
			// 跳转到编辑界面
			toUpdatePage(index,row){
				localStorage.setItem("productList",JSON.stringify(row));
				this.$router.push("/updateProductList")
			},
			// 删除按钮
			delBtn(index, row) {

			}
		}
	}
</script>

<style lang="scss" scoped>
	.product {
		.nav {
			padding: 10px;
			margin-top: 20px;
			border: 1px solid lightgray;
			display: flex;
			justify-content: space-between;
			align-items: center;
			font-size: 16px;
		}
	}
</style>