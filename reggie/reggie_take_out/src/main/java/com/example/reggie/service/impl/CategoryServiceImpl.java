package com.example.reggie.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.reggie.Entity.Category;
import com.example.reggie.Entity.Dish;
import com.example.reggie.Entity.Setmeal;
import com.example.reggie.common.CustomException;
import com.example.reggie.mapper.CategoryMapper;
import com.example.reggie.service.CategoryService;
import com.example.reggie.service.DishService;
import com.example.reggie.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
    @Autowired
    private DishService dishService;
    @Autowired
    private SetmealService setmealService;

    /**
     *
     * @param id
     */
    @Override
    public void remove(Long id){
        LambdaQueryWrapper<Dish> dishLambdaQueryWrapper = new LambdaQueryWrapper<>();
        dishLambdaQueryWrapper.eq(Dish::getCategoryId,id);
        int count1 = dishService.count(dishLambdaQueryWrapper);

        if(count1>0){
            //已有菜品加入此分類，因此無法直接刪除分類(當前分類下關聯了菜品，不能刪除)
            throw new CustomException("已有菜品加入此分類，因此無法直接刪除此分類");
        }

        LambdaQueryWrapper<Setmeal> setmealLambdaQueryWrapper = new LambdaQueryWrapper<>();
        setmealLambdaQueryWrapper.eq(Setmeal::getCategoryId,id);
        int count2 = setmealService.count(setmealLambdaQueryWrapper);
        if(count2 > 0){
            //已有套餐加入此分類，因此無法直接刪除分類(當前分類下關聯了套餐，不能刪除)
            throw new CustomException("已有套餐加入此分類，因此無法直接刪除此分類");
        }

        super.removeById(id);

    }
}
