package com.example.shoppinglist.service.impl;

import com.example.shoppinglist.model.entity.ProductEntity;
import com.example.shoppinglist.model.entity.enums.CategoryEnum;
import com.example.shoppinglist.model.service.ProductServiceModel;
import com.example.shoppinglist.model.view.ProductViewModel;
import com.example.shoppinglist.repository.ProductRepository;
import com.example.shoppinglist.service.CategoryService;
import com.example.shoppinglist.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

    public ProductServiceImpl(ProductRepository productRepository,
                              ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void add(ProductServiceModel productServiceModel) {
        ProductEntity product = modelMapper.map(productServiceModel, ProductEntity.class);

        product.setCategory(categoryService
                .findByName(productServiceModel.getCategory()));


        productRepository.save(product);
    }

    @Override
    public BigDecimal getTotalSum() {
        return productRepository.
                findTotalProductSum();
    }

    @Override
    public List<ProductViewModel> findAllProductsByCategory(CategoryEnum categoryEnum) {
        return productRepository
                .findAllByCategory_Name(categoryEnum)
                .stream()
                .map(productEntity -> modelMapper.map(productEntity, ProductViewModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public void buyById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void buyAll() {
        productRepository.deleteAll();
    }
}
