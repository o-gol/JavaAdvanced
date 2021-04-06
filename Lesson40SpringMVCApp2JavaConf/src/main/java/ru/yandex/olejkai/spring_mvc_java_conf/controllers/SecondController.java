package ru.yandex.olejkai.spring_mvc_java_conf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecondController {

    @GetMapping("/exit")
    public String  exit(){
        return "views/first/exit.html";
    }

}
