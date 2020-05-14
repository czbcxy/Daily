<template>
  <div class="i-body">
    <div class="i-left ">
      <div class="i-left-fiexd">
        <ileft/>
      </div>
    </div>
    <div class="i-content">
        <ibody/>
    </div>
    <div class="i-right">
      <div class="i-right-fiexd">
        <iright/>
      </div>
    </div>
  </div>
</template>


<script>
  import ileft from './body/i-left'
  import iright from './body/i-right'
  import ibody from './body/i-body'

  export default {
    name: "MyFoot",
    components: {ileft, iright, ibody},
    comments: [ileft, iright, ibody],
  };
</script>

<style scoped>
  .i-body {
    width: 94%;
    /*background-color: beige;*/
    overflow: hidden;
    word-wrap: break-word;
    margin: 0 auto;
  }

  .i-left {
    width: 25%;
    float: left;
  }

  .i-right-fiexd {
    position: fixed;
  }

  .i-content {
    width: 50%;
    margin: 0 auto;
    float: left;
    /*box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);*/
  }

  .i-right {
    width: 25%;
    float: right;
  }

</style>
