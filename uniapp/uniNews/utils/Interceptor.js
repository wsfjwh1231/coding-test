uni.addInterceptor("request",{
	invoke(args) {
		// request 触发前拼接url
		args.url = "http://101.34.49.100:3002/"+args.url
		let token = uni.getStorageSync("token")
		args.header = {
			authorization:token
		}
	},
	success(args) {
		// 请求成功后，如判断token过期，则跳转登录界面
		if(args.statusCode == 401){
			uni.navigateTo({
				url:"/pages/my/login/login?code=401"
			})
		}
	},
	fail(err) {
		
	}
})