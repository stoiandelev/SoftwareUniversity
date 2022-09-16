package com.example.battle_ship.model.entity;

import com.example.battle_ship.model.enums.CategoryEnum;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{


    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private CategoryEnum name;

    @Column(columnDefinition = "TEXT")
    private String description;

    public CategoryEntity() {
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
