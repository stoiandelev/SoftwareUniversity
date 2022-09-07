package com.example.andrey.repository;

import com.example.andrey.model.entity.CategoryEntity;
import com.example.andrey.model.entity.ItemEntity;
import com.example.andrey.model.entity.enums.CategoryNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Long> {


}
