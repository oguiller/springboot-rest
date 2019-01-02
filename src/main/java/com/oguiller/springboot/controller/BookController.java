package com.oguiller.springboot.controller;


import com.oguiller.springboot.BookNotFoundException;
import com.oguiller.springboot.domain.Book;
import com.oguiller.springboot.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public Iterable<Book> all() {
        return bookService.findAll();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> get(@PathVariable("isbn") String isbn) {
        return bookService.find(isbn)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody Book book,
                                       UriComponentsBuilder uriBuilder) {
        Book created = bookService.create(book);
        URI newBookUri = uriBuilder.path("/books/{isbn}").build(created.getIsbn());
        return ResponseEntity
                .created(newBookUri)
                .body(created);
    }

    @GetMapping("/httpmediaerror")
    public void throwHttpMediaTypeException() throws HttpMediaTypeNotSupportedException {
        throw new HttpMediaTypeNotSupportedException("Dummy HttpMediaTypeNotSupportedException.");
    }

    @GetMapping("/nullpointer")
    public void throwNullPointerException() throws HttpMediaTypeNotSupportedException {
        throw new NullPointerException("Dummy NullPointerException.");
    }

    @GetMapping("/booknotfound")
    public void throwBookNotFound() {
        throw new BookNotFoundException();
    }
}