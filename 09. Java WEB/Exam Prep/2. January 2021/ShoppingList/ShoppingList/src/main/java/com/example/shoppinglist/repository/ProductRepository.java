package com.example.shoppinglist.repository;

import com.example.shoppinglist.model.entity.ProductEntity;
import com.example.shoppinglist.model.entity.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query("select SUM (p.price) FROM ProductEntity p ")
    BigDecimal findTotalProductSum();

    List<ProductEntity> findAllByCategory_Name(CategoryEnum categoryName);

}
