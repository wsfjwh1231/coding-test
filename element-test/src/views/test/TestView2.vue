<template>
	<div class="page">
		<el-radio-group v-model="radio" @input="test">
			<el-radio :label="3">备选项</el-radio>
			<el-radio :label="6">备选项</el-radio>
			<el-radio :label="9">备选项</el-radio>
		</el-radio-group>
		<br />
		<br />
		<el-link href="https://element.eleme.io" target="_blank" :underline="false">默认链接</el-link>
		<el-link type="primary">主要链接</el-link>
		<el-link type="success">成功链接</el-link>

		<br />
		<!-- 带文字图标 -->
		<el-link icon="el-icon-edit">编辑</el-link>
		<br />
		<el-link>查看<i class="el-icon-view el-icon--right"></i> </el-link>

		<br />
		<div>
			<el-radio-group v-model="radio1" @input="test">
				<el-radio-button label="上海"></el-radio-button>
				<el-radio-button label="北京"></el-radio-button>
				<el-radio-button label="广州"></el-radio-button>
				<el-radio-button label="深圳"></el-radio-button>
			</el-radio-group>
		</div>
		<div>
			<el-radio v-model="radio1" label="1" border>备选项1</el-radio>
			<el-radio v-model="radio1" label="2" border>备选项2</el-radio>
		</div>
		<br />
		<el-checkbox v-model="checked">备选项</el-checkbox>
		<br />
		<br />
		<el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
		<div style="margin: 15px 0;"></div>
		<el-checkbox-group v-model="checkedCities" @change="handleCheckedCitiesChange">
			<el-checkbox v-for="city in cities" :label="city" :key="city">{{city}}</el-checkbox>
		</el-checkbox-group>
		<br />
		<br />

		<!-- 可选项目数量的限制 -->
		<el-checkbox-group v-model="checkedCities" :min="1" :max="2">
			<el-checkbox v-for="city in cities" :label="city" :key="city">{{city}}</el-checkbox>
		</el-checkbox-group>

		<!-- 多选框按钮样式 -->
		<div style="margin-top: 20px">
			<el-checkbox-group v-model="checkboxGroup2" size="medium" @change="handleCheckedCitiesChange">
				<el-checkbox-button v-for="city in cities" :label="city" :key="city">{{city}}</el-checkbox-button>
			</el-checkbox-group>
		</div>

		<br />
		<br />

		<!-- 输入框 -->
		<el-input placeholder="请输入内容" v-model="input" clearable @input="test" show-password style="width: 10%;">
		</el-input>

		<br />
		<br />

		<el-input type="textarea" :rows="2" placeholder="请输入内容" v-model="textarea" style="width: 30%;">
		</el-input>

		<br />
		<br />

		<el-input type="textarea" autosize placeholder="请输入内容" v-model="textarea1" maxlength="10" show-word-limit
			style="width: 30%;">
		</el-input>
		<div style="margin: 20px 0;"></div>
		<el-input type="textarea" :autosize="{ minRows: 2, maxRows: 4}" maxlength="30" show-word-limit
			placeholder="请输入内容" v-model="textarea2" style="width: 30%;">
		</el-input>

		<br />
		<br />
		<div style="margin-top: 15px;">
			<el-input placeholder="请输入内容" v-model="input3" class="input-with-select" style="width: 40%;">
				<!-- <el-select v-model="select" slot="prepend" placeholder="请选择">
		      <el-option label="餐厅名" value="1"></el-option>
		      <el-option label="订单号" value="2"></el-option>
		      <el-option label="用户电话" value="3"></el-option>
		    </el-select> -->
				<el-button slot="append" icon="el-icon-search" @click="searchBtn"></el-button>
			</el-input>
		</div>

		<br />
		<br />
		<!-- 远程搜索 -->
		<el-autocomplete v-model="state" :fetch-suggestions="querySearchAsync" placeholder="请输入远程搜索内容"
			@select="handleSelect" style="width: 30%;"></el-autocomplete>
	</div>
</template>

<script>
	import axios from "axios"
	const cityOptions = ['上海', '北京', '广州', '深圳'];
	export default {
		data() {
			return {
				radio: 6,
				radio1: '上海',
				radio2: '上海',
				radio3: '上海',
				radio4: '上海',


				checked: false,

				// 多选框部分
				checkAll: false,
				checkedCities: ['上海', '北京'],
				cities: cityOptions,
				isIndeterminate: true,

				// 多选框按钮样式
				checkboxGroup1: ['上海'],
				checkboxGroup2: ['上海'],
				checkboxGroup3: ['上海'],
				checkboxGroup4: ['上海'],

				// 输入框
				input: "",
				textarea: "",
				textarea1: '',
				textarea2: '',
				input3: "",

				//网络提示框
				restaurants: [],
				state: '',
				timeout: null
			}
		},
		mounted() {
			this.loadAll();
		},
		methods: {
			test(radio) {
				console.log(radio)
			},
			searchBtn() {
				console.log(this.input3)
			},


			handleCheckAllChange(val) {
				// 当判断勾选了全选框后，把checkedCities的值更改为全选状态，如果取消勾选，则把checkedCities的值变为空数组
				this.checkedCities = val ? cityOptions : [];
				this.isIndeterminate = false;
			},
			handleCheckedCitiesChange(value) {
				console.log(value)
				let checkedCount = value.length;
				// 当checkedCities的数组长度等于全选的长度，则checkAll为true;当全未选时候，则checkAll为false
				this.checkAll = checkedCount === this.cities.length;
				// 当checkedCount的数组长度大于零 和 checkedCount 小于全选的数组长度，则isIndeterminate为true
				this.isIndeterminate = checkedCount > 0 && checkedCount < this.cities.length;
			},


			// -------------------------------------------------------------------------------------------------------------------------------------------
			// 查询用户列表
			loadAll() {
				axios({
					url: "http://101.34.49.100:3001/user/userList",
					method: "GET"
				}).then(res => {
					console.log(res.data)
					this.restaurants = res.data.list
				})
			},
			querySearchAsync(queryString, cb) {
				console.log(queryString)

				axios({
					url: 'http://101.34.49.100:3001/user/searchByUsername?searchText=' + queryString,
					method:"GET"
				}).then(res =>{
					console.log(res.data)
					// 将搜索结果存储到 restaurants 数组中
					this.restaurants = res.data.list;
					console.log(this.restaurants)
					// 调用回调函数，将搜索结果传递给 <el-autocomplete>
					cb(this.restaurants);
				})

			},
			createStateFilter(queryString) {
				console.log(state)
				return (state) => {
					return (state.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
				};
			},
			// 查询选择后的结果对象，包含店名和地址
			handleSelect(item) {
				console.log(item);
			}


		}
	}
</script>

<style lang="scss" scoped>
	.page {}
</style>