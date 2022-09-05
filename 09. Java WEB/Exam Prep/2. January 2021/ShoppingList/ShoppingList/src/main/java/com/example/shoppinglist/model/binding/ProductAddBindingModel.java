package com.example.shoppinglist.model.binding;


import com.example.shoppinglist.model.entity.enums.CategoryEnum;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductAddBindingModel {

    @NotBlank(message = "Product name cannot be empty string")
    @Size(min = 3, max = 20, message = "Product name must be between 3 and 20 character!")
    private String name;

    @NotBlank(message = "Description cannot be empty string")
    @Size(min = 5, message = "Description must be minimum 5 character!")
    private String description;

    @DecimalMin(value = "0", message = "Price must be positive number!")
    @NotNull(message = "Price cannot be empty!")
    private BigDecimal price;

    @FutureOrPresent(message = "Time can not be in the past!")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime neededBefore;

    @NotNull(message = "You must select a category!")
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    public ProductAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ProductAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductAddBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ProductAddBindingModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getNeededBefore() {
        return neededBefore;
    }

    public ProductAddBindingModel setNeededBefore(LocalDateTime neededBefore) {
        this.neededBefore = neededBefore;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ProductAddBindingModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }
}
