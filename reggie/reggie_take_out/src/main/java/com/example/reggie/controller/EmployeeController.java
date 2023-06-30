package com.example.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.reggie.Entity.Employee;
import com.example.reggie.common.R;
import com.example.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 員工登錄方法
     *
     * @param request
     * @param employee
     * @return
     */
    @PostMapping("/login")
    public R<Employee> login(HttpServletRequest request, @RequestBody Employee employee) {
        // 密碼md5加密
        /*
        1.從員工類提取密碼
        2.調用方法DigestUtils進行md加密
         */
        String password = employee.getPassword();
        password = DigestUtils.md5DigestAsHex(password.getBytes());

        // 根據username查詢數據庫
        /*
        1. 創建查詢對象：創建一個Lambda-Query-Wrapper
        2. 創建查詢條件：使用等值查詢eq.(查詢的條件,依據查詢的屬性)
        3. 判斷emp如果為空，代表用戶不存在，不用去比對密碼，return R.error(登錄失敗)
        4. 判斷emp存在但與數據資料不一致，return R.error(登錄失敗)
         */
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Employee::getUsername, employee.getUsername());
        Employee emp = employeeService.getOne(queryWrapper);

        // 判斷emp是否為空，如果是null代表資料不存在
        if (emp == null) {
            return R.error("登錄失敗");
        }

        // 依據emp抓到的密碼比對加密後的password查詢數據庫是否吻合
        if (!emp.getPassword().equals(password)) {
            return R.error("登錄失敗");
        }

        // 依據status  查詢數據庫是否吻合(可能存在員工已禁用)
        if (emp.getStatus() == 0) {
            return R.error("帳號已禁用");
        }

        // 都通過才將員工id加入Session，並返回成功R
        request.getSession().setAttribute("employee", emp.getId());
        return R.success(emp);
    }
}
