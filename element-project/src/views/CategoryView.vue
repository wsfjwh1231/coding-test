<template>
  <div class="category">
    <el-row class="head">
      <el-col :span="22">
        <i class="el-icon-tickets"></i>
        <span class="topLeftText">分类列表</span>
      </el-col>
      <el-col :span="2">
        <el-button @click="addCategory" type="primary" plain>添加</el-button>
      </el-col>
    </el-row>

    <el-table :data="tableData" style="width: 100%" border :span="24">
      <el-table-column  label="编号" :span="2"></el-table-column>

      <el-table-column label="分类名称">
        <template slot-scope="scope">
          <!-- 注意 这里的collapseVisible变量控制组件的展开与隐蔽 类型为string 而非Boolean-->
          <el-collapse v-model="collapseVisible" @change="getCategoryLevelTwoList(scope.row.catId)">
            <el-collapse-item :title="scope.row.catName" :name="scope.row.catId">


              <el-table :data="categoryData" style="width: 100%">
                <el-table-column label="编号" width="180">
                  <template slot-scope="scope">
                    <span style="margin-left: 10px">{{ scope.row.catId }}</span>
                  </template>
                </el-table-column>
                <el-table-column label="名称" width="180">
                  <template slot-scope="scope">
                    <div slot="reference" class="name-wrapper">
                      <el-tag size="medium">{{ scope.row.catName }}</el-tag>
                    </div>
                  </template>
                </el-table-column>
                <el-table-column label="分类" width="180">
                  <template slot-scope="scope">
                    <div slot="reference" class="name-wrapper">
                      <el-tag size="medium">{{ scope.row.catLevel | categoryNumToText}}</el-tag>
                    </div>
                  </template>
                </el-table-column>
                <el-table-column label="操作">
                  <template slot-scope="scope">
                    <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
                    <el-button size="mini" type="danger" @click="handleDelete(scope.row)">删除</el-button>
                  </template>
                </el-table-column>
              </el-table>
            </el-collapse-item>
          </el-collapse>
        </template>
      </el-table-column>
      <el-table-column label="分类级别">
        <template slot-scope="scope">
          <div slot="reference" class="name-wrapper">
            <el-tag size="medium">{{ scope.row.catLevel | categoryNumToText}}</el-tag>
          </div>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button @click="handleEdit(scope.$index,scope.row)">编辑</el-button>
          <el-button type="danger" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <!-- <el-pagination @current-change="pageChange" layout="prev, pager, next" :total="total"></el-pagination> -->

  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "CategoryView",

  data() {
    return {
      title: "添加分类",
      activeNames: ["1"],
      collapseVisible:"false",
      dialogFormVisible: false,
      ruleForm: {
        catId: "",
        catName: "",
        catType: "",
        catLevel: "",
        file: ""
      },
      rules: {
        name: [
          { required: true, message: "不能为空", trigger: "blur" }
        ]
      },

      tableData: [],
      //   二级分类数据
      categoryData: [],
      page: 1,
      pageSize: 10,
      total: 0,
      searchText: ""
    };
  },

  mounted() {
    // 获取一级分类列表
    this.getCategoryList();
  },
  filters: {
    categoryNumToText(num) {
      switch (num) {
        case 0:
          return "无上级";
          break;

        case 1:
          return "一级";
          break;

        case 2:
          return "二级";
          break;

        case 3:
          return "三级";
          break;

        default:
          break;
      }
    }
  },

  methods: {
    // 添加分类
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          axios({
            url: "http://101.34.49.100:3001/addCategory",
            method: "post",
            data: {
              category_id: this.ruleForm.catId,
              catName: this.ruleForm.catName
              // file: this.ruleForm.file
            }
          }).then(res => {
            console.log(res);
            if (res.data.code == 200) {
              this.dialogFormVisible = false;
              this.ruleForm.catId = "";
              this.ruleForm.catName = "";
            }
          });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },

    resetForm(formName) {
      this.$refs[formName].resetFields();
    },

    // 查询一级分类列表
    getCategoryList() {
      axios({
        url: "http://101.34.49.100:3001/categoryLevelOneList",
        method: "GET"
      }).then(res => {
        // console.log(res);
        this.tableData = res.data.list;
      });
    },

    // 查询二级分类数据
    getCategoryLevelTwoList(id) {
      this.collapseVisible = "true"
      axios({
        url: "http://101.34.49.100:3001/categoryLevelTwoList",
        method: "get",
        params: {
          category_id: id
        }
      }).then(res => {
        this.categoryData = res.data.list;
        
      });
    },

    // 删除分类
    handleDelete(categoryInfo) {
      this.$confirm("您确定要删除分类吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(res => {
        // 调用删除的接口,实现删除的功能
        axios({
          url: "http://101.34.49.100:3001/delCategory",
          method: "delete",
          params: {
            catId: categoryInfo.catId,
            catLevel: categoryInfo.catLevel
          }
        })
          .then(res => {
            if (res.data.code == 200) {
              // 刷新页面数据
              
              this.getCategoryList();
              this.getCategoryLevelTwoList(categoryInfo.catId);
              this.$message({
                type: "success",
                message: res.data.msg
              });

              this.collapseVisible = "false"
            }
          })
          .catch(err => {
            this.$message({
                type: "error",
                message: err.response.data.msg
              });
          });
      });
    },

    // 添加分类的信息
    addCategory() {
      this.$router.push({
        name: "addCategoryView"
      });
      //   this.dialogFormVisible = true;
      //   this.title = "添加分类";
    }
  }
};
</script>

<style lang="scss" scoped>
.category {
  .head {
    // 重点 用内填充制造空隙效果
    padding: 15px 10px;
    border: 1px solid #ebeef5;
    display: flex;
    margin: 20px 0;
    align-items: center;

    .el-col {
      display: flex;
      align-items: center;
      // background-color: red;
      font-size: 30px;

      .el-button {
        width: 100%;
      }
    }
    .topLeftText {
      color: #b0adad;
      padding-left: 10px;
      font-size: 20px;
    }
  }
  //   .el-table {
  //     ::v-deep .el-table__cell {
  //       text-align: center;
  //     }
  //   }

  .el-table {
    ::v-deep .el-table__cell {
      width: 30%;
    }
  }
}
</style>