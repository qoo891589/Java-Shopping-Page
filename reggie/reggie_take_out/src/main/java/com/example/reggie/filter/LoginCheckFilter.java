package com.example.reggie.filter;

import com.alibaba.fastjson.JSON;
import com.example.reggie.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 檢查是否完成登錄
 */
@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {
    // 設定路徑匹配器用以過濾符合標準的URL
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        // 1 獲取本次請求的URL
        String requestURL = request.getRequestURI();

        log.info(requestURL);

        // 將不需要處理的請求直接放行, 例如本來就是點擊登錄的用戶,退出系統的用戶,靜態的資源
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**"
        };

        // 2 判斷是否需要處理
        boolean check = check(urls, requestURL);

        // 3 True : 放行
        if (check) {
            log.info("本次請求{}不需要處理", requestURL);
            filterChain.doFilter(request, response);
            return;
        }

        // 4 判斷是否登錄狀態 True : 放行
        if (request.getSession().getAttribute("employee") != null) {
            log.info("用戶已經登錄，用戶id為{}", request.getSession().getAttribute("employee"));
            filterChain.doFilter(request, response);
            return;
        }

        log.info("用戶未登錄");
        // 5 N : 返回未登錄結果
        response.getWriter().write(JSON.toJSONString(R.error("NOTLOGIN")));
        return;
    }

    /**
     * 第二步的方法
     * 檢查本次匹配是否需要放行
     *
     * @param requestUrl
     * @return
     */
    public boolean check(String[] urls, String requestUrl) {
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestUrl);
            if (match) {
                return true;
            }
        }
        return false;
    }


}
