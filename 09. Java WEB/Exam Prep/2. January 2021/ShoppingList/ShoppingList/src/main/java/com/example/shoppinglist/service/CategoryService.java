package com.example.shoppinglist.service;

import com.example.shoppinglist.model.entity.CategoryEntity;
import com.example.shoppinglist.model.entity.enums.CategoryEnum;

public interface CategoryService {

    void initCategories();

    CategoryEntity findByName(CategoryEnum categoryEnum);
}
