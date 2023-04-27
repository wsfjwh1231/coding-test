<template>
    <div class="bottomNav">
        <div :class="index==0?'blue':'bottomNavItem' " @click="toHome">
            <img v-if="index==0" src="../assets/home_active.png" alt="">
            <img v-else src="../assets/home.png" alt="">
            <div>首页</div>
        </div>
        <div :class="index==1?'blue':'bottomNavItem' " @click="toShoppingCar">
            <img v-if="index==1" src="../assets/cart_active.png" alt="">
            <img v-else src="../assets/cart.png" alt="">
            <div>购物车</div>
        </div>
        <div :class="index==2?'blue':'bottomNavItem' " @click="toMy">
            <img v-if="index==2" src="../assets/my_active.png" alt="">
            <img v-else src="../assets/my.png" alt="">
            <div>我的</div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'BottomNav',

    data() {
        return {
            index:0
        };
    },

    mounted() {
        
    },

    methods: {
        toHome(){
            // this.$route.push({
            //     name:""
            // })
            
            this.index=0
            this.$emit("getView",0)
        },
        toShoppingCar(){
            // this.$route.push({
            //     name:"shoppingCar"
            // })
            this.index=1
            this.$emit("getView",1)
        },
        toMy(){
            // this.$route.push({
            //     name:"my"
            // })
            this.index=2
            this.$emit("getView",2)
        },
    },
};
</script>

<style lang="scss" scoped>


.bottomNav{
    display: flex;
    justify-content: space-around;
    background: white;
    margin: 0 10px 10px 10px;
    box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);

    .bottomNavItem{
        font-size: 15px;
        img{
            height: 50px;
            width: 50px;
        }
    }
    
    .blue{
        color: rgba(8, 137, 241, 0.555);
        font-size: 15px;
        img{
            height: 50px;
            width: 50px;
        }
    }

}
</style>