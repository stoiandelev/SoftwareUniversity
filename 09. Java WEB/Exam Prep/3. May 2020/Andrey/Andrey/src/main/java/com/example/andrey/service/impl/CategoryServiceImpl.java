package com.example.andrey.service.impl;

import com.example.andrey.model.entity.CategoryEntity;
import com.example.andrey.model.entity.enums.CategoryNameEnum;
import com.example.andrey.model.service.CategoryServiceModel;
import com.example.andrey.repository.CategoryRepository;
import com.example.andrey.repository.ItemRepository;
import com.example.andrey.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository,
                               ItemRepository itemRepository, ModelMapper modelMapper) {
        this.categoryRepository = categoryRepository;
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public void initCategories() {
        if (categoryRepository.count() == 0) {
            Arrays.stream(CategoryNameEnum.values())
                    .forEach(categoryNameEnum -> {
                        categoryRepository.save(new CategoryEntity(categoryNameEnum,
                                String.format("Description for %s",
                                        categoryNameEnum.name())));
                    });
        }
    }

    @Override
    public CategoryEntity findByCategoryName(CategoryNameEnum categoryNameEnum) {
        return categoryRepository
                .findByName(categoryNameEnum)
                .orElse(null);
    }


}
