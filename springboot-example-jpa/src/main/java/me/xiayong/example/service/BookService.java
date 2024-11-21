package me.xiayong.example.service;

import me.xiayong.example.entity.Book;

import java.util.List;
import java.util.Optional;

/**
 * @author YongXia.
 * @since 1.0
 */
public interface BookService {
    List<Book> getBooks(Book book);

    Optional<Book> getBook(int id);

    Book add(Book book);

    void update(Book book);

    void delete(int id);

    void deleteAll();

    long countAll();
}