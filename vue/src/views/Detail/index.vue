<script setup>

import { ref } from 'vue'
const count = ref(1)
const countChange = (count) => {
    console.log(count)
}
const addCart = () => {
    cart.addCart({
        id: 201,
        name: 'bra-feel 短版坦克背心',
        picture: 'https://www.gu-global.com/tw/hmall/test/u0000000008354/main/first/1000/1.jpg',
        price: 190,
        count: count.value,
        skuID: null,
        attrsText: null,
        selected: true

    })
}

let skuObj = {}
const skuChange = (sku) => {
    console.log(sku)
    skuObj = sku
}
</script>

<template>
    <div class="xtx-goods-page">
        <div class="container">
            <div class="bread-container">
                <el-breadcrumb separator=">">
                    <el-breadcrumb-item :to="{ path: '/' }">首頁</el-breadcrumb-item>
                    <el-breadcrumb-item :to="{ path: '/' }">WOMEN
                    </el-breadcrumb-item>
                    <el-breadcrumb-item :to="{ path: '/' }">上衣
                    </el-breadcrumb-item>
                    <el-breadcrumb-item>bra-feel短版坦克背心</el-breadcrumb-item>
                </el-breadcrumb>
            </div>
            <!-- 商品資訊 -->
            <div class="info-container">
                <div>
                    <div class="goods-info">
                        <div class="media">
                            <!-- 圖片預覽區 -->
                            <img src="https://www.gu-global.com/tw/hmall/test/u0000000008354/main/first/1000/1.jpg" alt="">
                            <!-- 統計數量 -->
                            <!-- <ul class="goods-sales">
                                <li>
                                    <p>銷量人氣</p>
                                    <p> 100+ </p>
                                    <p><i class="iconfont icon-task-filling"></i>銷量人氣</p>
                                </li>
                                <li>
                                    <p>商品評價</p>
                                    <p>200+</p>
                                    <p><i class="iconfont icon-comment-filling"></i>查看評價</p>
                                </li>
                                <li>
                                    <p>收藏人氣</p>
                                    <p>300+</p>
                                    <p><i class="iconfont icon-favorite-filling"></i>收藏商品</p>
                                </li>
                                <li>
                                    <p>品牌信息</p>
                                    <p>400+</p>
                                    <p><i class="iconfont icon-dynamic-filling"></i>品牌主頁</p>
                                </li>
                            </ul> -->
                        </div>
                        <div class="spec">
                            <!-- 商品資訊區 -->
                            <p class="g-name"> bra-feel 短版坦克背心 </p>
                            <p class="g-desc">
                                附罩杯的內搭坦克背心。美式削肩設計，在隱藏胸口的同時亦能享受健康的露膚造型。自然渾圓的罩杯，穿上外衣時亦可自然勾勒出優美的胸型。側面的彈性針織布能提升包覆。柔軟的下緣鬆緊帶設計，穿著時不易感受到束縛感。不僅可以作為短版上衣的內搭，亦可搭配外套或襯衫等外衣來打造若隱若現的造型。
                            </p>
                            <p class="g-price">
                                <span>190</span>
                                <span>390</span>
                            </p>
                            <div class="g-service">
                                <dl>
                                    <dt>促銷</dt>
                                    <dd>618超狂優惠，滿千再折200元!!!</dd>
                                </dl>
                                <dl>
                                    <dt>材質</dt>
                                    <dd>
                                        <span>聚酯纖維62%</span>
                                        <span>棉34%</span>
                                        <span>彈性纖維4%</span>
                                        <a href="javascript:;">瞭解詳情</a>
                                    </dd>
                                </dl>
                            </div>
                            <!-- sku組件 -->
                            <!-- 資料元件 -->
                            <el-input-number v-model="count" :min="0" @change="countChange" />
                            <!-- 按鈕元件 -->
                            <div>
                                <el-button size="large" class="btn" @click="addCart">
                                    加入購物車
                                </el-button>
                            </div>
                        </div>
                    </div>
                    <div class="goods-footer">
                        <div class="goods-article">
                            <!-- 商品詳情 -->
                            <div class="goods-tabs">
                                <nav>
                                    <a>商品詳情</a>
                                </nav>
                                <div class="goods-detail">
                                    <!-- 屬性 -->
                                    <ul class="attrs">
                                        <li v-for="item in 1" :key="item.value">
                                            <span class="dt">顏色</span>
                                            <span class="dd">渚色</span>
                                            <span class="dt">材質</span>
                                            <span class="dd">聚酯纖維62%<br>棉34%<br>彈性纖維4%</span>
                                        </li>
                                    </ul>
                                    <!-- 圖片 -->
                                    <img src="https://www.gu-global.com/tw/hmall/test/u0000000008354/main/other4/1000/5.jpg"
                                        alt="">
                                    <br><br>
                                    <img src="https://www.gu-global.com/tw/hmall/test/u0000000008354/main/other5/1000/6.jpg"
                                        alt="">
                                    <br><br>
                                    <img src="https://www.gu-global.com/tw/hmall/test/u0000000008354/main/other6/1000/7.jpg"
                                        alt="">
                                    <br><br>
                                    <img src="https://www.gu-global.com/tw/hmall/test/u0000000008354/main/other10/1000/11.jpg"
                                        alt="">
                                    <br><br>
                                    <img src="https://www.gu-global.com/tw/hmall/test/u0000000008354/main/other12/1000/13.jpg"
                                        alt="">
                                    <br><br>
                                    <img src="https://www.gu-global.com/tw/hmall/test/u0000000008354/main/other16/1000/17.jpg"
                                        alt="">
                                    <br><br>
                                    <img src="https://www.gu-global.com/tw/hmall/test/u0000000008354/main/other17/1000/18.jpg"
                                        alt="">
                                </div>
                            </div>
                        </div>
                        <!-- 24熱榜+專題推薦 -->
                        <div class="goods-aside">

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>


