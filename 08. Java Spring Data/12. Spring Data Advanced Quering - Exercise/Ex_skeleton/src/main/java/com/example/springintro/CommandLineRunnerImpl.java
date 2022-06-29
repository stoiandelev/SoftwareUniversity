package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(CategoryService categoryService,
                                 AuthorService authorService,
                                 BookService bookService,
                                 BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
//        seedData();
//        printAllBooksAfterYear(2000);
//        printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(1990);
//        printAllAuthorsAndNumberOfTheirBooks();
//        printALlBooksByAuthorNameOrderByReleaseDate("George", "Powell");
        System.out.println("Enter ex:");
        int exNumber = Integer.parseInt(bufferedReader.readLine());
        switch (exNumber) {
            case 1 -> booksTitlesByAgeRestriction();
            case 2 -> goldenBooks();
            case 3 -> booksByPrice();
            case 4 -> notReleasedBooks();
            case 5 -> booksReleasedBeforeDate();
            case 6 -> firstNameEndWith();
            case 7 -> booksSearch();
            case 8 -> bookTitlesSearch();
            case 9 -> countBooks();
            case 10 -> totalBookCopies();
        }


    }

    private void totalBookCopies() {
        authorService
                .findAllAuthorsAndTheirTotalCopies()
                .forEach(System.out::println);

    }

    private void countBooks() throws IOException {
        System.out.println("Enter title length: ");
        int titleLength = Integer.parseInt(bufferedReader.readLine());


        System.out.println(bookService
                .findCountOfBooksWithLengthMoreThanTitle(titleLength));

    }

    private void bookTitlesSearch() throws IOException {
        System.out.println("Enter string: ");
        String lastNameStartsWith = bufferedReader.readLine();
        bookService
                .lastNameAuthorsStartsWith(lastNameStartsWith)
                .forEach(System.out::println);
    }

    private void booksSearch() throws IOException {
        System.out.println("Enter string: ");
        String containsString = bufferedReader.readLine();
        bookService
                .findAllBookContainsString(containsString)
                .forEach(System.out::println);
    }

    private void firstNameEndWith() throws IOException {
        System.out.println("Enter ends with: ");
        String endWith = bufferedReader.readLine();
        authorService
                .firstNameEndWith(endWith)
                .forEach(System.out::println);
    }

    private void booksReleasedBeforeDate() throws IOException {
        System.out.println("Enter date in format -> dd-MM-yyyy ");
        LocalDate localDate = LocalDate
                .parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyy"));
        bookService
                .findBookBeforeReleaseDate(localDate)
                .forEach(System.out::println);

    }

    private void notReleasedBooks() throws IOException {
        System.out.println("Enter year: ");
        int year = Integer.parseInt(bufferedReader.readLine());
        bookService
                .findAllBookNotInThisYear(year)
                .forEach(System.out::println);
    }

    private void booksByPrice() {
        bookService
                .findAllBooksTitlesWithPriceLessThan5OrMoreThan40()
                .forEach(System.out::println);
    }

    private void goldenBooks() throws IOException {
        System.out.println("Enter books copies: ");
        int copies = Integer.parseInt(bufferedReader.readLine());
        bookService.
                findTitleWithLessThan5000Copies(copies)
                .forEach(System.out::println);
    }

    private void booksTitlesByAgeRestriction() throws IOException {
        System.out.println("Enter age restriction: ");
        AgeRestriction ageRestriction =
                AgeRestriction.valueOf(bufferedReader.readLine().toUpperCase(Locale.ROOT));

        bookService.
                findAllBooksTitlesWithAgeRestriction(ageRestriction)
                .forEach(System.out::println);


    }

    private void printALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}
