package ru.yandex.olejkai.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.yandex.olejkai.DAO.PeopleDAO;
import ru.yandex.olejkai.model.People;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {
    List<People> peopleList=new ArrayList();

    @GetMapping("/people-create")
    public String createPeople(@RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "surName", required = false) String surName,
                               @RequestParam(value = "age", required = false) String age,
                               Model model
                               ){
        if(name!=null||surName!=null||age!=null) {
            People thisPeople = new People(name, surName, Integer.parseInt(age));
            PeopleDAO.addPeople(peopleList, thisPeople);
            model.addAttribute("addingPeople", String.format("Add person is %s \n", PeopleDAO.getPeople(peopleList, thisPeople)));
        }
        System.out.println("---------------------Start");
        for (People people :
                peopleList) {

            System.out.println(people);
        }

        System.out.println("---------------------End");
        return "views/people/people-create.html";
    }


}
