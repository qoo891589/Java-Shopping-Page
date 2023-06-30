package com.example.reggie.common;

import lombok.Data;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用的返回結果類
 * 服務端響應的所有樹去都會封裝成此對象
 * @param <T>
 */


@Data
public class R<T> {

    /**
     * 這些數據會送入前端，由backed.page.login.login.html裡面的vue裡面的methods中進行處理
     * 封裝的數據會傳送成res.code, res.data,res.msg 輔助 methods 判斷登錄是否成功
     * code: 1 = 成功 / 0 = 失敗
     * msg: 錯誤信息
     * data: 從方法可知，data是員工實體，目的是經JSON轉換後，暫時儲存在瀏覽器本地localStorage
     */

    private Integer code; //编码：1成功，0和其它数字为失败

    private String msg; //错误信息

    private T data; //数据

    private Map map = new HashMap(); //动态数据

    public static <T> R<T> success(T object) {
        R<T> r = new R<T>();
        r.data = object;
        r.code = 1;
        return r;
    }

    public static <T> R<T> error(String msg) {
        R r = new R();
        r.msg = msg;
        r.code = 0;
        return r;
    }

    public R<T> add(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

}
