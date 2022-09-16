package com.example.battle_ship.service.impl;

import com.example.battle_ship.model.entity.CategoryEntity;
import com.example.battle_ship.model.enums.CategoryEnum;
import com.example.battle_ship.repository.CategoryRepository;
import com.example.battle_ship.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays
                    .stream(CategoryEnum.values())
                    .forEach(categoryEnum -> {

                        CategoryEntity category = new CategoryEntity();

                        category.setName(categoryEnum);
                        switch (categoryEnum) {
                            case CARGO -> category.setDescription("Cargo description");
                            case BATTLE -> category.setDescription("Battle description");
                            case PATROL -> category.setDescription("Patrol description");
                        }
                        categoryRepository.save(category);

                    });
        }
    }

    @Override
    public CategoryEntity findCategory(String category) {
        return categoryRepository
                .findByName(CategoryEnum.valueOf(category))
                .orElse(null);
    }
}
