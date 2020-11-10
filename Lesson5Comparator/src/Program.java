import java.util.*;

public class Program {
    public static void main(String[] args) {
        List<String> animals=new ArrayList<>();
        animals.add("dogii");
        animals.add("cat");
        animals.add("frogiiiii");
        animals.add("birdiii");
        System.out.println(animals);
        Collections.sort(animals);
        Collections.sort(animals,(o1,o2)->{
            if (o1.length()>o2.length()){
                return 1;
            }else if(o1.length()<o2.length()){
                return -1;
            }else {
                return 0;
            }
        });
        System.out.println(animals);
//        List<String> animalsLenght=new ArrayList<>();
//        animalsLenght.add(new StringLenghtComparator("doggi").string);
//        animalsLenght.add(new StringLenghtComparator("cat").string);
//        animalsLenght.add(new StringLenghtComparator("frogiii").string);
//        animalsLenght.add(new StringLenghtComparator("bird").string);
//        System.out.println(animalsLenght);
//        Collections.sort(animalsLenght);
//        System.out.println(animalsLenght);
        List<Integer> number=new ArrayList<>();
        number.add(1);
        number.add(4);
        number.add(500);
        number.add(34);
        System.out.println(number);

        Collections.sort(number,(o1,o2)->{
            if (o1<o2){
                return 1;
            }else if(o1>o2){
                return -1;
            }else {
                return 0;
            }
        });
        System.out.println(number);

        ArrayList<Person> people=new ArrayList<>();

//        Map<Integer,String> map=new HashMap<>();


        people.add(new Person(39,"Kira"));
        people.add(new Person(65,"Jack"));
        people.add(new Person(68,"Willy"));
        people.add(new Person(39,"Bob"));
        people.add(new Person(39,"Ann"));

        people.add(new Person(21,"Sunny"));
        people.add(new Person(23,"John"));
        System.out.println(people);

        Collections.sort(people,(o1, o2) ->{

                if (o1.age>o2.age){
                    return 1;
                }else if(o1.age<o2.age){
                    return -1;
                }else {
                    return 0;
                }

        });
        System.out.println(people);
        //Collections.sort(people, Comparator.comparing(o -> o.name));
        Collections.sort(people);
        System.out.println(people);


    }

    public static class Person implements Comparable<Person>{
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

        public Person( int age, String name) {
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

        @Override
        public int compareTo(Person o) {
            return this.name.compareTo(o.name);
        }
    }

    static class StringLenghtComparator implements Comparator<String> {
        String string;

        public StringLenghtComparator(String string) {
            this.string = string;
        }


        @Override
        public int compare(String o1, String o2) {


            if (o1.length()>o2.length()){
                return 1;
            }else if(o1.length()<o2.length()){
                return -1;
            }else {
                return 0;
            }


        }
    }
}
