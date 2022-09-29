package com.example.rest_controllers.service;

import com.example.rest_controllers.model.dto.BookDTO;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<BookDTO> getAllBooks();

    Optional<BookDTO> findById(Long id);

    void deleteBook(Long id);

    long createBook(BookDTO bookDTO);

    Page<BookDTO> getBooks(int pageNo, int pageSize, String sortBy);
}
