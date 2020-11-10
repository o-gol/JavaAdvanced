import java.util.LinkedList;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Program {
    public static void main(String[] args) {
        Queue<Person> people=new ArrayBlockingQueue<Person>(10);

        people.add(new Person(39,"Kira"));
        people.add(new Person(65,"Jack"));
        people.add(new Person(68,"Willy"));
        people.add(new Person(39,"Bob"));
        people.add(new Person(39,"Ann"));

        System.out.println(people);
        System.out.println(people.remove());
        System.out.println(people.peek());
        System.out.println(people);
//                  Throws exception	Returns special value
//        Insert	add(e)	                    offer(e)
//        Remove	remove()	                poll()
//        Examine	element()	                peek()

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
}
