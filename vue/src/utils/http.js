import axios from "axios";

const httpInstance =  axios.create({
    baseURL: 'https://yapi.pro/mock/35918/',
    timeout: 5000
})

const httpInstanceCN =  axios.create({
    baseURL: 'http://pcapi-xiaotuxian-front-devtest.itheima.net',
    timeout: 5000
})

// axios請求攔截器
httpInstance.interceptors.request.use(config => {
  return config
}, e => Promise.reject(e))

// axios回應式攔截器
httpInstance.interceptors.response.use(res => res.data, e => {
  // 錯誤回應
  // ElMessage({
  //   type: 'warning',
  //   message: e.response.data.message
  // })
  return Promise.reject(e)
})

export default httpInstance;
export const httpCN = httpInstanceCN;

