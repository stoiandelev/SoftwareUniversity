package com.example.battle_ship.service;

import com.example.battle_ship.model.entity.CategoryEntity;

public interface CategoryService {

    void initCategories();

    CategoryEntity findCategory(String category);
}
