package com.example.andrey.service;

import com.example.andrey.model.entity.CategoryEntity;
import com.example.andrey.model.entity.enums.CategoryNameEnum;
import com.example.andrey.model.service.CategoryServiceModel;

public interface CategoryService {

    void initCategories();

    CategoryEntity findByCategoryName(CategoryNameEnum categoryNameEnum);

}
