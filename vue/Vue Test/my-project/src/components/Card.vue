<template>
    <div class="card">
        <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQAWBHgUNGQn84Z6Q0gokaw_PD-PS4gJxO5FR8yKn4f&s" alt="">
        <div class="right">
            <p>商品描述</p>
            <p>商品描述</p>
            <div class="price">
                <span>￥2.00</span>
                <span>￥2.00</span>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: 'MyProjectCard',

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

<!-- css是css的预处理器-->
<style lang="scss" scoped>
    .card{
        // background-color: red;
        width: 50%;
        display: flex;
        // justify-content: flex-start;
        padding: 15px 10px;
        img{
            width: 100px;
        }
        .right{
            
            flex: 1;
            text-align: left;
            margin: 10px 0 0 10px;
            .price{
                display: flex;
                justify-content: space-between;
                span:last-child{
                    color: #999;
                }
            }
        }
    }
</style>