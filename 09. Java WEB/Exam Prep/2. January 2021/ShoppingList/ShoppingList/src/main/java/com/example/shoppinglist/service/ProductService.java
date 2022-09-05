package com.example.shoppinglist.service;

import com.example.shoppinglist.model.entity.enums.CategoryEnum;
import com.example.shoppinglist.model.service.ProductServiceModel;
import com.example.shoppinglist.model.view.ProductViewModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ProductService {

    void add(ProductServiceModel productServiceModel);

    BigDecimal getTotalSum();

    List<ProductViewModel> findAllProductsByCategory(CategoryEnum categoryEnum);

    void buyById(Long id);

    void buyAll();
}
