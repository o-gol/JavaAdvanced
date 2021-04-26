package ru.yandex.olejkai.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.expression.Lists;
import ru.yandex.olejkai.DAO.PeopleDAO;
import ru.yandex.olejkai.model.People;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private List<People> peopleList = new ArrayList();


    @GetMapping("/{id}")
    public String getPeopleById(Model model,
                                @PathVariable("id") int id) {

        model.addAttribute("findPersonById", PeopleDAO.getPeopleByID(peopleList, id));
        return "/views/people/show.html";
    }


    @GetMapping("/people-create")
    public String createPeople(@RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "surName", required = false) String surName,
                               @RequestParam(value = "age", required = false) String age,
                               Model model
    ) {
        if (name != null || surName != null || age != null) {
            People thisPeople = new People(name, surName, Integer.parseInt(age));
            PeopleDAO.addPeople(peopleList, thisPeople);
            model.addAttribute("addingPeople", String.format("Add person is %s \n", PeopleDAO.getPeople(peopleList, thisPeople)));
        }

        if (PeopleDAO.getAllPeople(peopleList).size() != 0)
            model.addAttribute("allPeople", PeopleDAO.getAllPeople(peopleList));
        else
            model.addAttribute("allPeople", "Here not one person");


        System.out.println("---------------------Start");
        for (People people :
                peopleList) {

            System.out.println(people);
        }

        System.out.println("---------------------End");
        return "views/people/people-create.html";
    }


    @PostMapping("/people-create")
    public String addPeopleByPost(@RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "surName", required = false) String surName,
                                  @RequestParam(value = "age", required = false) Integer age) {
        if (name != "" || surName != "" || age != null) {
            PeopleDAO.addPeople(peopleList, new People(name, surName, age));
        }
        return "/views/people/people-create.html";
    }


}
