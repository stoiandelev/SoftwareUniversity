package com.example.hateos.model.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int age;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER)
    private List<OrderEntity> orders = new ArrayList<>();

    public StudentEntity() {
    }

    public long getId() {
        return id;
    }

    public StudentEntity setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentEntity setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public StudentEntity setAge(int age) {
        this.age = age;
        return this;
    }

    public List<OrderEntity> getOrders() {
        return orders;
    }

    public StudentEntity setOrders(List<OrderEntity> orders) {
        this.orders = orders;
        return this;
    }
}
