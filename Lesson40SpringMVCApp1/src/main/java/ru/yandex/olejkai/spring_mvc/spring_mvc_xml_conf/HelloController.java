package ru.yandex.olejkai.spring_mvc.spring_mvc_xml_conf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;

@Controller
public class HelloController {
    @GetMapping("/hello_world")
    public String helloWorld(){

//        return "index.html";
        return "hello_world";
    }
}
