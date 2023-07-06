package com.example.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.reggie.Entity.Category;
import com.example.reggie.common.R;
import com.example.reggie.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
@Slf4j
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public R<String> save(@RequestBody Category category){
        log.info("category:{}",category);
        categoryService.save(category);
        return R.success("新增分類成功");
    }

    @GetMapping("/page")
    public R<Page> page(int page,int pageSize) {
        Page<Category> pageInfo = new Page<>(page,pageSize);
        LambdaQueryWrapper<Category> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByAsc(Category::getSort);

        categoryService.page(pageInfo,queryWrapper);

        return R.success(pageInfo);
    }

    @DeleteMapping
    public R<String> delete(Long id) {
        log.info("刪除分類，id為: {}",id);
        categoryService.remove(id);

        return R.success("分類信息刪除成功");
    }

    @PutMapping
    public R<String> update(@RequestBody Category category){
        log.info("修改分類信息: {}",category);

        categoryService.updateById(category);
        return R.success("修改分類信息成功");
    }


}
