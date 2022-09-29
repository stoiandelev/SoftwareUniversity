package com.example.rest_controllers.service.impl;

import com.example.rest_controllers.model.dto.AuthorDTO;
import com.example.rest_controllers.model.dto.BookDTO;
import com.example.rest_controllers.model.entity.AuthorEntity;
import com.example.rest_controllers.model.entity.BookEntity;
import com.example.rest_controllers.repository.AuthorRepository;
import com.example.rest_controllers.repository.BookRepository;
import com.example.rest_controllers.service.BookService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ModelMapper modelMapper;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, ModelMapper modelMapper, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper;
        this.authorRepository = authorRepository;
    }


    @Override
    public List<BookDTO> getAllBooks() {
        return bookRepository
                .findAll()
                .stream()
                .map(this::asBook)
                .collect(Collectors.toList());

    }

    @Override
    public Optional<BookDTO> findById(Long id) {
        return bookRepository
                .findById(id)
                .map(this::asBook);
    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public long createBook(BookDTO bookDTO) {
        AuthorEntity author = authorRepository
                .findByName(bookDTO.getAuthor().getName())
                .orElseGet(() -> new AuthorEntity().setName(bookDTO.getAuthor().getName()));

        BookEntity newBook = new BookEntity()
                .setAuthors(author)
                .setIsbn(bookDTO.getIsbn())
                .setTitle(bookDTO.getTitle());

        return bookRepository.save(newBook).getId();
    }

    @Override
    public Page<BookDTO> getBooks(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        return bookRepository
                .findAll(pageable)
                .map(this::asBook);

    }

    private BookDTO asBook(BookEntity book) {
        BookDTO bookDTO = modelMapper.map(book, BookDTO.class);
        AuthorDTO authorDTO = modelMapper.map(book.getAuthors(), AuthorDTO.class);
        bookDTO.setAuthor(authorDTO);
        return bookDTO;
    }
}
