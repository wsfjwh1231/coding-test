<template>
  <div class="shoppingCar">
    <!-- <TopNav :title="msg"></TopNav> -->
    <Content></Content>
  </div>
</template>

<script>
import TopNav from '@/components/TopNav.vue';
import Content from '@/components/Content.vue';
export default {
  name: 'TestProjectShoppingCar',

  data() {
    return {
      msg:"购物车"
    };
  },

  mounted() {
    
  },

  methods: {
    
  },
  components:{
    TopNav,
    Content
  }
};
</script>

<style lang="scss" scoped>

.shoppingCar{
  // height: 60vh;
  background-color:rgb(184, 179, 179);
  margin: 0 10px 0 10px;
}
</style>