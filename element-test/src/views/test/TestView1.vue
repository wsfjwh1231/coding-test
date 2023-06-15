<template>
	<div class="page">
		<!-- 条形图图 -->
		<div ref="salesList" style="width:300px;height:400px"></div>

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
			getBar(){
				const chartDom = this.$refs.salesList
				const myChart = this.$echarts.init(chartDom);
				let option;
				
				myChart.option = ({
				xAxis: {
				      data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
				    },
				    yAxis: {},
				    series: [
				      {
				        type: 'bar',
				        data: [23, 24, 18, 25, 27, 28, 25]
				      }
				    ]
				});
				
			},
			getDoughnutChart() {
				var chartDom = document.getElementById('hot-good');
				var myChart = this.$echarts.init(chartDom);
				var option;
				
				option = {
				  tooltip: {
				    trigger: 'item'
				  },
				  legend: {
				    top: '5%',
				    left: 'center'
				  },
				  series: [
				    {
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
				      data: [
				        { value: 1048, name: 'Search Engine' },
				        { value: 735, name: 'Direct' },
				        { value: 580, name: 'Email' },
				        { value: 484, name: 'Union Ads' },
				        { value: 300, name: 'Video Ads' }
				      ]
				    }
				  ]
				};
				
				option && myChart.setOption(option);
				
			}
				

		}
	}
</script>

<style lang="scss" scoped>
	.page {
		// background-color: blue;
	}
</style>