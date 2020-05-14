<template>
  <div class="ileft">
    <div class="li-left1">
      <br>
      <div><h2>分门别类：</h2></div> <br>
      <div class="li-left" v-for="(data,index)  in options">
        <a :href="data.url" target="_self" class="li-header-div">{{data.topic}}</a>
      </div>
    </div>
    <br>
    <div class="li-left1">
      <br>
      <div><h2>友情链接：</h2></div> <br>
      <div class="li-left" v-for="(data,index)  in jsondata">
        <a :href="data.url" target="_self" class="li-header-div">{{data.name}}</a>
      </div>
    </div>
    <br>
    <div class="particles-js">
    </div>
  </div>
</template>

<script>
  import data from '../../json/targer';
  export default {
    name: "left",

    data() {
      return {
        jsondata: data,
        options: [{
          value: '01',
          label: 'Java'
        }],
      };
    },
    created: function () {
      let what = this;
      this.$axios.post("/topic", null)
        .then(function (data) {
          what.options = data.data.retList;
          console.log(data.data.retList)
        }).catch(function (error) {
        console.log(error)
      })
    },
  }
</script>

<style scoped>

  h2 {
    text-align: left;
    margin-left: 20px;
    line-height: 48px;
    font-size: 14px;
    font-weight: bold;
    text-shadow: 5px 5px 5px #FF0000;
  }

  .li-left1 {
    margin: 20px;
    background: white;
    box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  }

  .li-left {
    margin-left: 25px;
    display: inline;
  }

  .li-left > a {
    margin: 5px 5px;
  }

  .li-header-div {
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
    background: beige;
    width: 60px;
    height: 30px;
    display: inline-block;
    color: blue;
    text-align: center;
    line-height: 30px;
    margin-right: 15px;
  }

  .li-header-div:hover {
    -webkit-border-radius: 5px;
    -moz-border-radius: 5px;
    border-radius: 5px;
    background: hotpink;
    width: 70px;
    height: 40px;
    display: inline-block;
    text-align: center;
    color: white;
    line-height: 30px;
    margin-right: 5px;
  }
</style>
