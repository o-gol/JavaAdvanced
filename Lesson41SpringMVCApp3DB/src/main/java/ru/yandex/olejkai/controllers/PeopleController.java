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
            model.addAttribute("addingPeople", PeopleDAO.getPeople(peopleList, thisPeople));
        }

        if (PeopleDAO.getAllPeople(peopleList).size() != 0)
            model.addAttribute("allPeople", PeopleDAO.getAllPeople(peopleList));
        else
            model.addAttribute("allPeople", "Here not one person");

        model.addAttribute("people1",new People());


        System.out.println("---------------------Start");
        for (People people :
                peopleList) {

            System.out.println(people);
        }

        System.out.println("---------------------End");
        return "views/people/people-create.html";
    }


    /*@PostMapping("/people-create")
    public String addPeopleByPost(@RequestParam(value = "name", required = false) String name,
                                  @RequestParam(value = "surName", required = false) String surName,
                                  @RequestParam(value = "age", required = false) Integer age,
                                  Model model) {
        if (name != "" || surName != "" || age != null) {
            People people=new People(name, surName, age);
            PeopleDAO.addPeople(peopleList, people);
            model.addAttribute("addingPeople",PeopleDAO.getPeople(peopleList,people));
        }
        if (PeopleDAO.getAllPeople(peopleList).size() != 0)
            model.addAttribute("allPeople", PeopleDAO.getAllPeople(peopleList));
        else
            model.addAttribute("allPeople", "Here not one person");
        return "/views/people/people-create.html";
    }*/

    @PostMapping("/people-create")
    public String addPeopleByPost(@ModelAttribute("people1") People people,
                                  Model model) {
        boolean flag=people.getId()!=0 || people.getName() != null || people.getSurName() != null || people.getAge() != 0;
        System.out.println(flag);
        System.out.println(people.getId()!=0);
        System.out.println(people.getId());
        System.out.println( people.getName() != null);
        System.out.println( people.getName() );
        System.out.println(people.getSurName() != null);
        System.out.println(people.getSurName());
        System.out.println(people.getAge() != 0);
        System.out.println(people.getAge());
        if (people.getId()!=0 || people.getName() != null || people.getSurName() != null || people.getAge() != 0) {
            PeopleDAO.addPeople(peopleList, people);
            model.addAttribute("addingPeople", PeopleDAO.getPeople(peopleList, people));
        }
        if (PeopleDAO.getAllPeople(peopleList).size() != 0)
            model.addAttribute("allPeople", PeopleDAO.getAllPeople(peopleList));
        else
            model.addAttribute("allPeople", "Here not one person");
        return "/views/people/people-create.html";
        //return "redirect:people-create";
    }

    @ModelAttribute("allPeopleHeader")
    public String showAllPeople(){
        return "All PEOPLE";
    }


}
