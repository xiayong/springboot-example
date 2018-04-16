package me.xiayong.example.springboot.entity;

import javax.persistence.*;

/**
 * @author YongXia.
 * @since 1.0
 */
@Entity
@Table(
        indexes = {
                @Index(name = "uniq_isbn", columnList = "isbn", unique = true),
                @Index(name = "idx_title", columnList = "title")
        }
)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false)
    private String isbn;
    private String title;
    private String author;
    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
