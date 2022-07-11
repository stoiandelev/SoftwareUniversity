package com.example.xmlexercise.repository;

import com.example.xmlexercise.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPriceBetweenAndBuyerIsNull(BigDecimal lower, BigDecimal upper);
}
