(function (win) {
  axios.defaults.headers['Content-Type'] = 'application/json;charset=utf-8'
  // 創建axios實例
  const service = axios.create({
    // axios中請求配置有baseURL選項，表示請求URL公共部分
    baseURL: '/',
    // 超時
    timeout: 10000
  })
  // request攔截器
  service.interceptors.request.use(config => {
    // 是否需要設置 token
    // const isToken = (config.headers || {}).isToken === false
    // if (getToken() && !isToken) {
    //   config.headers['Authorization'] = 'Bearer ' + getToken() // 讓每個請求攜帶自訂token 請根據實際情況自行修改
    // }
    // get請求映射params參數
    if (config.method === 'get' && config.params) {
      let url = config.url + '?';
      for (const propName of Object.keys(config.params)) {
        const value = config.params[propName];
        var part = encodeURIComponent(propName) + "=";
        if (value !== null && typeof(value) !== "undefined") {
          if (typeof value === 'object') {
            for (const key of Object.keys(value)) {
              let params = propName + '[' + key + ']';
              var subPart = encodeURIComponent(params) + "=";
              url += subPart + encodeURIComponent(value[key]) + "&";
            }
          } else {
            url += part + encodeURIComponent(value) + "&";
          }
        }
      }
      url = url.slice(0, -1);
      config.params = {};
      config.url = url;
    }
    return config
  }, error => {
    Promise.reject(error)
  })

  // 回應攔截器
  service.interceptors.response.use(res => {
        console.log('---回應攔截器---',res)
        if (res.data.code === 0 && res.data.msg === 'NOTLOGIN') {// 返回登錄頁面
          window.top.location.href = '/front/page/login.html'
        } else {
          return res.data
        }
      },
      error => {
        let { message } = error;
        if (message == "Network Error") {
          message = "後端介面連接異常";
        }
        else if (message.includes("timeout")) {
          message = "系統介面請求超時";
        }
        else if (message.includes("Request failed with status code")) {
          message = "系統介面" + message.substr(message.length - 3) + "異常";
        }
        window.vant.Notify({
          message: message,
          type: 'warning',
          duration: 5 * 1000
        })
        //window.top.location.href = '/front/page/no-wify.html'
        return Promise.reject(error)
      }
  )
  win.$axios = service
})(window);

