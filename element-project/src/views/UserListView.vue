<template>
  <div class="userList">
    <el-row class="head">
      <el-col :span="22">
        <i class="el-icon-tickets"></i>
        <span class="topLeftText">数据列表</span>
      </el-col>
      <el-col :span="2">
        <el-button @click="addUser" type="primary" plain>添加</el-button>
      </el-col>
    </el-row>

    <!-- 搜索 -->
    <div style="margin-top: 15px;">
      <el-input placeholder="请输入账户" v-model="searchText">
        <el-button slot="append" icon="el-icon-search" @click="onSearch">搜索</el-button>
      </el-input>
    </div>

    <el-table :data="tableData" style="width: 100%" border>
      <el-table-column prop="id" label="编号"></el-table-column>
      <el-table-column prop="username" label="账号"></el-table-column>
      <el-table-column prop="phone" label="手机号"></el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button @click="handleEdit(scope.$index,scope.row)">编辑</el-button>
          <el-button type="danger" @click="handleDelete(scope.row)">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination @current-change="pageChange" layout="prev, pager, next" :total="total"></el-pagination>

    <!-- Form -->
    <el-dialog :title="title" :visible.sync="dialogFormVisible">
      <!-- <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm"></el-form> -->
      <el-form
        :model="ruleForm"
        :rules="rules"
        ref="ruleForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="用户名" prop="name">
          <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>
        <el-form-item label="手机号" prop="name">
          <el-input v-model="ruleForm.phone"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="name">
          <el-input v-model="ruleForm.password"></el-input>
        </el-form-item>
        <el-form-item label="头像" prop="name" v-if="title == '添加用户'">

          <!-- action="http://127.0.0.1:9998/upFile" 图片上传地址 -->
          <el-upload
            action="#"
            :on-change="handleChange"
            :before-upload="beforeAvatarUpload"
            list-type="picture-card"
            :auto-upload="false"
          >
            <i slot="default" class="el-icon-plus"></i>
            <div slot="file" slot-scope="{ file }">
              <img class="el-upload-list__item-thumbnail" :src="file.url" alt />
              <span class="el-upload-list__item-actions">
                <span class="el-upload-list__item-preview" @click="handlePictureCardPreview(file)">
                  <i class="el-icon-zoom-in"></i>
                </span>
                <span
                  v-if="!disabled"
                  class="el-upload-list__item-delete"
                  @click="handleDownload(file)"
                >
                  <i class="el-icon-download"></i>
                </span>
                <span
                  v-if="!disabled"
                  class="el-upload-list__item-delete"
                  @click="handleRemove(file)"
                >
                  <i class="el-icon-delete"></i>
                </span>
              </span>
            </div>
          </el-upload>
        </el-form-item>

      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取消</el-button>
        <!-- <el-button type="primary" @click="dialogFormVisible = false">确 定</el-button> -->
        <el-button type="primary" @click="submitForm('ruleForm')">确定</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "ElementProjectUserListView",

  data() {
    return {
      title: "添加用户",
      formLabelWidth: "120px",
      dialogFormVisible: false,
      ruleForm: {
        id: "",
        name: "",
        phone: "",
        password: ""
      },
      rules: {
        name: [
          { required: true, message: "不能为空", trigger: "blur" }
          // { min: 3, max: 5, message: "长度在 3 到 5 个字符", trigger: "blur" }
        ]
        // region: [
        //   { required: true, message: "请选择活动区域", trigger: "change" }
        // ],
        // date1: [
        //   {
        //     type: "date",
        //     required: true,
        //     message: "请选择日期",
        //     trigger: "change"
        //   }
        // ],
        // date2: [
        //   {
        //     type: "date",
        //     required: true,
        //     message: "请选择时间",
        //     trigger: "change"
        //   }
        // ],
        // type: [
        //   {
        //     type: "array",
        //     required: true,
        //     message: "请至少选择一个活动性质",
        //     trigger: "change"
        //   }
        // ],
        // resource: [
        //   { required: true, message: "请选择活动资源", trigger: "change" }
        // ],
        // desc: [{ required: true, message: "请填写活动形式", trigger: "blur" }]
      },
      tableData: [],
      page: 1,
      pageSize: 10,
      total: 0,
      searchText: "",
      file: {}
    };
  },

  mounted() {
    // 获取用户信息
    this.getUserList();
  },

  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          if (this.title == "编辑用户") {
            axios({
              url: "http://127.0.0.1:9998/user",
              method: "put",
              data: {
                id: this.ruleForm.id,
                username: this.ruleForm.name,
                phone: this.ruleForm.phone,
                password: this.ruleForm.password
              }
              // data:this.ruleForm
            })
              .then(res => {
                console.log(res);
                if (res.data.code == 200) {
                  this.dialogFormVisible = false;
                  this.ruleForm.name = "";
                  this.ruleForm.phone = "";
                  this.ruleForm.password = "";
                  this.getUserList();
                  this.$message({
                    type: "success",
                    message: "用户修改成功！"
                  });
                } else {
                  this.$message.error(res.data.msg);
                }
              })
              .catch(err => {
                this.$message.error(err.message);
              });
            F;
          } else {

            // let formdata = new FormData()
            // formdata.append('avatar', this.file)
            // formdata.append('username', this.ruleForm.name)
            // formdata.append('password', this.ruleForm.password)
            // formdata.append('phone', this.ruleForm.phone)
            
            axios({
              url: "http://127.0.0.1:9998/register",
              method: "post",
              data: {
                username: this.ruleForm.name,
                password: this.ruleForm.password,
                phone: this.ruleForm.phone,
                avatar:this.file,
              },
              // data:formdata,
              headers: {
                'Content-Type': 'multipart/form-data'
              },
            })
              .then(res => {
                console.log(res);
                if (res.data.code == 200) {
                  this.dialogFormVisible = false;
                  this.ruleForm.name = "";
                  this.ruleForm.password = "";
                  this.ruleForm.phone = "";
                  this.getUserList();
                  this.$message({
                    type: "success",
                    message: "用户添加成功！"
                  });
                } else {
                  this.$message.error(res.data.msg);
                }
              })
              .catch(err => {
                this.$message.error(err.message);
              });
          }
        } else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },

    // 获取用户信息
    getUserList() {
      axios({
        url: "http://127.0.0.1:9998/user/all",
        method: "GET"
        // params: {
        //   page: this.page,
        //   pageSize: this.pageSize
        // }
      }).then(res => {
        console.log(res);
        this.tableData = res.data.data;
        // this.total = res.data.total;
      });
    },

    // 修改用户的信息
    handleEdit(index, userInfo) {
      console.log(userInfo);
      this.dialogFormVisible = true;
      this.title = "编辑用户";
      this.ruleForm.name = userInfo.username;
      this.ruleForm.phone = userInfo.phone;
      this.ruleForm.id = userInfo.id;
      this.ruleForm.password = userInfo.password;
    },

    // 删除用户
    handleDelete(userInfo) {
      this.$confirm("您确定要删除用户吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(res => {
        // 调用删除的接口,实现删除的功能
        axios({
          url: "http://127.0.0.1:9998/user/" + userInfo.id,
          method: "delete"
        })
          .then(res => {
            if (res.data.code == 200) {
              // 刷新页面数据
              this.getUserList();
              this.$message({
                type: "success",
                message: "用户删除成功！"
              });
            }
          })
          .catch(() => {});
      });
    },
    // 添加用户的信息
    addUser() {
      this.dialogFormVisible = true;
      this.title = "添加用户";
    },

    // 搜索用户
    onSearch() {
      if (this.searchText != "") {
        axios({
          url: "http://127.0.0.1:9998/user/" + this.searchText,
          method: "get"
        }).then(res => {
          this.tableData = res.data.data;
          console.log(this.tableData);
        });
      } else {
        this.getUserList();
      }
    },

    // 监听分页切换事件
    pageChange(page) {
      console.log(page);
      this.page = page;
      this.getUserList();
    },

    // 文件上传之前的检查
    beforeAvatarUpload(file) {
      console.log(file);
      const isJPG = file.type === "image/jpeg" || file.type === "image/png";
      const isLt500K = file.size / 1024 < 500;

      if (!isJPG) {
        this.$message.error("上传头像图片只能是 JPG/PNG 格式!");
      }
      if (!isLt500K) {
        this.$message.error("上传头像图片大小不能超过 500KB!");
      }
      return isJPG && isLt500K;
    },
    // 头像上传
    handleChange(file) {
      this.file = file.raw;
      console.log(this.file);
    },
    // 删除图片
    handleRemove(file) {
      console.log(file);
    },

    // 点击查看按钮 查看图片
    handlePictureCardPreview(file) {
      console.log(file);
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    // 下载图片
    handleDownload(file) {
      console.log(file);
    }
  }
};
</script>

<!-- 当 <style> 标签有 scoped 属性时，它的 CSS 只作用于当前组件中的元素。 -->
<style lang="scss" scoped>
.home {
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
  .el-table {
    ::v-deep .el-table__cell {
      text-align: center;
    }
  }
}
</style>