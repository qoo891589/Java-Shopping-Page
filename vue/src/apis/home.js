import axios from 'axios';
import httpInstance from '@/utils/http'
import httpCN from '@/utils/http'

//獲取Banner資料
export function getBannerAPI(params = {}) {
  const { distributionSite = '1' } = params
  return httpInstance({
    url: '/home/banner',
    params: {
      distributionSite
    }
  })
}

export const findNewAPI = () => {
  return httpInstance({
    url:'/home/new'
  })
}

export const findHotAPI = () => {
  return httpInstance({
    url:'/home/hot'
  })
}

export const getGoodsAPI = () => {
  return httpInstance({
    url: '/home/goods'
  })
}