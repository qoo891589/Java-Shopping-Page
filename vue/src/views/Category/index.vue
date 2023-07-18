<script setup>
import { useRoute } from 'vue-router';
import { ref, onMounted } from 'vue';
import GoodsItem from '../Home/components/GoodsItem.vue';
import { onBeforeRouteUpdate } from 'vue-router';


import { getCategoryAPI } from '@/apis/category';
const categoryData = ref({})
const route = useRoute()
const getCategory = async (id = route.params.id) => {
    const res = await getCategoryAPI(id)
    categoryData.value = res.result
}
onMounted(() => getCategory())


onBeforeRouteUpdate((to) => {
    console.log("route變化了")
    getCategory(to.params.id)
})


import { getBannerAPI } from '@/apis/home';
const bannerList = ref([])
const getBanner = async () => {
    const res = await getBannerAPI({
        distributionSite: '2',
    })
    console.log(res)
    bannerList.value = res.result
}
onMounted(() => getBanner())
</script>


<template>
    <div class="top-category">
        <div class="container m-top-20">
            <!-- <div class="bread-container">
                <el-breadcrumb separator=">">
                    <el-breadcrumb-item :to="{ path: '/' }">HOME</el-breadcrumb-item>
                    <el-breadcrumb-item>{{ categoryData.name }}</el-breadcrumb-item>
                </el-breadcrumb>
            </div> -->

            <div class="home-banner">
                <el-carousel height="500px">
                    <!-- <el-carousel-item v-for="item in bannerList" :key="item.id"> -->
                    <el-carousel-item>
                        <img src='https://www.gu-global.com/tw/public/gutw/l1/2023/0714/women/w_hero_1_pc.jpg' alt="">
                    </el-carousel-item>

                </el-carousel>
            </div>

            <div class="sub-list">
                <h3>全部分類</h3>
                <ul>
                    <li v-for="i in categoryData.children" :key="i.id">
                        <RouterLink to="/detail">
                            <img :src="i.picture" />
                            <p>{{ i.name }}</p>
                        </RouterLink>
                    </li>
                </ul>
            </div>
            <div class="ref-goods" v-for="item in  categoryData.children " :key="item.id">
                <div class="head">
                    <h3>- {{ item.name }}-</h3>
                </div>
                <div class="body">
                    <ul class="goods-list">
                        <GoodsItem v-for="good in item.goods" :good="good" :key="good.id" />
                    </ul>
                </div>
            </div>
        </div>
    </div>
</template>


<style scoped lang="scss">
.goods-list {
    width: 1800px;
    display: flex;
    flex-wrap: wrap;

    s li {
        width: 240px;
        height: 300px;
        margin-right: 10px;
        margin-bottom: 10px;

        &:nth-last-child(-n + 4) {
            margin-bottom: 0;
        }

        &:nth-child(4n) {
            margin-right: 0;
        }
    }
}

.home-banner {
    width: 1240px;
    height: 500px;
    margin: 0 auto;
    left: 0;
    top: 0;


    img {
        width: 100%;
        height: 500px;
    }
}

.top-category {
    h3 {
        font-size: 28px;
        color: #666;
        font-weight: normal;
        text-align: center;
        line-height: 100px;
    }

    .sub-list {
        margin-top: 20px;
        background-color: #fff;

        ul {
            display: flex;
            padding: 0 32px;
            flex-wrap: wrap;

            li {
                width: 168px;
                height: 160px;


                a {
                    text-align: center;
                    display: block;
                    font-size: 16px;

                    img {
                        width: 100px;
                        height: 100px;
                    }

                    p {
                        line-height: 40px;
                    }

                    &:hover {
                        color: $xtxColor;
                    }
                }
            }
        }
    }

    .ref-goods {
        background-color: #fff;
        margin-top: 20px;
        position: relative;

        .head {
            .xtx-more {
                position: absolute;
                top: 20px;
                right: 20px;
            }

            .tag {
                text-align: center;
                color: #999;
                font-size: 20px;
                position: relative;
                top: -20px;
            }
        }

        .body {
            display: flex;
            justify-content: space-around;
            padding: 0 40px 30px;
        }
    }

    .bread-container {
        padding: 25px 0;
    }
}
</style>