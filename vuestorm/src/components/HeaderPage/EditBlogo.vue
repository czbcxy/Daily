<template>
  <div class="editbody">
    <div class="newblogo">新建博客</div>
    <div class="editormd">
      <p hidden>用户id</p>
      <div>
        <el-select class="topic" v-model="value8" filterable placeholder="请选择分类">
          <el-option
            v-for="item in options"
            :key="item.asnum"
            :label="item.topic"
            :value="item.asnum">
          </el-option>
        </el-select>
        <input class="isize" type="text" filterable placeholder="请输入标题">
      </div>
      <div>
        <textarea class="ibody" type="text" filterable placeholder="正文">
        </textarea></div>
    </div>
  </div>
</template>

<script>
  export default {
    name: "edit-blogo",
    data() {
      return {
        options: [{
              value: '01',
              label: 'Java'
            }],
        value8: ''
      }
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
    methods: {},
  //   [{
  //     value: '01',
  //     label: 'Java'
  //   }, {
  //   value: '02',
  //     label: 'C++'
  // }, {
  //   value: '03',
  //     label: 'Html'
  // }, {
  //   value: '04',
  //     label: 'python'
  // }]

  }
</script>

<style scoped>
  .newblogo {
    width: 100%;
    height: 65px;
    background-color: blanchedalmond;
    border-bottom: 2px solid darkslateblue;
    font-size: 24px;
    font-family: "Helvetica Neue", Helvetica, "PingFang SC", "Hiragino Sans GB", "Microsoft YaHei", "微软雅黑", Arial, sans-serif;
    text-align: center;
    line-height: 64px;
  }

  .editormd {
    text-align: center;
    width: 100%;
    height: 700px;
    /*border: 3px solid blanchedalmond;*/
    background-color: wheat;
    margin: 0 auto;
    /*box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);*/
  }

  .isize  {
    width: 500px;
    height: 40px;
  }

  .topic{
    width: 200px;
  }

  .ibody {
    width: 50%;
    height: 600px;
  }

</style>
