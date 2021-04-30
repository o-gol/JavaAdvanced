package ru.yandex.olejkai.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.yandex.olejkai.DAO.PeopleDAO;
import ru.yandex.olejkai.model.People;
import ru.yandex.olejkai.utils.CloneBySerializable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
                               @ModelAttribute("people1") People people,
                               Model model
    ) {
        if (name != null && surName != null && age != null) {
            People thisPeople = new People(name, surName, Integer.parseInt(age));
            PeopleDAO.addPeople(peopleList, thisPeople);
            model.addAttribute("status", String.format("%s was adding to list",PeopleDAO.getPeople(peopleList, thisPeople)) );
        }

        if (PeopleDAO.getAllPeople(peopleList).size() != 0)
            model.addAttribute("allPeople", PeopleDAO.getAllPeople(peopleList));
        else
            model.addAttribute("allPeople", "Here not one person");

//        model.addAttribute("people1",new People());


//        boolean hidden=true;
        model.addAttribute("hidden",true);


        System.out.println("---------------------Start");
        for (People peopleInList :
                peopleList) {

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
                               Model model)
    {
        model.addAttribute("people1", PeopleDAO.getPeopleByID(peopleList, id));
        model.addAttribute("hidden", false);
        model.addAttribute("allPeople",PeopleDAO.getAllPeople(peopleList));
        return "/views/people/people-create.html";
    }

    @PatchMapping("/{id}/update")
    public String updatePeople(@ModelAttribute("people1") People people,
                               @PathVariable("id") int id,
                               Model model) throws IOException, ClassNotFoundException {
        People beforeUpdate=CloneBySerializable.clone( PeopleDAO.getPeopleByID(peopleList,id));
        People peopleToUpdate=PeopleDAO.getPeopleByID(peopleList,id);
        if(people.getName()!=null)
            peopleToUpdate.setName(people.getName());
        if(people.getSurName()!=null)
            peopleToUpdate.setSurName(people.getSurName());
        if(people.getAge()!=0)
            peopleToUpdate.setAge(people.getAge());
        if (PeopleDAO.getAllPeople(peopleList).size() != 0)
            model.addAttribute("allPeople", PeopleDAO.getAllPeople(peopleList));
        else
            model.addAttribute("allPeople", "Here not one person");
        model.addAttribute("hidden", true);
        model.addAttribute("status", String.format("%s was update to %s",beforeUpdate,peopleToUpdate) );
        return "/views/people/people-create.html";
    }


    @DeleteMapping("/{id}/delete")
    public String deletePeopleById(Model model,
                                @PathVariable("id") int id) throws IOException, ClassNotFoundException {
//        People beforeDeleting=CloneBySerializable.clone(PeopleDAO.getPeopleByID(peopleList,id));
        PeopleDAO.deletePeopleByID(peopleList,id);
        /*model.addAttribute("hidden", true);
        model.addAttribute("status", String.format("%s was deleted",beforeDeleting) );
        if (PeopleDAO.getAllPeople(peopleList).size() != 0)
            model.addAttribute("allPeople", PeopleDAO.getAllPeople(peopleList));
        else
            model.addAttribute("allPeople", "Here not one person");*/
        return "/views/people/people-create.html";
//                return "redirect:people-create";

    }







    @PostMapping("/people-create")
    public String addPeopleByPost(@ModelAttribute("people1") People people,
                                  Model model) {
        System.out.println(people);
        boolean flag=people.getName() != "" && people.getSurName() != "" && people.getAge() != 0;

        /*System.out.println(flag);
        System.out.println(people.getId()!=0);
        System.out.println(people.getId());
        System.out.println( people.getName() != null);
        System.out.println( people.getName() );
        System.out.println(people.getSurName() != null);
        System.out.println(people.getSurName());
        System.out.println(people.getAge() != 0);
        System.out.println(people.getAge());*/

        if (people.getName() != "" && people.getSurName() != "" && people.getAge() != 0) {
            PeopleDAO.addPeople(peopleList, people);
            model.addAttribute("status", String.format("%s was adding to list",PeopleDAO.getPeople(peopleList, people)) );

        }
        if (PeopleDAO.getAllPeople(peopleList).size() != 0)
            model.addAttribute("allPeople", PeopleDAO.getAllPeople(peopleList));
        else
            model.addAttribute("allPeople", "Here not one person");
        model.addAttribute("hidden",true);
        return "/views/people/people-create.html";
//        return "redirect:people-create";
    }

    @ModelAttribute("allPeopleHeader")
    public String showAllPeople(){
        return "All PEOPLE";
    }


}
