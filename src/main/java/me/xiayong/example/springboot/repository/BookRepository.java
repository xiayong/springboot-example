package me.xiayong.example.springboot.repository;


import me.xiayong.example.springboot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author YongXia.
 * @since 1.0
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
