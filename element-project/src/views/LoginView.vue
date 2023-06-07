<template>
  <div class="login">
    <div class="form">
      <div class="title">mall-admin</div>
      <el-form
        :model="ruleForm"
        status-icon
        :rules="rules"
        ref="ruleForm"
        label-width="100px"
        class="demo-ruleForm"
      >
        <el-form-item prop="userName">
          <el-input
            prefix-icon="el-icon-user-solid
"
            class="loginInput"
            type="text"
            v-model="ruleForm.userName"
            autocomplete="off"
            placeholder="请输入用户名"
          ></el-input>
        </el-form-item>
        <el-form-item prop="pass">
          <el-input
            prefix-icon="el-icon-lock
"
            class="loginInput"
            type="password"
            v-model="ruleForm.pass"
            autocomplete="off"
            placeholder="请输入密码"
          ></el-input>
        </el-form-item>

        <el-form-item>
          <el-button class="loginBtn" type="primary" @click="submitForm('ruleForm')">登录</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "ElementProjectLoginView",

  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入密码"));
      } else {
        callback();
      }
    };
    var validateUserName = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入用户名"));
      } else {
        callback();
      }
    };

    return {
      ruleForm: {
        userName: "",
        pass: ""
      },
      rules: {
        userName: [{ validator: validateUserName, trigger: "blur" }],
        pass: [{ validator: validatePass, trigger: "blur" }]
      }
    };
  },

  mounted() {},

  methods: {
    submitForm(formName) {
      this.$refs[formName].validate(valid => {
        if (valid) {
          this.$http({
            url: "http://127.0.0.1:9998//weburl/user/login",
            method: "post",
            data: {
              username: this.ruleForm.userName,
              password: this.ruleForm.pass
            },
            Headers:{
              "Content-Type":"application/json"
            }
          })
            .then(res => {
              if (res.data.code == 200) {
                console.log(res.data.data)
                this.$store.commit("setUser",res.data.data)
                this.$message.success("登录成功");
                this.$router.push({ name: "home" });
              } else {
                this.$message.error(res.data.msg);
              }
            })
            .catch(err => {
              this.$message.error(err.message);
            });

          // axios({
          //   url: "http://101.34.49.100:3001/user/login",
          //   method: "post",
          //   data: {
          //     username: this.ruleForm.userName,
          //     password: this.ruleForm.pass
          //   },
          //   headers: {
          //     "Content-Type": "application/json"
          //   }
          // })
          //   .then(res => {
          //     console.log(res);
          //     if (res.data.code == 200) {
          //       this.$message.success("登录成功");
          //       this.$router.push({ name: "home" });
          //     } else {
          //       this.$message.error("登录失败");
          //     }
          //   })
          //   .catch(err => {
          //     console.log(err.response.data.message);
          //     this.$message.error(err.response.data.message);
          //   });
        } else {
          console.log("error submit!!");
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  }
};
</script>

<style lang="scss" scoped>
.login {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  height: 100vh;

  .form {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    width: 500px;
    height: 300px;

    box-shadow: 0 1px 3px rgba(0, 0, 0, 0.12), 0 1px 2px rgba(0, 0, 0, 0.24);
    .title {
      color: #409eff;
      font-weight: 700;
      font-size: 50px;
      //   text-align: center;
      padding: 20px 0;
    }
    ::v-deep .el-form-item__content {
      margin-left: 0 !important;
    }

    .el-form {
      width: 80%;
    }

    .loginBtn {
      width: 100%;
    }
  }
}
</style>