package com.example.thymeleaf.vue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author o.myltsyn * @since 19 февр. 2020 г.
 */
@Controller
public class IndexController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    private ModelAndView index(){
        return new ModelAndView("index");
    }

    @RequestMapping(path = "/auth", method = RequestMethod.GET)
    private ModelAndView indexAuth(){
        return new ModelAndView("index");
    }

}
