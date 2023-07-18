// 封裝購物車相關介面
import request from '@/utils/http'

// 加入購物車
export const insertCartAPI = ({ skuId, count }) => {
  return request({
    url: '/member/cart',
    method: 'POST',
    data: {
      skuId,
      count
    }
  })
}

// 獲取最新的購物車列表
export const findNewCartListAPI = () => {
  return request({
    url: '/member/cart'
  })
}

// 刪除購物車
export const delCartAPI = (ids) => {
  return request({
    url: '/member/cart',
    method: 'DELETE',
    data: {
      ids
    }
  })
}

// 合併購物車

export const mergeCartAPI = (data) => {
  return request({
    url: '/member/cart/merge',
    method: 'POST',
    data
  })
}

