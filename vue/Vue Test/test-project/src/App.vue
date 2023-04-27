<template>
  <div id="app">
    <!-- NavBar 框架实现方式 -->
    <van-nav-bar v-if="active == 0" :title="title" left-text="返回" left-arrow>
      <template #right>
        <van-icon name="search" size="18" />
      </template>
    </van-nav-bar>
    <van-nav-bar v-if="active == 1" :title="title" left-text="返回" right-text="管理" left-arrow></van-nav-bar>
    <van-nav-bar v-if="active == 2" :title="title" left-text="返回" right-text="登录" left-arrow></van-nav-bar>

    <!-- NavBar 组件实现方式 -->
    <!-- <TopNav :title="$route.meta.title"></TopNav> -->
    <router-view class="middle" />

    <!-- <Content></Content> -->
    <!-- 原先实现方式 -->
    <!-- <BottomNav :index="index" @getView="toView" @v-model="index" class="bottom"></BottomNav> -->

    <!-- 框架实现方式 -->
    <van-tabbar v-model="active" route>
      <van-tabbar-item to="/" icon="home-o">首页</van-tabbar-item>
      <!-- <van-tabbar-item to="/shoppingCar" icon="cart-o">购物车</van-tabbar-item> -->
      <van-tabbar-item to="/category" icon="cart-o">分类</van-tabbar-item>
      <van-tabbar-item to="/my" icon="friends-o">我的</van-tabbar-item>
      <van-tabbar-item to="/helloWorld" icon="friends-o">接口</van-tabbar-item>
    </van-tabbar>

    <!-- 系统自带实现方式 -->
    <!-- <nav>
      <router-link to="/">Home</router-link> |
      <router-link to="/shoppingCar">购物车</router-link> |
      <router-link to="/my">我的</router-link>
    </nav>-->
  </div>
</template>

<style lang="scss">
#app {
  // color: #2c3e50;

  // background-color: rgb(184, 179, 179);
  // overflow: hidden;
}
</style>

<script>
import BottomNav from "./components/BottomNav.vue";
import TopNav from "./components/TopNav.vue";
import Content from "./components/Content.vue";
import { Toast } from "vant";
export default {
  data() {
    return {
      // 原生Tabbar 实现方式
      index: 1,

      // 框架Tabbar 实现方式
      active: 0,
      title: ""
    };
  },
  methods: {
    toView(e) {
      console.log(e);
      switch (e) {
        case 0:
          this.$router.push("/");
          break;
        case 1:
          this.$router.push("/shoppingCar");
          break;
        case 2:
          this.$router.push("/my");
          break;
      }
    },
    onClickLeft() {
      Toast("返回");
    },
    onClickRight() {
      Toast("按钮");
    }
  },
  watch: {
    active(newVal, oldVal) {
      console.log(newVal);
      switch (newVal) {
        case 0:
          this.title = "首页";
          break;

        case 1:
          this.title = "购物车";
          break;

        case 2:
          this.title = "我的";
          break;

        case 3:
          this.title = "接口";
          break;

        default:
          break;
      }
    }
  },
  components: {
    TopNav,
    BottomNav,
    Content
  }
};
</script>
