<template>
  <div class="addCategory">
    <div class="form">
      <el-form
        :model="ruleForm"
        :rules="rules"
        ref="ruleForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item label="分类名称" prop="catName">
          <el-input v-model="ruleForm.catName"></el-input>
        </el-form-item>

        <el-form-item label="上级分类" prop="region">
          <el-select v-model="ruleForm.catId" placeholder="无上级分类">
            <el-option label="无上级分类" value="0"></el-option>
            <el-option
              :label="item.catName"
              :value="item.catId"
              v-for="item in tableData"
              :key="item.catId"
            ></el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="分类图" prop="name">
          <el-upload action="#" list-type="picture-card" :auto-upload="false" >
            <i slot="default" class="el-icon-plus"></i>
            <div slot="file" slot-scope="{file}">
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
          <el-dialog :visible.sync="dialogVisible">
            <img width="100%" :src="dialogImageUrl" alt />
          </el-dialog>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" @click="submitForm('ruleForm')">提交</el-button>
          <el-button @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "ElementProjectAddCategoryView",

  data() {
    return {
      dialogImageUrl: "",
      dialogVisible: false,
      disabled: false,
      tableData: [],
      ruleForm: {
        catId: "",
        // 选择的分类名称
        catName: "",
        file: ""
      },
      rules: {
        catName: [
          { required: true, message: "请输入分类名称", trigger: "blur" }
        ]
      }
    };
  },

  mounted() {
    this.getCategoryList();
  },

  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          alert("submit!");
          this.addCategory();
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
    getCategoryList(data) {
      axios({
        url: "http://101.34.49.100:3001/categoryLevelOneList",
        method: "GET"
      }).then(res => {
        console.log(res);
        this.tableData = res.data.list;

        // 分类名称集合
        for (let index = 0; index < this.tableData.length; index++) {
          this.categoryName.push(this.tableData[index].catName);
        }
        console.log(this.categoryName);
      });
    },

    // 创建分类
    addCategory() {
      axios({
        url: "http://101.34.49.100:3001/addCategory",
        method: "POST",
        data: {
          category_id: this.ruleForm.catId,
          catName: this.ruleForm.catName,
          file: this.ruleForm.file
        },
        headers:{
            "Content-Type":"multipart/form-data"
        }
      })
        .then(res => {
          console.log(res);
          if (res.data.code == 200) {
            //   成功 跳转分类列表界面
            this.$message({
              type: "success",
              message: res.data.msg
            });

            this.$router.push({
              name: "category"
            });

            
          } else {
            this.$message({
              type: "error",
              message: "分类创建失败！"
            });
          }
        })
        .catch(err => {
          console.log(err);
          console.log(err.response.data.message);
          this.$message.error(err.response.data.message);
        });
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
    },

    upload(event, file, fileList){
        console.log(event)
        console.log(file)
        console.log(fileList)
    }
  }
};
</script>

<style lang="scss" scoped>
.avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
}
.avatar-uploader .el-upload:hover {
  border-color: #409eff;
}
.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 178px;
  height: 178px;
  line-height: 178px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}

.addCategory {
  display: flex;
  justify-content: center;
  margin-top: 200px;
  height: 100vh;
  .form {
    width: 40%;
  }
}
</style>