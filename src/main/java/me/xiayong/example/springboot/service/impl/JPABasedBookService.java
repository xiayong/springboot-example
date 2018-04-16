package me.xiayong.example.springboot.service.impl;

import lombok.Getter;
import lombok.Setter;
import me.xiayong.example.springboot.entity.Book;
import me.xiayong.example.springboot.repository.BookRepository;
import me.xiayong.example.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author YongXia.
 * @since 1.0
 */
@Service
public class JPABasedBookService implements BookService {
    @Autowired
    @Getter
    @Setter
    private BookRepository bookRepository;


    @Override
    public List<Book> getBooks(Book book) {
        ExampleMatcher bookExampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("description")
                .withIgnoreCase()
                .withIgnoreNullValues();

        return getBookRepository().findAll(Example.of(book, bookExampleMatcher));
    }

    @Override
    public Book getBook(int id) {
        return getBookRepository().findOne(id);
    }

    @Override
    public Book add(Book book) {
        return getBookRepository().save(book);
    }

    @Override
    public void delete(int id) {
        getBookRepository().delete(id);
    }
}
