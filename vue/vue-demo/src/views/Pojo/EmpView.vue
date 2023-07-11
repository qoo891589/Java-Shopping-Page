<template>
    <div>
        <el-container style="height: 700px; border: 1px solid #eee">
            <el-header style="font-size: 40px; background-color: rgb(238, 241, 246)">Pojo後台管理輔助系統</el-header>
            <el-container>
                <!-- 側邊欄 -->
                <el-aside width="200px" style="border: 1px solid #eee">
                    <el-menu :default-openeds="['1', '3']">
                        <el-submenu index="1">
                            <template slot="title"><i class="el-icon-message"></i>系統信息管理</template>
                            <el-menu-item index="1-1">商品管理</el-menu-item>
                            <el-menu-item index="1-2">分類管理</el-menu-item>
                            <el-menu-item index="1-3">會員管理</el-menu-item>
                            <el-menu-item index="1-4">訂單管理</el-menu-item>
                        </el-submenu>
                    </el-menu>
                </el-aside>
                <!-- 主頁面 -->
                <el-main>
                    <!-- 行內表單 輸入查詢條件-->
                    <el-form :inline="true" :model="searchForm" class="demo-form-inline">
                        <!--  -->
                        <el-form-item label="商品名稱">
                            <el-input v-model="searchForm.productName" placeholder="商品名稱"></el-input>
                        </el-form-item>
                        <!--  -->
                        <el-form-item label="商品類型">
                            <el-select v-model="searchForm.categoryId" placeholder="商品類型">
                                <el-option label="男裝" value="1"></el-option>
                                <el-option label="女裝" value="2"></el-option>
                            </el-select>
                        </el-form-item>
                        <!--  -->
                        <!--  -->
                        <el-form-item>
                            <el-button type="primary" @click="onSubmit">查询</el-button>
                        </el-form-item>
                    </el-form>
                    <!-- 主展示區域: 姓名 圖片 性別 職位 入職日期 更新時間 操作-->
                        <el-table :data="tableData" border>
                            <el-table-column prop="productName" label="商品名稱" width="180">
                        </el-table-column>
                        

                        <el-table-column prop="image" label="商品圖片" width="180">
                            <template slot-scope="scope">
                                <img :src="scope.row.image" width="100px">
                            </template>
                        </el-table-column>

                        <el-table-column prop="categoryId" label="商品類型" width="140">
                            <template slot-scope="scope">
                                {{ scope.row.categoryId == 1 ? '男裝' : '女裝' }}
                            </template>
                        </el-table-column>
                        
                        <el-table-column label="操作">
                            <el-button type="primary" size="mini">編輯</el-button>
                            <el-button type="dander" size="mini">刪除</el-button>
                        </el-table-column>
                    </el-table>
                    <!-- 分頁條 -->
                    <el-pagination background layout="total, sizes, prev, pager, next, jumper"
                        @size-change="handleSizeChange" @current-change="handleCurrentChange" :total="1000">
                    </el-pagination>

                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            tableData: [],
            searchForm: {
                productName: "",
                categoryId: "",
                price: "",
                entrydate: [],
            },
        };
    },
    methods: {
        onSubmit() {
            console.log("submit!");
        },
        handleSizeChange(val) {
            console.log(`每页 ${val} 条`);
        },
        handleCurrentChange(val) {
            console.log(`当前页: ${val}`);
        },
        onSubmit() {
            console.log('submit!');
        }
    },
    mounted() {
        axios.get("http://localhost:8083/emps").then((result) => {
            console.log(result.data.data.rows);
            this.tableData = result.data.data.rows;
        });
    }
};
</script>

<style></style>
