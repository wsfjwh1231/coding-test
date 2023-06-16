<template>
	<div class="page">
		Layout 布局	
		<el-row>
		  <el-col :span="24"><div class="grid-content bg-purple-dark"></div></el-col>
		</el-row>
		<el-row>
		  <el-col :span="12"><div class="grid-content bg-purple"></div></el-col>
		  <el-col :span="12"><div class="grid-content bg-purple-light"></div></el-col>
		</el-row>
		<el-row>
		  <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
		  <el-col :span="8"><div class="grid-content bg-purple-light"></div></el-col>
		  <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
		</el-row>
		<el-row :gutter="20">
		  <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
		  <el-col :span="6" :offset="6"><div class="grid-content bg-purple-light"></div></el-col>
		  <!-- <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
		  <el-col :span="6"><div class="grid-content bg-purple-light"></div></el-col> -->
		</el-row>
		<el-row :gutter="20">
		  <el-col :span="4"><div class="grid-content bg-purple"></div></el-col>
		  <el-col :span="4"><div class="grid-content bg-purple-light"></div></el-col>
		  <el-col :span="4"><div class="grid-content bg-purple"></div></el-col>
		  <el-col :span="4"><div class="grid-content bg-purple-light"></div></el-col>
		  <el-col :span="4"><div class="grid-content bg-purple"></div></el-col>
		  <el-col :span="4"><div class="grid-content bg-purple-light"></div></el-col>
		</el-row>
		
		
		<el-row type="flex" justify="space-between">
		  <el-col :span="6"><div class="grid-content bg-purple"></div></el-col>
		  <el-col :span="6"><div class="grid-content bg-purple-light"></div></el-col>
		</el-row>
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
			
		},
		methods: {
			getBar() {
				
			},
			getDoughnutChart() {
				
			}


		}
	}
</script>

<style lang="scss" scoped>
	.page {
		.el-row {
		    margin-bottom: 20px;
		    &:last-child {
		      margin-bottom: 0;
		    }
		  }
		  .el-col {
		    border-radius: 4px;
		  }
		  .bg-purple-dark {
		    background: #99a9bf;
		  }
		  .bg-purple {
		    background: #d3dce6;
		  }
		  .bg-purple-light {
		    background: #e5e9f2;
			// box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
		  }
		  .grid-content {
		    border-radius: 4px;
		    min-height: 36px;
		  }
		  .row-bg {
		    padding: 10px 0;
		    background-color: #f9fafc;
		  }
		
	}
</style>