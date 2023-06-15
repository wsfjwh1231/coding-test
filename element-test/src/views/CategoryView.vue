<template>
	<div class="category">
		<div class="nav">
			<div class="leftNav">
				<i class="el-icon-tickets">数据列表</i>
			</div>
			<el-button @click="toAddPage">添加</el-button>
		</div>
		<el-table :data="tableData" style="width: 100%" border="">
			<el-table-column label="编号" width="200">
				<template slot-scope="scope">
					<span style="margin-left: 10px">{{ scope.row.catLevel }}</span>
				</template>
			</el-table-column>
			<el-table-column label="分类名称" width="1000">
				<template slot-scope="scope">
					<!-- 注意 这里的collapseVisible变量控制组件的展开与隐蔽 类型为string 而非Boolean-->
					<el-collapse v-model="collapseVisible" @change="getCategoryLevelTwoList(scope.row.catId)">
						<el-collapse-item :title="scope.row.catName" :name="scope.row.catId">
							
							 <el-table
							    :data="table2Data"
							    style="width: 100%"
								border="">
							    <el-table-column
							      label="编号"
							      width="180">
							      <template slot-scope="scope">
							        <span style="margin-left: 10px">{{ scope.row.catId }}</span>
							      </template>
							    </el-table-column>
							    <el-table-column
							      label="名称"
							      width="180">
							      <template slot-scope="scope">
									  <span style="margin-left: 10px">{{ scope.row.catName }}</span>
							      </template>
							    </el-table-column>
								<el-table-column
								  label="分类级别"
								  width="180">
								  <template slot-scope="scope">
									  <span style="margin-left: 10px">{{ scope.row.catLevel }}</span>
								  </template>
								</el-table-column>
							    <el-table-column label="操作">
							      <template slot-scope="scope">
							        <el-button
							          size="mini"
							          @click="handleEditTwo(scope.$index, scope.row)">编辑</el-button>
							        <el-button
							          size="mini"
							          type="danger"
							          @click="handleDeleteTwo(scope.$index, scope.row)">删除</el-button>
							      </template>
							    </el-table-column>
							  </el-table>
							
							
						</el-collapse-item>
					</el-collapse>
				</template>
			</el-table-column>
			<el-table-column label="分类级别" width="200">
				<template slot-scope="scope">
					<span style="margin-left: 10px">{{ scope.row.catLevel }}</span>
				</template>
			</el-table-column>
			<el-table-column label="操作" width="200">
				<template slot-scope="scope">
					<el-button size="mini" @click="handleEditOne(scope.$index, scope.row)">编辑</el-button>
					<el-button size="mini" type="danger" @click="handleDeleteOne(scope.$index, scope.row)">删除</el-button>
				</template>
			</el-table-column>
		</el-table>
	</div>
</template>

<script>
	import axios from "axios"
	export default {
		name:"CategoryView",
		data() {
			return {
				tableData: [],
				table2Data:[],
				collapseVisible:"false"
			}
		},
		mounted() {
			// 查询一级分类数据
			this.getCategoryLevelOneList()
		},
		methods: {
			// 查询一级分类数据
			getCategoryLevelOneList() {
				axios({
					url: "http://101.34.49.100:3001/categoryLevelOneList",
					method: "GET"
				}).then(res => {
					console.log(res.data)
					this.tableData = res.data.list
				})
			},
			// 查询二级分类数据
			getCategoryLevelTwoList(id){
				this.collapseVisible = "true";
				axios({
					url:"http://101.34.49.100:3001/categoryLevelTwoList?category_id="+id,
					method:"GET"
				}).then(res => {
					console.log(res.data)
					this.table2Data = res.data.list
				})
			},
			toAddPage(){
				// 跳转新增分类界面
				this.$router.push("/addCategory")
			},
			handleEditOne(index,row){
				// 跳转分类修改界面
				// 跳转分类修改界面
				localStorage.setItem("categoryData",JSON.stringify(row))
				this.$router.push("/updateCategory")
			},
			handleDeleteOne(index,row){
				// 跳转分类删除界面
			},
			handleEditTwo(index,row){
				// 跳转分类修改界面
				localStorage.setItem("categoryData",JSON.stringify(row))
				this.$router.push("/updateCategory")
				
			},
			handleDeleteTwo(index,row){
				// 分类删除
			}
		}

	}
</script>

<style lang="scss" scoped>
	.category {
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