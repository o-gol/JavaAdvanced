package ru.yandex.olejkai.spring_mvc.spring_mvc_xml_conf;

import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Controller
//@PropertySource(value = "classpath:config/data.properties", encoding = "UTF-8")
//@ResponseBody()
//@RequestMapping(value="/secure/example", headers="accept=text/html", method=RequestMethod.GET)

public class HelloController {

    /*@RequestMapping("/hello_world")
    public ResponseEntity<String> handle() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(new MediaType("text", "plain"));
        return new ResponseEntity<String>("Hello World", responseHeaders, HttpStatus.CREATED);
    }*/


    @GetMapping("/hello_world")
    public String helloWorld(HttpServletResponse response) {
        /*response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");*/
//        return "index.html";
        return "views/hello_world";
    }
    @GetMapping("/index")
    public String helloWorld() {
        /*response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");*/
//        return "index.html";
        return "views/my_view/index";
    }
}

