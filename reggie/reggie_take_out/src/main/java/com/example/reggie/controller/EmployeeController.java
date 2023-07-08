package com.example.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.reggie.entity.Employee;
import com.example.reggie.common.R;
import com.example.reggie.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

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

    /**
     * 員工退出
     *
     * @param request
     * @return
     */
    @PostMapping("/logout")
    public R<String> logout(HttpServletRequest request) {
        //清除session中暫時保存的當前登錄員工id
        request.getSession().removeAttribute("employee");
        return R.success("退出成功");
    }

    /**
     * 新增員工信息
     *
     * @param employee
     * @return
     */
    @PostMapping
    public R<String> save(HttpServletRequest request, @RequestBody Employee employee) {
        log.info("新增員工,員工信息: {}", employee.toString());
        //設置初始密碼為12345，但需要進行md5加密
        employee.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));

//        employee.setCreateTime(LocalDateTime.now());
//        employee.setUpdateTime(LocalDateTime.now());
//
//        //獲取當前登錄人的id
//        Long empId = (Long) request.getSession().getAttribute("employee");
//        employee.setCreateUser(empId);
//        employee.setUpdateUser(empId);

        employeeService.save(employee);
        return R.success("新增員工成功");
    }

    /**
     * 員工信息分頁查詢
     *
     * @param page
     * @param pageSize
     * @param name
     * @return
     */
    @GetMapping("/page")
    public R<Page> page(int page, int pageSize, String name) {
        log.info("page={}, pageSize=P{},name={}", page, pageSize, name);

        //創建分頁構造器
        Page pageInfo = new Page(page,pageSize);
        //創建條件構造器
        LambdaQueryWrapper<Employee> queryWrapper = new LambdaQueryWrapper();
        //添加過濾條件
        queryWrapper.like(StringUtils.isNotEmpty(name),Employee::getName,name);
        //添加排序條件
        queryWrapper.orderByDesc(Employee::getUpdateTime);
        //執行查詢
        employeeService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
    }

    @PutMapping
    public R<String> update(HttpServletRequest request, @RequestBody Employee employee){
        log.info(employee.toString());

        long id = Thread.currentThread().getId();
        log.info("線程id為: {}", id);
        //Long empId = (Long)request.getSession().getAttribute("employee");
        //employee.setUpdateTime(LocalDateTime.now());
        //employee.setUpdateUser(empId);
        employeeService.updateById(employee);

        return R.success("員工信息修改成功");
    }

    /**
     * 根據id查詢員工信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public  R<Employee> getById(@PathVariable Long id){
        Employee employee = employeeService.getById(id);
        if(employee!=null){
            return R.success(employee);
        }
        return R.error("未查詢到員工信息");
    }
}
