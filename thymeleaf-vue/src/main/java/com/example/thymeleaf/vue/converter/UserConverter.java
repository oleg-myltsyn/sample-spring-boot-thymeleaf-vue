package com.example.thymeleaf.vue.converter;

import com.example.thymeleaf.vue.dto.UserDTO;
import com.example.thymeleaf.vue.entity.User;

/**
 * @author o.myltsyn * @since 18 дек. 2019 г.
 */
public class UserConverter {

    public static UserDTO toDto(User userEntity){
        return new UserDTO(userEntity.getId(),
                userEntity.getUsername(),
                userEntity.getPassword(),
                userEntity.getEmail());
    }

    public static User toEntity(UserDTO userDTO){
        return new User(userDTO.getId(),
                userDTO.getUsername(),
                userDTO.getPassword(),
                userDTO.getEmail());
    }

}
