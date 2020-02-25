package com.example.thymeleaf.vue.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.thymeleaf.vue.converter.UserConverter;
import com.example.thymeleaf.vue.dto.UserDTO;
import com.example.thymeleaf.vue.entity.User;
import com.example.thymeleaf.vue.repository.UserRepository;

/**
 * @author o.myltsyn * @since 18 дек. 2019 г.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    private final Logger log = LoggerFactory.getLogger(UserService.class);

    public List<UserDTO> getAll(){
        if (SecurityContextHolder.getContext().getAuthentication() != null &&
                SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof UserDetails)
            log.info("Method GET ALL USERS used by: " +
                ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername());

        return userRepository.findAll().stream().map(UserConverter::toDto).collect(Collectors.toList());
    }

    public UserDTO getUserById(Integer id){
        return UserConverter.toDto(userRepository.getOne(id));
    }

    public User loadByUsername(String username){
        return userRepository.loadByUsername(username);
    }

    public boolean authorizeUser(String username, String password){
        Optional<User> user = Optional.ofNullable(userRepository.loadByUsername(username));
        return user.isPresent() && passwordEncoder.matches(password, user.get().getPassword());
    }

}
