package me.xiayong.example.springboot.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author YongXia.
 * @since 1.0
 */
@Entity
@Table(
        indexes = {
                @Index(name = "uniq_username", columnList = "username", unique = true)
        }
)
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private Boolean enabled;

    @Column(nullable = false)
    private Timestamp createTime;

    private Timestamp updateTime;
}
