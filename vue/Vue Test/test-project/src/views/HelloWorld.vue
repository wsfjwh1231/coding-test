<template>
  <div class="home">
    <van-swipe class="swipe" :autoplay="3000" :show-indicators="true" >
      <van-swipe-item v-for="item in images" :key="item.id">
        <!-- <img v-lazy="item.img" :src="item.img" /> -->
        <img :src="item.img" />
      </van-swipe-item>
    </van-swipe>

    <!-- Grid 宫格 -->
    <van-grid :border="false" :column-num="4" class="grid">
      <van-grid-item>
        <van-image :src="require('../assets/grid1.png')" />
        <span>服装</span>
      </van-grid-item>
      <van-grid-item>
        <van-image :src="require('../assets/grid2.png')" />
        <span>扎染</span>
      </van-grid-item>
      <van-grid-item>
        <van-image :src="require('../assets/grid3.png')" />
        <span>蜡染</span>
      </van-grid-item>
      <van-grid-item>
        <van-image :src="require('../assets/grid4.png')" />
        <span>绣球</span>
      </van-grid-item>
    </van-grid>

    <div class="art">
      <h4>民间艺术</h4>
      <!-- 商品列表 Layout 布局 一行24 -->
      <van-row>
        <van-col span="12" v-for="item in goodList" :key="item.id">
          <img :src="item.image" alt="商品图" />
          <p class="title">{{item.name}}</p>
          <p class="num">
            <span>￥{{item.price}}</span>
            <span>已售 {{item.sales}}</span>
          </p>
        </van-col>
      </van-row>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import { Toast } from "vant";

export default {
  name: "TestProjectHelloWorld",

  data() {
    return {
      images: [],
      goodList: [],
      flag: false,
      index: 0
    };
  },
  created() {
    // 调用初始化接口 赋值
    this.getSwipeList();
    this.getGoodList();
  },

  methods: {
    // 定义一个获取轮播数据的方法
    getSwipeList() {
      // 调用接口获取轮播数据
      axios.get("http://101.34.49.100:3001/swipeList").then(res => {
        console.log(res.data);
        this.images = res.data.list;
      });
    },

    onChange(index) {
      Toast("当前 Swipe 索引：" + index);
    },

    // 定义一个获取商品列表的方法
    getGoodList() {
      axios.get("http://101.34.49.100:3001/product").then(res => {
        console.log(res);
        this.goodList = res.data.list;
      });
    }
  }
};
</script>

<style lang="scss" scoped>
.home {
  .swipe {
    img {
      height: 300px;
      width: 100%;
    }
  }

  .grid {
    span {
      font-size: 15px;
      margin-top: 5px;
    }
  }

  .art {
    h4{
      text-align: left;
      font-size: 20px;
      margin-left: 10px;
    }
    padding: 0 0 100px 0;
    .van-row {
      .van-col {
        // display: flex;
        // flex-direction: column;
        // align-items: center;


        text-align: center;
        .title{
          // 重点
          white-space: nowrap;
          overflow: hidden;
          // // 重点
          text-overflow: ellipsis;
          font-size: 20px;

          
          
          // 配合flex布局
          // width: 100%;
          // display: flex;
          // justify-content: center;

        }
        img {
          width: 150px;
        }
        .num{
          display: flex;
          justify-content: space-around;
          span:nth-child(1){
            color: red;
          }
          
          span:nth-child(2){
            color: #999;
          }
        }
      }
    }
  }
}
</style>