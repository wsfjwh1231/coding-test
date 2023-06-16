启动项目 查看package.json文件的的命令

```
npm run serve
```

#### Layout 布局 
#### Row 组件 提供 gutter 属性来指定每一栏之间的间隔，默认间隔为 0。
#### col 组件的 offset 属性可以指定分栏偏移的栏数。

```html
<el-row :gutter="20">
  <el-col :span="8"><div class="grid-content bg-purple"></div></el-col>
  <el-col :span="8" :offset="8"><div class="grid-content bg-purple-light"></div></el-col>
</el-row>
```

#### container布局 上中下
```html
<el-container>
  <el-header>Header</el-header>
  <el-main>Main</el-main>
  <el-footer>Footer</el-footer>
</el-container>
```

#### container布局 左右
```html
<el-container>
  <!-- aside为导航栏边框 -->
  <el-aside width="200px">Aside</el-aside>
  <el-main>Main</el-main>
</el-container>
```

#### Border - 投影
```css
基础投影 box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)
浅色投影 box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1)
```

关键词：导航菜单
包含左右和上下布局

Breadcrumb 面包屑


vue特有方法，类似小程序onLoad（）

```javascript
mounted(){
  this.user = localStorage.getItem("pc-user")
  console.log(this.user)
},		
```

要使用路由模式，需要在el-menu 标签 里面加上router，很重要
```html
<el-container>
  <el-aside width="200px" style="height: 100vh;background-color: #545c64;">
    <el-menu router default-active="2" class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose"
      background-color="#545c64" text-color="#fff" active-text-color="#ffd04b">
      <el-menu-item index="1">
        <i class="el-icon-s-home"></i>
        <span slot="title">首页</span>
      </el-menu-item>
      <el-submenu index="2">
        <template slot="title">
          <i class="el-icon-shopping-bag-1"></i>
          <span>商品</span>
        </template>
        <el-menu-item-group>
          <el-menu-item index="/category">商品分类</el-menu-item>
          <el-menu-item index="/specification">商品规格</el-menu-item>
          <el-menu-item index="/productList">商品列表</el-menu-item>
          <el-menu-item index="/statistics">数据统计</el-menu-item>
        </el-menu-item-group>
      </el-submenu>
      <el-menu-item index="3">
        <i class="el-icon-s-order"></i>
        <span slot="title">订单管理</span>
      </el-menu-item>
      <el-menu-item index="4">
        <i class="el-icon-document"></i>
        <span slot="title">用户列表</span>
      </el-menu-item>
    </el-menu>
  </el-aside>
  <el-main>
    <div class="nav-menu">
      <el-breadcrumb separator="/">
        <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
        <el-breadcrumb-item v-if="$route.meta.title != '首页'">
          <a href="/">{{ $route.meta.title }}</a>
        </el-breadcrumb-item>
      </el-breadcrumb>
      <div class="rightIcon">
        <span>{{user.username}}</span>
        <img :src="user.avatar" alt="头像">
      </div>
    </div>
    
    <router-view />
  </el-main>
</el-container>
```


#### select选择，不要更改v-model的字段，否则会出现问题
#### 将value的值绑定到v-model上，这样就可以实现选择后，v-model的值就是value的值
```html
<el-select v-model="selectItem" placeholder="请选择上级分类">
<el-option label="无上级分类" :value="100" :key="100"></el-option>
  <el-option :label="item.catName" :value="item.catId" v-for="(item,index) in selectData" :key="item.catId"></el-option>
</el-select>
```

#### <el-input> 组件的 v-model.number 指令意味着当用户在该输入框中输入数值时，Vue.js 会自动将其转换为数值类型
<el-input v-model.number="ruleForm.age"></el-input>


---



#### echarts 图形表
```javascript
getBar() {
        <!-- 条形图图 -->
        <div ref="chartBar" style="width:300px;height:400px"></div>

        //根据标签的ref属性，用来获取dom元素
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
```


#### scoped：这个属性表示在这个style标签中定义的CSS样式将仅应用于当前Vue组件。
```html
<style lang="scss" scoped>
```


#### Link 文字链接

```html
<el-link href="https://element.eleme.io" target="_blank">默认链接</el-link>
<el-link type="primary">主要链接</el-link>
<el-link type="success">成功链接</el-link>

<el-link :underline="false">无下划线</el-link>
<el-link>有下划线</el-link>

<!-- 带文字图标 -->
<el-link icon="el-icon-edit">编辑</el-link>
<el-link>查看<i class="el-icon-view el-icon--right"></i> </el-link>
```

#### Radio 单选框
```html
<!-- 按钮样式 -->
 <div style="margin-top: 20px">
    <el-radio-group v-model="radio3" size="small">
      <el-radio-button label="上海"></el-radio-button>
      <el-radio-button label="北京" disabled ></el-radio-button>
      <el-radio-button label="广州"></el-radio-button>
      <el-radio-button label="深圳"></el-radio-button>
    </el-radio-group>
  </div>
```

#### Checkbox 多选框
```html
<!-- 多选框按钮样式 -->
		<div style="margin-top: 20px">
    <!-- size属性可以更改图标大小 -->
			<el-checkbox-group v-model="checkboxGroup2" size="medium" @change="handleCheckedCitiesChange">
				<el-checkbox-button v-for="city in cities" :label="city" :key="city">{{city}}</el-checkbox-button>
			</el-checkbox-group>
		</div>
```


#### 输入框、远程搜索

```html
<!-- 输入框  clearable 代表输入框内容可清空 show-password显示密码-->
  <el-input
    placeholder="请输入内容" v-model="input" clearable show-password @input="test" style="width: 10%;">
  </el-input>

  
<!-- prefix-icon	输入框头部图标 -->
<!-- suffix-icon	输入框尾部图标 -->
<!-- size	指定输入框的尺寸 -->

<el-input type="password"  autocomplete="off" suffix-icon="el-icon-date" size="small"></el-input>

<!-- textarea为文本域 高度可通过rows属性控制 长度限制maxlength为30 show-word-limit展示字数统计-->
<el-input
  type="textarea"
  :autosize="{ minRows: 2, maxRows: 4}"
  maxlength="30"
  show-word-limit
  placeholder="请输入内容"
  v-model="textarea2"
  style="width: 30%;">
</el-input>


<!-- autocomplete 是一个可带输入建议的输入框组件，fetch-suggestions 是一个返回输入建议的方法属性 -->
<<!-- 远程搜索 -->
<el-autocomplete
  v-model="state"
  :fetch-suggestions="querySearchAsync"
  placeholder="请输入远程搜索内容"
  @select="handleSelect"
  style="width: 30%;">
</el-autocomplete>

```
