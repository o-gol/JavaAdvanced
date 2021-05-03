package ru.yandex.olejkai.DAO;

import ru.yandex.olejkai.model.People;

import java.util.List;

public class PeopleDAO {


    public static void addPeople(List<People> list, People people) {
        if (people.getId() == 0 || people.getId() < People.getGlobId()) {

                int id=People.getGlobId()+1;
                People.setGlobId(id);
                people.setId(id);
                list.add(people);

        } else
            list.add(people);
    }

    public static void deletePeople(List<People> list, People people) {
        for (Object people1 :
                list) {
            if (people == (People) people1)
                list.remove(people1);
        }
    }

    public static People getPeople(List<People> list, People people) {
        for (Object people1 :
                list) {
            if (people == (People) people1)
                return (People) people1;
        }
        return null;
    }

    public static People getPeopleByID(List<People> list, int id) {
        return list.stream().filter(people -> people.getId() == id).findAny().orElse(null);

    }
    public static void deletePeopleByID(List<People> list, int id) {
        list.remove(getPeopleByID(list,id));

    }

    public static List<People> getAllPeople(List list) {
        List<People> peopleList = list;

        return peopleList;
    }

    public static void updatePeople(List<People> list, People peopleForUpdate, People peopleFromUpdate){
        getPeopleByID(list,peopleForUpdate.getId()).setName(peopleFromUpdate.getName());
        getPeopleByID(list,peopleForUpdate.getId()).setSurName(peopleFromUpdate.getSurName());
        getPeopleByID(list,peopleForUpdate.getId()).setAge(peopleFromUpdate.getAge());
        getPeopleByID(list,peopleForUpdate.getId()).setEmail(peopleFromUpdate.getEmail());


    }
}
