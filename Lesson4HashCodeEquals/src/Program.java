import java.util.*;

public class Program {


    public static void main(String[] args) {
        Person person1=new Person("Tom",5);
        Person person2=new Person("Tom",5);
        Person person4=new Person("Nike",7);
        Person person3=new Person("Mike",8);
        String[] names1={"Jack", "Bob", "Sunny", "John", "Sunny", "Vika","Tom","Kira"};
        String[] names2={"Jack", "Oleg", "Sunny", "Igor", "Sunny","Kira","Natasha"};
        Integer[] names3={1,1, 8, 4, 3, 45,5,9};
        Person[] names4={person1,person2};

        Map<Person,Integer> map=new HashMap<>();

        map.put(person1,1);
        map.put(person2,2);
//        map.put(39,"Bob");
//        map.put(39,"Kira");
//        map.put(65,"Jack");
//        map.put(21,"Sunny");
//        map.put(23,"John");
//        map.put(33,"Sunny");
        Set<Object> set=new HashSet<>();
        innerInst(set,names4);
        System.out.println(map);
        System.out.println(set);

    }

    static void innerInst(Set<Object> set, Object[] names) {
        for (Object name :
                names) {
            set.add((Person) name);
        }
    }

    public static class Person{
        private String name;
        private int age;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return age == person.age &&
                    name.equals(person.name);
        }

//        @Override
//        public boolean equals(Object obj) {
//            Person person=(Person)obj;
//            return  (this.name.equals(person.name)&&this.age==person.age);
//       }

        @Override
        public int hashCode() {
            return Objects.hash(name, age);
        }


//        @Override
//        public int hashCode() {
//            return super.hashCode();
//        }

        //        @Override
//        public boolean equals(Person person) {
//            return  (this.name==person.name&&this.age==person.age);
//        }

        @Override
        public String toString() {
            return String.format("Name: %s, Age: %s",this.name,this.age);
        }
    }
}
