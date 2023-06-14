<template>
	<div>
		<el-table :data="tableData" style="width: 100%;margin-top: 20px;text-align: ;" border="">
			<el-table-column label="订单编号" width="300">
				<template slot-scope="scope">
					<i class="el-icon-time"></i>
					<span style="margin-left: 10px">{{ scope.row.order_sn }}</span>
				</template>
			</el-table-column>
			<el-table-column label="商品信息" width="500">
				<template slot-scope="scope">
					<!-- <span style="margin-left: 10px">{{ scope.row.goods }}</span> -->
					<div class="goods">
						<img src="https://upload.jianshu.io/users/upload_avatars/13762297/80740476-43b5-415f-a911-56c4d6255036.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240" alt="商品图片">
						<div class="centerGoods">{{scope.row.goods[0].good_name}}</div>
						<div class="rightGoods">
							<div class="price">￥{{ scope.row.goods[0].good_price}}</div>
							<div class="num">x{{ scope.row.goods[0].good_num}}件</div>
						</div>
					</div>
				</template>
			</el-table-column>
			<el-table-column label="订单状态" width="200">
				<template slot-scope="scope">
					<el-tag :type="scope.row.status | status">{{ scope.row.status | goodIcon}}</el-tag>
				</template>
			</el-table-column>
			<el-table-column label="下单时间" width="200">
				<template slot-scope="scope">
					<span style="margin-left: 10px">{{ scope.row.order_create_time }}</span>
				</template>
			</el-table-column>
			<el-table-column label="下单金额" width="200">
				<template slot-scope="scope">
					<span style="margin-left: 10px">{{ scope.row.total_amount }}</span>
				</template>
			</el-table-column>
			<el-table-column label="操作">
				<template slot-scope="scope">
					<el-button size="mini" @click="updateBtn(scope.$index, scope.row)" :type=" scope.row.status | goodInfoIcon">{{scope.row.status | goodInfo}}</el-button>
				</template>
			</el-table-column>
		</el-table>
		
		<el-dialog title="发货" :visible.sync="showSend">
			<el-form :model="addressData">
				<el-form-item label="收货人姓名" :label-width="formLabelWidth">
					<el-input v-model="addressData.name" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="手机号" :label-width="formLabelWidth">
					<el-input v-model="addressData.phone" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="收货地址" :label-width="formLabelWidth">
					<el-input v-model="addressData.addressInfo" autocomplete="off"></el-input>
				</el-form-item>
				<el-form-item label="快递公司" :label-width="formLabelWidth" >
					<el-select placeholder="请选择快递公司" v-model="selectDeliveryCompany">
					      <el-option :label="item" :value="item" v-for="(item,index) in addressData.delivery_company" :key="index"></el-option>
					</el-select>
				</el-form-item>
				<el-form-item label="请输入快递单号" :label-width="formLabelWidth">
					<el-input v-model="addressData.delivery_sn" autocomplete="off"></el-input>
				</el-form-item>
			</el-form>
			<div slot="footer" class="dialog-footer">
				<el-button @click="showSend = false">取 消</el-button>
				<el-button type="primary" @click="sendOrder">确 定</el-button>
			</div>
		</el-dialog>
		
		<el-dialog title="订单详情" :visible.sync="showOrder">
			<el-form :model="getOrderData">
				<el-form-item label="订单编号" :label-width="formLabelWidth">
					<el-input :value="getOrderData.order_sn" autocomplete="off" disabled></el-input>
				</el-form-item>
				<el-form-item label="订单金额" :label-width="formLabelWidth">
					<el-input :value="getOrderData.total_amount" autocomplete="off" disabled></el-input>
				</el-form-item>
				<el-form-item label="下单时间" :label-width="formLabelWidth">
					<el-input :value="getOrderData.order_create_time" autocomplete="off" disabled></el-input>
				</el-form-item>
			</el-form>	
			<div slot="footer" class="dialog-footer">
				<el-button @click="showOrder = false">取 消</el-button>
				<el-button type="primary" @click="showOrder = false">确 定</el-button>
			</div>
		</el-dialog>
	</div>
</template>

<script>

	import axios from "axios"
	export default {
		name:"orderManagementView",
		data() {
			return {
				showSend:false,
				showOrder:false,
				tableData:[],
				addressData:{},
				// 发货
				sendUserData:{},
				// 商品详情
				getOrderData:{},
				formLabelWidth:"120 px",
				// 已选择的快递公司
				selectDeliveryCompany:""
			}
		},
		mounted() {
			this.getOrderList()
		},
		filters:{
			goodIcon(val){
				switch(val){
					case "1" :
						return "待发货"
						break;
					case "2" :
						return "待收货"
						break;
					case "3" :
						return "待付款"
						break;
					case "4" :
						return "已完成"
						break;
					default :
						return "未知状态"
						break;
				}
			},
			goodInfoIcon(val){
				switch(val){
					case "4" :
						return "success"
						break;
					case "1" :
						return "warning"
						break;
					default :
						return "success"
						break;
				}
			},
			goodInfo(val){
				switch(val){
					case "4" :
						return "订单详情"
						break;
					case "1" :
						return "发货"
						break;
					default :
						return "订单详情"
						break;
				}
			},
			status(val){
				switch(val){
					case "1" :
						return "danger"
						break;
					case "2" :
						return "info"
						break;
					case "3" :
						return "warning"
						break;
					case "4" :
						return ""
						break;
					
					default :
						return "info"
						break;
				}
			},
			
		},
		methods:{
			getOrderList(){
				axios({
					url:"http://101.34.49.100:3001/pc/orderList",
					method:"GET"
				}).then(res =>{
					this.tableData = res.data.orderList
					console.log(this.tableData)
				})
			},
			updateBtn(index,row){
				if(row.status == "1"){
					this.showSend = true;
					axios({
						url:"http://101.34.49.100:3001/pc/deliverInfo?addressId="+row.address_id,
						method:"GET"
					}).then(res =>{
						
						console.log(res.data)
						this.addressData = res.data.deliverInfo
						this.addressData.addressInfo = res.data.deliverInfo.province + res.data.deliverInfo.city + res.data.deliverInfo.district + res.data.deliverInfo.address
						this.addressData.delivery_company = ['圆通快递','顺丰快递','韵达快递','申通快递']	
					})
				}else if(row.status == "4"){
					this.showOrder = true;
					this.getOrderData = row
				}
				
			},
			sendOrder(){
				axios({
					url:"http://101.34.49.100:3001/pc/confirmDeliver",
					method:"POST",
					data:{
						orderId:this.addressData.id,
						delivery_company:this.selectDeliveryCompany,
						delivery_sn:this.addressData.delivery_sn
					}
				}).then(res =>{
					this.selectDeliveryCompany = ""
					if (res.data.code == 200) {
						this.$message({
							message:"发货成功",
							type:"success"
						})
					}else{
						this.$message({
							message:res.data.msg,
							type:"error"
						})
					}
					console.log(res.data)
				})
			}
		}
	}

	
</script>

<style lang="scss" scoped>
	.goods{
		display: flex;
		justify-content: space-evenly;
		.centerGoods{
			font-size: 10px;
			width: 60%;
		}
		
		.rightGoods{
			
		}
		
		img{
			width: 50px;
			height: 50px;
		}
	}
</style>