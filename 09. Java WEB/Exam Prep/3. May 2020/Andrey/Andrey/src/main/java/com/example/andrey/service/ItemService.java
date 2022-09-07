package com.example.andrey.service;

import com.example.andrey.model.service.ItemServiceModel;
import com.example.andrey.model.view.ItemViewModel;

import java.util.List;

public interface ItemService {


    void addItem(ItemServiceModel itemServiceModel);

    //for view all items
    List<ItemViewModel> findAllItems();

    //for details items
    ItemViewModel findById(Long id);

    void delete(Long id);
}
