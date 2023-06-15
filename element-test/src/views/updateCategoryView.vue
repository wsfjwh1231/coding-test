<template>
	<div class="page">
		<el-form :model="tableData"  label-width="100px" class="demo-ruleForm">
		  <el-form-item label="分类名称" >
		    <el-input v-model="tableData.catName" style="width: 30%;"></el-input>
		  </el-form-item>
		  <el-form-item label="上级分类" >
		    <el-select v-model="selectItem" placeholder="请选择上级分类">
				<el-option label="无上级分类" :value="100" :key="100"></el-option>
		      <el-option :label="item.catName" :value="item.catId" v-for="(item,index) in selectData" :key="item.catId"></el-option>
		    </el-select>
		  </el-form-item>
		  <!-- <el-form-item label="分类图" >
		    <el-select v-model="tableData.region" placeholder="请选择活动区域">
		      <el-option label="区域一" value="shanghai"></el-option>
		      <el-option label="区域二" value="beijing"></el-option>
		    </el-select>
		  </el-form-item> -->
		  <el-form-item>
		    <el-button type="primary" @click="editBtn()">提交</el-button>
		  </el-form-item>
		</el-form>
	</div>
</template>

<script>
import axios from "axios"
	export default {
		name:"updateCategoryView",
		data() {
			return {
				title:"",
				tableData:{},
				selectData:[],
				selectItem:100
			}
		},
		mounted() {
			this.getTableData();
			// 查询一级分类数据
			this.getCategoryLevelOneList()
		},
		methods:{
			// 查询一级分类数据
			getCategoryLevelOneList() {
				axios({
					url: "http://101.34.49.100:3001/categoryLevelOneList",
					method: "GET"
				}).then(res => {
					console.log(res.data)
					this.selectData = res.data.list
					// for (var i = 0; i < res.data.list.length; i++) {
					// 	this.selectData.push(res.data.list[i].catName)
					// }
					
					// this.selectData.unshift("无上级分类")
					console.log(this.selectData)
				})
			},
			// 获取上一界面传过来的数据
			getTableData(){
				this.tableData = JSON.parse(localStorage.getItem("categoryData"))
				
				if (this.tableData.catLevel == 1) {
					this.selectItem = 100
				} else{
					this.selectItem = this.tableData.catId
				}
				console.log(this.tableData)
			},
			editBtn(){
				
				axios({
					url:"http://101.34.49.100:3001/editCategory",
					method:"POST",
					data:{
						catId: this.tableData.catId,
						catLevel:this.tableData.catLevel,
						category_id:this.tableData.category_id,
						catName:this.tableData.catName,
						file:""
					}
				}).then(res => {
					console.log(res.data)
					if (res.data.code == 200) {
						console.log(res.data)
						// 修改完毕后删除上一界面传来的数据.
						// localStorage.removeItem("categoryData")
					} else{
						console.log(res.data)
					}
					
				})
			},
			submitForm(){
				
			}
		}
	}
</script>

<style lang="scss" scoped>
	.page{
		padding: 100px 0 0 250px;
	}
</style>