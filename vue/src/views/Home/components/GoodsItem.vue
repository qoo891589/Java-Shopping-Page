<script setup>
defineProps({
    good: {
        type: Object,
        default: () => { }
    }
})

</script>

<template>
    <RouterLink to="/detail" class="goods-item">
        <img v-img-lazy="good.picture" alt="" />
        <p class="name ellipsis">{{ good.name }}</p>
        <p class="desc ellipsis">{{ good.desc }}</p>
        <p class="price">NT${{ good.price }}</p>
    </RouterLink>
</template>

<style lang="scss">
.goods-item {
    display: block;
    width: 220px;
    padding: 10px 15px;
    text-align: center;
    transition: all .5s;

    &:hover {
        transform: translate3d(0, -3px, 0);
        box-shadow: 0 3px 8px rgb(0 0 0 / 20%);
    }

    img {
        width: 175px;
        height: 175px;
    }

    p {
        padding-top: 10px;
    }

    .name {
        font-size: 18px;
    }

    .desc {
        color: #999;
        height: 29px;
    }

    .price {
        color: $priceColor;
        font-size: 20px;
    }
}
</style>