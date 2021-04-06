package ru.yandex.olejkai.spring_mvc_java_conf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(){
        return "views/first/hello";
    }
    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "views/first/goodbye";
    }
}
