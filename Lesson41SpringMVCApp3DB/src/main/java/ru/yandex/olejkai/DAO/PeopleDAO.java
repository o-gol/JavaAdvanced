package ru.yandex.olejkai.DAO;

import ru.yandex.olejkai.model.People;

import java.util.List;

public interface PeopleDAO {
    public void addPeople(People people);
    public void deletePeople(People people);
    public People getPeople(People people);
    public People getPeopleByID( int id);
    public  void deletePeopleByID( int id);
    public List<People> getAllPeople();
    public  void updatePeople( People peopleForUpdate, People peopleFromUpdate);
    public int getMaxId();

}
