<template>
    <div>
        登录界面
        <p>传递过来的用户名是:{{$route.params.username}}</p>
        <p>传递过来的年龄是:{{$route.params.age}}</p>
        <!-- 使用刚刚封装的按钮组件 -->
        <!-- 调用子组件的，顺便传值过去 -->
        <CustomButtom></CustomButtom>
        <CustomButtom @to-transfer="recived"  type="primart" title="主要按钮"></CustomButtom>
        <CustomButtom type="success" title="成功按钮"></CustomButtom>
        <CustomButtom title="默认按钮"></CustomButtom>
        <CustomButtom :title="num"></CustomButtom>
        <CustomButtom ></CustomButtom>
        <h1>子组件传递过来的值是:{{msg}}</h1>
    </div>
    
    
</template>



<script>
// 1、引入组件 import
import CustomButtom from '@/components/CustomButtom.vue';
// 2、注册组件
export default {
    name: 'LoginView',
    
    data() {
        return {
            num:111,
            msg:""
        };
    },
    // 注册组件
    components:{
        CustomButtom
    },

    mounted() {
        
    },

    methods: {
        recived(data){
            this.msg = data
        }
    },
    computed:{

    },
    watch:{

    }
};
</script>

<style lang="scss" scoped>

</style>