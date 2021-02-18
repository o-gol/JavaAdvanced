package hoFunctions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Program {
    public static void main(String[] args) {
        List<RichPerson> persons = new ArrayList<>();
        persons.add(new RichPerson("Mary", "Black", 32, 95000));
        persons.add(new RichPerson("Jim", "Brown", 41, 75000));
        persons.add(new RichPerson("John", "White", 26, 65000));
        persons.add(new RichPerson("Juli", "Spring", 50, 65000));
        persons.add(new RichPerson("Ann", "Grow", 37, 50000));
        persons.add(new RichPerson("Dry", "Mine", 40, 100000));
        persons.add(new RichPerson("Fill", "Filrod", 29, 100000));

        testPredicate(persons);
        testFunction(persons);
        testConsumer(persons);
//        persons.forEach(System.out::println);
    }

    private static void testPredicate(List<RichPerson> persons) {
        System.out.println("---------------------------Predicate Testing");
        System.out.println("---------------------------Is rich and young");
        Predicate<RichPerson> richest = richPerson -> richPerson.salary >= 75000;
        Predicate<RichPerson> young = richPerson -> richPerson.age <= 32;
        System.out.println(addAll(persons, richest.and(young)));
        System.out.println("---------------------------Is rich or young");
        System.out.println(addAll(persons, richest.or(young)));
        System.out.println("---------------------------Not rich");
        System.out.println(addAll(persons, richest.negate()));


    }

    private static <T> List<T> addAll(List<T> list, Predicate<T> predicate) {
        List<T> fixedList = new ArrayList<>();
        for (T element :
                list) {
            if (predicate.test(element))
                fixedList.add(element);
        }
        return fixedList;
    }


    private static void testFunction(List<RichPerson> persons) {
        System.out.println("---------------------------Function Testing");
        Function<List<RichPerson>, List<RichPerson>> functionOld = richPerson -> {
            List<RichPerson> list = new ArrayList<>();
            for (RichPerson element :
                    richPerson) {
                if (element.age >= 40)
                    list.add(element);
            }
            return list;
        };
        Function<List<RichPerson>, List<RichPerson>> nameAndSername = list -> {
            for (RichPerson element :
                    list) {
                element.setName(element.name + " " + element.surname);
            }
            return list;
        };
        Function<List<RichPerson>, List<RichPerson>> nameToUpperCase = list -> {
            for (RichPerson element :
                    list) {
                element.setName(element.name.toUpperCase());
            }
            return list;
        };

        System.out.println("---------------------------Add salary to Old");
        List<RichPerson> oldAddMany = transform(persons, functionOld.andThen(richPerson -> {
            for (RichPerson element :
                    richPerson) {

                element.setSalary(element.salary + 20000);
            }
            return richPerson;
        }));
        System.out.println(oldAddMany);
        System.out.println("---------------------------Name and sername toUpperCase");
        List<RichPerson> nameAndSerToUp = transform(oldAddMany, compose(nameAndSername, nameToUpperCase));
        System.out.println(nameAndSerToUp);
    }

    private static <T extends List> T transform(T list, Function<T, T> function) {

        /*List<T> tList=new ArrayList<>();
        for (T element :
                list) {
            tList.add(function.apply(element));
        }
        return tList;*/
        return function.apply(list);
    }

    private static <T> Function<T, T> compose(Function<T, T>... functions) {
        Function<T, T> function = Function.identity();
        for (Function<T, T> element :
                functions) {
            function = function.andThen(element);
        }
        return function;

    }

    private static void testConsumer(List<RichPerson> persons) {
        System.out.println("---------------------------Cosumer Testing");
        Consumer<RichPerson> consumer=(x)->x.setSalary(x.getSalary()+66);
        processList(persons,consumer.andThen(System.out::println));

    }
    private static <T> void processList(List<T> elements,Consumer<T> consumer){
        for (T element:
             elements) {
            consumer.accept(element);
        }

    }

}
