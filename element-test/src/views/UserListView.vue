<template>
	<div class="userList">
		<div class="nav">
			<div class="leftNav">
				<i class="el-icon-tickets">数据列表</i>
			</div>
			<el-button>添加</el-button>
		</div>
		<div class="search">
			<el-input v-model="input" placeholder="请输入内容"></el-input>
			<el-button>搜索</el-button>
		</div>

		<el-table :data="tableData" style="width: 100%;margin-top: 20px;" border="1">
			<el-table-column label="编号" width="300">
				<template slot-scope="scope">
					<i class="el-icon-time"></i>
					<span style="margin-left: 10px">{{ scope.row.id }}</span>
				</template>
			</el-table-column>
			<el-table-column label="账户" width="300" >
				<template slot-scope="scope">
					<span style="margin-left: 10px">{{ scope.row.username }}</span>
				</template>
			</el-table-column>
			<el-table-column label="号码" width="200">
				<template slot-scope="scope">
					<span style="margin-left: 10px">{{ scope.row.phone }}</span>
				</template>
			</el-table-column>
			<el-table-column label="操作">
				<template slot-scope="scope">
					<el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
					<el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
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
				tableData: []
			}
		},
		mounted(){
			this.getUser()
		},
		methods:{
			getUser(){
				axios({
					url:"http://101.34.49.100:3001/user/userList",
					method:"GET"
				}).then(res => {
					console.log(res.data)
					this.tableData = res.data.list
				})
			}
		}
	}
</script>

<style lang="scss" scoped>
	.userList {
		.nav {
			padding: 10px;
			margin-top: 20px;
			border: 1px solid lightgray;
			display: flex;
			justify-content: space-between;
			align-items: center;
			font-size: 16px;
		}

		.search {
			margin-top: 20px;
			display: flex;
			width: 50%;
		}
	}
</style>
