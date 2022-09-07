package com.example.andrey.service.impl;


import com.example.andrey.model.entity.ItemEntity;
import com.example.andrey.model.service.ItemServiceModel;
import com.example.andrey.model.view.ItemViewModel;
import com.example.andrey.repository.ItemRepository;
import com.example.andrey.service.CategoryService;
import com.example.andrey.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ItemServiceImpl(ItemRepository itemRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.itemRepository = itemRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }


    @Override
    public void addItem(ItemServiceModel itemServiceModel) {

        ItemEntity item = modelMapper.map(itemServiceModel, ItemEntity.class);

        item.setCategory(categoryService.findByCategoryName(itemServiceModel.getCategory().getName()));

        itemRepository.save(item);
    }

    @Override
    public List<ItemViewModel> findAllItems() {
        return itemRepository
                .findAll()
                .stream()
                .map(itemEntity -> {
                    ItemViewModel itemViewModel = modelMapper.map(itemEntity, ItemViewModel.class);

                    itemViewModel.setImageUrl(String
                            .format("/img/%s-%s.jpg",
                                    itemEntity.getGender(), itemEntity.getCategory().getName().name()));

                    return itemViewModel;
                })
                .collect(Collectors.toList());
    }

    @Override
    public ItemViewModel findById(Long id) {
        return itemRepository
                .findById(id)
                .map(itemEntity -> {
                    ItemViewModel itemViewModel = modelMapper.map(itemEntity, ItemViewModel.class);

                    itemViewModel.setImageUrl(String
                            .format("/img/%s-%s.jpg",
                                    itemEntity.getGender(), itemEntity.getCategory().getName().name()));

                    return itemViewModel;
                })
                .orElse(null);

    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
