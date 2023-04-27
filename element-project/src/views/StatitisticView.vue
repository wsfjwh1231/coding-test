<template>
  <div class="imageList">
    <!-- 饼图 需要准备一个dom节点，而且需要宽高 -->
    <div id="hot-good" style="width:300px;height:400px"></div>

    <!-- 条形图图 -->
    <div id="sales-list" style="width:300px;height:400px"></div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "ElementProjectStatitisticView",

  data() {
    return {
      hotGoodData: [],
      salesListData: []
    };
  },

  mounted() {
    this.getHotGoodList();
    this.getSalesListData();
    this.delete()
  },

  methods: {
    getSalesListData() {
      // 请求接口
      axios.get("http://101.34.49.100:3001/salesAreaStatistics").then(res => {
        console.log(res);
        this.salesListData = res.data.list;
        // 绘制图表应该是等到数据请求回来之后，再画图
        this.barChart();
      });
    },

    // 获取销售数据
    getHotGoodList() {
      // 请求接口
      axios.get("http://101.34.49.100:3001/hotGoodStatistics").then(res => {
        // console.log(res);
        this.hotGoodData = res.data.list;
        // 绘制图表应该是等到数据请求回来之后，再画图
        this.drawHotGood();
      });
    },
    //定义一个绘制饼图的方法
    drawHotGood() {
      // 基于准备好的dom，初始化echarts实例
      var myChart = this.$echarts.init(document.getElementById("hot-good"));

      // 绘制图表
      myChart.setOption({
        tooltip: {
          trigger: "item"
        },
        legend: {
          top: "5%",
          left: "center"
        },
        series: [
          {
            name: "Access From",
            type: "pie",
            radius: ["40%", "70%"],
            avoidLabelOverlap: false,
            itemStyle: {
              borderRadius: 10,
              borderColor: "#fff",
              borderWidth: 2
            },
            label: {
              show: false,
              position: "center"
            },
            emphasis: {
              label: {
                show: true,
                fontSize: 40,
                fontWeight: "bold"
              }
            },
            labelLine: {
              show: false
            },
            data: this.hotGoodData
          }
        ]
      });
    },

    //获取地区统计条形图
    barChart() {
      var localtionList = [];
      var valueList = [];
      for (let index = 0; index < this.salesListData.length; index++) {
        localtionList.push(this.salesListData[index].localtion);
        valueList.push(this.salesListData[index].value);
      }


      var myChart = this.$echarts.init(document.getElementById("sales-list"));
      myChart.setOption({
        xAxis: {
          type: "category",
          data: localtionList
        },
        yAxis: {
          type: "value"
        },
        series: [
          {
            data: valueList,
            type: "bar"
          }
        ]
      });
    },

    //批量删除














    delete() {
      var userId = "";
      var searchText = "admin";
      axios({
        url: "http://101.34.49.100:3001/user/userList?searchText=" + searchText,
        method: "get"
      }).then(res => {
        


        for (let index = 0; index < res.data.list.length; index++) {
            const element = res.data.list[index].id;
            console.log(element);
        }
      });

    //   axios({
    //     url: "http://101.34.49.100:3001/user/delUser?userId=" + userId,
    //     methods: "delete"
    //   }).then(res => {
    //     console.log(res);
    //   });
    }
  }
};
</script>

<style lang="scss" scoped>
.imageList {
  display: flex;
  justify-content: space-around;
}
</style>