package me.xiayong.example.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
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
    private String comment;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}