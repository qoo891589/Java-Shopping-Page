// 管理使用者資料相關

import { defineStore } from 'pinia'
import { ref } from 'vue'
import { loginAPI } from '@/apis/user'
import { useCartStore } from './cartStore'
import { mergeCartAPI } from '@/apis/cart'

export const useUserStore = defineStore('user', () => {
  const cartStore = useCartStore()
  // 1. 定義管理使用者資料的state
  const userInfo = ref({})
  // 2. 定義獲取介面資料的action函數
  const getUserInfo = async ({ account, password }) => {
    const res = await loginAPI({ account, password })
    userInfo.value = res.result
    // 合併購物車的操作
    await mergeCartAPI(cartStore.cartList.map(item => {
      return {
        skuId: item.skuId,
        selected: item.selected,
        count: item.count
      }
    }))
    cartStore.updateNewList()
  }

  // 退出時清除使用者資訊
  const clearUserInfo = () => {
    userInfo.value = {}
    // 執行清除購物車的action
    cartStore.clearCart()
  }
  // 3. 以對象的格式把state和action return
  return {
    userInfo,
    getUserInfo,
    clearUserInfo
  }
}, {
  persist: true,
})

