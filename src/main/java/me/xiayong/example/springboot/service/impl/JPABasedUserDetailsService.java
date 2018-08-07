package me.xiayong.example.springboot.service.impl;

import me.xiayong.example.springboot.entity.User;
import me.xiayong.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


/**
 * @author YongXia.
 * @since 1.0
 */
@Service
public class JPABasedUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    private UserDetails buildUserDetails(User user) {
        return org.springframework.security.core.userdetails.User
                .withUsername(user.getUsername())
                .password(user.getPassword())
                .disabled(!user.getEnabled())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .roles(StringUtils.hasText(user.getRoles()) ? user.getRoles().split(",") : new String[]{})
                .build();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User " + username + " not exists.");
        }
        return buildUserDetails(user);
    }
}
