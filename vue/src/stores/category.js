import { ref, onMounted, computed } from 'vue'
import { defineStore } from 'pinia'
import { getCategoryAPI } from '@/apis/layout';

export const useCategorytore = defineStore('category', () => {
  // 導航清單的資料管理
  // state 導航清單數據
    const categoryList = ref([])

  // action 獲取導航資料的方法
    const getCategory = async () => {
    const res = await getCategoryAPI()
    categoryList.value = res.result
    }
    return {
        categoryList,
        getCategory
    }
})


