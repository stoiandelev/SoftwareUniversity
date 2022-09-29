package com.example.rest_controllers.web;

import com.example.rest_controllers.model.dto.BookDTO;
import com.example.rest_controllers.service.BookService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookService bookService;

    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }


    //called on localhost:8080/books
    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> allBooks = bookService.getAllBooks();

        return ResponseEntity.ok(allBooks);
    }

    @GetMapping("/pageable")
    public ResponseEntity<Page<BookDTO>> getBooks(@RequestParam(name = "pageNo", defaultValue = "0") Integer pageNo,
                                                  @RequestParam(name = "pageSize", defaultValue = "3") Integer pageSize,
                                                  @RequestParam(name = "sortBy", defaultValue = "id") String sortBy) {

      return   ResponseEntity.ok(bookService.getBooks(pageNo, pageSize, sortBy));
    }


    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id) {
        Optional<BookDTO> book = bookService.findById(id);

        if (book.isEmpty()) {
            return ResponseEntity
                    .notFound()
                    .build();
        } else {
            return ResponseEntity.ok(book.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookDTO> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<BookDTO> create(
            @RequestBody BookDTO bookDTO,
            UriComponentsBuilder builder) {


        long bookId = bookService.createBook(bookDTO);
        URI location = builder.path("/books/{id}")
                .buildAndExpand(bookId).toUri();

        return ResponseEntity
                .created(location)
                .build();
    }


}
