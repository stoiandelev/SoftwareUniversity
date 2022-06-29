package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBooksTitlesWithAgeRestriction(AgeRestriction ageRestriction);

    List<String> findTitleWithLessThan5000Copies(int copies);

    List<String> findAllBooksTitlesWithPriceLessThan5OrMoreThan40();

    List<String> findAllBookNotInThisYear(int year);

    List<String> findBookBeforeReleaseDate(LocalDate localDate);

    List<String> findAllBookContainsString(String containsString);

    List<String> lastNameAuthorsStartsWith(String lastNameStartsWith);

    int findCountOfBooksWithLengthMoreThanTitle(int titleLength);

}
