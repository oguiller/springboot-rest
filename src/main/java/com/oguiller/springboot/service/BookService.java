package com.oguiller.springboot.service;

import com.oguiller.springboot.domain.Book;

import java.util.Optional;

public interface BookService {
    Iterable<Book> findAll();

    Book create(Book book);

    Optional<Book> find(String isbn);
}