<template>
  <div class="home">
    <el-container>
      <el-aside width="200px" style="height:100vh;background-color:#545c64">
        <el-menu
          default-active="2"
          class="el-menu-vertical-demo"
          @open="handleOpen"
          @close="handleClose"
          background-color="#545c64"
          text-color="#fff"
          active-text-color="#ffd04b"
          router
        >
          <el-menu-item index="/home">
            <i class="el-icon-menu"></i>
            <span slot="title">首页</span>
          </el-menu-item>
          <el-submenu index="2">
            <template slot="title">
              <i class="el-icon-location"></i>
              <span>商品</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="/category">商品分类</el-menu-item>
              <el-menu-item index="1-2">商品列表</el-menu-item>
              <el-menu-item index="1-3">添加商品</el-menu-item>
              <el-menu-item index="1-4">商品规格</el-menu-item>
              <el-menu-item index="/statitistic">数据统计</el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-menu-item index="/user-list">
            <i class="el-icon-menu"></i>
            <span slot="title">用户列表</span>
          </el-menu-item>
          <!-- 无权限 禁止点击按钮  -->
          <el-menu-item index="4" disabled>
            <i class="el-icon-document"></i>
            <span slot="title">权限</span>
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
          <!-- <img src="../assets/logo.png" alt=""> -->
          <div>
            {{ user.username }}
            <img :src="user.avatar" alt="头像">
          </div>
        </div>
        

        <router-view />
      </el-main>
    </el-container>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";

export default {
  name: "HomeView",
  data() {
    return {
      user:{}
    }
  },
  created(){
    // 从vuex state获取出来
    this.user = this.$store.state.user
    console.log(this.user)
  },
  methods: {
    handleOpen(key, keyPath) {
      console.log(key, keyPath);
    },
    handleClose(key, keyPath) {
      console.log(key, keyPath);
    }
  },
  components: {
    HelloWorld
  }
};
</script>
<style lang="scss">
.nav-menu{
  display: flex;
  justify-content: space-between;
  align-items: center;
  img{
    width: 30px;
    height: 30px;
  }
}
</style>
