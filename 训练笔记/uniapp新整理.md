
const 适用于需要声明不变的常量，而 var 和 let 适用于需要声明可变的变量。在实际开发中，建议尽可能使用 const 和 let，以避免对变量的误操作。

#### 界面路径设置
```json
"pages": [ //pages数组中第一项表示应用启动页，参考：https://uniapp.dcloud.io/collocation/pages
		{
			"path": "pages/index/index",
			"style": {
				"navigationBarTitleText": "uni-app",
				//隐蔽导航栏
				"navigationStyle": "custom"
			}
		}
```

#### 下方Tabbar
```json
"tabBar": {
		"color": "#999999",
		"selectedColor": "#3366FF",
		"list": [
            {
				"pagePath": "pages/index/index",
				"text": "首页",
				"iconPath": "/static/home.png",
				"selectedIconPath": "/static/home_active.png"
			},
```

#### 轮播图

```html
<!-- duration：动画滑动时长； interval:自动切换时间间隔	  -->
<swiper :indicator-dots="true" :autoplay="true" :interval="3000" :duration="1000">
    <swiper-item v-for="(item,index) in shopImg">
        <image :src="item.url" mode=""></image>
    </swiper-item>
</swiper>
```

### 滚动条
```html
<view class="content">
    <div class="leftNav">
        <div :class="selectIndex==index?'leftNavItemSelect':'leftNavItem'" v-for="(item,index) in category" :key="index" @click="selectBtn(index)">
            <div :class="selectIndex==index?'leftNavItemPadding':''">{{item.catName}}</div>
        </div>
    </div>
    
    <!-- 核心：1、设置高度 2、组件位置超出高度之外  3.scrollId的值为'scroll'+item.id-->
    <scroll-view scroll-y="true" class="right" :scroll-into-view="scrollId">
        <view :class="'categoryItem'+item.id" :id="'scroll'+item.id" v-for="(item,index) in scrollList">
            {{item.name}}
        </view>
    </scroll-view>
		
</view>
```

### 请求示例

```javascript

uni.setStorageSync("user",res.data.user)
uni.getStorageSync("token")

onCollection() {
    uni.request({
        url: "user/getUserCollection",
        method: "GET",
        header: {
            "authorization": uni.getStorageSync("token")
        },
        success: (res) => {
            if (res.data.code == 200) {
                this.newsList = res.data.list
                console.log(this.newsList)
            } else {
                console.log(this.data)
            }

        },
        fail: (err) => {
            console.log(err)
        }
    })
}

toInformation(){
    uni.navigateTo({
        url:"/pages/my/information/information"
    })
}


// 选择相片
uni.chooseImage({
    success: (res) => {
        console.log(res)
        const tempFilePaths = res.tempFilePaths;
        相片上传
        uni.uploadFile({
            url:"http://101.34.49.100:3002/upload",
            filePath: tempFilePaths[0],
            name:"file",
            success: (res) => {
                console.log(res.data)
                const data = JSON.parse(res.data)
                console.log(data)
                this.user.avatar = data.path
                
            },
            fail: (err) => {
                console.log(err)
            }
        })
    }
})		

```


### uniapp和vue的区别
```javascript
// UNIAPP
onLoad() {
    this.getCategory()
}

//vue
mounted() {
			
},


---
//UNIAPP
uni.request({
    url: "user/getUserCollection",
    method: "GET",
    header: {
        "authorization": uni.getStorageSync("token")
    },
    success: (res) => {
        if (res.data.code == 200) {
            this.newsList = res.data.list
            console.log(this.newsList)
        } else {
            console.log(this.data)
        }

    },
    fail: (err) => {
        console.log(err)
    }
})


//vue
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
```