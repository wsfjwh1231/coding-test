<template>
	<div class="page">
		<div class="login">
			<div class="topText">
				mall-admin
			</div>
			<el-form status-icon label-width="100px" class="demo-ruleForm">
				<el-form-item>
					<el-input prefix-icon="el-icon-user-solid" type="text" autocomplete="off" placeholder="请输入用户名"
						v-model="username" @input="usernameInput"></el-input>
				</el-form-item>
				<el-form-item>
					<el-input prefix-icon="el-icon-lock" type="password" autocomplete="off" placeholder="请输入密码"
						v-model="passowrd" @input="passwordInput" @change="loginBtn"></el-input>
				</el-form-item>
				<el-form-item>
					<el-button type="primary" @click="loginBtn" class="loginBtn">登录</el-button>
				</el-form-item>
			</el-form>
		</div>

	</div>
</template>

<script>
	import axios from "axios";
	export default {
		data() {
			return {
				username: "",
				passowrd: "",
				user: {}
			}
		},
		mounted() {
			
		},
		methods: {

			usernameInput(data) {
				this.username = data
				console.log(this.username)
			},
			passwordInput(data) {
				this.password = data
				console.log(this.password)
			},
			loginBtn(data) {
				axios({
					url: "http://101.34.49.100:3001/user/login",
					method: "POST",
					data: {
						username: this.username,
						password: this.passowrd
					}
				}).then(res => {
					console.log(res.data)
					if (res.data.code == 200) {
						// 有BUG
						this.$message({
							message:"登录成功",
							type:"success"
						});
						
						setTimeout(()=>{
							localStorage.setItem("pc-user",JSON.stringify(res.data.user));
							localStorage.setItem("pc-token", res.data.token);
							console.log(localStorage.getItem("pc-user"))
							this.$router.push('/index')
						}, 1000);
					} else {
						this.$message({
							message:"用户名或密码错误",
							type:"error"
						})
					}
				})
			}
		}

	}
</script>

<style lang="scss" scoped>
	.page {
		height: 100vh;
		display: flex;
		justify-content: center;
		align-items: center;

		.login {
			width: 30%;
			height: 50%;

			.topText {
				text-align: center;
				font-size: 40px;
				font-weight: 600;
				color: #409eff;
				padding: 20px 0;
			}

			::v-deep .el-form-item__content {
				margin-left: 0 !important;
				// text-align: center;
			}

			.loginBtn {
				width: 100%;
			}


		}

	}
</style>