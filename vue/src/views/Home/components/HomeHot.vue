<script setup>
import { ref, onMounted } from 'vue';
import HomePanel from './HomePanel.vue';
import { findHotAPI } from '@/apis/home'


const hotList = ref([])

const getHotList = async () => {
    const res = await findHotAPI()
    hotList.value = res.result
}

onMounted(() => {
    getHotList()
})

</script>

<template>
    <HomePanel title="最新活動" sub-title="本季最新優惠活動">
        <ul class="goods-list">
            <li v-for="item in hotList" :key="item.id">
                <!-- <RouterLink :to="'/detail/${item.id}`'"> -->
                <RouterLink :to="'/detail'">
                    <img v-img-lazy="item.picture" alt="" />
                    <p class="name">{{ item.title }}</p>
                    <p class="price">{{ item.alt }}</p>
                </RouterLink>
            </li>
        </ul>
    </HomePanel>
</template>

<style scoped lang='scss'>
.goods-list {
    display: flex;
    justify-content: space-between;
    height: 426px;

    li {
        width: 306px;
        height: 406px;
        transition: all .5s;

        &:hover {
            transform: translate3d(0, -3px, 0);
            box-shadow: 0 3px 8px rgb(0 0 0 / 20%);
        }

        img {
            width: 306px;
            height: 306px;
        }

        p {
            font-size: 22px;
            padding-top: 12px;
            text-align: center;
        }

        .desc {
            color: #999;
            font-size: 18px;
        }
    }
}
</style>
