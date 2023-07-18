<script setup>
import { ref } from 'vue'

const form = ref({
    account: '',
    password: '',
    agree: true
})

const rules = {
    email: [
        { required: true, message: '*必填選項', trigger: 'blur' }
    ],
    password: [
        { required: true, message: '*必填，6-14個字元', trigger: 'blur' },
        { min: 6, max: 24, message: '密碼為6-14個字元', trigger: 'blur' }
    ],
    phone: [
        { required: true, message: '*必填', trigger: 'blur' },
        { min: 10, max: 10, message: '電話為10位純數字', trigger: 'blur' }
    ],
    agree1: [
        {
            validator: (rule, val, callback) => {
                return val ? callback() : new Error('請先閱讀條款並勾選同意')
            }
        }
    ],
    agree2: [
        {
            validator: (rule, val, callback) => {
                return val ? callback() : new Error('請先閱讀條款並勾選同意')
            }
        }
    ]
}
const formRef = ref(null)
</script>

<template>
    <div>
        <header class="login-header">
            <div class="container m-top-20">
                <h1 class="logo">
                    <RouterLink to="/">JP Shop</RouterLink>
                </h1>
                <RouterLink class="entry" to="/">
                    我想先逛逛>>
                    <i class="iconfont icon-angle-right"></i>
                    <i class="iconfont icon-angle-right"></i>
                </RouterLink>
            </div>
        </header>
        <section class="login-section">
            <div class="wrapper">
                <nav>
                    <a href="javascript:;">快速註冊</a>
                </nav>
                <div class="account-box">
                    <div class="form">
                        <el-form ref="formRef" :model="form" :rules="rules" label-position="right" label-width="60px"
                            status-icon>

                            <el-form-item prop="email" label="Email">
                                <el-input v-model="form.email" />
                            </el-form-item>

                            <el-form-item prop="password" label="密碼">
                                <el-input v-model="form.password" />
                            </el-form-item>

                            <el-form-item prop="phone" label="手機">
                                <el-input v-model="form.phone" />
                            </el-form-item>

                            <el-form-item prop="agree" label-width="22px">
                                <el-checkbox size="large" v-model="form.agree1">
                                    本人同意會員資料登入於JP Shop網路商店。
                                </el-checkbox>
                            </el-form-item>

                            <el-form-item prop="agree" label-width="22px">
                                <el-checkbox size="large" v-model="form.agree2">
                                    我同意 <a href="">《隱私權保護政策》</a>及<a href="">《定型化契約條款》</a>
                                </el-checkbox>
                            </el-form-item>

                            <RouterLink to="/login">
                                <el-button size="large" class="subBtn login" @click="doLogin">我要登錄</el-button>
                            </RouterLink>
                            <el-button size="large" class="subBtn regi" @click="doLogin">點擊註冊</el-button>
                        </el-form>
                    </div>
                </div>
            </div>
        </section>

        <footer class="login-footer">
            <div class="container">
                <p>
                    <a href="javascript:;">關於我們</a>
                    <a href="javascript:;">幫助中心</a>
                    <a href="javascript:;">品牌日誌</a>
                    <a href="javascript:;">最新消息</a>
                    <a href="javascript:;">免責聲明</a>
                    <a href="javascript:;">隱私權政策</a>
                </p>
                <p>CopyRight &copy; JP Shop</p>
            </div>
        </footer>
    </div>
</template>

<style scoped lang='scss'>
.login-header {
    background: #fff;
    border-bottom: 1px solid #e4e4e4;

    .container {
        display: flex;
        align-items: flex-end;
        justify-content: space-between;
    }

    .logo {
        width: 200px;

        a {
            display: block;
            height: 132px;
            width: 100%;
            text-indent: -9999px;
            background: url("@/assets/images/logo.png") no-repeat center 18px / contain;
        }
    }

    .sub {
        flex: 1;
        font-size: 24px;
        font-weight: normal;
        margin-bottom: 38px;
        margin-left: 20px;
        color: #666;
    }

    .entry {
        width: 120px;
        margin-bottom: 38px;
        font-size: 16px;

        i {
            font-size: 14px;
            color: $xtxColor;
            letter-spacing: -5px;
        }
    }
}

.login-section {
    background: url('@/assets/images/94147.jpg') no-repeat center / cover;
    height: 488px;
    position: relative;

    .wrapper {
        width: 400px;
        background: #fff;
        position: absolute;
        left: 50%;
        top: 54px;
        transform: translate3d(100px, 0, 0);
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);

        nav {
            font-size: 14px;
            height: 55px;
            margin-bottom: 20px;
            border-bottom: 1px solid #f5f5f5;
            display: flex;
            padding: 0 40px;
            text-align: right;
            align-items: center;

            a {
                flex: 1;
                line-height: 1;
                display: inline-block;
                font-size: 20px;
                position: relative;
                text-align: center;
            }
        }
    }
}

.login-footer {
    padding: 30px 0 50px;
    background: #fff;

    p {
        text-align: center;
        color: #999;
        padding-top: 20px;

        a {
            line-height: 1;
            padding: 0 10px;
            color: #999;
            display: inline-block;

            ~a {
                border-left: 1px solid #ccc;
            }
        }
    }
}

.account-box {
    .toggle {
        padding: 15px 40px;
        text-align: right;

        a {
            color: $xtxColor;

            i {
                font-size: 14px;
            }
        }
    }

    .form {
        padding: 0 20px 20px 20px;

        &-item {
            margin-bottom: 28px;

            .input {
                position: relative;
                height: 36px;

                >i {
                    width: 34px;
                    height: 34px;
                    background: #cfcdcd;
                    color: #fff;
                    position: absolute;
                    left: 1px;
                    top: 1px;
                    text-align: center;
                    line-height: 34px;
                    font-size: 18px;
                }

                input {
                    padding-left: 44px;
                    border: 1px solid #cfcdcd;
                    height: 36px;
                    line-height: 36px;
                    width: 100%;

                    &.error {
                        border-color: $priceColor;
                    }

                    &.active,
                    &:focus {
                        border-color: $xtxColor;
                    }
                }

                .code {
                    position: absolute;
                    right: 1px;
                    top: 1px;
                    text-align: center;
                    line-height: 34px;
                    font-size: 14px;
                    background: #f5f5f5;
                    color: #666;
                    width: 90px;
                    height: 34px;
                    cursor: pointer;
                }
            }

            >.error {
                position: absolute;
                font-size: 12px;
                line-height: 28px;
                color: $priceColor;

                i {
                    font-size: 14px;
                    margin-right: 2px;
                }
            }
        }

        .agree {
            a {
                color: #069;
            }
        }

        .btn {
            display: block;
            width: 100%;
            height: 40px;
            color: #fff;
            text-align: center;
            line-height: 40px;
            background: $xtxColor;

            &.disabled {
                background: #cfcdcd;
            }
        }
    }

    .action {
        padding: 20px 40px;
        display: flex;
        justify-content: space-between;
        align-items: center;

        .url {
            a {
                color: #999;
                margin-left: 10px;
            }
        }
    }
}

.subBtn {
    // background: $xtxColor;
    width: 48%;
    color: #fff;
}

.regi {
    background: rgb(234, 125, 140);
}

.login {
    background: $xtxColor
}
</style>

