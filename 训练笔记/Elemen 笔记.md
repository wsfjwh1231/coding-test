prefix-icon	输入框头部图标
suffix-icon	输入框尾部图标
```html
<el-input type="password"  autocomplete="off" suffix-icon="el-icon-date"></el-input>
```
scoped：这个属性表示在这个style标签中定义的CSS样式将仅应用于当前Vue组件。
```html
<style lang="scss" scoped>
```

container布局 上中下
```html
<el-container>
  <el-header>Header</el-header>
  <el-main>Main</el-main>
  <el-footer>Footer</el-footer>
</el-container>
```

container布局 左右
```html
<el-container>
  <el-aside width="200px">Aside</el-aside>
  <el-main>Main</el-main>
</el-container>
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