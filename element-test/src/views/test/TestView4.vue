<template>
	<div class="page">
		<!-- 轮播图 -->
		<div class="carousel">
			<el-carousel :interval="2000" type="card" height="200px" arrow="hover">
				<el-carousel-item v-for="(item,index) in images" :key="index">
					<img :src="item.url" alt="轮播图">
				</el-carousel-item>
			</el-carousel>
		</div>

		<el-time-select
		  v-model="value"
		  :picker-options="{
		    start: '08:30',
		    step: '00:15',
		    end: '18:30'
		  }"
		  placeholder="选择时间"
		  @change="selectTime">
		</el-time-select>
		
		<br />
		<br />
		<!-- ---------------------------------------------------多选框-------------------------------------------------------- -->
		
		  <el-checkbox :indeterminate="isIndeterminate" v-model="checkAll" @change="handleCheckAllChange">全选</el-checkbox>
		  <div style="margin: 15px 0;"></div>
		  <el-checkbox-group v-model="checkedCities" @change="handleCheckedCitiesChange">
		    <el-checkbox v-for="city in cities" :label="city" :key="city">{{city}}</el-checkbox>
		  </el-checkbox-group>
	</div>
</template>

<script>
	import axios from "axios"
	const cityOptions = ['上海', '北京', '广州', '深圳'];
	export default {
		data() {
			return {
				images: [{
						url: "https://img.alicdn.com/imgextra/i2/6000000002648/O1CN01Tb94w11VQpdGeg2do_!!6000000002648-0-octopus.jpg",
						name: "图片1"
					},
					{
						url: "https://img.alicdn.com/imgextra/i2/6000000002648/O1CN01Tb94w11VQpdGeg2do_!!6000000002648-0-octopus.jpg",
						name: "图片2"
					},
					{
						url: "https://img.alicdn.com/imgextra/i2/6000000002648/O1CN01Tb94w11VQpdGeg2do_!!6000000002648-0-octopus.jpg",
						name: "图片3"
					},
					{
						url: "https://img.alicdn.com/imgextra/i2/6000000002648/O1CN01Tb94w11VQpdGeg2do_!!6000000002648-0-octopus.jpg",
						name: "图片4"
					},
					{
						url: "https://img.alicdn.com/imgextra/i2/6000000002648/O1CN01Tb94w11VQpdGeg2do_!!6000000002648-0-octopus.jpg",
						name: "图片5"
					}
				],
				activeName: '1',


				activities: [{
					content: '支持使用图标',
					timestamp: '2018-04-12 20:46',
					size: 'large',
					type: 'primary',
					icon: 'el-icon-more'
				}, {
					content: '支持自定义颜色',
					timestamp: '2018-04-03 20:46',
					color: '#0bbd87'
				}, {
					content: '支持自定义尺寸',
					timestamp: '2018-04-03 20:46',
					size: 'normal'
				}, {
					content: '默认样式的节点',
					timestamp: '2018-04-03 20:46'
				}],
				
				value: '',
				//------------------------------------------------------
				checkAll: false,
				checkedCities: ['上海', '北京'],
				cities: cityOptions,
				isIndeterminate: true
			}
		},
		mounted() {
			
		},
		methods:{
			selectTime(){
				console.log(this.value);
			},
			
			
			handleCheckAllChange(val) {
				console.log(val);
				this.checkedCities = val ? cityOptions : [];
				this.isIndeterminate = false;
			},
			
			handleCheckedCitiesChange(value) {
				console.log(value);
				let checkedCount = value.length;
				this.checkAll = checkedCount === this.cities.length;
				this.isIndeterminate = checkedCount > 0 && checkedCount < this.cities.length;
			}
		}
	}
</script>

<style lang="scss" scoped>
	.page {
		.carousel {
			margin-top: 50px;
			display: flex;
			justify-content: center;

			.el-carousel {
				// background-color: blue;
				width: 1500px;
				height: 250px;

				img {
					background-color: black;
					width: 100%;
					height: 100%;
				}
			}
		}


		.card {
			width: 30%;

			.text {
				font-size: 14px;
			}

			.item {
				margin-bottom: 18px;
			}

			.clearfix:before,
			.clearfix:after {
				display: table;
				content: "";
			}

			.clearfix:after {
				clear: both
			}

			.box-card {
				width: 480px;
			}
		}
	}
</style>