<style scoped lang='scss'>
.xtx-goods-page {
    .goods-info {
        min-height: 600px;
        background: #fff;
        display: flex;

        .media {
            width: 580px;
            height: 600px;
            padding: 30px 50px;
        }

        .spec {
            flex: 1;
            padding: 30px 30px 30px 0;
        }
    }

    .goods-footer {
        display: flex;
        margin-top: 20px;

        .goods-article {
            width: 940px;
            margin-right: 20px;
        }

        .goods-aside {
            width: 280px;
            min-height: 1000px;
        }
    }

    .goods-tabs {
        min-height: 600px;
        background: #fff;
    }

    .goods-warn {
        min-height: 600px;
        background: #fff;
        margin-top: 20px;
    }

    .number-box {
        display: flex;
        align-items: center;

        .label {
            width: 60px;
            color: #999;
            padding-left: 10px;
        }
    }

    .g-name {
        font-size: 22px;
    }

    .g-desc {
        color: #999;
        margin-top: 10px;
    }

    .g-price {
        margin-top: 10px;

        span {
            &::before {
                content: "$";
                font-size: 14px;
            }

            &:first-child {
                color: $priceColor;
                margin-right: 10px;
                font-size: 22px;
            }

            &:last-child {
                color: #999;
                text-decoration: line-through;
                font-size: 16px;
            }
        }
    }

    .g-service {
        background: #f5f5f5;
        width: 500px;
        padding: 20px 10px 0 10px;
        margin-top: 10px;

        dl {
            padding-bottom: 20px;
            display: flex;
            align-items: center;

            dt {
                width: 50px;
                color: #999;
            }

            dd {
                color: #666;

                &:last-child {
                    span {
                        margin-right: 10px;

                        &::before {
                            content: "•";
                            color: $xtxColor;
                            margin-right: 2px;
                        }
                    }

                    a {
                        color: $xtxColor;
                    }
                }
            }
        }
    }

    .goods-sales {
        display: flex;
        width: 400px;
        align-items: center;
        text-align: center;
        height: 140px;

        li {
            flex: 1;
            position: relative;

            ~li::after {
                position: absolute;
                top: 10px;
                left: 0;
                height: 60px;
                border-left: 1px solid #e4e4e4;
                content: "";
            }

            p {
                &:first-child {
                    color: #999;
                }

                &:nth-child(2) {
                    color: $priceColor;
                    margin-top: 10px;
                }

                &:last-child {
                    color: #666;
                    margin-top: 10px;

                    i {
                        color: $xtxColor;
                        font-size: 14px;
                        margin-right: 2px;
                    }

                    &:hover {
                        color: $xtxColor;
                        cursor: pointer;
                    }
                }
            }
        }
    }
}

.goods-tabs {
    min-height: 600px;
    background: #fff;

    nav {
        height: 70px;
        line-height: 70px;
        display: flex;
        border-bottom: 1px solid #f5f5f5;

        a {
            padding: 0 40px;
            font-size: 18px;
            position: relative;

            >span {
                color: $priceColor;
                font-size: 16px;
                margin-left: 10px;
            }
        }
    }
}

.goods-detail {
    padding: 40px;

    .attrs {
        display: flex;
        flex-wrap: wrap;
        margin-bottom: 30px;

        li {
            display: flex;
            margin-bottom: 10px;
            width: 50%;

            .dt {
                width: 100px;
                color: #999;
            }

            .dd {
                flex: 1;
                color: #666;
            }
        }
    }

    >img {
        width: 100%;
    }
}

.btn {
    margin-top: 20px;

}

.bread-container {
    padding: 25px 0;
}
</style>
