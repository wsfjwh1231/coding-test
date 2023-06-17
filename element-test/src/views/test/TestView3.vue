<template>
	<div class="page">
		<!-- 计算数器 -->
		<el-input-number v-model="num" @change="handleChange" :min="1" :max="10" label="描述文字"
			:disabled="false"></el-input-number>

		<br />
		<br />
		<!-- 选择器 -->
		<el-switch v-model="value1" active-text="按月付费" inactive-text="按年付费" @change="selectItem">
		</el-switch>
		<br />
		<br />
		<div class="block">
			<span class="demonstration">自定义初始值</span>
			<el-slider v-model="value2" style="width: 40%;" @change="selectItem"></el-slider>
		</div>
		<br />
		<br />
		<el-time-select v-model="value" :picker-options="{
		    start: '08:30',
		    step: '00:15',
		    end: '18:30'
		  }" placeholder="选择时间" @change="selectItem">
		</el-time-select>
		<br />
		<br />
		<el-time-picker v-model="value3" :picker-options="{
		      selectableRange: '18:30:00 - 20:30:00'
		    }" placeholder="任意时间点"
			@change="selectItem">
		</el-time-picker>
		<br />
		<br />
		<el-badge :value="value2" :max="20" class="item" type="primary">
		  <el-button size="small">评论</el-button>
		</el-badge>
		<el-empty description="描述文字"></el-empty>
		<el-progress type="circle" :percentage="75"></el-progress>
	</div>
</template>

<script>
	import axios from "axios"
	export default {
		data() {
			return {
				num: 1,
				value: "",
				value1: false,
				value2: 50,
				value3: "new Date(2016, 9, 10, 18, 40)"
			}
		},
		methods: {
			handleChange(value) {
				console.log(value);
			},
			selectItem() {
				console.log(this.value3)
			}
		}
	}
</script>

<style lang="scss" scoped>
	.page {}
</style>