import axios from "axios";

const instance = axios.create({
    baseURL : "http://101.34.49.100:3001",
    // 网络请求超时时间
    timeout : 5000

})

// 请求拦截
instance.interceptors.request.use(config => {
    console.log("请求发起了吗")
    // 设置请求头 token
    return config;
})

// 响应拦截器
// 响应拦截，接口数据请求回来之后，需要做一些什么操作，可以在此进行操作
instance.interceptors.response.use(response => {
    console.log("响应拦截器")
    console.log(response)
    return response;
})

export default instance