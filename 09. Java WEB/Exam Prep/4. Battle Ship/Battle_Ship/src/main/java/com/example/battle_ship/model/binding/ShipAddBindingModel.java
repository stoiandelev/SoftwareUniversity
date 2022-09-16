package com.example.battle_ship.model.binding;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class ShipAddBindingModel {

    @NotBlank
    @Size(min = 2, max = 10, message = "Name must between 2 and 10 character!")
    private String name;

    @NotNull
    @Positive(message = "The power must be positive!")
    private Long power;

    @NotNull
    @Positive(message = "The health must be positive!")
    private Long health;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @PastOrPresent(message = "Created date cannot be in future!")
    private LocalDate created;

    @NotBlank(message = "Must select a category!")
    private String category;

    public ShipAddBindingModel() {
    }

    public String getName() {
        return name;
    }

    public ShipAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getPower() {
        return power;
    }

    public ShipAddBindingModel setPower(Long power) {
        this.power = power;
        return this;
    }

    public Long getHealth() {
        return health;
    }

    public ShipAddBindingModel setHealth(Long health) {
        this.health = health;
        return this;
    }

    public LocalDate getCreated() {
        return created;
    }

    public ShipAddBindingModel setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public String getCategory() {
        return category;
    }

    public ShipAddBindingModel setCategory(String category) {
        this.category = category;
        return this;
    }
}
