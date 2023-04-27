<template>
    <div class="nav">
        <div class="nav-bar">
            <slot name="left">
                <img src="../assets/magnifying-glass.svg" alt="">
            </slot>
            
            <span>{{title}}</span>
            
            <!-- 插槽 slot -->
            <slot name="right">
                <button>按钮</button>
            </slot>
            <!-- 无名插槽 -->
            <!-- 有名插槽 -->
        </div>
        
        
        
    </div>
    
    

    
</template>

<script>
export default {
    name: 'MyProjectNavBar',
    props:["title"],
    data() {
        return {
            commodityInfo:{
                name:"ipad Pro 12.9",
                describe:"2018年款 超高清",
                price:1988
            }
        };
    },
    mounted() {
        
    },

    methods: {
        
    },
    filters:{
        priceFun(e){
            return "￥" + e
        }
    }
};
</script>

<style lang="scss" scoped>
.nav-bar{
    width: 100%;
    display: flex;
    justify-content:space-between
    
}

.gray{
    color: gray;
}



</style>