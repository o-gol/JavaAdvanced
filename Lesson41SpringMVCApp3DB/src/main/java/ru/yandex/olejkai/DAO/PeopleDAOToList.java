package ru.yandex.olejkai.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import ru.yandex.olejkai.connections.Connectivity;
import ru.yandex.olejkai.connections.JDBCConnect;
import ru.yandex.olejkai.model.People;

import java.sql.SQLException;
import java.util.List;
@Component
@Qualifier("list")
public class PeopleDAOToList implements PeopleDAO {

    private final List<People> list;
    @Autowired
    public PeopleDAOToList( List<People> list) {
        this.list = list;

    }

    public void addPeople(People people) {
        if (people.getId() == 0 || people.getId() < People.getGlobId()) {

                int id=People.getGlobId()+1;
                People.setGlobId(id);
                people.setId(id);

        }
        list.add(people);
    }




    public  void deletePeople( People people) {
        for (Object people1 :
                list) {
            if (people == people1)
                list.remove(people1);
        }
    }


    public People getPeople(People people) {
        for (Object people1 :
                list) {
            if (people == people1)
                return (People) people1;
        }
        return null;
    }

    public People getPeopleByID( int id) {
        return list.stream().filter(people -> people.getId() == id).findAny().orElse(null);

    }

    public  void deletePeopleByID( int id) {
        list.remove(getPeopleByID( id));

    }

    public  List<People> getAllPeople() {
        List<People> peopleList = list;

        return peopleList;
    }


    public  void updatePeople( People peopleForUpdate, People peopleFromUpdate) {
        getPeopleByID(peopleForUpdate.getId()).setName(peopleFromUpdate.getName());
        getPeopleByID(peopleForUpdate.getId()).setSurName(peopleFromUpdate.getSurName());
        getPeopleByID(peopleForUpdate.getId()).setAge(peopleFromUpdate.getAge());
        getPeopleByID( peopleForUpdate.getId()).setEmail(peopleFromUpdate.getEmail());

    }

    @Override
    public int getMaxId() {
        return 0;
    }


}
