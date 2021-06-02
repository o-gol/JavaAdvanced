package ru.yandex.olejkai.controllers;



import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.yandex.olejkai.DAO.PeopleDAO;
import ru.yandex.olejkai.DAO.PeopleDAOHibernate;
import ru.yandex.olejkai.model.People;
import ru.yandex.olejkai.services.PeopleServices;
import ru.yandex.olejkai.services.PeopleServicesImpl;
import ru.yandex.olejkai.utils.CloneBySerializable;

import javax.validation.Valid;
import java.io.IOException;

@Controller
@RequestMapping("/people")
public class PeopleController {
    private static final Logger LOG=Logger.getLogger(PeopleServices.class);


//    PeopleDAO peopleDAO=new PeopleDAOToList(peopleList);
    boolean choose=true;

//        @Autowired
//        @Qualifier("jdbcTemplate")
//        @Qualifier("jdbc")
    PeopleServices peopleServices;
//        PeopleServicesImpl peopleServices;

        /*@Autowired
        @Qualifier("list")
        PeopleDAO peopleDAO;*/


    /*public PeopleController(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }*/
    @Autowired
    public PeopleController(PeopleServices peopleServices) {
        this.peopleServices = peopleServices;
    }

   /*@Autowired
    public void setPeopleServices(PeopleServicesImpl peopleServices) {
        this.peopleServices = peopleServices;
    }*/

    @GetMapping("/{id}")
    public String getPeopleById(
                                @PathVariable("id") int id,
                                Model model
                                ) {

        model.addAttribute("findPersonById", peopleServices.getPeopleByID( id));
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
            peopleServices.addPeople(thisPeople);
//            model.addAttribute("status", String.format("%s was adding to list", peopleDAO.getPeople(thisPeople)) );
            model.addAttribute("status", String.format("%s was adding to list", peopleServices.getPeopleByID(thisPeople.getId())) );
        }

//        peopleServices.manySave();

        if (peopleServices.getAllPeople().size() != 0)
            model.addAttribute("allPeople", peopleServices.getAllPeople());
        /*else
//            model.addAttribute("allPeople", "Here not one person");
            model.addAttribute("allPeople", new ArrayList<>());*/

        model.addAttribute("people1",new People());


//        boolean hidden=true;
        model.addAttribute("hidden", true);
        model.addAttribute("hiddenCreate", false);


        System.out.println("---------------------Start");
        for (People peopleInList :
                peopleServices.getAllPeople()) {

//            System.out.println(peopleInList);
            LOG.info(peopleInList);
        }
//        System.out.println(peopleServices.getMaxId());
            LOG.info(peopleServices.getMaxId());
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
        model.addAttribute("people1", peopleServices.getPeopleByID( id));
        model.addAttribute("hidden", false);
        model.addAttribute("hiddenCreate", true);

        model.addAttribute("allPeople", peopleServices.getAllPeople());
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
        People beforeUpdate = CloneBySerializable.clone(peopleServices.getPeopleByID( id));
        peopleServices.updatePeople( peopleServices.getPeopleByID( id), people);
        if (peopleServices.getAllPeople().size() != 0)
            model.addAttribute("allPeople", peopleServices.getAllPeople());
        /*else
            model.addAttribute("allPeople", "Here not one person");*/
        model.addAttribute("hidden", true);
        model.addAttribute("hiddenCreate", false);
        model.addAttribute("people1",new People());
        model.addAttribute("status", String.format("%s was update to %s", beforeUpdate, peopleServices.getPeopleByID( id)));
        return "/views/people/people-create.html";
    }

    @DeleteMapping("/{id}")
    public String deletePeople(
//            @ModelAttribute("hidden") boolean bool,
//            @ModelAttribute("people1") People people,
            @PathVariable("id") int id
            , Model model
    ) throws IOException, ClassNotFoundException {
        People beforeUpdate = CloneBySerializable.clone(peopleServices.getPeopleByID( id));
        peopleServices.deletePeopleByID( id);
        if (peopleServices.getAllPeople().size() != 0)
            model.addAttribute("allPeople", peopleServices.getAllPeople());
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
            if (peopleServices.getAllPeople().size() != 0)
                model.addAttribute("allPeople", peopleServices.getAllPeople());
        /*else
            model.addAttribute("allPeople", "Here not one person");*/
            model.addAttribute("hidden", true);
            model.addAttribute("hiddenCreate", false);

            model.addAttribute("status", String.format("%s was not adding to list", peopleServices.getPeopleByID( people.getId())));
//            model.addAttribute("status", String.format("%s was not adding to list", peopleDAO.getPeople( people)));

            return "/views/people/people-create.html";
        }

        System.out.println(people);

//        if (people.getName() != "" && people.getSurName() != "" && people.getAge() != 0) {
        peopleServices.addPeople( people);
        model.addAttribute("status", String.format("%s was adding to list", peopleServices.getPeopleByID( people.getId())));
//        model.addAttribute("status", String.format("%s was adding to list", peopleDAO.getPeople( people)));

//        }
        if (peopleServices.getAllPeople().size() != 0)
            model.addAttribute("allPeople", peopleServices.getAllPeople());
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
