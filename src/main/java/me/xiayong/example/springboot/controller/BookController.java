package me.xiayong.example.springboot.controller;

import lombok.Getter;
import lombok.Setter;
import me.xiayong.example.springboot.entity.Book;
import me.xiayong.example.springboot.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author YongXia.
 * @since 1.0
 */
@Setter
@Getter
@RestController
@RequestMapping("/api/book")
public class BookController {

    @Autowired
    private BookService bookService;


    @RequestMapping(method = RequestMethod.GET)
    public List<Book> books(Book book) {
        return getBookService().getBooks(book);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Book add(@RequestBody Book book) {
        return getBookService().add(book);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Integer id) {
        getBookService().delete(id);
        return "SUCCESS";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book book(@PathVariable Integer id) {
        return getBookService().getBook(id);
    }
}
