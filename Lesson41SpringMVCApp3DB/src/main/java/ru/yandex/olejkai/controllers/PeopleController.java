package ru.yandex.olejkai.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.yandex.olejkai.DAO.PeopleDAO;
import ru.yandex.olejkai.DAO.PeopleDAOToJDBC;
import ru.yandex.olejkai.DAO.PeopleDAOToList;
import ru.yandex.olejkai.connections.Connectivity;
import ru.yandex.olejkai.connections.JDBCConnect;
import ru.yandex.olejkai.model.People;
import ru.yandex.olejkai.utils.CloneBySerializable;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private final List<People> peopleList = new ArrayList();

    {
        peopleList.add(new People("Tim", "Tyrri", 23, "ret5@tut.fd"));
        peopleList.add(new People("Typ", "Dibby", 54, "ser5@ttre.tr"));
        peopleList.add(new People("Jack", "Ruret", 25, "yet@iyttut.mer"));
        peopleList.add(new People("Pick", "Mamy", 23, "34yfhui@tyui.zz"));
    }

    PeopleDAO peopleDAO=new PeopleDAOToList(peopleList);

//    Connectivity connectivity=new JDBCConnect();
//    PeopleDAO peopleDAO=new PeopleDAOToJDBC(connectivity);





    @GetMapping("/{id}")
    public String getPeopleById(
                                @PathVariable("id") int id,
                                Model model
                                ) {

        model.addAttribute("findPersonById", peopleDAO.getPeopleByID( id));
        return "/views/people/show.html";
    }


    @GetMapping("/people-create")
    public String createPeople(
            @RequestParam(value = "name", required = false) String name,
                               @RequestParam(value = "surName", required = false) String surName,
                               @RequestParam(value = "email", required = false) String email,
                               @RequestParam(value = "age", required = false) String age,
            @ModelAttribute("people1") @Valid People people,
            BindingResult bindingResult,
            Model model
    ) {
        if (name != null && surName != null && age != null && email != null) {
            People thisPeople = new People(name, surName,  Integer.parseInt(age),email);
            peopleDAO.addPeople(thisPeople);
            model.addAttribute("status", String.format("%s was adding to list", peopleDAO.getPeople(thisPeople)) );
        }

        if (peopleDAO.getAllPeople().size() != 0)
            model.addAttribute("allPeople", peopleDAO.getAllPeople());
        /*else
//            model.addAttribute("allPeople", "Here not one person");
            model.addAttribute("allPeople", new ArrayList<>());*/

        model.addAttribute("people1",new People());


//        boolean hidden=true;
        model.addAttribute("hidden", true);
        model.addAttribute("hiddenCreate", false);


        System.out.println("---------------------Start");
        for (People peopleInList :
                peopleDAO.getAllPeople()) {

            System.out.println(peopleInList);
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


    @GetMapping("/{id}/update")
    public String toUpdateForm(@PathVariable("id") int id,
                               Model model) {
        model.addAttribute("people1", peopleDAO.getPeopleByID( id));
        model.addAttribute("hidden", false);
        model.addAttribute("hiddenCreate", true);

        model.addAttribute("allPeople", peopleDAO.getAllPeople());
        return "/views/people/people-create.html";
    }

    @PatchMapping("/{id}/update")
    public String updatePeople(@ModelAttribute("people1") @Valid People people,
                               BindingResult bindingResult,
                               @PathVariable("id") int id,
                               Model model) throws IOException, ClassNotFoundException {
        if (bindingResult.hasErrors()) {
            model.addAttribute("hidden", false);
            model.addAttribute("hiddenCreate", true);

            model.addAttribute("status", String.format("%s not updated",people));
            return "/views/people/people-create.html";
        }
        People beforeUpdate = CloneBySerializable.clone(peopleDAO.getPeopleByID( id));
        peopleDAO.updatePeople( peopleDAO.getPeopleByID( id), people);
        if (peopleDAO.getAllPeople().size() != 0)
            model.addAttribute("allPeople", peopleDAO.getAllPeople());
        /*else
            model.addAttribute("allPeople", "Here not one person");*/
        model.addAttribute("hidden", true);
        model.addAttribute("hiddenCreate", false);
        model.addAttribute("people1",new People());
        model.addAttribute("status", String.format("%s was update to %s", beforeUpdate, peopleDAO.getPeopleByID( id)));
        return "/views/people/people-create.html";
    }

    @DeleteMapping("/{id}")
    public String deletePeople(
//            @ModelAttribute("hidden") boolean bool,
//            @ModelAttribute("people1") People people,
            @PathVariable("id") int id
            , Model model
    ) throws IOException, ClassNotFoundException {
        People beforeUpdate = CloneBySerializable.clone(peopleDAO.getPeopleByID( id));
        peopleDAO.deletePeopleByID( id);
        if (peopleDAO.getAllPeople().size() != 0)
            model.addAttribute("allPeople", peopleDAO.getAllPeople());
        /*else
            model.addAttribute("allPeople", new ArrayList<>());*/
        model.addAttribute("hidden", true);
        model.addAttribute("hiddenCreate", false);

        model.addAttribute("people1", new People());
        model.addAttribute("status", String.format("%s was deleted", beforeUpdate));
        return "/views/people/people-create.html";
//                return "redirect:people-create";

    }


    @PostMapping("/people-create")
    public String addPeopleByPost(
            @ModelAttribute("people1") @Valid People people,
                                  BindingResult bindingResult,
                                  Model model) {

        if(bindingResult.hasErrors()){
            if (peopleDAO.getAllPeople().size() != 0)
                model.addAttribute("allPeople", peopleDAO.getAllPeople());
        /*else
            model.addAttribute("allPeople", "Here not one person");*/
            model.addAttribute("hidden", true);
            model.addAttribute("hiddenCreate", false);

            model.addAttribute("status", String.format("%s was not adding to list", peopleDAO.getPeople( people)));

            return "/views/people/people-create.html";
        }

        System.out.println(people);

//        if (people.getName() != "" && people.getSurName() != "" && people.getAge() != 0) {
        peopleDAO.addPeople( people);
        model.addAttribute("status", String.format("%s was adding to list", peopleDAO.getPeople( people)));

//        }
        if (peopleDAO.getAllPeople().size() != 0)
            model.addAttribute("allPeople", peopleDAO.getAllPeople());
        /*else
            model.addAttribute("allPeople", "Here not one person");*/
        model.addAttribute("hidden", true);
        model.addAttribute("hiddenCreate", false);
        model.addAttribute("people1", new People());
        return "/views/people/people-create.html";
//        return "redirect:people-create";
    }

    @ModelAttribute("allPeopleHeader")
    public String showAllPeople() {
        return "All PEOPLE";
    }


}
