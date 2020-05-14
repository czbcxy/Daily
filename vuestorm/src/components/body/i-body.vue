<template>
  <div>
    <div class="div-one" v-for="(data,index) in jsonData">
      <el-card class="box-card">
        <div slot="header">
          <span><h1><a href="javascript.void(0)">{{data.title}}</a></h1></span>
        </div>
        <div class="el-textarea">
          <span>
            <P><a href="javascript.void(0)">【{{data.category}}】</a>
            <a href="javascript.void(0)" class="active">{{data.mainbody}}</a>
            </P>
          </span>
          <br>
          <span class="el-alert--info"> Author: {{data.author}}</span>
          <span class="el-alert--info">CreateDate: {{data.createtime}}</span>
          <span class="el-alert--info">浏览量: {{data.lookCount}}</span>
          <div class="right-tab ">
            <!--v-if="index === index1"-->
            <b @click="nexticon(index,status)" >
              <img v-if="status === 1" :src="urlpng2" alt="点赞" style="height: 20px;width: 20px ">
              <img v-else :src="urlpng1" alt="点赞" style="height: 20px;width: 20px ">
              99+ </b>
            <img src="../../assets/icon/评论.png" alt="评论" style="height: 20px;width: 25px; margin-left: 15px"
                 @click="pinglun(index)"><b> 99+ </b>
          </div>
        </div>
        <div class="pinglun" style="margin-top: 20px" v-if="index === showPrise">
          <p>请写下你的评论：</p>
          <button @click="pinglun(index)">取消</button>
          <button @click="submit(data.author)">提交</button>
          <textarea ref="txs" class="txs" v-model="txs" cols="30" rows="10" style=" width: 100%; height: 75px;">
          </textarea>
        </div>
      </el-card>
      <br>

    </div>
    <div class="blocks">
      <div class="pageone">
        <p @click="Pone()"><a href="javascript:void(0)"><- 上一页</a></p>
      </div>
      <div class="pagetow">
        <p @click="Ptow()"><a href="javascript:void(0)">下一页 -></a></p>
      </div>
    </div>
  </div>
</template>

<script>

  export default {
    name: "i-body",
    data() {
      return {
        jsonData: [],
        pageSize: 0,
        showPrise: -1,
        dataList: [],
        urlpng1: '/static/icon/dz1.png',
        urlpng2: '/static/icon/dz2.png',
        status: 1,
        txs: '',
      };
    },
    created: function () {
      let tmp = new Array();
      this.pageSize = 1;
      var params = new URLSearchParams();
      params.append('pageSize', '1');
      this.$axios.post('/local', params)
        .then(function (response) {
          if (response.data.status === '200') {
            response.data.retList.forEach(x => tmp.push(x));
          }
        }).catch(function (error) {
        console.log(error);
      });
      this.jsonData = tmp;
    },
    methods: {
      Pone: function () {
        let count = this.pageSize;
        var count1 = count - 1;
        if (count1 === 0) {
          count1 = 1;
          this.$message.warning("已经是首页啦！")
        }
        console.log(count);
        let tmp = new Array();
        var params = new URLSearchParams();
        params.append('pageSize', count1);
        this.$axios.post('/local', params)
          .then(function (response) {
            if (response.data.status === '200') {
              response.data.retList.forEach(x => tmp.push(x));
            }
          }).catch(function (error) {
          console.log(error);
        });
        this.jsonData = tmp;
        this.pageSize = count1;
      },
      Ptow: function () {
        let total = 0;
        let count = this.pageSize;
        this.pageSize = count + 1;
        let tmp = new Array();
        var params = new URLSearchParams();
        params.append('pageSize', count);
        this.$axios.post('/local', params)
          .then(function (response) {
            if (response.data.status === '200') {
              total = response.data.totalCount;
              response.data.retList.forEach(x => tmp.push(x));
              console.log(total)
              if (total <= this.pageSize * 5) {
                this.$message.warning("已经没有资源啦！");
                this.pageSize = count - 1;
                return;
              }
            }
          }).catch(function (error) {
          console.log(error);
        });
        this.jsonData = tmp;
      },
      pinglun(count) {
        if (this.showPrise === -1) {
          this.showPrise = count;
        } else {
          this.showPrise = -1;
        }
      },
      nexticon(index, status) {
        if (status === 1) {
          this.status = 2;
          this.$message.success("已去消点赞")
        } else {
          this.status = 1;
          this.$message.success("已点赞")
        }
      },
      submit(userid) {
        this.$message.success("用户"+userid+"保存成功"+this.txs);
        this.pinglun(-1);
        this.txs = '';
      }
    }
  }
</script>

<style scoped>
  .div-one {
    background: white;
  }

  .box-card {
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  }

  .active {
    color: black;
  }

  .active:hover {
    color: #B4BF42;
  }

  .active:after {
    color: #C81623;
  }

  p {
    font-size: 13px;
  }

  /*分页*/
  /*.blocks {*/
  /*width: 100%;*/
  /*margin: 10px auto;*/
  /*text-align: center;*/
  /*}*/
  .pageone {
    float: left;
  }

  .pagetow {
    float: right;
  }

  .right-tab {
    width: 20%;
    height: 20px;
    float: right;
    /*background-color: #C81623;*/
  }


  b {
    color: #666666;
    font-size: 10px;
  }

  .pinglun {
    width: 100%;
    height: 100px;
    background-color: white;
    /*border: 3px solid wheat;*/

  }

  .pinglun p {
    float: left;
  }

  .pinglun button {
    display: inline;
    width: 40px;
    height: 20px;
    /*border: 1px solid antiquewhite;*/
    background-color: #fafafa;
    color: black;
    float: right;
    margin: 0 5px;
    border-radius: 5px;
    /*-moz-box-shadow: 10px 10px 5px #888888; !* 老的 Firefox *!*/
    /*box-shadow: 10px 10px 5px #888888;*/
  }

  .txs:focus{
    color:red;
  }


</style>
