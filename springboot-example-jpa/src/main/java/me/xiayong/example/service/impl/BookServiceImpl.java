package me.xiayong.example.service.impl;

import lombok.Getter;
import lombok.Setter;
import me.xiayong.example.entity.Book;
import me.xiayong.example.persistence.BookRepository;
import me.xiayong.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author: Yong Xia.
 * @date: Nov-22/2024
 * @since: v1.0
 **/
@Service
public class BookServiceImpl implements BookService {
    @Getter
    @Setter
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getBooks(Book book) {
        ExampleMatcher bookExampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("description")
                .withIgnoreCase()
                .withIgnoreNullValues();

        return getBookRepository().findAll(Example.of(book, bookExampleMatcher));
    }

    @Override
    public Optional<Book> getBook(int id) {
        return getBookRepository().findById(id);
    }

    @Override
    public Book add(Book book) {
        return getBookRepository().save(book);
    }

    @Override
    public void update(Book book) {
        getBookRepository().save(book);
    }

    @Override
    public void delete(int id) {
        getBookRepository().deleteById(id);
    }

    @Override
    public void deleteAll() {
        getBookRepository().deleteAll();
    }

    @Override
    public long countAll() {
        return getBookRepository().count();
    }
}
