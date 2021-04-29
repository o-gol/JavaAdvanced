package ru.alishev.springcourse.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.alishev.springcourse.dao.PeopleDAO;
import ru.alishev.springcourse.dao.PersonDAO;
import ru.alishev.springcourse.models.People;
import ru.alishev.springcourse.models.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neil Alishev
 */
@Controller
@RequestMapping("/people")
public class PeopleController {

    private final PersonDAO personDAO;
    private List<People> peopleList;
    {
        peopleList = new ArrayList<>();

        peopleList.add(new People( "Tom","KuKu",3));
        peopleList.add(new People( "Bob","Happy",43));
        peopleList.add(new People( "Mike","Jommy",32));
        peopleList.add(new People( "Katy","Kaki",45));
    }

    @Autowired
    public PeopleController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("people",PeopleDAO.getAllPeople(peopleList));
        return "people/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", PeopleDAO.getPeopleByID(peopleList,id));
        return "people/show";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("person") People person) {
        return "people/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("person") People person) {
        System.out.println(person);
        PeopleDAO.addPeople(peopleList,person);
        return "redirect:/people";
    }
}
