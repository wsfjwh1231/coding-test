<template>
  <div class="cattegory">
    <van-sidebar class="left" v-model="activeKey">
      <van-sidebar-item
        @click="onClick(item.catId)"
        :title="item.catName"
        v-for="item in leftCateList"
        :key="item.catId"
      />
    </van-sidebar>
    <div class="right">
      <!-- 商品列表 Layout 布局 一行24 -->
      <van-row v-if="rightCateList.length > 0">
        <van-col span="12" v-for="item in rightCateList" :key="item.id">
          <img :src="item.backImg" alt="商品图" />
          <p class="title">{{item.catName}}</p>
        </van-col>
      </van-row>
      <van-empty v-else description="无数据" />
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "CategoryView",

  data() {
    return {
      activeKey: 0,
      // 存储左侧分类的数组变量
      leftCateList: [],
      // 存储右侧分类的数组变量
      rightCateList: [],
      cateId: ""
    };
  },

  mounted() {
    this.getCateList();
  },

  methods: {
    onClick(index) {
      console.log(index);
      this.cateId = index;
      this.getCateList();
    },
    // 定义一个获取分类数据的方法
    getCateList() {
      axios
        .get("http://101.34.49.100:3001/category", {
          params: {
            category_id: this.cateId
          }
        })
        .then(res => {
          console.log("获取分类", res);
          this.leftCateList = res.data.category;
          this.rightCateList = res.data.currentChildCategory;
        });
    },
    login() {
      // axios.post("http://101.34.49.100:3001/user/login",{
      //     username: "admin", //用户名
      //     password: "123456" //密码
      // }).then(res=>{
      //     console.log("登录",res);
      // })
      axios({
        url: "http://101.34.49.100:3001/user/login",
        method: "post",
        // post/put传参
        data:{
          username: "admin", //用户名
          password: "123456" //密码
        },
        // Get 传参
        // params:{

        // }
      }).then(res=>{
        
      })
    }
  }
};
</script>

<style lang="scss" scoped>
.cattegory {
  display: flex;
  .left {
    width: 15%;
    .van-sidebar-item {
      // width: 20%;
      padding-left: 30px;
    }
  }
  .right {
    flex: 1;
    text-align: center;
    // display: flex;
    // justify-content: sp;
    // background-color: red;
    .van-row {
      .van-col {
        img {
          width: 100px;
        }
        p {
          font-size: 15px;
        }
      }
    }
  }
}
</style>