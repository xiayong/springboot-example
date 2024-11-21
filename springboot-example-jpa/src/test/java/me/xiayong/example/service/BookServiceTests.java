package me.xiayong.example.service;

import lombok.Getter;
import lombok.Setter;
import me.xiayong.example.entity.Book;
import me.xiayong.example.util.UUIDGenerator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * @author: Yong Xia.
 * @date: Nov-22/2024
 * @since: v1.0
 **/
@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BookServiceTests {
    @Setter
    @Getter
    @Autowired
    private BookService bookService;



    @Test
    public void testGetBooks() {
        Book book = new Book();
        book.setAuthor("Andrew");
        List<Book> books = bookService.getBooks(book);
        Assertions.assertFalse(books.isEmpty());
        Assertions.assertTrue(books.stream().allMatch(b -> "Andrew".equalsIgnoreCase(b.getAuthor())));
    }

    @Test
    @Order(Integer.MIN_VALUE + 1)
    public void testAddBooks() {
        Book book1 = new Book();
        book1.setIsbn(UUIDGenerator.uuid());
        book1.setTitle("Hello");
        book1.setAuthor("Andrew");
        book1.setComment("description.");
        book1.setCreateTime(LocalDateTime.now());
        book1.setUpdateTime(LocalDateTime.now());
        var _book1 = bookService.add(book1);
        Assertions.assertNotNull(_book1);
        Assertions.assertNotNull(_book1.getId());
        Assertions.assertTrue(_book1.getId() > 0);


        Book book2 = new Book();
        book2.setIsbn(UUIDGenerator.uuid());
        book2.setTitle("World");
        book2.setAuthor("Andy");
        book2.setComment("DESCRIPTION.");
        book2.setCreateTime(LocalDateTime.now());
        book2.setUpdateTime(LocalDateTime.now());
        var _book2 = bookService.add(book2);
        Assertions.assertNotNull(_book2);
        Assertions.assertNotNull(_book2.getId());
        Assertions.assertTrue(_book2.getId() > 0);


        Book book3 = new Book();
        book3.setIsbn(UUIDGenerator.uuid());
        book3.setTitle("Hello World");
        book3.setAuthor("Yong Xia");
        book3.setComment("Description.");
        book3.setCreateTime(LocalDateTime.now());
        book3.setUpdateTime(LocalDateTime.now());
        var _book3 = bookService.add(book3);
        Assertions.assertNotNull(_book3);
        Assertions.assertNotNull(_book3.getId());
        userId = _book3.getId();
    }

    private static int userId;

    @Test
    @Order(10)
    public void testUpdateBook() {
        Optional<Book> bookOptional = bookService.getBook(userId);
        Assertions.assertTrue(bookOptional.isPresent());
        Book book = bookOptional.get();
        LocalDateTime now = LocalDateTime.now();
        book.setUpdateTime(now);
        bookService.update(book);
    }

    @Test
    public void testDeleteBook() {
        Book book = new Book();
        book.setAuthor("andy");
        List<Book> books = bookService.getBooks(book);
        Assertions.assertFalse(books.isEmpty());
        Assertions.assertTrue(books.stream().allMatch(b -> "andy".equalsIgnoreCase(b.getAuthor())));
        books.forEach(b -> {
            bookService.delete(b.getId());
        });
    }

    @Test
    @Order(Integer.MIN_VALUE)
    public void testDeleteAllBooks() {
        bookService.deleteAll();
        var l = bookService.countAll();
        Assertions.assertEquals(0, l);
    }
}
