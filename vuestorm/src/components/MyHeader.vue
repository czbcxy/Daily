<template>
  <div class="onehead" style="background-color: whitesmoke;border-bottom:2px solid #666666">
    <div class="title">
      <a href="#">WellCome To My blogo</a>
    </div>
    <div class="MenuItem">
      <a href="#"><img src="../assets/bianji.png" alt="" > <router-link to="EditBlogo">写博客</router-link></a>
      <a href="#"><img src="../assets/lief.png" alt="" > 生命线</a>
      <a href="#"><img src="../assets/settings.png" alt="" > 设置</a>
      <a href="#"><img src="../assets/sign-in.png" alt="" >
        <router-link to="login">登录</router-link>
        <a href="#">/</a>
        <a href="#">注册</a>
      </a>
    </div>
  </div>
</template>

<script>
  export default {
    name: 'MyHeader',
    data() {
      return {}
    }
  }
</script>

<style scoped>
  .onehead {
    left: 0px;
    position: fixed;
    width: 100%;
  }

  .MenuItem {
    float: right;
    line-height: 48px;
  }

  div {
    display: inline;
    margin-right: 30px;
  }

  img {
    width: 45px;
    height: 45px;
  }

  .MenuItem > a {
    margin-right: 10px;
    font-size: 14px;
  }

  .title > a {
    float: left;
    line-height: 48px;
    margin-left: 66px;
    font-size: 20px;
    text-shadow: 5px 5px 5px #FF0000;
  }

  a>img{
    width: 16px;
    height: 16px;
  }

</style>
