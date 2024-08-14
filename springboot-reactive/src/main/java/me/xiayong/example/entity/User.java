package me.xiayong.example.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

/**
 * @author: Yong Xia.
 * @date: Apr-11/2024
 * @since: v1.0
 **/
@Table("users")
@Data
public class User {
    @Id
    private Integer userId;
    private String username;
    private String passwd;
    private String email;
    private String fullName;
    private String phoneNumber;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
