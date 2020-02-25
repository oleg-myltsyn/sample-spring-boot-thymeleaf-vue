package com.example.thymeleaf.vue.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author o.myltsyn * @since 18 дек. 2019 г.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Integer id;

    private String username;

    private String password;

    private String email;

}
