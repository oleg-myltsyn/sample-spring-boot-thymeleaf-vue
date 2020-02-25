package com.example.thymeleaf.vue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.thymeleaf.vue.dto.Response;
import com.example.thymeleaf.vue.service.UserService;

/**
 * @author o.myltsyn * @since 18 дек. 2019 г.
 */

@RestController
@RequestMapping("api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "user/all"
    )
    public ResponseEntity<Response> getAllUsers() {

        return new ResponseEntity<>(
                Response.builder()
                        .response(userService.getAll())
                        .build(),
                HttpStatus.OK);
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE,
            value = "user/{id}"
    )
    public ResponseEntity<Response> getUserById(@PathVariable("id") Integer id) {

        return new ResponseEntity<>(
                Response.builder()
                        .response(userService.getUserById(id))
                        .build(),
                HttpStatus.OK);
    }

}
