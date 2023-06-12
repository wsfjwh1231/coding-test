<template>
	<div class="userList">
		<div class="nav">
			<div class="leftNav">
				<i class="el-icon-tickets">数据列表</i>
			</div>
			<el-button>添加</el-button>
		</div>
		<div class="search">
			<el-input v-model="inputSearch" placeholder="请输入内容" @input="searchInput"></el-input>
			<el-button @click="searchBtn">搜索</el-button>
		</div>

		<el-table :data="tableData" style="width: 100%;margin-top: 20px;">
			<el-table-column label="编号" width="300">
				<template slot-scope="scope">
					<i class="el-icon-time"></i>
					<span style="margin-left: 10px">{{ scope.row.id }}</span>
				</template>
			</el-table-column>
			<el-table-column label="账户" width="300">
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
					<el-button size="mini" @click="updateBtn(scope.$index, scope.row)">编辑</el-button>
					<el-button size="mini" type="danger" @click="delBtn(scope.$index, scope.row)">删除</el-button>
				</template>
			</el-table-column>
		</el-table>

		<el-dialog title="编辑用户" :visible.sync="dialogFormVisible">
			<el-form :model="selectUserData">
				<el-form-item label="用户名" :label-width="formLabelWidth">
					<el-input v-model="selectUserData.username" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="手机号" :label-width="formLabelWidth">
					<el-input v-model="selectUserData.phone" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="密码" :label-width="formLabelWidth">
					<el-input v-model="selectUserData.password" autocomplete="off"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="dialogFormVisible = false">取 消</el-button>
				<el-button type="primary" @click="sendUpdate">确 定</el-button>
			</div>
		</el-dialog>
	</div>
</template>

<script>
	import axios from "axios"
	export default {
		data() {
			return {
				dialogFormVisible: false,
				// 展示数据
				tableData: [],
				selectUserData: {},
				inputSearch: "",
				formLabelWidth: '120px'
			}
		},
		mounted() {
			this.getUser()
		},
		methods: {
			getUser() {
				axios({
					url: "http://101.34.49.100:3001/user/userList",
					method: "GET"
				}).then(res => {
					console.log(res.data)
					this.tableData = res.data.list
				})
			},
			searchInput(data) {
				this.inputSearch = data
				console.log(this.inputSearch)
			},
			searchBtn() {
				axios({
					url: "http://101.34.49.100:3001/user/searchByUsername",
					method: "GET",
					params: {
						searchText: this.inputSearch
					}
				}).then(res => {
					console.log(res.data)
					if (res.data.code == 200) {
						this.tableData = res.data.list
						this.$message({
							message: "查询成功",
							type: "success"
						})
					} else {
						this.$message({
							message: res.data.msg,
							type: "error"
						})
					}
				})
			},
			updateBtn(index, row) {
				this.dialogFormVisible = true;
				console.log(index)
				console.log(row)
				this.selectUserData = row
			},
			sendUpdate() {
				axios({
					url: "http://101.34.49.100:3001/user/editUser",
					method: "PUT",
					data: {
						password: this.selectUserData.password,
						phone: this.selectUserData.mobile,
						userId: this.selectUserData.id,
						username: this.selectUserData.username
					}
				}).then(res => {
					console.log(res.data)
					if (res.data.code == 200) {
						this.dialogFormVisible = false
						this.$message({
							message: "修改成功",
							type: "success"
						})
						this.getUser()
					} else {
						this.$message({
							message: res.data.msg,
							type: "error"
						})
					}
				})
			},
			delBtn(index, row) {
				this.$confirm("您确定要删除用户吗?", "提示", {
					confirmButtonText: "确定",
					cancelButtonText: "取消",
					type: "warning"
				}).then(res => {
					// 调用删除的接口,实现删除的功能
					axios({
							url: "http://127.0.0.1:9998/user/" + userInfo.id,
							method: "delete"
						})
						.then(res => {
							if (res.data.code == 200) {
								// 刷新页面数据
								this.getUserList();
								this.$message({
									type: "success",
									message: "用户删除成功！"
								});
							}
						})
						.catch(() => {});
				});
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
