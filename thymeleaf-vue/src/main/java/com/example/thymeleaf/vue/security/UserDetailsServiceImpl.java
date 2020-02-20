package com.example.thymeleaf.vue.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.thymeleaf.vue.entity.User;
import com.example.thymeleaf.vue.service.UserService;

/**
 * @author o.myltsyn * @since 20 дек. 2019 г.
 */
@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.loadByUsername(username);
        if (user == null) throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));

        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles("USER").build();
    }
}
