package com.example.hateos.model.dto;

public class StudentDTO {

    private long id;
    private String name;
    private int age;

    public StudentDTO() {
    }

    public long getId() {
        return id;
    }

    public StudentDTO setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StudentDTO setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public StudentDTO setAge(int age) {
        this.age = age;
        return this;
    }
}
