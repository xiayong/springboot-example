package me.xiayong.example.persistence;

import me.xiayong.example.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YongXia.
 * @since 1.0
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}