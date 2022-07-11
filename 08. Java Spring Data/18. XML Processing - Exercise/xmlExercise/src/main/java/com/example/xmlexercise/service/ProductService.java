package com.example.xmlexercise.service;

import com.example.xmlexercise.model.dto.taskOneDto.ProductInRangeRootDto;
import com.example.xmlexercise.model.dto.productsSeeds.ProductSeedDto;

import java.util.List;

public interface ProductService {
    long getEntityCount();

    void seedProducts(List<ProductSeedDto> products);

    ProductInRangeRootDto findProductInRangeWithNoBuyer();
}
