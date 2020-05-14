<template>
  <div class="background">
    <p class="login">
      <el-tabs v-model="activeName" @tab-click="handleClick">
          <h1>用户登录</h1>
        <br>
          <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="名称" prop="name">
              <el-input v-model="ruleForm.name"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="pass">
              <el-input type="password" v-model="ruleForm.pass" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item>
              <el-button type="primary" @click="submitForm('ruleForm')">登录</el-button>
              <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
          </el-form>
      </el-tabs>
    </p>
  </div>
</template>

<script>
  export default {
    name: "login",
    data() {
      var validatePass = (rule, value, callback) => {
        if (value === '') {
          callback(new Error('请输入密码'));
        } else {
          if (this.ruleForm.checkPass !== '') {
            this.$refs.ruleForm.validateField('checkPass');
          }
          callback();
        }
      };
      return {
        ruleForm: {
          name: '',
          pass: '',
          checkPass: '',
        },
        rules: {
          name: [
            {required: true, message: '请输入您的名称', trigger: 'blur'},
            {min: 2, max: 5, message: '长度在 2 到 5 个字符', trigger: 'blur'}
          ],
          pass: [
            {required: true, validator: validatePass, trigger: 'blur'}
          ]
        },
        height: '200px',
      };
    },
    methods: {
      //选项卡切换
      handleClick(tab, event) {
        this.$router.replace('/reg');
      },
      //重置表单
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
      //提交表单
      submitForm(formName) {
        // this.$store.commit('$_setLogin', '1');//没有网跳过
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var $message = this.$message;
            var $router = this.$router;
            var $store = this.$store;
            let data = new URLSearchParams();
            let ruleForm = this.ruleForm;
            data.append('username', ruleForm.name);
            data.append('password', ruleForm.pass);
            this.$axios.post("proxy/login", data)
              .then(function (data) {
                console.log(data.data);
                if (data.data == '1200') {
                  $message({
                    type: 'success',
                    message: '登录成功'
                  });
                  //记录登录信息状态
                  // $store.commit('$_setStorage', {user: ruleForm.name});
                  // $store.commit('$_setLogin', '1');
                  $router.replace('/');
                } else {
                  $message({
                    type: 'failure',
                    message: '登录失败，用户名或密码错误！'
                  });
                }
              }).catch(function (error) {
              console.log(error);
              $message({
                type: 'failure',
                message: '登录失败'
              });
            });
          } else {
            return false;
          }
        });
      },
    }
  }
</script>
<style scoped>
  .login {
    width: 64px;
    margin:200px auto;
    font-family: 'Avenir', Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    /*background-attachment: fixed;*/
    width: 300px;
  }

  .background {
    /*background-attachment: fixed;*/
    /*margin-top: 0;*/
    /*height: 500px;*/
    /*background-image: url('http://c.hiphotos.baidu.com/zhidao/pic/item/c83d70cf3bc79f3d0a1f1872bca1cd11738b29f2.jpg');*/
  }
</style>
