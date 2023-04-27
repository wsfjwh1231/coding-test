<template>
    <div class="topNav">
        <slot name="left">
            <img src="../assets/back.png" alt="后退">
        </slot>
        <span>{{title}}</span>
        <slot name="left">
            <img v-show="title == '首页'" src="../assets/search.png" alt="搜索">
            <button v-show="title == '购物车'">管理</button>
            <button v-show="title == '我的'">登录</button>
        </slot>
    </div>
    
</template>

<script>
export default {
    name: 'TestProjectTopNav',
    props:['title'],
    data() {
        return {
            
        };
    },

    mounted() {
        
    },

    methods: {
        
    },
};
</script>

<style lang="scss" scoped>
.topNav{
    // background-color:red;
    width: 100%;
    display: flex;
    justify-content: space-between;
    align-items: center;
    background-color: white;
    // margin: 0 10px 10px 10px;
    height: 50px;
    font-weight: 600;
    img{
        height: 20px;
        width: 20px;
        margin: 0 20px 0 20px;
    }
    button{
        margin: 0 20px 0 20px;
    }
    box-shadow: 0 1px 3px rgba(0,0,0,0.12), 0 1px 2px rgba(0,0,0,0.24);
}
</style>