<template>
  <div id="app">
    <nav>
      <!-- router-link  -->
      <!-- <router-link to="/">Home</router-link> |
      <router-link to="/about">About</router-link>|
      <router-link :to="{name:'login',params:{username:'李四',age:18}}">Login</router-link>-->
      <!-- 编程式跳转 -->
      <!-- <button @click="tologin" >跳转到登录界面</button> -->
      <!-- 调用导航组件 -->
      <!-- <NavBar :title="$route.meta.title">
      </NavBar>
      <Card></Card>-->
    </nav>
    <van-nav-bar
      title="标题"
      left-text="返回"
      right-text="按钮"
      left-arrow
      @click-left="onClickLeft"
      @click-right="onClickRight"
    />
    <!-- 页面的占位符 -->
    <van-tabbar v-model="active">
      <van-tabbar-item icon="home-o">标签</van-tabbar-item>
      <van-tabbar-item icon="search">标签</van-tabbar-item>
      <van-tabbar-item icon="friends-o">标签</van-tabbar-item>
      <van-tabbar-item icon="setting-o">标签</van-tabbar-item>
    </van-tabbar>
    <router-view />
  </div>
</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
</style>
<script>
// 编程式跳转
import Card from "./components/Card.vue";
import NavBar from "@/components/NavBar.vue";
import { Toast } from 'vant';
export default {
  data() {
    return {
      active: 0
    };
  },
  methods: {
    tologin() {
      // 跳转界面
      // this.$router.push("/login")
      // this.$router.push(name="/login?username=张三&age=18")
      this.$router.push({
        name: "login",
        // query: {username:"李四",age:18}
        params: { username: "李四", age: 18 }
      });
    },
    onClickLeft() {
      Toast('后退');
    },
    onClickRight() {
      Toast('按钮');
    }
  },
  components: {
    NavBar,
    Card
  }
};
</script>