package com.example.thymeleaf.vue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author o.myltsyn * @since 19 февр. 2020 г.
 */
@Controller
public class MainController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    private ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping(path = "/login", method = RequestMethod.GET)
    private ModelAndView login(){
        return new ModelAndView("login");
    }

}
