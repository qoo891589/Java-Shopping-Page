<template>
    <footer class="app_footer">
        <!-- 聯繫我們 -->
        <div class="contact">
            <div class="container">
                <dl>
                    <dt>客戶服務</dt>
                    <dd><i class="iconfont fa-solid fa-headset"></i> 線上客服</dd>
                    <dd><i class="iconfont fa-solid fa-question "></i> 問題回饋</dd>
                </dl>
                <dl>
                    <dt>關注我們</dt>
                    <dd><i class="iconfont fa-brands fa-square-facebook"></i>粉絲專頁</dd>
                    <dd><i class="iconfont fa-brands fa-instagram"></i>Instagram</dd>
                </dl>
                <dl>
                    <dt>下載APP</dt>
                    <dd class="qrcode"><img src="@/assets/images/qrcode.jpg" /></dd>
                    <dd class="download">
                        <span>掃描QRcode</span>
                        <span>前往下載頁面</span>
                        <a href="javascript:;">下載頁面</a>
                    </dd>
                </dl>
                <dl>
                    <dt>聯繫電話</dt>
                    <dd class="hotline">09-8765-4321 <small>週一至週五 9:00-17:00</small></dd>
                </dl>
            </div>
        </div>
        <!-- 其它 -->
        <div class="extra">
            <div class="container">
                <!-- <div class="slogan">
                    <a href="javascript:;">
                        <i class="iconfont icon-footer01"></i>
                        <span>價格親民</span>
                    </a>
                    <a href="javascript:;">
                        <i class="iconfont icon-footer02"></i>
                        <span>物流快捷</span>
                    </a>
                    <a href="javascript:;">
                        <i class="iconfont icon-footer03"></i>
                        <span>品質新鮮</span>
                    </a>
                </div> -->
                <!-- 版權資訊 -->
                <div class="copyright">
                    <p>
                        <a href="javascript:;">關於我們</a>
                        <a href="javascript:;">幫助中心</a>
                        <a href="javascript:;">品牌日誌</a>
                        <a href="javascript:;">最新消息</a>
                        <a href="javascript:;">免責聲明</a>
                        <a href="javascript:;">隱私權政策</a>
                    </p>
                    <p>CopyRight © JP Shop</p>
                </div>
            </div>
        </div>
    </footer>
</template>

<style scoped lang='scss'>
.app_footer {
    overflow: hidden;
    // background-color: #f5f5f5;
    padding-top: 20px;

    .contact {
        background: #fff;

        .container {
            padding: 60px 0 40px 25px;
            display: flex;
        }

        dl {
            height: 190px;
            text-align: center;
            padding: 0 72px;
            border-right: 1px solid #f2f2f2;
            color: #999;

            &:first-child {
                padding-left: 0;
            }

            &:last-child {
                border-right: none;
                padding-right: 0;
            }
        }

        dt {
            line-height: 1;
            font-size: 18px;
        }

        dd {
            margin: 36px 12px 0 0;
            float: left;
            width: 92px;
            height: 92px;
            padding-top: 10px;
            border: 1px solid #ededed;

            .iconfont {
                font-size: 36px;
                display: block;
                color: #666;
                padding: 8px 0 8px 0;
            }

            &:hover {
                .iconfont {
                    color: $xtxColor;
                }
            }

            &:last-child {
                margin-right: 0;
            }
        }

        .qrcode {
            width: 92px;
            height: 92px;
            padding: 7px;
            border: 1px solid #ededed;
        }

        .download {
            padding-top: 5px;
            font-size: 14px;
            width: auto;
            height: auto;
            border: none;

            span {
                display: block;
            }

            a {
                display: block;
                line-height: 1;
                padding: 10px 25px;
                margin-top: 5px;
                color: #fff;
                border-radius: 2px;
                background-color: $xtxColor;
            }
        }

        .hotline {
            padding-top: 20px;
            font-size: 22px;
            color: #666;
            width: auto;
            height: auto;
            border: none;

            small {
                display: block;
                font-size: 15px;
                color: #999;
            }
        }
    }

    .extra {
        background-color: #222;
    }

    .slogan {
        height: 178px;
        line-height: 58px;
        padding: 60px 100px;
        border-bottom: 1px solid #434343;
        display: flex;
        justify-content: space-between;

        a {
            height: 58px;
            line-height: 58px;
            color: #fff;
            font-size: 28px;

            i {
                font-size: 50px;
                vertical-align: middle;
                margin-right: 10px;
                font-weight: 100;
            }

            span {
                vertical-align: middle;
                text-shadow: 0 0 1px #333;
            }
        }
    }

    .copyright {
        height: 170px;
        padding-top: 40px;
        text-align: center;
        color: #999;
        font-size: 15px;
        background-color: #222;

        p {
            line-height: 1;
            margin-bottom: 20px;
        }

        a {
            color: #999;
            line-height: 1;
            padding: 0 10px;
            border-right: 1px solid #999;

            &:last-child {
                border-right: none;
            }
        }
    }
}
</style>
