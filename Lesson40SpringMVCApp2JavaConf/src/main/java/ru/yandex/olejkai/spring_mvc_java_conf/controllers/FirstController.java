package ru.yandex.olejkai.spring_mvc_java_conf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(){
        return "views/first/hello";
    }
    /*@GetMapping("/goodbye")
    public String goodbyePage(HttpServletRequest request){
        System.out.println(request.getParameter("age"));
        return "views/first/goodbye";
    }*/


    @GetMapping("/calculator")
    public String calculator(@RequestParam(value = "a", required = false)  float a,
                             @RequestParam(value = "b", required = false) float b,
                             @RequestParam(value = "operation", required = false) String operation,
                             Model model)


    {
        float resalt;
        switch (operation){
            case "multip":
                resalt=a*b;
                break;
            case "add":
                resalt=a+b;
                break;
            case "sud":
                resalt=a-b;
                break;
            case "divis":
                resalt=a/b;
                break;
            default:
                resalt=0;
        }
        System.out.println(resalt);
        model.addAttribute("final",String.format("Result is %s",
                resalt
                ));
        return "views/first/calculator";
    }

    @GetMapping("/goodbye")
    public String goodbyePageWithParam(@RequestParam(value = "age", required = false) String age,
                                       @RequestParam(value = "name", required = false) String name,
                                        Model model){
        String message=String.format("you name is %s, you age is %s",name,age);
        model.addAttribute("message",message);
        System.out.println(message);
        return "views/first/goodbye";
    }

}
