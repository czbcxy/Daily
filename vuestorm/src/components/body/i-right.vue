<template>
  <div class="iright">
    <div class="li-right">
      <input type="type" v-bind:onclick="baidu()" value="java" v-model="inputfield" placeholder="找不到内容，记得全局搜索一下😯...">
      <!--<button class="button" v-bind:onclick="baidu()">Google</button>-->
    </div>
    <br>
    <div class="li-user">
      <h2>个人资料:</h2>
      <div class="user-head" style="margin-bottom: 15px">
        <img src="../../assets/lief.png" alt="头像"
             style="width: 45px;height: 45px;float: left;margin-left: 30px;border-radius: 100px;">
        <button class="button"  @click="FocusOn(FocusStatus)" v-model="FocusStatus">{{mes}}</button>
      </div>
      <hr>
      <div class="user-body">
        <p v-for="datauser in jsonuser">
          <b>{{datauser.name}}</b>
          <br>
          <b>{{datauser.num}}</b>
        </p>
      </div>
      <hr>
      <div class="user-body">
        <p v-for="userdata in userjson">
          <b>{{userdata.name}}</b>
          <b>{{userdata.num}}</b>
        </p>
      </div>
    </div>
    <div>
      <video ishivideo="false" autoplay="false" isrotate="false" autoHide="true" class="ivideo">
        <source src="https://pic.ibaotu.com/00/33/17/37j888piCMtk.mp4" type="video/mp4">
      </video>
      <div style="font-size: 18px ; text-align: center">
        <a
          href="https://ibaotu.com/shipin/7-5023-0-0-3-1.html?chan=bd&label=video&plan=D1-bd&kwd=4368&utm_source=%E7%99%BE%E5%BA%A6SEM&utm_medium=D1-bd&utm_campaign=ae%E6%A8%A1%E6%9D%BF%E4%B8%8B%E8%BD%BD&utm_term=%E5%88%9B%E6%84%8F">
          查看更多视频请点击</a></div>
    </div>
  </div>
</template>

<script>
  import userjson from '../../json/user1';
  import jsonuser from '../../json/user';

  export default {
    name: "right",
    data() {
      return {
        jsonuser: userjson,
        userjson: jsonuser,
        inputfield: '',
        FocusStatus: '1',
        mes: '关注',
      };
    },
    methods: {
      baidu: function () {
        var data = this.inputfield;
        console.log(data)
        this.$axios.get('/baidu' + data)
          .then(function (data) {
              // alert(data.data)
            }
          ).catch(function (error) {
          console.log(error);
        })
      },
      FocusOn(stauts) {
        console.log(stauts)
        if (stauts === '1'){
          this.FocusStatus = '0';
          this.mes = '已关注';
          this.$message.success("已关注");
        }else {
          this.FocusStatus = '1';
          this.mes = '关注';
          this.$message.success("已取消关注");
        }
      },
    }
  }
</script>

<style scoped>
  .iright {
    margin: 20px;
  }

  input {
    margin: 5px;
    width: 90%;
    height: 32px;
    border-radius: 5px;
  }

  .li-right {
    width: 98%;
    margin-left: 10px;
    background: white;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  }

  .button {
    background-color: #4CAF50;
    border: none;
    color: white;
    width: 80px;
    height: 40px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 8px;
    cursor: pointer;
    border-radius: 35px;
  }

  .button:hover {
    background-color: darkslateblue;
    border: none;
    color: white;
    width: 80px;
    height: 40px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 8px;
    cursor: pointer;
    border-radius: 35px;
  }

  .li-right > input:hover {
    background-color: greenyellow;
  }

  .li-user {
    width: 98%;
    height: auto;
    margin-left: 10px;
    text-align: center;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
    background: white;
  }

  h2 {
    text-align: left;
    margin-left: 20px;
    line-height: 48px;
    font-size: 14px;
    font-weight: bold;
    text-shadow: 5px 5px 5px #FF0000;
  }

  .user-head {
    overflow: hidden;
  }

  .user-body > p {
    display: inline-block;
    margin: 6%;
  }

  .ivideo {
    width: 98%;
    height: 200px;
    margin: 10px;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  }

</style>
