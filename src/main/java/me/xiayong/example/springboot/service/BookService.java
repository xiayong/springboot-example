package me.xiayong.example.springboot.service;

import me.xiayong.example.springboot.entity.Book;

import java.util.List;

/**
 * @author YongXia.
 * @since 1.0
 */
public interface BookService {
    List<Book> getBooks(Book book);

    Book getBook(int id);

    Book add(Book book);

    void delete(int id);
}
