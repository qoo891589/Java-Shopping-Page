CREATE TABLE 'products'
(
    `pd_id`      bigint(20) NOT NULL COMMENT '商品id',
    `pd_name`    varchar(50) DEFAULT NULL COMMENT '商品名稱',
    `pd_des`     varchar(100)  NOT NULL COMMENT '商品敘述',
    `pd_price`   integer(10000)  DEFAULT NULL COMMENT '商品賈格',
    `pd_img_url` varchar(500)   DEFAULT NULL COMMENT '圖片連結',
    `pd_type`    varchar(20)   DEFAULT NULL COMMENT '商品種類(男裝 女裝 運動裝)',
    `ps_cate`    varchar(20)   DEFAULT '0' COMMENT '商品類型(外套 上衣 下身 內衣)'
) COMMENT ='商品資訊';

CREATE TABLE `user`
(
    `user_id`       bigint(20)   NOT NULL COMMENT '使用者id',
    `user_name`     varchar(50)  DEFAULT NULL COMMENT '姓名',
    'user_account'  varchar(50)  DEFAULT NULL COMMENT '使用者帳號',
    'user_password' varchar(50)  DEFAULT NULL COMMENT '使用者密碼',
    `user_phone`    integer(100)  NOT NULL COMMENT '手機號碼'
) COMMENT ='用户信息';

CREATE TABLE `oder`
(
    `od_id`      bigint(20)   NOT NULL COMMENT '使用者id',
    `od_status`  varchar(50)  DEFAULT NULL COMMENT '姓名',
    'od_name'    varchar(50)  DEFAULT NULL COMMENT '使用者帳號',
    'od_phone'   varchar(50)  DEFAULT NULL COMMENT '使用者密碼',
    `od_address` varchar(100)  NOT NULL COMMENT '取貨地址',
    `od_time`    time  COMMENT '訂購時間',
    `od_total`   integer(100) COLLATE utf8_bin NOT NULL COMMENT '訂單總額'

) COMMENT ='訂單資訊';
