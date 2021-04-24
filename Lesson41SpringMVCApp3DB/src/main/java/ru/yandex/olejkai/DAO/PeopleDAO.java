package ru.yandex.olejkai.DAO;

import ru.yandex.olejkai.model.People;

import java.util.List;

public class PeopleDAO {


    public static void addPeople(List list, People people){ list.add(people); }

    public static void deletePeople(List list, People people){
        for (Object people1 :
                list) {
            if (people == (People) people1)
                list.remove(people1);
        } }

    public static People getPeople(List list, People people){
        for (Object people1 :
                list) {
            if (people == (People) people1)
                return (People) people1;
        }
        return null;
    }
}
