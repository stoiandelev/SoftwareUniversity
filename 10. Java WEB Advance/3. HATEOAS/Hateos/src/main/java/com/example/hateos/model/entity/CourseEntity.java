package com.example.hateos.model.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "courses")
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private BigDecimal price;
    private Boolean enabled;

    public CourseEntity() {
    }

    public long getId() {
        return id;
    }

    public CourseEntity setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CourseEntity setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public CourseEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public CourseEntity setEnabled(Boolean enabled) {
        this.enabled = enabled;
        return this;
    }
}
