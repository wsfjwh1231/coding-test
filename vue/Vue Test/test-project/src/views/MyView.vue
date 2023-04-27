<template>
    <div class="my">
        <!-- <TopNav :title="msg"></TopNav> -->
        <div class="myIconList">
            <div class="myIconItem">
                <img src="../assets/payment.png" alt="待付款">
                <div>待付款</div>
            </div>
            <div class="myIconItem">
                <img src="../assets/deliver.png" alt="待发货">
                <div>待发货</div>
            </div>
            <div class="myIconItem">
                <img src="../assets/pick.png" alt="待收货">
                <div>待收货</div>
            </div>
            <div class="myIconItem">
                <img src="../assets/evaluate.png" alt="待评价">
                <div>待评价</div>
            </div>
            <div class="myIconItem">
                <img src="../assets/after-sale.png" alt="退款/售后">
                <div>退款/售后</div>
            </div>
        </div>
    </div>
    
</template>

<script>
import TopNav from '@/components/TopNav.vue';
export default {
    name: 'MyView',

    data() {
        return {
            msg:"我的",
            iconList:[
                {
                    name:"待付款",
                    img:"../assets/payment.png"
                },
                {
                    name:"待发货",
                    img:"../assets/deliver.png"
                },
                {
                    name:"待收货",
                    img:"../assets/pick.png"
                },
                {
                    name:"待评价",
                    img:"../assets/evaluate.png"
                },
                {
                    name:"退款/售后",
                    img:"../assets/after-sale.png"
                }
            ]
        };
    },

    mounted() {
        
    },

    methods: {
        
    },
    components:{
        TopNav
    }
};
</script>

<style lang="scss" scoped>
.my{
    margin: 0 10px;
    
    .myIconList{
        display: flex;
        justify-content: space-around;
        background-color: white;
        margin: 10px 0; 
        padding: 10px;
        height: 52vh;
        font-size: 10px;
        .myIconItem{
            
        }
    } 
}


</style>