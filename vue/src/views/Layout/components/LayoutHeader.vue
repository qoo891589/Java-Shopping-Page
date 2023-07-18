<script setup>
import { UserFilled } from '@element-plus/icons-vue'
import HeaderCart from './HeaderCart.vue'

import { useCategorytore } from '@/stores/category';
const categoryStore = useCategorytore()

</script>

<template>
    <header class='app-header'>
        <div class="container">
            <h1 class="logo">
                <RouterLink to="/">HOME</RouterLink>
            </h1>
            <ul class="app-header-nav">
                <!-- <li class="home" v-for="item in categoryList" :key="item.id"> -->
                <li class="home">
                    <RouterLink to="/">HOME</RouterLink>
                </li>
                <li class="home" v-for="item in categoryStore.categoryList  " :key="item.id">
                    <RouterLink active-class="active" :to="`/category/${item.id}`">{{ item.name }}</RouterLink>
                </li>
            </ul>

            <div class="search">
                <i class="fa-solid fa-magnifying-glass fa-bounce"></i>
                <input type="text" placeholder="搜尋">
            </div>
            <!-- 頭部購物車 -->
            <HeaderCart />
            <nav class="app-topnav">
                <ul>
                    <template v-if="true">
                        <el-dropdown>
                            <span class="el-dropdown-link">
                                <li><a href="javascript:/;"><i class=" iconfont icon-user"></i>
                                        <div>
                                            <el-avatar
                                                src="https://cdn4.iconfinder.com/data/icons/general-office/91/General_Office_33-512.png" />
                                        </div>
                                    </a></li>
                                <el-icon class="el-icon--right">
                                </el-icon>
                            </span>
                            <template #dropdown>
                                <el-dropdown-menu>
                                    <el-dropdown-item>
                                        <RouterLink to="/member">
                                            <li><a href="javascript:;">會員中心</a></li>
                                        </RouterLink>
                                    </el-dropdown-item>

                                    <el-dropdown-item>
                                        <RouterLink to="/member/order">
                                            <li><a href="javascript:;">我的訂單</a></li>
                                        </RouterLink>
                                    </el-dropdown-item>

                                    <el-dropdown-item>
                                        <RouterLink to="/login">
                                            <li><a href="javascript:;">回到登入頁</a></li>
                                        </RouterLink>
                                    </el-dropdown-item>

                                    <el-dropdown-item>
                                        <li>
                                            <el-popconfirm title="確認要登出嗎?" confirm-button-text="確認" cancel-button-text="取消">
                                                <template #reference>
                                                    <a href="javascript:;">登出</a>
                                                </template>
                                            </el-popconfirm>
                                        </li>
                                    </el-dropdown-item>
                                </el-dropdown-menu>
                            </template>
                        </el-dropdown>

                    </template>
                    <template v-else>
                        <li><a href="javascript:;" @click="$router.push('/login')">登錄/註冊</a></li>
                    </template>
                </ul>

            </nav>
        </div>


    </header>
</template>


<style scoped lang='scss'>
.app-header {
    background: #fff;

    .container {
        display: flex;
        align-items: center;
    }



    .logo {
        width: 200px;

        a {
            display: block;
            height: 132px;
            width: 100%;
            text-indent: -9999px;
            background: url('@/assets/images/logo.png') no-repeat center 18px / contain;
        }
    }

    .app-header-nav {
        width: 800px;
        display: flex;
        // padding-left: 40px;
        position: relative;
        z-index: 998;
        justify-content: space-evenly;

        li {
            margin-right: 40px;
            // width: 38px;
            text-align: center;

            a {
                font-size: 20px;
                line-height: 32px;
                height: 32px;
                display: inline-block;
                // padding: 7px 30px;

                &:hover {
                    color: $xtxColor;
                    // border-bottom: 1px solid $xtxColor;
                    // background-color: $xtxColor;
                }
            }

            .active {
                color: $xtxColor;
                border-bottom: 1px solid $xtxColor;
            }
        }
    }

    .search {
        width: 170px;
        height: 32px;
        position: relative;
        border-bottom: 1px solid #e7e7e7;
        line-height: 32px;

        .icon-search {
            font-size: 18px;
            margin-left: 5px;
        }

        input {
            width: 140px;
            padding-left: 5px;
            color: #666;
        }
    }

    .cart {
        width: 50px;

        .curr {
            height: 32px;
            line-height: 32px;
            text-align: center;
            position: relative;
            display: block;

            .icon-cart {
                font-size: 22px;
            }

            em {
                font-style: normal;
                position: absolute;
                right: 0;
                top: 0;
                padding: 1px 6px;
                line-height: 1;
                background: $helpColor;
                color: #fff;
                font-size: 12px;
                border-radius: 10px;
                font-family: Arial;
            }
        }
    }
}

.app-topnav {
    background: #ffffff;

    ul {
        display: flex;
        height: 53px;
        justify-content: flex-end;
        align-items: center;

        li {
            a {
                padding: 0 4px;
                color: #111;
                line-height: 1;
                display: inline-block;

                i {
                    font-size: 14px;
                    margin-right: 2px;
                }

                &:hover {
                    color: $xtxColor;
                }
            }

            ~li {
                a {
                    border-left: 2px solid #666;
                }
            }
        }
    }
}

.demo-type {
    display: flex;
}

.demo-type>div {
    flex: 1;
    text-align: center;
}

.demo-type>div:not(:last-child) {
    border-right: 1px solid var(--el-border-color);
}

.example-showcase .el-dropdown-link {
    cursor: pointer;
    color: var(--el-color-primary);
    display: flex;
    align-items: center;
}
</style>
