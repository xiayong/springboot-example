package me.xiayong.example.springboot.service.impl;

import me.xiayong.example.springboot.entity.User;
import me.xiayong.example.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

/**
 * @author YongXia.
 * @since 1.0
 */
@Service
public class JPABasedUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;


    private UserDetails buildUserDetails(User user) {
        org.springframework.security.core.userdetails.User userDetails
                = new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, Collections.emptySet());
        return userDetails;
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
