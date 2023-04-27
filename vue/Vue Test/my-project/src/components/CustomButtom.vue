<template>
    <div>
        <!-- 当点击子组件按钮，给父组件传递一个helloworld -->
        <button @click="onClick" :class="['btn',type]">{{title}}</button>
    </div>
</template>

<script>
export default {
    name: 'CustomButtom',
    // props 接收来自父组件的内容
    // props 语法 数组 对象
    // props ["title"]
    // 写法二 对象
    props:{
        // 接收父组件传进来的title属性
        // 做一些限制
        title:{
            // type:String,
            // 必传字段
            required:false,
            // 如果不传 设置默认值
            default:"默认按钮"
        },
        type:{
            type:String
        }
    },
    data() {
        return {
            
        };
    },

    mounted() {
        
    },

    methods: {
        onClick(){
            // 需要自定义一个事件，并且传递值到父组件当中 emit("自定义事件的名称"，需要传递的数据)
            this.$emit("to-transfer","helloWorld")
        }
    },
};
</script>

<style lang="scss" scoped>
    .btn{
        background-color: red;
        color: white;
    }
    .primart{
        background-color: blue;
    }
    .success{
        background-color: green;
    }
</style>