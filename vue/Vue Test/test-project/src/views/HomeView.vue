<template>
  <div class="home">
      <!-- <TopNav :title="msg" class="topNav"></TopNav> -->
      <div class="iconList">
      <!-- <div class="iconItem" @v-for="(item, index) in commodityList" :key="index">
        <img :src="item.img" alt="">
        <div :v-text="item.name"></div>
      </div> -->

      <div class="iconItem">
        <img src="../assets/cellphone.png" alt="">
        <div>手机</div>
      </div>
      <div class="iconItem">
        <img src="../assets/doorlock.png" alt="">
        <div>门锁</div>
      </div>
      <div class="iconItem">
        <img src="../assets/display.png" alt="">
        <div>显示器</div>
      </div>
      <div class="iconItem">
        <img src="../assets/television.png" alt="">
        <div>电视</div>
      </div>
      <div class="iconItem">
        <img src="../assets/trunk.png" alt="">
        <div>行李箱</div>
      </div>
      <div class="iconItem">
        <img src="../assets/watches.png" alt="">
        <div>手表</div>
      </div>
      <div class="iconItem">
        <img src="../assets/electric.png" alt="">
        <div>电饭锅</div>
      </div>
      <!-- <img alt="Vue logo" src="../assets/logo.png"> -->
      <!-- <HelloWorld msg="Welcome to Your Vue.js App"/> -->
      
    </div>
  </div>
  
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import TopNav from '@/components/TopNav.vue';
export default {
  name: 'HomeView',
  data() {
    return {
      msg:"首页",
      commodityList:[
        {
          img:"../assets/cellphone.png",
          name:"手机"
        },
        {
          img:"../assets/doorlock.png",
          name:"门锁"
        },
        {
          img:"../assets/display.png",
          name:"显示器"
        },
        {
          img:"../assets/television.png",
          name:"电视"
        },
        {
          img:"../assets/electric.png",
          name:"电饭锅"
        },
        {
          img:"../assets/trunk.png",
          name:"行李箱"
        },
        {
          img:"../assets/watches.png",
          name:"手表"
        },
      ]
    }
  },
  components: {
    HelloWorld,
    TopNav
  }
}
</script>
<style lang="scss">
  .home{
    .topNav{
      margin-top: 10px;
    }
    .iconList{
      margin: 10px 0;
      box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
      background-color: white;
      display: flex;
      justify-content:flex-start;
      height: 54vh;
      
      flex-wrap: wrap;
      .iconItem{
        // width: 100%;
        // margin: 0 auto;
        margin: 5px 50px;
        // background-color: red;
        font-size: 15px;
        img{
          width: 80px;
          height: 80px;
          // background-color: red;
        }

      }
    }
  }
  
</style>
