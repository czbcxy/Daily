<template>
  <div>
      <MyHeader/>
      <div style="height: 50px"></div>
      <MyFoot/>
      <MyButton/>
  </div>
</template>

<script>
  import MyHeader from './MyHeader'
  import MyFoot from './MyFoot'
  import MyButton from './MyButton'

  export default {
    components: {
      MyFoot,
      MyHeader,
      MyButton
    },
    name: "app-main",
    comments: [MyHeader, MyFoot,MyButton]
  }
</script>

<style scoped>

</style>
