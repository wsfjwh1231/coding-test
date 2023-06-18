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

		<div class="collapse">
			<el-collapse v-model="activeName" accordion>
				<el-collapse-item title="一致性 Consistency" name="1">
					<div>与现实生活一致：与现实生活的流程、逻辑保持一致，遵循用户习惯的语言和概念；</div>
					<div>在界面中一致：所有的元素和结构需保持一致，比如：设计样式、图标和文本、元素的位置等。</div>
				</el-collapse-item>
				<el-collapse-item title="反馈 Feedback" name="2">
					<div>控制反馈：通过界面样式和交互动效让用户可以清晰的感知自己的操作；</div>
					<div>页面反馈：操作后，通过页面元素的变化清晰地展现当前状态。</div>
				</el-collapse-item>
				<el-collapse-item title="效率 Efficiency" name="3">
					<div>简化流程：设计简洁直观的操作流程；</div>
					<div>清晰明确：语言表达清晰且表意明确，让用户快速理解进而作出决策；</div>
					<div>帮助用户识别：界面简单直白，让用户快速识别而非回忆，减少用户记忆负担。</div>
				</el-collapse-item>
				<el-collapse-item title="可控 Controllability" name="4">
					<div>用户决策：根据场景可给予用户操作建议或安全提示，但不能代替用户进行决策；</div>
					<div>结果可控：用户可以自由的进行操作，包括撤销、回退和终止当前操作等。</div>
				</el-collapse-item>
			</el-collapse>
		</div>

		<div class="block">
			<el-timeline>
				<el-timeline-item v-for="(activity, index) in activities" :key="index" :icon="activity.icon"
					:type="activity.type" :color="activity.color" :size="activity.size" :timestamp="activity.timestamp">
					{{activity.content}}
				</el-timeline-item>
			</el-timeline>
		</div>

		<div class="card">
			<el-card class="box-card">
				<div slot="header" class="clearfix">
					<span>卡片名称</span>
					<el-button style="float: right; padding: 3px 0" type="text">操作按钮</el-button>
				</div>
				<div v-for="o in 4" :key="o" class="text item">
					{{'列表内容 ' + o }}
				</div>
			</el-card>
		</div>
	</div>
</template>

<script>
	import axios from "axios"
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
				}]
			}
		},
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
