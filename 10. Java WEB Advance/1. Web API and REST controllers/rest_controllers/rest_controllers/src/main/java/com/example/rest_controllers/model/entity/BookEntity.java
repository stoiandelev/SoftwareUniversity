package com.example.rest_controllers.model.entity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class BookEntity extends BaseEntity {

    private String title;
    private String isbn;

    @ManyToOne
    private AuthorEntity authors;

    public BookEntity() {
    }

    public String getTitle() {
        return title;
    }

    public BookEntity setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getIsbn() {
        return isbn;
    }

    public BookEntity setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public AuthorEntity getAuthors() {
        return authors;
    }

    public BookEntity setAuthors(AuthorEntity authors) {
        this.authors = authors;
        return this;
    }
}
