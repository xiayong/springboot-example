package me.xiayong.example.repository;

import me.xiayong.example.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
    Mono<User> findByUsername(String username);

    Mono<Void> deleteByUsername(String username);
}