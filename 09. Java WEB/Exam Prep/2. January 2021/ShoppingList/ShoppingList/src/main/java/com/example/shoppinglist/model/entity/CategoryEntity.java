package com.example.shoppinglist.model.entity;

import com.example.shoppinglist.model.entity.enums.CategoryEnum;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CategoryEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;


    public CategoryEntity() {
    }

    public CategoryEntity(CategoryEnum categoryEnum, String description) {
        this.name = categoryEnum;
        this.description = description;
    }

    public CategoryEnum getName() {
        return name;
    }

    public CategoryEntity setName(CategoryEnum name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CategoryEntity setDescription(String description) {
        this.description = description;
        return this;
    }
}
