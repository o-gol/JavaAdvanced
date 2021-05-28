package ru.yandex.olejkai.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.yandex.olejkai.DAO.PeopleDAO;
import ru.yandex.olejkai.DAO.PeopleDAOHibernate;
import ru.yandex.olejkai.model.People;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class PeopleServicesImpl implements PeopleServices {

    @Autowired
    @Qualifier("hibernate")
//    @Qualifier("jdbcTemplate")
    private PeopleDAO peopleDAO;

    /*@Autowired
    public PeopleServicesHibernate(PeopleDAO peopleDAO) {
        this.peopleDAO = peopleDAO;
    }*/

    @Override
    public void addPeople(People people) {
        peopleDAO.addPeople(people);
    }

    @Override
    public People getPeopleByID(int id) {
        return peopleDAO.getPeopleByID(id);
    }

    @Override
    public void deletePeopleByID(int id) {
        peopleDAO.deletePeopleByID(id);
    }

    @Transactional
    @Override
    public List<People> getAllPeople() {
        return peopleDAO.getAllPeople();
    }

    @Override
    public void updatePeople(People peopleForUpdate, People peopleFromUpdate) {
        peopleDAO.updatePeople(peopleForUpdate,peopleFromUpdate);
    }

    @Override
    public int getMaxId() {
        return peopleDAO.getMaxId();
    }
}
