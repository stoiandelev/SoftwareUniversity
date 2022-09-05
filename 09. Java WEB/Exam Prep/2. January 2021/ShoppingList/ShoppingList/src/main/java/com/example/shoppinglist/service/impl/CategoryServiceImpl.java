package com.example.shoppinglist.service.impl;

import com.example.shoppinglist.model.entity.CategoryEntity;
import com.example.shoppinglist.model.entity.enums.CategoryEnum;
import com.example.shoppinglist.repository.CategoryRepository;
import com.example.shoppinglist.service.CategoryService;
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
            Arrays.stream(CategoryEnum.values())
                    .forEach(categoryEnum -> {
                        CategoryEntity category = new CategoryEntity(categoryEnum,
                                "Description for " + categoryEnum.name());

                        categoryRepository.save(category);
                    });

        }


    }

    @Override
    public CategoryEntity findByName(CategoryEnum categoryEnum) {
        return categoryRepository
                .findByName(categoryEnum)
                .orElse(null);

    }
}
