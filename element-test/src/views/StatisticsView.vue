<template>
	<div class="page">
		<!-- 条形图图 -->
		<div ref="chartBar" style="width:300px;height:400px"></div>

		<!-- 饼图 需要准备一个dom节点，而且需要宽高 -->
		<div id="hot-good" style="width:300px;height:400px"></div>
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
			this.getDoughnutChart();
			this.getBar()
		},
		methods: {
			getBar() {
				var chartDom = this.$refs.chartBar;
				var myChart = this.$echarts.init(chartDom);
				
				myChart.setOption({
				  xAxis: {
				    type: 'category',
				    data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
				  },
				  yAxis: {
				    type: 'value'
				  },
				  series: [
				    {
				      data: [120, 200, 150, 80, 70, 110, 130],
				      type: 'bar',
				      showBackground: true,
				      backgroundStyle: {
				        color: 'rgba(180, 180, 180, 0.2)'
				      }
				    }
				  ]
				});
			},
			getDoughnutChart() {
				var chartDom = document.getElementById('hot-good');
				var myChart = this.$echarts.init(chartDom);
				myChart.setOption({
					tooltip: {
						trigger: 'item'
					},
					legend: {
						top: '5%',
						left: 'center'
					},
					series: [{
						name: 'Access From',
						type: 'pie',
						radius: ['40%', '70%'],
						avoidLabelOverlap: false,
						label: {
							show: false,
							position: 'center'
						},
						emphasis: {
							label: {
								show: true,
								fontSize: 40,
								fontWeight: 'bold'
							}
						},
						labelLine: {
							show: false
						},
						data: [{
								value: 1048,
								name: 'Search Engine'
							},
							{
								value: 735,
								name: 'Direct'
							},
							{
								value: 580,
								name: 'Email'
							},
							{
								value: 484,
								name: 'Union Ads'
							},
							{
								value: 300,
								name: 'Video Ads'
							}
						]
					}]
				})
			}


		}
	}
</script>

<style lang="scss" scoped>
	.page {
		display: flex;
		// background-color: blue;
	}
</style>