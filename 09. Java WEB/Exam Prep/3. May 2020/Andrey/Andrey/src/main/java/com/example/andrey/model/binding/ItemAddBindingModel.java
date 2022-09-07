package com.example.andrey.model.binding;

import com.example.andrey.model.entity.CategoryEntity;
import com.example.andrey.model.entity.enums.CategoryNameEnum;
import com.example.andrey.model.entity.enums.GenderEnum;


import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

public class ItemAddBindingModel {

    @Size(min = 2, message = "Name must be min 2 character!")
    @NotBlank(message = "Name can not be empty String")
    private String name;

    @Size(min = 2, message = "Description must be min 3 character!")
    @NotBlank(message = "Description can not be empty String")
    private String description;

    @DecimalMin(value = "0", message = "Price must be positive number!")
    private BigDecimal price;

    @NotNull(message = "Enter valid gender!")
    private GenderEnum gender;

    @NotNull(message = "Enter valid category!")
    private CategoryNameEnum category;

    public ItemAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ItemAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ItemAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ItemAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public GenderEnum getGender() {
        return gender;
    }

    public ItemAddBindingModel setGender(GenderEnum gender) {
        this.gender = gender;
        return this;
    }

    public CategoryNameEnum getCategory() {
        return category;
    }

    public ItemAddBindingModel setCategory(CategoryNameEnum category) {
        this.category = category;
        return this;
    }
}
